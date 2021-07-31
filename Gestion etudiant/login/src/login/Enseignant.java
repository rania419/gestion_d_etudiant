package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Enseignant extends JFrame {

	private JPanel contentPane;
	private JTextField matricule_ens;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enseignant frame = new Enseignant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JTextField matricul_ens;
	private JTextField nom_ens;
	private JTextField prenom_ens;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public Enseignant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 0, 603, 451);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("consult enseignant", null, panel, null);
		panel.setLayout(null);
		
		matricule_ens = new JTextField();
		matricule_ens.setBounds(193, 78, 201, 28);
		panel.add(matricule_ens);
		matricule_ens.setColumns(10);
		
		JLabel lblMatriculeens = new JLabel("matricule_ens");
		lblMatriculeens.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatriculeens.setForeground(new Color(255, 255, 255));
		lblMatriculeens.setBounds(71, 85, 98, 14);
		panel.add(lblMatriculeens);
		
		JButton btnSelect = new JButton("select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:Enseignant/TPEnseignant@localhost");	
				
						String query="select * from bddadmin.Enseignant where matricule_ens=?";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1,matricule_ens.getText());
						ResultSet rs=ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnSelect.setBackground(new Color(255, 102, 51));
		btnSelect.setForeground(new Color(255, 255, 255));
		btnSelect.setBounds(249, 150, 89, 23);
		panel.add(btnSelect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 229, 338, 132);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("insert enseignant", null, panel_1, null);
		panel_1.setLayout(null);
		
		matricul_ens = new JTextField();
		matricul_ens.setBounds(195, 79, 218, 34);
		panel_1.add(matricul_ens);
		matricul_ens.setColumns(10);
		
		nom_ens = new JTextField();
		nom_ens.setBounds(195, 147, 218, 34);
		panel_1.add(nom_ens);
		nom_ens.setColumns(10);
		
		prenom_ens = new JTextField();
		prenom_ens.setBounds(195, 220, 218, 34);
		panel_1.add(prenom_ens);
		prenom_ens.setColumns(10);
		
		JLabel lblMatriculeens_1 = new JLabel("matricule_ens");
		lblMatriculeens_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatriculeens_1.setForeground(new Color(255, 255, 255));
		lblMatriculeens_1.setBounds(62, 89, 91, 14);
		panel_1.add(lblMatriculeens_1);
		
		JLabel lblNomens = new JLabel("nom_ens");
		lblNomens.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomens.setForeground(new Color(255, 255, 255));
		lblNomens.setBounds(62, 157, 74, 14);
		panel_1.add(lblNomens);
		
		JLabel lblPrenomens = new JLabel("prenom_ens");
		lblPrenomens.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenomens.setForeground(new Color(255, 255, 255));
		lblPrenomens.setBounds(62, 230, 91, 14);
		panel_1.add(lblPrenomens);
		
		JButton btnInsert = new JButton("insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:Enseignant/TPEnseignant@localhost");	
				
						String query="insert into bddadmin.Enseignant values(?,?,?)";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1,matricul_ens.getText());
						ps.setString(2,nom_ens.getText());
						ps.setString(3,prenom_ens.getText());ps.execute();
						JOptionPane.showMessageDialog(null, "saved");
					}catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnInsert.setBackground(new Color(255, 102, 51));
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setBounds(260, 306, 89, 23);
		panel_1.add(btnInsert);
	}

}
