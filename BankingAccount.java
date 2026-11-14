import java.util.*;

class BankAccount {
    int accNo;
    double currentBalance;

    BankAccount(int no, double bal) {
        accNo = no;
        this.currentBalance = bal;
    }

    double calculateFinalBalance() {
        return currentBalance;
    }
}

class SavingsAccount extends BankAccount {
    double interest;

    SavingsAccount(int no, double bal, double rateValue) {
        super(no, bal);
        interest = rateValue;
    }

    @Override
    double calculateFinalBalance() {
        return currentBalance + (currentBalance * interest / 100);
    }
}

class CurrentAccount extends BankAccount {
    double overdraft;

    CurrentAccount(int no, double bal, double limitValue) {
        super(no, bal);
        overdraft = limitValue;
    }

    @Override
    double calculateFinalBalance() {
        return currentBalance + overdraft;
    }
}

public class BankingAccount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int accType = input.nextInt();
        int accNumber = input.nextInt();
        double accBalance = input.nextDouble();
        BankAccount acc;
        if (accType == 1) {
            double interestRate = input.nextDouble();
            acc = new SavingsAccount(accNumber, accBalance, interestRate);
        } else {
            double odLimit = input.nextDouble();
            acc = new CurrentAccount(accNumber, accBalance, odLimit);
        }
        System.out.printf("%.2f%n", acc.calculateFinalBalance());
        input.close();
    }
}
