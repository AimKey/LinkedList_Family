package Controller;

import Common.Algorithm;
import Common.Library;
import Model.LinkedList;
import Model.Node;
import Model.Song;
import view.Menu;

public class MainController extends Menu<String> {

    private Menu parentMenu;
    private static String[] mc = {"Playlist management", "Shopping Cart",
        "Game queue", "Exit"};

    public MainController(Menu parentMenu) {
        super("Controller", mc, parentMenu);
        this.parentMenu = parentMenu;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                linkedList();
                break;
            case 2:
                doublyLinkedList();
                break;
            case 3:
                circularLinkedList();
                break;
            case 4:
                System.exit(0);
        }
    }

    public void linkedList() {
        new LinkedListController(parentMenu).run();
    }
    public void doublyLinkedList() {
        new LinkedListController(parentMenu).run();
    }
    public void circularLinkedList() {
        new LinkedListController(parentMenu).run();
    }

    
}
