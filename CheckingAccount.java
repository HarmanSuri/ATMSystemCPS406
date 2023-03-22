public class CheckingAccount extends Account {
  private double balance, withdrawLimit, minDepositAmount;
  private int accID;

  public CheckingAccount(double balance, int accID, double withdrawLimit, double minDepositAmount) {
    super(balance, accID, withdrawLimit);
    this.minDepositAmount = minDepositAmount;
  }

  public boolean deposit(double cash) {
    if (cash < minDepositAmount) {
      return false;
    }
    setBalance(balance + cash);
    return true;
  }

  public boolean withdraw(double cash) {
    if (cash >= balance || cash > withdrawLimit) {
      return false;
    }
    setBalance(balance - cash);
    return true;
  }
}
