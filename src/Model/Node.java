
package Model;

public class Node {
    String dataOfNode;
    Node next;
    
    public Node(){}

    public Node(String dataOfNode, Node next) {
        this.dataOfNode = dataOfNode;
        this.next = next;
    }

    public String getDataOfNode() {
        return dataOfNode;
    }

    public void setDataOfNode(String dataOfNode) {
        this.dataOfNode = dataOfNode;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}