/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Effects;

import Effects.Effects;

/**
 *
 * @author Govind
 */
public class BlueAdjust implements Effects{
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

        blue = blue + value;

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
