import javax.swing.*;

public class GUI {
    private WelcomeWindow ww ;
    public GUI()
    {
        makeGUI();
    }

    public static void main(String[] args)
    {
        GUI gui = new GUI();
    }

    public void makeGUI()
    {
        JFrame mainFrame = new JFrame();
        WelcomeWindow w = new WelcomeWindow();
        ww = w;
        mainFrame.add(ww);
        mainFrame.setVisible(true);
        mainFrame.pack();
    }


}

