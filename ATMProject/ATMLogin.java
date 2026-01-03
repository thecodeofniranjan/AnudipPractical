import javax.swing.*;
import java.awt.event.*;

public class ATMLogin extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1;

    ATMLogin() {
        l1 = new JLabel("Enter User ID:");
        l2 = new JLabel("Enter PIN:");

        t1 = new JTextField();
        t2 = new JPasswordField();

        b1 = new JButton("Login");

        l1.setBounds(50, 50, 100, 30);
        t1.setBounds(160, 50, 150, 30);

        l2.setBounds(50, 100, 100, 30);
        t2.setBounds(160, 100, 150, 30);

        b1.setBounds(130, 160, 100, 30);

        add(l1); add(t1);
        add(l2); add(t2);
        add(b1);

        b1.addActionListener(this);

        setTitle("ATM Login");
        setSize(400, 300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String user = t1.getText();
        String pin = t2.getText();

        if (user.equals("admin") && pin.equals("1234")) {
            new ATMMenu();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login");
        }
    }

    public static void main(String[] args) {
        new ATMLogin();
    }
}
