import javax.swing.*;
import java.util.ArrayList;


public class Windows extends JPanel{

    protected final ArrayList<AirbnbListing> database;
    protected static final String[] BOROUGHS  = {"Kingston upon Thames","Croydon","Bronley","Hounslow","Ealing","Havering",
            "Hillingdon","Harrow","Brent","Barnet", "Enfield", "Waltham Forest", "Redbridge", "Sutton", "Lambeth", "Southwark",
            "Lewisham", "Greenwich", "Bexley", "Richmond upon Thames", "Merton", "Wandsworth","Hammersmith and Fulham",
            "Kensington and Chelsea","City of London","Westminster","Camden","Tower Hamlets", "Islington", "Hackney","Haringey",
            "Newham","Barking and Dagenham"};

    public Windows()
    {
        AirbnbDataLoader dl = new AirbnbDataLoader();
        database = dl.load();


    }

}