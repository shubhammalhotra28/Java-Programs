
/**
 * A description of what the class does.
 *
 * @author      Shubham Malhotra
 * Home work 1(Assignment)
 * Class ISTE 121
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import sun.audio.*;
import java.io.*;





public class Assignment extends JFrame implements ActionListener
{

    //initialising the global variables
    private JTextArea jta;
    private Label l;
    private int i;
    private String exitString;
    static JTextField textfield1, textfield2, textfield3;
    private int j=0;

    //calling the constructor

    public Assignment() {
        super("Gui from Hell");//setting the title

         jta = new JTextArea("hello welcome to the GUI making the user life miserable further.",20,15);//textarea pre filled
        JPanel jpPanel1 = new JPanel(new FlowLayout());
        jpPanel1.add(jta);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        Font font = new Font("Segoe Script", Font.BOLD, 20);//addind font to the text
        jta.setFont(font);
        jta.setForeground(Color.BLUE);
        jta.setBackground(Color.yellow);
        JScrollPane scrollpane = new JScrollPane(jta);
        jpPanel1.add(scrollpane);
        //adding the menu bar
        JMenuBar menu = new JMenuBar();
        JMenu File = new JMenu("File");
        setJMenuBar(menu);
        File.setMnemonic('F');
        menu.add(File);
        JMenuItem jExit = new JMenuItem("Exit");
        jExit.setMnemonic('X');
        File.add(jExit);
        JMenuItem Help = new JMenuItem("Help");
        Help.setMnemonic('H');

        File.add(Help);
        JMenuItem About = new JMenuItem("About");
        About.setMnemonic('A');
        File.add(About);
        MyListenerCnt helper = new MyListenerCnt(jta,jExit,Help,About);
        Help.addActionListener(helper);
        jExit.addActionListener(helper);
        About.addActionListener(helper);
        add(jpPanel1, BorderLayout.NORTH);
        JPanel jpPanel2 = new JPanel(new FlowLayout());

        JButton jbExit = new JButton("Exit");
        jbExit.addActionListener(this);
        JButton jbVeryExit = new JButton("TRAP");
        jbVeryExit.addActionListener(this);

        jbVeryExit.addMouseListener(new MouseAdapter() {
            /**
             *using the mouse adapter within the MouseListener to chck the presence of motion detected and further
             *performing the relevant task.
             * this button also ask the user to exit the program while hovering over the button
             */
            public void mouseEntered(MouseEvent evt) {
                jbVeryExit.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(null,"mouse entered exit");
                i=0;
                check();
            }
            public void mouseExited(MouseEvent evt) {

                jbVeryExit.setBackground(UIManager.getColor("control"));
                JOptionPane.showMessageDialog(null,"mouse left the control panel");
                System.out.println("exit");
                i=1;
                check();
            }
        });
        jpPanel2.add(jbExit);
        jpPanel2.add(jbVeryExit);
        add(jpPanel2, BorderLayout.SOUTH);
        JPanel jpPanel3 = new JPanel(new FlowLayout());
        JButton jbOk = new JButton("Ok");
        jbOk.addActionListener(this);
        final JFrame frame = new JFrame("JToggle Button ");
        frame.setSize(200, 100);
        JToggleButton jtbButton = new JToggleButton("welcome to toggling of buttons. please press on the window");

        jtbButton.addItemListener(new ItemListener() {
            /**
             *this is further using the item listener which will further check if the button is pressed b the user and
             * perform toggling once pressed.
             */
            public void itemStateChanged(ItemEvent ev) {
                JOptionPane.showMessageDialog(frame, "Item Event in toggling of button");
            }
        });
        jtbButton.addChangeListener(new ChangeListener() {
            /**
             *this is further using the item listener which will further check if the button is pressed b the user and
             * perform toggling once pressed.
             */
            public void stateChanged(ChangeEvent ev) {
                JOptionPane.showMessageDialog(frame, "Change event in toggling of button");
            }
        });
        frame.add(jtbButton);
        frame.setVisible(true);
        frame.add(jtbButton);
        jpPanel3.add(jbOk);
        add(jpPanel3, BorderLayout.EAST);
        JFrame myWindow = new JFrame("Hola! SEE YOU IN GUI FROM HELL");
        myWindow.getContentPane().setBackground(Color.YELLOW);
        myWindow.getContentPane().setLayout(new FlowLayout());
        textfield1 = new JTextField("Welcome to gui hell",20);
        textfield2 = new JTextField("miserable",10);
        textfield3 = new JTextField("user life",10);
        myWindow.getContentPane().addMouseMotionListener(new MouseMotionListener() {
            /**
             * this is using the MouseListener and MouseMotionListener and further show the message in JOptionpane
             * message dialog box if there is mouse being dragged or moved.
             */
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("dont dragg the mouse too much");
            }

            @Override
            /**
             * this is using the MouseListener and MouseMotionListener and further show the message in JOptionpane
             * message dialog box if there is mouse being dragged or moved.
             */
            public void mouseMoved(MouseEvent e) {
                System.out.println("mouse moved");
                JOptionPane.showMessageDialog(null,"mousee moved");
            }
        });
        myWindow.getContentPane().add(textfield1);
        myWindow.getContentPane().add(textfield2);
        myWindow.getContentPane().add(textfield3);

        myWindow.pack();
        myWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        myWindow.setLayout(null);
        myWindow.setVisible(true);

        l = new Label();
        l.setBounds(20, 50, 100, 20);
        add(l);
        setSize(300, 300);
        pack();
    }
    /**
     * this method is created to check the value of int i , which will further help to tell if the user wishes to
     * close the program or still wishes to run all the windows of the program.
     */
    public void check()
    {
        if(i==1)
        {
            int ans = JOptionPane.showConfirmDialog(null,"are you sure you want to exit ");
            switch (ans){
                case 0:
                    System.out.println("program exited");
                    JOptionPane.showMessageDialog(null,"program exited");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("not exiting");
                    JOptionPane.showMessageDialog(null,"not exiting");
                    break;
                case 2:
                    System.out.println("canceling the exit request");
                    JOptionPane.showMessageDialog(null,"canceling the exit request");
                    break;
                default:
                    System.out.println("no command");
            }
        }
        else
        {
            System.out.println("not exiting now");
        }
    }
    /**
     * this method will display the message in dialog box that the exit button is just used as a trap
     */
    public void sorry() {
        System.out.println("forcing to shutdown ");
        JOptionPane.showMessageDialog(null, "sorry itss a trap");
    }
    /**
     * The listener interface for receiving action events.
     * The class that is interested in processing an action event
     * implements this interface, and the object created with that
     * class is registered with a component, using the component's
     */
    public void actionPerformed(ActionEvent ae) {
        String ans = ae.getActionCommand();
        if (ans.equals("Exit")) {
            System.out.println("Seriously looking to exit :)");
            JOptionPane.showMessageDialog(null, "Seriously looking to exit ");
            sorry();
        } else if (ans.equals("Trap")) {
            System.exit(0);
        }
        else if(ans.equals("Ok"))
        {
            j++;
            String hell = jta.getText()+"haha its a trappp";
            Font font = new Font("Arial", Font.BOLD, 20);
            jta.setFont(font);
            jta.setText(hell);
            if(j>5)
            {
                /**
                 * if the button is pressed more than 5 times than the background colour will be changed as well as the text
                 * will be changed. Along with that the user will see the MessageDialogBox(as a warning).
                 */
                JOptionPane.showMessageDialog(null,"wohooo dont press the button again and again");
                jta.setEnabled(false);
                jta.setText(" ");
                jta.setBackground(Color.CYAN);
                jta.setAlignmentX(3.5f);
            }


        }
        else if(ans.equals("mouse moved"))
        {
            System.out.println("hi");
        }

    }
        public static void main(String args[]) {
            Assignment menu = new Assignment();

            JFrame frame1 = new JFrame("holaaa");
            JButton jb1 = new JButton("click me");
            frame1.add(jb1);
            jb1.addActionListener(new AL());
            frame1.setVisible(true);
            frame1.pack();
            frame1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            JFrame frame = new JFrame("Welcome to the world of gui hell");

            frame.getContentPane().add(new MainClass());
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setSize(200, 200);
            frame.setVisible(true);
            menu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            menu.setVisible(true);
        }
    }//end of main class

