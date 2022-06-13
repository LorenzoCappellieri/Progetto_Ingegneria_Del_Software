package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Controller;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VisualizzaFattura extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaFattura frame = new VisualizzaFattura("Visualizza Fattura");
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
	
	String ID_Fornitura = new String();
	String user = new String();
	String cf = new String();
	String psw = new String();
	
	public VisualizzaFattura(String title) {
		
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(10, 31, 98, 20);
		contentPane.add(lblUsername);
		
		textUsername = new JTextField();
		textUsername.setBounds(137, 32, 118, 19);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(10, 74, 79, 20);
		contentPane.add(lblPassword);
		
		JLabel lblfornitura = new JLabel("ID Fornitura");
		lblfornitura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblfornitura.setBounds(10, 129, 98, 13);
		contentPane.add(lblfornitura);
		
		textPassword = new JTextField();
		textPassword.setBounds(137, 77, 118, 19);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		textid = new JTextField();
		textid.setEditable(false);
		textid.setBounds(137, 128, 118, 19);
		contentPane.add(textid);
		textid.setColumns(10);
		
		JLabel lblfatturagen = new JLabel("");
		lblfatturagen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfatturagen.setEnabled(false);
		lblfatturagen.setBounds(111, 268, 323, 20);
		contentPane.add(lblfatturagen);
		
		JLabel lbldati = new JLabel("");
		lbldati.setBounds(29, 311, 512, 13);
		contentPane.add(lbldati);
		
		JLabel lbldati2 = new JLabel("");
		lbldati2.setBounds(29, 334, 535, 13);
		contentPane.add(lbldati2);
		
		JLabel lblerrori = new JLabel("");
		lblerrori.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblerrori.setBounds(10, 232, 565, 13);
		contentPane.add(lblerrori);
		
		JButton btnCheckuser = new JButton("Verifica");
		btnCheckuser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		JButton btnCheck3 = new JButton("Verifica");
		btnCheck3.setEnabled(false);
		btnCheck3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		JButton btnvisualizza = new JButton("Visualizza Fattura");
		btnvisualizza.setEnabled(false);
		btnvisualizza.setFont(new Font("Tahoma", Font.PLAIN, 12));

		
		btnCheckuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> i = new ArrayList<String>();
				user = textUsername.getText();
				psw = textPassword.getText();
				
				i = Controller.CheckUPClienteReg(user, psw);
				
				String i2 = i.get(0);
				cf = i.get(1);
				
				int i3 = Integer.parseInt(i2);
				
				if(i3 == 1) {
					lblerrori.setText("Username e/o Password non corretti");
				}				
				
				if(i3 == 0) {
								lblerrori.setText("  ");
					
								textUsername.setEditable(false);
								textPassword.setEditable(false);
								btnCheckuser.setEnabled(false);											
						
								btnCheck3.setEnabled(true);
								textid.setEditable(true);
								
								
								btnCheck3.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
										int k = 0;
										
										ID_Fornitura = textid.getText();
										
										k = Controller.CheckFornitura(ID_Fornitura, cf);
										
										if( k == 1) {
											lblerrori.setText("L'id della fornitura non esiste!");
										}
										
										if( k == 2) {
											lblerrori.setText("L'id della fornitura inserita non corrisponde ad una fornitura di sua appartenenza");
										}
										    
										if( k == 0) {
											 
											lblerrori.setText(" ");
											btnvisualizza.setEnabled(true);
											textid.setEditable(false);
											btnCheck3.setEnabled(false);
											
											
											btnvisualizza.addMouseListener(new MouseAdapter() {
												@Override
												public void mouseClicked(MouseEvent e) {
													
													ArrayList<String> j = new ArrayList<String>();
													j = Controller.Genera_e_VisualizzaFattura(ID_Fornitura);
													
													String tipo = j.get(0);
													String costo = j.get(1);
													String unita = j.get(2);
													String consumo_mensile = j.get(3);
													
													lblfatturagen.setEnabled(true);	
													lblfatturagen.setText("Fattura Generata");
													
													lbldati.setText("La quota mensile che le spetta da pagare per la vostra fornitura di "+tipo+" è di: "+costo);
													lbldati2.setText("La cifra è stata calcolata su un consumo di "+consumo_mensile+" "+unita);
												}
											});
										}
									}
								});
							}
			    	}
		});
		
		
		
		
		btnCheckuser.setBounds(295, 76, 85, 21);
		contentPane.add(btnCheckuser);
		
		
		btnvisualizza.setBounds(162, 184, 146, 21);
		contentPane.add(btnvisualizza);
		

		btnCheck3.setBounds(295, 127, 85, 21);
		contentPane.add(btnCheck3);
		
		
	}
}
