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
            head = newNode;
            tail = newNode;
            newNode.setNext(head);
        } else {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head);
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

        Node<T> current = head;
        System.out.println("Queue:");
        do {
            System.out.print(current.getDataOfNode()+ " ");
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
