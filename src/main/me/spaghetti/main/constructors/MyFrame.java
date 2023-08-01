package main.me.spaghetti.main.constructors;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements ActionListener, KeyListener {

    public MyFrame(String title, int width, int height) {

        // sets the location of the frame to be centered in the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (int) ((screenSize.getWidth() - width) / 2); // accounts for the size of the window when centering it
        int locY = (int) (((screenSize.getHeight() - height) / 2));
        this.setLocation(locX, locY);

        // sets the size of the frame
        this.setSize(width, height + 30); // Add 30 to account for the frame title bar
        this.setResizable(true);

        // sets the icon of the frame
        ImageIcon image = new ImageIcon("src/main/resources/logos/conquest_logo.jpg");
        this.setIconImage(image.getImage()); // change icon of this

        // sets the background and title of the frame
        this.getContentPane().setBackground(new Color(0xFFFFFF)); // change color of background
        this.setTitle(title); // sets title of this

        // exit out of the application when closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // keyListener detects inputs
        this.addKeyListener(this);
        this.setFocusable(true); // sets if the frame can accept inputs, turn off if you only want other objects to detect actions and don't want the frame stealing priority

        this.setLayout(null); // without a layout every object added to the frame needs its position defined
        this.setUndecorated(false); // decoration is the bar at the top of the frame

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}