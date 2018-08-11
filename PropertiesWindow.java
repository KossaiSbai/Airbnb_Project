import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class PropertiesWindow extends Windows{


    public PropertiesWindow(String borough)
    {
        ArrayList<String> propertiesToDisplay = listOfProperties(borough,WelcomeWindow.lowerPrice,WelcomeWindow.upperPrice);
        displayProperties(propertiesToDisplay);
    }

    public ArrayList<String> listOfProperties(String borough, int fromPrice, int toPrice) {
        ArrayList<String> matchingProperties = new ArrayList<>();
        int propertyNumber = 0;
        for (AirbnbListing p : database) {
            int price = p.getPrice();
            String neighbourhood= p.getNeighbourhood();
            int reviews = p.getNumberOfReviews();
            int nights = p.getMinimumNights();
            String host = p.getHost_name();
            propertyNumber++;

            if ((neighbourhood.equals(borough)) && (price <= toPrice) && (price >= fromPrice)) {
                matchingProperties.add("Property " + propertyNumber + ":    " + "Host Name : " + host + "   " + "Price : " + price + "   " + "Number of reviews : " + reviews + "   " + "Minimum number of nights : " + nights);

            }
        }
        return matchingProperties;
    }

    public void displayProperties(ArrayList<String> properties) {
        JFrame propertiesFrame = new JFrame();
        propertiesFrame.setPreferredSize(new Dimension(1200,800));
        JPanel propertiesPanel = new JPanel(new GridLayout(properties.size(), 1, 0, 10));
        for (String l : properties) {
            JLabel label = new JLabel(l);
            propertiesPanel.add(label);
        }
        JScrollPane sp = new JScrollPane(propertiesPanel);
        propertiesFrame.getContentPane().add(sp);
        propertiesFrame.setVisible(true);
        propertiesFrame.pack();
    }

}
