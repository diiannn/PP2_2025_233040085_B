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

public class ManajemenNilaiSiswaApp_Tugas extends JFrame{
    
    // Deklarasi komponen global [cite: 47-53]
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    // Konstruktor Utama 
    public ManajemenNilaiSiswaApp_Tugas () {
        //1.Konfigurasi Frame utama
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(500, 450);
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
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
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

        //TUGAS 4  menambahkan tombol reset
        JButton btnSimpan = new JButton("Simpan Data");
        JButton btnReset = new JButton("Reset Form"); 

        panel.add(btnReset); 
        panel.add(btnSimpan); 

        // Event Handling Tombol Simpan
        btnSimpan.addActionListener(e -> prosesSimpan());

        // Event Handling Tombol Reset
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
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
        
        // TUGAS NO 2 membuat Tombol Hapus 
        JButton btnHapus = new JButton("Hapus Data Terpilih");
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(btnHapus);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Event Handling Tombol Hapus 
        btnHapus.addActionListener(e -> {
            int selectedRow = tableData.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(this, 
                        "Pilih baris yang ingin dihapus terlebih dahulu.", 
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

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
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", 
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // TUGAS 3 Validasi nama minimal 3 
        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama harus minimal 3 karakter!", 
                    "Error Validasi", JOptionPane.WARNING_MESSAGE);
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

        //TUGAS 1 ubah logika  grade jadi Switch case
        //3. Logika Bisnis (Menentukan grade)
        String grade;
        int kategori = nilai / 10; 
        switch (kategori) {
            case 10: 
            case 9:  
            case 8: grade = "A"; break;
            case 7: grade = "AB"; break;
            case 6: grade = "B"; break;
            case 5: grade = "BC"; break;
            case 4: grade = "C"; break;
            case 3: grade = "D"; break;
            default: grade = "E"; break;
        }


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
            new ManajemenNilaiSiswaApp_Tugas().setVisible(true);
        });
    }
}

