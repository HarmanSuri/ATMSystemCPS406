
public class Account {
  private double balance, withdrawLimit;
  private int accID;

  public Account(double balance, int accID, double withdrawLimit) {
    this.balance = balance;
    this.accID = accID;
    this.withdrawLimit = withdrawLimit;
  }

  public double getBalance() {
    return balance;
  }

  public int getAccID() {
    return accID;
  }

  public void setBalance(double balance) {
    balance = this.balance;
  }

  public boolean deposit(double cash) {
    setBalance(balance + cash);
    return true;
  }

  public boolean withdraw(double cash) {
    if (cash < balance && cash <= withdrawLimit) {
      setBalance(balance - cash);
      return true;
    }
    return false;
  }

  public boolean transfer(double cash, Account otherAcc) {
    return false;
  }
  
}
