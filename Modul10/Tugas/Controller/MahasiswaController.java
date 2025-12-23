/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul10.Tugas.Controller;

import id.ac.unpas.praktikumpemograman2.Modul10.Tugas.model.KoneksiDB;
import id.ac.unpas.praktikumpemograman2.Modul10.Tugas.view.MahasiswaView;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

/**
 *
 * @author astri
 */
public class MahasiswaController {
    private MahasiswaView view;

    public MahasiswaController(MahasiswaView view) {
        this.view = view;
        
        view.tableMahasiswa = new JTable(view.model);
        JScrollPane scrollPane = new JScrollPane(view.tableMahasiswa);
        view.add(scrollPane, BorderLayout.CENTER);

        // Listener Klik Tabel (untuk mengambil data saat baris diklik)
        view.tableMahasiswa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = view.tableMahasiswa.getSelectedRow();
                view.txtNim.setText(view.model.getValueAt(row, 0).toString());
                view.txtNama.setText(view.model.getValueAt(row, 1).toString());
                view.txtJurusan.setText(view.model.getValueAt(row, 2).toString());
            }
        });

        // Aksi Tombol Simpan
        view.btnSimpan.addActionListener(e -> tambahData());

        // Aksi Tombol Edit
        view.btnEdit.addActionListener(e -> ubahData());

        // Aksi Tombol Hapus
        view.btnHapus.addActionListener(e -> hapusData());

        // Aksi Tombol Clear
        view.btnClear.addActionListener(e -> kosongkanForm());
        
        // Latihan 3: Aksi Tombol Cari
        view.btnCari.addActionListener(e -> cariData());

        tampilData();
    }

    // Method untuk menampilkan data dari database ke tabel
    void tampilData() {
        try {
            view.model.setRowCount(0);
            Connection conn = KoneksiDB.configDB();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mahasiswa");

            while (rs.next()) {
                view.model.addRow(new Object[]{
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.view, "Gagal Load Data : " + e.getMessage());
        }
    }

    // Method tambah data
    void tambahData() {
        //Latihan 2: Validasi Input Kosong
        if (view.txtNama.getText().isEmpty() || view.txtNim.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this.view, "Data tidak boleh kosong!");
        return; // Berhenti di sini, tidak lanjut ke proses simpan
    }
        
        try {
            Connection conn = KoneksiDB.configDB();
            
             // Cek NIM sudah ada apa blum
            String cekSql = "SELECT nim FROM mahasiswa WHERE nim = ?";
            PreparedStatement cekPst = conn.prepareStatement(cekSql);
            cekPst.setString(1, view.txtNim.getText());
            ResultSet rs = cekPst.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this.view, "NIM sudah terdaftar!");
            return;
        }
            
            String sql = "INSERT INTO mahasiswa (nim, nama, jurusan) VALUES (?, ?, ?)"; 
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, view.txtNim.getText());
            pst.setString(2, view.txtNama.getText());
            pst.setString(3, view.txtJurusan.getText());
            pst.execute();

            JOptionPane.showMessageDialog(this.view, "Data Berhasil Disimpan");
            tampilData();
            kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.view, "Gagal Simpan : " + e.getMessage());
        }
    }

    // Method ubah data
    void ubahData() {
        try {
            String sql = "UPDATE mahasiswa SET nama=?, jurusan=? WHERE nim=?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, view.txtNama.getText());
            pst.setString(2, view.txtJurusan.getText());
            pst.setString(3, view.txtNim.getText());
            pst.execute();

            JOptionPane.showMessageDialog(this.view, "Data Berhasil Diubah");
            tampilData();
            kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.view, "Gagal Update : " + e.getMessage());
        }
    }

    // Method hapus data
    void hapusData() {
        try {
            String sql = "DELETE FROM mahasiswa WHERE nim=?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, view.txtNim.getText());
            pst.execute();

            JOptionPane.showMessageDialog(this.view, "Data Berhasil Dihapus");
            tampilData();
            kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.view, "Gagal Hapus : " + e.getMessage());
        }
    }
    
    private void cariData() {
    view.model.setRowCount(0); // Reset tabel
    try {
        String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + view.txtCari.getText() + "%");
        ResultSet res = pst.executeQuery();

        int no = 1;
        while (res.next()) {
            view.model.addRow(new Object[]{
                no++, res.getString("nama"), res.getString("nim"), res.getString("jurusan")
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this.view, "Pencarian Gagal: " + e.getMessage());
    }
}

    // Method clear form
    void kosongkanForm() {
        view.txtNim.setText("");
        view.txtNama.setText("");
        view.txtJurusan.setText("");
    }
    
}
