package proj;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main {
  private static int count = 0;

  public static void main(String[] args) {
    showPasswordFrame();
  }

  private static void showPasswordFrame() {
    JFrame frame = new JFrame("Enter Password");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Password:");
    label.setBounds(36, 9, 50, 14);
    JPasswordField pass = new JPasswordField(10);
    pass.setBounds(91, 6, 86, 20);
    JButton button = new JButton("Submit");
    button.setBounds(36, 34, 65, 23);
    

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        char[] enteredPass = pass.getPassword();
        String password = new String(enteredPass);

        if (password.equals("bigo143")) {
          frame.dispose();
          showLengthFrame();
        } else {
          JOptionPane.showMessageDialog(null, "Password denied");
        }
      }
    });
    panel.setLayout(null);

    panel.add(label);
    panel.add(pass);
    panel.add(button);
    frame.getContentPane().add(panel);
    
    JButton btnNewButton = new JButton("New button");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		System.exit(count);
    	}
    });
    btnNewButton.setBounds(111, 34, 89, 23);
    panel.add(btnNewButton);
    frame.setSize(300, 100);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  private static void showLengthFrame() {
    JFrame frame = new JFrame("Enter Length");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Enter Length of rectangular wood:");
    JTextField lengthField = new JTextField(10);
    JButton button = new JButton("Submit");
 

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          double length = Double.parseDouble(lengthField.getText());
          frame.dispose();
          showWidthFrame(length);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(null, "Invalid character");
        }
      }
    });

    panel.add(label);
    panel.add(lengthField);
    panel.add(button);
    frame.getContentPane().add(panel);
    frame.setSize(300, 100);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  private static void showWidthFrame(double length) {
    JFrame frame = new JFrame("Enter Width");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Enter Width of rectangular wood:");
    JTextField widthField = new JTextField(10);
    JButton button = new JButton("Submit");

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          double width = Double.parseDouble(widthField.getText());
          frame.dispose();
          showAnswer(length, width);
        } catch (NumberFormatException ex) {
        	
            JOptionPane.showMessageDialog(null, "Invalid character");
          }
        }
      });

      panel.add(label);
      panel.add(widthField);
      panel.add(button);
      frame.getContentPane().add(panel);
      frame.setSize(300, 100);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    }

    private static void showAnswer(double length, double width) {
      double area =  2 * (length + width) ;
      JOptionPane.showMessageDialog(null, "Area of rectangular wood is: " + area);
      count++;
      showRepeatFrame();
    }

    private static void showRepeatFrame() {
      JFrame frame = new JFrame("Repeat Program?");
      JPanel panel = new JPanel();
      JLabel label = new JLabel("Do you want to repeat the program? (y/n)");
      JTextField repeatField = new JTextField(10);
      JButton button = new JButton("Submit");

      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String repeat = repeatField.getText();

          if (repeat.equalsIgnoreCase("y")) {
            frame.dispose();
            showLengthFrame();
          } else if (repeat.equalsIgnoreCase("n")) {
            JOptionPane.showMessageDialog(null, "Program repeated " + count + " times. Exiting.");
            System.exit(0);
          } else {
            JOptionPane.showMessageDialog(null, "Invalid input");
          }
        }
      });

      panel.add(label);
      panel.add(repeatField);
      panel.add(button);
      frame.getContentPane().add(panel);
      frame.setSize(300, 100);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    }
  }

