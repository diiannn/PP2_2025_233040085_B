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
public class Latihan4 {
     public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable(){
           public void run() {
               JFrame frame = new JFrame ("Contoh BorderLayout");
               frame.setSize(400, 300);
               frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
               
               //layout manager
               frame.setLayout(new BorderLayout());
               
               //komponen GUI
               JLabel label = new JLabel("Label ini ada diatas ((NORTH)");
               JButton button = new JButton ("Label ini ada dibawah (SOUTH)");
               
               //aksi
                button.addActionListener(e -> {
                // Aksi ini akan mengubah teks pada label
                label.setText("Tombol SOUTH diklik!");
            });
               
                //Komponen ke frame dengan POSISI
               frame.add(label, BorderLayout.NORTH);
               frame.add(button, BorderLayout.SOUTH);
               frame.add(new JButton("WEST"), BorderLayout.WEST);
               frame.add(new JButton("EAST"), BorderLayout.EAST);
               frame.add(new JButton("CENTER"), BorderLayout.CENTER);
               
               frame.setVisible(true);
           }
       });
    }
}
