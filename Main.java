import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Appliances appliance = new Appliances();
        SolarBattery solarBattery = new SolarBattery();
        int choice;

        solarBattery.setVolt(Double.parseDouble(input("Battery Voltage: ", input)));
        solarBattery.setCurrent(Double.parseDouble(input("Battery Current: ", input)));

        do {
            appliance.listAppliances();
            choice = parseIntSafe(input("Select an appliance: ", input), -1);
            
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    int watts = appliance.getApplianceWattage(choice);
                    String label = appliance.getApplianceLabel(choice);
                    if (watts < 0) {
                        System.out.println("Invalid appliance choice.");
                        break;
                    }
                    System.out.println("Selected Appliance: " + label + " (" + watts + " W/hr.)");
                    int hours = parseIntSafe(input("Hours used: ", input), 0);
                    appliance.addApplianceUsage(choice, hours);
                    System.out.println("Added " + label + " usage for " + hours + " hours.");
                    break;
                
                case 0:
                    appliance.printReceipt();
                    break;

                default:
                    System.out.println("Invalid selection. Please select again.");
                    break;
            }
        } while (choice >= 1 && choice <= 9);

        System.out.printf("Total watts used: %.0f watts. %n", appliance.calculateTotalWattHours());
        System.out.printf("Total kWh used: %.0f kWh. %n", appliance.calculateTotalKWh());
        System.out.printf("Battery Capacity: %.0f Wh. %n", solarBattery.getPower());
        if (solarBattery.getPower() > appliance.calculateTotalWattHours()) {
            System.out.printf("The battery can support the appliance usage with extra %.0f watts.", 
                solarBattery.getPower() - appliance.calculateTotalWattHours());
        } else {
            System.out.printf("The battery cannot support the appliance usage with deficit of  %.0f watts.", 
                appliance.calculateTotalWattHours() - solarBattery.getPower());
        }
    }

    public static String input(String message, Scanner input) {
        System.out.print(message);
        return input.nextLine();
    }

    public static int parseIntSafe(String s, int fallback) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return fallback;
        }
    }
}