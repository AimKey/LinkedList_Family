
import Controller.MainController;
import Model.Node;
import view.Menu;


public class Main {
    public static void main(String[] args) {
        Node node = new Node();
        Menu mainMenu = new MainController(null);
//        Entry point
        new MainController(mainMenu).run();
    }
}
