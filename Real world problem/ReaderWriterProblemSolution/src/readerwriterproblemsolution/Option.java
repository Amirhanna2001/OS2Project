package readerwriterproblemsolution;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.SwingConstants;

public class Option extends JFrame {

	private JPanel contentPane;
	private boolean reader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Option frame = new Option();
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
	public Option() throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println(start);
		reader = false;
		ReaderWriterProblemSolution r = new ReaderWriterProblemSolution();
		r.run();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Read");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long end = System.currentTimeMillis();
				long con = end - start;
				System.out.println(con);
				try {
					if (con <= 7000) {
						dispose();
						new ReaderFrame().setVisible(true);
					} else
						JOptionPane.showMessageDialog(null, "Reading Is Not Allowed Now");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(127, 91, 173, 76);
		contentPane.add(btnNewButton);

		JButton btnWrite = new JButton("Modify");
		btnWrite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long end = System.currentTimeMillis();
				long con = end - start;
				System.out.println(con);
				if (con >= 7000 ) {
					dispose();
					new WriterFrame().setVisible(true);
				} else
					JOptionPane.showMessageDialog(null, "Writing Is Not Allowed Now");
			}
		});
		btnWrite.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnWrite.setBounds(127, 180, 173, 76);
		contentPane.add(btnWrite);

		JLabel lblNewLabel = new JLabel("Choose Option");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 11, 414, 69);
		contentPane.add(lblNewLabel);

	}

}
