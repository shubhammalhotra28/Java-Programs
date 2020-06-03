import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class MyMenu extends JFrame {

    private JTextArea jta;
    private int result;
    private String lastChar;
    private Document doc;

    public MyMenu() {

        super("My Menu");

        jta = new JTextArea("0", 20, 15);

        JPanel jpPanel = new JPanel(new FlowLayout());
        jpPanel.add(jta);
        //String lastline = jta.Lines[jta.Lines.Length - 1];
        JScrollPane scrollPane = new JScrollPane(jta);
        jpPanel.add(scrollPane);


        JMenuBar menu = new JMenuBar();

        JMenu mCount = new JMenu("Count");
        setJMenuBar(menu);
        mCount.setMnemonic('C');
        menu.add(mCount);
        JMenuItem mInc = new JMenuItem("Inc");
        mCount.setMnemonic('I');
        MyListenerCnt helper = new MyListenerCnt(jta, result, doc, lastChar);
        mInc.addActionListener(helper);
        mCount.add(mInc);
        JMenuItem mDec = new JMenuItem("Dec");
        mDec.setMnemonic('D');
        mDec.addActionListener(helper);
        mCount.add(mDec);
        JMenuItem mReset = new JMenuItem("Reset");
        mReset.setMnemonic('R');
        mReset.addActionListener(helper);

        mCount.add(mReset);
        JMenuItem mExit = new JMenuItem("Exit");
        mReset.setMnemonic('E');

        mCount.addActionListener(helper);
        mCount.add(mExit);

        //count = jta.ReadLine.Last();
        add(jpPanel, BorderLayout.CENTER);
        pack();
    }

    public static void main(String args[]) {
        MyMenu menu = new MyMenu();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }

    public class MyListenerCnt implements ActionListener {
        private JTextArea jta;
        private int result;
        private Document doc;
        private String lastChar;


        public MyListenerCnt(JTextArea jtaMain, int countVal, Document docVal, String lastCharSt) {

            jta = jtaMain;
            result = countVal;
            doc = docVal;
            lastChar = lastCharSt;


        }

        public void actionPerformed(ActionEvent ae) {

            if (ae.getActionCommand().equals("Reset")) {
                jta.append("\n0");
            } else if(ae.getActionCommand().equals("Exit")){
                //System.out.println("hi");
                System.exit(0);

            } else if (ae.getActionCommand().equals("Inc")) {
                try {
                    System.out.println(jta.getText());
                    doc = jta.getDocument();
                    lastChar = doc.getText(doc.getLength() - 1, 1);
                    String s = jta.getText();//getting all the text
                    String[] myData = s.split("\\r?\\n");//regular expression to get the last value
                    result = Integer.parseInt(myData[myData.length-1]);
                    result++;
                    jta.append("\n" + result);

                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            } else if (ae.getActionCommand().equals("Dec")) {
                try {
                    doc = jta.getDocument();
                    lastChar = doc.getText(doc.getLength() - 1,1 );
                    String s = jta.getText();//getting all the text
                    String[] myData = s.split("\\r?\\n");//regular expression to get the last value
                    result = Integer.parseInt(myData[myData.length-1]);
                    --result;
                    jta.append("\n" + result);


                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

}

