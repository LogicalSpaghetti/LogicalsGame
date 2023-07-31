package main.me.spaghetti.main;


import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements ActionListener, KeyListener {

    MyFrame(String title, int width, int height) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (int) ((screenSize.getWidth() - width) / 2); // accounts for the size of the window when centering it
        int locY = (int) (((screenSize.getHeight() - height) / 2));
        this.setLocation(locX, locY); // location is the top left corner of the window

        ImageIcon image = new ImageIcon("main/resources/logo.png"); // create image icon
        this.setIconImage(image.getImage()); // change icon of this
        this.getContentPane().setBackground(new Color(0xFFFFFF)); // change color of background
        this.setTitle(title); // sets title of this

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of the application
        this.setSize(width, height + 30); // Add 30 to account for the frame title bar, and sets x and y dimension of this
        //this.setUndecorated(true);

        this.setFocusable(true);
        this.addKeyListener(this);

        this.setLayout(null);

        this.setResizable(true);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key typed.");
        System.out.println(this.getHeight() + " " + this.getWidth());
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}