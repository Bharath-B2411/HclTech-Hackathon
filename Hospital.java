import java.util.*;

abstract class Doctor {
    double consultationFee;

    Doctor(double fee) {
        consultationFee = fee;
    }

    abstract String getDoctorType();

    double calculateTotalBill(double labCharges) {
        return consultationFee;
    }
}

class GeneralPhysician extends Doctor {
    GeneralPhysician() {
        super(500.0);
    }

    String getDoctorType() {
        return "General Physician";
    }
}

class Specialist extends Doctor {
    Specialist() {
        super(1000.0);
    }

    String getDoctorType() {
        return "Specialist";
    }
}

class EmergencyDoctor extends Doctor {
    EmergencyDoctor() {
        super(1500.0);
    }

    String getDoctorType() {
        return "Emergency Doctor";
    }

    @Override
    double calculateTotalBill(double labCharges) {
        return consultationFee + labCharges;
    }
}

public class Hospital {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int doctorType = input.nextInt();
        double labCharges = input.nextDouble();
        Doctor doc;
        if (doctorType == 1) {
            doc = new GeneralPhysician();
        } else if (doctorType == 2) {
            doc = new Specialist();
        } else {
            doc = new EmergencyDoctor();
        }
        double totalBill = doc.calculateTotalBill(labCharges);
        System.out.println("Doctor Type: " + doc.getDoctorType());
        System.out.printf("Consultation Charge: %.2f%n", doc.consultationFee);
        System.out.printf("Test Charges: %.2f%n", labCharges);
        System.out.printf("Total Bill: %.2f%n", totalBill);
        input.close();
    }
}
