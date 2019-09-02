/**
 *  OpenKM, Open Document Management System (http://www.openkm.com)
 *  Copyright (c) 2006-2010  Paco Avila & Josep Llort
 *
 *  No bytes were intentionally harmed during the development of this application.
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.openkm.applet;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import netscape.javascript.JSObject;
import uk.co.mmscomputing.device.scanner.ScannerIOException;

public class MainFrame extends JFrame implements ActionListener, WindowListener {
	private static Logger log = Logger.getLogger(MainFrame.class.getName());
	private static final long serialVersionUID = 1L;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton bScan;
	private JComboBox cbFileType;
	private JTextField tfFileName;
	private JCheckBox cbUI;
	private ScannerManager scanner;
	private JSObject win;
        private JButton bSelectScan;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Messages.init(Locale.getDefault());
				MainFrame inst = new MainFrame(null, null);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}

	/**
	 *
	 */
	public MainFrame(ScannerManager scanner, JSObject win) {
		super("Scan & Upload");
		initGUI();
		// JComponent jc = scanner.getDevice().getScanGUI();
		// jc.setBounds(260, 10, 115, 150);
		// getContentPane().add(jc);
		addWindowListener(this);

		// Set instances
		this.scanner = scanner;
		this.win = win;

		// Get the size of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;

		// Move the window
		this.setLocation(x, y);
	}

	/**
	 * 
	 */
	private void initGUI() {
		try {
			getContentPane().setLayout(null);

			jLabel1 = new JLabel();
			getContentPane().add(jLabel1);
			jLabel1.setText(Messages.get("doc.name"));                        
			jLabel1.setBounds(19, 19, 105, 15);
			
			jLabel2 = new JLabel();
			getContentPane().add(jLabel2);
			
                        jLabel2.setText(Messages.get("doc.type"));
			jLabel2.setBounds(19, 45, 105, 15);
			
			tfFileName = new JTextField();
			getContentPane().add(tfFileName);
			tfFileName.setBounds(125, 15, 190, 22);
			
                        
                        DefaultComboBoxModel DocTypeModel = new DefaultComboBoxModel();
                        JComboBox<String> comboBox = new JComboBox<>(DocTypeModel);
                        comboBox.setSelectedIndex(-1);
                        comboBox.setEditable(true);
                       
                        


                        DocTypeModel.addElement(new DocTypeModel("1","1. Kartu Pendaftaran Ulang PNS (KARDAF) Tahun 1974"));	
                        DocTypeModel.addElement(new DocTypeModel("2","2. Data Kepegawaian Perorangan (DKP)"));
                        DocTypeModel.addElement(new DocTypeModel("3","3. Nota Persetujuan/Penetapan NIP)"));
                        DocTypeModel.addElement(new DocTypeModel("4","4. Surat Keputusan Pengangkatan sebagai Calon PNS"));
                        DocTypeModel.addElement(new DocTypeModel("5","5. Surat Perintah Melaksanakan Tugas (SPMT)"));
                        DocTypeModel.addElement(new DocTypeModel("6","6. Surat Tanda Tamat Pendidikan dan Pelatihan"));
                        DocTypeModel.addElement(new DocTypeModel("7","7. Berita Acara Pengangkatan Sumpah dan Janji PNS"));
                        DocTypeModel.addElement(new DocTypeModel("8","8. Surat Keputusan Pengangkatan sebagai PNS"));
                        
                        
                        /*
			new String[] { 
                             "",
                            "",
                            "",
                            "",
                            "9. Nota Persetujuan Kenaikan Pangkat",
                            "10. Nota Persetujuan Mutasi Lain-Lain",
                            "11. SK Kenaikan Pangkat PNS",
                            "12. SK Mutasi lain-lain PNSS",
                            "13. Penetapan Angka Kredit",
                            "14. Berita Acara Pelantikan dalam Jabatan",
                            "15. SK Pengangkatan, Pemindahan, dan Pemberhentian  Jabatan",
                            "16. Surat Pernyataan Menduduki Jabatan",
                            "17. SK Pindah Wilayah Kerja",
                            "18. Nota Persetujuan Perpindahan Antar Instansi",
                            "19. Surat Keputusan Pindah Antar lnstansi diterbitkan Instansi",
                            "20. Nota Persetujuan Peninjauan Masa Kerja",
                            "21. SK Peninjauan Masa Kerja diterbitkan Instansi",
                            "22. Nota Persetujuan CLTN",
                            "23. Surat Keputusan  CLTN",
                            "24. Nota Persetujuan Pengaktifan Kernbali Setelah CLTN",
                            "25. Surat Keputusan Pengaktifan Kembali Setelah CLTN",
                            "26. Nota Persetujuan Perbantuan pada Instansi Lain",
                            "27. SK Perbantuan kepada Instansi Lain",
                            "28. SK Penarikan dari Perbantuan",
                            "29. SK Diperkerjakan pada Instansi Lain",
                            "30. SK Penarikan dari Diperkerjakan",
                            "31. SK Hukuman Disiplin",
                            "32. SK Pengangkatan Kembali sebagai Pejabat Negara",
                            "33. SK Pembebasan dari Jabatan Organik",
                            "34. SK Pemberhentian Sementara",
                            "35. SK Pengaktifan Kembali dari Pernberhentian Sementara",
                            "36. Laporan Pegawai yang hilang",
                            "37. Laporan Kembalinya PNS yang hilang",
                            "38. Surat Keputusan Pemberian Uang Tunggu",
                            "39. Surat Keputusan Penggantian/Perubahan nama",
                            "40. Surat Keputusan Penetapan Tanggal Lahir",
                            "41. Tanda Lulus Mengikuti Pendidikan Kedinasan",
                            "42. Tanda Lulus Mengikuti Pendidikan dan Pelatihan/Penataran",
                            "43. Surat Keputusan Tugas Belajar Pendidikan Umum",
                            "44. Surat Tanda Lulus/ Ijazah Pendidikan Umum",
                            "45. Laporan Peningkatan Pendidikan",
                            "46. Laporan Perkawinan Pertama/Kedua/Ketiga/Perceraian",
                            "47. Laporan Kelahiran/Kematian Anak",
                            "48. Surat Keterangan Pengangkatan Anak",
                            "49. Surat lzin untuk Melangsungkan Perceraian",
                            "50. Laporan Kematian Suami/ lstri",
                            "51. Surat Keputusan Tanda Kehormatan dan Jasa",
                            "52. Surat Keputusan Penyesuaian Gaji Pokok",
                            "53. SK Penyesuaian Jabatan bagi PNS Jabatan Fungsional Tertentu",
                            "54. Surat Keputusan Pengangkatan PNS dalam Pangkat Lokal",
                            "55. Hasil Pendataan Ulang PNS Juli 2003",
                            "56. Hasil Pendataan Ulang PNS Juli 2015",
                            "57. Surat Keputusan Konversi NIP",
                            "58. Surat Keputusan Meninggal Dunia",
                            "59. Surat Keputusan Pemberhentian",
                            "60. Surat Keputusan Kenaikan Pangkat Pengabdian",
                            "61. Surat Keputusan Pensiun",
                            "62. Daftar Riwayat Hidup",
                            "63. Daftar Penilaian Prestasi Kerja",
                            "64. Nota Pertimbangan Pemberian Pensiun",
                            "65. Pangkalan Data",
                            "66. DPCP",
                            "67. Surat Tugas Belajar/Izin Belajar",
                            "68. Uraian Tugas Jabatan",
                        });
                        */
			cbFileType = new JComboBox();
			getContentPane().add(cbFileType);
			cbFileType.setModel(DocTypeModel);
			cbFileType.setBounds(125, 43, 500, 22);
                        AutoCompletion.enable(cbFileType);
			
			//cbUI = new JCheckBox(Messages.get("user.interface"), true);
                        cbUI = new JCheckBox("Show Scanner Interface", false);
			getContentPane().add(cbUI);
			cbUI.setBounds(650, 43, 200, 22);
			
			bScan = new JButton();
			getContentPane().add(bScan);
			bScan.setText(Messages.get("scan.upload"));
			bScan.setBounds(20, 84, 235, 22);
			bScan.addActionListener(this);
                        
                        bSelectScan = new JButton();
			getContentPane().add(bSelectScan);
			bSelectScan.setText(Messages.get("select.scan"));
			bSelectScan.setBounds(275, 84, 235, 22);
			bSelectScan.addActionListener(this);
			
			pack();
			this.setSize(850, 159);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
           
            DocTypeModel item = (DocTypeModel) cbFileType.getModel().getSelectedItem();
            System.out.println( item.getId() + " : " + item.getName() );
            /*
		
            try {
			String fileName = tfFileName.getText().trim();
			String fileType = "";
                        System.out.println(cbFileType.getModel());
                        
                        
                        
			if (fileName.length() > 0) {
				scanner.acquire(fileName, fileType.toLowerCase(), cbUI.isSelected(), bScan, tfFileName, cbFileType, cbUI);
			} else {
				JOptionPane.showMessageDialog(this, "Empty file name", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (ScannerIOException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
            */
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		log.info("windowClosed: calling 'destroyScannerApplet'");
		if (win != null) {
			win.call("destroyScannerApplet", new Object[] {});
		} else {
			JOptionPane.showMessageDialog(null, "destroyScannerApplet", "JavaScript call",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

    private ActionListener createSearchActionListener(JComboBox<String> comboBox, DefaultComboBoxModel DocTypeModel) {
            return null;
       
    }
}
