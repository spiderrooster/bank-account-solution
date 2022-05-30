
public class BankAccount
{
    boolean open;
    double balance;

    public BankAccount()
    {
        open = false;
        balance = 0;
    }

    public synchronized boolean isOpen()
    {
        return open;
    }

    public synchronized void open()
    {
        open = true;
    }

    public synchronized void close()
    {
        open = false;
    }

    public double getBalance() throws BankAccountActionInvalidException
    {
        if (!isOpen())
        {
            throw new BankAccountActionInvalidException("Account closed");
        }
        return balance;
    }

    public synchronized void deposit(int value) throws BankAccountActionInvalidException
    {
        if (!isOpen())
        {
            throw new BankAccountActionInvalidException("Account closed");
        }
        else
        {
            if (value < 0)
            {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
            else
            {
                balance = (balance + value);
            }
        }
    }

    public synchronized void withdraw(double value) throws BankAccountActionInvalidException
    {
        if (!isOpen())
        {
            throw new BankAccountActionInvalidException("Account closed");
        }

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
        }
        else if (value == 0)
        {
            throw new BankAccountActionInvalidException("Cannot withdraw 0 from an account account");
        }
        else
        {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
    }
}
