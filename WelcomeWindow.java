import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


/**
 * Write a description of class WelcomeWindow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WelcomeWindow extends Windows {
    private String[] fromPrices, toPrices;
    public static int upperPrice, lowerPrice;


    /**
     * Constructor for objects of class WelcomeWindow
     */
    public WelcomeWindow() {
        // initialise instance variables
        makeWindow();

    }


    public void makeWindow() {
        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel(new GridLayout(1, 4, 0, 0));
        JPanel northButtonPanel = new JPanel(new BorderLayout());
        JPanel fromPanel = new JPanel();
        JPanel toPanel = new JPanel();
        JPanel southPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
        northPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        southPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
        northPanel.setPreferredSize(new Dimension(1200, 30));
        southPanel.setPreferredSize(new Dimension(1200, 30));
        northButtonPanel.setPreferredSize(new Dimension(50, 30));
        priceButtons();
        JComboBox from = new JComboBox(fromPrices);
        JComboBox to = new JComboBox(toPrices);
        JButton previous = new JButton("<");
        JButton next = new JButton(">");
        previous.setEnabled(false);
        next.setEnabled(false);
        JButton search = new JButton("Search");
        centerPanel.add(search);
        search.addActionListener(e_ -> displayImage() );
        from.addActionListener(e -> {validRange(from, to, previous, next);lowerPrice = Integer.parseInt(from.getSelectedItem().toString()); });
        to.addActionListener(e_ -> {validRange(from, to, previous, next); upperPrice = Integer.parseInt(to.getSelectedItem().toString()); });
        fromPanel.add(new JLabel("From : "));
        fromPanel.add(from);
        toPanel.add(new JLabel("To : "));
        toPanel.add(to);
        northButtonPanel.add(fromPanel, BorderLayout.CENTER);
        northButtonPanel.add(toPanel, BorderLayout.EAST);
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(northButtonPanel);
        southPanel.add(previous, BorderLayout.WEST);
        southPanel.add(next, BorderLayout.EAST);

    }


    public void priceButtons() {
        fromPrices = new String[141];
        toPrices = new String[141];
        int price = 0;
        for (int i = 0; i < 141; i++) {
            fromPrices[i] = "" + price;
            toPrices[i] = "" + price;
            price += 50;
        }
    }


    public void validRange(JComboBox a, JComboBox b, JButton c, JButton d) {
        if (Integer.parseInt(a.getSelectedItem().toString()) > Integer.parseInt(b.getSelectedItem().toString())) {
            c.setEnabled(false);
            d.setEnabled(false);
            JOptionPane.showMessageDialog(GUI.mainFrame, "Please select a valid price range", "Warning", JOptionPane.WARNING_MESSAGE);


        } else {
            c.setEnabled(true);
            d.setEnabled(true);

        }
    }

    public void displayImage() {
        MapWindow m = new MapWindow();
        GUI.mw = m;
        GUI.mainFrame.remove(GUI.ww);
        GUI.mainFrame.add(GUI.mw);
        GUI.mainFrame.revalidate();
        GUI.mainFrame.repaint();






    }
}



