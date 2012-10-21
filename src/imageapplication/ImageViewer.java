/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageapplication;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author Govind
 */
public class ImageViewer extends JInternalFrame {

    Image image;
    Image image2;
    private JLabel imlabel;
    private ImageIcon imicon;
    int crop=0;

    ImageViewer() {
        imicon = new ImageIcon();
        imlabel = new JLabel();
        SelectImage();
        
        this.setSize(200, 300);
        this.setVisible(true);
        this.setLocation(100, 300);
        this.setTitle("Preview");
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        this.setClosable(true);
        this.setSize(width, height);

        imlabel.setVisible(true);
        this.add(imlabel);
        
        imicon.setImage(image);
        imlabel.setIcon(imicon);
        imlabel.repaint();
        this.repaint();
    }
  
    @Override
    public void repaint() {
       if(image!=null){
            imicon.setImage(image);
            imlabel.setIcon(imicon);
            imlabel.repaint();

         }
       
        super.repaint();
    }

    void preview() {
        imicon.setImage(image2);
        imlabel.setIcon(imicon);
        imlabel.repaint();
    }
    void switchimg(){
        image=image2;
    }

    private void SelectImage() {
        JFrame f = new JFrame();
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);

        String extensions[] ={"gif","jpg","png"};

        chooser.addChoosableFileFilter(new ExampleFileFilter(extensions, "Images"));
        chooser.showOpenDialog(f);
        
        image = Toolkit.getDefaultToolkit().getImage(chooser.getSelectedFile().getPath());
    }    
}
