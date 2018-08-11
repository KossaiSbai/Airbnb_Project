
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;


public class MapWindow extends Windows {
    JPanel mapPanel;
    JLabel mapLabel;
    HashMap<String, ArrayList<Integer>> boroughsCoordinates;

    public MapWindow() {
        boroughsCoordinates = new HashMap<>();
        displayMap();
    }

    public void displayMap()

    {
        JPanel mapPanel = new JPanel();
        this.mapPanel = mapPanel;
        try {
            BufferedImage bimg = ImageIO.read(new File("london-borough-map.jpg"));
            ImageIcon image = new ImageIcon();
            image.setImage(bimg);
            JLabel imageLabel = new JLabel(image);
            mapLabel = imageLabel;
            mapPanel.add(mapLabel);
            add(mapPanel);
        } catch (IOException exc) {
            return;
        }


        coordinates();
        map(WelcomeWindow.lowerPrice, WelcomeWindow.upperPrice);
    }


    public void map(int fromPrice, int toPrice) {


        for (String borough : BOROUGHS) {
            int numberOfProperties = numberOfProperties(borough, fromPrice, toPrice);
            int width;
            int height;
            String url;

            if (numberOfProperties < 500) {
                width = height = 20;
                url = "houseicon3.png";
            } else if (numberOfProperties >= 500 && numberOfProperties < 3000) {
                width = height = 30;
                url = "houseicon2.png";
            } else {
                width = height = 50;
                url = "houseicon.png";
            }

            ImageIcon ic = new ImageIcon(url);
            JButton b = new JButton();
            b.setIcon(ic);
            b.addActionListener(e-> new PropertiesWindow(borough));
            b.setBounds(boroughsCoordinates.get(borough).get(0), boroughsCoordinates.get(borough).get(1), width, height);
            mapLabel.add(b);
            mapPanel.add(mapLabel);
        }

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


    public void coordinates() {

        boroughsCoordinates.put(BOROUGHS[0], new ArrayList(Arrays.asList(282, 651)));
        boroughsCoordinates.put(BOROUGHS[1], new ArrayList(Arrays.asList(507, 725)));
        boroughsCoordinates.put(BOROUGHS[2], new ArrayList(Arrays.asList(708, 710)));
        boroughsCoordinates.put(BOROUGHS[3], new ArrayList(Arrays.asList(150, 497)));
        boroughsCoordinates.put(BOROUGHS[4], new ArrayList(Arrays.asList(222, 313)));
        boroughsCoordinates.put(BOROUGHS[5], new ArrayList(Arrays.asList(872, 178)));
        boroughsCoordinates.put(BOROUGHS[6], new ArrayList(Arrays.asList(106, 424)));
        boroughsCoordinates.put(BOROUGHS[7], new ArrayList(Arrays.asList(245, 161)));
        boroughsCoordinates.put(BOROUGHS[8], new ArrayList(Arrays.asList(361, 291)));
        boroughsCoordinates.put(BOROUGHS[9], new ArrayList(Arrays.asList(371, 116)));
        boroughsCoordinates.put(BOROUGHS[10], new ArrayList(Arrays.asList(509, 55)));
        boroughsCoordinates.put(BOROUGHS[11], new ArrayList(Arrays.asList(620, 148)));
        boroughsCoordinates.put(BOROUGHS[12], new ArrayList(Arrays.asList(768, 189)));
        boroughsCoordinates.put(BOROUGHS[13], new ArrayList(Arrays.asList(473, 612)));
        boroughsCoordinates.put(BOROUGHS[14], new ArrayList(Arrays.asList(509, 55)));
        boroughsCoordinates.put(BOROUGHS[15], new ArrayList(Arrays.asList(503, 505)));
        boroughsCoordinates.put(BOROUGHS[16], new ArrayList(Arrays.asList(549, 457)));
        boroughsCoordinates.put(BOROUGHS[17], new ArrayList(Arrays.asList(630, 526)));
        boroughsCoordinates.put(BOROUGHS[18], new ArrayList(Arrays.asList(706, 478)));
        boroughsCoordinates.put(BOROUGHS[19], new ArrayList(Arrays.asList(772, 509)));
        boroughsCoordinates.put(BOROUGHS[20], new ArrayList(Arrays.asList(237, 543)));
        boroughsCoordinates.put(BOROUGHS[21], new ArrayList(Arrays.asList(462, 566)));
        boroughsCoordinates.put(BOROUGHS[22], new ArrayList(Arrays.asList(451, 508)));
        boroughsCoordinates.put(BOROUGHS[23], new ArrayList(Arrays.asList(387, 426)));
        boroughsCoordinates.put(BOROUGHS[24], new ArrayList(Arrays.asList(384, 348)));
        boroughsCoordinates.put(BOROUGHS[25], new ArrayList(Arrays.asList(524, 355)));
        boroughsCoordinates.put(BOROUGHS[26], new ArrayList(Arrays.asList(414, 337)));
        boroughsCoordinates.put(BOROUGHS[27], new ArrayList(Arrays.asList(472, 323)));
        boroughsCoordinates.put(BOROUGHS[28], new ArrayList(Arrays.asList(612, 380)));
        boroughsCoordinates.put(BOROUGHS[29], new ArrayList(Arrays.asList(0, 0)));
        boroughsCoordinates.put(BOROUGHS[30], new ArrayList(Arrays.asList(0, 0)));
        boroughsCoordinates.put(BOROUGHS[31], new ArrayList(Arrays.asList(0, 0)));
        boroughsCoordinates.put(BOROUGHS[32], new ArrayList(Arrays.asList(0, 0)));


    }
}


