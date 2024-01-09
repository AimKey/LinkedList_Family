
package Common;

import java.util.Scanner;

public class Library {

    public int getInt(String td) {
        Scanner sc = new Scanner(System.in);
        System.out.print(td + ": ");
        return Integer.parseInt(sc.nextLine());
    }
    
    public String getString(String td) {
        Scanner sc = new Scanner(System.in);
        System.out.print(td + ": ");
        return sc.nextLine();
    }
}
