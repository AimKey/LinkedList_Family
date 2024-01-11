package Model;

import java.util.Random;

/**
 *
 * @author phamm
 */
public class DoublyLinkedList {

    Node head, tail;
    private int size;
    Node curPointer;

    public DoublyLinkedList() {
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

    public void add(Item itemData) {
//        Node: data, nextNode, preNode
        Node node = new Node(itemData, null, tail);
        if (head == null) {
            curPointer = head = tail = node;
        } else {
            Item item = getItemByName(itemData.name);
            if (item == null) {
                tail.next = node;
                tail = node;
            } else {
                item.addCount();
            }
        }
        updateSize();
    }

    public void addFirst(Item inputData) {
        Node node = new Node(inputData, head, null);
        if (head == null) {
//            If empty, update Head and Tail point to the new Node
            head = tail = node;
        } else {
            Item item = getItemByName(inputData.name);
            if (item == null) {
                head.pre = node;
                head = node;
            } else {
                item.addCount();
            }
        }
        updateSize();
    }

    public Item getItemByName(String itemName) {
        Node<Item> pointer = head;
        while (pointer != null) {
            if (itemName == null ? pointer.dataOfNode.name == null : itemName.equals(pointer.dataOfNode.name)) {
                return pointer.getDataOfNode();
            }
            pointer = pointer.next;
        }
        return null;
    }

    public void add(int index, Item itemData) throws Exception {
        if (index <= size) {
            Node nodeAfter = getNode(index);
            Node nodePrev = nodeAfter.pre;
            Node newNode = new Node(itemData, nodeAfter, nodePrev);

            if (head == null || index == 0) {
                addFirst(itemData);
            } else {
                nodePrev.next = newNode;
                nodeAfter.pre = newNode;
            }
            if (tail.next != null) {
                tail = newNode;
            }
            updateSize();
        } else {
            throw new Exception("Exceed size limit!");
        }
    }

    private Node getNode(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        if (index == 0) {
            return this.head;
        }
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

    public Item get(int index) {
        int count = 0;
        Node pointer = head;
        while (pointer != null) {
            if (count == index) {
                return (Item) pointer.dataOfNode;
            }
            pointer = pointer.next;
            count++;
        }
        return null;
    }

    public Item prev() {
        if (curPointer == null) return null;
        Item info = (Item) curPointer.dataOfNode;
        curPointer = curPointer.pre;
        return info;
    }

    public Item next() {
        if (curPointer == null) return null;
        Item info = (Item) curPointer.dataOfNode;
        curPointer = curPointer.next;
        return info;
    }

    public boolean delete(String itemName) {
        Node<Item> nodePointer = head;
        while (nodePointer != null) {
            if (itemName == null ? nodePointer.dataOfNode.name == null : itemName.equals(nodePointer.dataOfNode.name)) {
                Node preNode = nodePointer.pre;
                Node nextNode = nodePointer.next;
                if (preNode == null) {
//                Truong hop Node o dau
                    head = nextNode;
                    head.pre = null;
                } else if (nextNode == null) {
//                Truong hop Node o cuoi
                    tail = preNode;
                    tail.next = null;
                } else {
                    preNode.next = nextNode;
                    nextNode.pre = preNode;
                }
                return true;
            }
            nodePointer = nodePointer.next;
        }
        return false;
    }

    public void clear() {
        head = tail = null;
    }

    private void updateSize() {
        this.size++;
    }
}
