package Model;

public class Node<T> {

    T dataOfNode;
    Node next;

    public Node() {
    }

    public Node(T dataOfNode, Node next) {
        this.dataOfNode = dataOfNode;
        this.next = next;
    }

    public T getDataOfNode() {
        return dataOfNode;
    }

    public void setDataOfNode(T dataOfNode) {
        this.dataOfNode = dataOfNode;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "dataOfNode=" + dataOfNode + ", next=" + next + '}';
    }
    

}
