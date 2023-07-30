package main.me.spaghetti;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaveImageToFile {
    public static void Save(BufferedImage image, String name) {
        try {
            // retrieve image
            File outputfile = new File("src/main/resources/rescaled_textures/" + name + "Re.png");
            ImageIO.write(image, "png", outputfile);
        } catch (
                IOException e) {
            System.out.println("Write error for " + /*file.getPath() +*/ ": " + e.getMessage());
        }
    }
}
