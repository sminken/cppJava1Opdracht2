package bankTest;

import static org.junit.Assert.*;

import org.junit.Test;
import bank.*;

public class BankTest {

//Constante voor het meten van afrondingsverschillen bij het vergelijken van doubles.
  private static final double EPSILON = 1e-16;
  Bank internetBank;

  @Test
  public void testZoekRekening() {
    internetBank = new Bank();
    Rekening rekening = internetBank.zoekRekening(4444);
    assertEquals(null, rekening); 
  }

  @Test
  public void testStort() {
    internetBank = new Bank();
    internetBank.stort(1111, -20);
    assertEquals(0,internetBank.getRekeningSaldo(1111), EPSILON);
    internetBank.stort(1111, 10);
    assertEquals(10,internetBank.getRekeningSaldo(1111), EPSILON);
  }

  @Test
  public void testNeemOp() {
    internetBank = new Bank();
    internetBank.neemOp(1111, 15);
    assertEquals(0,internetBank.getRekeningSaldo(1111), EPSILON);
    internetBank.neemOp(1111, 30);
    assertEquals(0,internetBank.getRekeningSaldo(1111), EPSILON);
    internetBank.neemOp(1111, -15);
    assertEquals(0,internetBank.getRekeningSaldo(1111), EPSILON);
  }

  @Test
  public void maakOver() {
    internetBank = new Bank();
    internetBank.stort(1111, 30);
    internetBank.maakOver(1111, 15, 1234);
    assertEquals(15,internetBank.getRekeningSaldo(1111), EPSILON);
    assertEquals(15,internetBank.getRekeningSaldo(1234), EPSILON);
  }
    
    
  @Test
  public void testGetRekeningNaam() {
    internetBank = new Bank();
    assertEquals("Pieters", internetBank.getRekeningNaam(1111));
  }

  @Test
  public void testGetRekeningSaldo() {
    internetBank = new Bank();
    assertEquals(0, internetBank.getRekeningSaldo(1111), EPSILON);
  }

  @Test
  public void testGetRekeningNummer() {
    internetBank = new Bank();
    assertEquals(1111, internetBank.getRekeningNummer(1111), EPSILON);
  }

}
