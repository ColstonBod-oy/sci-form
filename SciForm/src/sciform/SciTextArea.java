/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sciform;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author User
 */
public class SciTextArea extends SciUI {
    
    private JTextArea c;
    private JScrollPane scrollPane;
    private boolean isActive;
    private Color statusColor;

    public SciTextArea(JPanel root, JTextArea c, String text, int x, int y, int width, int height) throws FontFormatException, IOException {
        super(c);
        this.c = c;
        isActive = false;
        statusColor = Color.decode("#ff160c");
        this.c.setBounds(x, y, width, height);
        this.c.setCaretColor(Color.decode("#1afe49"));
        this.c.setText(text);
        this.c.setEditable(isActive);
        scrollPane = new JScrollPane(c);
        scrollPane.setBounds(x, y, width, height);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.decode("#01012b"));
        scrollPane.setViewportBorder(BorderFactory.createCompoundBorder(new SciTextArea.RoundedBorder(), new EmptyBorder(new Insets(15, 25, 15, 25))));
        
        this.c.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isActive == false) {
                    isActive = true;
                    statusColor = Color.decode("#1afe49");
                    c.setText("");
                    c.setEditable(isActive);
                    c.getCaret().setVisible(isActive);
                    c.setForeground(statusColor);
                    root.repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        this.c.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && c.getText().equals("")) {
                    isActive = false;
                    statusColor = Color.decode("#ff160c");
                    c.setText(text);
                    c.setEditable(isActive);
                    c.getCaret().setVisible(isActive);
                    c.setForeground(statusColor);
                    root.repaint();
                }
            }
        });
        
        this.c.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                if (c.getText().trim().equals("")) {
                    isActive = false;
                    statusColor = Color.decode("#ff160c");
                    c.setText(text);
                    c.setEditable(isActive);
                    c.getCaret().setVisible(isActive);
                    c.setForeground(statusColor);
                    root.repaint();
                }
            }
        });
    }

    @Override
    public JComponent getComponent() {
        return scrollPane;
    }

    @Override
    public void drawCircle(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(statusColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(scrollPane.getX() - 10, scrollPane.getY() + 16, 8, 8);
        g2d.fillOval(scrollPane.getX() - 10, scrollPane.getY() + 16, 8, 8);
    }
    
    public Color getStatusColor() {
        return statusColor;
    }
    
}
