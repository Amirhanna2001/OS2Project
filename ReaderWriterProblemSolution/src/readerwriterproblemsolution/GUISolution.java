package readerwriterproblemsolution;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUISolution extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JTextField text2;
	private Thread t1 = new Thread(), t2 = new Thread(), t3 = new Thread(), t4 = new Thread();
	private Read read = new Read();
	private Write write = new Write();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISolution frame = new GUISolution();
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
	public GUISolution() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("New label");
		label.setForeground(Color.RED);
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 11, 434, 90);
		contentPane.add(label);

		JButton write1 = new JButton("Write");
		write1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!t2.isAlive() && !t3.isAlive() && !t4.isAlive()) {
					t1 = new Thread(write);
					t1.start();
					label.setText(text1.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Not Allowed To Write Now");
				}

			}
		});
		write1.setBounds(43, 174, 89, 23);
		contentPane.add(write1);

		JButton write2 = new JButton("Write");
		write2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!t1.isAlive() && !t3.isAlive() && !t4.isAlive()) {
					t2 = new Thread(write);
					t2.start();
					label.setText(text2.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Not Allowed To Write Now");
				}
			}
		});
		write2.setBounds(292, 174, 89, 23);
		contentPane.add(write2);

		JButton read1 = new JButton("Read");
		read1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!t1.isAlive() && !t2.isAlive()) {
					t3 = new Thread(read);
					t3.start();
					label.setText("Reading Are Avilable Now!");
				} else {
					JOptionPane.showMessageDialog(null, "Not Allowed To Read Now!");
				}
			}
		});
		read1.setBounds(43, 247, 89, 23);
		contentPane.add(read1);

		JButton read2 = new JButton("Read");
		read2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!t1.isAlive() && !t2.isAlive()) {
					t4 = new Thread(read);
					t4.start();
					label.setText("Reading Are Avilable Now!");
				} else {
					JOptionPane.showMessageDialog(null, "Not Allowed To Read Now!");
				}
			}
		});
		read2.setBounds(292, 247, 89, 23);
		contentPane.add(read2);

		text1 = new JTextField();
		text1.setBounds(43, 143, 164, 20);
		contentPane.add(text1);
		text1.setColumns(10);

		text2 = new JTextField();
		text2.setColumns(10);
		text2.setBounds(217, 143, 164, 20);
		contentPane.add(text2);
	}

}
