/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Effects;

/**
 *
 * @author Govind
 */
public class AutoColor implements Effects{

      private int increase;
      private float corr,corg,corb;
      int approach=50;

    public AutoColor() {

    }
      public AutoColor(int a)
      {approach=a;}
    public void Filter(int[] pixels, int width, int height, int sliderval) {

 int normal=128; int sumr=0;int sumg=0;int sumb=0;

 int[] histr=new int[256],histg=new int[256],histb=new int[256];
 for(int i=0;i<256;i++)
 {
     histr[i]=0;
     histg[i]=0;
     histb[i]=0;
 }
 for(int i=0;i<width*height;i++){
       int p = pixels[i];
       int red =(0xff & (p>>16));
       int green = (0xff & (p>>8));
       int blue = (0xff & p);
       histr[red]++;histb[blue]++;histg[green]++;
 }
  for(int i=0;i<256;i++){
sumr=sumr +i*histr[i];
sumg=sumg +i*histg[i];
sumb=sumb +i*histb[i];
}
 
corr=(sumg+sumb)/(1+sumr);
corg=(sumb+sumr)/(1+sumg);
corb=(sumr+sumg)/(1+sumb);

 System.out.println(corr);
System.out.println(corg);
System.out.println(corb);
        for (int i = 0; i < width * height; i++) {
            pixels[i] = ProcessPixel(pixels[i]);
        }
    }

    public int ProcessPixel(int pixel) {

       int red =(0xff & (pixel>>16));
       int green = (0xff & (pixel>>8));
       int blue = (0xff & pixel);

      red+=(int) (red*corr * approach / 100);
    green+=(int) (green*corg * approach / 100);
    blue+=(int) (blue*corb * approach / 100);

       if (red > 255) red =255;if(red<0) red=0;
       if (green > 255) green=255;if(green<0) green=0;
       if (blue >255) blue =255;if(blue<0) blue=0;
       pixel = (0xff000000 | red << 16 | green <<8 | blue);
       return pixel;
    }
    }
