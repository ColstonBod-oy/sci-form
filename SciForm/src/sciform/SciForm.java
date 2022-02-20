/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sciform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class SciForm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FontFormatException, IOException {
        MainPanel mainPanel = new MainPanel();
        JFrame frame = new JFrame("Sci-Form");
        frame.setSize(480, 780);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.setVisible(true);
        
        // Adds excess width and height caused by window borders on the frame to fix offset
        Dimension frameSize = frame.getContentPane().getSize();
        int excessWidth = frame.getWidth() - frameSize.width;
        int excessHeight = frame.getHeight() - frameSize.height;
        frame.setSize(frame.getWidth() + excessWidth, frame.getHeight() + excessHeight);
    }
    
}

class MainPanel extends JPanel {
    ImageLabel emblem = new ImageLabel("emblem.png", 190, 20, 100, 100);
    JTextField textField1 = new JTextField();
    SciTextField name = new SciTextField(this, textField1, "name", 115, 120, 250, 40);
    JTextField textField2 = new JTextField();
    SciTextField name2 = new SciTextField(this, textField2, "name2", 115, 160, 250, 40);
    
    public MainPanel() throws FontFormatException, IOException {
        add(name2.getComponent());
        add(name.getComponent());
        add(emblem);
        setLayout(null);
        setBackground(Color.decode("#d1f7ff"));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        name.drawCircle(g);
        name2.drawCircle(g);
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
