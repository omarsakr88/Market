import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static ArrayList<Customer> customerList;
    static ArrayList<Item> itemList;
    static ArrayList<Order> orderList;
    static Scanner scanner;
    static boolean run;

    public static void main(String[] args) {
        customerList = new ArrayList<>();
        itemList = new ArrayList<>();
        orderList = new ArrayList<>();
        scanner = new Scanner(System.in);
        run = true;
        while (run == true) {
            doOperation();
            System.out.println("");
        }
    }

    static void doOperation() {
        System.out.println("Select opertaion:");

        System.out.println("1:exit");

        System.out.println("2:customer");

        System.out.println("3:order");

        System.out.println("4:item");

        System.out.println("5:item line");

        System.out.println("6:print-all");

        String ans = scanner.next();
        if (ans.equals("1")) {
            run = false;
        }
        if (ans.equals("2")) {
            customerOperation();
        }
        if (ans.equals("3")) {
            orderOperation();
        }
        if (ans.equals("4")) {
            itemOperation();
        }
        if (ans.equals("5")) {
            itemLineOperation();
        }
        if (ans.equals("6")) {
            print();
        }
    }

    static void customerOperation() {
        System.out.println("Select operation:");
        System.out.println("1:Add");
        System.out.println("2:Rename");
        System.out.println("3:Remove");
        System.out.println("4:Print");

        String ans = scanner.next();
        if (ans.equals("1")) {
            addCustomer();
        }
        if (ans.equals("2")) {
            renameCustomer();
        }
        if (ans.equals("3")) {
            removeCustomer();
        }
        if (ans.equals("4")) {
            printCustomers();
        }
    }
    static void orderOperation()    {
        System.out.println("Select operation:");
        System.out.println("1:Add");
        System.out.println("2:Add item line");
        System.out.println("3:Get total");
        System.out.println("4:Print-ItemLine");

        String ans = scanner.next();
        if (ans.equals("1")) {
            addorder();
        }
        if (ans.equals("2")) {
            addItemLine();
        }
        if (ans.equals("3")) {
            getTotal();
        }
        if (ans.equals("4")) {
            printItemLines();
        }
    }
    static void itemOperation() {
        System.out.println("Select operation:");
        System.out.println("1:Add");
        System.out.println("2:Rename");
        System.out.println("3:Remove");
        System.out.println("4:Print");

        String ans = scanner.next();
        if (ans.equals("1")) {
            addItem();
        }
        if (ans.equals("2")) {
            renameItem();
        }
        if (ans.equals("3")) {
            removeItem();
        }
        if (ans.equals("4")) {
            printItems();
        }
    }
    static void itemLineOperation() {
        System.out.println("Select operation:");
        System.out.println("1:Count");
        System.out.println("2:Remove");
        String ans = scanner.next();
        if (ans.equals("1")) {
            modifyItemLine();
        }
        if (ans.equals("2")) {
            removeItemLine();
        }
    }
    static void addTes() {

    }
    static void addCustomer() {
        Customer customer = new Customer();
        customer.assignNewId();
        customer.fillName();
        customer.fillAdress();
        customerList.add(customer);
    }
    static void renameCustomer() {
        printCustomers();
        Customer customer = getCustomer();
        if (customer == null) {
            return;
        }
        customer.fillName();
        customer.fillAdress();
    }
    static void removeCustomer() {
        printCustomers();
        Customer customer = getCustomer();
        if (customer == null) {
            return;
        }
        customerList.remove(customer);
    }

    static void addorder() {
        Order order = new Order();
        order.assignNewId();

        printCustomers();
        Customer customer = getCustomer();
        if (customer == null) {
            return;
        }
        order.setCustomer(customer);
        customer.getOrderList().add(order);
        orderList.add(order);

    }
    static void addItemLine() {
        printOrders();
        Order order = getOrder();
        if (order == null) {
            return;
        }
        printItems();
        Item item = getItem();
        if (item == null) {
            return;
        }
        ItemLine itemLine = new ItemLine();
        itemLine.assignNewId();
        itemLine.setItem(item);
        itemLine.setOrder(order);
        itemLine.fillCount();
        order.getItemlineList().add(itemLine);
    }
    static void getTotal() {
        printOrders();
        Order order = getOrder();
        if (order == null) {
            return;
        }
        System.out.print("Total= ");
        System.out.println(order.getTotal());
    }

    static void addItem() {
        Item item = new Item();
        item.assignNewId();
        item.fillName();
        itemList.add(item);
        item.fillPrice();
    }
    static void renameItem() {
        printItems();
        Item item = getItem();
        if (item == null) {
            return;
        }
        item.fillName();
    }
    static void removeItem() {
        printItems();
        Item item = getItem();
        if (item == null) {
            return;
        }
        itemList.remove(item);
    }

    static void modifyItemLine() {
        printOrders();
        Order order = getOrder();
        if (order == null) {
            return;
        }
        order.printItemLines();
        ItemLine itemline = order.getItemLine();
        if (itemline == null) {
            return;
        }
        itemline.fillCount();
    }
    static void removeItemLine() {
        printOrders();
        Order order = getOrder();
        if (order == null) {
            return;
        }
        order.printItemLines();
        ItemLine itemline = order.getItemLine();
        if (itemline == null) {
            return;
        }
        order.getItemlineList().remove(itemline);
    }
    static void printItemLines() {
        printOrders();
        Order order = getOrder();
        if (order == null) {
            return;
        }
        order.printItemLines();
    }

    static void print() {
        printCustomers();
        printItems();
        printOrders();
    }
    static void printCustomers() {
        System.out.println("Customers:");
        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            customer.print();
            customer.printOrders();
        }
    }
    static void printItems() {
        System.out.println("Items:");
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            item.print();
        }
    }
    static void printOrders() {
        System.out.println("Orders:");
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            order.print();
        }
    }


    static Order getOrder() {
        System.out.println("Enter order ID:");
        Integer orderId = scanner.nextInt();
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getId().equals(orderId)) {
                return order;
            }
        }
        System.out.println("Order not found");
        return null;
    }
    static Customer getCustomer() {
        System.out.println("Enter customer ID:");
        Integer customerId = scanner.nextInt();
        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        System.out.println("Customer not found");
        return null;
    }
    static Item getItem() {
        System.out.println("Enter Item ID:");
        Integer itemId = scanner.nextInt();
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        System.out.println("Item not found");
        return null;
    }
}

