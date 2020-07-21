//https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

package week4;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> s1=new Stack<Integer>();
        Stack<Integer> s2=new Stack<Integer>();
        
        value(s1, s2, n, sc);
        
        sc.close();
    }
    
    private static void value(Stack<Integer> s1, Stack<Integer> s2, int n, Scanner sc) {
        int choice=0;
        for(int i=0; i<n; i++) {
            choice = sc.nextInt();
            if(choice==1) {
                s1.push(sc.nextInt());
            }else {
                if(s2.isEmpty()) {
                    while(!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
            }
            
            if(choice==2) {
               s2.pop();
            }
            if(choice==3){
               System.out.println(s2.peek());
            }

        }
    }
}