public class SolarBattery extends Battery {
    private boolean solarBatt;
    private int quantity = 1;

    public void setSolarBatt(boolean solarBatt) {
        this.solarBatt = solarBatt;
    }

    public boolean getSolarBatt() {
        return this.solarBatt;
    }

    public void listVoltageOptions() {
        System.out.println("Solar Battery Voltage Option:");
        System.out.println("(1) 12V System");
        System.out.println("(2) 24V System");
        System.out.println("(3) 48V System");
    }

    public void listCurrentOptions() {
        System.out.println("Solar Battery Current Option:");
        System.out.println("(1) 50Ah");
        System.out.println("(2) 100Ah");
        System.out.println("(3) 150Ah");
        System.out.println("(4) 200Ah");
        System.out.println("(5) 250Ah");
    }

    public void setVolt(int choice) {
        switch(choice) {
            case 1: setVolt(12.0); break;
            case 2: setVolt(24.0); break;
            case 3: setVolt(48.0); break;
        }
    }

    public void setCurrent(int choice) {
        switch(choice) {
            case 1: setCurrent(50.0); break;
            case 2: setCurrent(100.0); break;
            case 3: setCurrent(150.0); break;
            case 4: setCurrent(200.0); break;
            case 5: setCurrent(250.0); break;
        }
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPower() {
        return (getVolt() * getCurrent()) * this.quantity;
    }
}