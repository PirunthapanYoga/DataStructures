package josephusproblemoptimized;

import java.util.Scanner;

/**
 *
 * @author REX 2017E082
 */
public class JosephusProblemOptimized {                                            // This code can find all possibility Count Off values if 

    public static class CircularList {

        Node head;

        // Circular node class
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

        //Insert an item 
        public static void addElements(JosephusProblemOptimized.CircularList list, int val) {
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
        public static void addHead(JosephusProblemOptimized.CircularList list, int i) {
            Node x = new Node(i);
            list.head = x;
        }

        // Print list if necessary
        public static void printElement(JosephusProblemOptimized.CircularList list) {
            Node x = list.head;
            do {
                System.out.print(x.val + "\t");
                x = x.next;
            } while (x != list.head);
            System.out.println();
        }

        //input of the list throuth loop
        public static void inputLoop(JosephusProblemOptimized.CircularList list, int x) {
            for (int i = 1; i <= x; i++) {
                if (i == 1) {
                    CircularList.addHead(list, i);

                } else {
                    CircularList.addElements(list, i);
                }
            }
        }

        // step to remove a node
        public static void remove(JosephusProblemOptimized.CircularList list, int x) {
            Node newNode = list.head;

            while (list.head != list.head.next) {

                if (newNode.val == x) {
                    newNode.next.previous = newNode.previous;
                    newNode.previous.next = newNode.next;
                    list.head = newNode.next;
                    break;
                }
                newNode = newNode.next;
            }
        }

        //Find death order
        public static boolean deathOrder(JosephusProblemOptimized.CircularList list, int countOff, int lastStand, boolean print) {
            while (list.head != list.head.next) {
                Node newNode = list.head;
                for (int i = 1; i < countOff; i++) {
                    newNode = newNode.next;
                }
                if (print) {
                    System.out.print(newNode.val + "\t");
                }
                CircularList.remove(list, newNode.val);
            }
            return list.head.val == lastStand;
        }

        //check the count off value for the Last stand
        public static void checkLast(JosephusProblemOptimized.CircularList list1, int people, int lastStand) {
            for (int i = 1; i <= people; i++) {
                if (CircularList.deathOrder(list1, i, lastStand, false)) {

                    System.out.println("Possible Count off value for the LastStand Position is : " + i);
                    JosephusProblemOptimized.CircularList.inputLoop(list1, people);                                        //Regenerate the list for print death order
                    JosephusProblemOptimized.CircularList.deathOrder(list1, i, lastStand, true);                              // true used to enable print in the method deathOrder
                    System.out.print(list1.head.val + "\n");

                }
                JosephusProblemOptimized.CircularList.inputLoop(list1, people);
            }
        }
    }

    public static void main(String[] args) {
        JosephusProblemOptimized.CircularList list1 = new JosephusProblemOptimized.CircularList(); // object cicular list

        Scanner scan = new Scanner(System.in);                                                      // new scaner object

        System.out.print("Enter the numbers of People : ");
        int people = scan.nextInt();

        System.out.print("Enter the person for the last stand : ");
        int lastStand = scan.nextInt();

        JosephusProblemOptimized.CircularList.inputLoop(list1, people);

        System.out.println("Death Order : ");
        JosephusProblemOptimized.CircularList.checkLast(list1, people, lastStand);

    }
}
