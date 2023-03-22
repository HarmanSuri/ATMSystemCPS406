
abstract class Account {
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

  public abstract boolean deposit(double cash);

  public abstract boolean withdraw(double cash);

  public boolean transfer(double cash, Account otherAcc) {
    if (cash >= this.balance) {
      return false;
    }
    otherAcc.setBalance(otherAcc.getBalance() + cash);
    this.setBalance(this.balance - cash);
    return true;

  }
  
}
