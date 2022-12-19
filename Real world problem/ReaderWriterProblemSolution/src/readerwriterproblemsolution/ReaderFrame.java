package readerwriterproblemsolution;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReaderFrame extends JFrame {
    static String PATH = "F:\\College\\LEVEL4\\OS2\\Project\\OS2Project\\Items.txt";

	private JPanel contentPane;
	private String[] header = { "Name ", "Quantity " };
	private String body[][];
	private ArrayList<Product> products = new ArrayList<>();
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderFrame frame = new ReaderFrame();
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
	 * @throws IOException
	 */
	public ReaderFrame() throws IOException {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 511, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 94, 424, 256);

		setTable();
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Products");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 33, 475, 50);
		contentPane.add(lblNewLabel);

		btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				try {
					new Option().setVisible(true);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);

	}

	// read
	public ArrayList<Product> getItems() {
		try {
			Path path = Paths.get(PATH).toAbsolutePath();
			ArrayList<String> Reader = (ArrayList<String>) Files.lines(path).collect(Collectors.toList());

			String[] split;
			for (String str : Reader) {
				split = str.split(" ");
				products.add(new Product(split[0], Integer.parseInt(split[1])));
			}
			return products;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private void setTable() {
		try {
			ArrayList<Product> ps = new ArrayList<>();
			ps = getItems();
			System.out.println(ps.size());
			int size = ps.size();
			body = new String[size][2];
			for (int i = 0; i < size; i++) {
				body[i][0] = ps.get(i).getName();
				body[i][1] = String.valueOf(ps.get(i).getCounter());
			}
			table = new JTable(body, header);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}