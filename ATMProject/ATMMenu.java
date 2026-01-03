import java.awt.event.*;
import javax.swing.*;

public class ATMMenu extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4;
    int balance = 5000;

    ATMMenu() {

        b1 = new JButton("Check Balance");
        b2 = new JButton("Deposit");
        b3 = new JButton("Withdraw");
        b4 = new JButton("Exit");

        b1.setBounds(100, 50, 200, 30);
        b2.setBounds(100, 100, 200, 30);
        b3.setBounds(100, 150, 200, 30);
        b4.setBounds(100, 200, 200, 30);

        add(b1); add(b2); add(b3); add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setTitle("ATM Menu");
        setSize(400, 350);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            JOptionPane.showMessageDialog(this, "Current Balance: ₹" + balance);
        }

        if (e.getSource() == b2) {
            String amt = JOptionPane.showInputDialog(this, "Enter Deposit Amount:");
            balance += Integer.parseInt(amt);
            JOptionPane.showMessageDialog(this, "Amount Deposited Successfully");
        }

        if (e.getSource() == b3) {
            String amt = JOptionPane.showInputDialog(this, "Enter Withdrawal Amount:");
            int w = Integer.parseInt(amt);

            if (w > balance) {
                JOptionPane.showMessageDialog(this, "Insufficient Balance");
            } else {
                balance -= w;
                JOptionPane.showMessageDialog(this, "Please Collect Cash");
            }
        }

        if (e.getSource() == b4) {
            JOptionPane.showMessageDialog(this, "Thank You!");
            System.exit(0);
        }
    }
}
