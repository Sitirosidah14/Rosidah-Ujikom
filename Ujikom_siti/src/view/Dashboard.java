/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import java.io.File;
import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import config.KoneksiDB;
import config.UserSession;
/**
 *
 * @author siti
 */
public class Dashboard extends javax.swing.JFrame {
    Connection con = KoneksiDB.getConnection();
    ResultSet rs;
    DefaultTableModel model;
    
    //get user data session
    String id = UserSession.get_id();
    String username = UserSession.get_username();
    String nama = UserSession.get_nama();
    String level = UserSession.get_level();
    String nisn = UserSession.get_nisn();
    String nama_siswa = UserSession.get_nama_siswa();
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        
        
    }
    
//  admin previleges
    public void dashAdmin() { 
        tabelSpp();    
        tabelTrans();
        jumlahDataMaster();
        t_Level.setText("ADMINISTRATOR");
        tNama_user.setText(nama); 
    }
    
//  petugas previleges
    public void dashPetugas() {    
        tabelSpp();    
        tabelTrans();
        jumlahDataMaster();
        t_Level.setText("PETUGAS");
        tNama_user.setText(nama);   
        
        //block akses
        mnDataMaster.setVisible(false);
        mnLaporan.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        t_Level = new javax.swing.JLabel();
        tNama_user = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jml_siswa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jml_petugas = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jml_kelas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Jtabelpane1 = new javax.swing.JScrollPane();
        JtabelSpp = new javax.swing.JTable() { public boolean isCellEditable(int rowIndex, int colIndex) { return false; } };
        jLabel2 = new javax.swing.JLabel();
        cariTransaksi = new javax.swing.JTextField();
        btnTransaksi = new javax.swing.JButton();
        Jtabelpane2 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnAkun = new javax.swing.JMenu();
        smInfo_akun = new javax.swing.JMenuItem();
        smLogout = new javax.swing.JMenuItem();
        mnDataMaster = new javax.swing.JMenu();
        smData_siswa = new javax.swing.JMenuItem();
        smData_petugas = new javax.swing.JMenuItem();
        smData_kelas = new javax.swing.JMenuItem();
        smData_spp = new javax.swing.JMenuItem();
        mnPembayaran = new javax.swing.JMenu();
        smTambah_trans = new javax.swing.JMenuItem();
        mnLaporan = new javax.swing.JMenu();
        smGenerate_laporan = new javax.swing.JMenuItem();
        mnAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1370, 680));
        setPreferredSize(new java.awt.Dimension(1370, 680));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_Level.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        t_Level.setText("Level");

        tNama_user.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tNama_user.setText("Nama User");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tNama_user)
                    .addComponent(t_Level))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(t_Level)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNama_user)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 290, 90));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel4.setText("APLIKASI PEMBAYARAN SPP");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("SMK AL - IHSAN BATUJAJAR");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("SISWA");

        jml_siswa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jml_siswa.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jml_siswa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jml_siswa))
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 290, 60));

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("PETUGAS");

        jml_petugas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jml_petugas.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jml_petugas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jml_petugas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 290, -1));

        jPanel4.setBackground(new java.awt.Color(0, 102, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("KELAS");

        jml_kelas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jml_kelas.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jml_kelas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jml_kelas)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 290, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("DATA ANGKATAN");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        JtabelSpp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        JtabelSpp.setCellSelectionEnabled(true);
        Jtabelpane1.setViewportView(JtabelSpp);

        getContentPane().add(Jtabelpane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 290, 180));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Cari Transaksi ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        cariTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariTransaksiKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariTransaksiKeyTyped(evt);
            }
        });
        getContentPane().add(cariTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 420, 30));

        btnTransaksi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTransaksi.setText("+ Transaksi Baru");
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 190, 50));

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelTransaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Jtabelpane2.setViewportView(tabelTransaksi);

        getContentPane().add(Jtabelpane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 600, 420));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mnAkun.setText("Akun");

        smInfo_akun.setText("Info Akun");
        smInfo_akun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smInfo_akunActionPerformed(evt);
            }
        });
        mnAkun.add(smInfo_akun);

        smLogout.setText("Logout");
        smLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smLogoutActionPerformed(evt);
            }
        });
        mnAkun.add(smLogout);

        jMenuBar1.add(mnAkun);

        mnDataMaster.setText("Data Master");

        smData_siswa.setText("Data Siswa");
        smData_siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smData_siswaActionPerformed(evt);
            }
        });
        mnDataMaster.add(smData_siswa);

        smData_petugas.setText("Data Petugas");
        smData_petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smData_petugasActionPerformed(evt);
            }
        });
        mnDataMaster.add(smData_petugas);

        smData_kelas.setText("Data Kelas");
        smData_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smData_kelasActionPerformed(evt);
            }
        });
        mnDataMaster.add(smData_kelas);

        smData_spp.setText("Data SPP");
        smData_spp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smData_sppActionPerformed(evt);
            }
        });
        mnDataMaster.add(smData_spp);

        jMenuBar1.add(mnDataMaster);

        mnPembayaran.setText("Pembayaran");

        smTambah_trans.setText("Tambah Transaksi");
        smTambah_trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smTambah_transActionPerformed(evt);
            }
        });
        mnPembayaran.add(smTambah_trans);

        jMenuBar1.add(mnPembayaran);

        mnLaporan.setText("Laporan");

        smGenerate_laporan.setText("Generate Laporan");
        smGenerate_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smGenerate_laporanActionPerformed(evt);
            }
        });
        mnLaporan.add(smGenerate_laporan);

        jMenuBar1.add(mnLaporan);

        mnAbout.setText("About");
        mnAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnAboutMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnAbout);

        setJMenuBar(jMenuBar1);

        getAccessibleContext().setAccessibleName("Dashboard");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smData_sppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smData_sppActionPerformed
    CRUD_Spp view = new CRUD_Spp();
    view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    view.setVisible(true);
    dispose();
    }//GEN-LAST:event_smData_sppActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void smLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smLogoutActionPerformed
    new Login().setVisible(true);
    dispose();
    }//GEN-LAST:event_smLogoutActionPerformed

    private void smData_siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smData_siswaActionPerformed
    CRUD_Siswa view = new CRUD_Siswa();
    view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    view.setVisible(true);
    dispose();
    }//GEN-LAST:event_smData_siswaActionPerformed

    private void smData_petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smData_petugasActionPerformed
    CRUD_Petugas view = new CRUD_Petugas();
    view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    view.setVisible(true);
    dispose();
    }//GEN-LAST:event_smData_petugasActionPerformed

    private void smData_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smData_kelasActionPerformed
    CRUD_Kelas view = new CRUD_Kelas();
    view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    view.setVisible(true);
    dispose();
    }//GEN-LAST:event_smData_kelasActionPerformed

    private void cariTransaksiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTransaksiKeyReleased
    tabelTrans();
    }//GEN-LAST:event_cariTransaksiKeyReleased

    private void cariTransaksiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTransaksiKeyTyped
    tabelTrans();
    }//GEN-LAST:event_cariTransaksiKeyTyped

    private void smTambah_transActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smTambah_transActionPerformed
    new FormTransaksi().setVisible(true);
    dispose();
    }//GEN-LAST:event_smTambah_transActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
    new FormTransaksi().setVisible(true);
    dispose();
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void smInfo_akunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smInfo_akunActionPerformed
        // TODO add your handling code here:
        new InfoAkun().setVisible(true);
    }//GEN-LAST:event_smInfo_akunActionPerformed

    private void smGenerate_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smGenerate_laporanActionPerformed
        // TODO add your handling code here:
        new Report().setVisible(true);
        
    }//GEN-LAST:event_smGenerate_laporanActionPerformed

    private void mnAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnAboutMouseClicked
        new about().setVisible(true);
    }//GEN-LAST:event_mnAboutMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
