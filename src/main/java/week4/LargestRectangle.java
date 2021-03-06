//https://www.hackerrank.com/challenges/largest-rectangle/problem

package week4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        long max=0, minHeight=0, width=0;
        int leftPointer=0, rightPointer=0;
        for(int i=0; i<h.length ; i++) {
            minHeight = h[i];
            width = 0;
            leftPointer = i;
            rightPointer = i;
            //left area
            while(leftPointer >= 0 && (h[leftPointer] >= minHeight)) {
                width++;
                leftPointer--;
            }
            
            //right area
            while(rightPointer < h.length && (h[rightPointer] >= minHeight)) {
                width++;
                rightPointer++;    
            }
            width -= 1;
            max = Math.max(max,(minHeight*width));
        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
