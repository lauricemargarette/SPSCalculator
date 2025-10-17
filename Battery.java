public class Battery {
    private double volt, current;
    private String brand, type;

    Battery() {
        this.volt = 0.0;
        this.current = 0.0;
        this.brand = "No brand";
        this.type = "No type";
    }

    public void setVolt(double volt) {
        this.volt = volt;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getVolt() {
        return this.volt;
    }

    public double getCurrent() {
        return this.current;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getType() {
        return this.type;
    }

    public double getPower() {
        return this.volt * this.current;
    }

    public void displayBatteryInfo() {
        System.out.println("Battery Information:");
        System.out.println("Brand: " + this.brand);
        System.out.println("Type: " + this.type);
        System.out.println("Voltage: " + this.volt + " V");
        System.out.println("Current: " + this.current + " A");
        System.out.printf("Capacity: %.2f Wh \n\n%n", getPower());
    }
}
