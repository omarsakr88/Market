import java.util.Scanner;

public class Item extends BaseObject{

    private String name;
    private Double price;

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   public void fillName() {
        System.out.println("Enter item name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
    }
   public void fillPrice() {
        System.out.println("Enter price:");
        Scanner scanner = new Scanner(System.in);
        price = scanner.nextDouble();
    }
   public void print() {
        System.out.print("ID: ");
        System.out.println(getId());
        System.out.print("Name: ");
        System.out.println(name);
        System.out.print("price: ");
        System.out.println(price);
    }



}
