package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrameImpiegato extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameImpiegato frame = new MainFrameImpiegato("Società di forniture energetiche LoViAn - impiegato");
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
	public MainFrameImpiegato(String title) {
		
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAssegnazioneFornitura = new JButton("Assegnazione Fornitura");
		btnAssegnazioneFornitura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AssegnazioneFornitura().setVisible(true);
			}
		});
		btnAssegnazioneFornitura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAssegnazioneFornitura.setBounds(153, 134, 193, 85);
		contentPane.add(btnAssegnazioneFornitura);
	}

}
