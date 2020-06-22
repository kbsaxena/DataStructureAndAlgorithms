package temp;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MatrixRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int round = 0;
        int numberofRows = matrix.size();
        int numberofColoumns = matrix.get(0).size();
        
        int runtill = numberofColoumns/2;
        int currentVal = 0;
        
        while(r>0) {
            while(round<runtill) {
                currentVal = matrix.get(round).get(round);

                for(int i=round+1; i<numberofRows-round;i++) {
                    int nextVal = matrix.get(i).get(round);
                    
                    matrix.get(i).set(round, currentVal);
                    currentVal = nextVal;
                }
                
                for(int j=round+1; j<numberofColoumns-round; j++) {
                    int nextVal = matrix.get(numberofRows-(round+1)).get(j);
                    
                    matrix.get(numberofRows-(round+1)).set(j, currentVal);
                    currentVal = nextVal;
                }
                
                for(int i=numberofRows-(round+2); i>=round; i--) {
                    int nextVal = matrix.get(i).get(numberofColoumns-(round+1));
                    
                    matrix.get(i).set(numberofColoumns-(round+1), currentVal);
                    currentVal = nextVal;
                }
                
                for(int j=numberofColoumns-(round+2); j>=round; j--) {
                    int nextVal = matrix.get(round).get(j);
                    
                    matrix.get(round).set(j, currentVal);
                    currentVal = nextVal;
                }
                
                round++;
            }
            
            round = 0;
            r--;
        }
        
        matrix.forEach(list -> {
            list.forEach(a-> System.out.print(a +" "));
            System.out.println();
        });
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

