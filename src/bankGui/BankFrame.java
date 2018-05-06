package bankGui;

import bank.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;

public class BankFrame extends JFrame {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private Bank internetBank = new Bank();

  private JPanel contentPane;
  private JLabel rekeningVanLabel;
  private JTextField rekeningVanVeld;
  private JLabel naamVanLabel;
  private JTextField naamVanVeld;
  private JLabel saldoVanLabel;
  private JTextField saldoVanVeld;
  private JLabel bedragVanLabel;
  private JTextField bedragVanVeld;
  private JLabel vanLabel;
  private JPanel panel;
  private JPanel panel_1;
  private JLabel label;
  private JLabel rekeningNaarLabel;
  private JTextField rekeningNaarVeld;
  private JLabel naamNaarLabel;
  private JTextField naamNaarVeld;
  private JLabel saldoNaarLabel;
  private JTextField saldoNaarVeld;
  private JLabel bedragNaarLabel;
  private JTextField bedragNaarVeld;
  private JLabel label_1;
  private JButton maakOverKnop;
  private JButton stortNaarKnop;
  private JButton neemOpNaarKnop;
  private JButton zoekNaarKnop;
  private JButton stortVanKnop;
  private JButton neemOpVanKnop;
  private JButton zoekVanKnop;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          BankFrame frame = new BankFrame();
          frame.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public BankFrame() {
    initialize();
    mijnInit();
  }
  
//beginwaarden van de velden

  private void mijnInit() {
    int vanRekening = 1111;
    rekeningVanVeld.setText(String.valueOf(internetBank.getRekeningNummer(vanRekening)));
    naamVanVeld.setText(internetBank.getRekeningNaam(vanRekening));
    saldoVanVeld.setText(Double.toString(internetBank.getRekeningSaldo(vanRekening)));
    bedragVanVeld.setText("");
    
    int naarRekening = 1234;
    rekeningNaarVeld.setText(String.valueOf(internetBank.getRekeningNummer(naarRekening)));
    naamNaarVeld.setText(internetBank.getRekeningNaam(naarRekening));
    saldoNaarVeld.setText(Double.toString(internetBank.getRekeningSaldo(naarRekening)));
    bedragNaarVeld.setText("");
  }
  
  private void initialize() {
    setTitle("Bank Applicatie");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 782, 452);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getPanel());
    contentPane.add(getPanel_1());
    contentPane.add(getLabel_1());
    contentPane.add(getMaakOverKnop());
    contentPane.add(getStortNaarKnop());
    contentPane.add(getNeemOpNaarKnop());
    contentPane.add(getZoekNaarKnop());
    contentPane.add(getStortVanKnop());
    contentPane.add(getNeemOpVanKnop());
    contentPane.add(getZoekVanKnop());
  }
  
