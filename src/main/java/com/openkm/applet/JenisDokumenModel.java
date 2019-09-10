/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.applet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author papamas
 */
public class JenisDokumenModel {
    
    private static final DefaultComboBoxModel model;// = new DefaultComboBoxModel();
    private static DatabaseHandler db;
    private static ResultSet rs; 
    
    static {
        model = new DefaultComboBoxModel();       
        try {
           
            DatabaseHandler  db = new DatabaseHandler();
            db.connect();
           
            ResultSet res;
       
            res = db.getAll();
            while (res.next()) {
                model.addElement(
                        new Item(res.getInt("ID"),
                                res.getString("DESCRIPTION"),
                                res.getString("PATH"),
                                res.getString("FNAME")
                        )
                );
            }    
            db.close();   
            
            /*
            model.addElement(new Item(1,"Kartu Pendaftaran Ulang PNS (KARDAF) Tahun 1974","PUPNS","PUPNS_1974"));
            model.addElement(new Item(2,"Kartu Pegawai","STATUS KEPEGAWAIAN","KARPEG"));
            model.addElement(new Item(3,"Kartu Istri","STATUS KEPEGAWAIAN","KARIS"));
            model.addElement(new Item(4,"Kartu Suami","STATUS KEPEGAWAIAN","KARSU"));
            model.addElement(new Item(5,"Nota Persetujun atau Penetapan NIP","PENETAPAN NIP","PENETAPAN_NIP"));
            model.addElement(new Item(6,"Surat Keputusan Pengangkatan sebagai Calon PNS","CPNS","SK_CPNS"));
            model.addElement(new Item(7,"Surat Perintah Melaksanakan Tugas (SPMT)","SURAT PERINTAH","SPMT"));
            model.addElement(new Item(8,"Surat Tanda Tamat Pendidikan dan Pelatihan","IJAZAH","STTPL"));
            model.addElement(new Item(9,"Berita Acara Pengangkatan Sumpah dan Janji PNS","BERITA ACARA","BA_SUMPAH_PNS"));
            model.addElement(new Item(10,"Surat Keputusan Pengangkatan sebagai PNS","PNS","SK_PNS"));
            model.addElement(new Item(11,"Nota Persetujuan Kenaikan Pangkat","KENAIKAN PANGKAT","NPKP"));
            model.addElement(new Item(12,"Nota Persetujuan Mutasi Lain-Lain","MUTASI","NOTA_PERSETUJUAN_MUTASI"));
            model.addElement(new Item(13,"Surat Keputusan Kenaikan Pangkat PNS","KENAIKAN PANGKAT","SK_KP"));
            model.addElement(new Item(14,"Surat Keputusan Mutasi lain-lain PNS","MUTASI","SK_MUTASI"));
            model.addElement(new Item(15,"Penetapan Angka Kredit","PAK","PAK"));
            model.addElement(new Item(16,"Berita Acara Pelantikan dalam Jabatan","BERITA ACARA","BA_PELANTIKAN_JABATAN"));
            model.addElement(new Item(17,"Surat Keputusan Pengangkatan, Pemindahan, dan Pemberhentian  Jabatan","MUTASI","SK_PPP_JABATAN"));
            model.addElement(new Item(18,"Surat Pernyataan Menduduki Jabatan","SURAT PERNYATAAN","SPMJ"));
            model.addElement(new Item(19,"Surat Keputusan Pindah Wilayah Kerja","MUTASI","SK_PINDAH_WILAYAH"));
            model.addElement(new Item(20,"Nota Persetujuan Perpindahan Antar Instansi","MUTASI","NOTA_PERSETUJUAN_PI"));
            model.addElement(new Item(21,"Surat Keputusan Pindah Antar lnstansi diterbitkan Instansi","MUTASI","SK_PI"));
            model.addElement(new Item(22,"Nota Persetujuan Peninjauan Masa Kerja","PMK","NOTA_PERSETUJUAN_PMK"));
            model.addElement(new Item(23,"SK Peninjauan Masa Kerja diterbitkan Instansi","PMK","SK_PMK"));
            model.addElement(new Item(24,"Nota Persetujuan CLTN","CLTN","NOTA_PERSETUJUAN_CLTN"));
            model.addElement(new Item(25,"Surat Keputusan  CLTN","CLTN","SK_CLTN"));
            model.addElement(new Item(26,"Nota Persetujuan Pengaktifan Kembali Setelah CLTN","CLTN","NOTA_PERSETUJUAN_PENGAKTIFAN_DARI_CLTN"));
            model.addElement(new Item(27,"Surat Keputusan Pengaktifan Kembali Setelah CLTN","CLTN","SK_PENGAKTIFAN_DARI_CLTN"));
            model.addElement(new Item(28,"Nota Persetujuan Perbantuan pada Instansi Lain","PERBANTUAN","NOTA_PERSETUJUAN_PERBANTUAN"));
            model.addElement(new Item(29,"Surat Keputusan Perbantuan kepada Instansi Lain","PERBANTUAN","SK_PERBANTUAN"));
            model.addElement(new Item(30,"Surat Keputusan Penarikan dari Perbantuan","PERBANTUAN","SK_PENARIKAN_PERBANTUAN"));
            model.addElement(new Item(31,"Surat Keputusan Diperkerjakan pada Instansi Lain","DIPEKERJAKAN","SK_DIPEKERJAKAN"));
            model.addElement(new Item(32,"Surat Keputusan Penarikan dari Diperkerjakan","DIPEKERJAKAN","SK_PENARIKAN_DARI_DIPEKERJAKAN"));
            model.addElement(new Item(33,"Surat Keputusan Hukuman Disiplin","HUKUMAN DISIPLIN","SK_HUKUMAN_DISIPLIN"));
            model.addElement(new Item(34,"Surat Keputusan Pengangkatan Kembali sebagai Pejabat Negara","PEJABAT NEGARA","SK_PENGANGKATAN_SEBAGAI_PEJABAT_NEGARA"));
            model.addElement(new Item(35,"Surat Keputusan Pembebasan dari Jabatan Organik","JABATAN ORGANIK","SK_PEMBEBASAN_JABATAN_ORGANIK"));
            model.addElement(new Item(36,"Surat Keputusan Pemberhentian Sementara","PEMBERHENTIAN PNS","SK_PEMBERHENTIAN_SEMENTARA"));
            model.addElement(new Item(37,"Surat Keputusan Pengaktifan Kembali dari Pemberhentian Sementara","PEMBERHENTIAN","SK_PENGAKTIFAN_DARI_PEMBERHENTIAN_SEMENTARA"));
            model.addElement(new Item(38,"Laporan Pegawai yang hilang","LAPORAN","LAPORAN_PEGAWAI_HILANG"));
            model.addElement(new Item(39,"Laporan Kembalinya PNS yang hilang","LAPORAN","LAPORAN_KEMBALI_PNS_HILANG"));
            model.addElement(new Item(40,"Surat Keputusan Pemberian Uang Tunggu","PENSIUN","SK_PEMBERIAN_UANG_TUNGGU"));
            model.addElement(new Item(41,"Surat Keputusan Penggantian Nama","PERUBAHAN DATA DASAR","SK_PENGGANTIAN_NAMA"));
            model.addElement(new Item(42,"Surat Keputusan Perubahan Nama","PERUBAHAN DATA DASAR","SK_PERUBAHAN_NAMA"));
            model.addElement(new Item(43,"Surat Keputusan Penetapan Tanggal Lahir","PERUBAHAN DATA DASAR","SK_PENETAPAN_TGL_LAHIR"));
            model.addElement(new Item(44,"Tanda Lulus Mengikuti Pendidikan Kedinasan","IJAZAH","TANDA_LULUS_PENDIDIKAN_KEDINASAN"));
            model.addElement(new Item(45,"Tanda Lulus Mengikuti Pendidikan dan Pelatihan/Penataran","IJAZAH","TANDA_LULUS_PENDIDIKAN_PELATIHAN"));
            model.addElement(new Item(46,"Surat Keputusan Tugas Belajar Pendidikan Umum","TUGAS BELAJAR","SK_TUGAS_BELAJAR"));
            model.addElement(new Item(47,"Ijazah Pendidikan Umum","IJAZAH","IJAZAH"));
            model.addElement(new Item(48,"Laporan Peningkatan Pendidikan","PENINGKATAN PENDIDIKAN","LAPORAN_PENINGKATAN_PENDIDIKAN"));
            model.addElement(new Item(49,"Laporan Perkawinan Pertama","STATUS KEPEGAWAIAN","LAPORAN_PERKAWINAN_PERTAMA"));
            model.addElement(new Item(50,"Laporan Perkawinan Kedua","STATUS KEPEGAWAIAN","LAPORAN_PERKAWINAN_KEDUA"));
            model.addElement(new Item(51,"Laporan Perkawinan Ketiga","STATUS KEPEGAWAIAN","LAPORAN_PERKAWINAN_KETIGA"));
            model.addElement(new Item(52,"Laporan Perceraian Pertama","STATUS KEPEGAWAIAN","LAPORAN_PERCERAIAN_PERTAMA"));
            model.addElement(new Item(53,"Laporan Perceraian Kedua","STATUS KEPEGAWAIAN","LAPORAN_PERCERAIAN_KEDUA"));
            model.addElement(new Item(54,"Laporan Perceraian Ketiga","STATUS KEPEGAWAIAN","LAPORAN_PERCERAIAN_KETIGA"));
            model.addElement(new Item(55,"Laporan Kelahiran Anak","STATUS KEPEGAWAIAN","LAPORAN_KELAHIRAN_ANAK"));
            model.addElement(new Item(56,"Laporan Kematian Anak","STATUS KEPEGAWAIAN","LAPORAN_KEMATIAN_ANAK"));
            model.addElement(new Item(57,"Surat Keterangan Pengangkatan Anak","STATUS KEPEGAWAIAN","SK_PENGANGKATAN_ANAK"));
            model.addElement(new Item(58,"Surat lzin untuk Melangsungkan Perceraian","STATUS KEPEGAWAIAN","SURAT_IZIN_PERCERAIAN"));
            model.addElement(new Item(59,"Laporan Kematian Suami","STATUS KEPEGAWAIAN","LAPORAN_KEMATIAN_SUAMI"));
            model.addElement(new Item(60,"Laporan Kematian lstri","STATUS KEPEGAWAIAN","LAPORAN_KEMATIAN_ISTRI"));
            model.addElement(new Item(61,"Surat Keputusan Tanda Kehormatan dan Jasa","TANDA KEHORMATAN","SK_TANDA_KEHORMATAN"));
            model.addElement(new Item(62,"Surat Keputusan Penyesuaian Gaji Pokok","GAJI","SK_PENYESUAIAN_GAJI_POKOK"));
            model.addElement(new Item(63,"Surat Keputusan Penyesuaian Jabatan bagi PNS Jabatan Fungsional Tertentu","PENYESUAIAN JABATAN","SK_PENYESUAIAN_JABATAN"));
            model.addElement(new Item(64,"Surat Keputusan Pengangkatan PNS dalam Pangkat Lokal","KENAIKAN PANGKAT","SK_PENGANGKATAN_PNS_DALAM_PANGKAT_LOKAL"));
            model.addElement(new Item(65,"Hasil Pendataan Ulang PNS Juli 2003","PUPNS","PUPNS_2003"));
            model.addElement(new Item(66,"Hasil Pendataan Ulang PNS Juli 2015","PUPNS","PUPNS_2005"));
            model.addElement(new Item(67,"Surat Keputusan Konversi NIP","PERUBAHAN DATA DASAR","SK_KONVERSI_NIP"));
            model.addElement(new Item(68,"Surat Keputusan Meninggal Dunia","STATUS KEPEGAWAIAN","SK_MENINGGAL_DUNIA"));
            model.addElement(new Item(69,"Surat Keputusan Pemberhentian","PEMBERHENTIAN PNS","SK_PEMBERHENTIAN"));
            model.addElement(new Item(70,"Surat Keputusan Kenaikan Pangkat Pengabdian","PENSIUN","SK_KP_PENGABDIAN"));
            model.addElement(new Item(71,"Surat Keputusan Pensiun","PENSIUN","SK_PENSIUN"));
            model.addElement(new Item(72,"Daftar Riwayat Hidup","DATA PERSEORANGAN","DRH"));
            model.addElement(new Item(73,"Daftar Penilaian Prestasi Kerja","SKP","SKP"));
            model.addElement(new Item(74,"Nota Pertimbangan Teknis Pemberian Pensiun","PENSIUN","NOTA_PERTIMBANGAN_PEMBERIAN_PENSIUN"));
            model.addElement(new Item(75,"Pangkalan Data Direktorat Perguruan Tinggi","DIKTI","PANGKALAN_DATA_DIKTI"));
            model.addElement(new Item(76,"Data Perorangan Calon Penerima Pensiun","PENSIUN","DPCP"));
            model.addElement(new Item(77,"Surat Izin Belajar","TUGAS BELAJAR","IZIN_BELAJAR"));
            model.addElement(new Item(78,"Uraian Tugas Jabatan","URAIAN TUGAS","URAIAN_TUGAS"));
            model.addElement(new Item(79,"TASPEN","PENSIUN","TASPEN"));
            model.addElement(new Item(80,"Surat Pemberhentian Gaji","GAJI","SURAT"));
            model.addElement(new Item(81,"Surat Pernyataan CPNS","SURAT PERNYATAAN","SURAT_PERNYATAAN_CPNS"));
            model.addElement(new Item(82,"Surat Pernyataan Rencana Penempatan","SURAT PERNYATAAN","SURAT_PERNYATAAN_RENCANA_PENEMPATAN"));
            model.addElement(new Item(83,"Surat Keterangan Dokter","DATA PERSEORANGAN","SURAT_KETERANGAN_DOKTER"));
            model.addElement(new Item(84,"Surat Keterangan Bebas Narkoba","DATA PERSEORANGAN","SURAT_KETERANGAN_BEBAS_NASRKOBA"));
            model.addElement(new Item(85,"Surat Lamaran Pekerjaan","DATA PERSEORANGAN","SURAT_LAMARAN_PEKERJAAN"));
            model.addElement(new Item(86,"Surat Pernyataan Tidak Pernah Dijatuhi Hukuman Disiplin (HD)","HUKUMAN DISIPLIN","SURAT_PERNYATAAN_TDK_PERNAH_HD"));
            model.addElement(new Item(87,"Surat Pernyataan Tidak Sedang menjalani Proses Pidana","PIDANA","SURAT_PERNYATAAN_TDK_SEDANG_PIDANA"));
            model.addElement(new Item(88,"Surat Permohonan berhenti karena tidak cakap jasmani dan atau rohani /Usul Uzur ","PENSIUN","SURAT_USUL_UZUR"));
            model.addElement(new Item(89,"Usul APS PPK","PENSIUN","USUL_APS_PPK"));
            model.addElement(new Item(90,"Surat Permohonan Berhenti sebagai PNS Atas Permintaan Sendiri yang ditandatangani Yang Bersangkutan","PENSIUN","SURAT_PERMOHONAN_APS"));
            model.addElement(new Item(91,"Surat Permohonan Berhenti sebagai PNS Atas Permintaan Sendiri yang ditandatangani Pejabat Yang Berwenang (PPK)","PENSIUN","SURAT_PERMOHONAN_APS_PPK"));
            model.addElement(new Item(92,"Surat Keterangan Kematian","STATUS KEPEGAWAIAN","AKTE_KEMATIAN"));
            model.addElement(new Item(93,"Surat Keterangan Tim Penguji Kesehatan","DATA PERSEORANGAN","SURAT_KETERANGAN_PENGUJI_KESEHATAN"));
            model.addElement(new Item(94,"Surat Pengesahan Pengadilan","DATA PERSEORANGAN","SURAT_PENGESAHAN_PENGADILAN"));
           */
        } catch (SQLException ex) {
            Logger.getLogger(JenisDokumenModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
    public static DefaultComboBoxModel getData(){
        return model;
    }

   

   

    

   
    
}

