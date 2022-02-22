/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sciform;

import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class SciForm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FontFormatException, IOException {
        new SciRegisterForm();
    }
    
}

class ImageLabel extends JLabel {
    public ImageLabel(String imgFile, int x, int y, int width, int height) throws IOException {
        setBounds(x, y, width, height);
        BufferedImage img = ImageIO.read(getClass().getResource("/sciform/assets/" + imgFile));
        Image dimg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ico = new ImageIcon(dimg);
        setIcon(ico);
    }
}
