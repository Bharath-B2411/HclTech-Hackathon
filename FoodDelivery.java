import java.util.*;

class Delivery {
    double billAmount;

    Delivery(double amt) {
        billAmount = amt;
    }

    double calculateDeliveryCharge() {
        return billAmount;
    }
}

class RegularDelivery extends Delivery {
    RegularDelivery(double amt) {
        super(amt);
    }

    @Override
    double calculateDeliveryCharge() {
        return billAmount + 40.0;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double amt) {
        super(amt);
    }

    @Override
    double calculateDeliveryCharge() {
        return billAmount + 80.0 + (billAmount * 5 / 100);
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int deliveryType = input.nextInt();
        double orderValue = input.nextDouble();
        Delivery order;
        if (deliveryType == 1) {
            order = new RegularDelivery(orderValue);
        } else {
            order = new ExpressDelivery(orderValue);
        }
        System.out.printf("%.2f%n", order.calculateDeliveryCharge());
        input.close();
    }
}
