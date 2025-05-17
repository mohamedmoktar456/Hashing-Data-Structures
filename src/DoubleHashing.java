ublic class DoubleHashing {
    public static final int DEFAULT_CAPACITY = 53;
    public final int capacity;
    public final String[] table;
    public final boolean[] isDeleted;
    public int size;
    public int collisions;

    public DoubleHashing(int capacity, String[] table, boolean[] isDeleted) {
        this.capacity = capacity;
        this.table = table;
        this.isDeleted = isDeleted;
    }


    // Hash function 1: main hash
    public int hashFun1(String key) {
        return HashUtils.hash(key, capacity);
    }

    // Hash function 2: step size for probing
    public int hashFun2(String key) {
        return capacity - (Math.abs(key.hashCode()) % capacity);
    }

    // Insert element into the hash table
    public void insert(String key) {
        if (size >= capacity) {
            System.out.println("Table is full");
            return;
        }

        int index = hashFun1(key);
        int step = hashFun2(key);
        int i = 1;

        while (table[index] != null && !isDeleted[index]) {
            if (table[index].equals(key)) {
                return; 
            }
            collisions++;
            index = (index + i * step) % capacity;
            i++;
        }

        table[index] = key;
        isDeleted[index] = false;
        size++;
    }

    // Check if key exists
    public boolean isContains(String key) {
        int index = findIndex(key);
        return index != -1;
    }

    // Delete an element
    public void delete(String key) {
        int index = findIndex(key);
        if (index != -1) {
            isDeleted[index] = true;
            size--;
        }
    }

    // Internal: find index of a key
    public int findIndex(String key) {
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

    // Optional: Get number of collisions
    public int getCollisions() {
        return collisions;
    }

    // Optional: Get current size
    public int getSize() {
        return size;
    }
}

