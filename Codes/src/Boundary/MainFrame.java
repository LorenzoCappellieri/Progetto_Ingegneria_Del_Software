package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new MainFrameCliente("Società di forniture energetiche LoViAn - Cliente").setVisible(true); 
			}
		});
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCliente.setBounds(58, 110, 129, 43);
		contentPane.add(btnCliente);
		
		JButton btnDirettoreCommerciale = new JButton("Direttore Commerciale");
		btnDirettoreCommerciale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDirettoreCommerciale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MainFrameDirettore("Società di forniture energetiche LoViAn - direttore commerciale").setVisible(true);
			}
		});
		btnDirettoreCommerciale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDirettoreCommerciale.setBounds(146, 233, 217, 43);
		contentPane.add(btnDirettoreCommerciale);
		
		JButton btnImpiegato = new JButton("Impiegato");
		btnImpiegato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImpiegato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MainFrameImpiegato("Società di forniture energetiche LoViAn - impiegato").setVisible(true);
			}
		});
		btnImpiegato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnImpiegato.setBounds(324, 110, 129, 43);
		contentPane.add(btnImpiegato);
		
		JLabel lblNewLabel = new JLabel("Premi per specificare il tuo ruolo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(132, 29, 263, 34);
		contentPane.add(lblNewLabel);
	}
}
