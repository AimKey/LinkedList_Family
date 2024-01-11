package Model;

public class CircularLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private Node<T> currentPlayer;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data, null, null);
        if (isEmpty()) {
            // If the list is empty, set the new node as both the head and the tail,
            // and connect it to itself in both directions to form a circular structure
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.pre = tail;
        } else {
            // If the list is not empty, set the new node's previous reference to the current tail,
            // connect the current tail's next reference to the new node, and update the tail to the new node
            // then connect the last and first nodes to maintain the circular structure
            newNode.pre = tail;
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
            head.pre = tail;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        // Retrieve the data of the element at the front of the queue.
        // If there is only one element in the queue, reset both head and tail to null.
        T data = head.dataOfNode;
        if (head == tail) {
            head = null;
            tail = null;
            currentPlayer = null; // Reset currentPlayer when queue becomes empty
        } else {
            // Move the head to the next element and update the circular links accordingly.
            head = head.next;
            tail.next = head;
            head.pre = tail;
        }

        // Update currentPlayer if it was pointing to the dequeued player
        if (currentPlayer != null && currentPlayer.getDataOfNode().equals(data)) {
            currentPlayer = head;
        }

        return data;
    }

    public void viewQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty(move to next player or add player)");
            return;
        }
        // Start from the head and traverse the circular list
        Node<T> current = head;
        System.out.println("Queue:");
        do {
            System.out.print(current.getDataOfNode() + " ");
            current = current.getNext();
        } while (current != head);
        System.out.println();
    }

    public void moveToNextPlayer() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        if (currentPlayer == null) {
            // Set the first player as the current player
            currentPlayer = head;
        } else {
            // Move to the next player
            currentPlayer = currentPlayer.next;
        }

        System.out.println("Current player: " + currentPlayer.getDataOfNode());
    }
}
