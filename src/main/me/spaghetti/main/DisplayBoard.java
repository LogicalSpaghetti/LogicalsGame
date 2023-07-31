package main.me.spaghetti.main;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DisplayBoard {
    public static void InitialSetup() {

        InitialTextureRescale();

        for (int i = 0; i < Main.panels.length; i++) {
            Main.panels[i] = new JPanel();
            Main.panels[i].setBackground(Color.white);
            Main.panels[i].setPreferredSize(new Dimension(Main.tileSize, Main.tileSize));
            Main.panels[i].setLayout(null);
            Main.panels[i].setFocusable(false);

            Main.labels[i] = new JLabel();
            Main.labels[i].setVisible(true);
            Main.labels[i].setBounds(0, 0, Main.tileSize, Main.tileSize);

            Main.panels[i].add(Main.labels[i]);
        }
    }

    // create JPanels with the associated texture then position them
    public static void Panels(Map map) {

        int width = map.width;

        String[] gridLayout = map.layout;

        for (JPanel jPanel : Main.panels) {
            jPanel.setVisible(false);
        }

        for (int i = 0; i < map.layout.length; i++) {

            Main.labels[i].setIcon(new ImageIcon("src/main/resources/rescaled_textures/" + gridLayout[i] + "Re.png"));

            int xPosition = (i%width) * Main.tileSize;
            int yPosition = ((i-(i%width))/width) * Main.tileSize;
            Main.panels[i].setBounds(xPosition, yPosition, Main.tileSize, Main.tileSize);

            Main.frame.add(Main.panels[i]);
            Main.panels[i].setVisible(true);
        }
    }

    // for each texture, input its name into a method which rescales it and creates a new texture with that filename
    public static void InitialTextureRescale() {
        for (int i = 0; i < Main.tileNames.length; i++) {
            if (!Objects.equals(Main.tileNames[i], "space")) {
                RescaleEach(Main.tileNames[i], Main.fileNames[i]);
            }
        }
    }

    public static void RescaleEach(String name, String fileName) {

        ImageIcon icon = new ImageIcon(fileName + ".png");
        SaveImageToFile.Save(Rescale.ImageIcon(icon), name);
    }
}
