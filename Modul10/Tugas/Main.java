/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul10.Tugas;

/**
 *
 * @author astri
 */

import id.ac.unpas.praktikumpemograman2.Modul10.Tugas.view.MahasiswaView;
import id.ac.unpas.praktikumpemograman2.Modul10.Tugas.Controller.MahasiswaController;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaView view = new MahasiswaView();
            new MahasiswaController(view);
            view.setVisible(true); 
        });
    }
}