/**
 * this class is made to add audio file within the program and play further with the help of music method
 */
    class AL implements ActionListener {
        public final void actionPerformed(ActionEvent ae) {
            /**
             * The listener interface for receiving action events.
             * The class that is interested in processing an action event
             * implements this interface, and the object created with that
             * class is registered with a component, using the component's
             */
            music();// call of music method
        }
        private void music()
        {
            /**
             * adding of the music file within the system with various components such as AudioPlayer,AudioStream
             * and AudioData.
             * ContinuousAudioDataStream is acting as a loop to the audio which is initiating again and again to null
             * as soon as the audio completes.
             */


            AudioPlayer Audio = AudioPlayer.player;
            AudioStream AudioStream;
            AudioData Audiodata;

            ContinuousAudioDataStream loop = null;

            /**
             * code placed within the try and catch block so that the program could easily handle all the exceptions
             */
            try
            {
                InputStream test = new FileInputStream("src/song.wav");
                AudioStream = new AudioStream(test);
                AudioPlayer.player.start(AudioStream);
            }
            catch(FileNotFoundException e){
                System.out.print(e.toString());
            }
            catch(IOException error)
            {
                System.out.print(error.toString());
            }
            Audio.start(loop);

        }
    }


/**
 * this class is further implementing a frame in which the whole window will be acting as a button
 * various warning and options are being added within the file to make the gui perform as miserable as possible
 * it will keep on popping the message if the user wants to use or if he chooses not to use the GUI FROM HELL
 * program.
 */
class MainClass extends JPanel {


    public MainClass() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JOptionPane.showMessageDialog(null,"welcome to gui hell");
                int input = JOptionPane.showConfirmDialog(null,"are you sure to enter the world of gui");
                System.out.println(input);
                switch (input)
                {
                    case 0:
                        JOptionPane.showMessageDialog(null,"you are making the miserable decision");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null,"good decision,but why not give it a shot");
                        break;
                    case 2:
                        int input1 = JOptionPane.showConfirmDialog(null,"really");
                        switch (input1)
                        {
                            case 0:
                                System.exit(0);
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(null,"select an appropriate choice");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null,"your wish");
                                break;
                            default:
                                System.out.println("no choice selected");
                        }
                    default:
                        System.out.println("no choice selected");
                }
            }

            });
    }
}




