package AtmSystem;

import java.util.HashMap;

public class Bank {
  private String name;
  private String address;
  private HashMap<Integer, Integer> bankDB;
  private HashMap<Integer, Customer> custDB;

  public Bank(String name, String address, HashMap<Integer, Integer> bankDB, HashMap<Integer, Customer> custDB) {
    this.name = name;
    this.address = address;
    this.bankDB = bankDB;
    this.custDB = custDB;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public boolean checkCard(int cardNum) {
    if (bankDB.get(cardNum) == null) {
      return false;
    }
    return true;
  }
  public Customer login(int cardNum, int pin) {
    int customerId = bankDB.get(cardNum);
    Customer cust = custDB.get(customerId);
    if (cust == null) {
      return null;
    }
    if (cust.getPin() != pin) {
      return null;
    }
    return cust;
  }
  public Account[] getAccount(int custId) {
    Customer cust = custDB.get(custId);
    if (cust == null) {
      System.out.println("nill");
      return null;
    }
    return cust.getAccounts();
  }
}
