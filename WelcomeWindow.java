import java.awt.*;
import javax.swing.*;

/*
 * This class stands for the second window that the user sees , called welcome window. On this window, the user chooses a price range.
 * By pressing a button the user will be brought to the map window , displaying a map of London showing the properties matching the selected price range.
 */
public class WelcomeWindow extends Windows {
    private String[] fromPrices, toPrices;
    public static int upperPrice, lowerPrice; // Variables that store the upper and lower prices chosen by the customer.
    private JComboBox from,to;


    /*
     * Builds the welcome window.
     */
    public WelcomeWindow() {

        makeWelcomeWindow();
    }


    private void makeWelcomeWindow() {
        setLayout(new BorderLayout());

        // Creates all the panels.
        JPanel northPanel = new JPanel(new GridLayout(1, 4, 0, 0));
        JPanel northButtonPanel = new JPanel(new BorderLayout());
        JPanel fromPanel = new JPanel(); // this panel holds the JComboBox called from that allows the user to choose a lower price.
        JPanel toPanel = new JPanel(); // this panel holds the JComboBox called from that allows the user to choose a upper price.
        JPanel southPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel();

        // Sets the borders and the sizes of the panels.
        northPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        southPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
        northPanel.setPreferredSize(new Dimension(1200, 30));
        southPanel.setPreferredSize(new Dimension(1200, 30));
        northButtonPanel.setPreferredSize(new Dimension(50, 30));

        priceButtons(); // loads the arrays of prices to be shown into the JComboBoxes when the user wants to select a price range.
        from = new JComboBox(fromPrices);
        to = new JComboBox(toPrices);
        JButton previous = new JButton("<"); // if pressed , the user goes back to the account window.
        JButton next = new JButton(">");
        previous.addActionListener(e-> goToAccountWindow());
        next.setEnabled(false);
        next.addActionListener(e-> displayImage()); // this button is enabled only if the user selects a valid price range and when pressed it brings the user to the map window.

        // On those two JComboBoxes , whenever a price is selected , the price range is checked to be valid. If it is, the selected prices are assigned to the lower price and upper price variables.
        from.addActionListener(e -> validRange(from, to, next));
        to.addActionListener(e_ -> validRange(from, to, next));


        // Adds the components to the panels.
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

        // Adds all the panels to the window.
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

    }



    //Computes all the prices choosable by the user , displayed into the JComboBoxes. There is a gap of 50 between each price.
    private void priceButtons() {
        fromPrices = new String[141]; // array storing the prices for the "from" JComboBox.
        toPrices = new String[141]; // array storing the prices for the "to" JComboBox.
        int price = 0;
        for (int i = 0; i < 141; i++) {
            fromPrices[i] = "" + price;
            toPrices[i] = "" + price;
            price += 50;
        }
    }

    // Checks if the price range selected by the user is valid. If it is not the inputted button is disabled.
    private void validRange(JComboBox a, JComboBox b, JButton c) {
        if (Integer.parseInt(a.getSelectedItem().toString()) > Integer.parseInt(b.getSelectedItem().toString())) {
            c.setEnabled(false);
            JOptionPane.showMessageDialog(GUI.mainFrame, "Please select a valid price range", "Warning", JOptionPane.WARNING_MESSAGE);


        } else {
            c.setEnabled(true);
            lowerPrice = Integer.parseInt(from.getSelectedItem().toString());
            upperPrice = Integer.parseInt(to.getSelectedItem().toString());

        }
    }

    // Displays the map of London showing the properties matching the price range selected by the customer.
    private void displayImage() {
        GUI.mw = new MapWindow();
        GUI.mainFrame.remove(GUI.ww);
        GUI.mainFrame.add(GUI.mw);
        GUI.mainFrame.revalidate();
        GUI.mainFrame.repaint();

    }

    // Goes back to the account window.
    private void goToAccountWindow()
    {
        GUI.mainFrame.remove(GUI.ww);
        GUI.mainFrame.add(GUI.aw);
        GUI.mainFrame.setPreferredSize(new Dimension(750,400));
        GUI.mainFrame.pack();
    }
}



