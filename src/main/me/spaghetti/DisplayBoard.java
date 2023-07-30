package main.me.spaghetti;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

import static main.me.spaghetti.Main.*;

public class DisplayBoard {
    public static void InitialSetup() {

        InitialTextureRescale();

        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            panels[i].setBackground(Color.white);
            panels[i].setPreferredSize(new Dimension(tileSize,tileSize));
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

        for (JPanel jPanel : panels) {
            jPanel.setVisible(false);
        }

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
        for (int i = 0; i < tileNames.length; i++) {
            if (!Objects.equals(tileNames[i], "space")) {
                RescaleEach(tileNames[i], fileNames[i]);
            }
        }
    }

    public static void RescaleEach(String name, String fileName) {

        ImageIcon icon = new ImageIcon(fileName + ".png");
        SaveImageToFile.Save(Rescale.ImageIcon(icon), name);
    }
}
