/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul6;

import javax.swing.*;
/**
 *
 * @author astri
 */
public class ContohFlowLayout {
    public static void main(String[] args){
        //1. buat frame (window)
        JFrame frame = new JFrame ("Contoh Flow layout");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        //2. Buat panel (container
        //jpanel secara default sudah menggunakan flow
        JPanel panel = new JPanel();
        
        //3.Buat dan tambahkan komponen
        panel.add(new JButton ("tombol 1"));
        panel.add(new JButton ("tombol 2"));
        panel.add(new JButton ("tombol Tiga"));
        panel.add(new JButton ("tombol empat"));
        panel.add(new JButton ("tombol 5"));
        
        //4. Tambahkan panel e frame
        frame.add(panel);
        
        //5. Tampilkan frame
        frame.setVisible(true);
        
    }
}
