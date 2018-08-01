import java.awt.*;
import javax.swing.*;


/**
 * Write a description of class WelcomeWindow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WelcomeWindow extends Windows
{
    private String[] fromPrices,toPrices;



    /**
     * Constructor for objects of class WelcomeWindow
     */
    public WelcomeWindow()
    {
        // initialise instance variables
        makeWindow();

    }


    public void makeWindow()
    {
        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel(new GridLayout(1,4,0,0));
        JPanel northButtonPanel = new JPanel(new BorderLayout());
        JPanel fromPanel = new JPanel();
        JPanel toPanel = new JPanel();
        JPanel southPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel();
        add(northPanel,BorderLayout.NORTH);
        add(southPanel,BorderLayout.SOUTH);
        add(centerPanel,BorderLayout.CENTER);
        northPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        southPanel.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.black));
        northPanel.setPreferredSize(new Dimension(1200,30));
        southPanel.setPreferredSize(new Dimension(1200,25));
        northButtonPanel.setPreferredSize(new Dimension(50,30));
        priceButtons();
        JComboBox from = new JComboBox(fromPrices);
        JComboBox to = new JComboBox(toPrices);
        from.addActionListener(e-> System.out.println(getItem(from)));
        JButton previous = new JButton("<");
        JButton next = new JButton(">");
        JButton search = new JButton("Search");
        centerPanel.add(search);
        search.addActionListener(e_-> {JFrame f = new JFrame(); f.setVisible(true); f.pack();} );
        fromPanel.add(new JLabel("From : "));
        fromPanel.add(from);
        toPanel.add(new JLabel("To : "));
        toPanel.add(to);
        northButtonPanel.add(fromPanel,BorderLayout.CENTER);
        northButtonPanel.add(toPanel,BorderLayout.EAST);
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(northButtonPanel);
        southPanel.add(previous,BorderLayout.WEST);
        southPanel.add(next, BorderLayout.EAST);
        System.out.println(maxPrice());
    }



    public void priceButtons()
    {
        fromPrices = new String[141];
        toPrices = new String[141];
        int price = 0;
        for(int i=0; i<141; i++)
        {
            fromPrices[i]=""+price;
            toPrices[i]=""+ price;
            price+=50;
        }
    }

    public int maxPrice()
    {
        int maxPrice = 0;
        for(AirbnbListing l : database)
        {
            if(l.getPrice()>maxPrice)
            {
                maxPrice = l.getPrice();
            }
        }
        return maxPrice;
    }

    public String getItem(JComboBox b)
    {
        return b.getSelectedItem().toString();
    }




}