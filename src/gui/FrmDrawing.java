package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.jdi.Accessible;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import net.miginfocom.swing.MigLayout;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDrawing extends JFrame{

	private JPanel contentPane;
	public ButtonGroup tglbtnButtonGroup = new ButtonGroup();
	public JToggleButton tglbtnPoint;
	public JToggleButton tglbtnLine;
	public JToggleButton tglbtnRectangle;
	public JToggleButton tglbtnCircle;
	public JToggleButton tglbtnDonut;
	public JButton btnModify;
	public JButton btnDelete;
	private JButton btnColorChooser;
	public Color color;
	private JButton btnDeleteAll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		  
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
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
	public FrmDrawing() {
		PnlDrawing panelDrawing = new PnlDrawing(this);
		setTitle("IT 59-2020 Šuster Miroslav");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(panelDrawing, BorderLayout.CENTER);
		getContentPane().add(panelDrawing);
		panelDrawing.setVisible(true);
		
		
		
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][][grow][][][][grow,right][right]", "[]"));
		
		tglbtnPoint = new JToggleButton("Point");
		panel.add(tglbtnPoint, "cell 0 0");
		
		tglbtnLine = new JToggleButton("Line");
		panel.add(tglbtnLine, "cell 1 0");
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		panel.add(tglbtnRectangle, "cell 2 0");
		
		tglbtnCircle = new JToggleButton("Circle");
		panel.add(tglbtnCircle, "cell 3 0");
		
		tglbtnDonut = new JToggleButton("Donut");
		panel.add(tglbtnDonut, "cell 4 0");
		
		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDrawing.modify();
			}
		});
		
		panel.add(btnModify, "cell 12 0");
		
		tglbtnButtonGroup.add(tglbtnPoint);
		tglbtnButtonGroup.add(tglbtnLine);
		tglbtnButtonGroup.add(tglbtnRectangle);
		tglbtnButtonGroup.add(tglbtnCircle);
		tglbtnButtonGroup.add(tglbtnDonut);
		
		btnColorChooser = new JButton("");
		btnColorChooser.setBackground(Color.black);
		btnColorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null,"Select a color",Color.black);    
				btnColorChooser.setBackground(color);  
			}
		});
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDrawing.delete();
			}
		});
		panel.add(btnDelete, "cell 13 0");
		
		btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDrawing.deleteAll();
			}
		});
		panel.add(btnDeleteAll, "cell 14 0");
		panel.add(btnColorChooser, "cell 16 0,grow");
	}

}
