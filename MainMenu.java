
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;

import javax.swing.*;

public class MainMenu extends JPanel {
  Border brdButtons;
  Font fntTitle;
  JPanel pnlAccounts, pnlTitle, pnlSouth, pnlLeft, pnlRight;
  JLabel lblTitle;
  JButton[] accountButtons;

  public MainMenu(int numAccounts) throws IOException {
    brdButtons = BorderFactory.createLineBorder(new Color(94, 168, 128), 7);

    fntTitle = new Font(null, Font.BOLD, 40);

    pnlAccounts = new JPanel();
    pnlTitle = new JPanel();
    pnlSouth = new JPanel();
    pnlLeft = new JPanel();
    pnlRight = new JPanel();

    pnlTitle.setBackground(new Color(51, 51, 51));
    pnlAccounts.setBackground(new Color(51, 51, 51));
    pnlSouth.setBackground(new Color(51, 51, 51));
    pnlLeft.setBackground(new Color(51, 51, 51));
    pnlRight.setBackground(new Color(51, 51, 51));

    lblTitle = new JLabel("Main Menu");
    lblTitle.setFont(fntTitle);
    lblTitle.setOpaque(true);
    lblTitle.setForeground(Color.WHITE);
    lblTitle.setBackground(new Color(51, 51, 51));

    accountButtons = new JButton[numAccounts];

    setLayout(new BorderLayout());
    pnlTitle.add(lblTitle);
    pnlTitle.setPreferredSize(new Dimension(200,150));
    
    pnlAccounts.setLayout(new GridLayout(2, 4, 5, 5));
    pnlAccounts.setSize(600, 200);
    
    for (int i = 0; i < accountButtons.length; i++) {
      accountButtons[i] = new JButton("Account #" + Integer.toString(i + 1));
      accountButtons[i].setBorder(brdButtons);
      accountButtons[i].setBackground(new Color(51, 51, 51));
      accountButtons[i].setForeground(Color.WHITE);
      accountButtons[i].setPreferredSize(new Dimension(60, 10));
      pnlAccounts.add(accountButtons[i]);
    }
    
    pnlSouth.setPreferredSize(new Dimension(0, 100));
    pnlLeft.setPreferredSize(new Dimension(10, 0));
    pnlRight.setPreferredSize(new Dimension(10, 0));
    
    add(pnlTitle, BorderLayout.NORTH);
    add(pnlAccounts, BorderLayout.CENTER);
    add(pnlSouth, BorderLayout.SOUTH);
    add(pnlLeft, BorderLayout.LINE_START);
    add(pnlRight, BorderLayout.LINE_END);

    for (int i = 0; i < accountButtons.length; i++) {
      accountButtons[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JButton btn = (JButton)e.getSource();
          int accIndex = Integer.parseInt(btn.getText().split("#")[1]) - 1;
          System.out.println(accIndex);
        }
      });
    }
  }

  public static void main(String[] args) throws IOException {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new MainMenu(5));
    frame.setSize(700, 500);
    frame.setVisible(true);
  }
}