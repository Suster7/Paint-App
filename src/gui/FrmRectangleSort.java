package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRectangleSort extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrlPaneLeft;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private DefaultListModel<String> dlmSorted = new DefaultListModel<String>();
	private JList unsortedList;
	private JList sortedList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRectangleSort frame = new FrmRectangleSort();
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
	public FrmRectangleSort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("IT 59-2020 Šuster Miroslav");
		setResizable(false);
		
		
		ArrayList<Rectangle> list = new ArrayList<Rectangle>();
		ArrayList<Rectangle> Slist = new ArrayList<Rectangle>();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Rectangle Sort");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblTitle);
		
		JPanel pnlContainer = new JPanel();
		contentPane.add(pnlContainer, BorderLayout.CENTER);
		pnlContainer.setLayout(new MigLayout("", "[grow][grow][grow][][][grow][grow]", "[grow][grow][grow][grow][grow][grow]"));
		
		scrlPaneLeft = new JScrollPane();
		pnlContainer.add(scrlPaneLeft, "cell 0 0 2 6,grow");
		
		
		
		JPanel pnlCenter = new JPanel();
		pnlContainer.add(pnlCenter, "cell 2 0 1 6,grow");
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{73, 0};
		gbl_pnlCenter.rowHeights = new int[]{36, 21, 33, 21, 33, 21, 0};
		gbl_pnlCenter.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JButton btnAddNew = new JButton("Add new");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgRectangleSS dlgrs = new DlgRectangleSS();
				dlgrs.setVisible(true);
				if(dlgrs.flag == true) {
					Rectangle rectangle = new Rectangle(new Point(Integer.parseInt(dlgrs.getFtxtfXcoord().getText()),
							Integer.parseInt(dlgrs.getFtxtfYcoord().getText())),
							Integer.parseInt(dlgrs.getFtxtfWidth().getText()) ,
							Integer.parseInt(dlgrs.getFtxtfHeight().getText()) );
							list.add(rectangle);
							dlm.addElement(list.get(list.size() - 1).toString());
				}
			}
		});
		GridBagConstraints gbc_btnAddNew = new GridBagConstraints();
		gbc_btnAddNew.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAddNew.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddNew.gridx = 0;
		gbc_btnAddNew.gridy = 1;
		pnlCenter.add(btnAddNew, gbc_btnAddNew);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty - Deleting is not possible!");
				}
				else 
				{
					if(!unsortedList.isSelectionEmpty()) {
						list.remove(unsortedList.getSelectedIndex());
						dlm.removeElementAt(unsortedList.getSelectedIndex());
					}else {
						JOptionPane.showMessageDialog(null, "You need to select object you want to delete!");
					}
				}				
			}
			
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.NORTH;
		gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 3;
		pnlCenter.add(btnDelete, gbc_btnDelete);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Slist.removeAll(Slist);
				sortedList.removeAll();
				dlmSorted.removeAllElements();
				Slist.addAll(list);
				Collections.sort(Slist);
				for(int i=0;i<Slist.size();i++) {
					dlmSorted.addElement(Slist.get(i).toString());	
				}
			}
		});
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.anchor = GridBagConstraints.SOUTH;
		gbc_btnSort.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSort.gridx = 0;
		gbc_btnSort.gridy = 5;
		pnlCenter.add(btnSort, gbc_btnSort);
		
		JScrollPane scrlPaneRight = new JScrollPane();
		pnlContainer.add(scrlPaneRight, "cell 5 0 2 6,grow");
		
		unsortedList = new JList();
		scrlPaneLeft.setViewportView(unsortedList);
		unsortedList.setModel(dlm);
		
		
		sortedList = new JList();
		sortedList.setEnabled(false);
		scrlPaneRight.setViewportView(sortedList);
		sortedList.setModel(dlmSorted);
	}

}
