package Controller;

import Common.Algorithm;
import Common.Library;
import Model.DoublyLinkedList;
import Model.Item;
import view.Menu;

/**
 *
 * @author phamm
 */
public class DoublyLinkedListController extends Menu<String> {

    private Menu parentMenu;
    private static String[] mc = {"Add", "Remove", "Adjust quantities", "View Items", "Return to menu"};
    private Library lib;
    private DoublyLinkedList list;
    private Algorithm algo;

    public DoublyLinkedListController(Menu parentMenu) {
        super("Shopping cart", mc, parentMenu);
        this.parentMenu = parentMenu;
        lib = new Library();
        list = new DoublyLinkedList();
        algo = new Algorithm();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                doAdd();
                break;
            case 2:
                doRemove();
                break;
            case 3:
                doAdjust();
                break;
            case 4:
                doView();
                break;
            case 5:
                returnToPMenu();
                break;
        }
    }

    public void doAdd() {
        String iName = lib.getString("Enter item name");
        int iAmmount = lib.getInt("Enter item ammount");
        String desc = lib.getString("Enter item desc");
        list.add(new Item(iName, iAmmount, desc));
        algo.displayItems(list.getHead());
    }

    public void doRemove() {
        String iName = lib.getString("Enter item name to remove");
        if (list.delete(iName)) System.out.println("Delete complete!");
        else System.out.println("Item not found to delete");
    }

    public void doAdjust() {
        String iName = lib.getString("Enter item name to adjust");
        Item f = list.getItemByName(iName);
        f.setAmmount(lib.getInt("How many"));
    }
    
    public void doView() {
        algo.displayItems(list.getHead());
    }

}
