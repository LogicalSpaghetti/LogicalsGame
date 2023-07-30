package main.me.spaghetti;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// defines the attributes of a map such as size
public class Map {

    String fileName;
    int width;
    String[] layout;
    int height;
    BufferedImage bufferedImage;

    Map(String mapName) {
        this.fileName = "src/main/resources/maps/" + mapName + ".png";

        Image img = ((new ImageIcon(fileName)).getImage());
        this.bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bufferedImage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        this.width = this.bufferedImage.getWidth();
        this.height = this.bufferedImage.getHeight();
        this.layout = MapDecoder.ImageToArray(bufferedImage);
    }
}
