/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxoccwithoutspaces;

import java.io.*;

/**
 *
 * @author REX
 */
public class MaxOccWithOutSpaces {

    /**
     * 'c' for store character 'x' is the counter of each chain which stored in
     * 'x' used for counter of linked list which contains the values linked list
     * used for the hash list array of objects used for indexing
     * this program accept spaces also 
     */
    
    public static class Node {

        Node head;

        int x = 0;
        char c;
        Node next;

        Node() {
            x = 1;
        }

        Node(char c) {
            this.c = c;
            this.next = null;

        }

        public void setNode(char c) {
            Node new_node = new Node(c);
            new_node.next = null;

            if (head == null) {
                head = new_node;
            } else {

                Node last = head;
                while (last.next != null) {
                    last = last.next;
                }

                last.next = new_node;
            }

        }

    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Sentence : ");
        String s = reader.readLine();

        Node[] map = new Node[94];                                                          // object array for 96 chracters
        for (int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i)==' '){
                continue;
            }
            int key = (int) s.charAt(i) - 33;                                               //Ascii 32 = "SPACE" to Ascii 126 = "~" so that array 94 index so 127-32-1

            if (map[key] == null) {
                map[key] = new Node();
            } else {
                map[key].setNode(s.charAt(i));
                map[key].x = map[key].x + 1;
            }
        }

        int max = 0;
        int index = 96;
        for (int i = 0; i < 94; i++) {
            if (map[i] != null) {
                if (max < map[i].x) {
                    max = map[i].x;
                    index = i + 33;
                } else if (max == map[i].x && index > i) {
                    index = i + 33;
                }
            }
        }
        
        System.out.println((char) index+ " " + max);
    }
}
