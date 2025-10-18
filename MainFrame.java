import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JLabel;

public class MainFrame extends JFrame{
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
    MainFrame myFrame = new MainFrame();
    myFrame.initialize();
}
}