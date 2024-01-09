package Common;

import Model.Node;

public class Algorithm {

    public void display(Node head) {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.getDataOfNode() + " ");
            pointer = pointer.getNext();
        }
        System.out.println("");
    }
}
