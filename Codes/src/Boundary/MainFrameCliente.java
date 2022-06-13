package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrameCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameCliente frame = new MainFrameCliente("Società di forniture energetiche LoViAn - Cliente");
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
	public MainFrameCliente(String title) {
		
		super(title);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrazione = new JButton("Registrazione");
		btnRegistrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Registrazione().setVisible(true);
			}
		});
		btnRegistrazione.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrazione.setBounds(194, 76, 156, 64);
		contentPane.add(btnRegistrazione);
		
		JButton btnInserimentoLettura = new JButton("Inserimento Lettura");
		btnInserimentoLettura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new InserimentoLettura("Inserimento Lettura").setVisible(true);
			}
		});
		btnInserimentoLettura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInserimentoLettura.setBounds(312, 205, 206, 64);
		contentPane.add(btnInserimentoLettura);
		
		JButton btnVisualizzaFattura = new JButton("Visualizza Fattura");
		btnVisualizzaFattura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new VisualizzaFattura("Visualizza Fattura").setVisible(true);
			}
		});
		btnVisualizzaFattura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVisualizzaFattura.setBounds(70, 205, 165, 64);
		contentPane.add(btnVisualizzaFattura);
		
		JLabel lblNewLabel = new JLabel("            Si prega di registrarsi ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(126, 11, 302, 26);
		contentPane.add(lblNewLabel);
	}

}
