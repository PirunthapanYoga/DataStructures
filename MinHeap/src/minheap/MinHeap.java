package minheap;

import java.io.*;

/**
 *
 * @author PRINCE_REX 2017E082
 */
public class MinHeap {

    //class minimum heap
    public static class Heap {

        private int[] Heap;
        private int size = 0;
        private final int max_size;

        //constructor
        Heap(int n) {
            max_size = n;
            Heap = new int[max_size + 1];
        }

        //Inserting elements
        public void insert(int element) {
            Heap[size] = element;

            int pos = size;
            while (Heap[(pos - 1) / 2] > Heap[pos]) { // swap the parent with child
                swap(pos, (pos - 1) / 2);
                pos = (pos - 1) / 2;
            }
            size++;

            if (size == max_size && size % 2 == 0) { // set the max vlue for the second child for the one child node
                Heap[size] = Integer.MAX_VALUE;
            }
        }

        //check it is leaf or not
        public boolean isleaf(int n) {
            return size / 2 < n;
        }

        //Heap the elements
        public void minHeap(int parent) {
            if (!isleaf(parent) && parent < size / 2) {
                if (Heap[parent] > Heap[2 * parent + 2] || Heap[parent] > Heap[2 * parent + 1]) {

                    if (Heap[2 * parent + 1] < Heap[2 * parent + 2]) {
                        swap(parent, 2 * parent + 1);
                        minHeap(2 * parent + 1);

                    } else {
                        swap(parent, 2 * parent + 2);
                        minHeap(2 * parent + 2);
                    }
                }
            }
        }

        //call for heapify through all list
        public void minHeap() {
            for (int i = 0; i < (size / 2) - 1; i++) {
                minHeap(i); //Run through all nodes.
            }
        }

        //mofication
        public void action() {
            Heap[0] = (-Heap[0]); 
        }

        //swap the elements int the heap
        public void swap(int n, int m) {
            int temp = Heap[n];
            Heap[n] = Heap[m];
            Heap[m] = temp;
        }

        //Print the heap
        public void print(int n) {
            for (int i = 0; i < size / 2; i++) {
                if (n % 2 == 0 && 2 * i + 2 == size) {
                    System.out.println("i is : " + i + "\tParent : " + Heap[i] + "\tLeft : " + Heap[2 * i + 1]); // added for one child node
                } else { // one node child adjustment child added with integer max value
                    System.out.println("i is : " + i + "\tParent : " + Heap[i] + "\tLeft : " + Heap[2 * i + 1] + "\tRight : " + Heap[2 * i + 2]);
                }
            }

        }
        
        //methode for sum the heap
        public int sum(int n) {
           int sum=0;
            for (int i = 0; i < size ; i++) {
                sum+=Heap[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //Buffered reader initilization
        
        System.out.println("Enter the total elements : "); //insert elemnt amount
        int n = Integer.parseInt(reader.readLine());
        
        System.out.print("Enter the count of operaions : "); // insert operation amount
        int k = Integer.parseInt(reader.readLine()); 
        
        System.out.println("Enter the elements (seperate like (x1,x2...) : "); // Get string input of total data if it exceed the total elemnt but heap array will only take mentioned elemnts
        String data = reader.readLine();
        String[] dataarr= data.split(",");
        
        MinHeap.Heap H = new Heap(n);  // new object heap
        for (int i = 0; i < n; i++) {
            H.insert(Integer.parseInt(dataarr[i]));     //input data in heap array
        }
    
        H.minHeap(); // last heapify after inserting element 
        
        for (int j = 0; j < k; j++) {
            H.action();                 //call for action 
            H.minHeap();                //heapifi the data
        }
        
        H.print(n);
        System.out.println("\nSum is : " + H.sum(n));  //return the sum
    }

}
