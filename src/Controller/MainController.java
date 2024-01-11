package Controller;

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
//  3 controllers for 3 different programs
    public void linkedList() {
        new LinkedListController(parentMenu).run();
    }
    public void doublyLinkedList() {
        new DoublyLinkedListController(parentMenu).run();
    }
    public void circularLinkedList() {
        new CircularLinkedListController(parentMenu).run();
    }
}
