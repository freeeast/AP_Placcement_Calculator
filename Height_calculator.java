import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Height_calculator {
    public static final int PAGE_WIDTH = 600;
    public static final int PAGE_HEIGHT = 360;
    public static final double C = 3.00E8;

    public static String toString(double a) {
        String temp = "";
        String result = temp + a;
        return result;
    }


    public static void Height_calculator() {
        //Frame container
        JFrame Height_Page = new JFrame("Test for Calculation");
        Height_Page.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        Height_Page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add panel
        JPanel panel = new JPanel();

        //add button
        JButton back = new JButton("Back");
        JButton confirm = new JButton("Confirm");
        JButton Refresh = new JButton("Refresh");

        //add label
        //input part
        JLabel input_value = new JLabel("INPUT");
        JLabel d1 = new JLabel("d1:");
        JLabel d2 = new JLabel("d2:");
        JLabel f = new JLabel("f (MHz):");
        JLabel h = new JLabel(("h"));

        //output part
        JLabel output_value = new JLabel("OUTPUT");
        JLabel r = new JLabel("r:");
        JLabel H = new JLabel("H(60%)>");


        //add TextField
        JTextField d1_text = new JTextField(20);
        JTextField d2_text = new JTextField(20);
        JTextField f_text = new JTextField(20);
        JTextField h_text = new JTextField(20);
        JTextField r_text = new JTextField(20);
        JTextField H_text = new JTextField(20);


        //result shown


        //distribution adjustment
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
        Height_Page.setLocation((screen_width - PAGE_WIDTH) / 2, (screen_height - PAGE_HEIGHT) / 2);

        back.setBounds(10, 20, 80, 25);
        confirm.setBounds(400, 200, 100, 25);
        Refresh.setBounds(400,250,100,25);

        input_value.setBounds(30, 50, 60, 25);
        output_value.setBounds(400, 50, 60, 25);


        d1.setBounds(30, 100, 50, 25);
        d2.setBounds(30, 140, 50, 25);
        f.setBounds(30, 180, 50, 25);
        h.setBounds(30, 220, 50, 25);


        r.setBounds(400, 100, 20, 25);
        H.setBounds(400, 140, 60, 25);

        d1_text.setBounds(100, 100, 100, 25);
        d2_text.setBounds(100, 140, 100, 25);
        f_text.setBounds(100, 180, 100, 25);
        h_text.setBounds(100, 220, 100, 25);

        r_text.setBounds(470,100,100,25);
        H_text.setBounds(470,140,100,25);


        panel.add(back);
        panel.add(confirm);
        panel.add(Refresh);

        panel.add(input_value);
        panel.add(output_value);
        panel.add(d1);
        panel.add(d2);
        panel.add(f);
        panel.add(h);
        panel.add(r);
        panel.add(H);

        panel.add(d1_text);
        panel.add(d2_text);
        panel.add(f_text);
        panel.add(h_text);

        panel.add(r_text);
        panel.add(H_text);

        r_text.setVisible(false);
        H_text.setVisible(false);

        panel.setLayout(null);
        Height_Page.add(panel);
        Height_Page.setResizable(false);
        Height_Page.setVisible(true);


        //function part
        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String d1_valueS = d1_text.getText();
                String d2_valueS = d2_text.getText();
                String f_valueS = f_text.getText();
                String h_valueS = h_text.getText();

                double d1_value = Double.parseDouble(d1_valueS);
                double d2_value = Double.parseDouble(d2_valueS);
                double f_value = Double.parseDouble(f_valueS);
                f_value = f_value * Math.pow(10.0,6.0);
                double h_value = Double.parseDouble(h_valueS);

                //calculator
                double r_result = 0;
                double H_result = 0;
                double temp1 = (d1_value * d2_value) / (d1_value + d2_value);
                double temp2 = C / f_value;


                r_result = Math.sqrt(temp1 * temp2);

                H_result = h_value + r_result * 0.6;

                String rStr = String.format("%.2f",r_result);
                String HStr = String.format("%.2f",H_result);
                r_text.setText(rStr);
                H_text.setText(HStr);

                r_text.setVisible(true);
                H_text.setVisible(true);

            }
        });


        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Height_Page.dispose();
                new Select_Screen().Select_Screen();
            }
        });

        Refresh.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Height_Page.dispose();
                new Height_calculator().Height_calculator();
            }
        });


    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { Height_calculator();}
        });
    }
}

//问题1：为什么切换窗口时需要eg.  new Select_Screen().Select_Screen();
//而不是直接 new Select_Screen()？

//