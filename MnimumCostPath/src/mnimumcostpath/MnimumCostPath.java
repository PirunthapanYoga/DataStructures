package mnimumcostpath;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *
 * @author 2017e082
 */
public class MnimumCostPath {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    
    static class Node {
        
    }

    static int paid(int paid, int cost) {
        int currentVal = (cost - paid);
        if (currentVal <= 0) {
            return 0;
        } else {
            paid = paid + currentVal;
            return currentVal;
        }
    }

    static void path(int[] gfrom, int[] gTo, int[] gWeight, int paid) {

    }

    public static void main(String[] args) {

        String[] gNodesEdges = scanner.nextLine().split(" ");
        int gNodes = Integer.parseInt(gNodesEdges[0].trim());
        int gEdges = Integer.parseInt(gNodesEdges[1].trim());

        Integer[] gFrom = new Integer[gEdges];
        Integer[] gTo = new Integer[gEdges];
        Integer[] gWeight = new Integer[gEdges];

        for (int i = 0; i < gEdges; i++) {
            String[] gFromToWeight = scanner.nextLine().split(" ");
            gFrom[i] = Integer.parseInt(gFromToWeight[0].trim());
            gTo[i] = Integer.parseInt(gFromToWeight[1].trim());
            gWeight[i] = Integer.parseInt(gFromToWeight[2].trim());
        }
        
        int paid = 0;

        scanner.close();
    }

}
