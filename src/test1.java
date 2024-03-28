import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test1 {
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MenuItem {
    private String itemName;
    private double price;

    public MenuItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
}

class RestaurantMenu {
    private ArrayList<MenuItem> menuItems;

    public RestaurantMenu() {
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}

public class RestaurantExample {
    public static void main(String[] args) {
        // Create a menu
        RestaurantMenu menu = new RestaurantMenu();
        menu.addMenuItem(new MenuItem("Burger", 8.99));
        menu.addMenuItem(new MenuItem("Pizza", 12.99));
        menu.addMenuItem(new MenuItem("Salad", 6.99));

        // Display menu using ArrayList and Iterator
        System.out.println("Menu Items:");
        ArrayList<MenuItem> menuItems = menu.getMenuItems();
        Iterator<MenuItem> iterator = menuItems.iterator();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.println(item.getItemName() + " - $" + item.getPrice());
        }

        // Create a HashMap to store customer orders
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("Burger", 2);
        orders.put("Pizza", 1);

        // Calculate and display the total order amount
        double totalAmount = calculateTotalAmount(menu, orders);
        System.out.println("\nTotal Order Amount: $" + totalAmount);
    }

    private static double calculateTotalAmount(RestaurantMenu menu, HashMap<String, Integer> orders) {
        double totalAmount = 0;
        double discountPercentage = 0.1; // 10% discount for quantities above 2
        double taxPercentage = 0.08; // 8% tax
        double serviceChargePercentage = 0.05; // 5% service charge

        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();

            // Find the item in the menu
            MenuItem menuItem = findMenuItemByName(menu, itemName);

            // Calculate the total amount for the item with special logic
            if (menuItem != null) {
                double itemPrice = menuItem.getPrice();

                // Apply discount for quantities above 2
                if (quantity > 2) {
                    itemPrice -= itemPrice * discountPercentage;
                }

                totalAmount += itemPrice * quantity;
            }
        }

        // Apply tax and service charge
        totalAmount += totalAmount * taxPercentage;
        totalAmount += totalAmount * serviceChargePercentage;

        return totalAmount;
    }

    private static MenuItem findMenuItemByName(RestaurantMenu menu, String itemName) {
        for (MenuItem menuItem : menu.getMenuItems()) {
            if (menuItem.getItemName().equals(itemName)) {
                return menuItem;
            }
        }
        return null;
    }
}

