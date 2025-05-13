public class LinearProbing implements HashingTechnique {
    private final String[] table;
    private final int size;
    private int collisions = 0;

    public LinearProbing(int size) {
        this.size = size;
        table = new String[size];
    }

    public void insert(String word) {
        int index = HashUtils.hash(word, size);
        int original = index;
        int steps = 0;

        while (table[index] != null && !table[index].equals(word)) {
            index = (index + 1) % size;
            collisions++;
            steps++;
            if (index == original) return; // Full table
        }

        table[index] = word;
        System.out.println("Inserted \"" + word + "\" at index " + index + " (Hash: " + original + ", Steps: " + steps + ")");
    }

    public void display() {
        System.out.println("Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + (table[i] != null ? table[i] : "[empty]"));
        }
        System.out.println("Total collisions: " + collisions);
    }
}
