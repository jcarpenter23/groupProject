import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    //GUI setup (frame, labels)
        JFrame frame = new JFrame("MadLibs Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        JLabel label1 = new JLabel("Welcome to MadLibs Creator. From the menu, click a button to start your adventure!");
        frame.getContentPane().add(label1);

    }
}
