//https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

package week1.easy;

import java.io.IOException;
import java.util.Scanner;

public class Breaking_Best_And_Worst_Records {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int maxCount = 0;
        int minCount = 0;
        
        int max = scores[0];
        int min = scores[0];
        
        int[] a = new int[2];
        
        for(int i=1; i<scores.length;i++) {
            if(scores[i]>max) {
                max = scores[i];
                maxCount++;
            }
            
            if(scores[i]<min) {
                min = scores[i];
                minCount++;
            }
        }
        
        a[0] = maxCount;
        a[1] = minCount;
        
        return a;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        System.out.println(result);
        
        scanner.close();
    }
}

