package Boundary;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Control.Controller;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class InserimentoLettura extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textFornitura;
	private JTextField textLettura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InserimentoLettura frame = new InserimentoLettura("Inserimento Lettura");
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	String ID_Fornitura = new String();
	String user = new String();
	String cf = new String();
	String psw = new String();
	Double lettura = 0.00;
	
	public InserimentoLettura(String title) {
		
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(10, 21, 84, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(10, 71, 84, 20);
		contentPane.add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(126, 22, 119, 19);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(126, 72, 119, 19);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblFornitura = new JLabel("ID Fornitura");
		lblFornitura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFornitura.setBounds(10, 136, 84, 13);
		contentPane.add(lblFornitura);
		
		textFornitura = new JTextField();
		textFornitura.setEditable(false);
		textFornitura.setBounds(126, 133, 119, 19);
		contentPane.add(textFornitura);
		textFornitura.setColumns(10);
		
		JLabel lblLettura = new JLabel("Lettura");
		lblLettura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLettura.setBounds(10, 199, 64, 13);
		contentPane.add(lblLettura);
		
		textLettura = new JTextField();
		textLettura.setEditable(false);
		textLettura.setBounds(126, 196, 119, 19);
		contentPane.add(textLettura);
		textLettura.setColumns(10);
		
		JLabel lblerrori = new JLabel("");
		lblerrori.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblerrori.setBounds(10, 256, 567, 13);
		getContentPane().add(lblerrori);
		
		JButton btnCheckUser = new JButton("Verifica");
		btnCheckUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JButton btnCheckID = new JButton("Verifica");
		btnCheckID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JButton btnCheckLett = new JButton("Verifica");
		btnCheckLett.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		btnCheckUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> i = new ArrayList<String>();
				user = textUsername.getText();
				psw = textPassword.getText();
				
				i = Controller.CheckUPClienteReg(user,psw);
				
				String i2 = i.get(0);
				cf = i.get(1);
				lblerrori.setText(" "+cf);
				int i3 = Integer.parseInt(i2);
				
				if(i3 == 1) {
					lblerrori.setText("Username e/o Password non corretti");
				}
								
				if(i3 == 0) {
					
								lblerrori.setText(" ");
								btnCheckUser.setEnabled(false);
								textUsername.setEditable(false);
								textPassword.setEditable(false);
		
								btnCheckID.setEnabled(true);
								textFornitura.setEditable(true);		
								
								btnCheckID.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
										int k = 0;
										
										ID_Fornitura = textFornitura.getText();
										
										k = Controller.CheckFornitura(ID_Fornitura, cf);
										
										if( k == 1) {
											lblerrori.setText("L'id della fornitura non esiste!");
										}
										
										if( k == 2) {
											lblerrori.setText("L'id della fornitura inserita non corrisponde ad una fornitura di sua appartenenza");
											
										}
										
										if( k == 0) {
									
											lblerrori.setText(" ");
											btnCheckLett.setEnabled(true);
											textFornitura.setEditable(false);
											btnCheckID.setEnabled(false);
											textLettura.setEditable(true);
											
											btnCheckLett.addMouseListener(new MouseAdapter() {
												@Override
												public void mouseClicked(MouseEvent e) {
													int z = 0;
													Double lett = Double.parseDouble(textLettura.getText());
													z = Controller.CheckLettura(ID_Fornitura,lett);
													
													if (z == 1) {
														lblerrori.setText("La lettura inserita è minore dell'ultima lettura inserita");
													}
													
													if( z == 0) {
														lblerrori.setText("La lettura inserita è stata inserita correttamente.");
														textLettura.setEditable(false);
														btnCheckLett.setEnabled(false);
														
													}
												}
											});
											}
									}	
							});
					}
				}
			
			});
		btnCheckUser.setBounds(293, 72, 85, 21);
		contentPane.add(btnCheckUser);
		
		btnCheckID.setBounds(293, 134, 85, 21);
		contentPane.add(btnCheckID);
		
		
		btnCheckLett.setBounds(293, 197, 85, 21);
		contentPane.add(btnCheckLett);
		
			
	}
}
