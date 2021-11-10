import java.util.Collections;
import java.util.Comparator;

public class OrderedItem {

    String itemName;
    double itemPrice;

    public OrderedItem(String itemName, double itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName(){
        return itemName;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public String toString(){
       return(getItemName() + "\t\t$ " + getItemPrice());
    }
}
