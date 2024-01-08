package Controller;

import Model.Node;
import view.Menu;

public class LinkedList_Family extends Menu<String>{
    
    private Menu parentMenu;
    private Node node;
    private static String[] mc = {"Playlist management", "Shopping Cart", 
    "Game queue", "Exit"};
    private String dataOfNode;
    private String head, tail, next;
    
    
    public LinkedList_Family(Node dataOfNode, Menu parentMenu){
        super("Controller", mc, parentMenu);
        this.parentMenu = parentMenu;
        dataOfNode.getDataOfNode();
        head = tail = null;
    }

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
            case 2:
            case 3:
            case 4:
                System.exit(0);
        }
    }
    
    public void linkedList(){
        String[] mcs = {"Add Song", "Shuffle", "Skip to next",
            "Back to previous", "Return to menu", "Exit"};
        Menu smenu;
        smenu = new Menu ("Playlist manager", mcs, this){
            @Override
            public void execute(int n) {
                switch(n){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        returnToPMenu();
                        break;
                    case 6:
                        System.exit(0);
                }
            }
            
        };
        smenu.run();
    }
}
