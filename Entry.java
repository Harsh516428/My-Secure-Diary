import java.time.LocalDateTime;

public class Entry {
    private final String content;
    private final LocalDateTime timestamp;

    public Entry(String content) {
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String format() {
        return "[" + timestamp + "]\n" + content;
    }

    public String getFilename() {
        return "data/" + timestamp.toLocalDate() + ".txt";
    }
}
