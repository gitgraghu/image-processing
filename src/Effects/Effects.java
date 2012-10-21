/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Effects;

import java.awt.Image;

/**
 *
 * @author Govind
 */
public interface Effects {

    void Filter(int pixels[],int width,int height,int sliderval);
    int ProcessPixel(int pixel);

}
