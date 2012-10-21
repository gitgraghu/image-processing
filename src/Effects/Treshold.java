/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Effects;

/**
 *
 * @author Govind
 */
public class Treshold implements Effects{

    public void Filter(int[] pixels, int width, int height, int sliderval) {
          for (int i = 0; i < width * height; i++) {
            pixels[i] = ProcessPixel(pixels[i]);
        }
    }

    public int ProcessPixel(int pixel) {
       int red =(0xff & (pixel>>16));
       int green = (0xff & (pixel>>8));
       int blue = (0xff & pixel);
       int gr=(int)(0.3*red+0.59*green+0.11*blue);

       int th = 128;
       if(gr>=th)
       {red=250;
        blue=250;
        green=250;}
       else
       {red  = 10;
		green= 10;
		blue = 10;
       }
       if (red > 255) red =255;if(red<0) red=0;
       if (green > 255) green=255;if(green<0) green=0;
       if (blue >255) blue =255;if(blue<0) blue=0;
       pixel = (0xff000000 | red << 16 | green <<8 | blue);
       return pixel;
    }


}
