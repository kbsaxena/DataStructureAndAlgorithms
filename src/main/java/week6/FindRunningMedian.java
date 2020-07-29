//https://www.hackerrank.com/challenges/find-the-running-median/problem

package week6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindRunningMedian {

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
        double[] result = new double[a.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i= 0; i < a.length; i++){
            int currentValue = a[i];
            if(minHeap.isEmpty() || currentValue > minHeap.peek()){
               minHeap.add(currentValue);
            }else{
                maxHeap.add(currentValue);
            }
            
            rebalanceHeaps(minHeap, maxHeap);
            result[i] = getMedian(minHeap, maxHeap);
        }
        return result;
    }

    private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
            if(minHeap.size() > maxHeap.size()){
                return (double) minHeap.peek();
            }else if(maxHeap.size() > minHeap.size()){
                return (double) maxHeap.peek();
            }else{
                return ((double)(minHeap.peek() + maxHeap.peek()))/2;
            }
    }
    
    private static void rebalanceHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        while (Math.abs(minHeap.size() - maxHeap.size()) > 1){
            if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }else{
                minHeap.add(maxHeap.poll());
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

