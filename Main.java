public class Main {
    public static void main(String[] args) {
        // Ensure GUI is created on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> new LoginGUI());
    }
}
