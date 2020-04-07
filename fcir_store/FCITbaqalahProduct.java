
public class FCITbaqalahProduct
 {
    private int itemNum;
private String itemName;
private double itemPrice;
private int quantity;
private int restockQuantity;
private static int numProducts;

    public FCITbaqalahProduct(int itemNum, String itemName, double itemPrice, int quantity, int restockQuantity) {
        this.itemNum = itemNum;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.restockQuantity = restockQuantity;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRestockQuantity() {
        return restockQuantity;
    }

    public void setRestockQuantity(int restockQuantity) {
        this.restockQuantity = restockQuantity;
    }

    public static int getNumProducts() {
        return numProducts;
    }

    public static void setNumProducts(int numProducts) {
        FCITbaqalahProduct.numProducts = numProducts;
    }
    public static void  plus() {
        numProducts++;
    }
}
