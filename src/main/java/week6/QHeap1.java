//https://www.hackerrank.com/challenges/qheap1/problem
package week6;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class QHeap1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> minHeap = new PriorityQueue<>();

        int q = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            String query = scanner.nextLine().trim();
            char type = query.charAt(0);

            if (query.length() > 1) {
                int num = Integer.parseInt(query.substring(2));
                if (type == '1') {
                    minHeap.add(num);
                } else if (type == '2') {
                    minHeap.remove(num);
                }
            } else {
                System.out.println(minHeap.peek());
            }
        }

        scanner.close();

    }
}
