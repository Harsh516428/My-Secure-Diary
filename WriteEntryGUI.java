import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.swing.*;

public class WriteEntryGUI {
    public WriteEntryGUI() {
        JFrame frame = new JFrame("Write New Entry");
        JTextArea textArea = new JTextArea(10, 30);
        JButton saveButton = new JButton("Save Entry");

        saveButton.addActionListener(e -> {
            String text = textArea.getText();
            if (text.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Entry cannot be empty.");
                return;
            }
            Entry entry = new Entry(Encryptor.encrypt(text));
            try {
                Files.writeString(Paths.get(entry.getFilename()), entry.format() + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                JOptionPane.showMessageDialog(frame, "Entry saved.");
                frame.dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving entry: " + ex.getMessage());
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JScrollPane(textArea));
        panel.add(saveButton);

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}
