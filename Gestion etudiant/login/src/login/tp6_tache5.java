package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class tp6_tache5 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tp6_tache5 frame = new tp6_tache5();
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
	public tp6_tache5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 377);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 535, 339);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("qst 3", null, panel, null);
		panel.setLayout(null);
		
		JButton btnConsult = new JButton("consult");
		btnConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="select unite.code_unite,libelle\r\n" + 
						"from unite\r\n" + 
						"where unite.code_unite not IN ( select distinct etudiantunite.code_unite\r\n" + 
						"		from etudiantunite)";
				 PreparedStatement pst;
				 try {	
					 Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:bddadmin/TPadmin@localhost");
					pst = con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
			}
		});
		btnConsult.setBackground(new Color(255, 102, 51));
		btnConsult.setForeground(new Color(255, 255, 255));
		btnConsult.setBounds(218, 58, 89, 23);
		panel.add(btnConsult);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 113, 398, 146);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("qst 4", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnConsult_1 = new JButton("consult");
		btnConsult_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="select e.nom_etu,e.prenom_etu,u.libelle,(eu.note_cc+eu.note_tp+eu.note_examen)/3 moyenne\r\n" + 
						"from etudiant e\r\n" + 
						"JOIN etudiantunite eu\r\n" + 
						"on eu.matricule_etu = e.matricule_etu \r\n" + 
						"JOIN unite u\r\n" + 
						"on u.code_unite = eu.code_unite\r\n" + 
						"order by e.matricule_etu";
				 PreparedStatement pst;
				 try {	
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:bddadmin/TPadmin@localhost");
					pst = con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
			
			}
		});
		btnConsult_1.setBackground(new Color(255, 102, 51));
		btnConsult_1.setForeground(new Color(255, 255, 255));
		btnConsult_1.setBounds(218, 67, 89, 23);
		panel_1.add(btnConsult_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(63, 101, 420, 177);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}

}
