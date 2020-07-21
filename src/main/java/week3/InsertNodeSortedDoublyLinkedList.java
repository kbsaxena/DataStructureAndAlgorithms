//https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem

package week3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertNodeSortedDoublyLinkedList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
        while (current != null) {
            if (current.prev == null && current.data >= data) {
                temp.next = current;
                current.prev = temp;
                head = temp;
                break;
            } else if (current.prev != null && current.prev.data <= data && current.data >= data) { 
                temp.prev = current.prev;
                temp.next = current;
                current.prev.next = temp;
                current.prev = temp;
                break;
            } else if (current.next == null && current.data <= data) { 
                temp.prev = current;
                current.next = temp;
                break;
            }
            
            current = current.next;
        }
        return head;

    }

    private static final Scanner scanner = new Scanner(System.in);