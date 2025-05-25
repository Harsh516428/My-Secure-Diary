import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileHandlerGUI {
    public static void viewAllEntries() {
        File folder = new File("data");
        if (!folder.exists()) {
            JOptionPane.showMessageDialog(null, "No entries found.");
            return;
        }

        StringBuilder allEntries = new StringBuilder();
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            try {
                allEntries.append("---- ").append(file.getName()).append(" ----\n");
                String content = Files.readString(file.toPath());
                allEntries.append(Encryptor.decrypt(content)).append("\n\n");
            } catch (IOException e) {
                allEntries.append("Error reading file ").append(file.getName()).append("\n");
            }
        }

        JTextArea textArea = new JTextArea(allEntries.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "All Entries", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void searchByDate() {
        String date = JOptionPane.showInputDialog("Enter date (YYYY-MM-DD):");
        if (date == null || date.isEmpty()) return;

        Path path = Path.of("data", date + ".txt");
        if (!Files.exists(path)) {
            JOptionPane.showMessageDialog(null, "No entry found for that date.");
            return;
        }

        try {
            String content = Files.readString(path);
            JTextArea textArea = new JTextArea(Encryptor.decrypt(content));
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Entry for " + date, JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not read the entry.");
        }
    }
}
