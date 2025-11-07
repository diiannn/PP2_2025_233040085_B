/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul6;

import java.awt.BorderLayout;
import javax.swing.*;
/**
 *
 * @author astri
 */
public class ContohBorderLayout {
     public static void main(String[] args){
        //1. buat frame (window)
        JFrame frame = new JFrame ("Contoh Borderlayout");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        //frame sudah menggunakan borderlayout
        
        
        //2. Buat dan tambahkan komponen ke 5 wilayah
        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);   
        
        //3. Tampilkan frame
        frame.setVisible(true);
        
    }
}
