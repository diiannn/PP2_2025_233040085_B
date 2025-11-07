/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul6;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author astri
 */

public class Latihan1 {
    public static void main(String[] args) {
        // Membuat jendela utama
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        // Membuat JTextField sebagai layar kalkulator
        JTextField layar = new JTextField();
        frame.add(layar, BorderLayout.NORTH);

        // Membuat panel untuk tombol
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Membuat tombol angka dan operator
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btnBagi = new JButton("/");

        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btnKali = new JButton("*");

        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btnKurang = new JButton("-");

        JButton btn0 = new JButton("0");
        JButton btnC = new JButton("C");
        JButton btnSamaDengan = new JButton("=");
        JButton btnTambah = new JButton("+");

        // Menambahkan tombol ke panel
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btnBagi);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btnKali);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btnKurang);
        panel.add(btn0);
        panel.add(btnC);
        panel.add(btnSamaDengan);
        panel.add(btnTambah);

        // Menambahkan panel ke frame
        frame.add(panel, BorderLayout.CENTER);

        // Menampilkan jendela
        frame.setVisible(true);
    }
}


