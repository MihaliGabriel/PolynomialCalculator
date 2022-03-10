package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomeworkView {
    private JFrame frame;
    private JTextField jcomp1;
    private JTextField jcomp2;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JTextField jcomp5;
    private JLabel jcomp6;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JButton jcomp9;
    private JButton jcomp10;
    private JButton jcomp11;
    private JButton jcomp12;
    private JButton jcomp13;
    private JButton jcomp14;

    public HomeworkView() {

        jcomp1 = new JTextField(5);
        jcomp2 = new JTextField(5);
        jcomp3 = new JLabel("Polinom 2");
        jcomp4 = new JLabel("Polinom 1");
        jcomp5 = new JTextField(5);
        jcomp6 = new JLabel("Rezultat");
        jcomp7 = new JLabel("Operatii pe polinomul 1");
        jcomp8 = new JLabel("Operatii pe 2 polinoame");
        jcomp9 = new JButton("Deriveaza");
        jcomp10 = new JButton("Integreaza");
        jcomp11 = new JButton("Adunare");
        jcomp12 = new JButton("Scadere");
        jcomp13 = new JButton("Inmultire");
        jcomp14 = new JButton("Impartire");


        frame = new JFrame("Calculator polinomial");
        frame.setSize(new Dimension(752, 430));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.add(jcomp1);
        frame.add(jcomp2);
        frame.add(jcomp3);
        frame.add(jcomp4);
        frame.add(jcomp5);
        frame.add(jcomp6);
        frame.add(jcomp7);
        frame.add(jcomp8);
        frame.add(jcomp9);
        frame.add(jcomp10);
        frame.add(jcomp11);
        frame.add(jcomp12);
        frame.add(jcomp13);
        frame.add(jcomp14);

        jcomp1.setBounds(55, 60, 165, 25);
        jcomp2.setBounds(55, 135, 165, 30);
        jcomp3.setBounds(60, 110, 100, 25);
        jcomp4.setBounds(55, 35, 100, 25);
        jcomp5.setBounds(345, 95, 240, 30);
        jcomp6.setBounds(345, 70, 100, 25);
        jcomp7.setBounds(75, 215, 140, 25);
        jcomp8.setBounds(430, 215, 145, 25);
        jcomp9.setBounds(20, 270, 115, 30);
        jcomp10.setBounds(180, 270, 105, 30);
        jcomp11.setBounds(375, 270, 110, 30);
        jcomp12.setBounds(545, 270, 105, 30);
        jcomp13.setBounds(375, 335, 110, 30);
        jcomp14.setBounds(545, 335, 105, 30);
    }

    public void addAdunareListener(ActionListener a) {
        jcomp11.addActionListener(a);
    }

    public void addScadereListener(ActionListener b) {
        jcomp12.addActionListener(b);
    }

    public void addInmultireListener(ActionListener c) {
        jcomp13.addActionListener(c);
    }

    public void addDerivareListener(ActionListener d) {
        jcomp9.addActionListener(d);
    }

    public void addIntegrareListener(ActionListener e) {
        jcomp10.addActionListener(e);
    }

    public void addImpartireListener(ActionListener f) { jcomp14.addActionListener(f);}

    public String getPolinom1 () {
        return jcomp1.getText();
    }

    public String getPolinom2 () {
        return jcomp2.getText();
    }

    public void setResult (String x) {
        jcomp5.setText(x);
    }

    public void errorMessage (String msg) {
        JOptionPane.showMessageDialog(new JFrame(), msg, "Eroare",
                JOptionPane.ERROR_MESSAGE);
    }

    public void infoMessage(String msg) {
        JOptionPane.showMessageDialog(new JFrame(), msg, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
