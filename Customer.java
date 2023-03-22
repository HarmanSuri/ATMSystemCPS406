import java.util.LinkedList;

public class Customer extends Person {
  private String name;
  private String address;
  private int phoneNum;
  private int custID;
  private LinkedList<Account> custAcc;
  private int cardNum;
  private int pin;

  public Customer(String name, String address, int phoneNum, int custID, LinkedList<Account> custAcc, int cardNum, int pin) {
    super(name, address, phoneNum);
    this.custID = custID;
    this.custAcc = custAcc;
    this.cardNum = cardNum;
    this.pin = pin;
  }
  
  public int getCustomerID() {
    return custID;
  }

  public int getCardNumber() {
    return cardNum;
  }

  public int getPin() {
    return pin;
  }

  public LinkedList<Account> getAccounts() {
    return custAcc;
  }

  public boolean setPin(int oldPin, int newPin) {
    if (oldPin != pin || oldPin == newPin) {
      return false;
    }
    pin = newPin;
    return true;
  }
}
