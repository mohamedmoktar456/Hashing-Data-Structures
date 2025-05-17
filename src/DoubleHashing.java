
public class DoubleHashingHashTable implements HashTable {
    private static final int DEFAULT_CAPACITY = 52;
    private final int capacity;
    private final String[] table;
    private final boolean[] isDeleted;
    private int size;
    private int collisions;

    public DoubleHashingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public DoubleHashingHashTable(int initialCapacity) {
        // Check if capacity greater than 0
       if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity greater than zero");
        }
        this.capacity = initialCapacity;
        this.table = new String[capacity];
        this.isDeleted = new boolean[capacity];
        this.size = 0;
        this.collisions = 0;
    }

    // Hash function 1
    private int hashFun1(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += (int) c; // Caculate ascii
        }
        return hash % capacity;
    }

    //Hash function 2
    private int hashFun2(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += (int) c;
        }
        return capacity - (hash % capacity); // h2 = size - (x % size)
    }

    // to insert element
    public void insert(String key) {
        if (size >= capacity) {
            System.err.println("Table is full");
            return;
        }

        int index = hashFun1(key);
        int step = hashFun2(key);
        int i = 1;

        while (table[index] != null && !isDeleted[index]) {
            if (table[index].equals(key)) {
                return; // element is already exist
            }
            collisions++;
            index = (index + i * step) % capacity;
            i++;
        }

        table[index] = key;
        isDeleted[index] = false;
        size++;
    }

    // is-contains
    public boolean isContains(String key) {
        int index = findIndex(key);
        return index != -1;
    }

    // Delete element
    public void delete(String key) {
        int index = findIndex(key);
        if (index != -1) {
            isDeleted[index] = true;
            size--;
        }
    }


    private int findIndex(String key) {
        int index = hashFun1(key);
        int step = hashFun2(key);
        int i = 1;

        while (table[index] != null) {
            if (!isDeleted[index] && table[index].equals(key)) {
                return index;
            }
            index = (index + i * step) % capacity;
            i++;
        }
        return -1;
    }

    public void printStats() {
        System.out.println("Table statistics\n");
        System.out.println("Capacity: " + capacity);
        System.out.println("Number of element: " + size);
        System.out.println("No of collisions " + collisions);
        System.out.println(" " + (size * 100.0 / capacity) + "%");
    }

    public void printTable() {
        System.out.println(":");
        for (int i = 0; i < capacity; i++) {
            System.out.printf("Index %3d: %s %s%n",
                    i,
                    table[i] != null ? table[i] : "---",
                    isDeleted[i] ? "(DELETED)" : "");
        }
    }


    @Override
    public int getCollisionCount() {
        return 0;
    }

    @Override
    public void printTbale() {

    }

}
