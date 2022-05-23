
public class BankAccount {

    boolean open;
    double balance;

    public BankAccount() {
        open = false;
        balance = 0;
    }

    private boolean isOpen() {
        return open;
    }

    public void open() {
        open = true;
    }

    public void close() {
        open = false;
    }

    public double getBalance() throws BankAccountActionInvalidException {
        if (!isOpen())
        {
            throw new BankAccountActionInvalidException("Account closed");
        }
        return balance;
    }

    public void deposit(int value) throws BankAccountActionInvalidException {
        if (isOpen()) {
            if (value > 0)
            {
                balance = (balance + value);
            }
            else
            {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
        }
        else
        {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    public void withdraw(double value) throws BankAccountActionInvalidException {
        if (isOpen())
        {
            if (value > 0)
            {
                if (balance == 0)
                {
                    throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
                }
                else if (value > balance)
                {
                    throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
                }
                else
                {
                    balance = (balance - value);
                }
            } else if (value == 0)
            {
                throw new BankAccountActionInvalidException("Cannot withdraw 0 from an account account");
            }
            else
            {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
        }
        else
        {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }
}
