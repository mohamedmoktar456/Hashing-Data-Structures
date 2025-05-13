public class DoubleHashing implements HashingTechnique {
    private final String[] table;
    private final int size;
    private int collisions = 0;

    public DoubleHashing(int size) {
        this.size = size;
        table = new String[size];
    }

    private int hash2(String key) {
        int h = HashUtils.hash(key, size);
        return 97 - (h % 97);
    }

    public void insert(String word) {
        int hash1 = HashUtils.hash(word, size);
        int hash2 = hash2(word);
        int index = hash1;
        int i = 0;

        while (table[index] != null && !table[index].equals(word)) {
            collisions++;
            i++;
            index = (hash1 + i * hash2) % size;
            if (i == size) return; // Fail-safe
        }

        table[index] = word;
        System.out.println("Inserted \"" + word + "\" at index " + index + " (Hash1: " + hash1 + ", Hash2: " + hash2 + ", i=" + i + ")");
    }

    public void display() {
        System.out.println("Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + (table[i] != null ? table[i] : "[empty]"));
        }
        System.out.println("Total collisions: " + collisions);
    }
}
