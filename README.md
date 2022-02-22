# Documentation

Documentation for Midterm Lab Quiz#1.

## Groupmates

Colston Bod-oy - Coding  
Jean Delmari Bernal - Documentation

## Output

![Screenshot_1](https://user-images.githubusercontent.com/75562733/155139975-cd273b67-0a75-40b3-aa21-c993122ed0c2.png)

* Contains 1 main class named SciForm, 1 abstract class named SciUI, and 7 additional classes (SciTextField, SciComboBox, SciPasswordField, SciTextArea, SciButton, SciRegisterForm, SciLoginForm).
* Assets: cyberspace.ttf, emblem.png.
```
Whole project with assets: https://github.com/ColstonBod-oy/sci-form
```

### SciForm.java

![Screenshot_2](https://user-images.githubusercontent.com/75562733/155141600-44ba9a06-b400-42c1-bbe4-f1c203db2f56.png)

* The main class of the program that instantiates a SciRegisterForm object.
* Has the ImageLabel class extending the JLabel class which creates the emblem using an ImageIcon.
```
Image dimg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
```
Allows image to automatically adjust to the label's dimensions using a Buffered Image object.

### SciUI.java

![Screenshot_3](https://user-images.githubusercontent.com/75562733/155142890-f0adf7d4-fe53-4d16-b200-c39579cf60e1.png)

* An abstract class that sets the initial font, background, and foreground color.
* Allows the creation of rounded corners based on the passed JComponents using Graphics2D.
* Requires the implementation of the getComponent() and drawCircle(Graphics g) abstract methods.

### SciTextField.java

![Screenshot_4](https://user-images.githubusercontent.com/75562733/155144317-026ef305-914c-4358-8f5d-81e1ae6a3449.png)

* Extends the SciUI abstract class.
* Instantiates custom JTextFields.
```
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
```
This mouse listener, along with key and focus listeners sets the caret's color and visibility, editability, foreground color, circle color, and text based on its isActive state then repaints its JPanel named root. 

### SciComboBox.java

![Screenshot_5](https://user-images.githubusercontent.com/75562733/155147278-12f9e0bd-05f0-4dce-9383-766d6cc6a12c.png)
![Screenshot_6](https://user-images.githubusercontent.com/75562733/155147243-d231fdc6-5275-4d4e-aecf-4e6853c6f27b.png)

* Extends the SciUI abstract class.
* Instantiates custom JComboBoxes.
```
this.text = new JLabel(text);
this.text.setFont(c.getFont());
this.text.setForeground(statusColor);
this.text.setBounds(x + 15, y - 1, width, height);
root.add(this.text);
```
Creates a JLabel based on the passed text to be placed on top of the combo box and temporarily serve as the required field sign when the combo box isn't selected or empty.

### SciPasswordField.java

![Screenshot_7](https://user-images.githubusercontent.com/75562733/155150473-47e86760-2b73-45e5-b702-387b72f3ab2d.png)

* Extends the SciUI abstract class.
* Instantiates custom JPasswordFields.
* Also creates a JLabel to temporarily serve as the required field sign.

### SciTextArea.java

![Screenshot_8](https://user-images.githubusercontent.com/75562733/155152071-acdb37cd-40e3-4298-a40e-badfd3596805.png)
![Screenshot_9](https://user-images.githubusercontent.com/75562733/155152039-d343e37a-50e9-45b0-8c11-96312aa3bc64.png)

* Extends the SciUI abstract class.
* Instantiates custom JTextAreas.
```
scrollPane = new JScrollPane(c);
scrollPane.setBounds(x, y, width, height);
scrollPane.setBorder(null);
scrollPane.setBackground(Color.decode("#01012b"));
scrollPane.setViewportBorder(BorderFactory.createCompoundBorder(new SciTextArea.RoundedBorder(), new EmptyBorder(new Insets(15, 25, 15, 25))));
```
Adds a scroll pane with rounded borders as container to the text area to generate scroll bars when the text comes out of view.

### SciButton.java

![Screenshot_10](https://user-images.githubusercontent.com/75562733/155157123-0dcddc7c-a158-41ca-a02c-ba1d049538ca.png)
![Screenshot_11](https://user-images.githubusercontent.com/75562733/155157150-d6bb914f-d874-443b-976d-d3092baccf20.png)

* Extends the SciUI abstract class.
* Instantiates custom JButtons.
```
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
```
Creates triangular corners instead of rounded ones.

### SciRegisterForm.java

![Screenshot_12](https://user-images.githubusercontent.com/75562733/155159227-cdb65a23-2434-4610-9a0c-7db90da643ad.png)
![Screenshot_13](https://user-images.githubusercontent.com/75562733/155164560-81ee71ad-558c-4b63-822c-b969218aa9d4.png)
![Screenshot_14](https://user-images.githubusercontent.com/75562733/155164589-f1a3ac22-e3a4-4a8b-9667-29c0916aa28f.png)
![Screenshot_15](https://user-images.githubusercontent.com/75562733/155164614-73ef68bc-a94c-4b93-89d0-a8387b1406d8.png)

* Extends the JFrame class.
* Instantiates the register form and adds form components inside a JPanel.
* Creates a mouse clicked listener for the register button.
* Shows a JOptionPane when the fields are empty, short password length, or the password fields doesn't match.

### SciLoginForm.java

![Screenshot_16](https://user-images.githubusercontent.com/75562733/155162702-a285f417-9044-4e52-ab25-4a9f2f616e9e.png)
![Screenshot_17](https://user-images.githubusercontent.com/75562733/155162722-d2ac8853-3366-467e-bb0b-71f3f9620167.png)
![Screenshot_18](https://user-images.githubusercontent.com/75562733/155162743-4af71fb4-2b00-4efe-8266-ea10f885bc07.png)
![Screenshot_19](https://user-images.githubusercontent.com/75562733/155162761-cc0e9173-55ad-423a-af7a-7401edb2ff37.png)

* Extends the JFrame class.
* Instantiates the login form and adds form components inside a JPanel.
* Creates a mouse clicked listener for the login button.
* Shows a JOptionPane when the fields are empty, invalid credentials, or successful login.

### End of Documentation
