package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import AtmSystem.Person;

public class PersonTest {

  @Test
  public void testGetName() {
    Person person = new Person("John Doe", "123 Nowhere St.", "123-456-7890");
    assertEquals("John Doe", person.getName());
  }

  @Test
  public void testGetAddress() {
    Person person = new Person("John Doe", "123 Nowhere St.", "123-456-7890");
    assertEquals("123 Nowhere St.", person.getAddress());
  }

  @Test
  public void testGetPhoneNumber() {
    Person person = new Person("John Doe", "123 Nowhere St.", "123-456-7890");
    assertEquals("123-456-7890", person.getPhoneNumber());
  }

  @Test
  public void testSetName() {
    Person person = new Person("John Doe", "123 Nowhere St.", "123-456-7890");
    person.setName("Scott Smith");
    assertEquals("Scott Smith", person.getName());
  }

  @Test
  public void testSetAddress() {
    Person person = new Person("John Doe", "123 Nowhere St.", "123-456-7890");
    person.setAddress("341 Yonge St.");
    assertEquals("341 Yonge St.", person.getAddress());
  }

  @Test
  public void testSetPhoneNumber() {
    Person person = new Person("John Doe", "123 Nowhere St.", "123-456-7890");
    person.setPhoneNumber("416-641-4358");
    assertEquals("416-641-4358", person.getPhoneNumber());
  }
}
