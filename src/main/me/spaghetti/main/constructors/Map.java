package main.me.spaghetti.main.constructors;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// defines the attributes of a map such as size
public class Map {

    public String fileName;
    public int width;
    public String[] layout;
    public BufferedImage bufferedImage;

    public Map(String mapName) {
        this.fileName = "src/main/resources/maps/" + mapName + ".png";

        Image img = ((new ImageIcon(fileName)).getImage());
        bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bufferedImage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        this.width = this.bufferedImage.getWidth();
        this.layout = ImageToArray(bufferedImage);
    }

    // decodes the image associated with a map and returns the tile associated with each color
    public static String[] ImageToArray(BufferedImage image) {
        String[] array = new String[image.getHeight() * image.getWidth()];
        int i = 0;
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                array[i] = TypeGet((new Color(image.getRGB(x, y))));
                i += 1;
            }
        }

        return array;
    }

    // returns the name of the tile associated with an inputted color
    public static String TypeGet(Color color) {
        return switch (color.getRGB()) {
            case -16617439 -> "grass";
            case -12961222 -> "stone";
            case -15751962 -> "water";
            default -> "space";
        };
    }

}
