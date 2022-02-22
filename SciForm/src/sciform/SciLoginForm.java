/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sciform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class SciLoginForm extends JFrame {
    
    private SciTextField username;
    private SciPasswordField password;
    
    public SciLoginForm(String regUsername, String regPassword) throws FontFormatException, IOException {
        LoginPanel loginPanel = new LoginPanel(this, regUsername, regPassword);
        setTitle("Sci-Login");
        setSize(480, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(loginPanel);
        setVisible(true);
        
        // Adds excess width and height caused by window borders on the frame to fix offset
        Dimension frameSize = getContentPane().getSize();
        int excessWidth = getWidth() - frameSize.width;
        int excessHeight = getHeight() - frameSize.height;
        setSize(getWidth() + excessWidth, getHeight() + excessHeight);
    }
    
    class LoginPanel extends JPanel {
        public LoginPanel(SciLoginForm loginForm, String regUsername, String regPassword) throws FontFormatException, IOException {
            ImageLabel emblem = new ImageLabel("emblem.png", 190, 86, 100, 100);
            JButton button1 = new JButton();
            SciButton login = new SciButton(button1, "login", 115, 290, 250, 50);
            
            JTextField textField1 = new JTextField();
            username = new SciTextField(this, textField1, "username", 115, 192, 250, 40);
        
            JPasswordField passwordField1 = new JPasswordField();
            password = new SciPasswordField(this, passwordField1, "password", 115, 232, 250, 40); 
            
            add(emblem);
            add(login.getComponent());
            add(username.getComponent());
            add(password.getComponent());
            setLayout(null);
            setBackground(Color.decode("#d1f7ff"));
        
            login.getComponent().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (username.getStatusColor().equals(Color.decode("#ff160c")) || 
                            password.getStatusColor().equals(Color.decode("#ff160c")) 
                        ) {
                        JOptionPane.showMessageDialog(emblem, "Empty fields detected!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                
                    else if (username.getText().equals(regUsername) && password.getPassword().equals(regPassword)) {
                        JOptionPane.showMessageDialog(emblem, "Successful login!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                
                    else {
                        JOptionPane.showMessageDialog(emblem, "Invalid login!", "Error", JOptionPane.ERROR_MESSAGE);
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
        }
    
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            username.drawCircle(g);
            password.drawCircle(g);
        }
    }
    
}
