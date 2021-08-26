package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private DefaultListModel<String> dlm  = new DefaultListModel<String>();
	private JLabel lblCrvena;
	private JLabel lblPlava;
	private JLabel lblZuta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlNorth = new JPanel();
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblNaslov = new JLabel("Naslov");
		pnlNorth.add(lblNaslov);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnIspisi = new JButton("Ispi\u0161i");
		btnIspisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antistress dugme :)");
			}
		});
		pnlSouth.add(btnIspisi);
		
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCentar = new GridBagLayout();
		gbl_pnlCentar.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlCentar.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlCentar.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCentar.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCentar.setLayout(gbl_pnlCentar);
		
		JToggleButton tglbtnCrvena = new JToggleButton("Crvena");
		tglbtnCrvena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGroup.add(tglbtnCrvena);
				dlm.addElement(lblCrvena.getText());
				if(tglbtnCrvena.isSelected()) {
					lblCrvena.setForeground(Color.RED);
					lblZuta.setForeground(Color.BLACK);
					lblPlava.setForeground(Color.BLACK);
				}
			}
		});
		GridBagConstraints gbc_tglbtnCrvena = new GridBagConstraints();
		gbc_tglbtnCrvena.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvena.gridx = 0;
		gbc_tglbtnCrvena.gridy = 0;
		pnlCentar.add(tglbtnCrvena, gbc_tglbtnCrvena);
		
		lblCrvena = new JLabel("Crvena");
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 0;
		pnlCentar.add(lblCrvena, gbc_lblCrvena);
		
		JScrollPane scrlPaneBoje = new JScrollPane();
		GridBagConstraints gbc_scrlPaneBoje = new GridBagConstraints();
		gbc_scrlPaneBoje.gridheight = 3;
		gbc_scrlPaneBoje.gridwidth = 4;
		gbc_scrlPaneBoje.insets = new Insets(0, 0, 5, 0);
		gbc_scrlPaneBoje.fill = GridBagConstraints.BOTH;
		gbc_scrlPaneBoje.gridx = 2;
		gbc_scrlPaneBoje.gridy = 0;
		pnlCentar.add(scrlPaneBoje, gbc_scrlPaneBoje);
		
		JList lstBoje = new JList();
		lstBoje.setLayoutOrientation(JList.VERTICAL_WRAP);
		scrlPaneBoje.setViewportView(lstBoje);
		lstBoje.setModel(dlm);
		
		JToggleButton tglbtnPlava = new JToggleButton("Plava");
		tglbtnPlava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGroup.add(tglbtnPlava);
				dlm.addElement(lblPlava.getText());
				if(tglbtnPlava.isSelected()) {
					lblCrvena.setForeground(Color.BLACK);
					lblZuta.setForeground(Color.BLACK);
					lblPlava.setForeground(Color.BLUE);
				}
			}
		});
		GridBagConstraints gbc_tglbtnPlava = new GridBagConstraints();
		gbc_tglbtnPlava.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlava.gridx = 0;
		gbc_tglbtnPlava.gridy = 1;
		pnlCentar.add(tglbtnPlava, gbc_tglbtnPlava);
		
		lblPlava = new JLabel("Plava");
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 1;
		pnlCentar.add(lblPlava, gbc_lblPlava);
		
		JToggleButton tglbtnZuta = new JToggleButton("\u017Duta");
		tglbtnZuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGroup.add(tglbtnZuta);
				dlm.addElement(lblZuta.getText());
				if(tglbtnZuta.isSelected()) {
					lblCrvena.setForeground(Color.BLACK);
					lblZuta.setForeground(Color.YELLOW);
					lblPlava.setForeground(Color.BLACK);
				}
			}
		});
		GridBagConstraints gbc_tglbtnZuta = new GridBagConstraints();
		gbc_tglbtnZuta.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnZuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnZuta.gridx = 0;
		gbc_tglbtnZuta.gridy = 2;
		pnlCentar.add(tglbtnZuta, gbc_tglbtnZuta);
		
		lblZuta = new JLabel("\u017Duta");
		GridBagConstraints gbc_lblZuta = new GridBagConstraints();
		gbc_lblZuta.insets = new Insets(0, 0, 0, 5);
		gbc_lblZuta.gridx = 1;
		gbc_lblZuta.gridy = 2;
		pnlCentar.add(lblZuta, gbc_lblZuta);
	}

}
