package main.me.spaghetti.main.simpleMethods;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;

import static main.me.spaghetti.main.Main.tileSize;

// rescales an image to a desired size
public class RescaleImage {

    // rescales an ImageIcon to tileSize by tileSize and returns it as a BufferedImage
    public static BufferedImage ImageIcon(ImageIcon icon) {

        // rescale
        Image startImage = icon.getImage(); // transform it
        Image newImg = startImage.getScaledInstance(tileSize, tileSize, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon.setImage(newImg); // transform it back

        // transform to BufferedImage
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
