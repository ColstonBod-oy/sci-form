/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sciform;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author User
 */
public abstract class SciUI {
    
    public SciUI(JComponent c) throws FontFormatException, IOException {
        Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/sciform/assets/cyberspace.ttf")).deriveFont(10f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        c.setFont(font);
        c.setBackground(Color.decode("#01012b"));
        c.setForeground(Color.decode("#ff160c"));
        
        if (c instanceof JTextArea) {
            c.setBorder(null);
        }
        
        else if (c instanceof JComboBox) {
            c.setBorder(BorderFactory.createCompoundBorder(new SciUI.RoundedBorder(), new EmptyBorder(new Insets(12, 12, 12, 12))));
        }
        
        else {
            c.setBorder(BorderFactory.createCompoundBorder(new SciUI.RoundedBorder(), new EmptyBorder(new Insets(15, 25, 15, 25))));
        }   
    }
    
    // Creates rounded corners for the JComponents
    class RoundedBorder extends AbstractBorder {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(12));
            g2d.setColor(Color.decode("#d1f7ff"));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
        }
    }
    
    public abstract JComponent getComponent();
    public abstract void drawCircle(Graphics g);
    
}




