package trucktour;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author 2017e082
 */
public class TruckTour {

    public int startTruckTour(int[][] petrolPump) {
        
        int k=0;                                                                //innitiate counter
        int index = 0;                                                          //innititate index

        for (int j = 0; j < petrolPump.length; j++) {                           //iterate to find all petrol stations if any possible stations found 
            
            index=j;                                                            //assign each station for index
            
            int capacity = petrolPump[j][0];                                    //assign initial capacity
            int distance = petrolPump[j][1];                                    //assign initial distance
            
            for (int i = j; k < petrolPump.length; i++) {                       //travel through all petroll stations if possible 
                
                if (i >= petrolPump.length) {                                   //if index not start from 0 then assign to bo back to make a circle
                    if (capacity < distance) {                                  //check wheather the fuel is enoght to finish the tour
                        index = Integer.MAX_VALUE;                              //if not possible assign index to max value
                        break;                                                  //then break to start from next station
                        
                    } else {                                                            
                        capacity = capacity + petrolPump[i - petrolPump.length][0] - distance;         //calculate capacity value 
                        distance = petrolPump[i - petrolPump.length][1];                               //assign new distance
                    }

                } else {
                    if (capacity < distance) {                                  //check wheather the fuel is enoght to finish the tour
                        index = Integer.MAX_VALUE;                              //if not possible assign index to max value
                        break;                                                  //then break to start from next station  
                    } else {
                        capacity = capacity + petrolPump[i][0] - distance;          //assign remaining fuel
                        distance = petrolPump[i][1];                                //assign next destance
                    }
                    
                }
                
                k++;                                                                //breaking variable count of for loop 
                
            }

            if (index != Integer.MAX_VALUE) {
                break;                                                              // break if found any possible starting point
            }

        }

        return index;                                                               // return result
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolPump = new int[n][2];                                             // assignemt of variable array

        //assignemt of variables
        for (int petrolPumpsRowItr = 0; petrolPumpsRowItr < n; petrolPumpsRowItr++) {
            String[] petrolPumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolPumpsColumnItr = 0; petrolPumpsColumnItr < 2; petrolPumpsColumnItr++) {
                int petrolPumpsItem = Integer.parseInt(petrolPumpsRowItems[petrolPumpsColumnItr].trim());
                petrolPump[petrolPumpsRowItr][petrolPumpsColumnItr] = petrolPumpsItem;
            }
        }

        TruckTour testTour = new TruckTour();                                                                           //inititate class truck tour
        int result = testTour.startTruckTour(petrolPump);                                                               //get the result    

        if(result!=Integer.MAX_VALUE){                                                                                  // check wheather index is integer maximum value
             System.out.println("The smallest index of the petrol pump from which the truck can start the tour is "     //print the least possible start point
                + result);
        }else{
            System.out.println("No possible point to start");                                               // state if no possible outcomes
        }
       
    }
}
