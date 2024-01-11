package Model;

public class CircularLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private Node<T> currentPlayer;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (isEmpty()) {
            // If the list is empty, set the new node as both the head and the tail,
            // and connect it to itself in both directions to form a circular structure
            head = newNode;
            tail = newNode;
            newNode.setNext(head);
        } else {
            tail.setNext(newNode);
            // If the list is not empty, set the new node's next reference to the head,
            // and update the tail and head references accordingly to maintain the circular structure
            newNode.setNext(head);
            tail = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T data = head.getDataOfNode();
        if (head == tail) {
            head = null;
            tail = null;
            currentPlayer = null; // Reset currentPlayer when queue becomes empty
        } else {
            head = head.getNext();
            tail.setNext(head);
        }

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
            currentPlayer = currentPlayer.getNext();
        }

        System.out.println("Current player: " + currentPlayer.getDataOfNode());
    }
}