public class SolarPanel extends PowerConsumption {
    private double volt, current, efficiency, panelArea; // in square meters

    public void setPanelArea(double panelArea) {
        this.panelArea = panelArea;
    }

    public double getPanelArea() {
        return this.panelArea;
    }

    @Override
    public double getPower() {
        // Assuming efficiency is given as a percentage and solar irradiance is 1000 W/m^2
        double solarIrradiance = 1000.0; // W/m^2
        return this.panelArea * solarIrradiance * (getEfficiency() / 100.0);
    }

    @Override
    public void displayPowerInfo() {
        System.out.println("Voltage: " + this.volt + " V");
        System.out.println("Current: " + this.current + " A");
        System.out.println("Efficiency: " + this.efficiency + " %");
        System.out.printf("Power Output: %.2f W \n\n%n", getPower());
    }
}