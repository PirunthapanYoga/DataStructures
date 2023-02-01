package priority.queue;

import java.io.*;

/**
 *
 * @author 2017e082
 */
public class PriorityQueue {

    //implement MaxHeap
    public static class MaxHeap {

        public int[] heap;
        public int size;
        public final int maxsize;

        //constructor for empty heap
        public MaxHeap(int maxsize) {
            this.maxsize = maxsize;
            this.size = 0;
            heap = new int[this.maxsize + 1];
            heap[0] = Integer.MAX_VALUE;
        }

        //insert the element in heap
        public void insert(int element) {
            heap[++size] = element;
            int current = size;
            while (heap[current] > heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        //get a value
        public int getvalue(int n) {
            return heap[n];
        }

        //set a value
        public void setvalue(int n, int val) {
            heap[n] = val;
            maxHeapify(1);
        }

        //return parent value
        private int parent(int position) {
            return position / 2;
        }

        //return child left
        private int leftChild(int position) {
            return (2 * position);
        }

        //return child right
        private int rightChild(int position) {
            return (2 * position) + 1;
        }

        //check position is leaf or not
        private boolean isleaf(int position) {
            return ((position >= size / 2) && (position <= size));
        }

        private void swap(int fpos, int spos) {
            int temp;
            temp = heap[fpos];
            heap[fpos] = heap[spos];
            heap[spos] = temp;
        }

        //recursive to set heap
        private void maxHeapify(int position) {
            if (isleaf(position)) {
                return;
            }
            if (heap[position] < heap[leftChild(position)] || heap[position] < heap[rightChild(position)]) {
                swap(position, leftChild(position));
                maxHeapify(leftChild(position));
            } else {
                swap(position, rightChild(position));
                maxHeapify(rightChild(position));
            }
        }

        
        public int extractmin() {
            for(int i=; i<size/2)
            
        }

        //print the heap
        public void print() {
            for (int i = 1; i < size / 2; i++) {
                System.out.print("Parent : " + heap[i] + " LEFT CHILD : " + heap[2 * i] + "Right Child : " + heap[2 * i + 1]);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of Elements in the array : ");
        int x = Integer.parseInt(Read.readLine());
        System.out.print("Enter the number of Operation : ");
        int k = Integer.parseInt(Read.readLine());

        //in max heap index 0 assigned to max int value.
        
        int n= x+1;
        
        PriorityQueue.MaxHeap heap = new PriorityQueue.MaxHeap(n);

        System.out.print("Enter the elements one by one : ");
        for (int i = 1; i < n; i++) {
            heap.insert(Integer.parseInt(Read.readLine()));
        }

        heap.print();

        for (int i = k; i > 0; i--) {
            int m=heap.extractmin();
            System.out.println("extraced min  = " + m);
            m = (-1 * m);
            heap.insert(m);

        }

        int sum = 0;
        for (int i = 1; i < heap.maxsize; i++) {
            sum = sum + heap.getvalue(i);
            System.out.println("heap value : " + heap.getvalue(i));
            System.out.println("Total sum is = " + sum);
        }

        System.out.println("Total sum is = " + sum);
    }

}
