package Common;

import Model.Node;

public class Algorithm {

    public void display(Node head) {
        Node pointer = head;
        int count = 0;
        while (pointer != null) {
            count++;
            System.out.println(count + ". " + pointer.getDataOfNode() + " ");
            pointer = pointer.getNext();
        }
    }
}
