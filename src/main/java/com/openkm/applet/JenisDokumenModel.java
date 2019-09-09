/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.applet;


import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author papamas
 */
public class JenisDokumenModel {
    
    private static final DefaultComboBoxModel model;// = new DefaultComboBoxModel();
    static {
        model = new DefaultComboBoxModel();
        model.addElement(new Item(1,"Kartu Pendaftaran Ulang PNS (KARDAF) Tahun 1974","PUPNS","PUPNS_1974"));
        model.addElement(new Item(2,"Data Kepegawaian Perorangan (DKP)","DATA PERORANGAN","DKP"));
        model.addElement(new Item(3,"Nota Persetujuan/Penetapan NIP","PERSETUJUAN","D2_NPNIP"));
        model.addElement(new Item(4,"Surat Keputusan Pengangkatan sebagai Calon PNS","SURAT KEPUTUSAN","SK_CPNS"));
        model.addElement(new Item(5,"Surat Perintah Melaksanakan Tugas (SPMT)","SURAT PERINTAH","SPMT"));
        model.addElement(new Item(6,"Surat Tanda Tamat Pendidikan dan Pelatihan","IJAZAH","STTPL"));
        model.addElement(new Item(7,"Berita Acara Pengangkatan Sumpah dan Janji PNS","BERITA ACARA","BA_SUMPAH_PNS"));
        model.addElement(new Item(8,"Surat Keputusan Pengangkatan sebagai PNS","SURAT KEPUTUSAN","SK_PNS"));
        model.addElement(new Item(9,"Nota Persetujuan Kenaikan Pangkat","PERSETUJUAN","NPKP"));
        model.addElement(new Item(10,"Nota Persetujuan Mutasi Lain-Lain","MUTASI","NOTA_PERSETUJUAN_MUTASI"));
        model.addElement(new Item(11,"Surat Keputusan Kenaikan Pangkat PNS","SKKP","SK_KP"));
        model.addElement(new Item(12,"Surat Keputusan Mutasi lain-lain PNS","MUTASI","SK_MUTASI"));
        model.addElement(new Item(13,"Penetapan Angka Kredit","PAK","PAK"));
        model.addElement(new Item(14,"Berita Acara Pelantikan dalam Jabatan","BERITA ACARA","BA_PELANTIKAN_JABATAN"));
        model.addElement(new Item(15,"Surat Keputusan Pengangkatan, Pemindahan, dan Pemberhentian  Jabatan","MUTASI","SK_PPP_JABATAN"));
        model.addElement(new Item(16,"Surat Pernyataan Menduduki Jabatan","SPMJ","SPMJ"));
        model.addElement(new Item(17,"Surat Keputusan Pindah Wilayah Kerja","MUTASI","SK_PINDAH_WILAYAH"));
        model.addElement(new Item(18,"Nota Persetujuan Perpindahan Antar Instansi","MUTASI","NOTA_PERSETUJUAN_PI"));
        model.addElement(new Item(19,"Surat Keputusan Pindah Antar lnstansi diterbitkan Instansi","MUTASI","SK_PI"));
        model.addElement(new Item(20,"Nota Persetujuan Peninjauan Masa Kerja","PMK","NOTA_PERSETUJUAN_PMK"));
        model.addElement(new Item(21,"SK Peninjauan Masa Kerja diterbitkan Instansi","PMK","SK_PMK"));
        model.addElement(new Item(22,"Nota Persetujuan CLTN","CLTN","NOTA_PERSETUJUAN_CLTN"));
        model.addElement(new Item(23,"Surat Keputusan  CLTN","CLTN","SK_CLTN"));
        model.addElement(new Item(24,"Nota Persetujuan Pengaktifan Kembali Setelah CLTN","CLTN","NOTA_PERSETUJUAN_PENGAKTIFAN_DARI_CLTN"));
        model.addElement(new Item(25,"Surat Keputusan Pengaktifan Kembali Setelah CLTN","CLTN","SK_PENGAKTIFAN_DARI_CLTN"));
        model.addElement(new Item(26,"Nota Persetujuan Perbantuan pada Instansi Lain","PERBANTUAN","NOTA_PERSETUJUAN_PERBANTUAN"));
        model.addElement(new Item(27,"Surat Keputusan Perbantuan kepada Instansi Lain","PERBANTUAN","SK_PERBANTUAN"));
        model.addElement(new Item(28,"Surat Keputusan Penarikan dari Perbantuan","PERBANTUAN","SK_PENARIKAN_PERBANTUAN"));
        model.addElement(new Item(29,"Surat Keputusan Diperkerjakan pada Instansi Lain","DIPEKERJAKAN","SK_DIPEKERJAKAN"));
        model.addElement(new Item(30,"Surat Keputusan Penarikan dari Diperkerjakan","DIPEKERJAKAN","SK_PENARIKAN_DARI_DIPEKERJAKAN"));
        model.addElement(new Item(31,"Surat Keputusan Hukuman Disiplin","HUKUMAN DISIPLIN","SK_HUKUMAN_DISIPLIN"));
        model.addElement(new Item(32,"Surat Keputusan Pengangkatan Kembali sebagai Pejabat Negara","SK PPJN","SK_PENGANGKATAN_SEBAGAI_PEJABAT_NEGARA"));
        model.addElement(new Item(33,"Surat Keputusan Pembebasan dari Jabatan Organik","SKPJO","SK_PEMBEBASAN_JABATAN_ORGANIK"));
        model.addElement(new Item(34,"Surat Keputusan Pemberhentian Sementara","PEMBERHENTIAN","SK_PEMBERHENTIAN_SEMENTARA"));
        model.addElement(new Item(35,"Surat Keputusan Pengaktifan Kembali dari Pernberhentian Sementara","PEMBERHENTIAN","SK_PENGAKTIFAN_DARI_PEMBERHENTIAN_SEMENTARA"));
        model.addElement(new Item(36,"Laporan Pegawai yang hilang","LAPORAN","LAPORAN_PEGAWAI_HILANG"));
        model.addElement(new Item(37,"Laporan Kembalinya PNS yang hilang","LAPORAN","LAPORAN_KEMBALI_PNS_HILANG"));
        model.addElement(new Item(38,"Surat Keputusan Pemberian Uang Tunggu","PEMBERIAN","SK_PEMBERIAN_UANG_TUNGGU"));
        model.addElement(new Item(39,"Surat Keputusan Penggantian Nama","PERUBAHAN","SK_PENGGANTIAN_NAMA"));
        model.addElement(new Item(40,"Surat Keputusan Perubahan Nama","PERUBAHAN","SK_PERUBAHAN_NAMA"));
        model.addElement(new Item(41,"Surat Keputusan Penetapan Tanggal Lahir","PERUBAHAN","SK_PENETAPAN_TGL_LAHIR"));
        model.addElement(new Item(42,"Tanda Lulus Mengikuti Pendidikan Kedinasan","LULUS","TANDA_LULUS_PENDIDIKAN_KEDINASAN"));
        model.addElement(new Item(43,"Tanda Lulus Mengikuti Pendidikan dan Pelatihan/Penataran","LULUS","TANDA_LULUS_PENDIDIKAN_PELATIHAN"));
        model.addElement(new Item(44,"Surat Keputusan Tugas Belajar Pendidikan Umum","TUGAS BELAJAR","SK_TUGAS_BELAJAR"));
        model.addElement(new Item(45,"Ijazah Pendidikan Umum","IJAZAH","IJAZAH"));
        model.addElement(new Item(46,"Laporan Peningkatan Pendidikan","LAPORAN","LAPORAN_PENINGKATAN_PENDIDIKAN"));
        model.addElement(new Item(47,"Laporan Perkawinan Pertama","LAPORAN","LAPORAN_PERKAWINAN_PERTAMA"));
        model.addElement(new Item(48,"Laporan Perkawinan Kedua","LAPORAN","LAPORAN_PERKAWINAN_KEDUA"));
        model.addElement(new Item(49,"Laporan Perkawinan Ketiga","LAPORAN","LAPORAN_PERKAWINAN_KETIGA"));
        model.addElement(new Item(50,"Laporan Perceraian Pertama","LAPORAN","LAPORAN_PERCERAIAN_PERTAMA"));
        model.addElement(new Item(51,"Laporan Perceraian Kedua","LAPORAN","LAPORAN_PERCERAIAN_KEDUA"));
        model.addElement(new Item(52,"Laporan Perceraian Ketiga","LAPORAN","LAPORAN_PERCERAIAN_KETIGA"));
        model.addElement(new Item(53,"Laporan Kelahiran Anak","LAPORAN","LAPORAN_KELAHIRAN_ANAK"));
        model.addElement(new Item(54,"Laporan Kematian Anak","LAPORAN","LAPORAN_KEMATIAN_ANAK"));
        model.addElement(new Item(55,"Surat Keterangan Pengangkatan Anak","KELUARGA","SK_PENGANGKATAN_ANAK"));
        model.addElement(new Item(56,"Surat lzin untuk Melangsungkan Perceraian","PERCERAIAN","SURAT_IZIN_PERCERAIAN"));
        model.addElement(new Item(57,"Laporan Kematian Suami","LAPORAN","LAPORAN_KEMATIAN_SUAMI"));
        model.addElement(new Item(58,"Laporan Kematian lstri","LAPORAN","LAPORAN_KEMATIAN_ISTRI"));
        model.addElement(new Item(59,"Surat Keputusan Tanda Kehormatan dan Jasa","KEHORMATAN","SK_TANDA_KEHORMATAN"));
        model.addElement(new Item(60,"Surat Keputusan Penyesuaian Gaji Pokok","PENYESUAIAN","SK_PENYESUAIAN_GAJI_POKOK"));
        model.addElement(new Item(61,"Surat Keputusan Penyesuaian Jabatan bagi PNS Jabatan Fungsional Tertentu","PENYESUAIAN","SK_PENYESUAIAN_JABATAN"));
        model.addElement(new Item(62,"Surat Keputusan Pengangkatan PNS dalam Pangkat Lokal","PENGANGKATAN","SK_PENGANGKATAN_PNS_DALAM_PANGKAT_LOKAL"));
        model.addElement(new Item(63,"Hasil Pendataan Ulang PNS Juli 2003","PUPNS","HASIL_PUPNS_2003"));
        model.addElement(new Item(64,"Hasil Pendataan Ulang PNS Juli 2015","PUPNS","HASIL_PUPNS_2005"));
        model.addElement(new Item(65,"Surat Keputusan Konversi NIP","PERUBAHAN","SK_KONVERSI_NIP"));
        model.addElement(new Item(66,"Surat Keputusan Meninggal Dunia","KEMATIAN","SK_MENINGGAL_DUNIA"));
        model.addElement(new Item(67,"Surat Keputusan Pemberhentian","PEMBERHENTIAN","SK_PEMBERHENTIAN"));
        model.addElement(new Item(68,"Surat Keputusan Kenaikan Pangkat Pengabdian","KENAIKAN","SK_KP_PENGABDIAN"));
        model.addElement(new Item(69,"Surat Keputusan Pensiun","PENSIUN","SK_PENSIUN"));
        model.addElement(new Item(70,"Daftar Riwayat Hidup","DRH","DRH"));
        model.addElement(new Item(71,"Daftar Penilaian Prestasi Kerja","PRESTASI","SKP"));
        model.addElement(new Item(72,"Nota Pertimbangan Pemberian Pensiun","PERTIMBANGAN","NOTA_PERTIMBANGAN_PEMBERIAN_PENSIUN"));
        model.addElement(new Item(73,"Pangkalan Data Direktorat Perguruan Tinggi","DIKTI","PANGKALAN_DATA_DIKTI"));
        model.addElement(new Item(74,"DPCP","DPCP","DPCP"));
        model.addElement(new Item(75,"Surat Izin Belajar","TUGAS BELAJAR","IZIN_BELAJAR"));
        model.addElement(new Item(76,"Uraian Tugas Jabatan","URAIAN TUGAS","URAIAN_TUGAS"));
        
      
    }
 
    public static DefaultComboBoxModel getData(){
        return model;
    }
    
    
}

