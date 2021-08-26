package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color color;
	private Color initialColor;
	private JFormattedTextField ftxtfXcoord;
	private JFormattedTextField ftxtfYcoord;
	public boolean flag;
	public boolean colorChange;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setAllowsInvalid(false); 
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(800);
		
		setTitle("Modify Point");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 29, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXcoord = new JLabel("X coordinate:");
			GridBagConstraints gbc_lblXcoord = new GridBagConstraints();
			gbc_lblXcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcoord.gridx = 1;
			gbc_lblXcoord.gridy = 2;
			contentPanel.add(lblXcoord, gbc_lblXcoord);
		}
		{
			ftxtfXcoord = new JFormattedTextField();
			GridBagConstraints gbc_ftxtfXcoord = new GridBagConstraints();
			gbc_ftxtfXcoord.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtfXcoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtfXcoord.gridx = 3;
			gbc_ftxtfXcoord.gridy = 2;
			contentPanel.add(ftxtfXcoord, gbc_ftxtfXcoord);
		}
		{
			JLabel lblYcoord = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblYcoord = new GridBagConstraints();
			gbc_lblYcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcoord.gridx = 1;
			gbc_lblYcoord.gridy = 3;
			contentPanel.add(lblYcoord, gbc_lblYcoord);
		}
		{
			ftxtfYcoord = new JFormattedTextField(numberFormatter);
			GridBagConstraints gbc_ftxtfYcoord = new GridBagConstraints();
			gbc_ftxtfYcoord.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtfYcoord.fill = GridBagConstraints.BOTH;
			gbc_ftxtfYcoord.gridx = 3;
			gbc_ftxtfYcoord.gridy = 3;
			contentPanel.add(ftxtfYcoord, gbc_ftxtfYcoord);
		}
		{
			JLabel lblColor = new JLabel("Color");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 1;
			gbc_lblColor.gridy = 4;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		
		
		
		{
			JButton btnChooseColor = new JButton("Choose");
			btnChooseColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorChange = true;
					color = JColorChooser.showDialog(null,"Select a color", initialColor);    
				}

			});
			GridBagConstraints gbc_btnChooseColor = new GridBagConstraints();
			gbc_btnChooseColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnChooseColor.gridx = 3;
			gbc_btnChooseColor.gridy = 4;
			contentPanel.add(btnChooseColor, gbc_btnChooseColor);
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
							!ftxtfYcoord.getText().isEmpty()) {
							flag = true;
							dispose();
						}else {
							flag = false;
							JOptionPane.showMessageDialog(null, "All fields are required!");
							setVisible(true);
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getInitialColor() {
		return initialColor;
	}

	public void setInitialColor(Color initialColor) {
		this.initialColor = initialColor;
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

}
