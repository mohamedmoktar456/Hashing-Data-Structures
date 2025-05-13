public class HashUtils {
    private static final int B = 31;
    private static final int M = 1_000_000_009;

    public static int hash(String key, int tableSize) {
        long hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * B + key.charAt(i)) % M;
        }
        return (int)(hash % tableSize);
    }
}
