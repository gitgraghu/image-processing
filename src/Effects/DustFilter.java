/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Effects;

/**
 *
 * @author Govind
 */
public class DustFilter implements Effects{
    
private int rr,gg,bb,r,g,b;


private int mod(int num)
{
   int pos;
   if(num>=0) pos=num;
   else pos=(-1)*num;
   return pos;
}

    public void Filter(int[] pixels, int width, int height, int sliderval) {

 int normal=128; int approach=50;int sum=0,flag=0;

 for(int ii=width;ii<width*(height-1);ii++){
     int i=ii/width,j=ii%width;
   if(j>0&&j<width-1)
   {rr=0;gg=0;bb=0;
     for(int m=i-1;m<=i+1;m++)
     {
         for(int n=j-1;n<=j+1;n++)
         {
                int c=m*width+n;
                int p = pixels[c];
             if(m!=i||n!=j)
             {
       
                rr+=(0xff & (p>>16));
                gg+=(0xff & (p>>8));
                bb+=(0xff & p);
             }
             else
             {
                r=(0xff & (p>>16));
                g=(0xff & (p>>8));
                b=(0xff & p);
                 
             }
         }
     }
     
     if(mod(r*8-rr)>normal*4||mod(g*8-gg)>normal*4||mod(b*8-bb)>normal*4)
     {
         int red=rr/8;
         int green=gg/8;
         int blue=(bb/8);
if(flag<10)
{
         System.out.println(blue);
         flag++;
}
     if (red > 255) red =255;if(red<0) red=0;
       if (green > 255) green=255;if(green<0) green=0;
       if (blue >255) blue =255;if(blue<0) blue=0;
       pixels[ii] =(0xff000000 | red << 16 | green << 8 | blue);
       //if(flag<10) System.out.println(pixels[ii]);
     }
     }
     
 }

    }

    public int ProcessPixel(int pixel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


  

}
