package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.geom.Area;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDelete extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public boolean safetyCheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDelete dialog = new DlgDelete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDelete() {
		setModal(true);
		setTitle("Are you sure?");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCheck = new JLabel("This shape will be deleted permanently.");
			lblCheck.setVerticalAlignment(SwingConstants.BOTTOM);
			lblCheck.setFont(new Font("Tahoma", Font.BOLD, 18));
			GridBagConstraints gbc_lblCheck = new GridBagConstraints();
			gbc_lblCheck.insets = new Insets(0, 0, 5, 5);
			gbc_lblCheck.gridx = 2;
			gbc_lblCheck.gridy = 1;
			contentPanel.add(lblCheck, gbc_lblCheck);
		}
		{
			JLabel lblCheck2 = new JLabel("Are you sure you want to continue?");
			lblCheck2.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblCheck2.setVerticalAlignment(SwingConstants.TOP);
			GridBagConstraints gbc_lblCheck2 = new GridBagConstraints();
			gbc_lblCheck2.insets = new Insets(0, 0, 5, 5);
			gbc_lblCheck2.gridx = 2;
			gbc_lblCheck2.gridy = 2;
			contentPanel.add(lblCheck2, gbc_lblCheck2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDelete = new JButton("Delete");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						safetyCheck = true;
						dispose();
					}
				});
				btnDelete.setActionCommand("OK");
				buttonPane.add(btnDelete);
				getRootPane().setDefaultButton(btnDelete);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						safetyCheck = false;
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

}
