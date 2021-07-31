package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;

public class Etudiant extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Etudiant frame = new Etudiant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JTextField matricule_etu;
	private JScrollPane scrollPane;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public Etudiant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSelect = new JButton("select");
		btnSelect.setBackground(new Color(255, 102, 51));
		btnSelect.setForeground(new Color(255, 255, 255));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:Etudiant/TPEtudiant@localhost");	
				
						String query="select * from bddadmin.etudiant where matricule_etu=?";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1,matricule_etu.getText());
						ResultSet rs=ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch (Exception e1) {
						e1.printStackTrace();
					}
			
		}});
		btnSelect.setBounds(195, 162, 89, 23);
		contentPane.add(btnSelect);
		
		matricule_etu = new JTextField();
		matricule_etu.setBounds(134, 92, 210, 28);
		contentPane.add(matricule_etu);
		matricule_etu.setColumns(10);
		
		JLabel lblMatriculeetu = new JLabel("matricule_etu");
		lblMatriculeetu.setForeground(new Color(255, 255, 255));
		lblMatriculeetu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatriculeetu.setBounds(35, 99, 89, 14);
		contentPane.add(lblMatriculeetu);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 247, 333, 124);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:Etudiant/TPEtudiant@localhost");	
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}
