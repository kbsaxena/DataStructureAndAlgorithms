//https://www.hackerrank.com/challenges/tree-top-view/problem

package week5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeTopView {

    /* 
    
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static void topView(Node root) {
        SortedMap<Integer, Integer> printedAtWidth = new TreeMap<>();
    
        Queue<Node> nodes = new LinkedList<>();
        Queue<Integer> widths = new LinkedList<>();
        nodes.add(root);
        widths.add(0);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            Integer width = widths.remove();
            if (node == null) {
                continue;
            }
            if (printedAtWidth.get(width) == null) {
                printedAtWidth.put(width, node.data);
            }
            nodes.add(node.left);
            nodes.add(node.right);
            widths.add(width - 1);
            widths.add(width + 1);
        }
    
        StringBuilder result = new StringBuilder();
        for (Integer key : printedAtWidth.keySet()) {
            result.append(printedAtWidth.get(key)).append(" ");
        }
        System.out.println(result);
      
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }   
}
