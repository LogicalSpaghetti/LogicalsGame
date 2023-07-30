package main.me.spaghetti;

import javax.swing.*;
import java.awt.image.BufferedImage;


public class Main {

    // don't forget to add the colors to MapDecoder.TypeGet
    static String[] tileNames = new String[] {
            "grass",
            "stone",
            "water",
            "space"
    };

    static String[] fileNames = new String[] {
            "src/main/resources/floor/grass",
            "src/main/resources/floor/stone",
            "src/main/resources/floor/water",
            "space"
    };

    static int frameWidth = 800;
    static int frameHeight = 800;

    static MyFrame frame = new MyFrame("Game", frameWidth, frameHeight);
    static int tileSize = 60;

    // each map is associated with a file in resources/maps
    static Map map1 = new Map("map1");
    static Map map2 = new Map("map2");

    // 1024 is arbitrary, this needs to be reworked eventually
    static JPanel[] panels = new JPanel[1024];
    static JLabel[] labels = new JLabel[1024];

    static BufferedImage[] spriteSheet = SpriteSheet.Separate("src/main/resources/sprites/tileSets/Grass.png", 8, 10);

    // main method
    public static void main(String[] args) {
        DisplayBoard.InitialSetup();

        // SwingUtilities.invokeLater(PolyTest::new);
        DisplayBoard.Panels(map2);

    }
}