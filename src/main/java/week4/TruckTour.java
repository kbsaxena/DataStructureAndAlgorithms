//https://www.hackerrank.com/challenges/truck-tour/problem

package week4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TruckTour {

    /*
     * Complete the truckTour function below.
     */
    static int truckTour(int[][] petrolpumps) {
        /*
         * Write your code here.
         */
         long tank = 0;
         int start = 0, positionOfPP = 0, i = 0;
         while(i < petrolpumps.length+start){
            if(positionOfPP == petrolpumps.length)
                positionOfPP = 0; 
            
            int petrol = petrolpumps[positionOfPP][0]; 
            int distance = petrolpumps[positionOfPP][1];

            tank = tank - distance + petrol; 
            if(tank < 0){
                start = positionOfPP+1;
                tank = 0;
            }

            i++;
            positionOfPP++;
        }
        return start;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

