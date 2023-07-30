package main.me.spaghetti;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {
    public static BufferedImage[] Separate(String fileName, int rows, int columns) {

        BufferedImage bigImg;
        try {
            bigImg = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // The above line throws a checked IOException which must be caught.

        int width = bigImg.getWidth()/columns;
        int height = bigImg.getHeight()/rows;
        BufferedImage[] sprites = new BufferedImage[rows * columns];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                sprites[(i * columns) + j] = bigImg.getSubimage(
                        j * width,
                        i * height,
                        width,
                        height
                );
            }
        }
        return sprites;
    }
}
