package main.me.spaghetti.main;

import main.me.spaghetti.main.constructors.Map;
import main.me.spaghetti.main.constructors.MyFrame;
import main.me.spaghetti.main.simpleMethods.SaveImageToFile;
import main.me.spaghetti.main.warpTiles.ReDrawToRotate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {

    // the frame:
    static int frameWidth = 800;
    static int frameHeight = 800;
    static MyFrame frame = new MyFrame("Game", frameWidth, frameHeight);

    // tiles
    public static int tileSize = 60;
    static String[] tileNames = new String[] { // don't forget to add the colors to MapDecoder.TypeGet
            "grass",
            "stone",
            "water",
            "space"
    };

    // maps
    static Map map1 = new Map("map1");

    // 1024 is arbitrary, this needs to be reworked eventually
    static JPanel[] panels = new JPanel[1024];
    static JLabel[] labels = new JLabel[panels.length];

    // main method
    public static void main(String[] args) {
        // DisplayBoard.InitialSetup();
        // SwingUtilities.invokeLater(PolyTest::new);
        // DisplayBoard.Panels(map1);

        BufferedImage image2 = ReDrawToRotate.Rotate(map1.bufferedImage, 0, 0, 45);
        MyFrame frame2 = new MyFrame("Warped Image", 100, 100);
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel();
        label2.setBounds(0,0,image2.getWidth() * 10,image2.getHeight() * 10);
        panel2.setBounds(0,0,image2.getWidth() * 10,image2.getHeight() * 10);
        panel2.setLayout(null);
        label2.setLayout(null);

        SaveImageToFile.Buffered(image2, "warpedWaldo");
        ImageIcon icon = new ImageIcon("src/main/resources/rescaled_textures/" + "warpedWaldo" + "Re.png");

        label2.setIcon(icon);
        panel2.add(label2);
        frame2.add(panel2);
        panel2.setVisible(true);


    }
}