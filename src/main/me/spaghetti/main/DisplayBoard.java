package main.me.spaghetti.main;

import main.me.spaghetti.main.constructors.Map;
import main.me.spaghetti.main.simpleMethods.RescaleImage;
import main.me.spaghetti.main.simpleMethods.SaveImageToFile;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static main.me.spaghetti.main.Main.*;

public class DisplayBoard {
    public static void InitialSetup() {

        // Rescales all textures to tileSize
        InitialTextureRescale();

        // Does the initial configuration for the JPanels and JLabels
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            panels[i].setBackground(Color.white);
            panels[i].setPreferredSize(new Dimension(tileSize, tileSize));
            panels[i].setLayout(null);
            panels[i].setFocusable(false);

            labels[i] = new JLabel();
            labels[i].setVisible(true);
            labels[i].setBounds(0, 0, tileSize, tileSize);

            panels[i].add(labels[i]);
        }
    }

    // create JPanels with the associated texture then position them
    public static void Panels(Map map) {

        int width = map.width;

        String[] gridLayout = map.layout;

        // hides every panel in case any were open from a previous run
        for (JPanel jPanel : panels) {
            jPanel.setVisible(false);
        }

        // loops through all JPanels required to display the map, sets them up and displays them
        for (int i = 0; i < map.layout.length; i++) {

            labels[i].setIcon(new ImageIcon("src/main/resources/rescaled_textures/" + gridLayout[i] + "Re.png"));

            int xPosition = (i%width) * tileSize;
            int yPosition = ((i-(i%width))/width) * tileSize;
            panels[i].setBounds(xPosition, yPosition, tileSize, tileSize);

            frame.add(panels[i]);
            panels[i].setVisible(true);
        }
    }

    // for each texture, input its name into a method which rescales it and creates a new texture with that filename
    public static void InitialTextureRescale() {
        for (String tileName : tileNames) {
            if (!Objects.equals(tileName, "space")) {
                RescaleEach(tileName);
            }
        }
    }

    // rescales each image and saves it to the unscaled folder
    public static void RescaleEach(String name) {
        ImageIcon icon = new ImageIcon( "src/main/resources/unscaled/" + name + ".png");
        SaveImageToFile.Buffered(RescaleImage.ImageIcon(icon), name);
    }
}
