package doublelinkedlist;

import java.io.*;

public class DoubleLinkedList {

    Node head;

    public static class Node {

        Node next;
        Node previous;
        int val;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.previous = null;
        }
    }

    public static void add(DoubleLinkedList list, int val) {

        Node new_node = new Node(val);
        new_node.next = null;
        new_node.previous = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
            last.previous = last;
        }

    }
    
    public static void rem(DoubleLinkedList list,int val)
    {
        Node x=list.head.next;
        while(val==x.val){
            x.previous.next=x.next;
            x.next.previous=x.previous;
            System.out.println(x.val);
            x=x.next;
            System.out.println(x.val);
        }
    }

    public static void Print(DoubleLinkedList list) {
        Node x = list.head;
        while (x != null) {
            System.out.print(x.val + "\t");
            x = x.next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        add(list, 10);
        add(list, 20);
        add(list, 30);
        add(list, 40);
        add(list, 50);
        add(list, 60);
        add(list, 70);
        rem(list, 50);
        //Print(list);
    }

}
