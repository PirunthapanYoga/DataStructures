package favoritegame;

import java.util.*;
import java.io.*;

/**
 *
 * @author REX 2017E082
 */
public class FavoriteGame {

    //create hashmap 
    public static void addHash(HashMap Database, HashMap Count, BufferedReader read) throws IOException {

        System.out.print("Total Entries :- ");
        int n = Integer.parseInt(read.readLine());

        String[] data;
        String name, sport;

        System.out.println(":::::::: Enter the Name And sport in upper cases seperate with only one space (NAME SPORT) :::::::: ");
        for (int i = 0; i < n; i++) {
            data = read.readLine().split(" ", 2);

            if ((data[0].length() >= 12) || (data[1].length() >= 12)) {                                                                 //skip if character exceed 12
                System.out.println("Input exceed 12 character long input skipped");
                continue;
            }

            if (Database.containsKey(data[0])) {                                                                                        //skip if key exists
                continue;
            }

            if (!Database.containsKey(data[1])) {                                                                                       //add new ket to Count hashmap
                Count.put(data[1], 0);
            }

            Database.put(data[0], data[1]);                                                                                             //add new key to Database hashmap
        }

    }

    //add the occurrences
    public static void addCount(HashMap Count, String[] cArray) {
        for (Object m : Count.keySet()) {                                                                                           //run through all keyset
            Integer i = 0;
            for (String cArray1 : cArray) {                                                                                         //run through array to find occurances of games
                if (m.toString().equals(cArray1)) {                                                                                 // compare the string and increment in the hashmap
                    i = i + 1;
                    Count.put(m, i);                                                                                                //increment the values
                }
            }
        }
    }

    //find the maximum occurrence in the sport count hashmap
    public static int findMax(HashMap Count) {
        Integer max = 0;

        for (Object m : Count.keySet()) {
            if (Integer.parseInt(Count.get(m).toString()) > max) {
                max = Integer.parseInt(Count.get(m).toString());
            }
        }
        return max;
    }

    //find any same liked games recorded
    public static String findMultiple(HashMap Count, Integer max) {

        String[] same = null;
        String firstGame = null;

        for (Object m : Count.keySet()) {

            if (Count.get(m) == max) {
                if (firstGame == null) {
                    firstGame = m.toString();
                }
                if (firstGame.compareTo(m.toString()) > 0) {
                    firstGame = m.toString();
                    System.out.println(firstGame);
                }
            }
        }
        return firstGame;
    }

    //print the required format
    public static void print(String mostLiked, Integer countFootBall, Integer max) {
        System.out.println("\nMost Liked Game : " + mostLiked + " \tTotal People - " + max);
        System.out.println("People like Football - " + countFootBall);
    }

    //main method
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> Database = new HashMap<>();                                                         // this hashmap's key is Names and value is sport for store datas and doble value entries for the same name if occurs
        HashMap<String, Integer> Count = new HashMap<>();                                                           // this hashmap's key is sport and value is occurances

        addHash(Database, Count, read);                                                                             //method to add datas in hashmap

        String values = Database.values().toString().substring(1, Database.values().toString().length() - 1);       //Extract all values from hashmap and convert interface string to string then remove brackets from substring function
        String[] cArray = values.split(", ");                                                                       //convert string to string array

        addCount(Count, cArray);                                                                                    //set the count hashmap with respectable occurances

        Integer max = findMax(Count);                                                                               //find the maximum in the count hash map

        String mostLikedGame = findMultiple(Count, max);                                                            //find the first game 
        print(mostLikedGame, Count.get("FOOTBALL"), max);
    }
}
