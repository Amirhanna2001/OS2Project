package readerwriterproblemsolution;

import java.awt.EventQueue;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField t1t;
	private int n;
	static int readerCount = 0;
	static Semaphore semaphore1 = new Semaphore(1);
	static Semaphore readSemaphore = new Semaphore(1);
	static Semaphore writeSemaphore = new Semaphore(1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws InterruptedException
	 */
	public Frame() throws InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Number Of  Threads:");
		lblNewLabel.setBounds(30, 32, 165, 20);
		contentPane.add(lblNewLabel);

		t1t = new JTextField();
		t1t.setBounds(209, 32, 215, 20);
		contentPane.add(t1t);
		t1t.setColumns(10);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				n = Integer.parseInt(t1t.getText());
				dispose();
				try {
					new Option().setVisible(true);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("done");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(128, 132, 148, 54);
		contentPane.add(btnNewButton);

	}

}
