
import java.util.Scanner;

/**
 *
 * @author REX 2017E082
 */
public class JosephusProblem {

    public static class CircularList {          //this is proper code of circular list methoes can be interchangale with circularlist. Optimized version build only for find possible values of count off respected with Last stand position.

        Node head;

        public static class Node {

            Node next;
            Node previous;
            int val;

            //constructor
            Node(int val) {
                this.val = val;
                this.next = null;
                this.previous = null;
            }
        }

        //Insert an item other than  head . 
        public static void addElements(JosephusProblem.CircularList list, int val) {
            Node newNode = new Node(val);
            if (list.head.next == null) {
                list.head.next = newNode;
                list.head.previous = newNode;
                newNode.next = list.head;
                newNode.previous = list.head;
            } else {
                newNode.previous = list.head.previous;
                newNode.next = list.head;
                list.head.previous.next = newNode;
                list.head.previous = newNode;
            }

        }

        //Add the head element
        public static void addHead(JosephusProblem.CircularList list, int i) {
            Node x = new Node(i);
            list.head = x;
        }

        // Print list
        public static void printElement(JosephusProblem.CircularList list) {
            Node x = list.head;
            do {
                System.out.print(x.val + "\t");
                x = x.next;
            } while (x != list.head);
            System.out.println();
        }

        //input of the list throuth loop
        public static void inputLoop(JosephusProblem.CircularList list, int x) {
            for (int i = 1; i <= x; i++) {
                if (i == 1) {                   //for head element
                    CircularList.addHead(list, i);

                } else {                        //for other elements
                    CircularList.addElements(list, i);
                }
            }
        }

        // step to remove a node
        public static void remove(JosephusProblem.CircularList list, int x) {       //common circular list remove element method
            Node newNode = list.head;

            while (list.head != list.head.next) {                                   // if it necessary to remove all elements other than head, head will point head so loop will end with last element 
                if (newNode.val == x) {
                    if (x == list.head.val) {                                       // method to remove head
                        list.head.next.previous = list.head.previous;
                        list.head.previous.next = list.head.next;
                        list.head = list.head.next;
                        System.out.print(x+"\t");
                        break;
                    } else {                                                        // method to remove other elements
                        newNode.next.previous = newNode.previous;
                        newNode.previous.next = newNode.next;
                        System.out.print(x+"\t");
                        break;
                    }
                }
                newNode = newNode.next;                                             //node increment
            }
        }

        //Find Death order for certain count off
        public static void deathOrder(JosephusProblem.CircularList list, int o) {
            Node newNode = list.head;
            while (list.head != list.head.next) {
                for (int i = 1; i < o; i++) {
                    newNode = newNode.next;                                         //node increament from head or next element of last removal
                }
                CircularList.remove(list, newNode.val);                             // call for removal of subject 
                newNode = newNode.next;                                             //node increament
            }
        }
    }

//main method
    public static void main(String[] args) {
        
        JosephusProblem.CircularList list = new JosephusProblem.CircularList();
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the numbers of People : ");
        int x = scan.nextInt();
        System.out.print("Enter the number used for counting off :");
        int o = scan.nextInt();

        JosephusProblem.CircularList.inputLoop(list, x);
        
        System.out.println("Death Order : ");
        JosephusProblem.CircularList.deathOrder(list, o);
        
        System.out.println(list.head.val);
        System.out.println("Last stand position  : " + list.head.val);

    }
}
