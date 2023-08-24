package GuiExcercising;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SimpleGui3 implements ActionListener{
    private JFrame frame;

    public static void main(String[] args) {
        SimpleGui3 gui = new SimpleGui3();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change color");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();
        JCheckBox checkBox = new JCheckBox("click");
        JPasswordField passwordField = new JPasswordField("dottedPassword");

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, checkBox);
        frame.getContentPane().add(BorderLayout.NORTH, passwordField);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
}
