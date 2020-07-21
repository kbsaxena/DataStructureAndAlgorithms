//https://www.hackerrank.com/challenges/matrix-rotation-algo/problem

package week1.hard;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatrixRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r, int m, int n) {
        int matrixDiagonalDepth = 0;
        int numberofRows = m;
        int numberofColoumns = n;
        
        int runtill = 0;
        if(numberofRows>=numberofColoumns)
            runtill = numberofColoumns/2;
        if(numberofRows<numberofColoumns)
            runtill = numberofRows/2;
        
        int currentVal = 0;
        
        while(r>0) {
            while(matrixDiagonalDepth<runtill) {
                currentVal = matrix.get(matrixDiagonalDepth).get(matrixDiagonalDepth);

                for(int i=matrixDiagonalDepth+1; i<numberofRows-matrixDiagonalDepth;i++) {
                    int nextVal = matrix.get(i).get(matrixDiagonalDepth);
                    
                    matrix.get(i).set(matrixDiagonalDepth, currentVal);
                    currentVal = nextVal;
                }
                
                for(int j=matrixDiagonalDepth+1; j<numberofColoumns-matrixDiagonalDepth; j++) {
                    int nextVal = matrix.get(numberofRows-(matrixDiagonalDepth+1)).get(j);
                    
                    matrix.get(numberofRows-(matrixDiagonalDepth+1)).set(j, currentVal);
                    currentVal = nextVal;
                }
                
                for(int i=numberofRows-(matrixDiagonalDepth+2); i>=matrixDiagonalDepth; i--) {
                    int nextVal = matrix.get(i).get(numberofColoumns-(matrixDiagonalDepth+1));
                    
                    matrix.get(i).set(numberofColoumns-(matrixDiagonalDepth+1), currentVal);
                    currentVal = nextVal;
                }
                
                for(int j=numberofColoumns-(matrixDiagonalDepth+2); j>=matrixDiagonalDepth; j--) {
                    int nextVal = matrix.get(matrixDiagonalDepth).get(j);
                    
                    matrix.get(matrixDiagonalDepth).set(j, currentVal);
                    currentVal = nextVal;
                }
                
                matrixDiagonalDepth++;
            }
            
            matrixDiagonalDepth = 0;
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

        matrixRotation(matrix, r, m, n);

        bufferedReader.close();
    }
}

