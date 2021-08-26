package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
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

public class DlgRectangleSS extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public boolean flag;
	private JFormattedTextField ftxtfXcoord;
	private JFormattedTextField ftxtfYcoord;
	private JFormattedTextField ftxtfWidht;
	private JFormattedTextField ftxtfHeight;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangleSS dialog = new DlgRectangleSS();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangleSS() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][grow][][grow]", "[][54.00][][][][][][]"));
		setModal(true);
		setResizable(false);
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setAllowsInvalid(false); 
		numberFormatter.setMinimum(1);
		
		
		{
			JLabel lblXcoord = new JLabel("Upper Left X coordinate:");
			lblXcoord.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(lblXcoord, "cell 0 2");
		}
		{
			
			ftxtfXcoord = new JFormattedTextField(numberFormatter);
			contentPanel.add(ftxtfXcoord, "cell 2 2,growx");
			
		}
		{
			JLabel lblYcoord = new JLabel("Upper Left Y coordinate:");
			lblYcoord.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(lblYcoord, "cell 0 3");
		}
		{
			ftxtfYcoord = new JFormattedTextField(numberFormatter);
			contentPanel.add(ftxtfYcoord, "cell 2 3,growx");
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			lblWidth.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(lblWidth, "cell 0 4");
		}
		{
			ftxtfWidht = new JFormattedTextField(numberFormatter);
			contentPanel.add(ftxtfWidht, "cell 2 4,growx");
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(lblHeight, "cell 0 5");
		}
		{
			ftxtfHeight = new JFormattedTextField(numberFormatter);
			contentPanel.add(ftxtfHeight, "cell 2 5,growx");
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

}
