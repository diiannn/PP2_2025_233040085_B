/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul10;

/**
 *
 * @author astri
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MahasiswaApp extends JFrame {
    // Komponen GUI
    JTextField txtNim, txtNama, txtJurusan, txtCari; //latihan 3 menambahkan txtCari
    JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari; //Latihan 3 menambahkan button Cari
    JTable tableMahasiswa;
    DefaultTableModel model;

    public MahasiswaApp() {
        // Setup Frame
        setTitle("Aplikasi CRUD Mahasiswa JDBC");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Form
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("NIM:"));
        txtNim = new JTextField();
        panelForm.add(txtNim);

        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);

        // Panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");
        
        //Latihan 3
        txtCari = new JTextField(15); // Membuat kolom teks pencarian
        btnCari = new JButton("Cari"); // Membuat tombol Cari

        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);
        //Latihan 3
        panelTombol.add(txtCari); 
        panelTombol.add(btnCari); 
        
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);

        // Tabel Mahasiswa
        model = new DefaultTableModel();
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Jurusan");

        tableMahasiswa = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);
        add(scrollPane, BorderLayout.CENTER);

        // Listener Klik Tabel (untuk mengambil data saat baris diklik)
        tableMahasiswa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tableMahasiswa.getSelectedRow();
                txtNim.setText(model.getValueAt(row, 0).toString());
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtJurusan.setText(model.getValueAt(row, 2).toString());
            }
        });

        // Aksi Tombol Simpan
        btnSimpan.addActionListener(e -> tambahData());

        // Aksi Tombol Edit
        btnEdit.addActionListener(e -> ubahData());

        // Aksi Tombol Hapus
        btnHapus.addActionListener(e -> hapusData());

        // Aksi Tombol Clear
        btnClear.addActionListener(e -> kosongkanForm());
        
        // Latihan 3: Aksi Tombol Cari
        btnCari.addActionListener(e -> cariData());

        tampilData();
    }

    // Method untuk menampilkan data dari database ke tabel
    void tampilData() {
        try {
            model.setRowCount(0);
            Connection conn = KoneksiDB.configDB();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mahasiswa");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Load Data : " + e.getMessage());
        }
    }

    // Method tambah data
    void tambahData() {
        //Latihan 2: Validasi Input Kosong
        if (txtNama.getText().isEmpty() || txtNim.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!");
        return; // Berhenti di sini, tidak lanjut ke proses simpan
    }
        
        try {
            Connection conn = KoneksiDB.configDB();
            
             // Cek apakah NIM sudah ada
            String cekSql = "SELECT nim FROM mahasiswa WHERE nim = ?";
            PreparedStatement cekPst = conn.prepareStatement(cekSql);
            cekPst.setString(1, txtNim.getText());
            ResultSet rs = cekPst.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "NIM sudah terdaftar!");
            return;
        }
            
            String sql = "INSERT INTO mahasiswa (nim, nama, jurusan) VALUES (?, ?, ?)"; 
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtNim.getText());
            pst.setString(2, txtNama.getText());
            pst.setString(3, txtJurusan.getText());
            pst.execute();

            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
            tampilData();
            kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Simpan : " + e.getMessage());
        }
    }

    // Method ubah data
    void ubahData() {
        try {
            String sql = "UPDATE mahasiswa SET nama=?, jurusan=? WHERE nim=?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtNama.getText());
            pst.setString(2, txtJurusan.getText());
            pst.setString(3, txtNim.getText());
            pst.execute();

            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            tampilData();
            kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Update : " + e.getMessage());
        }
    }

    // Method hapus data
    void hapusData() {
        try {
            String sql = "DELETE FROM mahasiswa WHERE nim=?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtNim.getText());
            pst.execute();

            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            tampilData();
            kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Hapus : " + e.getMessage());
        }
    }
    
    private void cariData() {
    model.setRowCount(0); // Reset tabel
    try {
        String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + txtCari.getText() + "%");
        ResultSet res = pst.executeQuery();

        int no = 1;
        while (res.next()) {
            model.addRow(new Object[]{
                no++, res.getString("nama"), res.getString("nim"), res.getString("jurusan")
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Pencarian Gagal: " + e.getMessage());
    }
}

    // Method clear form
    void kosongkanForm() {
        txtNim.setText("");
        txtNama.setText("");
        txtJurusan.setText("");
    }
    
    public static void main(String[]args) {
        //Menjalankan aplikasi
        SwingUtilities.invokeLater(() -> new MahasiswaApp().setVisible(true));
    }
    
}







