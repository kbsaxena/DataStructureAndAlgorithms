//https://www.hackerrank.com/challenges/encryption/problem

package week1.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encyption {

    //Complete the encryption function below.
    static String encryption(String s) {
        StringBuilder sb = new StringBuilder();
        int row = (int)Math.floor(Math.sqrt(s.length()));
        int column = (int)Math.ceil(Math.sqrt(s.length()));
        if (row * column < s.length()) row = column;
        for(int i = 0; i < column; i++){
            for(int j = i; j < s.length(); j = j + column ){
                sb.append(s.charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
