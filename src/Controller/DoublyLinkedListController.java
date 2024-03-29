package Controller;

import Common.Algorithm;
import Common.Library;
import Model.DoublyLinkedList;
import Model.Item;
import view.Menu;

/**
 * for Shopping cart option
 *
 * @author phamm
 */
public class DoublyLinkedListController extends Menu<String> {

    private Menu parentMenu;
    private static String[] mc = {"Add", "Remove", "Adjust quantities", "View Items", "Detail view", "Return to menu"};
    private Library lib;
    private DoublyLinkedList list;
    private Algorithm algo;

    public DoublyLinkedListController(Menu parentMenu) {
//        Initialize
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
                doDetailView();
                break;
            case 6:
                returnToPMenu();
                break;
        }
    }

    public void doAdd() {
//            add new item to the list (shopping cart)
        try {
            String iName = lib.getString("Enter item name");
            int iAmmount = lib.getInt("Enter item ammount");
            String desc = lib.getString("Enter item desc");
            list.add(new Item(iName, iAmmount, desc));
        } catch (Exception e) {
//            This execute if user enter wrong input type
            System.out.println("Wrong information!");
        }
    }

    public void doRemove() {
//        Remove a Node based on Node's data property: name
        String iName = lib.getString("Enter item name to remove");
        if (list.delete(iName)) {
            System.out.println("Delete complete!");
        } else {
            System.out.println("Item not found to delete");
        }
    }

    public void doAdjust() {
//        Get the node and then set it ammount using setter
        String iName = lib.getString("Enter item name to adjust");
        Item f = list.getItemByName(iName);
        f.setAmmount(lib.getInt("How many"));
    }

    public void doView() {
//        Pass the head Node to start iterate and display the nodes
        algo.displayItems(list.getHead());
    }

    public void doDetailView() {
        String[] choices = new String[]{"Next", "Previous", "End"};
        int count = 0;
        while (true) {
            if (count >= 0 && count < list.size()) {
//                Display the current item with its description
                System.out.println("--------------Item---------------");
                System.out.println(list.getCurPointer().getDataOfNode());
                System.out.println((count + 1) + " out of " + list.size() + " items");
                System.out.println("--------------------------------");
                System.out.format("1.%-10s 2.%-10s 3.%-10s\n", choices[0], choices[1], choices[2]);
                int ans = lib.getInt("Your choice");
                if (ans == 1) {
//                    Advance to next item
                    list.next();
                    count++;
                }
                if (ans == 2) {
//                    Back to the previous item
                    list.prev();
                    count--;
                }
                if (ans == 3) {
//                    Exit loop
                    break;
                }
            } else {
                break;
            }
        }
    }

}