/*
 * Eigen methoden voor event handlers
 */
  private void zoekVanKnopAction() {
    naamVanVeld.setText(internetBank.getRekeningNaam(Integer.parseInt(rekeningVanVeld.getText())));
    saldoVanVeld.setText(String.valueOf(internetBank.getRekeningSaldo(Integer.parseInt(rekeningVanVeld.getText()))));
    bedragVanVeld.setText(String.valueOf(0));
  }
  
  private void zoekNaarKnopAction() {
    naamNaarVeld.setText(internetBank.getRekeningNaam(Integer.parseInt(rekeningNaarVeld.getText())));
    saldoNaarVeld.setText(String.valueOf(internetBank.getRekeningSaldo(Integer.parseInt(rekeningNaarVeld.getText()))));
    bedragNaarVeld.setText(String.valueOf(0));
  }
  
  private void stortKnopVanAction() {
    Double bedrag = Double.parseDouble(bedragVanVeld.getText());  
    internetBank.stort(Integer.parseInt(rekeningVanVeld.getText()), bedrag);
    DecimalFormat df = new DecimalFormat("####0.00");
    saldoVanVeld.setText(df.format(internetBank.getRekeningSaldo(Integer.parseInt(rekeningVanVeld.getText()))));
  }
  
  private void stortKnopNaarAction() {
    Double bedrag = Double.parseDouble(bedragNaarVeld.getText());  
    internetBank.stort(Integer.parseInt(rekeningNaarVeld.getText()), bedrag);
    DecimalFormat df = new DecimalFormat("####0.00");
    saldoNaarVeld.setText(df.format(internetBank.getRekeningSaldo(Integer.parseInt(rekeningNaarVeld.getText()))));
  }
  
  private void neemOpKnopVanAction() {
    Double bedrag = Double.parseDouble(bedragVanVeld.getText());  
    internetBank.neemOp(Integer.parseInt(rekeningVanVeld.getText()), bedrag);
    DecimalFormat df = new DecimalFormat("####0.00");
    saldoVanVeld.setText(df.format(internetBank.getRekeningSaldo(Integer.parseInt(rekeningVanVeld.getText()))));
  }
  
  private void neemOpKnopNaarAction() {
    Double bedrag = Double.parseDouble(bedragNaarVeld.getText());  
    internetBank.neemOp(Integer.parseInt(rekeningNaarVeld.getText()), bedrag);
    DecimalFormat df = new DecimalFormat("####0.00");
    saldoNaarVeld.setText(df.format(internetBank.getRekeningSaldo(Integer.parseInt(rekeningNaarVeld.getText()))));
  }
  
  private void maakOverKnopAction() {
    Double bedrag = Double.parseDouble(bedragVanVeld.getText());  
    DecimalFormat df = new DecimalFormat("####0.00");
 
    internetBank.maakOver(Integer.parseInt(rekeningVanVeld.getText()), bedrag, Integer.parseInt(rekeningNaarVeld.getText()));
    saldoVanVeld.setText(df.format(internetBank.getRekeningSaldo(Integer.parseInt(rekeningVanVeld.getText()))));
    saldoNaarVeld.setText(df.format(internetBank.getRekeningSaldo(Integer.parseInt(rekeningNaarVeld.getText()))));
}
    
  private JLabel getRekeningVanLabel() {
    if (rekeningVanLabel == null) {
        rekeningVanLabel = new JLabel("Rekeningnummer:");
        rekeningVanLabel.setBounds(10, 47, 111, 14);
    }
    return rekeningVanLabel;
  }
  private JTextField getRekeningVanVeld() {
    if (rekeningVanVeld == null) {
        rekeningVanVeld = new JTextField();
        rekeningVanVeld.setBounds(120, 41, 100, 20);
        rekeningVanVeld.setColumns(10);
    }
    return rekeningVanVeld;
  }
  private JLabel getNaamVanLabel() {
    if (naamVanLabel == null) {
        naamVanLabel = new JLabel("Naam:");
        naamVanLabel.setBounds(10, 75, 66, 14);
    }
    return naamVanLabel;
  }
  private JTextField getNaamVanVeld() {
    if (naamVanVeld == null) {
        naamVanVeld = new JTextField();
        naamVanVeld.setBounds(120, 72, 100, 20);
        naamVanVeld.setColumns(10);
    }
    return naamVanVeld;
  }
  private JLabel getSaldoVanLabel() {
    if (saldoVanLabel == null) {
        saldoVanLabel = new JLabel("Saldo:");
        saldoVanLabel.setBounds(10, 118, 85, 14);
    }
    return saldoVanLabel;
  }
  private JTextField getSaldoVanVeld() {
    if (saldoVanVeld == null) {
        saldoVanVeld = new JTextField();
        saldoVanVeld.setBounds(120, 115, 100, 20);
        saldoVanVeld.setColumns(10);
    }
    return saldoVanVeld;
  }
  private JLabel getBedragVanLabel() {
    if (bedragVanLabel == null) {
        bedragVanLabel = new JLabel("Bedrag:");
        bedragVanLabel.setBounds(10, 159, 66, 17);
    }
    return bedragVanLabel;
  }
  private JTextField getBedragVanVeld() {
    if (bedragVanVeld == null) {
        bedragVanVeld = new JTextField();
        bedragVanVeld.setBounds(120, 158, 100, 20);
        bedragVanVeld.setColumns(10);
    }
    return bedragVanVeld;
  }
  private JLabel getVanLabel() {
    if (vanLabel == null) {
        vanLabel = new JLabel("Van");
        vanLabel.setBounds(120, 11, 58, 14);
        vanLabel.setHorizontalAlignment(SwingConstants.CENTER);
        vanLabel.setVerticalAlignment(SwingConstants.TOP);
    }
    return vanLabel;
  }
  private JPanel getPanel() {
    if (panel == null) {
        panel = new JPanel();
        panel.setBackground(SystemColor.controlHighlight);
        panel.setBounds(56, 59, 250, 221);
        panel.setLayout(null);
        panel.add(getRekeningVanLabel());
        panel.add(getRekeningVanVeld());
        panel.add(getSaldoVanLabel());
        panel.add(getVanLabel());
        panel.add(getSaldoVanVeld());
        panel.add(getBedragVanLabel());
        panel.add(getBedragVanVeld());
        panel.add(getNaamVanLabel());
        panel.add(getNaamVanVeld());
    }
    return panel;
  }
  private JPanel getPanel_1() {
    if (panel_1 == null) {
        panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.controlHighlight);
        panel_1.setBounds(433, 59, 250, 221);
        panel_1.setLayout(null);
        panel_1.add(getRekeningNaarLabel());
        panel_1.add(getLabel());
        panel_1.add(getRekeningNaarVeld());
        panel_1.add(getNaamNaarLabel());
        panel_1.add(getNaamNaarVeld());
        panel_1.add(getSaldoNaarLabel());
        panel_1.add(getSaldoNaarVeld());
        panel_1.add(getBedragNaarLabel());
        panel_1.add(getBedragNaarVeld());
    }
    return panel_1;
  }
  private JLabel getLabel() {
    if (label == null) {
        label = new JLabel("Naar");
        label.setBounds(133, 11, 67, 14);
    }
    return label;
  }
  private JLabel getRekeningNaarLabel() {
    if (rekeningNaarLabel == null) {
        rekeningNaarLabel = new JLabel("Rekeningnummer:");
        rekeningNaarLabel.setBounds(10, 44, 113, 14);
    }
    return rekeningNaarLabel;
  }
  private JTextField getRekeningNaarVeld() {
    if (rekeningNaarVeld == null) {
        rekeningNaarVeld = new JTextField();
        rekeningNaarVeld.setBounds(133, 41, 86, 20);
        rekeningNaarVeld.setColumns(10);
    }
    return rekeningNaarVeld;
  }
  private JLabel getNaamNaarLabel() {
    if (naamNaarLabel == null) {
        naamNaarLabel = new JLabel("Naam:");
        naamNaarLabel.setBounds(10, 79, 97, 14);
    }
    return naamNaarLabel;
  }
  private JTextField getNaamNaarVeld() {
    if (naamNaarVeld == null) {
        naamNaarVeld = new JTextField();
        naamNaarVeld.setBounds(133, 76, 86, 20);
        naamNaarVeld.setColumns(10);
    }
    return naamNaarVeld;
  }
  private JLabel getSaldoNaarLabel() {
    if (saldoNaarLabel == null) {
        saldoNaarLabel = new JLabel("Saldo: ");
        saldoNaarLabel.setBounds(10, 123, 97, 14);
    }
    return saldoNaarLabel;
  }
  private JTextField getSaldoNaarVeld() {
    if (saldoNaarVeld == null) {
        saldoNaarVeld = new JTextField();
        saldoNaarVeld.setBounds(133, 117, 86, 20);
        saldoNaarVeld.setColumns(10);
    }
    return saldoNaarVeld;
  }
  private JLabel getBedragNaarLabel() {
    if (bedragNaarLabel == null) {
        bedragNaarLabel = new JLabel("Bedrag:");
        bedragNaarLabel.setBounds(10, 162, 97, 14);
    }
    return bedragNaarLabel;
  }
  private JTextField getBedragNaarVeld() {
    if (bedragNaarVeld == null) {
        bedragNaarVeld = new JTextField();
        bedragNaarVeld.setBounds(133, 159, 86, 20);
        bedragNaarVeld.setColumns(10);
    }
    return bedragNaarVeld;
  }
  private JLabel getLabel_1() {
    if (label_1 == null) {
        label_1 = new JLabel("Internet Bank");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_1.setBounds(310, 11, 96, 14);
    }
    return label_1;
  }
  
