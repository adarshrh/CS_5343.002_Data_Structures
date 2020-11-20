package assignment1;
/**
 * Name: Adarsh Raghupati Hegde
 * NetId: axh190002
 */

import java.util.Random;

public class SinglyLinkedList {
    //Variables to store head and tail reference
    Node head, tail;
    int size;

    static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Creates a singly linked list of size n with random numbers.
     * @param n
     */
    SinglyLinkedList(int n) {
        this.size = n;
        Random random = new Random();
        head = new Node(random.nextInt(20), null);
        tail = head;
        for (int i = 1; i < size; i++) {
            int num = random.nextInt(20);
            Node temp = new Node(num, null);
            tail.next = temp;
            tail = tail.next;
        }
    }

    /**
     * Sorts the list and updates the new head node
     */
    public void selectionSort() {
        head = selectionSort(head);
    }

    /**
     * Recursively sorts the list by adjusting the node links
     * @param curHead
     * @return
     */
    public Node selectionSort(Node curHead) {

        if (curHead.next == null)
            return curHead;

        Node minNode = curHead;
        Node prev = null;
        Node ptr = curHead;
     //Find the minimum node and its previous node
        while (ptr.next != null) {

            if (ptr.next.val < minNode.val) {
                minNode = ptr.next;
                prev = ptr;
            }
            ptr = ptr.next;
        }
       //If current head is not the minimum node then swap the node with current head
        if (minNode != curHead)
            curHead = swap(curHead, minNode, prev);

        curHead.next = selectionSort(curHead.next);

        return curHead;
    }

    /**
     * Swaps the minNode with curHead and returns minNode as new head
     * @param curHead
     * @param minNode
     * @param prev
     * @return
     */
    Node swap(Node curHead, Node minNode, Node prev) {
        Node newHead = minNode;
        prev.next = curHead;
        Node temp = minNode.next;
        minNode.next = curHead.next;
        curHead.next = temp;
        return newHead;
    }

    /**
     * Prints the linked list
     */
    public void printlList() {
        Node cur = head;
        boolean isFirst = true;
        while (cur != null) {
            if (isFirst) {
                System.out.print(cur.val);
                isFirst = false;
            } else {
                System.out.print("->" + cur.val);
            }
            cur = cur.next;
        }
    }

    public static void main(String[] arg) {
        SinglyLinkedList sll = new SinglyLinkedList(20);
        System.out.println("Linked list before sorting");
        sll.printlList();
        sll.selectionSort();
        System.out.println();
        System.out.println("Linked list after sorting");
        sll.printlList();
    }
}
