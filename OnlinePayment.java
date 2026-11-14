import java.util.*;

interface Payment {
    double calculateFee(double value);
}

class CreditCardPayment implements Payment {
    public double calculateFee(double value) {
        return value * 2 / 100;
    }
}

class UpiPayment implements Payment {
    public double calculateFee(double value) {
        return value * 0.5 / 100;
    }
}

class WalletPayment implements Payment {
    public double calculateFee(double value) {
        return value * 1 / 100;
    }
}

public class OnlinePayment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int paymentType = input.nextInt();
        double paymentAmount = input.nextDouble();
        Payment method;
        if (paymentType == 1) {
            method = new CreditCardPayment();
        } else if (paymentType == 2) {
            method = new UpiPayment();
        } else {
            method = new WalletPayment();
        }
        double transactionFee = method.calculateFee(paymentAmount);
        double finalAmount = paymentAmount + transactionFee;
        System.out.printf("Payment Amount: %.2f%n", paymentAmount);
        System.out.printf("Transaction Fee: %.2f%n", transactionFee);
        System.out.printf("Final Amount: %.2f%n", finalAmount);
        input.close();
    }
}
