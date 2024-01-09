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
    private Library lib;
    private LinkedList list;
    private Algorithm algo;

    public MainController(Node dataOfNode, Menu parentMenu) {
        super("Controller", mc, parentMenu);
        this.parentMenu = parentMenu;
        lib = new Library();
        list = new LinkedList();
        algo = new Algorithm();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                linkedList();
                break;
            case 2:
            case 3:
            case 4:
                System.exit(0);
        }
    }

    public void linkedList() {
        String[] mcs = {"Add Song", "Shuffle", "Skip to next",
            "Back to previous", "Show all songs", "Return to menu"};
        Menu smenu;
        smenu = new Menu("Playlist manager", mcs, this) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        doAddSong();
                        break;
                    case 2:
                        doShuffle();
                        break;
                    case 3:
                        doSkip();
                        break;
                    case 4:
                        doBack();
                        break;
                    case 5:
                        doShow();
                        break;
                    case 6:
                        returnToPMenu();
                        break;
                }
            }

        };
        smenu.run();
    }

    public void doAddSong() {
        while (true) {
            String name = lib.getString("Enter song name");
            int dur = lib.getInt("Enter song duration");
            Song s = new Song(name, dur);
            list.add(s);
            if ("n".equals(lib.getString("Continue? y/n"))) {
                break;
            }
        }
        algo.display(list.getHead());
    }

    public void doShuffle() {
        if (list.size < 1){
            System.out.println("There is only 1 song in the list");
            return;
        }
        
        System.out.println("Ahihi");
        list.shuffle();
    }

    public void doSkip() {

    }

    public void doBack() {

    }

    public void doShow() {
        System.out.println("------------Playlist------------");
        algo.display(list.getHead());
        System.out.println("--------------------------------");
        System.out.println("Currently playing -> " + list.getCurPointer().getDataOfNode());
    }
}
