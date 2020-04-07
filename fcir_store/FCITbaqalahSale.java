
public class FCITbaqalahSale
 {
    private String firstName;
    
private String lastName;
private int numItemsOnList;
private int itemsPurchased[];
private static int numSales;

    public FCITbaqalahSale(String firstName, String lastName, int numItemsOnList, int[] itemsPurchased) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numItemsOnList = numItemsOnList;
        this.itemsPurchased = itemsPurchased;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumItemsOnList() {
        return numItemsOnList;
    }

    public void setNumItemsOnList(int numItemsOnList) {
        this.numItemsOnList = numItemsOnList;
    }

    public int[] getItemsPurchased() {
        return itemsPurchased;
    }

    public void setItemsPurchased(int[] itemsPurchased) {
        this.itemsPurchased = itemsPurchased;
    }

    public static int getNumSales() {
        return numSales;
    }

    public static void setNumSales(int numSales) {
        FCITbaqalahSale.numSales = numSales;
    }

}
