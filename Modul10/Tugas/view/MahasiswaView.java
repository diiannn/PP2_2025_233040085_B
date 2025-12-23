package id.ac.unpas.praktikumpemograman2.Modul10.Tugas.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*; // Import semua javax.swing agar lebih ringkas [cite: 126]
import javax.swing.table.DefaultTableModel;

/**
 * @author astri
 */
public class MahasiswaView extends JFrame {
    // Komponen GUI
    public JTextField txtNim, txtNama, txtJurusan, txtCari; 
    public JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari; 
    public JTable tableMahasiswa;
    public DefaultTableModel model;

    public MahasiswaView() {
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
        
        // Latihan 3
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
    }
}