public void tabelTrans() {
        String[] judul = {"Tanggal","No. Transaksi","NISN","Nama Siswa","Bulan Dibayar","Tahun","Jumlah Bayar","Petugas"};
        model = new DefaultTableModel(judul,0);
        tabelTransaksi.setModel(model);
        String sql = "SELECT *,petugas.*, siswa.* from pembayaran INNER JOIN petugas USING(id_petugas) INNER JOIN siswa USING(nisn) where id_pembayaran like '%"+cariTransaksi.getText()+"%' or nisn like '%"+cariTransaksi.getText()+"%' or tgl_bayar like '%"+cariTransaksi.getText()+"%'or nama like '%"+cariTransaksi.getText()+"%'or bulan_dibayar like '%"+cariTransaksi.getText()+"%'or tahun_dibayar like '%"+cariTransaksi.getText()+"%'or jumlah_bayar like '%"+cariTransaksi.getText()+"%'or nama_petugas like '%"+cariTransaksi.getText()+"%'";
       
        try {
            rs = con.createStatement().executeQuery(sql);
           
            while(rs.next()) {
               String tanggal = rs.getString("tgl_bayar");
               String no_transaksi = rs.getString("id_pembayaran");
               String nisn = rs.getString("nisn");              
               String nama = rs.getString("nama");              
               String bulan = rs.getString("bulan_dibayar");               
               String tahun = rs.getString("tahun_dibayar");
               String jumlah = rs.getString("jumlah_bayar");
               String petugas = rs.getString("nama_petugas");
               
               String[] data = {tanggal,no_transaksi,nisn,nama,bulan,tahun, jumlah,petugas};
               model.addRow(data);
           }
        }catch(Exception e) {
           System.out.println(e);
        }
    
    }
    
    private void tabelSpp() {
        String[] judul = {"Tahun","Nominal"};
        model = new DefaultTableModel(judul,0);
        JtabelSpp.setModel(model);
        String sql = "SELECT tahun, nominal from spp";
       
        try {
            rs = con.createStatement().executeQuery(sql);
            
            while(rs.next()) {
               String tahun = rs.getString("tahun");
               String nominal = rs.getString("nominal");
                
               String[] data = {tahun,nominal};
               model.addRow(data);
           }
        }catch(Exception e) {
           System.out.println(e);
        }
    }
    
    private void jumlahDataMaster() {                
       try {
           ResultSet rowPetugas = con.createStatement().executeQuery("select * from petugas");
           ResultSet rowKelas = con.createStatement().executeQuery("select * from kelas");
           ResultSet rowSiswa = con.createStatement().executeQuery("select * from siswa");
           rowPetugas.next();
           rowSiswa.next();
           rowKelas.next();
           
           if (rowPetugas.last()) {
              int total=rowPetugas.getRow();
              rowPetugas.beforeFirst();
              jml_petugas.setText(Integer.toString(total));
           }
           
           if(rowSiswa.last()){
              int total=rowSiswa.getRow();
              rowSiswa.beforeFirst();
              jml_siswa.setText(Integer.toString(total));
           }
           
           if(rowKelas.last()){
              int total=rowKelas.getRow();
              rowKelas.beforeFirst();
              jml_kelas.setText(Integer.toString(total));
           }
       } catch (Exception e) {
           System.out.println(e);
       }
    }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtabelSpp;
    private javax.swing.JScrollPane Jtabelpane1;
    private javax.swing.JScrollPane Jtabelpane2;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JTextField cariTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jml_kelas;
    private javax.swing.JLabel jml_petugas;
    private javax.swing.JLabel jml_siswa;
    private javax.swing.JMenu mnAbout;
    private javax.swing.JMenu mnAkun;
    private javax.swing.JMenu mnDataMaster;
    private javax.swing.JMenu mnLaporan;
    private javax.swing.JMenu mnPembayaran;
    private javax.swing.JMenuItem smData_kelas;
    private javax.swing.JMenuItem smData_petugas;
    private javax.swing.JMenuItem smData_siswa;
    private javax.swing.JMenuItem smData_spp;
    private javax.swing.JMenuItem smGenerate_laporan;
    private javax.swing.JMenuItem smInfo_akun;
    private javax.swing.JMenuItem smLogout;
    private javax.swing.JMenuItem smTambah_trans;
    private javax.swing.JLabel tNama_user;
    private javax.swing.JLabel t_Level;
    private javax.swing.JTable tabelTransaksi;
    // End of variables declaration//GEN-END:variables
}
