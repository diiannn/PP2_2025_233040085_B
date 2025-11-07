package id.ac.unpas.praktikumpemograman2.Modul6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author astri
 */
public class Latihan2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel labelC = new JLabel("Celcius:");
        JTextField inputC = new JTextField(10);
        JButton btnKonversi = new JButton("Konversi");
        JLabel labelF = new JLabel("Fahrenheit:");
        JLabel hasil = new JLabel("");

        btnKonversi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double c = Double.parseDouble(inputC.getText());
                    double f = (c * 9 / 5) + 32;
                    hasil.setText(f + " °F");
                } catch (NumberFormatException ex) {
                    hasil.setText("Input tidak valid!");
                }
            }
        });

        frame.add(labelC);
        frame.add(inputC);
        frame.add(btnKonversi);
        frame.add(labelF);
        frame.add(hasil);

        frame.setVisible(true);
    }
}
