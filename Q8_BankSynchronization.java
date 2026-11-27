
class BankAccount {

    private int balance = 1000;

    synchronized void deposit(int amount) {
        System.out.println("Depositing: " + amount);

        balance = balance + amount;

        System.out.println("Balance after deposit: " + balance);
    }

    synchronized void withdraw(int amount) {

        System.out.println("Withdrawing: " + amount);

        if (balance >= amount) {
            balance = balance - amount;

            System.out.println(
                "Balance after withdrawal: " + balance
            );
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    synchronized void displayBalance() {
        System.out.println("Final Balance: " + balance);
    }
}

class DepositThread extends Thread {

    BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.deposit(500);
    }
}

class WithdrawThread extends Thread {

    BankAccount account;

    WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.withdraw(300);
    }
}

public class Q8_BankSynchronization {

    public static void main(String[] args)
            throws InterruptedException {

        BankAccount account = new BankAccount();

        DepositThread t1 = new DepositThread(account);
        WithdrawThread t2 = new WithdrawThread(account);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        account.displayBalance();
    }
}
