import javax.swing.*;

public class MapWindow extends Windows{

    public MapWindow()
    {
      displayMap();
    }

    public void displayMap()
    {

        ImageIcon image = new ImageIcon("london-borough-map.jpg");
        JLabel imageLabel = new JLabel(image);
        add(imageLabel);

    }

}
