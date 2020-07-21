//https://www.hackerrank.com/challenges/maximum-element/problem

package week4;

import java.util.Scanner;
import java.util.Stack;

public class MaxElement {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);
        while(n-->0){
            int choice = sc.nextInt();
            if(choice==1){
                stack.push(Math.max(stack.peek(),sc.nextInt()));
            }else if(choice==2){
                stack.pop();
            }else{
                System.out.println(stack.peek());
            }
        }
        
        sc.close();
    }
}