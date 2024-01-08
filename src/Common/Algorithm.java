
package Common;

import Model.Node;

public class Algorithm {
    
    private Node head, tail;
    
    public void add(String inputData){
        Node node = new Node(inputData, null);
        if (head == null){
            head = tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }
    }
}
