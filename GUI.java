import javax.swing.*;
import java.awt.*;

public class GUI {
    public static WelcomeWindow ww ;
    public static JFrame mainFrame;
    public static MapWindow mw;
    public static StatisticsWindow sw;
    public GUI()
    {
        makeGUI();
    }

    public static void main(String[] args)
    {
        GUI gui = new GUI();
        StatisticsWindow s = new StatisticsWindow();
    }

    public void makeGUI()
    {
        JFrame mF = new JFrame();
        mainFrame = mF;
        mainFrame.getContentPane().setPreferredSize(new Dimension(1200,1000));
        WelcomeWindow w = new WelcomeWindow();
        ww = w;
        mainFrame.add(ww);
        mainFrame.setVisible(true);
        mainFrame.pack();
    }


}

