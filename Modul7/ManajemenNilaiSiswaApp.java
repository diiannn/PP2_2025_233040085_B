/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul7;

/**
 *
 * @author astri
 * 
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManajemenNilaiSiswaApp extends JFrame{
    
    // Deklarasi komponen global [cite: 47-53]
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    // Konstruktor Utama 
   public ManajemenNilaiSiswaApp () {
        //1.Konfigurasi Frame utama
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Posisi tengah layar

        // 2. Inisialisasi Tabbed Pane 
        tabbedPane = new JTabbedPane();

        // 3. membuat panel untuk tab 1 (Form INput)
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        // 4. Membuat panel untuk tab 2 (Tabel Data) 
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        //Menambahkan Tabbedpane ke Frame
        add(tabbedPane);
    }

    //Method untuk membuat desain tab Input
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //KOmponen Nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        //Komponen Mata pelajaran(ComboBox)
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {"Matematika Dasar", "Bahasa Indonesia", "Algoritma dan Pemrograman I", "Praktikum Pemrograman II"};
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        //Komponen Nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        //Tombol  simpan
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(new JLabel("")); 
        panel.add(btnSimpan);

        //Event handling tombol simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        return panel;
    }

    //Method untuk membuat desain tab tabel
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Setup kolom tabel
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        //bungkustabel dgn srollpanel (agar bisa discroll jika data banyak)
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Logika Validasi dan Penyimpanan data
    private void prosesSimpan() {
        //1. Ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        //2.validasi input
        
        // Validasi 1: cek Nama Kosong 
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi 2: cek apakah nilai  berupa angka dan dalam range
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0-100!", "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!", "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //3. Logika Bisnis (Menentukan grade)
        String grade;
        if (nilai >= 80) grade = "A";
        else if (nilai >= 70) grade = "AB";
        else if (nilai >= 60) grade = "B";
        else if (nilai >= 50) grade = "BC";
        else if (nilai >= 40) grade = "C";
        else if (nilai >= 30) grade = "D";
        else grade = "E";

        // 4. Masukkan ke Tabel (update Model)
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        // 5. Reset Form dan pindah tab
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
        
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1); //otomatis pindah ke tab tabel
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}

