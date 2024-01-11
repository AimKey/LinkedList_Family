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
public class LinkedListController extends Menu<String> {
//Hien thi cac option cho Playlist Management
    private Menu parentMenu;
    private static String[] mc = {"Add Song", "Shuffle", "Skip to next",
        "Back to previous", "Show all songs", "Return to menu"};
    private Library lib;
    private LinkedList list;
    private Algorithm algo;

    public LinkedListController(Menu parentMenu) {
        super("Playlist manager", mc, parentMenu);
        this.parentMenu = parentMenu;
        lib = new Library();
        list = new LinkedList();
        algo = new Algorithm();
    }
//Thuc thi cac option cua playlist management
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
        algo.displaySongs(list.getHead());
    }
    public void doShuffle() {
        if (list.size < 1) {
            System.out.println("There is only 1 song in the list");
        }
        list.shuffle();
        doShow();
    }
//  Skip by advacing current pointer of the list
    public void doSkip() {
        try {
            list.next();
            System.out.println("Currently playing -> " + list.getCurPointer().getDataOfNode());

        } catch (Exception e) {
            System.out.println("No songs left to play!");
        }
    }
//  Back to a previous song by iterate to the previous node of current pointer
    public void doBack() {
        try {
            list.setCurPointer(list.getPreviousNode(list.getCurPointer()));
            System.out.println("Currently playing -> " + list.getCurPointer().getDataOfNode());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
//  Display
    public void doShow() {
        System.out.println("-----------------Playlist-----------------");
        algo.displaySongs(list.getHead());
        System.out.println("------------------------------------------");
        System.out.println("Currently playing -> " + list.getCurPointer().getDataOfNode());
    }
}
