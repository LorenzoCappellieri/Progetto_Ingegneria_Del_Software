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

public class MainFrameDirettore extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameDirettore frame = new MainFrameDirettore("Società di forniture energetiche LoViAn - direttore commerciale");
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
	public MainFrameDirettore(String title) {
		
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGeneraReport = new JButton("Genera Report");
		btnGeneraReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GeneraReport("GeneraReport").setVisible(true);
			}
		});
		btnGeneraReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGeneraReport.setBounds(79, 116, 147, 83);
		contentPane.add(btnGeneraReport);
		
		JButton btnGeneraStatistiche = new JButton("Genera Statistiche");
		btnGeneraStatistiche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GeneraStatistiche("Genera Statistiche").setVisible(true);
			}
		});
		btnGeneraStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGeneraStatistiche.setBounds(340, 116, 165, 83);
		contentPane.add(btnGeneraStatistiche);
	}

}
