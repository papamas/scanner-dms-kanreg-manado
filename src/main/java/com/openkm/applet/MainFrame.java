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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import netscape.javascript.JSObject;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import uk.co.mmscomputing.device.scanner.ScannerIOException;
import uk.co.mmscomputing.device.scanner.ScannerIOMetadata;
import java.sql.SQLException;
import java.util.List;

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
        private JButton bSetScan;
        private String folder;
        private ScannerIOMetadata metadata;
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) throws SQLException {            
	    	
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
			jLabel1.setText(Messages.get("doc.tmt"));                        
			jLabel1.setBounds(19, 19, 105, 15);
			
			jLabel2 = new JLabel();
			getContentPane().add(jLabel2);
			
                        jLabel2.setText(Messages.get("doc.type"));
			jLabel2.setBounds(19, 45, 105, 15);
			
			tfFileName = new JTextField();
			getContentPane().add(tfFileName);
			tfFileName.setBounds(125, 15, 190, 22);
			
                       
                        cbFileType = new JComboBox(JenisDokumenModel.getData());
                        getContentPane().add(cbFileType);
                        cbFileType.setEditable(true);
                        JTextField field = (JTextField)cbFileType.getEditor().getEditorComponent();
                        field.addKeyListener(new ComboKeyHandler(cbFileType));
                        cbFileType.setBounds(125, 43, 650, 22);                 
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
                        
                        bSetScan = new JButton();
			getContentPane().add(bSetScan);
			bSetScan.setText(Messages.get("set.scan"));
			bSetScan.setBounds(525, 84, 235, 22);
			bSetScan.addActionListener(this);
			
			pack();
			this.setSize(850, 159);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
            String fileName = tfFileName.getText().trim();
            String fileType = "pdf"; 
            String path   =  this.scanner.getPath();
            int index = path.lastIndexOf('/');
            String nip = path.substring(index +1);
            
            if(nip.startsWith("19") && nip.length() == 18){
                if(ae.getSource()==bScan){                      
                    Item item = (Item) cbFileType.getModel().getSelectedItem(); 
                    folder    = item.getPath();
                    int id    = item.getId();                  
                    
                    if (fileName.length() > 0) {

                         switch (id){
                        case 1:
                            fileName = "";
                        break;
                        case 2:
                            fileName = "";
                        break; 
                        case 3:
                            fileName = "";
                        break; 
                        case 4:
                            fileName = "";
                        break;
                        case 5:
                            fileName = "";
                        break;
                        case 6:
                            fileName = "";
                        break;
                        case 8:
                            fileName = "";
                        break;
                        case 9:
                            fileName = "";
                        break;
                        case 10:
                            fileName = "";
                        break;
                        case 38:
                            fileName = "";
                        break;
                        case 39:
                            fileName = "";
                        break;
                        case 40:
                            fileName = "";
                        break;
                        case 49:
                            fileName = "";
                        break;
                        case 50:
                            fileName = "";
                        break;
                        case 51:
                            fileName = "";
                        break;
                        case 52:
                            fileName = "";
                        break;
                        case 53:
                            fileName = "";
                        break;
                        case 54:
                            fileName = "";
                        break;
                        case 65:
                            fileName = "";
                        break;
                        case 66:
                            fileName = "";
                        break;
                        case 67:
                            fileName = "";
                        break;
                        case 68:
                            fileName = "";
                        break;
                        case 69:
                            fileName = "";
                        break;
                        case 70:
                            fileName = "";
                        break;
                        case 71:
                            fileName = "";
                        break;
                        case 74:
                            fileName = "";
                        break;
                        case 76:
                            fileName = "";
                        break;
                        case 79:
                            fileName = "";
                        break;
                        case 81:
                            fileName = "";
                        break;
                        case 82:
                            fileName = "";
                        break;
                        case 83:
                            fileName = "";
                        break;
                        case 84:
                            fileName = "";
                        break;
                        case 85:
                            fileName = "";
                        break;
                        case 87:
                            fileName = "";
                        break;
                        case 88:
                            fileName = "";
                        break;
                        case 89:
                            fileName = "";
                        break;
                        case 90:
                            fileName = "";
                        break;
                        case 91:
                            fileName = "";
                        break;
                        case 92:
                            fileName = "";
                        break;
                        case 93:
                            fileName = "";
                        break;
                        default:
                            fileName = "_"+fileName;
                    }
                        scanner.acquire(folder, item.getFname()+"_"+nip+fileName,
                           fileType.toLowerCase(),
                           false,
                           bScan,
                           bSelectScan,
                           bSetScan,
                           tfFileName,
                           cbFileType);
		    } else {
			JOptionPane.showMessageDialog(this,
                                "TMT Dokumen Tidak Boleh Kosong",
                                "Error", JOptionPane.ERROR_MESSAGE);
		    }
                   
                }else if(ae.getSource()==bSelectScan){
                   try {
                       scanner.selectScan();
                   } catch (ScannerIOException ex) {
                       Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }else{
                    scanner.acquire(folder,
                            fileName,
                            fileType.toLowerCase(),
                            true,
                            bScan,
                            bSelectScan,
                            bSetScan,
                            tfFileName,
                            cbFileType);
		  
                }   
            }else{
                JOptionPane.showMessageDialog(this,
                            "Dokumen hanya boleh di Scan pada Folder NIP",
                            "Error", JOptionPane.ERROR_MESSAGE);
            }          
            
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		log.info("windowClosed: calling 'destroyScannerApplet'");
		if (win != null) {
			win.call("destroyScannerAppletFix", new Object[] {});
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
        
       
    
}
