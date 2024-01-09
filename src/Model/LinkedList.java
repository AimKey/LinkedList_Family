package Model;

import java.util.ArrayList;

/**
 *
 * @author phamm
 */
public class LinkedList {

    Node head, tail;
    public int size;
    Node curPointer;

    public LinkedList() {
        curPointer = head = tail = null;
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void add(Song songData) {
        Node node = new Node(songData, null);
        if (head == null) {
//            If empty, update pHead and pTail point to the new Node
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        updateSize();
    }

    public void add(int index, Song inputData) {
        if (index <= size) {
            Node newNode = new Node(inputData, null);
            Node pre = getNode(index - 1);
            Node after = getNode(index);
            if (head == null || index == 0) {
                addFirst(inputData);
            } else {
//                System.out.println("Pre: " + pre + " After: " + after);
                pre.next = newNode;
                newNode.next = after;
            }
            if (tail.next != null) {
                tail = newNode;
            }
            updateSize();
        } else {
            System.out.println("Exceed size limit!");
            System.exit(1);
        }
    }

    private Node getNode(int index) {
        int count = 0;
        Node pointer = head;
        while (pointer != null) {
            if (count == index) {
                return pointer;
            }
            pointer = pointer.next;
            count++;
        }
        return null;
    }

    public Song get(int index) {
        int count = 0;
        Node pointer = head;
        while (pointer != null) {
            if (count == index) {
                return pointer.dataOfNode;
            }
            pointer = pointer.next;
            count++;
        }
        return null;
    }

    public void addFirst(Song inputData) {
        Node node = new Node(inputData, null);
        if (head == null) {
//            If empty, update pHead and pTail point to the new Node
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        updateSize();
    }

    public int size() {
        return this.size;
    }



    public Song next() {
        if (curPointer == null) {
            return null;
        }
        Song info = curPointer.dataOfNode;
        curPointer = curPointer.next;
        return info;
    }

    public void clear() {
        head = tail = null;
    }

    private void updateSize() {
        this.size++;
    }
}
