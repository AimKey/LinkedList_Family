package Controller;

import Common.Algorithm;
import Common.Library;
import Model.CircularLinkedList;
import view.Menu;

/**
 *
 * @author Mazl
 */
public class CircularLinkedListController extends Menu<String> {

    private Menu parentMenu;
    private static String[] mc = {"Equeue", "Dequeue", "Move to next player", "View the queue", "back to menu"};
    private Library lib;
    private CircularLinkedList list;
    private Algorithm algo;

    public CircularLinkedListController(Menu parentMenu) {
        super("Game queue", mc, parentMenu);
        this.parentMenu = parentMenu;
        lib = new Library();
        list = new CircularLinkedList();
        algo = new Algorithm();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                enqueue();
                break;
            case 2:
                dequeue();
                break;
            case 3:
                list.moveToNextPlayer();
                break;
            case 4:
                list.viewQueue();
                break;
            case 5:
                returnToPMenu();
                break;
        }
    }

    public void enqueue() {
        String playerName = lib.getString("Enter the name of the player to enqueue");
        // Get the name of the player to enqueue from user input.
        String playerName = lib.getString("Enter the name of the player to enqueue:");
        // Enqueue the player's name and print a confirmation message.
        list.enqueue(playerName);
        System.out.println("Player '" + playerName + "' enqueued");
    }

    public void dequeue() {
        // Dequeue the player's name from the queue.
        String dequeuedPlayer = (String) list.dequeue();
        // Print a confirmation message if a player was dequeued.
        if (dequeuedPlayer != null) {
            System.out.println("Player '" + dequeuedPlayer + "' dequeued");
        }
    }
}
