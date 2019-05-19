package ds.linkedlist;

import sun.awt.image.ImageWatched;

public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList linkedList, int data) {
        // Create a new node with given data
        Node newNode = new Node(data);
        newNode.next = null;
        if (linkedList.head == null) {
            linkedList.head = newNode;
        } else {
            // else traverse till to the last node and insert there
            Node last = linkedList.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return linkedList;
    }

    public static void printList(LinkedList list) {
        System.out.println("Linked list: ");
        Node currNode = list.head;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static LinkedList deleteByKey(LinkedList list, int key) {

        Node currNode = list.head; Node prev = null;

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            return list;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println("found and deleted");
        } else {
            System.out.println("not found");
        }
        return list;
    }

    public static LinkedList deleteByKeyNew(LinkedList list, int key) {
        Node currNode  = list.head; // get head node
        Node prev = null;

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            return list;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            prev.next = currNode.next;
        }

        return list;

    }

    public static void main(String[] args) {
//        System.out.println(new LinkedList().head);

        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        //
        // ******INSERTION******
        //

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        printList(list);

        deleteByKey(list, 1);

        printList(list);

    }

}
