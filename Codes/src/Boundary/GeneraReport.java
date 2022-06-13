package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Controller;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeneraReport extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textcitta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneraReport frame = new GeneraReport("Genera Report");
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
	
	String user = new String();
	String psw = new String();
	private JTextField texttipo;
	String citta = new String();
	
	public GeneraReport(String title) {
		
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbluser = new JLabel("Username");
		lbluser.setBounds(10, 34, 109, 13);
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lbluser);
		
		JLabel lblpsw = new JLabel("Password");
		lblpsw.setBounds(10, 74, 130, 13);
		lblpsw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblpsw);
		
		textUsername = new JTextField();
		textUsername.setBounds(111, 31, 141, 19);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(111, 71, 141, 19);
		textPassword.setText("");
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblcitta = new JLabel("Inserire la citt\u00E0 della quale ");
		lblcitta.setBounds(10, 119, 242, 34);
		lblcitta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblcitta);
		
		JLabel lblcitta2 = new JLabel("si vogliono avere le statistiche");
		lblcitta2.setBounds(10, 147, 242, 19);
		lblcitta2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblcitta2);
		
		textcitta = new JTextField();
		textcitta.setBounds(225, 134, 130, 19);
		textcitta.setEditable(false);
		contentPane.add(textcitta);
		textcitta.setColumns(10);
		
		JLabel lblerrori = new JLabel("");
		lblerrori.setBounds(10, 100, 692, 13);
		lblerrori.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblerrori);
		
		JButton btnCheckuser = new JButton("Verifica");
		btnCheckuser.setBounds(281, 72, 85, 21);
		btnCheckuser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(btnCheckuser);
		
		JButton btncitta = new JButton("Verifica");
		btncitta.setBounds(382, 128, 85, 21);
		btncitta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(btncitta);
		
		JLabel lblNewLabel = new JLabel("Inserire il tipo della fornitura di cui si richiedono i report");
		lblNewLabel.setBounds(10, 208, 437, 13);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Premere 1 se si desidera generare report su ENERGIA ELETTRICA.");
		lblNewLabel_1.setBounds(10, 231, 467, 13);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Premere 2 se si desidera generare report su ACQUA");
		lblNewLabel_2.setBounds(10, 254, 437, 13);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Premere 3 se si desidera generare report su GAS.");
		lblNewLabel_3.setBounds(10, 277, 437, 13);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblerroricit = new JLabel("");
		lblerroricit.setBounds(10, 185, 746, 13);
		lblerroricit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblerroricit);
		
		texttipo = new JTextField();
		texttipo.setBounds(490, 207, 96, 19);
		texttipo.setEditable(false);
		contentPane.add(texttipo);
		texttipo.setColumns(10);
		
		JButton btnNewButton = new JButton("Verifica");
		btnNewButton.setBounds(606, 206, 85, 21);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(btnNewButton);
		
		JLabel lblreport = new JLabel("");
		lblreport.setBounds(10, 332, 322, 13);
		lblreport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblreport);
		
		JLabel lblerrori2 = new JLabel("");
		lblerrori2.setBounds(10, 366, 986, 33);
		lblerrori2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblerrori2);
		
		
		
		btnCheckuser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 0;
				
				psw = textPassword.getText();
				user = textUsername.getText();
				
				i = Controller.CheckUPDirettore(user,psw);
				
				if(i == 1) {
					lblerrori.setText("Username e/o Password non corretti");
				}
	
				
				if(i == 0) {
								lblerrori.setText("  ");
				
								textPassword.setEditable(false);
								textUsername.setEditable(false);
								btnCheckuser.setEnabled(false);																												
								
								btncitta.setEnabled(true);
								textcitta.setEditable(true);
								btncitta.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
									
									citta = textcitta.getText();
									
									int i = 0;
									
									i = Controller.CheckCitta(citta);
									
									if( i == 1) {
										lblerroricit.setText("La città da lei inserita non è presente nel database.Inserirne una corretta.");
									}
									if( i == 0) {
										
										btncitta.setEnabled(false);
										textcitta.setEditable(false);
										lblerroricit.setText(" ");
										texttipo.setEditable(true);
										btnNewButton.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseClicked(MouseEvent e) {
												String tipo = new String();
												String x = new String();
												ArrayList<String> ar = new ArrayList<String>();
												tipo = texttipo.getText();
												ar = Controller.CheckTipo(tipo);
												
												x = ar.get(0);
												int w = Integer.parseInt(x);
												
												if( w == 1) {
													lblerrori2.setText("Ciò che ha inserito non rispetta il formato richiesto");
												}
												if( w == 0) {
													tipo = ar.get(1);
													String unita= ar.get(2);
													Double consumi = Controller.GeneraRep(citta, tipo, unita);
													lblreport.setText("Report Generato: ");
													lblerrori2.setText("I consumi medi mensili dell'ultimo anno per unità abitativa sono " +consumi+" "+unita+" per la città di "+citta+" per quanto riguarda la fornitura di "+tipo);
												}
												
											}
										});
									  }
									}
								});
							}
						}
		});
		contentPane.add(btnCheckuser);
		
		
}
}
