package Boundary;
import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.Panel;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

public class AssegnazioneFornitura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField UField;
	private JTextField PField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AssegnazioneFornitura dialog = new AssegnazioneFornitura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	String u = new String();
	String p = new String();
	String cf = new String();
	String nome = new String();
	String cognome = new String();
	String via = new String();
	String ncivico = new String();
	String nint = new String();
	String citta = new String();
	String cap = new String();
	String tipo = new String();
	String unita = new String();
 	
	int i = 0;
	int j = 0;
	int d = 0;
	
	private JTextField CfField;
	private JTextField NomeField;
	private JTextField CognomeField;
	private JTextField ViaField;
	private JTextField NcivicoField;
	private JTextField NintField;
	private JTextField Citt‡Field;
	private JTextField CapField;
	private JTextField texttipo;
	
	public AssegnazioneFornitura() {
		
		JButton CfButton = new JButton("Check");
		CfButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		JButton CheckIButton = new JButton("Check");
		CheckIButton.setEnabled(false);
		
		JButton NcButton = new JButton("Check");
		NcButton.setEnabled(false);
		
		JButton InserisciBtn = new JButton("Check");
		
		InserisciBtn.setEnabled(false);
		InserisciBtn.setBounds(746, 443, 89, 23);
		contentPanel.add(InserisciBtn);
				
		setBounds(100, 100, 1066, 581);
		getContentPane().setLayout(new CardLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "name_117994512735000");
		contentPanel.setLayout(null);
		
		JLabel ULbl = new JLabel("Username");
		ULbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ULbl.setBounds(10, 11, 135, 47);
		contentPanel.add(ULbl);
		
		JLabel CfLbl = new JLabel("Codice Fiscale");
		CfLbl.setEnabled(false);
		CfLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CfLbl.setBounds(10, 152, 96, 47);
		contentPanel.add(CfLbl);
		
		JLabel CognomeLbl = new JLabel("Cognome");
		CognomeLbl.setEnabled(false);
		CognomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CognomeLbl.setBounds(10, 244, 135, 47);
		contentPanel.add(CognomeLbl);
		
		JLabel NomeLbl = new JLabel("Nome");
		NomeLbl.setEnabled(false);
		NomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NomeLbl.setBounds(10, 198, 135, 47);
		contentPanel.add(NomeLbl);
		
		UField = new JTextField();
		UField.setBounds(118, 26, 86, 20);
		contentPanel.add(UField);
		UField.setColumns(10);
		
		JLabel PLbl = new JLabel("Password");
		PLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PLbl.setBounds(272, 11, 135, 47);
		contentPanel.add(PLbl);
		
		PField = new JTextField();
		
		PField.setColumns(10);
		PField.setBounds(440, 26, 86, 20);
		contentPanel.add(PField);
		
		JButton PButton = new JButton("Check");
		
		
		JLabel lblerrori = new JLabel("");
		lblerrori.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblerrori.setHorizontalAlignment(SwingConstants.CENTER);
		lblerrori.setEnabled(false);
		lblerrori.setBounds(22, 102, 659, 34);
		contentPanel.add(lblerrori);
		
		JLabel lblerrorevia = new JLabel("");
		lblerrorevia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblerrorevia.setBounds(684, 175, 358, 13);
		contentPanel.add(lblerrorevia);
		
		JLabel lblerrorecivico = new JLabel("");
		lblerrorecivico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblerrorecivico.setBounds(682, 221, 360, 13);
		contentPanel.add(lblerrorecivico);
		
		JLabel lblerroreinterno = new JLabel("");
		lblerroreinterno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblerroreinterno.setBounds(684, 262, 360, 13);
		contentPanel.add(lblerroreinterno);
		
		JLabel lblerrorecitta = new JLabel("");
		lblerrorecitta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblerrorecitta.setBounds(684, 311, 358, 13);
		contentPanel.add(lblerrorecitta);
		
		JLabel lblerrorecap = new JLabel("");
		lblerrorecap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblerrorecap.setBounds(684, 348, 358, 13);
		contentPanel.add(lblerrorecap);

		JLabel lblerroritipo = new JLabel("");
		lblerroritipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblerroritipo.setBounds(684, 487, 270, 13);
		contentPanel.add(lblerroritipo);
			
		JLabel lblfinale = new JLabel("");
		lblfinale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblfinale.setBounds(61, 510, 666, 13);
		contentPanel.add(lblfinale);
		
		PButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				u = UField.getText();
				p = PField.getText();
				i = Controller.Checkup(u,p);
				
				if (i == 1) {
					lblerrori.setText("Username e/o Password non corretti.");
				}
				
				if (i==0) {
					lblerrori.setText(" ");
					UField.setEditable(false);
					PField.setEditable(false);
					PButton.setEnabled(false);
					CfField.setEditable(true);
					CfLbl.setEnabled(true);
					CfButton.setEnabled(true);
					
					CfButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cf = CfField.getText();
							j=0;
							j = Controller.CheckCf_Af(cf);
							ArrayList<String> info = new ArrayList<String>();
							
							
							if(j == 0) {
								d = 1;
								lblerrori.setText("Utente gi‡ registrato i campi sottostanti verrano riempiti automaticamente.");
								info = Controller.scaricaCliente(cf);
								CfField.setEditable(false);
								NomeField.setEditable(false);
								CognomeField.setEditable(false);
								j = 1;
								NomeField.setText(info.get(0)); 
								CognomeField.setText(info.get(1));
							}								
								
							if(j == -2) {
								lblerrori.setText("Il codice fiscale da lei inserito non ha il corretto numero di caratteri,reinserirlo prego.");
							}	
							if(j == 1) {
								if (d == 0) {
								lblerrori.setText(" ");
								}
								
								CfField.setEditable(false);
								NomeField.setEditable(true);
								CognomeField.setEditable(true);
								CfButton.setEnabled(false);
								NcButton.setEnabled(true);
				
								
								NcButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										nome = NomeField.getText();
										cognome = CognomeField.getText();
										
										int c = Controller.CheckN(nome);
										 c = c + Controller.CheckC(cognome);
										
										if (c == 1 ) {
											lblerrori.setText("Nome inserito  non valido.");
										}
										if (c == 2 ) {
										lblerrori.setText("Cognome inserito  non valido.");
								     	}
										if (c == 3) {
										lblerrori.setText("Dati inseriti non validi");
										}
										if ( c == 0) {
										
										NcButton.setEnabled(false);
										lblerrori.setText(" ");
										ViaField.setEditable(true);
										NcivicoField.setEditable(true);
										NintField.setEditable(true);
										Citt‡Field.setEditable(true);
										CapField.setEditable(true);
																				
										CheckIButton.setEnabled(true);
										
										CheckIButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												
												lblerrorevia.setText(" ");
												lblerrorecivico.setText(" ");
												lblerroreinterno.setText(" ");
												lblerrorecitta.setText(" ");
												lblerrorecap.setText(" ");
												
												via = ViaField.getText();
												ncivico = NcivicoField.getText();
												nint = NintField.getText();
												citta = Citt‡Field.getText();
												cap = CapField.getText();
												
												int i = Controller.CheckVia(via);
												int j = Controller.CheckCivico(ncivico);
												int k = Controller.CheckInterno(nint);
												int q = Controller.CheckCitta2(citta);
												int w = Controller.CheckCap(cap);
												
												if(i == 1) {
													lblerrorevia.setText("La via da lei inserita non rispetta il formato richiesto, lo reinserisca");
												}
												if(j == 1) {
													lblerrorecivico.setText("Il civico da lei inserito non rispetta il formato richiesto, lo reinserisca");
												}
												if(k == 1) {
													lblerroreinterno.setText("L'interno non rispetta il formato richiesto, lo reinserisca");
												}
												if(q == 1) {
													lblerrorecitta.setText("La citt‡ da lei inserita non rispetta il formato richiesto, lo reinserisca");
												}
												if(w == 1) {
													lblerrorecap.setText("Il CAP deve essere formato da 5 numeri, lo reinserisca");
												}
												if(i == 0 && j == 0 && k == 0 && q == 0 && w == 0) {
													
													lblerrorevia.setText(" ");
													lblerrorecivico.setText(" ");
													lblerroreinterno.setText(" ");
													lblerrorecitta.setText(" ");
													lblerrorecap.setText(" ");
											
													texttipo.setEditable(true);
													CheckIButton.setEnabled(false);
													InserisciBtn.setEnabled(true);
													
													InserisciBtn.addMouseListener(new MouseAdapter() {
														@Override
														public void mouseClicked(MouseEvent e) {
															String tip = texttipo.getText();
															ArrayList<String> ar = Controller.CheckTipo(tip); 
															String i = ar.get(0);
															int w = Integer.parseInt(i);
															tipo = ar.get(1);
															unita = ar.get(2);
															if(w == 1) {
																lblerroritipo.setText("CiÚ che ha inserito non rispetta il formato richiesto");
															}
															if(w == 0) {
																texttipo.setEditable(false);
																Controller.InserisciCliente(nome, cognome, cf);
																int id = Controller.InserisciFornitura(via,ncivico,nint,citta,cap,tipo,unita,cf);
																lblfinale.setText("Dati registrati e fornitura creata. La fornitura creata ha questo identificativo:  "+id);
																InserisciBtn.setEnabled(false);
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
		
		PButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			}
		});
		PButton.setBounds(264, 69, 86, 23);
		contentPanel.add(PButton);
		

		
		CfField = new JTextField();
		CfField.setEditable(false);
		CfField.setColumns(10);
		CfField.setBounds(118, 168, 135, 20);
		contentPanel.add(CfField);
		
		NomeField = new JTextField();
		NomeField.setEditable(false);
		NomeField.setColumns(10);
		NomeField.setBounds(118, 214, 135, 20);
		contentPanel.add(NomeField);
		
		CognomeField = new JTextField();
		CognomeField.setEditable(false);
		CognomeField.setColumns(10);
		CognomeField.setBounds(118, 255, 136, 20);
		contentPanel.add(CognomeField);
		
		CfButton.setEnabled(false);
		CfButton.setBounds(264, 166, 86, 23);
		contentPanel.add(CfButton);
		
		ViaField = new JTextField();
		ViaField.setEditable(false);
		ViaField.setColumns(10);
		ViaField.setBounds(569, 168, 105, 20);
		contentPanel.add(ViaField);
		
		NcivicoField = new JTextField();
		NcivicoField.setEditable(false);
		NcivicoField.setColumns(10);
		NcivicoField.setBounds(569, 214, 105, 20);
		contentPanel.add(NcivicoField);
		
		NintField = new JTextField();
		NintField.setEditable(false);
		NintField.setColumns(10);
		NintField.setBounds(569, 260, 105, 20);
		contentPanel.add(NintField);
		
		Citt‡Field = new JTextField();
		Citt‡Field.setEditable(false);
		Citt‡Field.setColumns(10);
		Citt‡Field.setBounds(569, 304, 105, 20);
		contentPanel.add(Citt‡Field);
		
		CapField = new JTextField();
		CapField.setEditable(false);
		CapField.setColumns(10);
		CapField.setBounds(569, 346, 105, 20);
		contentPanel.add(CapField);
		
		JLabel LblVia = new JLabel("Via");
		LblVia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LblVia.setEnabled(false);
		LblVia.setBounds(391, 152, 135, 47);
		contentPanel.add(LblVia);
		
		JLabel NumeroCivicoLbl = new JLabel("Numero Civico");
		NumeroCivicoLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NumeroCivicoLbl.setEnabled(false);
		NumeroCivicoLbl.setBounds(391, 198, 135, 47);
		contentPanel.add(NumeroCivicoLbl);
		
		JLabel NumeroInternoLbl = new JLabel("Numero Interno");
		NumeroInternoLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NumeroInternoLbl.setEnabled(false);
		NumeroInternoLbl.setBounds(391, 244, 135, 47);
		contentPanel.add(NumeroInternoLbl);
		
		JLabel Citt‡Lbl = new JLabel("Citt\u00E0");
		Citt‡Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Citt‡Lbl.setEnabled(false);
		Citt‡Lbl.setBounds(391, 288, 135, 47);
		contentPanel.add(Citt‡Lbl);
		
		JLabel CapLbl = new JLabel("Cap");
		CapLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CapLbl.setEnabled(false);
		CapLbl.setBounds(391, 330, 135, 47);
		contentPanel.add(CapLbl);
		
		
		CheckIButton.setBounds(746, 371, 89, 23);
		contentPanel.add(CheckIButton);
	
		NcButton.setBounds(264, 258, 86, 23);
		contentPanel.add(NcButton);	
		
		JLabel lblNewLabel = new JLabel("Inserire il tipo della fornitura desiderata");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 381, 288, 13);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Deve premere 1 se il cliente desidera avere una fornitura di ENERGIA ELETTRICA.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 407, 541, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Premere 2 se il cliente desidera avere una fornitura di GAS.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 425, 397, 13);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Premere 3 se il cliente desidera avere una fornitura di ACQUA.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 446, 421, 13);
		contentPanel.add(lblNewLabel_3);
		
		texttipo = new JTextField();
		texttipo.setEditable(false);
		texttipo.setBounds(559, 445, 115, 19);
		contentPanel.add(texttipo);
		texttipo.setColumns(10);

		
}
}
