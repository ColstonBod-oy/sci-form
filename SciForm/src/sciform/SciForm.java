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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
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
    ImageLabel emblem = new ImageLabel("emblem.png", 190, 38, 100, 100);
    JTextField textField1 = new JTextField();
    SciTextField name = new SciTextField(this, textField1, "name", 115, 144, 250, 40);
    JComboBox comboBox1 = new JComboBox(new String[] {"male", "female", "others"});
    SciComboBox gender = new SciComboBox(this, comboBox1, "gender", 115, 184, 107, 40);
    JTextField textField2 = new JTextField();
    SciTextField religion = new SciTextField(this, textField2, "religion", 233, 184, 132, 40);
    JTextField textField3 = new JTextField();
    SciTextField nationality = new SciTextField(this, textField3, "nationality", 115, 224, 250, 40);
    JTextField textField4 = new JTextField();
    SciTextField username = new SciTextField(this, textField4, "username", 115, 284, 250, 40);
    JTextField textField5 = new JTextField();
    SciTextField emailAddress = new SciTextField(this, textField5, "email address", 115, 324, 250, 40);
    JPasswordField passwordField1 = new JPasswordField();
    SciPasswordField password = new SciPasswordField(this, passwordField1, "password", 115, 364, 250, 40);
    JPasswordField passwordField2 = new JPasswordField();
    SciPasswordField confirmPassword = new SciPasswordField(this, passwordField2, "confirm password", 115, 404, 250, 40);
    JTextArea textArea1 = new JTextArea();
    SciTextArea subjectComment = new SciTextArea(this, textArea1, "Tell me something\nabout the subject?", 115, 444, 250, 200);
    JButton button1 = new JButton();
    SciButton register = new SciButton(button1, "register", 145, 662, 190, 50);
    
    public MainPanel() throws FontFormatException, IOException {
        add(register.getComponent());
        add(subjectComment.getComponent());
        add(confirmPassword.getComponent());
        add(password.getComponent());
        add(emailAddress.getComponent());
        add(username.getComponent());
        add(nationality.getComponent());
        add(religion.getComponent());
        add(gender.getComponent());
        add(name.getComponent());
        add(emblem);
        setLayout(null);
        setBackground(Color.decode("#d1f7ff"));
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

class ImageLabel extends JLabel {
    public ImageLabel(String imgFile, int x, int y, int width, int height) throws IOException {
        setBounds(x, y, width, height);
        BufferedImage img = ImageIO.read(getClass().getResource("/sciform/assets/" + imgFile));
        Image dimg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ico = new ImageIcon(dimg);
        setIcon(ico);
    }
}
