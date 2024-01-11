package Common;

import Model.Node;
import Model.Song;

public class Algorithm {

    public void display (Node<Song> head) {
        Node<Song> pointer = head;
        int count = 0;
        while (pointer != null) {
            count++;
//            System.out.println(count + ". " + pointer.getDataOfNode() + " ");
            System.out.printf("%d. |Name: %-15s |Duration: %-15d\n", count, pointer.getDataOfNode().getName(), pointer.getDataOfNode().getDuration());
            pointer = pointer.getNext();
        }
    }
}
