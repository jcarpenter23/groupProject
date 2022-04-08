import javax.swing.*;
import java.awt.event.ActionListener;


public class Main {


    public static void main(String[] args) {

    //GUI setup (frame & labels)
        JFrame frame = new JFrame("MadLibs Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(500,500);
        JLabel label1 = new JLabel("Welcome to MadLibs Creator. From the menu, click a button to start your adventure!");
        frame.getContentPane().add(label1);
        frame.setVisible(true);
        //GUI buttons
        JButton button1 = new JButton("Edit your own MadLib Story");
        frame.getContentPane().add(button1);
        JButton button2 = new JButton("Read completed stories");
        frame.getContentPane().add(button2);
        JButton button3 = new JButton("View completed Stories");
        frame.getContentPane().add(button3);
    }
}
