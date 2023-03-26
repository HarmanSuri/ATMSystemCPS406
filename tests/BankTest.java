package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import java.util.HashMap;

import AtmSystem.Customer;
import AtmSystem.Bank;
import AtmSystem.Account;
import AtmSystem.CheckingAccount;
import AtmSystem.SavingsAccount;


public class BankTest {

  @Test
  public void testGetName() {
    Bank bank = new Bank("Bank", "12 Money St.", null, null);
    assertEquals("Bank", bank.getName());
  }

  @Test
  public void testGetAddress() {
    Bank bank = new Bank("Bank", "12 Money St.", null, null);
    assertEquals("12 Money St.", bank.getAddress());
  }

  @Test
  public void testSetName() {
    Bank bank = new Bank("Bank", "12 Money St.", null, null);
    bank.setName("Canadian Bank");
    assertEquals("Canadian Bank", bank.getName());
  }

  @Test
  public void testSetAddress() {
    Bank bank = new Bank("Bank", "12 Money St.", null, null);
    bank.setAddress("23 Yonge St.");
    assertEquals("23 Yonge St.", bank.getAddress());
  }

  @Test
  public void testCheckCard1() {
    HashMap<Integer, Integer> bankDB = new HashMap<Integer, Integer>() {{
      put(468, 0);
    }};
    HashMap<Integer, Customer> custDB = new HashMap<Integer, Customer>() {{
      put(0, new Customer("John Doe", "123 Nowhere St.", "123-456-7890", 0, null, 468, 1784));
    }};

    Bank bank = new Bank("Bank", "12 Money St.", bankDB, custDB);
    assertEquals(false, bank.checkCard(736));
  }

  @Test
  public void testCheckCard2() {
    HashMap<Integer, Integer> bankDB = new HashMap<Integer, Integer>() {{
      put(468, 0);
    }};
    HashMap<Integer, Customer> custDB = new HashMap<Integer, Customer>() {{
      put(0, new Customer("John Doe", "123 Nowhere St.", "123-456-7890", 0, null, 468, 1784));
    }};

    Bank bank = new Bank("Bank", "12 Money St.", bankDB, custDB);
    assertEquals(true, bank.checkCard(468));
  }

  @Test
  public void testLogin1() {
    HashMap<Integer, Integer> bankDB = new HashMap<Integer, Integer>() {{
      put(468, 0);
    }};
    HashMap<Integer, Customer> custDB = new HashMap<Integer, Customer>() {{
      put(0, new Customer("John Doe", "123 Nowhere St.", "123-456-7890", 0, null, 468, 1784));
    }};

    Bank bank = new Bank("Bank", "12 Money St.", bankDB, custDB);
    assertEquals(null, bank.login(468, 1111));
  }

  @Test
  public void testLogin2() {
    Customer customer = new Customer("John Doe", "123 Nowhere St.", "123-456-7890", 0, null, 468, 1784);
    HashMap<Integer, Integer> bankDB = new HashMap<Integer, Integer>() {{
      put(468, 0);
    }};
    HashMap<Integer, Customer> custDB = new HashMap<Integer, Customer>() {{
      put(0, customer);
    }};

    Bank bank = new Bank("Bank", "12 Money St.", bankDB, custDB);
    assertEquals(customer, bank.login(468, 1784));
  }

  @Test
  public void testGetAccount1() {
    HashMap<Integer, Integer> bankDB = new HashMap<Integer, Integer>() {{
      put(468, 0);
    }};
    HashMap<Integer, Customer> custDB = new HashMap<Integer, Customer>() {{
      put(0, new Customer("John Doe", "123 Nowhere St.", "123-456-7890", 0, null, 468, 1784));
    }};

    Bank bank = new Bank("Bank", "12 Money St.", bankDB, custDB);
    assertArrayEquals(null, bank.getAccount(0));
  }

  @Test
  public void testGetAccount2() {
    CheckingAccount acc1 = new CheckingAccount(100, 1, 50, 100);
    SavingsAccount acc2 = new SavingsAccount(10, 2, 1000, 0.08, 30);

    Account[] accounts = {acc1, acc2};
    Customer customer = new Customer("John Doe", "123 Nowhere St.", "123-456-7890", 0, accounts, 468, 1784);
    
    HashMap<Integer, Integer> bankDB = new HashMap<Integer, Integer>() {{
      put(468, 0);
    }};
    HashMap<Integer, Customer> custDB = new HashMap<Integer, Customer>() {{
      put(0, customer);
    }};

    Bank bank = new Bank("Bank", "12 Money St.", bankDB, custDB);
    assertArrayEquals(accounts, bank.getAccount(0));
  }
}
