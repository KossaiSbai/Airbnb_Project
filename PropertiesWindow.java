import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.*;


public class PropertiesWindow extends Windows{
    private ArrayList<AirbnbListing> matchingProperties;
    private JComboBox sort;
    private String borough;

    public PropertiesWindow(String borough)
    {
        this.borough = borough;
        listOfProperties(WelcomeWindow.lowerPrice,WelcomeWindow.upperPrice);
        displayProperties();
    }

    public void listOfProperties( int fromPrice, int toPrice) {
         matchingProperties = new ArrayList<>();

        for (AirbnbListing p : database) {
            int price = p.getPrice();
            String neighbourhood= p.getNeighbourhood();

            if ((neighbourhood.equals(borough)) && (price <= toPrice) && (price >= fromPrice)) {

                matchingProperties.add(p);
            }

        }

    }

    public void displayProperties() {
        JFrame propertiesFrame = new JFrame(borough);
        String[] sortingWays = {"Sort by" ,"Host name", "Number of reviews", "Price"};
        sort = new JComboBox(sortingWays);
        sort.addActionListener(e-> {sortByHostName(); sortByNumberOfReviews(); sortByPrice(); });
        propertiesFrame.setPreferredSize(new Dimension(1200,800));
        JPanel propertiesPanel = new JPanel(new GridLayout(matchingProperties.size()+1, 1, 0, 10));
        propertiesPanel.add(sort);
        int propertyNumber = 1;
        for (AirbnbListing p : matchingProperties) {
            int price = p.getPrice();
            int reviews = p.getNumberOfReviews();
            int nights = p.getMinimumNights();
            String host = p.getHost_name();
            JLabel label = new JLabel("Property " + propertyNumber + ":    " + "Host Name : " + host + "   " + "Price : " + price + "   " + "Number of reviews : " + reviews + "   " + "Minimum number of nights : " + nights);
            label.addMouseListener(
                    new MouseAdapter()
                    {
            public void mousePressed(MouseEvent mouseEvent)
            {
               JFrame descriptionFrame = new JFrame();
               descriptionFrame.getContentPane().add(new JLabel(p.getName()));
               descriptionFrame.setVisible(true);
               descriptionFrame.pack();

            }
            });
            propertiesPanel.add(label);
            propertyNumber++;
        }
        JScrollPane sp = new JScrollPane(propertiesPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        propertiesFrame.getContentPane().add(sp);
        propertiesFrame.setVisible(true);
        propertiesFrame.pack();
    }

    public void sortByHostName()
    {
        if(sort.getSelectedItem().equals("Host name")) {
            matchingProperties.sort(Comparator.comparing(AirbnbListing::getHost_name));
            displayProperties();
        }
    }

    public void sortByNumberOfReviews()
    {
        if(sort.getSelectedItem().equals("Number of reviews")) {
            matchingProperties.sort(Comparator.comparing(AirbnbListing::getNumberOfReviews));
            displayProperties();

        }
    }

    public void sortByPrice()
    {
        if(sort.getSelectedItem().equals("Price")) {
            matchingProperties.sort(Comparator.comparing(AirbnbListing::getPrice));
            displayProperties();

        }
    }




}
