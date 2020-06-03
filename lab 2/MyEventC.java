import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyEventC extends JFrame implements ActionListener{
    private JButton jbPlus;
    private JButton jbQuit;
    private JButton jbReset;
    private JButton jbSub;
    private JTextField jtf;
    private JLabel current;


    public static void main(String args[])
    {
        new MyEventC ();
    }
    public MyEventC ()
    {
        super("Part 4 Using separate class for Reset Button");

        JPanel jpPanel = new JPanel(new FlowLayout());
        current = new JLabel("Current Value:");
        jtf = new JTextField("0",13);
        jpPanel.add(current);
        jpPanel.add(jtf);

        add(jpPanel,BorderLayout.NORTH);

        JPanel jpPanel1 = new JPanel(new FlowLayout());
        jbPlus = new JButton("+");
        jbPlus.addActionListener(this);
        jbSub = new JButton("-");
        jbSub.addActionListener(this);
        jbReset = new JButton("Reset");
        //jbReset.addActionListener(this);


        jbQuit = new JButton("Quit");
        jbQuit.addActionListener(this);

        jpPanel1.add(jbPlus);
        jpPanel1.add(jbSub);
        //registering the reset button
        ResetHelper rh = new ResetHelper(jbReset);
        jbReset.addActionListener(rh);
        jpPanel1.add(jbReset);
        jpPanel1.add(jbQuit);

        add(jpPanel1,BorderLayout.SOUTH);


        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
    public void actionPerformed(ActionEvent ae)
    {
        System.out.println(ae);
        Object choice = ae.getSource();
        if(choice == jbPlus)
        {
            String number = jtf.getText();
            Double num1 = Double.parseDouble(number);
            num1++;
            jtf.setText(""+num1);


        }
        else if(choice == jbQuit)
        {
            System.exit(0);
        }
        // Reset button is in another java file
        /*else if(choice == jbReset)
        {
            jtf.setText("0");
        }*/
        else if (choice == jbSub)
        {
            String number = jtf.getText();
            Double num1 = Double.parseDouble(number);
            num1--;
            jtf.setText(""+num1);
        }

    }
    class ResetHelper implements ActionListener{
        private JButton jbReset1;
        //method to handle the rest button;
        public ResetHelper(JButton jbReset1)
        {
            jbReset1 = jbReset;
        }
        public void actionPerformed(ActionEvent ae)
        {

            jtf.setText("0");
        }
    }
}

