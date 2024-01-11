package Model;

import java.util.Random;

/**
 *
 * @author phamm
 */
public class LinkedList {

    Node head, tail;
    public int size;
    Node curPointer;

    public LinkedList() {
        head = tail = null;
        curPointer = head;
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

    public Node getCurPointer() {
        return curPointer;
    }

    public void setCurPointer(Node curPointer) {
        this.curPointer = curPointer;
    }

    public int size() {
        return this.size;
    }
//  Copy qua cac linkedlist khac thi nho doi ten
    public void add(Song songData) {
        Node node = new Node(songData, null);
        if (head == null) {
//            If empty, update pHead and pTail point to the new Node
            curPointer = head = tail = node;
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
                pre.next = newNode;
                newNode.next = after;
            }
            if (tail.next != null) {
                tail = newNode;
            }
            updateSize();
        } else {
            throw new Error("Exceed size limit!");
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
                return (Song) pointer.dataOfNode;
            }
            pointer = pointer.next;
            count++;
        }
        return null;
    }

    public Node getPreviousNode(Node node) throws Exception {
        try {
            if (size > 1) {
                Node p = head;
                while (p.next != node) {
                    p = p.next;
                }
                return p;
            } else {
                throw new Exception("List only contain 1 item!");
            }
        } catch (Exception e) {
            throw new Exception("Cannot back further!");
        }
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

    public Song next() {
        if (curPointer == null) {
            return null;
        }
        Song info = (Song) curPointer.dataOfNode;
        curPointer = curPointer.next;
        return info;
    }

    public void clear() {
        head = tail = null;
    }

    private void updateSize() {
        this.size++;
    }

    public void shuffle() {
        Random rand = new Random();
        Node[] nodeArray = toArray();

        if (size > 1) {
            for (int i = size - 1; i > 0; i--) {
                int j = rand.nextInt(i + 1);
                swap(nodeArray, i, j);
            }
        }

        returnToList(nodeArray);
    }

    private Node[] toArray() {
        Node[] nodeArray = new Node[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            nodeArray[index++] = current;
            current = current.getNext();
        }
        return nodeArray;
    }

    private void swap(Node[] nodeArray, int i, int j) {
        Node temp = nodeArray[i];
        nodeArray[i] = nodeArray[j];
        nodeArray[j] = temp;
    }

    private void returnToList(Node[] nodeArray) {
        head = nodeArray[0];
        tail = nodeArray[size - 1];
        tail.setNext(null);

        for (int i = 0; i < size - 1; i++) {
            nodeArray[i].setNext(nodeArray[i + 1]);
        }
    }
}
