import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Distance_calculator {
    public static final int PAGE_WIDTH = 600;
    public static final int PAGE_HEIGHT = 360;


    public static void Distance_calculator(){
        //Frame container
        JFrame Distance_Page = new JFrame("Test for Calculation");
        Distance_Page.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        Distance_Page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add panel
        JPanel panel = new JPanel();

        //add button
        JButton back = new JButton("Back");
        JButton confirm = new JButton("Confirm");
        JButton Refresh = new JButton("Refresh");

        //add label
        //input part
        JLabel input_value = new JLabel("INPUT");
        JLabel TX_Power = new JLabel("TX Power:");
        JLabel TX_Gain = new JLabel("TX Gain:");
        JLabel RX_Gain = new JLabel("RX Gain:");
        JLabel RX_Sensitivity = new JLabel(("RX Sensitivity:"));
        JLabel Margin = new JLabel(("Margin:"));
        JLabel f = new JLabel(("f (MHz):"));

        //output part
        JLabel output_value = new JLabel("OUTPUT");
        JLabel Distance = new JLabel(("Distance:"));
        JLabel FSPL = new JLabel(("FSPL:"));


        //add TextField
        JTextField TX_Power_text = new JTextField(20);
        JTextField TX_Gain_text = new JTextField(20);
        JTextField RX_Gain_text = new JTextField(20);
        JTextField RX_Sensitivity_text = new JTextField(20);
        JTextField Margin_text = new JTextField(20);
        JTextField f_text = new JTextField(20);

        JTextField Distance_text = new JTextField(20);
        JTextField FSPL_text = new JTextField(20);


        //result shown


        //distribution adjustment
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
        Distance_Page.setLocation((screen_width - PAGE_WIDTH) / 2, (screen_height - PAGE_HEIGHT) / 2);

        back.setBounds(10, 20, 80, 25);
        confirm.setBounds(400, 200, 100, 25);
        Refresh.setBounds(400,250,100,25);

        input_value.setBounds(30, 50, 60, 25);
        output_value.setBounds(400, 50, 60, 25);


        TX_Power.setBounds(30, 90, 100, 25);
        TX_Gain.setBounds(30, 130, 100, 25);
        RX_Gain.setBounds(30, 170, 100, 25);
        RX_Sensitivity.setBounds(30, 210, 100, 25);
        Margin.setBounds(30, 250, 100, 25);
        f.setBounds(30, 290, 100, 25);



        Distance.setBounds(400, 100, 100, 25);
        FSPL.setBounds(400, 140, 100, 25);

        TX_Power_text.setBounds(150, 90, 100, 25);
        TX_Gain_text.setBounds(150, 130, 100, 25);
        RX_Gain_text.setBounds(150, 170, 100, 25);
        RX_Sensitivity_text.setBounds(150, 210, 100, 25);
        Margin_text.setBounds(150, 250, 100, 25);
        f_text.setBounds(150, 290, 100, 25);

        Distance_text.setBounds(470,100,100,25);
        FSPL_text.setBounds(470,140,100,25);



        panel.add(back);
        panel.add(confirm);
        panel.add(Refresh);

        panel.add(input_value);
        panel.add(output_value);
        panel.add(TX_Power);
        panel.add(TX_Gain);
        panel.add(RX_Gain);
        panel.add(RX_Sensitivity);
        panel.add(Margin);
        panel.add(f);
        panel.add(Distance);
        panel.add(FSPL);

        panel.add(TX_Power_text);
        panel.add(TX_Gain_text);
        panel.add(RX_Gain_text);
        panel.add(RX_Sensitivity_text);
        panel.add(Margin_text);
        panel.add(f_text);

        panel.add(Distance_text);
        panel.add(FSPL_text);
        Distance_text.setVisible(false);
        FSPL_text.setVisible(false);

        panel.setLayout(null);
        Distance_Page.add(panel);
        Distance_Page.setResizable(false);
        Distance_Page.setVisible(true);



        //function part
        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TX_Power_valueS = TX_Power_text.getText();
                String TX_Gain_valueS = TX_Gain_text.getText();
                String RX_Gain_valueS = RX_Gain_text.getText();
                String RX_Sensitivity_valueS = RX_Sensitivity_text.getText();
                String Margin_valueS = Margin_text.getText();
                String f_valueS = f_text.getText();

                double TX_Power_value = Double.parseDouble(TX_Power_valueS);
                double TX_Gain_value = Double.parseDouble(TX_Gain_valueS);
                double RX_Gain_value = Double.parseDouble(RX_Gain_valueS);
                double RX_Sensitivity_value = Double.parseDouble(RX_Sensitivity_valueS);
                double Margin_value = Double.parseDouble(Margin_valueS);
                double f_value = Double.parseDouble(f_valueS);


                //calculator
                double FDPL_result = 0;
                double d_result = 0;
                FDPL_result = TX_Power_value + TX_Gain_value + RX_Gain_value - RX_Sensitivity_value - Margin_value;

                double temp1 = 20 * Math.log10(f_value);

                double temp2 =(FDPL_result + 27.55 - temp1) / 20.0;


                d_result = Math.pow(10,temp2);

                String FDPL_Str = String.format("%.2f",FDPL_result);
                String d_Str = String.format("%.2f",d_result);
                FSPL_text.setText(FDPL_Str);
                Distance_text.setText(d_Str);

                Distance_text.setVisible(true);
                FSPL_text.setVisible(true);

            }
        });


        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Distance_Page.dispose();
                new Select_Screen().Select_Screen();
            }
        });


        Refresh.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Distance_Page.dispose();
                new Distance_calculator().Distance_calculator();
            }
        });



    }


    public static void main(String[] arg){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { Distance_calculator();}
        });

    }



}
