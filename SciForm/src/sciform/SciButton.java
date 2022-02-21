/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sciform;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author User
 */
public class SciButton extends SciUI {
    
    private JButton c;

    public SciButton(JButton c, String text, int x, int y, int width, int height) throws FontFormatException, IOException {
        super(c);
        this.c = c;
        this.c.setBounds(x, y, width, height);
        this.c.setText(text);
        this.c.setFont(c.getFont().deriveFont(17f));
        this.c.setBackground(Color.decode("#08deea"));
        this.c.setForeground(Color.decode("#01012b"));
        this.c.setBorder(BorderFactory.createCompoundBorder(new SciButton.TriangularBorder(), new EmptyBorder(new Insets(15, 25, 15, 25))));
        
        this.c.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                c.setContentAreaFilled(false);
                c.setOpaque(true);
                c.setBackground(Color.decode("#08deea"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                c.setContentAreaFilled(true);
                c.setBackground(Color.decode("#00fefc"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                c.setBackground(Color.decode("#00fefc"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                c.setBackground(Color.decode("#08deea"));
            }
        });
    }

    @Override
    public JComponent getComponent() {
        return c;
    }

    @Override
    public void drawCircle(Graphics g) {}
    
    // Creates triangular corners for the JComponents
    class TriangularBorder extends AbstractBorder {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(12));
            g2d.setColor(Color.decode("#d1f7ff"));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawRoundRect(x, y, width - 1, height - 1, 50, 50);
        }
    }
    
}
