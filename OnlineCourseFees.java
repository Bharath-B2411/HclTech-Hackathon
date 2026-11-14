import java.util.*;

abstract class Course {
    double baseFee;

    Course(double fee) {
        baseFee = fee;
    }

    abstract double calculateDiscount();

    abstract String getCourseType();

    double calculateFinalFee() {
        return baseFee - calculateDiscount();
    }
}

class ProgrammingCourse extends Course {
    ProgrammingCourse(double fee) {
        super(fee);
    }

    double calculateDiscount() {
        return baseFee * 10 / 100;
    }

    String getCourseType() {
        return "Programming";
    }
}

class DataScienceCourse extends Course {
    DataScienceCourse(double fee) {
        super(fee);
    }

    double calculateDiscount() {
        return baseFee * 15 / 100;
    }

    String getCourseType() {
        return "Data Science";
    }
}

class CloudCourse extends Course {
    CloudCourse(double fee) {
        super(fee);
    }

    double calculateDiscount() {
        return baseFee * 5 / 100;
    }

    String getCourseType() {
        return "Cloud";
    }
}

public class OnlineCourseFees {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int courseType = input.nextInt();
        double courseAmount = input.nextDouble();
        Course selectedCourse;
        if (courseType == 1) {
            selectedCourse = new ProgrammingCourse(courseAmount);
        } else if (courseType == 2) {
            selectedCourse = new DataScienceCourse(courseAmount);
        } else {
            selectedCourse = new CloudCourse(courseAmount);
        }
        System.out.println("Course Type: " + selectedCourse.getCourseType());
        System.out.printf("Discount: %.2f%n", selectedCourse.calculateDiscount());
        System.out.printf("Final Fee: %.2f%n", selectedCourse.calculateFinalFee());
        input.close();
    }
}
