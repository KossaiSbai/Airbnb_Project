import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MapWindow extends Windows {

    public MapWindow() {
        displayMap();
    }

    public void displayMap()

    {
        JPanel mapPanel = new JPanel();
        ImageIcon image = new ImageIcon("london-borough-map.jpg");
        JLabel imageLabel = new JLabel(image);
        mapPanel.add(imageLabel);
        add(mapPanel);
        map(0,100);

    }


    public void map(int fromPrice, int toPrice)
    {
        JFrame f = new JFrame();
        JPanel c = new JPanel();
        for(String borough : BOROUGHS)
        {
            JButton b = new JButton("b");
            ArrayList<String> l = listOfProperties(borough,fromPrice,toPrice );
            b.addActionListener(e->displayProperties(l));
            c.add(b);
        }
        f.getContentPane().add(c);
        f.setVisible(true);
        f.pack();
    }


    public int numberOfProperties(String borough, int fromPrice, int toPrice) {
        int counter = 0;
        for (AirbnbListing property : database) {
            int price = property.getPrice();
            String b = property.getNeighbourhood();

            if ((b.equals(borough)) && (price <= toPrice) && (price >= fromPrice)) {
                counter++;

            }
        }
        return counter;

    }

    public ArrayList<String> listOfProperties(String borough, int fromPrice, int toPrice)
    {
        ArrayList<String> matchingProperties = new ArrayList<>();
        for(AirbnbListing p : database)
        {
            int price = p.getPrice();
            String b = p.getNeighbourhood();

            if ((b.equals(borough)) && (price <= toPrice) && (price >= fromPrice))
            {
             matchingProperties.add(p.getHost_id());

            }
        }
        return matchingProperties;
    }

    public void displayProperties(ArrayList<String> properties)
    {
     JFrame frame = new JFrame();
     JPanel panel = new JPanel(new GridLayout(properties.size(),1,0,10));
     for (String l : properties)
     {
      JLabel label = new JLabel("ID " + l);
      panel.add(label);
     }
     JScrollPane sp = new JScrollPane(panel);
     frame.getContentPane().add(sp);
     frame.setVisible(true);
     frame.pack();
    }

}


