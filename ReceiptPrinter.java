
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ReceiptPrinter extends JPanel {
  Border brdButtons;
  Font fntTransaction, fntReciept, fntButton;
  JPanel pnlButtons, pnlText, pnlSouth, pnlLeft, pnlRight;
  JLabel lblTransaction, lblReciept;
  JButton btnYes, btnNo;

  public ReceiptPrinter(String transactionName) throws IOException {
    brdButtons = BorderFactory.createLineBorder(new Color(94, 168, 128), 7);

    fntTransaction = new Font(null, Font.BOLD, 40);
    fntReciept = new Font(null, Font.PLAIN, 20);
    fntButton = new Font(null, Font.PLAIN, 30);

    pnlButtons = new JPanel();
    pnlText = new JPanel();
    pnlSouth = new JPanel();
    pnlLeft = new JPanel();
    pnlRight = new JPanel();

    pnlText.setBackground(new Color(51, 51, 51));
    pnlButtons.setBackground(new Color(51, 51, 51));
    pnlSouth.setBackground(new Color(51, 51, 51));
    pnlLeft.setBackground(new Color(51, 51, 51));
    pnlRight.setBackground(new Color(51, 51, 51));

    lblTransaction = new JLabel(transactionName + " Successful");
    lblTransaction.setFont(fntTransaction);
    lblTransaction.setOpaque(true);
    lblTransaction.setForeground(Color.GREEN);
    lblTransaction.setBackground(new Color(51, 51, 51));
    lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
    lblTransaction.setVerticalAlignment(SwingConstants.CENTER);

    lblReciept = new JLabel("Would You Like a Receipt?");
    lblReciept.setFont(fntReciept);
    lblReciept.setOpaque(true);
    lblReciept.setForeground(Color.WHITE);
    lblReciept.setBackground(new Color(51, 51, 51));
    lblReciept.setHorizontalAlignment(SwingConstants.CENTER);
    lblReciept.setVerticalAlignment(SwingConstants.CENTER);
    
    btnYes = new JButton("Yes");
    btnYes.setBorder(brdButtons);
    btnYes.setBackground(new Color(51, 51, 51));
    btnYes.setForeground(Color.WHITE);
    btnYes.setFont(fntButton);

    btnNo = new JButton("No");
    btnNo.setBorder(brdButtons);
    btnNo.setBackground(new Color(51, 51, 51));
    btnNo.setForeground(Color.WHITE);
    btnNo.setFont(fntButton);

    pnlText.setLayout(new BorderLayout());
    pnlText.add(lblTransaction, BorderLayout.NORTH);
    pnlText.add(lblReciept, BorderLayout.CENTER);
    pnlText.setPreferredSize(new Dimension(200,200));
    
    pnlButtons.setLayout(new GridLayout(1, 2, 90, 10));
    pnlButtons.setSize(600, 200);
    pnlButtons.add(btnYes);
    pnlButtons.add(btnNo);    
    
    pnlSouth.setPreferredSize(new Dimension(0, 150));
    pnlLeft.setPreferredSize(new Dimension(100, 0));
    pnlRight.setPreferredSize(new Dimension(100, 0));


    setLayout(new BorderLayout());
    add(pnlText, BorderLayout.NORTH);
    add(pnlButtons, BorderLayout.CENTER);
    add(pnlSouth, BorderLayout.SOUTH);
    add(pnlLeft, BorderLayout.LINE_START);
    add(pnlRight, BorderLayout.LINE_END);

    btnYes.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Reciept printed");
      }
    });

    btnYes.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Reciept printed");
      }
    });

  }

  public static void main(String[] args) throws IOException {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new ReceiptPrinter("Deposit"));
    frame.setSize(700, 500);
    frame.setVisible(true);
  }
}