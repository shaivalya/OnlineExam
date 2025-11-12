import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    JTextField userField;
    JPasswordField passField;
    JButton loginButton;
    JLabel statusLabel;

    public LoginPage() {
        setTitle("Online Exam - Login");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        setLocationRelativeTo(null);

        add(new JLabel("Username:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("Password:"));
        passField = new JPasswordField();
        add(passField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        add(loginButton);

        statusLabel = new JLabel("");
        add(statusLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        if (user.equals("student") && pass.equals("123")) {
            dispose();
            new ExamPage();
        } else {
            statusLabel.setText("Invalid credentials!");
        }
    }

    public static void main(String[] args) {
        new LoginPage().setVisible(true);
    }
}
