package bank;

public class Rekening {

/*
 * Attributen. rekeningNummer en naam kunnen niet meer gewijzigd worden na initialisatie.
 */
  private final int rekeningNummer;
  private final String naam;
  private double saldo;
  
/*
 * Constructor. Deze is protected alleen de klasse Bank binnen deze package nieuwe rekeningen kan aanmaken.
 */
  protected Rekening(int rekeningNummer, String naam) {
    this.rekeningNummer = rekeningNummer;
    this.naam = naam;
    this.saldo = 0.0;
  }
  
  /*
   * Methoden. Deze zijn protected en alleen aan te roepen door klasse Bank binnen deze package.
   */
  protected void neemOp(double bedrag) {
    saldo = saldo - bedrag;
  }

  protected void stort(double bedrag) {
    saldo = saldo + bedrag;
  }

  protected int getRekeningNummer() {
    return rekeningNummer;
  }

  protected String getNaam() {
    return naam;
  }

  protected double getSaldo() {
    return saldo;
  }

}
