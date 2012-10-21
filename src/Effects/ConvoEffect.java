/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Effects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.ImageObserver;
import java.awt.image.Kernel;

/**
 *
 * @author Govind
 */
public class ConvoEffect {
 BufferedImage bufim;
 float[] kernel;
 BufferedImageOp ConvOp;

public ConvoEffect(String Operation)
 {
     if(Operation.equals("Sharpen"))
     {
      kernel = new float[] {
     0.0f, -1.0f, 0.0f,
    -1.0f, 5.0f, -1.0f,
     0.0f, -1.0f, 0.0f
   };
     }
else if(Operation.equals("Blur"))
     {float num = 1.0f/9.0f;
      kernel = new float[] {
     num, num, num,
     num, num, num,
     num, num, num
};
     }
else if(Operation.equals("Bump"))
     {
      kernel = new float[] {
     0.0f, 0.0f, 0.0f,
     0.0f, 1.0f, 1.0f,
     0.0f, 0.0f,-1.0f
};
     }
else if(Operation.equals("Edge"))
     {
      kernel = new float[] {
     0.0f, -1.0f, 0.0f,
     -1.0f, 4.0f, -1.0f,
     0.0f, -1.0f, 0.0f
};
     }

else if(Operation.equals("Emboss"))
     {
      kernel = new float[] {
     -1.0f, -1.0f, 0.0f,
     -1.0f, 0.0f, 1.0f,
     0.0f, 1.0f, 1.0f
};
      }
else if(Operation.equals("Glow"))
{float num = 1.0f/9.0f;
 kernel = new float[] {
     num, num, num,
     num, 7*num, num,
     num, num, num
};
}
   ConvOp = new ConvolveOp(new Kernel(3, 3,kernel));
 }

public Image Filter(Image image,ImageObserver im)
 {    int width = image.getWidth(null);
      int height = image.getHeight(null);

      bufim = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
     Graphics2D g2d = bufim.createGraphics();
     g2d.drawImage(image,0,0,im);

     image = ConvOp.filter(bufim, null);
     return image;
}

}
