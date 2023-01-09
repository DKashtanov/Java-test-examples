package utils;

import aquality.selenium.browser.AqualityServices;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompareImage {

    private static final int RED_VALUE = 16;
    private static final int GREEN_VALUE = 8;
    private static final int HEX_VALUE_OF_255 = 0xff;
    private static final int TOTAL_PIXELS_MULTIPLIER = 3;
    private static final int AVG_DIFFERENT_PIXELS_DIVIDER = 255;
    private static final int AVG_DIFFERENT_PIXELS_MULTIPLIER = 100;

    public static double compareImages(String file1, String file2) {
        BufferedImage imgA = null;
        BufferedImage imgB = null;
        try {
            File fileA = new File(file1);
            File fileB = new File(file2);
            imgA = ImageIO.read(fileA);
            imgB = ImageIO.read(fileB);
        }
        catch (IOException e) {
            AqualityServices.getLogger().error(e.getMessage());
        }

        int width1 = imgA.getWidth();
        int width2 = imgB.getWidth();
        int height1 = imgA.getHeight();
        int height2 = imgB.getHeight();

        if ((width1 != width2) || (height1 != height2))
            AqualityServices.getLogger().error("Error: Images dimensions mismatch");
        else {
            long difference = 0;
            for (int y = 0; y < height1; y++) {
                for (int x = 0; x < width1; x++) {
                    int rgbA = imgA.getRGB(x, y);
                    int rgbB = imgB.getRGB(x, y);
                    int redA = (rgbA >> RED_VALUE) & HEX_VALUE_OF_255;
                    int greenA = (rgbA >> GREEN_VALUE) & HEX_VALUE_OF_255;
                    int blueA = (rgbA) & HEX_VALUE_OF_255;
                    int redB = (rgbB >> RED_VALUE) & HEX_VALUE_OF_255;
                    int greenB = (rgbB >> GREEN_VALUE) & HEX_VALUE_OF_255;
                    int blueB = (rgbB) & HEX_VALUE_OF_255;

                    difference += Math.abs(redA - redB);
                    difference += Math.abs(greenA - greenB);
                    difference += Math.abs(blueA - blueB);
                }
            }
            double totalPixels = width1 * height1 * TOTAL_PIXELS_MULTIPLIER;
            double avgDifferentPixels = difference / totalPixels;
            return (avgDifferentPixels / AVG_DIFFERENT_PIXELS_DIVIDER) * AVG_DIFFERENT_PIXELS_MULTIPLIER;
        }
        return 0;
    }
}