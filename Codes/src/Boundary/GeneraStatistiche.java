package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Controller;

import javax.swing.JLabel;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GeneraStatistiche extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JLabel lblCitta;
	private JTextField textcitta;
	private JTextField textdata_Inizio;
	private JTextField texttipo;
	private JTextField textdata_fine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneraStatistiche frame = new GeneraStatistiche("Genera Statistiche");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String citta = new String();
	String user = new String();
	String psw = new String();
	String tipo = new String();
	LocalDate inizio;
	LocalDate fine;
	/**
	 * Create the frame.
	 */
	public GeneraStatistiche(String Title) {
		super(Title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbluser = new JLabel("Username");
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbluser.setBounds(26, 29, 82, 38);
		contentPane.add(lbluser);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsername.setBounds(149, 34, 163, 26);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblpsw = new JLabel("Password");
		lblpsw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpsw.setBounds(26, 78, 82, 26);
		contentPane.add(lblpsw);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPassword.setBounds(149, 77, 163, 26);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		lblCitta = new JLabel("Inserisci la citt\u00E0 per la quale vuoi generare le statistiche");
		lblCitta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCitta.setBounds(10, 128, 396, 38);
		contentPane.add(lblCitta);
		
		textcitta = new JTextField();
		textcitta.setEditable(false);
		textcitta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textcitta.setBounds(527, 137, 96, 20);
		contentPane.add(textcitta);
		textcitta.setColumns(10);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		JButton btncitta = new JButton("Verifica");
		btncitta.setBounds(633, 134, 89, 23);
		contentPane.add(btncitta);
		
		JLabel lbldataInizio = new JLabel("Inserisci la data d'inizio (yyyy-mm-dd) da quando vuoi sapere le\r\n analytics di questa citt\u00E0");
		lbldataInizio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbldataInizio.setBounds(10, 303, 530, 32);
		contentPane.add(lbldataInizio);
		
		textdata_Inizio = new JTextField();
		textdata_Inizio.setEditable(false);
		textdata_Inizio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textdata_Inizio.setBounds(527, 308, 96, 20);
		contentPane.add(textdata_Inizio);
		textdata_Inizio.setColumns(10);
		
		JButton btndata_inizio = new JButton("Verifica");
		
		btndata_inizio.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btndata_inizio.setBounds(633, 305, 89, 23);
		contentPane.add(btndata_inizio);
		
		JLabel lblNewLabel = new JLabel("Inserisci la data di fine (yyyy-mm-dd) da quando vuoi sapere le analytics di questa citt\u00E0.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 346, 530, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserire il tipo della fornitura di cui si richiedono i report");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 189, 461, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Premere 1 se si desidera generare report su ENERGIA ELETTRICA.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 214, 479, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Premere 2 se si desidera generare report su ACQUA.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 239, 461, 14);
		contentPane.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_4 = new JLabel(" Premere 3 se si desidera generare report su GAS.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 264, 461, 14);
		contentPane.add(lblNewLabel_4);
		
		texttipo = new JTextField();
		texttipo.setEditable(false);
		texttipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		texttipo.setBounds(527, 191, 96, 20);
		contentPane.add(texttipo);
		texttipo.setColumns(10);
		
		JButton btnNewButton = new JButton("Verifica");
		btnNewButton.setBounds(633, 190, 89, 23);
		contentPane.add(btnNewButton);
		
		textdata_fine = new JTextField();
		textdata_fine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textdata_fine.setEditable(false);
		textdata_fine.setBounds(527, 350, 96, 20);
		contentPane.add(textdata_fine);
		textdata_fine.setColumns(10);
		
		JButton btndata_fine = new JButton("Verifica");
		
		btndata_fine.setBounds(633, 349, 89, 23);
		contentPane.add(btndata_fine);
		
		JLabel lblerrori = new JLabel("");
		lblerrori.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblerrori.setBounds(26, 115, 501, 14);
		contentPane.add(lblerrori);
		
		JLabel lblerroricit = new JLabel("");
		lblerroricit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblerroricit.setBounds(10, 164, 530, 14);
		contentPane.add(lblerroricit);
		
		JLabel lblerrori2 = new JLabel("");
		lblerrori2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblerrori2.setBounds(10, 383, 712, 14);
		contentPane.add(lblerrori2);
		
		JLabel lblstats1 = new JLabel("");
		lblstats1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblstats1.setBounds(10, 406, 712, 14);
		contentPane.add(lblstats1);
		
		JLabel lblstats2 = new JLabel("");
		lblstats2.setBounds(10, 423, 712, 14);
		contentPane.add(lblstats2);
		
		JLabel lblstats3 = new JLabel("");
		lblstats3.setBounds(10, 448, 712, 14);
		contentPane.add(lblstats3);
		
		JButton btnCheckuser = new JButton("Verifica");
		btnCheckuser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 0;
				
				user = textUsername.getText();
				psw = textPassword.getText();
				
				i = Controller.CheckUPDirettore(user,psw);
				
				if(i == 1) {
					lblerrori.setText("Username e/o password non corretti");
				}
				
				if(i == 0) {
								lblerrori.setText("  ");
									
								textUsername.setEditable(false);
								textPassword.setEditable(false);
								
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
										btnNewButton.setEnabled(true);
										textcitta.setEditable(false);
										lblerroricit.setText(" ");
										texttipo.setEditable(true);
										btnNewButton.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseClicked(MouseEvent e) {
												
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
													textdata_Inizio.setEditable(true);
													texttipo.setEditable(false);
													lblerrori2.setText(" ");
													btnNewButton.setEnabled(false);
													
													btndata_inizio.addMouseListener(new MouseAdapter() {
														@Override
														public void mouseClicked(MouseEvent e) {
															
															String ini = textdata_Inizio.getText();
															int i = Controller.CheckDataIn(ini);
															//LocalDate inizio = LocalDate.parse(ini, formatter);
															
															if(i>0) {
																lblerrori2.setText("La data inserita non è valida");
															}
															if(i == 0) {
																
																btndata_inizio.setEnabled(false);
																textdata_Inizio.setEditable(false);
																lblerrori2.setText(" ");
																textdata_fine.setEditable(true);
																
																btndata_fine.addMouseListener(new MouseAdapter() {
																	@Override
																	public void mouseClicked(MouseEvent e) {
																		
																		String fin = textdata_fine.getText();
																		ArrayList<String> i = Controller.CheckDataFin(fin, ini);
																		//LocalDate inizio = LocalDate.parse(ini, formatter);
																		String f = i.get(0);
																		int w = Integer.parseInt(f);
																		if(w > 0) {
																			lblerrori2.setText("La data inserita non è valida");
																		}
																		if(w == 0) {
																			btndata_fine.setEnabled(false);
																			lblerrori2.setText("Analytics Generate: ");
																			 String iniz = i.get(1);
																			 String fine = i.get(2);
																			 ArrayList<Double> ar = Controller.GeneraStat(citta,tipo, iniz,fine);
																			 Double consumo_minimo = ar.get(0);
																			 Double consumo_massimo = ar.get(1);
																			 Double consumo_medio = ar.get(2);
																			 lblstats1.setText("Ecco il consumo minimo nel periodo "+iniz+"  -  "+fine+" : "+consumo_minimo+" "+unita);
																			 lblstats2.setText("Ecco il consumo massimo nel periodo "+iniz+"  -  "+fine+" : "+consumo_massimo+" "+unita);
																			 lblstats3.setText("Ecco il consumo medio nel periodo "+iniz+"  -  "+fine+" : "+consumo_medio+" "+unita);
																		}
																		
																	}
																});
															}
														}
													});
																																							
												}
												
											}
										});
									  }
									}
								});
							}
				}	
		});
		btnCheckuser.setBounds(348, 82, 89, 23);
		contentPane.add(btnCheckuser);
		
	}
}
