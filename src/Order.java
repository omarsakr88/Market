import java.util.ArrayList;
import java.util.Scanner;

public class Order extends BaseObject{

    private Customer customer;
    private ArrayList<ItemLine> itemlineList = new ArrayList<>();

    public ArrayList<ItemLine> getItemlineList() {
        return itemlineList;
    }
    public void setItemlineList(ArrayList<ItemLine> itemlineList) {
        this.itemlineList = itemlineList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

   public void print() {
            System.out.print("ID:");
            System.out.println(getId());
            System.out.print("Name:");
            System.out.println(customer.getName());

    }
   public Double getTotal() {
        Double sum = 0.0;
        for (int i = 0; i < itemlineList.size(); i++) {
            ItemLine itemline = itemlineList.get(i);
            sum += itemline.getItem().getPrice() * itemline.getCount();
        }
        return sum;
    }
   public ItemLine getItemLine() {
        System.out.println("Enter ItemLine ID:");
        Scanner scanner = new Scanner(System.in);
        Integer itemlineId = scanner.nextInt();
        for (int i = 0; i < itemlineList.size(); i++) {
            ItemLine itemline = itemlineList.get(i);
            if (itemline.getId().equals(itemlineId)) {
                return itemline;
            }
        }
        return null;
    }

   public void printItemLines() {
        System.out.println("Item Lines:");
        for (int i = 0; i < itemlineList.size(); i++) {
            ItemLine itemLine = itemlineList.get(i);
            itemLine.print();
        }
    }
}
