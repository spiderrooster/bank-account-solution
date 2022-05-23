
public class BankAccount {

    boolean open;
    int balance;

    public BankAccount() {
        open = false;
        balance = 0;
    }

    public void open() {
        open = true;
    }

    public void close() {
        open = false;
    }

    public int getBalance() throws BankAccountActionInvalidException {
        if (!open) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        return balance;
    }

    public void deposit(int value) throws BankAccountActionInvalidException {
        if (open) {
            if (value > 0) {
                balance = balance + value;
            } else {
                throw new BankAccountActionInvalidException("Deposit cannot be minus amount try " +
                        "using withdraw");
            }
        } else {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    public void withdraw(double value) {

    }
}
