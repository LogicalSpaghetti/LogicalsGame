package main.me.spaghetti.main.warpTiles;

import java.awt.image.BufferedImage;

// outputs an image that's warped to simulate rotation
public class ReDrawToRotate {
    public static BufferedImage Rotate(BufferedImage image, double rotationX, double rotationY, double rotationZ) {

        // degrees to radians
        rotationX = (rotationX*Math.PI)/180;
        rotationY = (rotationY*Math.PI)/180;
        rotationZ = (rotationZ*Math.PI)/180;

        // this is rotation around Z:
        // x′ = x * Math.cos(rotationZ) - y * Math.sin(rotationZ)
        // y′ = x * Math.sin(rotationZ) + y * Math.cos(rotationZ)


        // rotating around Z will cause the image to rotate, it's a line going straight forward
        // rotating around X will cause the image to be squished flat
        // rotating around Y will cause the image to be squished thin

        //top left = 0,0
        int initialWidth = image.getWidth();
        int initialHeight = image.getHeight();

        // x,y
        int[] initialTopLeft = {-initialWidth, -initialHeight};
        int[] initialTopRight = {initialWidth, -initialHeight};
        int[] initialBottomLeft = {-initialWidth, initialHeight};
        int[] initialBottomRight = {initialWidth, initialHeight};
        int[][] corners = {initialTopLeft, initialTopRight, initialBottomLeft, initialBottomRight};

        // find the highest and lowest value for each, because it's a rectangle it'll always be the four corners
        double transformedMinX = 0;
        double transformedMinY = 0;
        double transformedMaxX = 0;
        double transformedMaxY = 0;

        for (int i = 0; i < 4; i++) {
            double newX = (corners[i][0] * Math.cos(rotationZ)) - (corners[i][1] * Math.sin(rotationZ));
            double newY = (corners[i][0] * Math.sin(rotationZ)) + (corners[i][1] * Math.cos(rotationZ));
            if (transformedMinX > newX) {
                transformedMinX = newX;
            }
            if (transformedMinY > newY) {
                transformedMinY = newY;
            }
            if (transformedMaxX < newX) {
                transformedMaxX = newX;
            }
            if (transformedMaxY < newY) {
                transformedMaxY = newY;
            }
        }

        System.out.println(transformedMinX);
        System.out.println(transformedMinY);
        System.out.println(transformedMaxX);
        System.out.println(transformedMaxY);

        int width = (int) Math.ceil(Math.abs(transformedMaxX));
        int height = (int) Math.ceil(Math.abs(transformedMaxY));

        System.out.println(width + " " + height);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y2 = 0; y2 < height; y2++) {
            for (int x2 = 0; x2 < width; x2++) {
                int y = (int) ((y2 - (x2 * Math.sin(rotationZ) - width/2 * Math.sin(rotationZ)) / Math.cos(rotationZ)) / (Math.cos(rotationZ) + Math.pow(Math.sin(rotationZ), 2) / Math.cos(rotationZ)));
                int x = (int) ((x2 - width/2 + y * Math.sin(rotationZ)) / Math.cos(rotationZ));

                if (x >= 0 && y >= 0 && x < image.getWidth() && y < image.getHeight()) {
                    System.out.println("x2 = " + x2);
                    System.out.println("y2 = " + y2);
                    bufferedImage.setRGB(x2, y2, image.getRGB(x, y));
                }
            }
        }

        return bufferedImage;
    }
}
