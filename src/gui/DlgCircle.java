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

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField ftxtfRadius;
	private JFormattedTextField ftxtfCenterX;
	private JFormattedTextField ftxtfCenterY;
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
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setAllowsInvalid(false); 
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(800);
		
		setTitle("Circle");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{78, 49, 63, 63, 0};
		gbl_contentPanel.rowHeights = new int[]{44, 32, 27, 31, 30, 30, 30, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterX = new JLabel("Center X:");
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.anchor = GridBagConstraints.EAST;
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
			gbc_lblCenterY.anchor = GridBagConstraints.EAST;
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
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
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
			JLabel lblBorderColor = new JLabel("Border color");
			GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
			gbc_lblBorderColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblBorderColor.gridx = 1;
			gbc_lblBorderColor.gridy = 4;
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
			gbc_btnBorderColor.gridy = 4;
			contentPanel.add(btnBorderColor, gbc_btnBorderColor);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner color");
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerColor.gridx = 1;
			gbc_lblInnerColor.gridy = 5;
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
			gbc_btnInnerColor.gridy = 5;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!ftxtfCenterX.getText().isEmpty() &&
								!ftxtfCenterY.getText().isEmpty() && 
								!ftxtfRadius.getText().isEmpty()) {
							flag = true;
							dispose();
						}
						else {
							flag = false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "All fields must be filled!");
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

	public JFormattedTextField getFtxtfRadius() {
		return ftxtfRadius;
	}

	public void setFtxtfRadius(JFormattedTextField ftxtfRadius) {
		this.ftxtfRadius = ftxtfRadius;
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
