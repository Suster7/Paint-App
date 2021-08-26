package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class FrmRectangleStack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRectangleStack frame = new FrmRectangleStack();
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
	public FrmRectangleStack() {
		setTitle("IT 59-2020 Šuster Miroslav");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		Stack<Rectangle> stack = new Stack<Rectangle>();
		
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setAllowsInvalid(false); 
		numberFormatter.setMinimum(1);
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblRectStack = new JLabel("Rectangle Stack");
		lblRectStack.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRectStack.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		lblRectStack.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		lblRectStack.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlNorth.add(lblRectStack);
		
		JPanel pnlWest = new JPanel();
		pnlWest.setBackground(new Color(0, 153, 255));
		contentPane.add(pnlWest, BorderLayout.WEST);
		pnlWest.setLayout(new MigLayout("", "[85px]", "[21px][21px][21px][21px][21px][21px]"));
		
		JButton btnAdd = new JButton("Add new");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgRectangleSS dlgrs = new DlgRectangleSS();
				dlgrs.setVisible(true);
				if(dlgrs.flag == true) {
					Rectangle rectangle = new Rectangle(new Point(Integer.parseInt(dlgrs.getFtxtfXcoord().getText()),
							Integer.parseInt(dlgrs.getFtxtfYcoord().getText())),
							Integer.parseInt(dlgrs.getFtxtfWidth().getText()) ,
							Integer.parseInt(dlgrs.getFtxtfHeight().getText()) );
							stack.push(rectangle);
							dlm.add(0,stack.peek().toString());
				}
				
			}
		});
		pnlWest.add(btnAdd, "cell 0 2,alignx center,aligny center");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty - Deleting is not possible!");
				}else {
					DlgRectangleSS dlgrs = new DlgRectangleSS();
					dlgrs.getFtxtfXcoord().setText(Integer.toString(stack.peek().getUpperLeftPoint().getX()));
					dlgrs.getFtxtfYcoord().setText(Integer.toString(stack.peek().getUpperLeftPoint().getY()));
					dlgrs.getFtxtfWidth().setText(Integer.toString(stack.peek().getWidth()));
					dlgrs.getFtxtfHeight().setText(Integer.toString(stack.peek().getHeight()));
					
					dlgrs.getFtxtfXcoord().setEditable(false);
					dlgrs.getFtxtfYcoord().setEditable(false);
					dlgrs.getFtxtfWidth().setEditable(false);
					dlgrs.getFtxtfHeight().setEditable(false);
					dlgrs.setVisible(true);
					if(dlgrs.flag == true) {
						stack.pop();
						dlm.removeElementAt(0);
					}
					
				}
			}
		});
		pnlWest.add(btnDelete, "flowx,cell 0 4,growx,aligny center");
		
		JScrollPane scrpnlCenter = new JScrollPane();
		contentPane.add(scrpnlCenter, BorderLayout.CENTER);
		
		list = new JList();
		scrpnlCenter.setViewportView(list);
		list.setModel(dlm);

	}

}
