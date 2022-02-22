/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sciform;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class SciComboBox extends SciUI {
    
    private JComboBox c;
    private JLabel text;
    private boolean isActive;
    private Color statusColor;
    
    public SciComboBox(JPanel root, JComboBox c, String text, int x, int y, int width, int height) throws FontFormatException, IOException {
        super(c);
        this.c = c;
        isActive = false;
        statusColor = Color.decode("#ff160c");
        this.c.insertItemAt("", 0);
        this.c.setSelectedIndex(0);
        this.c.setBounds(x, y, width, height);
        this.text = new JLabel(text);
        this.text.setFont(c.getFont());
        this.text.setForeground(statusColor);
        this.text.setBounds(x + 15, y - 1, width, height);
        root.add(this.text);
        
        this.c.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isActive == false) {
                    isActive = true;
                    statusColor = Color.decode("#1afe49");
                    getText().setVisible(!isActive);
                    c.setForeground(statusColor);
                    root.repaint();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (c.getSelectedItem().equals("")) {
                    isActive = false;
                    statusColor = Color.decode("#ff160c");
                    getText().setVisible(!isActive);
                    c.setForeground(statusColor);
                    root.repaint();
                }
            }
        });
    }
    
    @Override
    public JComponent getComponent() {
        return c;
    }

    @Override
    public void drawCircle(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(statusColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(c.getX() - 10, c.getY() + 16, 8, 8);
        g2d.fillOval(c.getX() - 10, c.getY() + 16, 8, 8);
    }
    
    private JLabel getText() {
        return text;
    }
    
    public Color getStatusColor() {
        return statusColor;
    }
    
}
