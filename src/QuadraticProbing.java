public class QuadraticProbing implements HashingTechnique {
    private final String[] table;
    private final int size;
    private int collisions = 0;

    public QuadraticProbing(int size) {
        this.size = size;
        table = new String[size];
    }

    public void insert(String word) {
        int hash = HashUtils.hash(word, size);
        int index = hash;
        int i = 1;

        while (table[index] != null && !table[index].equals(word)) {
            index = (hash + i * i) % size;
            collisions++;
            i++;
            if (i == size) return; // Fail-safe
        }

        table[index] = word;
        System.out.println("Inserted \"" + word + "\" at index " + index + " (Hash: " + hash + ", i=" + i + ")");
    }

    public void display() {
        System.out.println("Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + (table[i] != null ? table[i] : "[empty]"));
        }
        System.out.println("Total collisions: " + collisions);
    }
}
