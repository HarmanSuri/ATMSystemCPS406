
public class Person {
  private String name;
  private String address;
  private int phoneNum;

  public Person(String name, String address, int phoneNum) {
    this.name = name;
    this.address = address;
    this.phoneNum = phoneNum;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public int getPhoneNumber() {
    return phoneNum;
  }

  public void setName(String newName) {
    name = newName;
  }

  public void setAddress(String newAddress) {
    address = newAddress;
  }

  public void setPhoneNumber(int newPhoneNumber) {
    phoneNum = newPhoneNumber;
  }
}
