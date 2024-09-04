import com.sun.source.tree.BreakTree;

import java.util.Scanner;

public class ItemLine extends BaseObject{

    private Integer count;
    private Item item;
    private Order order;

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

   public void fillCount() {
        System.out.println("Enter count:");
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
    }

   public void print() {
        System.out.print("ID:");
        System.out.println(getId());
        System.out.print("Name:");
        System.out.println(item.getName());
        System.out.print("Count:");
        System.out.println(count);
    }
}
