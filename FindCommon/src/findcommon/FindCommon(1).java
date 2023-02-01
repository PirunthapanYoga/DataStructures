package findcommon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class FindCommon {

    public static void PrintArray(int[] sort, int k) {
        for (int i = 0; i < k; i++) {
            System.out.print(sort[i] + "\t");
        }
        System.out.println();
    }

    public static int Random(int p, int r) {
        Random R = new Random();
        int k = p + R.nextInt(r - p);
        return k;
    }

    private static int Partition(int[] A, int p, int r) {
        int pivot = A[p];
        int low = p + 1;
        int high = r;

        while (high > low) {

            while (low < high && A[low] < pivot) {
                low++;
            }

            while (low < high && A[high] >= pivot) {
                high--;
            }

            if (high > low) {
                int temp = A[high];
                A[high] = A[low];
                A[low] = temp;
            }
        }
        while (high > p && A[high] >= pivot) {
            high--;
        }

        if (pivot > A[high]) {
            A[p] = A[high];
            A[high] = pivot;
            return high;
        } else {
            return p;
        }

    }

    public static void RandomizedQuicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = Partition(A, p, r);
            RandomizedQuicksort(A, p, q - 1);
            RandomizedQuicksort(A, q + 1, r);
        }
    }

    public static void BinSearch(int[] array2, int start, int end, int a1) {
        if (end - start != 1) {
            int c = (end - start) / 2 + start;
            if (array2[c] == a1) {
                System.out.println("Match found :- " + a1);
            } else if (array2[c] > a1) {
                BinSearch(array2, start, c, a1);
            } else if (array2[c] < a1) {
                BinSearch(array2, c, end, a1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Elments int the first Array (Small array) (n1,n2,n3....) - \n");
        String string1 = Read.readLine();
        System.out.println("Elments int the first Array (Bigger array) (n1,n2,n3...) - \n");
        String string2 = Read.readLine();
        int m = string1.split(",").length;
        int n = string2.split(",").length;
        int[] array1 = new int[m];
        int[] array2 = new int[n];
        String[] data1 = string1.split(",");
        String[] data2 = string2.split(",");

        for (int i = 0; i < m; i++) {
            array1[i] = Integer.parseInt(data1[i]);
        }
        
        for (int i = 0; i < n; i++) {
            array2[i] = Integer.parseInt(data2[i]);
        }
        
        RandomizedQuicksort(array1, 0, m - 1);
        RandomizedQuicksort(array2, 0, n - 1);

        PrintArray(array1, m);
        PrintArray(array2, n);
        
        for (int i = 0; i < m; i++) {
            BinSearch(array2, 0, n - 1, array1[i]);
        }

    }
}
