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
import javax.swing.DefaultComboBoxModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			jLabel1.setText(Messages.get("doc.name"));                        
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
                        cbFileType.setSelectedIndex(-1);
                        JTextField field = (JTextField)cbFileType.getEditor().getEditorComponent();
                        field.setText("");
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
               
               if(ae.getSource()==bScan){
                   
                       
                Item item = (Item) cbFileType.getModel().getSelectedItem();
                System.out.println( "id : " + item.getId() +
                        " desc : " + item.getDescription() +
                        " path : " + item.getPath() +  
                        " file name : " + item.getFname());
                        
                    if (fileName.length() > 0) {
                        scanner.acquire(fileName,
                           fileType.toLowerCase(),
                           false,
                           bScan,
                           bSelectScan,
                           bSetScan,
                           tfFileName,
                           cbFileType);
		    } else {
			JOptionPane.showMessageDialog(this,
                                "File name cannot be empty",
                                "Error", JOptionPane.ERROR_MESSAGE);
		    }
                   
                }else if(ae.getSource()==bSelectScan){
                   try {
                       scanner.selectScan();
                   } catch (ScannerIOException ex) {
                       Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }else{
                    scanner.acquire(fileName,
                            fileType.toLowerCase(),
                            true,
                            bScan,
                            bSelectScan,
                            bSetScan,
                            tfFileName,
                            cbFileType);
		  
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
