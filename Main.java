import javax.swing.*;

import java.awt.Color;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Solar Power System Calculator");
        frame.setSize(750, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.getContentPane().setBackground(new Color(128, 0, 0));

        Scanner input = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("  Solar Power System Calculator (SPS)");
        System.out.println("==============================================");
        System.out.println("Select Mode:");
        System.out.println("[1] Console Mode");
        System.out.println("[2] GUI Mode");
        System.out.print("Enter your choice: ");
        int mode = parseIntSafe(input.nextLine(), -1);

        if (mode == 2) {
            // 🪟 Run GUI Mode
            System.out.println("Launching GUI...");
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new MainFrame(); // Opens your Swing GUI
                }
            });
            return; // Exit after opening the GUI
        }

        // 🖥️ Run Console Mode
        runConsoleMode(input);
    }

    public static void runConsoleMode(Scanner input) {

        Appliances appliance = new Appliances();
        SolarBattery solarBattery = new SolarBattery();
        int choice, hours;
        String billerName, billerAddress, billerContact;

        System.out.println("--- Solar Battery and Appliance Power Consumption Calculator ---");
        System.out.println("\n---------------------------------------------------------------");

        System.out.println("\nEnter Biller's Information:");
        System.out.print("Biller's Name: "); billerName = input.nextLine();
        System.out.print("Biller's Address: "); billerAddress = input.nextLine();
        System.out.print("Biller's Contact: "); billerContact = input.nextLine();

        System.out.println("\nEnter Solar Battery Details:");
        solarBattery.setBrand(input("Solar Battery Brand: ", input));
        solarBattery.setType(input("Solar Battery Type: ", input));
        solarBattery.listVoltageOptions();
        solarBattery.setVolt(Integer.parseInt(input("Battery Volt: ", input)));
        solarBattery.listCurrentOptions();
        solarBattery.setCurrent(Integer.parseInt(input("Battery Current: ", input)));
        solarBattery.setQuantity(Integer.parseInt(input("Quantity of Batteries: ", input)));

        do {
            appliance.listAppliances();
            choice = parseIntSafe(input("Select an appliance: ", input), -1);

            switch (choice) {
                case 1: case 2: case 3: case 4:
                case 5: case 6: case 7: case 8: case 9:
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
                    System.out.println("\n----- Receipt -----\n");
                    System.out.println("Biller's Name: " + billerName);
                    System.out.println("Biller's Address: " + billerAddress);
                    System.out.println("Biller's Contact: " + billerContact);
                    appliance.printReceipt();
                    break;

                default:
                    System.out.println("Invalid selection. Please select again.");
                    break;
            }
        } while (choice >= 1 && choice <= 9);

        System.out.printf("Battery Capacity: %.0f Wh.\n", solarBattery.getPower());
        if (solarBattery.getPower() > appliance.calculateTotalWattHours()) {
            System.out.printf("The battery can support the appliance usage with extra %.0f watts.\n",
                    solarBattery.getPower() - appliance.calculateTotalWattHours());
        } else {
            System.out.printf("The battery can't support the appliance usage with deficit of %.0f watts.\n",
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