public class PowerConsumption {
    private double volt, current, efficiency;
    private String brand, type;

    PowerConsumption() {
        this.volt = 0.0;
        this.current = 0.0;
        this.efficiency = 0.0;
        this.brand = "No brand";
        this.type = "No type";
    }

    public void setVolt(double volt) {
        this.volt = volt;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
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

    public double getEfficiency() {
        return this.efficiency;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getType() {
        return this.type;
    }

    public double getPower() {
        return this.volt * this.current * (this.efficiency / 100.0);
    }

    public void displayPowerInfo() {
        System.out.println("Power Consumption Information:");
        System.out.println("Brand: " + this.brand);
        System.out.println("Type: " + this.type);
        System.out.println("Voltage: " + this.volt + " V");
        System.out.println("Current: " + this.current + " A");
        System.out.println("Efficiency: " + this.efficiency + " %");
        System.out.printf("Effective Power: %.2f Wh \n\n%n", getPower());
    }
}
