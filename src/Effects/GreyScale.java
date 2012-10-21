/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Effects;

/**
 *
 * @author Govind
 */
public class GreyScale implements Effects{
    private int value;

    public void Filter(int[] pixels, int width, int height, int sliderval) {
           value = sliderval/50 + 1;
           for(int k=1; k < value; k++){
           for (int i = 0; i < width * height; i++) {
           pixels[i] = ProcessPixel(pixels[i]);
        }
           }
    }

    public int ProcessPixel(int pixel) {
       int red = (0xff & (pixel >> 16));
       int green = (0xff & (pixel >> 8));
       int blue = (0xff & (pixel));
       int avg = (int)((red + green + blue)/3);
       pixel = (0xff000000 | avg <<16 |green << 8 | avg);
       return pixel;
    }


}
