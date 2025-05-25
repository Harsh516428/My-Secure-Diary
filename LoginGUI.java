import java.awt.*;
import javax.swing.*;

public class LoginGUI {
    public LoginGUI() {
        JFrame frame = new JFrame("Secure Diary - Login");
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JTextField userField = new JTextField(15);
        JPasswordField passField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Create Account");

        loginButton.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (AccountManager.login(user, pass)) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
                new MainMenuGUI(); // No need to assign to a variable
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Login failed. Check credentials.");
            }
        });

        registerButton.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (AccountManager.register(user, pass)) {
                JOptionPane.showMessageDialog(frame, "Account created successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Username already exists.");
            }
        });

        // Improved layout for better UI
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panel.add(userLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panel.add(userField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        panel.add(passLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(passField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        frame.add(panel);
        frame.setSize(350, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}
