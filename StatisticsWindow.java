import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class StatisticsWindow extends Windows {

    ArrayList<String> statistics ;
    JPanel statisticsPanel;
    int currentStat;
    JLabel stat;
    public StatisticsWindow()
    {
        buildStatistics();
        currentStat = 0;
        makeStatisticsFrame();


    }

    public int averageNumberOfReviewsPerProperty()
    {
        int total = 0;

        for(AirbnbListing property : database)
        {
            total+=property.getNumberOfReviews();
        }
        return total/database.size();
    }

    public int numberOfAvailableProperties()
    {
        int total =0;
        for(AirbnbListing property  : database)
        {
            if(property.getAvailability365()>0) {
                total ++;

            }
        }
        return total;
    }

    public int numberOfEntireHApts()
    {
        int total=0;
        for(AirbnbListing property: database)
        {
            if(property.getRoom_type().equals("Entire home/apt"))
            {
                total+=1;
            }
        }
        return total;
    }

    public String getPriciestNeighborhood() // neighborhood with the most expensive property.
    {
        int maxPrice =0;
        String neighborhood = "";
        for(AirbnbListing property : database)
        {
            int price = property.getPrice() * property.getMinimumNights();

            if(price>maxPrice)
            {
                maxPrice=price;
                neighborhood = property.getNeighbourhood();
            }
        }
        return neighborhood;
    }

    public int countProperties(String borough)
    {
        int count =0;
        for(AirbnbListing p : database)
        {
            if(p.getNeighbourhood().equals(borough))
            {
                count++;

            }
        }
        return count;
    }


    public String getMostPopulatedNeighborhood()
    {
        int max =0;
        String mostPopulatedNeighborhood ="";
        for (String n : BOROUGHS)
        {
           if(countProperties(n)> max)
           {
               max = countProperties(n);
               mostPopulatedNeighborhood = n;
           }
        }
        return mostPopulatedNeighborhood;
    }



    public void buildStatistics()
    {
        statistics = new ArrayList<>();
        statistics.add( "Average number of reviews per property: "+  Integer.toString(averageNumberOfReviewsPerProperty()));
        statistics.add("Total number of available properties: " + Integer.toString(numberOfAvailableProperties()));
        statistics.add("Number of entire apartments: " + Integer.toString(numberOfEntireHApts()));
        statistics.add("Priciest neighborhood : " + getPriciestNeighborhood());
        statistics.add("Neighborhood with the most properties : " + getMostPopulatedNeighborhood());


    }


    public void makeStatisticsFrame()
    {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
         statisticsPanel = new JPanel(new GridBagLayout());
        JPanel bottomPanel = new JPanel();
        JPanel previousPanel = new JPanel(new BorderLayout());
        JPanel nextPanel = new JPanel(new BorderLayout());
        JButton mapPanel = new JButton("Map");
        mapPanel.addActionListener(e-> goBackToMapPanel());
        JButton previousStat = new JButton("<");
        previousStat.addActionListener(e-> getPreviousStat());
        JButton nextStat = new JButton(">");
        nextStat.addActionListener(e-> goToNextStat());
        previousPanel.add(previousStat,BorderLayout.CENTER);
        nextPanel.add(nextStat,BorderLayout.CENTER);
        stat = new JLabel(statistics.get(currentStat));
        stat.setFont(new Font("Calibri", Font.BOLD, 30));
        statisticsPanel.add(stat);
        bottomPanel.add(mapPanel, BorderLayout.WEST);
        add(statisticsPanel,BorderLayout.CENTER);
        bottomPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
        add(previousPanel,BorderLayout.WEST);
        add(nextPanel,BorderLayout.EAST);
        add(bottomPanel,BorderLayout.SOUTH);
        statisticsPanel.setBackground(Color.WHITE);
        bottomPanel.setBackground(Color.WHITE);

    }

    public void goToNextStat()
    {

       stat.setText(statistics.get(++currentStat % statistics.size()));


    }

    public void getPreviousStat()
    {
        --currentStat;
        if(currentStat < 0)
        {
            currentStat = statistics.size()-1;
        }
        stat.setText(statistics.get(currentStat));
    }

    public void goBackToMapPanel()
    {
        GUI.mainFrame.remove(GUI.sw);
        GUI.mainFrame.add(GUI.mw);
        GUI.mainFrame.revalidate();
        GUI.mainFrame.repaint();
    }








}
