package Common;

import Model.Item;
import Model.Node;
import Model.Song;

public class Algorithm {

    public void displaySongs (Node<Song> head) {
        Node<Song> pointer = head;
        int count = 0;
        while (pointer != null) {
            count++;
            System.out.printf("%d. |Name: %-15s |Duration: %-15d\n", count, pointer.getDataOfNode().getName(), pointer.getDataOfNode().getDuration());
            pointer = pointer.getNext();
        }
    }
    public void displayItems (Node<Item> head) {
        Node<Item> pointer = head;
        int count = 0;
        while (pointer != null) {
            count++;
            System.out.printf("%d. |Name: %-15s |Ammount: %-15d\n", count, pointer.getDataOfNode().getName(), pointer.getDataOfNode().getAmmount());
            pointer = pointer.getNext();
        }
    }
}
