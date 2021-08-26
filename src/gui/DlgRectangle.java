package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public boolean flag;
	private JFormattedTextField ftxtfXcoord;
	private JFormattedTextField ftxtfYcoord;
	private JFormattedTextField ftxtfWidht;
	private JFormattedTextField ftxtfHeight;
	private Color initialBorderColor;
	private Color initialInnerColor;
	public Color borderColor;
	public Color innerColor;
	public boolean borderColorChanged;
	public boolean innerColorChanged;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setTitle("Rectangle");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][][][grow][grow]", "[grow][16.00][][][][23.00][29.00][]"));
		setModal(true);
		setResizable(false);
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setAllowsInvalid(false); 
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(800);
		
		{
			JLabel lblXcoord = new JLabel("Upper Left X coordinate:");
			lblXcoord.setForeground(Color.BLACK);
			lblXcoord.setFont(new Font("Tahoma", Font.BOLD, 10));
			contentPanel.add(lblXcoord, "cell 1 1");
		}
		{
			
			ftxtfXcoord = new JFormattedTextField(numberFormatter);
			contentPanel.add(ftxtfXcoord, "cell 3 1,growx");
			
		}
		{
			JLabel lblYcoord = new JLabel("Upper Left Y coordinate:");
			lblYcoord.setForeground(Color.BLACK);
			lblYcoord.setFont(new Font("Tahoma", Font.BOLD, 10));
			contentPanel.add(lblYcoord, "cell 1 2");
		}
		{
			ftxtfYcoord = new JFormattedTextField(numberFormatter);
			contentPanel.add(ftxtfYcoord, "cell 3 2,growx");
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			lblWidth.setForeground(new Color(0, 0, 0));
			lblWidth.setFont(new Font("Tahoma", Font.BOLD, 12));
			contentPanel.add(lblWidth, "cell 1 3");
		}
		{
			ftxtfWidht = new JFormattedTextField(numberFormatter);
			contentPanel.add(ftxtfWidht, "cell 3 3,growx");
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			lblHeight.setForeground(Color.BLACK);
			lblHeight.setFont(new Font("Tahoma", Font.BOLD, 12));
			contentPanel.add(lblHeight, "cell 1 4");
		}
		{
			ftxtfHeight = new JFormattedTextField(numberFormatter);
			contentPanel.add(ftxtfHeight, "cell 3 4,growx");
		}
		{
			JLabel lblBorderColor = new JLabel("Border color");
			lblBorderColor.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBorderColor.setForeground(Color.BLACK);
			contentPanel.add(lblBorderColor, "cell 1 5");
		}
		{
			JButton btnBorderColor = new JButton("Choose");
			btnBorderColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borderColorChanged = true;   
					borderColor = JColorChooser.showDialog(null,"Select border color",getInitialBorderColor());
				}
			});
			contentPanel.add(btnBorderColor, "cell 3 5");
		}
		{
			JLabel lblInnerColor = new JLabel("Inner color");
			lblInnerColor.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblInnerColor.setForeground(Color.BLACK);
			contentPanel.add(lblInnerColor, "cell 1 6");
		}
		{
			JButton btnInnerColor = new JButton("Choose");
			btnInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					innerColorChanged = true;
					innerColor = JColorChooser.showDialog(null,"Select inner color",getInitialInnerColor());
				}
			});
			contentPanel.add(btnInnerColor, "cell 3 6");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!ftxtfXcoord.getText().isEmpty() && 
							!ftxtfYcoord.getText().isEmpty() &&
							!ftxtfWidht.getText().isEmpty() &&
							!ftxtfHeight.getText().isEmpty()) {
								flag = true;
								dispose();
						}
						else {
							flag = false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "All fields has to be filled!");
							getToolkit().beep();
						}
					}
					
				});
				
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						flag = false;
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	public JFormattedTextField getFtxtfXcoord() {
		return ftxtfXcoord;
	}

	public void setFtxtfXcoord(JFormattedTextField ftxtfXcoord) {
		this.ftxtfXcoord = ftxtfXcoord;
	}

	public JFormattedTextField getFtxtfYcoord() {
		return ftxtfYcoord;
	}

	public void setFtxtfYcoord(JFormattedTextField ftxtfYcoord) {
		this.ftxtfYcoord = ftxtfYcoord;
	}

	public JFormattedTextField getFtxtfWidth() {
		return ftxtfWidht;
	}

	public void setFtxtfWidth(JFormattedTextField ftxtfWidth) {
		this.ftxtfWidht = ftxtfWidth;
	}

	public JFormattedTextField getFtxtfHeight() {
		return ftxtfHeight;
	}

	public void setFtxtfHeight(JFormattedTextField ftxtfHeight) {
		this.ftxtfHeight = ftxtfHeight;
	}

	public Color getInitialBorderColor() {
		return initialBorderColor;
	}

	public void setInitialBorderColor(Color initialBorderColor) {
		this.initialBorderColor = initialBorderColor;
	}

	public Color getInitialInnerColor() {
		return initialInnerColor;
	}

	public void setInitialInnerColor(Color initialInnerColor) {
		this.initialInnerColor = initialInnerColor;
	}

}
