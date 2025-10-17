import java.util.ArrayList;
import java.util.List;

//Computation for appliances
public class Appliances {
    private double totalWattHours = 0.0;
    private double ratePerKWh = 13.32; //Rate this month of October 2025
    private final ArrayList<String> receipt = new ArrayList<>();

    //Appliances List
    public void listAppliances() {
        System.out.println("\n(1) Light Bulb");
        System.out.println("(2) Television");
        System.out.println("(3) Refrigerator");
        System.out.println("(4) Air Conditioner");
        System.out.println("(5) Washing Machine");
        System.out.println("(6) Computer");
        System.out.println("(7) Fan");
        System.out.println("(8) Modem/Router");
        System.out.println("(9) Rice Cooker");
        System.out.println("\n(0) Exit");
    }

    public String getApplianceLabel(int choice) {
        switch (choice) {
            case 1: return "Light Bulb";
            case 2: return "Television";
            case 3: return "Refrigerator";
            case 4: return "Air Conditioner";
            case 5: return "Washing Machine";
            case 6: return "Computer";
            case 7: return "Fan";
            case 8: return "Modem/Router";
            case 9: return "Rice Cooker";
            default: return "Unknown Appliance";
        }
    }

    public int getApplianceWattage(int choice) {
        switch (choice) {
            case 1: return 60;    // Light Bulb
            case 2: return 150;   // Television
            case 3: return 200;   // Refrigerator
            case 4: return 1000;  // Air Conditioner
            case 5: return 500;   // Washing Machine
            case 6: return 300;   // Computer
            case 7: return 75;    // Fan
            case 8: return 20;    // Modem/Router
            case 9: return 250;   // Rice Cooker
            default: return 0;
        }
    }

    public void addApplianceUsage(int choice, int hours) {
        int watts = getApplianceWattage(choice);
        String label = getApplianceLabel(choice);
        if (watts < 0 || label == null || hours <= 0) {
            return;
        }
        totalWattHours += watts * hours;
        receipt.add(label + " - " + watts + "W for " + hours + " hours.");
    }

    //Calculation for total kWh used
    public double calculateTotalKWh() {
        return totalWattHours / 1000.0;
    }

    public double calculateRatePerKWh() {
        return ratePerKWh;
    }

    public double calculateTotalWattHours() {
        return totalWattHours;
    }

    public void setRatePerKWh(double ratePerKWh) {
        if (ratePerKWh > 0) {
            this.ratePerKWh = ratePerKWh;
        }
    }

    public double calculateTotalCost() {
        return calculateTotalKWh() * ratePerKWh;
    }

    //Display receipt
    public List<String> getReceipt() {
        return new ArrayList<>(receipt);
    }

    public void printReceipt() {
        System.out.println("\n----- Receipt -----\n");
        for (String item : receipt) {
            System.out.println(item);
        }
        System.out.printf("Total Watt-Hours: %.2f Wh%n\n", calculateTotalWattHours());
        System.out.println("---------------");
        System.out.printf("Total kWh: %.2f kWh%n", calculateTotalKWh());
        System.out.printf("Rate per kWh: %.2f pesos.%n", calculateRatePerKWh());
        System.out.printf("Total Daily Bill: %.2f pesos.%n", calculateTotalCost());
        System.out.printf("Total Monthly Bill: %.2f pesos.%n", calculateTotalCost() * 30 );
        System.out.println("\n---------------\n");
    }
}
