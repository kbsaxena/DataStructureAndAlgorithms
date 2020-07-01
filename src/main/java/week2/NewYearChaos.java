package week2;

import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int temp = 0, count = 0, check =0;
        int[] bribe = new int[1000000];
        boolean isSorted = false;

        while(isSorted != true){
            isSorted = true;
            for(int i=q.length-1; i>0 ; --i){
                if(q[i] < q[i-1]){
                    temp = q[i-1];
                    q[i-1] = q[i];
                    q[i] = temp; 
                    bribe[q[i]]++;
                    count++;
                    if(bribe[q[i]] > 2) {
                        System.out.println("Too chaotic");
                        check++;
                        break;
                    }
                    isSorted = false;
                }
            }
        }
        if(check == 0)
            System.out.println(count);
              
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
