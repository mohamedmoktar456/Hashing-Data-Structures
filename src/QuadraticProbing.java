public class QuadraticProbing {
    static void hashing(String table[], int arr[]) {
        int tsize = table.length;

        for (int i = 0; i < arr.length; i++) {
            String value = arr[i];
            int hash = HashUtils.hash(value, tsize);

            if (table[hash] == null) {
                table[hash] = value;
            } else {
                for (int j = 1; j <= tsize; j++) {
                    int t = (hash + j * j) % tsize;
                    if (table[t] == null) {
                        table[t] = value;
                        break;
                    }
                }
            }
        }
    }
}
