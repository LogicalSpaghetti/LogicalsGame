package main.me.spaghetti.main;

import main.me.spaghetti.main.constructors.Map;
import main.me.spaghetti.main.constructors.MyFrame;

import javax.swing.JPanel;
import javax.swing.JLabel;

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
        DisplayBoard.InitialSetup();
        // SwingUtilities.invokeLater(PolyTest::new);
        DisplayBoard.Panels(map1);
    }
}