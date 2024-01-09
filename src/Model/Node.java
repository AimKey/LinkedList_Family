package Model;

public class Node {

    Song dataOfNode;
    Node next;

    public Node() {
    }

    public Node(Song dataOfNode, Node next) {
        this.dataOfNode = dataOfNode;
        this.next = next;
    }

    public Song getDataOfNode() {
        return dataOfNode;
    }

    public void setDataOfNode(Song dataOfNode) {
        this.dataOfNode = dataOfNode;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
