//https://www.hackerrank.com/challenges/array-left-rotation/problem

package week2;
import java.util.Arrays;
import java.util.Scanner;

public class LeftRotation {

    private static void rotate(int[] a, int d) {
        while(d>0) {
            int start = a[0];
            for(int i=0; i<a.length-1; i++) {
                a[i] = a[i+1];
            }
            a[a.length-1] = start;
            d--;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        rotate(a, d);

        Arrays.stream(a).forEach(e->System.out.print(e + " ")); 

        scanner.close();
    }
}

