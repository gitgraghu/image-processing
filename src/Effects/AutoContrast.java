/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Effects;

/**
 *
 * @author Govind
 */
public class AutoContrast implements Effects{
 int normal=128; int approach=50;
 public AutoContrast(){}
 public AutoContrast(int n,int a)
 {normal =n;approach=a;}
private int mod(int num)
{
   int pos;
   if(num>=0) pos=num;
   else pos=(-1)*num;
   return pos;
}
private int nearest(int r,int a,int b)
{
    if(mod(r-a)<mod(r-b)) return a;
    else return b;
}

    public void Filter(int[] pixels, int width, int height, int sliderval) {

 int stdevr=0,stdevg=0,stdevb=0;

 int[] histr=new int[256],histg=new int[256],histb=new int[256];
 for(int i=0;i<width*height;i++){
       int p = pixels[i];
       int red =(0xff & (p>>16));
       int green = (0xff & (p>>8));
       int blue = (0xff & p);
       histr[red]++;histb[blue]++;histg[green]++;
 }
  for(int i=0;i<256;i++){
stdevr+=i*(histr[i]-normal);
stdevg+=i*(histg[i]-normal);
stdevb+=i*(histb[i]-normal);
}

stdevr=stdevr/(width*height);
stdevg=stdevg/(width*height);
stdevb=stdevb/(width*height);
int stdev=(stdevr+stdevg+stdevb)/3;
int span=stdev-nearest(stdev,normal/2,3*normal/2);
int decrease=span*approach/100;

        for (int i = 0; i < width * height; i++) {
            pixels[i] = ProcessPixel(pixels[i],decrease);
        }
    }

    public int ProcessPixel(int pixel,int decrease) {

       int red =(0xff & (pixel>>16));
       int green = (0xff & (pixel>>8));
       int blue = (0xff & pixel);

    red-=decrease;
    green-=decrease;
    blue-=decrease;

       if (red > 255) red =255;if(red<0) red=0;
       if (green > 255) green=255;if(green<0) green=0;
       if (blue >255) blue =255;if(blue<0) blue=0;
       pixel = (0xff000000 | red << 16 | green <<8 | blue);
       return pixel;
    }

    public int ProcessPixel(int pixel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}

