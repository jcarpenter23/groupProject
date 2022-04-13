import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {

        //Button Listener 1
        class ButtonListener1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 1
            }
        }
        //Button Listener 2
        class ButtonListener2 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 2
            }
        }
        //Button Listener 3
        class ButtonListener3 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 3
            }
        }

        //GUI setup (frame, labels, and layout)
        JFrame frame = new JFrame("MadLibs Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(700,700);
        JLabel label1 = new JLabel("Welcome to your MadLibs Creator. From the menu, click a button to start your adventure!");
        frame.getContentPane().add(label1);
        frame.setVisible(true);
        //GUI buttons
        JButton button1 = new JButton("Edit your own MadLib Story");
        button1.addActionListener(new ButtonListener1());
        frame.getContentPane().add(button1);
        JButton button2 = new JButton("Read completed stories");
        button1.addActionListener(new ButtonListener2());
        frame.getContentPane().add(button2);
        JButton button3 = new JButton("View template stories");
        button1.addActionListener(new ButtonListener3());
        frame.getContentPane().add(button3);


    }
}
