package bank;

import java.util.ArrayList;

public class Bank {
 
/*
 * declaratie van aantal rekeningen.
 */
  private Rekening rekeningEen;
  private Rekening rekeningTwee;
  private Rekening rekeningDrie;
  private Rekening rekeningVier;
  private Rekening rekeningVijf;
  
/*
 * lijst ten behoeve van het zoeken van rekeningen. 
 */
  private ArrayList<Rekening> rekeningLijst;

//  constructor
  public Bank () {
    mijnInit();
  }

  /*
   * initialiseert de vijf rekeningen.
   */
  private void mijnInit () {
    this.rekeningEen = new Rekening(1111, "Pieters");
    this.rekeningTwee = new Rekening(1234, "Slotenmakers");
    this.rekeningDrie = new Rekening(2222, "Janssen");
    this.rekeningVier = new Rekening(2345, "van Geel");
    this.rekeningVijf = new Rekening(3333, "van Someren"); 

    /*
     * Lijst voor het beheer van en het zoeken naar rekeningen.
     */
    rekeningLijst = new ArrayList<Rekening>();
      rekeningLijst.add(rekeningEen);
      rekeningLijst.add(rekeningTwee);
      rekeningLijst.add(rekeningDrie);
      rekeningLijst.add(rekeningVier);
      rekeningLijst.add(rekeningVijf);
  }
  
/*
 * methode zoekRekening, indien niet gevonden return null.
 */
public Rekening zoekRekening(int rekeningNummer) {

  for (Rekening r: rekeningLijst) {
    if (r.getRekeningNummer() == rekeningNummer) {
      return r;
    }
  }
  return null;
}

  /*
   * Verhoogt het saldo van deze Rekening met een gegeven 
   * bedrag indien het bedrag groter is dan 0.
   */
  public void stort(int rekeningNummer, double bedrag) {
    for (Rekening r: rekeningLijst) {
      if (r.getRekeningNummer() == rekeningNummer && bedrag > 0) {
        r.stort(bedrag);
      }
    }
  }
  
  /*
   * Verlaagd het saldo met de opname indien het bedrag niet negatief is en het saldo toereikend.
   */
  public void neemOp(int rekeningNummer, double bedrag) {
    for (Rekening r: rekeningLijst) {
      if (r.getRekeningNummer() == rekeningNummer && bedrag > 0 && r.getSaldo() >= bedrag) {
        r.neemOp(bedrag);
      }
    }
  }
  
  public void maakOver(int rekeningNummerVan, double bedrag, int rekeningNummerNaar) {
    if (zoekRekening(rekeningNummerNaar) != null) {
      Rekening rNaar = zoekRekening(rekeningNummerNaar);
      for (Rekening r: rekeningLijst) {
        if (r.getRekeningNummer() == rekeningNummerVan && bedrag > 0 && r.getSaldo() >= bedrag) {
          r.neemOp(bedrag);
          rNaar.stort(bedrag);
        }
      }
    }
  }
  
  public String getRekeningNaam(int rekeningNummer) {
    for (Rekening r: rekeningLijst) {
      if (r.getRekeningNummer() == rekeningNummer) {
        return r.getNaam();
      }
    }
    return null;
  }
  
  public double getRekeningSaldo(int rekeningNummer) {
    for (Rekening r: rekeningLijst) {
      if (r.getRekeningNummer() == rekeningNummer) {
        return r.getSaldo();
      }
    }
    return 0;
  }
  
  public int getRekeningNummer(int rekeningNummer) {
    for (Rekening r: rekeningLijst) {
      if (r.getRekeningNummer() == rekeningNummer) {
        return r.getRekeningNummer();
      }
    }
    return 0;
  }
  
}


