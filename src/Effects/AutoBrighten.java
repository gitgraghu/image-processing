/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Effects;

/**
 *
 * @author Govind
 */
public class AutoBrighten implements Effects{
private int increase;int normal=150; int approach=20;

public AutoBrighten() {}
public AutoBrighten(int n,int a)
{normal=n;approach=a;}
    public void Filter(int[] pixels, int width, int height, int sliderval) {

 int sum=0;

 int[] histr=new int[256],histg=new int[256],histb=new int[256];
 for(int i=0;i<width*height;i++){
       int p = pixels[i];
       int red =(0xff & (p>>16));
       int green = (0xff & (p>>8));
       int blue = (0xff & p);
       histr[red]++;histb[blue]++;histg[green]++;
 }
  for(int i=0;i<256;i++){
sum=sum +i*(histr[i]+histg[i]+histb[i]);
}
sum=sum/(width*height);
int diff=normal-sum;
increase=diff*approach/100;

        for (int i = 0; i < width * height; i++) {
            pixels[i] = ProcessPixel(pixels[i]);
        }
    }

    public int ProcessPixel(int pixel) {

       int red =(0xff & (pixel>>16));
       int green = (0xff & (pixel>>8));
       int blue = (0xff & pixel);

    red+=increase;
    green+=increase;
    blue+=increase;

       if (red > 255) red =255;if(red<0) red=0;
       if (green > 255) green=255;if(green<0) green=0;
       if (blue >255) blue =255;if(blue<0) blue=0;
       pixel = (0xff000000 | red << 16 | green <<8 | blue);
       return pixel;
    }


}
