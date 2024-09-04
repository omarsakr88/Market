import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends BaseObject{

    private String name;
    private String address;
    private ArrayList<Order> orderList = new ArrayList<>();

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public void fillName() {
        System.out.println("Enter customer name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
    }
   public void fillAdress() {
        System.out.println("Enter customer address:");
        Scanner scanner = new Scanner(System.in);
        address = scanner.next();
    }


   public void printOrders() {
        System.out.println("Orders:");
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            order.print();
        }
    }

   public void print() {
        System.out.print("ID:");
        System.out.println(getId());
        System.out.print("Name:");
        System.out.println(name);
        System.out.print("Address:");
        System.out.println(address);
    }

   public Order getOrder() {
        System.out.println("Enter order ID:");
        Scanner scanner = new Scanner(System.in);
        Integer orderId = scanner.nextInt();
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }
}
