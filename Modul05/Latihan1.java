/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul05;

import javax.swing.*;

/**
 *
 * @author astri
 */

public class Latihan1 {
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable(){
           public void run() {
               JFrame frame = new JFrame ("Jendela");
               frame.setSize(400, 300);
               frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
               frame.setVisible(true);
           }
       });
    }
}