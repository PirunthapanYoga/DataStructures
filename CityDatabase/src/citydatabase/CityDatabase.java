package citydatabase;

import java.io.*;

/**
 *
 * @author 2017e082
 */
public class CityDatabase {

    // roote Node
    static Node root, handler = null;

    // Object Node
    public static class Node {

        String name;
        int x;
        int y;

        Node left = null;
        Node right = null;
        Node parent = null;

        public Node(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

    }

    // add element

    public static void binarySearch(String[] data) {
        Node newNode = new Node(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        Node node = root;

        while (true) {

            if (root == null) {
                root = newNode;
                break;
            }

            if (0 < node.name.compareTo(data[0])) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = newNode;
                    node.left.parent = node;
                    break;
                }
            }

            if (0 > node.name.compareTo(data[0])) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = newNode;
                    node.right.parent = node;
                    break;
                }
            }

            if (data[0].equals(node.name)) {
                break;
            }

        }
    }

    // delete an element
    public static void delete(String key) {

        Node current = search(key);

        if (current != null) {

            //delete leaf
            if (current.left == null && current.right == null) {

                delLeaf(current);

                //delete node with two children   
            } else if (current.left != null && current.right != null) {

                delChildren(current);

                //delete node with left child
            } else if (current.right == null) {

                delChildL(current);

                //delete node with right child
            } else if (current.left == null) {

                delChildR(current);

            }
        }
    }

    //delete by coordinate
    public static void delete(int x, int y) {
        Node current = search(x, y);

        if (current != null) {

            //delete leaf
            if (current.left == null && current.right == null) {

                delLeaf(current);

                //delete node with two children   
            } else if (current.left != null && current.right != null) {

                delChildren(current);

                //delete node with left child
            } else if (current.right == null) {

                delChildL(current);

                //delete node with right child
            } else if (current.left == null) {

                delChildR(current);

            }
        }
    }

    //delete node wuth only left child
    private static void delChildL(Node current) {
        current.left.parent = current.parent;

        if (current.parent.left == current) {
            current.parent.left = current.left;

        } else if (current.right == current) {
            current.parent.right = current.left;
        }
    }

    //delete node with only right child
    private static void delChildR(Node current) {
        current.right.parent = current.parent;

        if (current.parent.left == current) {
            current.parent.left = current.right;

        } else if (current.right == current) {
            current.parent.right = current.right;
        }
    }

    //delete node with 2 children
    private static void delChildren(Node current) {

        handler = current.left;

        while (true) {
            System.out.println("handelr " + handler.name);

            if (handler.right != null) {
                handler = handler.right;
            } else if (handler.left != null) {
                handler.parent.right = handler.left;
                handler.left.parent = handler.parent;
                break;
            } else if (handler.left == null && handler.right == null) {

                if(handler.parent.left==handler){
                    handler.parent.left = null;
                }else if(handler.parent.right==handler){
                    handler.parent.right = null;
                }
                break;
            }
        }

        current.name = handler.name;
        current.x = handler.x;
        current.y = handler.y;

    }

    //delete leaf
    private static void delLeaf(Node current) {
        if (current.parent.left == current) {
            current.parent.left = null;

        } else if (current.parent.right == current) {
            current.parent.right = null;

        }
    }

    // search call for coordinate
    public static Node search(int x, int y) {
        Node m = searchCoord(root, x, y);
        if (m != null) {
            System.out.println("------Match found------\n" + m.name + "\tx:" + m.x + "\ty:" + m.y);
        } else {
            System.out.println("------Match not found------");
        }
        handler = null;
        return m;

    }

    // search call for name
    public static Node search(String key) {
        Node m = searchName(root, key);
        if (m != null) {
            System.out.println("------Match found------\n" + m.name + "\tx:" + m.x + "\ty:" + m.y);
        } else {
            System.out.println("------Match not found------");
        }
        handler = null;
        return m;
    }

    // Binary Search by Name
    private static Node searchName(Node current, String key) {

        if (current != null) {
            if (current.name.equalsIgnoreCase(key)) {
                handler = current;
            } else if (current.name.compareTo(key) > 0) {
                searchName(current.left, key);
            } else if (current.name.compareTo(key) < 0) {
                searchName(current.right, key);
            }
        }
        return handler;
    }

    //Binary Search by Coodeinates
    private static Node searchCoord(Node current, int x, int y) {

        if (current != null) {

            if (current.x == x && current.y == y) {
                handler = current;
            } else {
                searchCoord(current.left, x, y);
                searchCoord(current.right, x, y);
            }

        }

        return handler;
    }

    // in-order tarversal
    private static void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            printEntry(node);
            inOrder(node.right);
        }
    }
    
    //find distance calling method
    public static void distance(int x,int y){
        distanceCoords(root,x,y);
    }

    // find distance distance
   private static void distanceCoords(Node node,int x,int y){
        if (node != null) {
            distanceCoords(node.left,x,y);
            System.out.println("Distance to "+ node.name + " : " + Math.sqrt(Math.pow(x-node.x, 2)+Math.pow(y-node.y, 2))) ;
            distanceCoords(node.right,x,y);
        }
    }
    
    // Print
    private static void printEntry(Node k) {
        System.out.println("city Name - " + k.name + " Xcoordinate - " + k.x + " Ycoordinate - " + k.y);
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Total Entries : ");
        int n = Integer.parseInt(read.readLine());
        System.out.println("Enter the Data int the format : city x-coordinate y-coordinate ");
        String[] data;
        for (int i = 0; i < n; i++) {
            data = read.readLine().split(" ");
            binarySearch(data);
        }

        inOrder(root);
        //search("n");
        //search("p");
        //search(5, 6);
        //search(8, 9);
        
        //delete("n");
        //delete("g");
        //delete("p");
        //delete("a");
        //delete("t");
        //delete("b");
        //delete(6, 7);
        //delete(8, 9);
       
        distance(0,0);
        
        //inOrder(root);
        
    }

}
