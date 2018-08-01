import javax.swing.*;
import java.util.ArrayList;


public class Windows extends JPanel{

    protected final ArrayList<AirbnbListing> database;

    public Windows()
    {
        AirbnbDataLoader dl = new AirbnbDataLoader();
        database = dl.load();


    }

}