public class QuadraticProbing {
    static void hashing(String table[], int arr[]) {
        int tsize = table.length;

        for (int i = 0; i < arr.length; i++) {
            String value = String.valueOf(arr[i]);
            int hash = Math.abs(value.hashCode()) % tsize;

            if (table[hash] == null)  // if the cell is empty
             {
                table[hash] = value;
            }
            else {
                for (int j = 1; j <= tsize; j++) {
                    //t=(hv+j^2)%tsize
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
