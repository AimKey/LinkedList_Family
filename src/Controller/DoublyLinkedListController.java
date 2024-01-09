package Controller;

import Common.Algorithm;
import Common.Library;
import Model.LinkedList;
import Model.Song;
import view.Menu;

/**
 *
 * @author phamm
 */
public class DoublyLinkedListController extends Menu<String> {
    private Menu parentMenu;
    private static String[] mc = {"Add some functions here..."};
    private Library lib;
    private LinkedList list;
    private Algorithm algo;
    public DoublyLinkedListController(Menu parentMenu) {
        super("Add name here...", mc, parentMenu);
        this.parentMenu = parentMenu;
        lib = new Library();
        list = new LinkedList();
        algo = new Algorithm();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }


}
