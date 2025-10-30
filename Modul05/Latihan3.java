/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul05;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author astri
 */
public class Latihan3 {
        public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable(){
           public void run() {
               JFrame frame = new JFrame ("Jendela");
               frame.setSize(400, 300);
               frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
               
               //layout manager
               frame.setLayout(new FlowLayout());
               
               //komponen GUI
               JLabel label = new JLabel("Teks awal");
               JButton button = new JButton ("Klik saya!");
               
               //aksi
                button.addActionListener(e -> {
                // Aksi ini akan mengubah teks pada label
                label.setText("Tombol berhasil diklik!");
            });

               frame.add(label);
               frame.add(button);
               
               frame.setVisible(true);
           }
       });
    }
    
}
