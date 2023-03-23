package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import AtmSystem.Person;

public class PersonTest {
  Person person = new Person("John Doe", "123 Nowhere St.", "123-456-7890");

  @Test
  public void testGetName() {
    assertEquals(person.getName(), "John Doe");
  }

  @Test
  public void testGetAddress() {
    assertEquals(person.getAddress(), "123 Nowhere St.");
  }

  @Test
  public void testGetPhoneNumber() {
    assertEquals(person.getPhoneNumber(), "123-456-7890");
  }

  @Test
  public void testSetName() {
    person.setName("Scott Smith");
    assertEquals(person.getName(), "Scott Smith");
  }

  @Test
  public void testSetAddress() {
    person.setAddress("341 Yonge St.");
    assertEquals(person.getAddress(), "341 Yonge St.");
  }

  @Test
  public void testSetPhoneNumber() {
    person.setPhoneNumber("416-641-4358");
    assertEquals(person.getPhoneNumber(), "416-641-4358");
  }
}
