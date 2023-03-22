
public class SavingsAccount extends Account {
  
  private double balance, withdrawLimit, intrestRate;
  private int accID, maxMonthlyWithdraws, withdrawCount;

  public SavingsAccount(double balance, int accID, double withdrawLimit, double intrestRate, int maxMonthlyWithdraws) {
    super(balance, accID, withdrawLimit);
    this.intrestRate = intrestRate;
    this.maxMonthlyWithdraws = maxMonthlyWithdraws;
    this.withdrawCount = 0;
  }

  public boolean deposit(double cash) {
    setBalance(balance + cash);
    return true;
  }

  public boolean withdraw(double cash) {
    if (cash >= balance || cash > withdrawLimit || withdrawCount >= maxMonthlyWithdraws) {
      return false;
    }
    setBalance(balance - cash);
    withdrawCount++;
    return true;
  }
}
