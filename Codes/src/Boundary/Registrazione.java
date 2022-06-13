package Boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Controller;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrazione extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField cffield;
	private JTextField textUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registrazione dialog = new Registrazione();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	String cf = new String();
	String user = new String();
	String psw = new String();
	private JTextField textPassword;
	
	public Registrazione() {
		setBounds(100, 100, 653, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblcf = new JLabel("Codice Fiscale");
		lblcf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblcf.setBounds(10, 34, 100, 36);
		contentPanel.add(lblcf);
		
		cffield = new JTextField();
		cffield.setBounds(124, 45, 125, 19);
		contentPanel.add(cffield);
		cffield.setColumns(10);
		
		JLabel lblerrori = new JLabel("");
		lblerrori.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblerrori.setBounds(10, 181, 619, 36);
		contentPanel.add(lblerrori);
		
		JButton Checkuserbutton = new JButton("Verifica valdit\u00E0 Username");
		Checkuserbutton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Checkuserbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Checkuserbutton.setEnabled(false);
		JButton Checkcfbutton = new JButton("Verifica");
		Checkcfbutton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Checkcfbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButton Checkpswbutton = new JButton("Verifica validit\u00E0 Password");
		Checkpswbutton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Checkpswbutton.setEnabled(false);

		
		Checkcfbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
		
		int i = 0;

		
		cf = cffield.getText();
		
		i = Controller.CheckCf(cf);
		
		if(i == 1) {
			lblerrori.setText("Il codice fiscale da lei inserito non è presente nel database. "
					+ "Per registrarsi è necessario possedere una fornitura");
		}
		if(i == -1) {
			lblerrori.setText("Il codice fiscale inserito risulta gia è associato ad un utente registrato.");
		}
		if(i == -2) {
			lblerrori.setText("Il codice fiscale da lei inserito non ha il corretto numero di caratteri.");
		}
	
		if ( i == 0) {
			lblerrori.setText("  ");
			textUsername.setEditable(true);
			Checkuserbutton.setEnabled(true);
			cffield.setEditable(false);
			Checkcfbutton.setEnabled(false);
			
		
			Checkuserbutton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					user = textUsername.getText();
					
					int j = 0;
					j = Controller.CheckUsername(user);
					
				if (j == 1) {
					lblerrori.setText("Username troppo lungo.");
				}
				if (j == -1) {
					lblerrori.setText("L'Username è già presente, inserirne un altro.");
				}
				if (j == 0) {
					lblerrori.setText("  ");
					textUsername.setEditable(false);
					Checkuserbutton.setEnabled(false);
					textPassword.setEditable(true);
					Checkpswbutton.setEnabled(true);
					
					Checkpswbutton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
					
					psw = textPassword.getText();
					
					int k = 0;
					k = Controller.CheckPassword(psw);
					
					if(k == 1) {
						lblerrori.setText("La password deve essere di 8 caratteri!");
					}
					if(k == 0) {
						textPassword.setEditable(false);
						Checkpswbutton.setEnabled(false);
						lblerrori.setText(" ");
						Controller.Insert(cf,user,psw);
						lblerrori.setText("La registrazione è avvenuta con successo");
					}
				}
				});
				}
				}
			});
		}
}
	});

		Checkcfbutton.setBounds(259, 44, 85, 21);
		contentPanel.add(Checkcfbutton);
		
		Checkuserbutton.setBounds(259, 88, 171, 21);
		contentPanel.add(Checkuserbutton);
		
		Checkpswbutton.setBounds(259, 131, 171, 21);
		contentPanel.add(Checkpswbutton);
		
		textUsername = new JTextField();
		textUsername.setEditable(false);
		textUsername.setBounds(124, 89, 125, 19);
		contentPanel.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setEditable(false);
		textPassword.setBounds(124, 132, 125, 19);
		contentPanel.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 92, 85, 13);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 135, 85, 13);
		contentPanel.add(lblNewLabel_1);
		}
}

	