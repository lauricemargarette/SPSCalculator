public class BillerInformation{
    private String billerName, billerAddress, billerContact;

    BillerInformation() {
        this.billerName = "No Name";
        this.billerAddress = "No Address";
        this.billerContact = "No Contact";
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }

    public void setBillerAddress(String billerAddress) {
        this.billerAddress = billerAddress;
    }

    public void setBillerContact(String billerContact) {
        this.billerContact = billerContact;
    }

    public String getBillerName() {
        return billerName;
    }

    public String getBillerAddress() {
        return billerAddress;
    }

    public String getBillerContact() {
        return billerContact;
    }

    public void displayBillerInfo() {
        System.out.println("\nBiller's Information:");
        System.out.println("Name: " + this.billerName);
        System.out.println("Address: " + this.billerAddress);
        System.out.println("Contact Number: " + this.billerContact);
    }
}
