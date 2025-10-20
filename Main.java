import java.util.Scanner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JLabel;

public class Main extends JFrame{
    final private Font mainFont = new Font("Poppins", Font.BOLD, 18);
    JTextField billerName, billerAddress, billerContact;
    JLabel welcomeText;

    public void initialize() {
        /*FORMS PANEL*/
        JLabel billerFullName = new JLabel("Biller's Name: ");
        billerFullName.setFont(mainFont);

        billerName = new JTextField();
        billerName.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.add(billerFullName);
        formPanel.add(billerName);

        /*WELCOME TEXT*/
        welcomeText = new JLabel();
        welcomeText.setFont(mainFont);

        /*Buttons Panel*/
        JButton buttons = new JButton("NEXT");
        buttons.setFont(mainFont);
        buttons.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String billerFullName = billerName.getText();
                welcomeText.setText("Hello, " + billerFullName + "!");
            }
        });

        JButton buttonsClr = new JButton("CLEAR");
        buttonsClr.setFont(mainFont);
        buttonsClr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                billerName.setText("");
                welcomeText.setText("");
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonsPanel.add(buttons);
        buttonsPanel.add(buttonsClr);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(255, 255, 250));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(welcomeText, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Welcome");
        setSize(500, 600);
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

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
        }
        while (choice >= 1 && choice <= 9);
        
        System.out.printf("Battery Capacity: %.0f Wh.", solarBattery.getPower());
        if (solarBattery.getPower() > appliance.calculateTotalWattHours()) {
            System.out.printf("The battery can support the appliance usage with extra %.0f watts.", 
                solarBattery.getPower() - appliance.calculateTotalWattHours());
        } else {
            System.out.printf("The battery can't support the appliance usage with deficit of %.0f watts.", 
                appliance.calculateTotalWattHours() - solarBattery.getPower());
        }

        Main myFrame = new Main();
        myFrame.initialize();
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