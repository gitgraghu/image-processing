/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Effects;

import java.awt.Color;

/**
 *
 * @author Govind
 */
public class Saturation implements Effects {

    private int value;


    public void Filter(int pixels[], int width, int height, int sliderval) {

        value = sliderval;

        for (int i = 0; i < width * height; i++) {
            pixels[i] = ProcessPixel(pixels[i]);
        }

    }

    public int ProcessPixel(int pixel) {
        int red = (0xff & (pixel >> 16));
        int green = (0xff & (pixel >> 8));
        int blue = (0xff & pixel);

  float hsb[] = Color.RGBtoHSB(red, green, blue, null);
 hsb[1]=hsb[1]+(value/100.0f);
  pixel = Color.HSBtoRGB(hsb[0],hsb[1],hsb[2]);
   red = (0xff & (pixel >> 16));
   green = (0xff & (pixel >> 8));
   blue = (0xff & pixel);
        if (red > 255) {
            red = 255;
        }
        if (red < 0) {
            red = 0;
        }
        if (green > 255) {
            green = 255;
        }
        if (green < 0) {
            green = 0;
        }
        if (blue > 255) {
            blue = 255;
        }
        if (blue < 0) {
            blue = 0;
        }
        pixel = (0xff000000 | red << 16 | green << 8 | blue);
        return pixel;
    }
}
