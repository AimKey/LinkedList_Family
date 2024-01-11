package Model;

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
//        Create a new node with it's previous pointer point to the tail
        Node node = new Node(itemData, null, tail);
        if (head == null) {
            curPointer = head = tail = node;
        } else {
//            If the item is exist, only increment item count
            Item item = getItemByName(itemData.name);
            if (item == null) {
//                Move up the tail
                tail.next = node;
                tail = node;
            } else {
                item.addCount();
            }
        }
        updateSize();
    }

/**
 * Add Item to the first location in the list
 * @param inputData 
 */
    public void addFirst(Item inputData) {
        Node node = new Node(inputData, head, null);
        if (head == null) {
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
/**
 * Iterate through the list and return the Item object if the names are matched
 * @param itemName
 * @return
 */
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

    /**
     * Add Item based on index
     * @param index
     * @param itemData
     * @throws Exception 
     */
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
/**
 * Get a node at any location
 * @param index
 * @return Node
 */
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
/**
 * Get an Item object at any location
 * @param index
 * @return 
 */
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
/**
 * Backward current pointer
 * @return 
 */
    public Item prev() {
        if (curPointer == null) {
            return null;
        }
        Item info = (Item) curPointer.dataOfNode;
        curPointer = curPointer.pre;
        return info;
    }
/**
 * Advance current pointer
 * @return 
 */
    public Item next() {
        if (curPointer == null) {
            return null;
        }
        Item info = (Item) curPointer.dataOfNode;
        curPointer = curPointer.next;
        return info;
    }
/**
 * Delete a Node based on the name property of in the node data
 * If the Node is find, link its previous node with its next node together
 * @param itemName
 * @return 
 */
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
