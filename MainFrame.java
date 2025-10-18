import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame{
    final private Font mainFont = new Font("Poppins", Font.BOLD, 20);
    JTextField billerName, billerAddress, billerContact;

    public void initialize() {
        /*FORMS PANEL */
        JLabel billerFullName = new JLabel("Biller's Name: ");
        billerFullName.setFont(mainFont);
    }
}