package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import AtmSystem.CheckingAccount;

public class CheckingAccountTest {  

  @Test
    public void testGetBalance1() {
        CheckingAccount account = new CheckingAccount(200, 1, 500, 10);
        assertEquals(200, account.getBalance(), 0.001);
    }

    @Test
    public void testGetBalance2() {
        CheckingAccount account = new CheckingAccount(500, 1, 500, 10);
        assertEquals(500, account.getBalance(), 0.001);
    }

    @Test
    public void testGetAccountID1() {
        CheckingAccount account = new CheckingAccount(200, 1, 500, 10);
        assertEquals(1, account.getAccID());
    }

    @Test
    public void testGetAccountID2() {
        CheckingAccount account = new CheckingAccount(200, 5, 500, 10);
        assertEquals(5, account.getAccID());
    }

    @Test
    public void testGetWithdrawLimit1() {
        CheckingAccount account = new CheckingAccount(200, 1, 500, 10);
        assertEquals(500, account.getWithdrawLimit(), 0.001);
    }

    @Test
    public void testGetWithdrawLimit2() {
        CheckingAccount account = new CheckingAccount(200, 1, 1000, 10);
        assertEquals(1000, account.getWithdrawLimit(), 0.001);
    }

    @Test
    public void testSetBalance1() {
        CheckingAccount account = new CheckingAccount(200, 1, 1000, 10);
        account.setBalance(500);
        assertEquals(500, account.getBalance(), 0.001);
    }

    @Test
    public void testSetBalance2() {
        CheckingAccount account = new CheckingAccount(200, 1, 1000, 10);
        account.setBalance(1000);
        assertEquals(1000, account.getBalance(), 0.001);
    }

    @Test
    public void testSetWithdrawLimit1() {
        CheckingAccount account = new CheckingAccount(200, 1, 1000, 10);
        account.setWithdrawLimit(500);
        assertEquals(500, account.getWithdrawLimit(), 0.001);
    }

    @Test
    public void testSetWithdrawLimit2() {
        CheckingAccount account = new CheckingAccount(200, 1, 1000, 10);
        account.setWithdrawLimit(1200);
        assertEquals(1200, account.getWithdrawLimit(), 0.001);
    }

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
