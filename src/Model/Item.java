package Model;

public class Item {

    String name, desc;
    int ammount;
    public Item(String name, int ammount) {
        this.name = name;
        this.ammount = ammount;
    }
    public Item(String name, int ammount, String desc) {
        this.name = name;
        this.desc = desc;
        this.ammount = ammount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
    
    public void addCount() {
        this.ammount++;
    }

    @Override
    public String toString() {
        String res = String.format("|Name: %-10s |Ammount: %-10s \n|Description: %s", name, ammount, desc);
        return res;
    }

}
