import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyEventA extends JFrame implements ActionListener{
    private JButton jbPlus;
    private JButton jbQuit;
    private JButton jbReset;
    private JButton jbSub;
    private JTextField jtf;
    private JLabel current;


    public static void main(String args[])
    {
        new MyEventA();
    }
    public MyEventA()
    {
        super("Part 2 Using getSource");

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
        jbReset.addActionListener(this);
        jbQuit = new JButton("Quit");
        jbQuit.addActionListener(this);

        jpPanel1.add(jbPlus);
        jpPanel1.add(jbSub);
        jpPanel1.add(jbReset);
        jpPanel1.add(jbQuit);

        add(jpPanel1,BorderLayout.SOUTH);


        pack();
        setVisible(true);


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
        else if(choice == jbReset)
        {
            jtf.setText("0");
        }
        else if (choice == jbSub)
        {
            String number = jtf.getText();
            Double num1 = Double.parseDouble(number);
            num1--;
            jtf.setText(""+num1);
        }

    }
}

