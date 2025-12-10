package id.ac.unpas.praktikumpemograman2.Modul8.controller;

import id.ac.unpas.praktikumpemograman2.Modul8.model.PersegiPanjangModel;
import id.ac.unpas.praktikumpemograman2.Modul8.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        //Model dan view sebagai atribut kelas
        this.model = model;
        this.view = view;

        this.view.addHitungLuasListener(new HitungLuasListener());
        //LATIHAN 2 
        this.view.addHitungKelilingListener(new HitungKelilingListener()); 
        //LATIHAN 3
        this.view.addResetListener(new ResetListener());
    }

    // Listener Khusus Luas
    class HitungLuasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);
                model.hitungLuas(); // Hitung Luas saja

                view.setLabelHasil("Luas: " + model.getLuas());
            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    // LATIHAN 2 Listener Keliling
    class HitungKelilingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);
                model.hitungKeliling(); // Hitung Keliling saja

                view.setLabelHasil("Keliling: " + model.getKeliling());
            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    //LATIHAN 3 Reset Listener
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.resetTampilan();
        }
    }
}