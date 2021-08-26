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


public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public Color color;
	private JFormattedTextField ftxtfStartX;
	private JFormattedTextField ftxtfStartY;
	private JFormattedTextField ftxtfEndX;
	private JFormattedTextField ftxtfEndY;
	private Color initialColor;
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
	public DlgLine() {
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setAllowsInvalid(false); 
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(800);
		
		setTitle("Modify Line");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 27, 26, 0, 0, 29, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXcoordS = new JLabel("Start point X:");
			GridBagConstraints gbc_lblXcoordS = new GridBagConstraints();
			gbc_lblXcoordS.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcoordS.gridx = 1;
			gbc_lblXcoordS.gridy = 1;
			contentPanel.add(lblXcoordS, gbc_lblXcoordS);
		}
		{
			ftxtfStartX = new JFormattedTextField(numberFormatter);
			GridBagConstraints gbc_ftxtfStartX = new GridBagConstraints();
			gbc_ftxtfStartX.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtfStartX.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtfStartX.gridx = 3;
			gbc_ftxtfStartX.gridy = 1;
			contentPanel.add(ftxtfStartX, gbc_ftxtfStartX);
		}
		{
			JLabel lblYcoord = new JLabel("Start point Y:");
			GridBagConstraints gbc_lblYcoord = new GridBagConstraints();
			gbc_lblYcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcoord.gridx = 1;
			gbc_lblYcoord.gridy = 2;
			contentPanel.add(lblYcoord, gbc_lblYcoord);
		}
		{
			ftxtfStartY = new JFormattedTextField(numberFormatter);
			GridBagConstraints gbc_ftxtfStartY = new GridBagConstraints();
			gbc_ftxtfStartY.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtfStartY.fill = GridBagConstraints.BOTH;
			gbc_ftxtfStartY.gridx = 3;
			gbc_ftxtfStartY.gridy = 2;
			contentPanel.add(ftxtfStartY, gbc_ftxtfStartY);
		}
		{
			JLabel lblEndPointX = new JLabel("End point X:");
			GridBagConstraints gbc_lblEndPointX = new GridBagConstraints();
			gbc_lblEndPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointX.gridx = 1;
			gbc_lblEndPointX.gridy = 3;
			contentPanel.add(lblEndPointX, gbc_lblEndPointX);
		}
		{
			ftxtfEndX = new JFormattedTextField(numberFormatter);
			GridBagConstraints gbc_ftxtfEndX = new GridBagConstraints();
			gbc_ftxtfEndX.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtfEndX.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtfEndX.gridx = 3;
			gbc_ftxtfEndX.gridy = 3;
			contentPanel.add(ftxtfEndX, gbc_ftxtfEndX);
		}
		{
			JLabel lblEndPointY = new JLabel("End point Y");
			GridBagConstraints gbc_lblEndPointY = new GridBagConstraints();
			gbc_lblEndPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointY.gridx = 1;
			gbc_lblEndPointY.gridy = 4;
			contentPanel.add(lblEndPointY, gbc_lblEndPointY);
		}
		{
			ftxtfEndY = new JFormattedTextField(numberFormatter);
			GridBagConstraints gbc_ftxtfEndY = new GridBagConstraints();
			gbc_ftxtfEndY.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtfEndY.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtfEndY.gridx = 3;
			gbc_ftxtfEndY.gridy = 4;
			contentPanel.add(ftxtfEndY, gbc_ftxtfEndY);
		}
		{
			JLabel lblColor = new JLabel("Color");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 1;
			gbc_lblColor.gridy = 5;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			JButton btnChooseColor = new JButton("Choose");
			btnChooseColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorChange = true;
					Color initialcolor = Color.black;    
					color = JColorChooser.showDialog(null,"Select a color",initialcolor);
				}
			});
			GridBagConstraints gbc_btnChooseColor = new GridBagConstraints();
			gbc_btnChooseColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnChooseColor.gridx = 3;
			gbc_btnChooseColor.gridy = 5;
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
						if(!ftxtfStartX.getText().isEmpty() &&
							!ftxtfStartY.getText().isEmpty()) {
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

	public JFormattedTextField getFtxtfStartX() {
		return ftxtfStartX;
	}

	public void setFtxtfStartX(JFormattedTextField ftxtfStartX) {
		this.ftxtfStartX = ftxtfStartX;
	}

	public JFormattedTextField getFtxtfStartY() {
		return ftxtfStartY;
	}

	public void setFtxtfStartY(JFormattedTextField ftxtfStartY) {
		this.ftxtfStartY = ftxtfStartY;
	}

	public JFormattedTextField getFtxtfEndX() {
		return ftxtfEndX;
	}

	public void setFtxtfEndX(JFormattedTextField ftxtfEndX) {
		this.ftxtfEndX = ftxtfEndX;
	}

	public JFormattedTextField getFtxtfEndY() {
		return ftxtfEndY;
	}

	public void setFtxtfEndY(JFormattedTextField ftxtfEndY) {
		this.ftxtfEndY = ftxtfEndY;
	}

	public Color getInitialColor() {
		return initialColor;
	}

	public void setInitialColor(Color initialColor) {
		this.initialColor = initialColor;
	}

	

}

