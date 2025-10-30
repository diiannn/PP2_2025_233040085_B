/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul05;

import java.awt.BorderLayout;
import javax.swing.*;
/**
 *
 * @author astri
 */
public class Tugas1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Tugas1 - Modul5");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //Layout manager
                frame.setLayout(new BorderLayout());

                // Komponen GUI
                JLabel label = new JLabel("Silakan tekan tombol");
                
                // Membuat tombol-tombol
                JButton btnNorth = new JButton("NORTH");
                //JButton btnSouth = new JButton("SOUTH");
                JButton btnEast = new JButton("EAST");
                JButton btnWest = new JButton("WEST");
                JButton btnCenter = new JButton("CENTER");

                // Aksi untuk setiap tombol selain SOUTH 
                btnNorth.addActionListener(e -> label.setText("Tombol NORTH ditekan"));
                btnEast.addActionListener(e -> label.setText("Tombol EAST ditekan"));
                btnWest.addActionListener(e -> label.setText("Tombol WEST ditekan"));
                btnCenter.addActionListener(e -> label.setText("Tombol CENTER ditekan"));

                
               // Menambahkan komponen ke layout BorderLayout
                frame.add(btnNorth, BorderLayout.NORTH);
                //frame.add(btnSouth, BorderLayout.SOUTH);
                frame.add(btnEast, BorderLayout.EAST);
                frame.add(btnWest, BorderLayout.WEST);
                frame.add(btnCenter, BorderLayout.CENTER);
                frame.add(label, BorderLayout.SOUTH); 

                // Tampilkan frame
                frame.setVisible(true);
            }
        });
    }
}