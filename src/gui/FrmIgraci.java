package gui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class FrmIgraci extends JFrame {
	
	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList listIgraci = new JList();
	private JTextField txtIgrac;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIgraci frame = new FrmIgraci();
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
	public FrmIgraci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 599); 
		setTitle("Evidencija igraca");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.NORTH);
		JLabel lblAleksandarKolarov = new JLabel("Aleksandar Kolarov");
		
		JLabel lblDusanTadic = new JLabel("Dusan Tadic");
		
		JLabel lblNemanjaGudelj = new JLabel("Nemanja Gudelj");
		
		JToggleButton tglbtnKolarov = new JToggleButton("Kolarov");
		tglbtnKolarov.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnKolarov.isSelected()) {
					dlm.addElement(lblAleksandarKolarov.getText());
				}
			}
		});
		
		JToggleButton tglbtnTadic = new JToggleButton("Tadic");
		tglbtnTadic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnTadic.isSelected()) {
					dlm.addElement(lblDusanTadic.getText());
				}
			}
		});
		
		JToggleButton tglbtnGudelj = new JToggleButton("Gudelj");
		tglbtnGudelj.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnGudelj.isSelected()) {
					dlm.addElement(lblNemanjaGudelj.getText());
				}
			}
		});
		
		btnGroup.add(tglbtnKolarov);
		btnGroup.add(tglbtnTadic);
		btnGroup.add(tglbtnGudelj);
		
		
		
		JScrollPane scrlPaneIgraci = new JScrollPane();
		
		JLabel lblUnesiIgraca = new JLabel("Unesi Igraca:");
		
		txtIgrac = new JTextField();
		txtIgrac.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtIgrac.getText());	
				}
				
			}
		});
		txtIgrac.setColumns(10);
		
		JLabel lblOdabirIgraca = new JLabel("Odaberi igraca:");
		
		JComboBox cbxIgraci = new JComboBox();
		cbxIgraci.addItem("Nemanja Matic");
		cbxIgraci.addItem("Luka Jovic");
		cbxIgraci.addItem("Dusan Vlahovic");
		
		JButton btnDodajOdabranogIgraca = new JButton("Dodaj odabranog igraca");
		btnDodajOdabranogIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement((String) cbxIgraci.getSelectedItem());
			}
		});
		
		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!listIgraci.isSelectionEmpty()) {
					dlm.removeElement(listIgraci.getSelectedValue());
				}else {
					JOptionPane.showMessageDialog(null, "Nije selektovan nijedan igrac iz liste!");
				}
			}
		});
		
		JButton btnDodajIgraca = new JButton("Dodaj igraca");
		btnDodajIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgIgrac dlgIgrac = new DlgIgrac();
				dlgIgrac.setVisible(true);
				if(dlgIgrac.isOk == true) {
					dlm.addElement(dlgIgrac.getTxtIme().getText() +" " + dlgIgrac.getTxtPrezime().getText());
				}
			}
		});
		
		JButton btnModifikujIgraca = new JButton("Modifikuj igraca");
		btnModifikujIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!listIgraci.isSelectionEmpty()) {
					DlgIgrac dlgModifikuj = new DlgIgrac();
					String[] split = dlm.getElementAt(listIgraci.getSelectedIndex()).toString().split(" ");
					dlgModifikuj.getTxtIme().setText(split[0]);
					dlgModifikuj.getTxtPrezime().setText(split[1]);
					dlgModifikuj.setVisible(true);
					
					if(dlgModifikuj.isOk == true) {
						dlm.setElementAt(dlgModifikuj.getTxtIme().getText() + " " + dlgModifikuj.getTxtPrezime().getText(), listIgraci.getSelectedIndex());
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Selektujte igraca u listi!");
				}
			}
		});
		
		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCentar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnModifikujIgraca)
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addComponent(lblOdabirIgraca, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbxIgraci, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDodajOdabranogIgraca)
							.addGap(558)
							.addComponent(btnDodajIgraca))
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addComponent(lblUnesiIgraca)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtIgrac, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 779, Short.MAX_VALUE)
							.addComponent(btnIzbrisi))
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tglbtnGudelj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tglbtnTadic, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tglbtnKolarov, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
							.addGap(31)
							.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNemanjaGudelj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDusanTadic, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblAleksandarKolarov, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
							.addComponent(scrlPaneIgraci, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)))
					.addGap(88))
		);
		gl_pnlCentar.setVerticalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnKolarov)
								.addComponent(lblAleksandarKolarov))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnTadic)
								.addComponent(lblDusanTadic))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnGudelj)
								.addComponent(lblNemanjaGudelj)))
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addGap(29)
							.addComponent(scrlPaneIgraci, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnesiIgraca)
								.addComponent(txtIgrac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(40)
							.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOdabirIgraca)
								.addComponent(cbxIgraci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDodajOdabranogIgraca)))
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addGap(18)
							.addComponent(btnIzbrisi)
							.addGap(18)
							.addComponent(btnDodajIgraca)))
					.addGap(18)
					.addComponent(btnModifikujIgraca)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		
		scrlPaneIgraci.setViewportView(listIgraci);
		pnlCentar.setLayout(gl_pnlCentar);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnIspisi = new JButton("Ispi\u0161i");
		btnIspisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test button");
			}
		});
		pnlSouth.add(btnIspisi);
		
		listIgraci.setModel(dlm); //bindovanje modela na listu igraca(listIgraci)
		
	}
}
