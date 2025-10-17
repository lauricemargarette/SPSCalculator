import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Appliances appliance = new Appliances();
        SolarBattery solarBattery = new SolarBattery();
        int choice, hours;

        solarBattery.setBrand(input("Battery Brand: ", input));
        solarBattery.setType(input("Battery Type: ", input));
        solarBattery.listVoltageOptions();
        solarBattery.setVolt(Integer.parseInt(input("Battery Volt: ", input)));
        solarBattery.listCurrentOptions();
        solarBattery.setCurrent(Integer.parseInt(input("Battery Current: ", input)));
        solarBattery.setQuantity(Integer.parseInt(input("Quantity of Batteries: ", input)));

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
                    hours = parseIntSafe(input("Hours used: ", input), -1);
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

        System.out.printf("Battery Capacity: %.0f Wh.", solarBattery.getPower());
        if (solarBattery.getPower() > appliance.calculateTotalWattHours()) {
            System.out.printf("The battery can support the appliance usage with extra %.0f watts.", 
                solarBattery.getPower() - appliance.calculateTotalWattHours());
        } else {
            System.out.printf("The battery can't support the appliance usage with deficit of %.0f watts.", 
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