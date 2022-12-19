package readerwriterproblemsolution;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WriterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField namet;
	private JTextField quantityt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WriterFrame frame = new WriterFrame();
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
	public WriterFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(25, 34, 127, 33);
		contentPane.add(lblNewLabel);

		namet = new JTextField();
		namet.setFont(new Font("Tahoma", Font.BOLD, 14));
		namet.setBounds(174, 40, 198, 20);
		contentPane.add(namet);
		namet.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuantity.setBounds(25, 102, 127, 33);
		contentPane.add(lblQuantity);

		quantityt = new JTextField();
		quantityt.setFont(new Font("Tahoma", Font.BOLD, 14));
		quantityt.setColumns(10);
		quantityt.setBounds(174, 108, 198, 20);
		contentPane.add(quantityt);

		JButton add = new JButton("Add");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String name = namet.getText();
					int q = Integer.parseInt(quantityt.getText());
					addItem(name, q);
					JOptionPane.showMessageDialog(null, "Added Success.");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		add.setFont(new Font("Tahoma", Font.BOLD, 18));
		add.setForeground(Color.RED);
		add.setBounds(142, 204, 140, 33);
		contentPane.add(add);

		JButton inc = new JButton("Increment");
		inc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String name = namet.getText();
					int q = Integer.parseInt(quantityt.getText());
					addItem(name, q);
					JOptionPane.showMessageDialog(null, "Quantity Incremented Success.");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		inc.setFont(new Font("Tahoma", Font.BOLD, 18));
		inc.setForeground(Color.RED);
		inc.setBounds(142, 265, 140, 33);
		contentPane.add(inc);

		JButton dec = new JButton("Decrement");
		dec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String name = namet.getText();
					int q = Integer.parseInt(quantityt.getText());
					if (decreamentItem(name, q))
						JOptionPane.showMessageDialog(null, "Decremented Success.");
					else
						JOptionPane.showMessageDialog(null, "False In Quanity");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		dec.setForeground(Color.RED);
		dec.setFont(new Font("Tahoma", Font.BOLD, 18));
		dec.setBounds(142, 325, 140, 33);
		contentPane.add(dec);

		JButton delete = new JButton("Delete");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String name = namet.getText();
					if (deleteItem(name))
						JOptionPane.showMessageDialog(null, "Deleted Success.");
					else
						JOptionPane.showMessageDialog(null, "There Are No Item With Name " + name);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		delete.setForeground(Color.RED);
		delete.setFont(new Font("Tahoma", Font.BOLD, 18));
		delete.setBounds(142, 386, 140, 33);
		contentPane.add(delete);

		JButton btnNewButton = new JButton("Back");
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
		btnNewButton.setBounds(25, 11, 89, 23);
		contentPane.add(btnNewButton);
	}

	// read
	public ArrayList<Product> getItems() throws IOException {
		Path path = Paths.get("H:\\Java Developer\\help\\test.txt").toAbsolutePath();
		ArrayList<String> Reader = (ArrayList<String>) Files.lines(path).collect(Collectors.toList());
		ArrayList<Product> products = new ArrayList<>();
		String[] split;
		for (String str : Reader) {
			split = str.split(" ");
			products.add(new Product(split[0], Integer.parseInt(split[1])));
		}
		return products;
	}

	// write
	public void addItem(String str, int q) throws IOException {
		ArrayList<Product> rem = getItems();
		boolean ok = false;
		for (int i = 0; i < rem.size(); i++) {
			if (str.equals(rem.get(i).getName())) {
				rem.get(i).setCounter(rem.get(i).getCounter() + q);
				ok = true;
				break;
			}
		}
		if (ok == false) {
			rem.add(new Product(str, q));
		}
		delete_Create_Add(rem);
	}

	public boolean deleteItem(String str) throws IOException {
		ArrayList<Product> rem = getItems();
		for (int i = 0; i < rem.size(); i++) {
			if (str.equals(rem.get(i).getName())) {
				rem.remove(i);
				delete_Create_Add(rem);
				return true;
			}
		}
		return false;
	}

	boolean decreamentItem(String str, int q) throws IOException {
		ArrayList<Product> rem = getItems();
		boolean ok = findItem(str);
		if (ok) {
			int index = -1;
			for (int i = 0; i < rem.size(); i++) {
				if (str.equals(rem.get(i).getName())) {
					index = i;
				}
			}
			if (rem.get(index).getCounter() < q) {
				return false;
			} else {
				rem.get(index).setCounter(rem.get(index).getCounter() - q);
				delete_Create_Add(rem);
				return true;
			}
		}
		return false;
	}

	public boolean findItem(String str) throws IOException {
		ArrayList<Product> rem = getItems();
		for (int i = 0; i < rem.size(); i++) {
			if (str.equals(rem.get(i).getName())) {
				return true;
			}
		}
		return false;
	}

	public void delete_Create_Add(ArrayList<Product> rem) throws IOException {
		FileOutputStream writer = new FileOutputStream("H:\\Java Developer\\help\\test.txt");
		writer.write(("").getBytes());
		writer.close();
		PrintWriter w = new PrintWriter("H:\\Java Developer\\help\\test.txt");
		for (int i = 0; i < rem.size(); i++) {
			w.println(rem.get(i).getName() + " " + rem.get(i).getCounter());
		}
		w.close();
	}

}
