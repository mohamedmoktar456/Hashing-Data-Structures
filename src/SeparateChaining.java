//import java.util.LinkedList;
//
//public class SeparateChainingHash {
//    private LinkedList<String>[] hashtable;
//    private int size;
//
//    public SeparateChainingHash(int size) {
//        this.size = size;
//        hashtable = new LinkedList[size];
//        for (int i = 0; i < size; i++) {
//            table[i] = new LinkedList<>();
//        }
//    }
//
//    private int hash(String key) {
//        return Math.abs(key.hashCode()) % size;
//    }
//
//    public void insert(String key) {
//        int index = hash(key);
//        if (!table[index].contains(key)) {
//            table[index].add(key);
//        }
//    }
//
//    public void display() {
//        for (int i = 0; i < size; i++) {
//            System.out.print("Index " + i + ": ");
//            for (String word : table[i]) {
//                System.out.print(word + " -> ");
//            }
//            System.out.println("null");
//        }
//    }
//}
