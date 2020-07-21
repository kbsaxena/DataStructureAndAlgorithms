//https://www.hackerrank.com/challenges/the-power-sum

package week2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThePowerSum {

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
    // Complete this function
        return calc(X, N, 1);
    }

    static int calc(int x, int n, int num) {
        int numberToN = (int) Math.pow(num, n);
        if (numberToN > x) {
            return 0;
        } else if (numberToN == x) {
            return 1;
        } else {
            return (calc(x, n, num+1) + calc(x-numberToN, n, num+1));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

