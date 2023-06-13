import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Select_Screen {
    public static final int  PAGE_WIDTH = 600;
    public static final int PAGE_HEIGHT = 360;

    public static void Select_Screen() {
        //Frame container
        JFrame Select_Page = new JFrame("Test for Calculation     Ver1.1");
        Select_Page.setSize(PAGE_WIDTH,PAGE_HEIGHT);
        Select_Page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add panel
        JPanel panel  = new JPanel();

        //add text
        JLabel Notice = new JLabel("AP Calculation");

        //add button
        JButton Height_calculator = new JButton("Height_calculator");
        JButton Distance_calculator = new JButton("Distance_calculator");

        //distribution adjustment
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
        Select_Page.setLocation((screen_width -PAGE_WIDTH )/2,(screen_height -PAGE_HEIGHT )/2);

        Notice.setBounds(250,20,100,40);
        Height_calculator.setBounds(210,100,180,40);
        Distance_calculator.setBounds(210,200,180,40);

        panel.add(Notice);
        panel.add(Height_calculator);
        panel.add(Distance_calculator);
        Select_Page.add(panel);
        panel.setLayout(null);
        Select_Page.setResizable(false);
        Select_Page.setVisible(true);



        //add action listener
        Height_calculator.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Select_Page.dispose();
                new Height_calculator().Height_calculator();

            }
        });

        Distance_calculator.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Select_Page.dispose();
                new Distance_calculator().Distance_calculator();
            }
        });





    }


    public static void main(String[] args){
        //show the GUI Screen
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { Select_Screen();}
        });
    }
}




