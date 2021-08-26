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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField ftxtfCenterX;
	private JFormattedTextField ftxtfCenterY;
	private JFormattedTextField ftxtfRadius;
	private JFormattedTextField ftxtfInnerRadius;
	public boolean flag;
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
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setAllowsInvalid(false); 
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(800);
		
		setTitle("Donut");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{54, 124, 143, 40, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 25, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterX = new JLabel("Center X:");
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.gridx = 1;
			gbc_lblCenterX.gridy = 1;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			ftxtfCenterX = new JFormattedTextField(numberFormatter);
			GridBagConstraints gbc_ftxtfCenterX = new GridBagConstraints();
			gbc_ftxtfCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtfCenterX.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtfCenterX.gridx = 2;
			gbc_ftxtfCenterX.gridy = 1;
			contentPanel.add(ftxtfCenterX, gbc_ftxtfCenterX);
		}
		{
			JLabel lblCenterY = new JLabel("Center Y:");
			GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
			gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterY.gridx = 1;
			gbc_lblCenterY.gridy = 2;
			contentPanel.add(lblCenterY, gbc_lblCenterY);
		}
		{
			ftxtfCenterY = new JFormattedTextField(numberFormatter);
			GridBagConstraints gbc_ftxtfCenterY = new GridBagConstraints();
			gbc_ftxtfCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtfCenterY.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtfCenterY.gridx = 2;
			gbc_ftxtfCenterY.gridy = 2;
			contentPanel.add(ftxtfCenterY, gbc_ftxtfCenterY);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			ftxtfRadius = new JFormattedTextField(numberFormatter);
			GridBagConstraints gbc_ftxtfRadius = new GridBagConstraints();
			gbc_ftxtfRadius.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtfRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtfRadius.gridx = 2;
			gbc_ftxtfRadius.gridy = 3;
			contentPanel.add(ftxtfRadius, gbc_ftxtfRadius);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner radius:");
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 1;
			gbc_lblInnerRadius.gridy = 4;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			ftxtfInnerRadius = new JFormattedTextField(numberFormatter);
			GridBagConstraints gbc_ftxtfInnerRadius = new GridBagConstraints();
			gbc_ftxtfInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtfInnerRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtfInnerRadius.gridx = 2;
			gbc_ftxtfInnerRadius.gridy = 4;
			contentPanel.add(ftxtfInnerRadius, gbc_ftxtfInnerRadius);
		}
		{
			JLabel lblBorderColor = new JLabel("Border color");
			GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
			gbc_lblBorderColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblBorderColor.gridx = 1;
			gbc_lblBorderColor.gridy = 5;
			contentPanel.add(lblBorderColor, gbc_lblBorderColor);
		}
		{
			JButton btnBorderColor = new JButton("Choose");
			btnBorderColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borderColorChanged = true;
					borderColor = JColorChooser.showDialog(null,"Select border color",getInitialBorderColor());
				}
			});
			GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnBorderColor.gridx = 2;
			gbc_btnBorderColor.gridy = 5;
			contentPanel.add(btnBorderColor, gbc_btnBorderColor);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner color");
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerColor.gridx = 1;
			gbc_lblInnerColor.gridy = 6;
			contentPanel.add(lblInnerColor, gbc_lblInnerColor);
		}
		{
			JButton btnInnerColor = new JButton("Choose");
			btnInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					innerColorChanged = true;
					innerColor = JColorChooser.showDialog(null,"Select inner color",getInitialInnerColor());
				}
			});
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnInnerColor.gridx = 2;
			gbc_btnInnerColor.gridy = 6;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(ftxtfCenterX.getText().isEmpty() &&
								ftxtfCenterY.getText().isEmpty() &&
								ftxtfRadius.getText().isEmpty() &&
								ftxtfInnerRadius.getText().isEmpty()) {
							flag = false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "All fields are requried!");
							getToolkit().beep();
								
						}else if (Integer.parseInt(ftxtfRadius.getText()) <= Integer.parseInt(ftxtfInnerRadius.getText())) {
							flag = false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "Radius must be bigger than inner radius!");
							getToolkit().beep();
						}else {
							flag = true;
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						flag = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JFormattedTextField getFtxtfCenterX() {
		return ftxtfCenterX;
	}

	public void setFtxtfCenterX(JFormattedTextField ftxtfCenterX) {
		this.ftxtfCenterX = ftxtfCenterX;
	}

	public JFormattedTextField getFtxtfCenterY() {
		return ftxtfCenterY;
	}

	public void setFtxtfCenterY(JFormattedTextField ftxtfCenterY) {
		this.ftxtfCenterY = ftxtfCenterY;
	}

	public JFormattedTextField getFtxtfRadius() {
		return ftxtfRadius;
	}

	public void setFtxtfRadius(JFormattedTextField ftxtfRadius) {
		this.ftxtfRadius = ftxtfRadius;
	}

	public JFormattedTextField getFtxtfInnerRadius() {
		return ftxtfInnerRadius;
	}

	public void setFtxtfInnerRadius(JFormattedTextField ftxtfInnerRadius) {
		this.ftxtfInnerRadius = ftxtfInnerRadius;
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
