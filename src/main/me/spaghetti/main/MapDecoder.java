package main.me.spaghetti.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapDecoder {
    public static String[] ImageToArray(BufferedImage image) {
        String[] array = new String[image.getHeight() * image.getWidth()];
        int i = 0;
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                array[i] = TypeGet(image, x, y);
                i += 1;
            }
        }

        return array;
    }
    public static String TypeGet(BufferedImage image, int x, int y) {
        return switch ((new Color(image.getRGB(x, y))).getRGB()) {
            case -16617439 -> "grass";
            case -12961222 -> "stone";
            case -15751962 -> "water";
            default -> "space";
        };
    }
}
