/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul8.view;

/**
 *
 * @author astri
 */

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;



public class PersegiPanjangView extends JFrame {
    // Komponen UI sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");
    private JButton btnHitungLuas = new JButton("Hitung Luas");
    private JButton btnHitungKeliling = new JButton("Hitung Keliling");
    //LATIHAN 3 menambahkan tombol Reset
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        // Inisialisasi UI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250); // Ukuran disesuaikan karena tombol bertambah
        this.setTitle("MVC Persegi Panjang");
        this.setLayout(new GridLayout(5, 2, 10, 10)); 


        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil:"));
        this.add(lblHasil);
        this.add(btnHitungLuas);
        this.add(btnHitungKeliling);

        //LATIHAN 3 tombol Reset
        this.add(btnReset);
        this.add(new JLabel(""));//Spacer kosong
    }

    //Mengambil nilai  panjang dari Tetxfield
    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    //Mengambil  nilai lebar dari Textfield
    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    //Menampilkan Hasil ke Label
    public void setLabelHasil(String isi) {
        lblHasil.setText(isi);
    }

    //LATIHAN 3 Method Reset
    public void resetTampilan() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasil.setText("-");
        txtPanjang.requestFocus();
    }

    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void addHitungLuasListener(ActionListener listener) {
        btnHitungLuas.addActionListener(listener);
    }
    //LAITIHAN 2
    public void addHitungKelilingListener(ActionListener listener) {
        btnHitungKeliling.addActionListener(listener);
    }
    //LATIHAN 3
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}