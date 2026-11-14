import java.util.*;

class Employee {
    String empName;

    Employee(String nameValue) {
        empName = nameValue;
    }

    double calculateBonus() {
        return 0;
    }

    double calculateBonus(double amt) {
        return 0;
    }
}

class TechnicalEmployee extends Employee {
    double baseSalary;
    int performanceRating;

    TechnicalEmployee(String nameValue, double sal, int rate) {
        super(nameValue);
        baseSalary = sal;
        this.performanceRating = rate;
    }

    @Override
    double calculateBonus() {
        return baseSalary * performanceRating * 2 / 100;
    }

    double calculateBonus(double sal, int empRating) {
        return sal * empRating * 2 / 100;
    }
}

class SalesEmployee extends Employee {
    double totalSales;

    SalesEmployee(String nameValue, double amt) {
        super(nameValue);
        totalSales = amt;
    }

    @Override
    double calculateBonus() {
        return totalSales * 3 / 100;
    }

    @Override
    double calculateBonus(double amt) {
        return amt * 3 / 100;
    }
}

public class EmployeePerformance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int empType = input.nextInt();
        Employee employee;
        double totalEarnings;
        if (empType == 1) {
            String empName = input.next();
            double baseSalary = input.nextDouble();
            int performanceRating = input.nextInt();
            employee = new TechnicalEmployee(empName, baseSalary, performanceRating);
            double bonusAmount = employee.calculateBonus();
            totalEarnings = baseSalary + bonusAmount;
            System.out.println("Employee Name: " + empName);
            System.out.printf("Bonus: %.2f%n", bonusAmount);
            System.out.printf("Total Earnings: %.2f%n", totalEarnings);
        } else {
            String empName = input.next();
            double salesAmount = input.nextDouble();
            employee = new SalesEmployee(empName, salesAmount);
            double bonusAmount = employee.calculateBonus();
            totalEarnings = salesAmount + bonusAmount;
            System.out.println("Employee Name: " + empName);
            System.out.printf("Bonus: %.2f%n", bonusAmount);
            System.out.printf("Total Earnings: %.2f%n", totalEarnings);
        }
        input.close();
    }
}
