package main.me.spaghetti;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;

import static main.me.spaghetti.Main.tileSize;

public class Rescale {
    public static BufferedImage ImageIcon(ImageIcon icon) {

        Image startImage = icon.getImage(); // transform it
        Image newImg = startImage.getScaledInstance(tileSize, tileSize, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon.setImage(newImg); // transform it back

        BufferedImage bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        // paint the Icon to the BufferedImage.
        icon.paintIcon(null, g, 0,0);
        g.dispose();

        return bi;
    }
}
