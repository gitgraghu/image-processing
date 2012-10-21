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
public class Granulate implements Effects{


    public void Filter(int[] pixels, int width, int height, int sliderval) {
float tmp;int marked;   int mark[]=new int [width * height];
for (int j = 0; j < 100; j++)
for (int i = 0; i < 100; i++)
{
tmp = (float) (Math.random ( ) * (width * height));
marked = (int) (tmp);
while (mark [marked] == 1)
{
tmp = (float) (Math.random ( ) * (width * height));
marked = (int) (tmp);
}
mark [marked] = 1;
pixels [marked] = pixels [j * width + i];
}
    }

    public int ProcessPixel(int pixel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
