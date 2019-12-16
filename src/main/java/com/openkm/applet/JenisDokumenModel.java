/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.applet;
import java.io.IOException;
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
    
    private static DefaultComboBoxModel model;
    private static DatabaseHandler db;
    private static ResultSet res; 
    
 
    public static DefaultComboBoxModel getData(){        
        try {
            model = new DefaultComboBoxModel();
            db = new DatabaseHandler();
            res =db.getAll();
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
          
        } catch (IOException | SQLException ex) {
            Logger.getLogger(JenisDokumenModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    }
    
    public static DefaultComboBoxModel getDefaultModel(){
        
        model = new DefaultComboBoxModel(); 
        model.addElement(new Item(1,"Kartu Pendaftaran Ulang PNS (KARDAF) Tahun 1974","PUPNS","PUPNS"));
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
            model.addElement(new Item(12,"Nota Persetujuan Mutasi Lain-Lain","MUTASI","NP_MUTASI"));
            model.addElement(new Item(13,"Surat Keputusan Kenaikan Pangkat PNS","KENAIKAN PANGKAT","SK_KP"));
            model.addElement(new Item(14,"Surat Keputusan Mutasi PNS atau Pindah Wilayah Kerja","MUTASI","SK_MUTASI"));
            model.addElement(new Item(15,"Penetapan Angka Kredit","PAK","PAK"));
            model.addElement(new Item(16,"Berita Acara Pelantikan dalam Jabatan","BERITA ACARA","BA_PELANTIKAN"));
            model.addElement(new Item(17,"Surat Keputusan Pengangkatan, Pemindahan, dan Pemberhentian  Jabatan","MUTASI","SK_MUTASI"));
            model.addElement(new Item(18,"Surat Pernyataan Menduduki Jabatan","SURAT PERNYATAAN","SPMJ"));
            model.addElement(new Item(19,"Surat Keputusan Pindah Wilayah Kerja","MUTASI","SK_MUTASI"));
            model.addElement(new Item(20,"Nota Persetujuan Perpindahan Antar Instansi","MUTASI","NP_PI"));
            model.addElement(new Item(21,"Surat Keputusan Pindah Antar lnstansi diterbitkan Instansi","MUTASI","SK_MUTASI"));
            model.addElement(new Item(22,"Nota Persetujuan Peninjauan Masa Kerja","PMK","NP_PMK"));
            model.addElement(new Item(23,"SK Peninjauan Masa Kerja diterbitkan Instansi","PMK","SK_PMK"));
            model.addElement(new Item(24,"Nota Persetujuan CLTN","CLTN","NP_CLTN"));
            model.addElement(new Item(25,"Surat Keputusan  CLTN","CLTN","SK_CLTN"));
            model.addElement(new Item(26,"Nota Persetujuan Pengaktifan Kembali Setelah CLTN","CLTN","NP_PENGAKTIFAN_CLTN"));
            model.addElement(new Item(27,"Surat Keputusan Pengaktifan Kembali Setelah CLTN","CLTN","SK_PENGAKTIFAN_CLTN"));
            model.addElement(new Item(28,"Nota Persetujuan Perbantuan pada Instansi Lain","PERBANTUAN","NP_PERBANTUAN"));
            model.addElement(new Item(29,"Surat Keputusan Perbantuan kepada Instansi Lain","PERBANTUAN","SK_PERBANTUAN"));
            model.addElement(new Item(30,"Surat Keputusan Penarikan dari Perbantuan","PERBANTUAN","SK_PENARIKAN"));
            model.addElement(new Item(31,"Surat Keputusan Diperkerjakan pada Instansi Lain","DIPEKERJAKAN","SK_DIPEKERJAKAN"));
            model.addElement(new Item(32,"Surat Keputusan Penarikan dari Diperkerjakan","DIPEKERJAKAN","SK_PENARIKAN_DIPEKERJAKAN"));
            model.addElement(new Item(33,"Surat Keputusan Penjatuhan Hukuman Disiplin PNS","HUKUMAN DISIPLIN","SK_HD"));
            model.addElement(new Item(34,"Surat Keputusan Pengangkatan Kembali sebagai Pejabat Negara","PEJABAT NEGARA","SK_PENGANGKATAN_PEJABAT_NEGARA"));
            model.addElement(new Item(35,"Surat Keputusan Pembebasan","DATA PERSEORANGAN","SK_PEMBEBASAN"));
            model.addElement(new Item(36,"Surat Keputusan Pemberhentian Sementara","PEMBERHENTIAN PNS","SK_PEMBERHENTIAN_SEMENTARA"));
            model.addElement(new Item(37,"Surat Keputusan Pengaktifan Kembali dari Pemberhentian Sementara","PEMBERHENTIAN","SK_PENGAKTIFAN_PEMBERHENTIAN_SEMENTARA"));
            model.addElement(new Item(38,"Laporan Pegawai yang hilang","LAPORAN","LAPORAN_PEGAWAI_HILANG"));
            model.addElement(new Item(39,"Laporan Kembalinya PNS yang hilang","LAPORAN","LAPORAN_KEMBALI_PNS_HILANG"));
            model.addElement(new Item(40,"Surat Keputusan Pemberian Uang Tunggu","PENSIUN","SK_PEMBERIAN_UANG_TUNGGU"));
            model.addElement(new Item(41,"Surat Keputusan Penggantian Nama","PERUBAHAN DATA DASAR","SK_PENGGANTIAN_NAMA"));
            model.addElement(new Item(42,"Surat Keputusan Perubahan Nama","PERUBAHAN DATA DASAR","SK_PERUBAHAN_NAMA"));
            model.addElement(new Item(43,"Surat Keputusan Penetapan Tanggal Lahir","PERUBAHAN DATA DASAR","SK_PENETAPAN_TGL_LAHIR"));
            model.addElement(new Item(44,"Tanda Lulus Mengikuti Pendidikan Kedinasan","IJAZAH","TLPK"));
            model.addElement(new Item(45,"Tanda Lulus Mengikuti Pendidikan dan Pelatihan/Penataran","IJAZAH","TLPP"));
            model.addElement(new Item(46,"Surat Keputusan Tugas Belajar Pendidikan Umum","TUGAS BELAJAR","TUBEL"));
            model.addElement(new Item(47,"Ijazah Pendidikan Umum","IJAZAH","IJAZAH"));
            model.addElement(new Item(48,"Laporan Peningkatan Pendidikan","PENINGKATAN PENDIDIKAN","LAPORAN_PENINGKATAN_PENDIDIKAN"));
            model.addElement(new Item(49,"Laporan Perkawinan Pertama","STATUS KEPEGAWAIAN","LAPORAN_PERKAWINAN"));
            model.addElement(new Item(50,"Kenaikan Gaji Berkala","GAJI","KGB"));            
            model.addElement(new Item(51,"Daftar Riwayat Jabatan","DATA PERSEORANGAN","DRJ"));
            model.addElement(new Item(52,"Laporan Perceraian","STATUS KEPEGAWAIAN","LAPORAN_PERCERAIAN"));
            model.addElement(new Item(53,"Akta Nikah","STATUS KEPEGAWAIAN","AKTA_NIKAH"));
            model.addElement(new Item(54,"Akta Cerai","STATUS KEPEGAWAIAN","AKTA_CERAI"));
            model.addElement(new Item(55,"Akta Anak atau Laporan Kelahiran Anak","STATUS KEPEGAWAIAN","AKTA_ANAK"));
            model.addElement(new Item(56,"Akta Kematian Anak atau Laporan Kematian Anak","STATUS KEPEGAWAIAN","AKTA_KEMATIAN_ANAK"));
            model.addElement(new Item(57,"Surat Keterangan Pengangkatan Anak","STATUS KEPEGAWAIAN","SK_PENGANGKATAN_ANAK"));
            model.addElement(new Item(58,"Surat lzin untuk Melangsungkan Perceraian","STATUS KEPEGAWAIAN","SURAT_IZIN_PERCERAIAN"));
            model.addElement(new Item(59,"Akta Kematian Suami atau Laporan Kematian Suami","STATUS KEPEGAWAIAN","AKTA_KEMATIAN"));
            model.addElement(new Item(60,"Akta Kematian Istri atau Laporan Kematian lstri","STATUS KEPEGAWAIAN","AKTA_KEMATIAN"));
            model.addElement(new Item(61,"Surat Keputusan Tanda Kehormatan dan Jasa","TANDA KEHORMATAN","SK_TANDA_KEHORMATAN"));
            model.addElement(new Item(62,"Surat Keputusan Penyesuaian Gaji Pokok","GAJI","SK_PENYESUAIAN_GAJI_POKOK"));
            model.addElement(new Item(63,"Surat Keputusan Penyesuaian Jabatan bagi PNS Jabatan Fungsional Tertentu","PENYESUAIAN JABATAN","SK_PENYESUAIAN_JABATAN"));
            model.addElement(new Item(64,"Surat Keputusan Pengangkatan PNS dalam Pangkat Lokal","KENAIKAN PANGKAT","SK_PENGANGKATAN_PNS_DALAM_PANGKAT_LOKAL"));
            model.addElement(new Item(65,"Pendataan atau Hasil Pendataan Ulang PNS","PUPNS","PUPNS"));
            model.addElement(new Item(66,"Daftar Keluarga","DATA PERSEORANGAN","DAFTAR_KELUARGA"));
            model.addElement(new Item(67,"Surat Keputusan Konversi NIP","PERUBAHAN DATA DASAR","KONVERSI_NIP"));
            model.addElement(new Item(68,"Surat Keputusan Meninggal Dunia","STATUS KEPEGAWAIAN","SK_KEMATIAN"));
            model.addElement(new Item(69,"Surat Keputusan Pemberhentian","PEMBERHENTIAN PNS","SK_PEMBERHENTIAN"));
            model.addElement(new Item(70,"Surat Keputusan Kenaikan Pangkat Pengabdian","PENSIUN","SK_KP_PENGABDIAN"));
            model.addElement(new Item(71,"Surat Keputusan Pensiun","PENSIUN","SK_PENSIUN"));
            model.addElement(new Item(72,"Daftar Riwayat Hidup","DATA PERSEORANGAN","DRH"));
            model.addElement(new Item(73,"Penilaian Prestasi Kerja","SKP","SKP"));
            model.addElement(new Item(74,"Nota Pertimbangan Teknis Pemberian Pensiun","PENSIUN","NP_PP"));
            model.addElement(new Item(75,"Pangkalan Data Direktorat Perguruan Tinggi","DIKTI","PANGKALAN_DATA_DIKTI"));
            model.addElement(new Item(76,"Data Perorangan Calon Penerima Pensiun","PENSIUN","DPCP"));
            model.addElement(new Item(77,"Surat Izin Belajar","TUGAS BELAJAR","IBEL"));
            model.addElement(new Item(78,"Uraian Tugas Jabatan","URAIAN TUGAS","URAIAN_TUGAS"));
            model.addElement(new Item(79,"TASPEN","PENSIUN","TASPEN"));
            model.addElement(new Item(80,"Surat Keterangan Pemberhentian Pembayaran atau Surat Pemberhentian Gaji","GAJI","SKPP"));
            model.addElement(new Item(81,"Surat Pernyataan CPNS","SURAT PERNYATAAN","SURAT_PERNYATAAN_CPNS"));
            model.addElement(new Item(82,"Surat Pernyataan Rencana Penempatan","SURAT PERNYATAAN","SURAT_PERNYATAAN_RENCANA_PENEMPATAN"));
            model.addElement(new Item(83,"Surat Keterangan Dokter","DATA PERSEORANGAN","SUKET_DOKTER"));
            model.addElement(new Item(84,"Surat Keterangan Bebas Narkoba","DATA PERSEORANGAN","SUKET_BEBAS_NASRKOBA"));
            model.addElement(new Item(85,"Surat Lamaran Pekerjaan","DATA PERSEORANGAN","SURAT_LAMARAN"));
            model.addElement(new Item(86,"Surat Pernyataan Tidak Pernah Dijatuhi Hukuman Disiplin (HD)","HUKUMAN DISIPLIN","HD"));
            model.addElement(new Item(87,"Surat Pernyataan Tidak Sedang menjalani Proses Pidana","PIDANA","PIDANA"));
            model.addElement(new Item(88,"Surat Permohonan berhenti karena tidak cakap jasmani dan atau rohani /Usul Uzur ","PENSIUN","USUL_UZUR"));
            model.addElement(new Item(89,"Usul APS PPK","PENSIUN","USUL_APS_PPK"));
            model.addElement(new Item(90,"Surat Permohonan Berhenti sebagai PNS Atas Permintaan Sendiri yang ditandatangani Yang Bersangkutan","PENSIUN","APS_YBS"));
            model.addElement(new Item(91,"Surat Permohonan Berhenti sebagai PNS Atas Permintaan Sendiri yang ditandatangani Pejabat Yang Berwenang (PPK)","PENSIUN","APS_PPK"));
            model.addElement(new Item(92,"Surat Keterangan Kematian","STATUS KEPEGAWAIAN","AKTA_KEMATIAN"));
            model.addElement(new Item(93,"Surat Keterangan Tim Penguji Kesehatan","DATA PERSEORANGAN","SUKET_PENGUJI_KESEHATAN"));
            model.addElement(new Item(94,"Surat Pengesahan Pengadilan","DATA PERSEORANGAN","SURAT_PENGESAHAN_PENGADILAN"));
            model.addElement(new Item(95,"Kartu Keluarga","DATA PERSEORANGAN","KK"));
            model.addElement(new Item(96,"MOU","DATA PERSEORANGAN","MOU"));
            model.addElement(new Item(97,"Nota Usul Kenaikan Pangkat","KENAIKAN PANGKAT","NUKP"));
            model.addElement(new Item(98,"Sertifikat Pendidik","IJAZAH","SERDIK"));
            model.addElement(new Item(99,"SK Jabatan Fungsional / Struktural  Pelantikan dan SPMT","DATA PERSEORANGAN","SK_JABATAN"));
            model.addElement(new Item(100,"Diklat PIM","IJAZAH","SK_PIM"));
            model.addElement(new Item(101,"Surat Tanda Lulus Kenaikan Pangkat Penyesuaian Ijazah","IJAZAH","STLKPPI"));
            model.addElement(new Item(102,"Surat Tanda Lulus Ujian Dinas","IJAZAH","STLUD"));
            model.addElement(new Item(103,"Surat Keterangan","DATA PERSEORANGAN","SUKET"));
            model.addElement(new Item(104,"Usul KARIS","DATA PERSEORANGAN","USUL_KARIS"));
            model.addElement(new Item(105,"Usul KARPEG","DATA PERSEORANGAN","USUL_KARPEG"));
            model.addElement(new Item(106,"Usul KARSU","DATA PERSEORANGAN","USUL_KARSU"));
            model.addElement(new Item(107,"Usul Pencantuman Gelar atau Peningkatan Pendidikan","DATA PERSEORANGAN","USUL_PG"));
           
        return model;
    }

   

   

    

   
    
}