// knoppen met verwijzing naar de juiste methode
  private JButton getMaakOverKnop() {
    if (maakOverKnop == null) {
        maakOverKnop = new JButton("maak over");
        maakOverKnop.setBackground(UIManager.getColor("Button.light"));
        maakOverKnop.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            maakOverKnopAction();
          }
        });
        maakOverKnop.setBounds(310, 325, 96, 23);
    }
    return maakOverKnop;
  }
  private JButton getStortNaarKnop() {
    if (stortNaarKnop == null) {
        stortNaarKnop = new JButton("stort");
        stortNaarKnop.setBackground(UIManager.getColor("Button.light"));
        stortNaarKnop.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        stortKnopNaarAction();
          }
        });
        stortNaarKnop.setBounds(422, 325, 103, 23);
    }
    return stortNaarKnop;
  }
  private JButton getNeemOpNaarKnop() {
    if (neemOpNaarKnop == null) {
        neemOpNaarKnop = new JButton("neem op");
        neemOpNaarKnop.setBackground(UIManager.getColor("Button.light"));
        neemOpNaarKnop.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            neemOpKnopNaarAction();
          }
        });
        neemOpNaarKnop.setBounds(535, 325, 89, 23);
    }
    return neemOpNaarKnop;
  }
  private JButton getZoekNaarKnop() {
    if (zoekNaarKnop == null) {
        zoekNaarKnop = new JButton("zoek");
        zoekNaarKnop.setBackground(UIManager.getColor("Button.light"));
        zoekNaarKnop.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            zoekNaarKnopAction();
          }
        });
        zoekNaarKnop.setBounds(634, 325, 89, 23);
    }
    return zoekNaarKnop;
  }
  private JButton getStortVanKnop() {
    if (stortVanKnop == null) {
        stortVanKnop = new JButton("stort");
        stortVanKnop.setBackground(UIManager.getColor("Button.light"));
        stortVanKnop.setForeground(Color.BLACK);
        stortVanKnop.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            stortKnopVanAction();
          }
        });
        stortVanKnop.setBounds(28, 325, 89, 23);
    }
    return stortVanKnop;
  }
  private JButton getNeemOpVanKnop() {
    if (neemOpVanKnop == null) {
        neemOpVanKnop = new JButton("neem op");
        neemOpVanKnop.setBackground(UIManager.getColor("Button.light"));
        neemOpVanKnop.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            neemOpKnopVanAction();
          }
        });
        neemOpVanKnop.setBounds(127, 325, 89, 23);
    }
    return neemOpVanKnop;
  }
  private JButton getZoekVanKnop() {
    if (zoekVanKnop == null) {
        zoekVanKnop = new JButton("zoek");
        zoekVanKnop.setBackground(UIManager.getColor("Button.light"));
        zoekVanKnop.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            zoekVanKnopAction();
          }
        });
        zoekVanKnop.setBounds(226, 325, 74, 23);
    }
    return zoekVanKnop;
  }
}
