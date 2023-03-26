package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import AtmSystem.SavingsAccount;

public class SavingsAccountTest {

    @Test
    public void testDeposit1() {
        SavingsAccount account = new SavingsAccount(200, 3, 1000, 0.08, 30);
        // test for deposit
        assertEquals(true, account.deposit(10));
        assertEquals(210, account.getBalance(), 0.001);
    }

    @Test
    public void testDeposit2() {
        SavingsAccount account = new SavingsAccount(200, 3, 1000, 0.08, 30);
        // test for deposit
        assertEquals(true, account.deposit(20));
        assertEquals(220, account.getBalance(), 0.001);
    }

    @Test
    public void testDeposit3() {
        SavingsAccount account = new SavingsAccount(200, 3, 1000, 0.08, 30);
        // test for deposit
        assertEquals(true, account.deposit(500));
        assertEquals(700, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw1() {
        SavingsAccount account = new SavingsAccount(200, 3, 1000, 0.08, 30);
        // test for withdraw greater than balance
        assertEquals(false, account.withdraw(250));
    }

    @Test
    public void testWithdraw2() {
        SavingsAccount account = new SavingsAccount(2000, 3, 1000, 0.08, 30);
        // test for withdraw greater than withdrawLimit
        assertEquals(false, account.withdraw(1200));
    }

    @Test
    public void testWithdraw3() {
        SavingsAccount account = new SavingsAccount(2000, 3, 1000, 0.08, 30);
        // test for successful withdraw
        assertEquals(true, account.withdraw(500));
        assertEquals(1500, account.getBalance(), 0.001);
    }

    @Test
    public void testmaxMonthlyWithdraws1() {
        SavingsAccount account = new SavingsAccount(2000, 0, 1000, 0.08, 2);
        // test for withdraws below to maxmonthlywithdraws

        assertEquals(true, account.withdraw(100));
        assertEquals(1900, account.getBalance(), 0);

    }

    @Test
    public void testmaxMonthlyWithdraws2() {
        SavingsAccount account = new SavingsAccount(2000, 0, 1000, 0.08, 0);
        // test for withdraws above to maxmonthlywithdraws

        assertEquals(false, account.withdraw(100));
        assertEquals(2000, account.getBalance(), 0);

    }

    @Test
    public void testSetInterestRate1() {
        SavingsAccount account = new SavingsAccount(2000, 0, 1000, 0.20, 0);
        // test for setting the interest rate
        account.setIntrestRate(0.1);
        assertEquals(0.1, account.getIntrestRate(), 0.001);
    }

    @Test
    public void testSetInterestRate2() {
        SavingsAccount account = new SavingsAccount(2000, 0, 1000, 0.08, 0);
        // test for setting the interest rate
        account.setIntrestRate(0.3);
        assertEquals(0.3, account.getIntrestRate(), 0.001);
    }

    @Test
    public void testGetInterestRate1() {
        SavingsAccount account = new SavingsAccount(2000, 0, 1000, 0.08, 0);
        // test for getting interest rate
        assertEquals(0.08, account.getIntrestRate(), 0.001);
    }

    @Test
    public void testGetInterestRate2() {
        SavingsAccount account = new SavingsAccount(2000, 0, 1000, 0.25, 0);
        // test for getting interest rate
        assertEquals(0.25, account.getIntrestRate(), 0.001);
    }
}