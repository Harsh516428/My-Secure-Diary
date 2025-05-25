public class Encryptor {
    private static final int SHIFT = 3;

    public static String encrypt(String text) {
        return shift(text, SHIFT);
    }

    public static String decrypt(String text) {
        return shift(text, -SHIFT);
    }

    private static String shift(String input, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
