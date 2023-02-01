package longestcommonsubsequence;

import java.util.*;
import java.io.*;

/**
 *
 * @author 2017e082
 */
public class LongestCommonSubSequence {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    //assign the matrix
    static void assignMatrix(Integer[][] array, String[] word1, String[] word2) {

        for (int i = 0; i < word1.length + 1; i++) {
            array[0][i] = i;
        }

        for (int i = 0; i < word2.length + 1; i++) {
            array[i][0] = i;
        }

        for (int i = 0; i < word2.length + 1; i++) {
            for (int j = 0; j < word1.length + 1; j++) {
                if (array[i][j] == null) {
                    array[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i <= word2.length; i++) {

            for (int j = 1; j < word1.length + 1; j++) {
                if ((j - 1) == 0 && (i - 1) == 0) {

                    if (word1[i - 1].equals(word2[j - 1])) {

                        array[i][j] = 1;

                    } else {

                        array[i][j] = 0;
                    }

                    for (int k = j; k < word1.length + 1; k++) {
                        array[1][k] = array[i][j];
                    }

                    for (int l = 1; l < word2.length + 1; l++) {
                        array[l][1] = array[i][j];
                    }

                } else if ((j - 1) != 0 && (i - 1) != 0) {

                    if (word1[j - 1].equals(word2[i - 1])) {

                        array[i][j] = array[i - 1][j - 1] + 1;

                        for (int k = j; k < word1.length + 1; k++) {
                            array[i][k] = array[i][j];
                        }

                        for (int l = i; l < word2.length + 1; l++) {
                            array[l][j] = array[i][j];
                        }

                    } else {

                        if (array[i][j - 1] > array[i - 1][j]) {

                            if (array[i][j] > array[i][j - 1]) {
                                array[i][j] = array[i][j - 1];
                            }

                        } else {

                            if (array[i - 1][j] > array[i][j]) {
                                array[i][j] = array[i - 1][j];
                            }

                        }

                        for (int k = j; k < word1.length + 1; k++) {
                            array[i][k] = array[i][j];
                        }

                        for (int l = i; l < word2.length + 1; l++) {
                            array[l][j] = array[i][j];
                        }

                    }
                } else {
                    if (word1[j - 1].equals(word2[i - 1])) {
                        array[i][j] = array[i - 1][j] + 1;

                        for (int k = j; k < word1.length + 1; k++) {
                            array[1][k] = array[i][j];
                        }

                        for (int l = i; l < word2.length + 1; l++) {
                            array[l][1] = array[i][j];
                        }

                    }
                }

            }

        }

        System.out.println();
        for (int i = 0; i < word2.length + 1; i++) {
            for (int j = 0; j < word1.length + 1; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("\n");
        }

    }

    //find the available options in the occurences throuth recursion
    static void findLCS(Integer[][] array, String[] word1, String[] word2, Stack s, int i, int j, int k) {

        while (k != 0) {

            if (array[i][j] == array[i - 1][j] && array[i][j] == array[i][j - 1] && array[i][j] != array[i - 1][j - 1]) {

                int l = i;
                int m = j;
                int p = k;

                while (array[l][j] == array[l - 1][j]) {
                    l--;
                }
                
                while (Objects.equals(array[i][m], array[i][m - 1])) {
                    m--;
                }
                
                findLCS(array, word1, word2, (Stack) s.clone(), l, j, p);       //recursion on i-1 direction
                findLCS(array, word1, word2, (Stack) s.clone(), i, m, p);       //recursion on j-1 direction
                break;
            }

            if (array[i][j] == array[i - 1][j] && array[i][j] == array[i][j - 1] && array[i][j] == array[i - 1][j - 1]) {
                i = i - 1;
                j = j - 1;
            }

            if ((array[i][j] - 1) == array[i - 1][j] && (array[i][j] - 1) == array[i][j - 1]) {
                s.push(j);
                i = i - 1;
                j = j - 1;
                k = k - 1;
            }

            if ((array[i][j] - 1) == array[i][j - 1] && array[i][j] == array[i - 1][j]) {
                i = i - 1;
            }

            if ((array[i][j] - 1) == array[i - 1][j] && array[i][j] == array[i][j - 1]) {
                j = j - 1;
            }

            if (i-1 == 0 && j-1==0 && array[i][j] == 1) {
                s.push(i);
                k = k - 1;
            }
        }

        while (!s.empty()) {
            System.out.print(word1[(int) s.pop() - 1]);
        }
        System.out.println();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in)); //buffered reader
        String[] word1 = read.readLine().split("");                                 //word 1
        String[] word2 = read.readLine().split("");                                 //word 2
        Integer[][] array = new Integer[word2.length + 1][word1.length + 1];        //string array
        Stack s = new Stack();                                                      //stack for store index

        assignMatrix(array, word1, word2);                                          //assign table

        int k = array[word2.length][word1.length];                                  //assign last value in the table
        int i = word2.length;                                                       //length of word 2
        int j = word1.length;                                                       //length of word 1
        findLCS(array, word1, word2, s, i, j, k);                                   //function for find longest common occurences
    }
}
