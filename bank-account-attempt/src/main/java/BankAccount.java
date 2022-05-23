
public class BankAccount {

    boolean open;
    double balance;

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

    public double getBalance() throws BankAccountActionInvalidException {
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

    public void withdraw(double value) throws BankAccountActionInvalidException {
        if (balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        } else if (value > balance) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        } else if (value == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw 0 from an account account");
        } else {
            balance = balance - value;
        }
    }
}
