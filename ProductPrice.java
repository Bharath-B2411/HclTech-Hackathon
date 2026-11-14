import java.util.*;

class Product {
    int prodId;
    String prodName;
    double prodPrice;

    Product(int id, String name, double cost) {
        prodId = id;
        prodName = name;
        this.prodPrice = cost;
    }

    double calculateDiscount() {
        return 0;
    }
}

class ElectronicsProduct extends Product {
    ElectronicsProduct(int id, String name, double cost) {
        super(id, name, cost);
    }

    @Override
    double calculateDiscount() {
        return prodPrice * 12 / 100;
    }
}

class ClothingProduct extends Product {
    ClothingProduct(int id, String name, double cost) {
        super(id, name, cost);
    }

    @Override
    double calculateDiscount() {
        return prodPrice * 20 / 100;
    }
}

class GroceryProduct extends Product {
    GroceryProduct(int id, String name, double cost) {
        super(id, name, cost);
    }

    @Override
    double calculateDiscount() {
        return prodPrice * 5 / 100;
    }
}

public class ProductPrice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int category = input.nextInt();
        int itemId = input.nextInt();
        String itemName = input.next();
        double itemPrice = input.nextDouble();
        Product item;
        if (category == 1) {
            item = new ElectronicsProduct(itemId, itemName, itemPrice);
        } else if (category == 2) {
            item = new ClothingProduct(itemId, itemName, itemPrice);
        } else {
            item = new GroceryProduct(itemId, itemName, itemPrice);
        }
        double discountAmount = item.calculateDiscount();
        double priceAfterDiscount = itemPrice - discountAmount;
        System.out.println("Product ID: " + item.prodId);
        System.out.println("Product Name: " + item.prodName);
        System.out.printf("Discount: %.2f%n", discountAmount);
        System.out.printf("Final Price: %.2f%n", priceAfterDiscount);
        input.close();
    }
}
