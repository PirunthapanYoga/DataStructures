package index;

import java.io.*;

public class Index {

    public static void PrintA(int[] A, int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + "\t");
        }
    }

    public static void PrintMatch(int[] A, int N) {
        if (N >= 0) {
            if (A[N] == N) {
                System.out.println("\n[" + N + "] = " + N);
            }
                PrintMatch(A, N - 1);
            }
        }

    public static void main(String[] args) throws IOException {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the elments int the assending order seperate with comos(n1,n2,.....) ");
        String A = Read.readLine();
        int N = A.split(",").length;
        int[] Array = new int[N];
        String[] Data = A.split(",");
        for (int i = 0; i < N; i++) {
            Array[i] = Integer.parseInt(Data[i]);
        }

        PrintA(Array, N);
        PrintMatch(Array, N - 1);

    }

}
