import javax.swing.*;

public class MainMenuGUI {
    public MainMenuGUI() {
        JFrame frame = new JFrame("My Secure Diary - Main Menu");

        JButton writeButton = new JButton("Write New Entry");
        JButton viewButton = new JButton("View All Entries");
        JButton searchButton = new JButton("Search by Date");
        JButton exitButton = new JButton("Exit");

        writeButton.addActionListener(e -> new WriteEntryGUI());
        viewButton.addActionListener(e -> FileHandlerGUI.viewAllEntries());
        searchButton.addActionListener(e -> FileHandlerGUI.searchByDate());
        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Goodbye! \"A day unrecorded is a day forgotten.\"");
            System.exit(0);
        });

        JPanel panel = new JPanel();
        panel.add(writeButton);
        panel.add(viewButton);
        panel.add(searchButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
