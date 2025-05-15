public class QuadraticProbing {
 static void hashing(int table[], int arr[])
    {

        int tsize = table.length;
                 int n = arr.length;

        for (int i = 0; i < n; i++) {
            int x = arr[i] % tsize;
            if (table[x] == -1) //if the position is empty
                table[x] = arr[i];
            else {

                for (int j = 1; j <= tsize; j++) {
                    //t=(hv+j^2)%tsize
                    int t = (x + j * j) % tsize;
                    if (table[t] == -1) {
                        table[t] = arr[i];
                        break;
                    }
                }
            }
        }

}}

}
