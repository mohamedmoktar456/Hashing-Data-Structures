import java.util.LinkedList;

public class SeparateChaining implements HashingTechnique {
    private final LinkedList<String>[] table;
    private final int size;
    private int collisions = 0;

    @SuppressWarnings("unchecked")
    public SeparateChaining(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void insert(String word) {
        int index = HashUtils.hash(word, size);
        if (!table[index].isEmpty()) collisions++;

        if (!table[index].contains(word)) {
            table[index].add(word);
        }
        System.out.println("Inserted \"" + word + "\" at index " + index + " (Chain size: " + table[index].size() + ")");
    }

    public void display() {
        System.out.println("Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + table[i]);
        }
        System.out.println("Total collisions (non-empty chains): " + collisions);
    }
}
