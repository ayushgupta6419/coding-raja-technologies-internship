import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ATMStimulator extends JFrame {
    private double balance = 1000; // Initial balance
    private JLabel balanceLabel;
    public ATMStimulator() {
        setTitle("ATM Simulator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeUI();
    }
    private void initializeUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        balanceLabel = new JLabel("Balance: $" + balance);
        panel.add(balanceLabel);
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter deposit amount:");
                if (input != null && !input.isEmpty()) {
                    double depositAmount = Double.parseDouble(input);
                    deposit(depositAmount);
                }
            }
        });
        panel.add(depositButton);
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
                if (input != null && !input.isEmpty()) {
                    double withdrawalAmount = Double.parseDouble(input);
                    withdraw(withdrawalAmount);
                }
            }
        });
        panel.add(withdrawButton);
        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });
        panel.add(checkBalanceButton);
        add(panel);
        setVisible(true);
    }
    private void deposit(double amount) {
        balance += amount;
        updateBalanceLabel();
    }
    private void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            updateBalanceLabel();
        } else {
            JOptionPane.showMessageDialog(this, "Insufficient funds!");
        }
    }
    private void checkBalance() {
        JOptionPane.showMessageDialog(this, "Current Balance: $" + balance);
    }
    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: $" + balance);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMStimulator();
            }
        });
    }
}
