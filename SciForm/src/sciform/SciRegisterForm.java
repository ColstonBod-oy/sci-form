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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class SciRegisterForm extends JFrame {
    
    private SciTextField name;
    private SciComboBox gender;
    private SciTextField religion;
    private SciTextField nationality;
    private SciTextField username;
    private SciTextField emailAddress;
    private SciPasswordField password;
    private SciPasswordField confirmPassword;
    private SciTextArea subjectComment;
    
    public SciRegisterForm() throws FontFormatException, IOException {
        RegisterPanel registerPanel = new RegisterPanel(this);
        setTitle("Sci-Register");
        setSize(480, 780);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(registerPanel);
        setVisible(true);
        
        // Adds excess width and height caused by window borders on the frame to fix offset
        Dimension frameSize = getContentPane().getSize();
        int excessWidth = getWidth() - frameSize.width;
        int excessHeight = getHeight() - frameSize.height;
        setSize(getWidth() + excessWidth, getHeight() + excessHeight);
    }
    
    class RegisterPanel extends JPanel {
        public RegisterPanel(SciRegisterForm registerForm) throws FontFormatException, IOException {
            ImageLabel emblem = new ImageLabel("emblem.png", 190, 38, 100, 100);
            JButton button1 = new JButton();
            SciButton register = new SciButton(button1, "register", 145, 662, 190, 50);
        
            JTextField textField1 = new JTextField();
            name = new SciTextField(this, textField1, "name", 115, 144, 250, 40);
        
            JComboBox comboBox1 = new JComboBox(new String[]{"male", "female", "others"});
            gender = new SciComboBox(this, comboBox1, "gender", 115, 184, 107, 40);
        
            JTextField textField2 = new JTextField();
            religion = new SciTextField(this, textField2, "religion", 233, 184, 132, 40);
        
            JTextField textField3 = new JTextField();
            nationality = new SciTextField(this, textField3, "nationality", 115, 224, 250, 40);
        
            JTextField textField4 = new JTextField();
            username = new SciTextField(this, textField4, "username", 115, 284, 250, 40);
        
            JTextField textField5 = new JTextField();
            emailAddress = new SciTextField(this, textField5, "email address", 115, 324, 250, 40);
        
            JPasswordField passwordField1 = new JPasswordField();
            password = new SciPasswordField(this, passwordField1, "password", 115, 364, 250, 40);
        
            JPasswordField passwordField2 = new JPasswordField();
            confirmPassword = new SciPasswordField(this, passwordField2, "confirm password", 115, 404, 250, 40);
        
            JTextArea textArea1 = new JTextArea();
            subjectComment = new SciTextArea(this, textArea1, "Tell me something\nabout the subject?", 115, 444, 250, 200);
            
            add(emblem);
            add(register.getComponent());
            add(name.getComponent());
            add(gender.getComponent());
            add(religion.getComponent());
            add(nationality.getComponent());
            add(username.getComponent());
            add(emailAddress.getComponent());
            add(password.getComponent());
            add(confirmPassword.getComponent());
            add(subjectComment.getComponent());
            setLayout(null);
            setBackground(Color.decode("#d1f7ff"));
        
            register.getComponent().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (name.getStatusColor().equals(Color.decode("#ff160c")) || 
                            gender.getStatusColor().equals(Color.decode("#ff160c")) || 
                            religion.getStatusColor().equals(Color.decode("#ff160c")) || 
                            nationality.getStatusColor().equals(Color.decode("#ff160c")) || 
                            username.getStatusColor().equals(Color.decode("#ff160c")) || 
                            emailAddress.getStatusColor().equals(Color.decode("#ff160c")) || 
                            password.getStatusColor().equals(Color.decode("#ff160c")) || 
                            confirmPassword.getStatusColor().equals(Color.decode("#ff160c")) || 
                            subjectComment.getStatusColor().equals(Color.decode("#ff160c"))
                        ) {
                        JOptionPane.showMessageDialog(emblem, "Empty fields detected!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                
                    else if (!password.getPassword().equals(confirmPassword.getPassword())) {
                        JOptionPane.showMessageDialog(emblem, "Password fields doesn't match!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                
                    else if (password.getPassword().length() < 8) {
                        JOptionPane.showMessageDialog(emblem, "Password length is too short!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else {
                        try {
                            new SciLoginForm(username.getText(), password.getPassword()).setVisible(true);
                        } catch (FontFormatException ex) {
                            Logger.getLogger(SciRegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(SciRegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        registerForm.dispose();
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
            name.drawCircle(g);
            gender.drawCircle(g);
            religion.drawCircle(g);
            nationality.drawCircle(g);
            username.drawCircle(g);
            emailAddress.drawCircle(g);
            password.drawCircle(g);
            confirmPassword.drawCircle(g);
            subjectComment.drawCircle(g);
        }
    }
    
}


