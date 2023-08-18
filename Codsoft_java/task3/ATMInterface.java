import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if(amount>0){
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount && amount > 0) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATMGUI extends JFrame {
    private JTextField depositField;
    private JTextField withdrawField;
    private JLabel balanceLabel;

    public ATMGUI(BankAccount account) {
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        balanceLabel = new JLabel("Balance: " + account.getBalance());
        add(balanceLabel);

        JButton checkBalanceButton = new JButton("Check Balance");
        add(checkBalanceButton);
        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                balanceLabel.setText("Balance: " + account.getBalance());
            }
        });

        depositField = new JTextField();
        add(depositField);

        JButton depositButton = new JButton("Deposit");
        add(depositButton);
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(depositField.getText());
                if(account.deposit(amount)){
                    balanceLabel.setText("Balance: " + account.getBalance());
                }else{
                    JOptionPane.showMessageDialog(ATMGUI.this, "Invalid amount!");
                }
                depositField.setText("");
            }
        });

        withdrawField = new JTextField();
        add(withdrawField);

        JButton withdrawButton = new JButton("Withdraw");
        add(withdrawButton);
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(withdrawField.getText());
                if (account.withdraw(amount)) {
                    balanceLabel.setText("Balance: " + account.getBalance());
                } else {
                    JOptionPane.showMessageDialog(ATMGUI.this, "Insufficient balance or Invalid amount!");
                }
                withdrawField.setText("");
            }
        });

        setVisible(true);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        new ATMGUI(userAccount);
    }
}
