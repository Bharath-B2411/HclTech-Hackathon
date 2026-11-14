import java.util.*;

abstract class Employee {
    private int empId;
    private String empName;

    Employee(int idValue, String nameValue) {
        empId = idValue;
        empName = nameValue;
    }

    int getEmployeeId() {
        return empId;
    }

    String getEmployeeName() {
        return empName;
    }

    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    double fixedSalary;

    FullTimeEmployee(int idValue, String nameValue, double sal) {
        super(idValue, nameValue);
        fixedSalary = sal;
    }

    double calculateSalary() {
        return fixedSalary;
    }
}

class ContractEmployee extends Employee {
    int daysWorked;
    double ratePerDay;

    ContractEmployee(int idValue, String nameValue, int noOfDays, double rate) {
        super(idValue, nameValue);
        daysWorked = noOfDays;
        ratePerDay = rate;
    }

    double calculateSalary() {
        return daysWorked * ratePerDay;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int empType = input.nextInt();
        int empId = input.nextInt();
        String empName = input.next();

        Employee employee;

        if (empType == 1) {
            double monthlyPay = input.nextDouble();
            employee = new FullTimeEmployee(empId, empName, monthlyPay);
        } else {
            int workDays = input.nextInt();
            double dayRate = input.nextDouble();
            employee = new ContractEmployee(empId, empName, workDays, dayRate);
        }

        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Employee Name: " + employee.getEmployeeName());
        System.out.printf("Salary: %.2f%n", employee.calculateSalary());

        input.close();
    }
}
