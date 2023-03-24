package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import AtmSystem.CheckingAccount;

public class CheckingAccountTest {  
  @Test
  public void testDeposit1() {
    CheckingAccount account = new CheckingAccount(200, 0, 100, 20);
    // test for deposit under minDepositAmount
    assertEquals(false, account.deposit(10));
    assertEquals(200, account.getBalance(), 0.001);
  }

  @Test
  public void testDeposit2() {
    CheckingAccount account = new CheckingAccount(200, 0, 100, 20);
    // test for deposit equal to minDepositAmount
    assertEquals(true, account.deposit(20));
    assertEquals(220, account.getBalance(), 0.001);
  }

  @Test
  public void testDeposit3() {
    CheckingAccount account = new CheckingAccount(200, 0, 100, 20);
    // test for deposit above to minDepositAmount
    assertEquals(true, account.deposit(30));
    assertEquals(230, account.getBalance(), 0.001);
  }

  @Test
  public void testWithdraw1() {
    CheckingAccount account = new CheckingAccount(200, 0, 300, 20);
    // test for withdraw greater than balance
    assertEquals(false, account.withdraw(250));
  }

  @Test
  public void testWithdraw2() {
    CheckingAccount account = new CheckingAccount(200, 0, 100, 20);
    // test for withdraw greater than withdrawLimit
    assertEquals(false, account.withdraw(150));
  }

  @Test
  public void testWithdraw3() {
    CheckingAccount account = new CheckingAccount(200, 0, 100, 20);
    // test for successful withdraw
    assertEquals(true, account.withdraw(50));
    assertEquals(150, account.getBalance(), 0.001);
  }
}
