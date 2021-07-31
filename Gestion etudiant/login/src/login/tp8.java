package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class tp8 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tp8 frame = new tp8();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JTable table;
	private JTable table_1;
	/**
	 * Create the frame.
	 */
	public tp8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 0, 571, 377);
		contentPane.add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("qst3_tache1", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton btnAddView = new JButton("add view");
		btnAddView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Query="create view v_etudiant_list as select nom_etu ,prenom_etu from bddadmin.etudiant";
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
				
					JOptionPane.showMessageDialog(null,"inserted");
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
		btnAddView.setBackground(new Color(255, 102, 51));
		btnAddView.setBounds(224, 200, 89, 23);
		panel_4.add(btnAddView);
		
		JLabel lblViewVetudiantlist = new JLabel("creation vue v_etudiant_list");
		lblViewVetudiantlist.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewVetudiantlist.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblViewVetudiantlist.setForeground(Color.WHITE);
		lblViewVetudiantlist.setBounds(10, 11, 210, 14);
		panel_4.add(lblViewVetudiantlist);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("qst4_tache1", null, panel_5, null);
		panel_5.setLayout(null);
		
		JButton btnInsert = new JButton("insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Query="CREATE OR REPLACE  VIEW V_MOYENNE \r\n" + 
						"AS SELECT ETUDIANT. Matricule_ETU AS  mat,\r\n" + 
						"          nom_etu  ,  prenom_etu  ,libelle,\r\n" + 
						"		  UNITE.code_unite    AS  code,  (note_CC +note_TP  +  note_examen*2)/4  AS  moy         \r\n" + 
						"   FROM        ETUDIANT    ,  UNITE    , EtudiantUnite \r\n" + 
						"   WHERE ETUDIANT.Matricule_etu    =  EtudiantUnite . Matricule_etu     \r\n" + 
						"    AND  UNITE.code_unite  =  EtudiantUnite.code_unite";
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
				
					JOptionPane.showMessageDialog(null,"inserted");
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
			}
		});
		btnInsert.setBackground(new Color(255, 102, 51));
		btnInsert.setBounds(219, 164, 89, 23);
		panel_5.add(btnInsert);
		
		JLabel lblAffichageContenuDe = new JLabel("creation vue v_moyenne");
		lblAffichageContenuDe.setForeground(Color.WHITE);
		lblAffichageContenuDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAffichageContenuDe.setBounds(22, 25, 269, 14);
		panel_5.add(lblAffichageContenuDe);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("qst1_tache2", null, panel, null);
		panel.setLayout(null);
		
		JButton btnSelectAll = new JButton("select all");
		btnSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Query="select * from bddadmin.v_etudiant_list";
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
			
			}
		});
		btnSelectAll.setForeground(new Color(255, 255, 255));
		btnSelectAll.setBackground(new Color(255, 102, 51));
		btnSelectAll.setBounds(220, 88, 89, 23);
		panel.add(btnSelectAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 139, 409, 169);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblAffichageContenuDu = new JLabel("affichage contenu du v_etudiant_list");
		lblAffichageContenuDu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAffichageContenuDu.setForeground(Color.WHITE);
		lblAffichageContenuDu.setBounds(26, 11, 257, 28);
		panel.add(lblAffichageContenuDu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("qst2_tache2", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnSelectAll_1 = new JButton("select all");
		btnSelectAll_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Query="select * from bddadmin.v_moyenne";
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
		btnSelectAll_1.setForeground(new Color(255, 255, 255));
		btnSelectAll_1.setBackground(new Color(255, 102, 51));
		btnSelectAll_1.setBounds(209, 68, 89, 23);
		panel_1.add(btnSelectAll_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(65, 121, 448, 188);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblAffichegeContenuDu = new JLabel("affichege contenu du v_moyenne");
		lblAffichegeContenuDu.setForeground(Color.WHITE);
		lblAffichegeContenuDu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAffichegeContenuDu.setBounds(23, 11, 230, 14);
		panel_1.add(lblAffichegeContenuDu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("qs1_tache3", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Query="delete from bddadmin.v_etudiant_list";
				PreparedStatement pst;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:bddadmin/TPadmin@localhost");
					
					pst = con.prepareStatement(Query);
				
					JOptionPane.showMessageDialog(null,"deleted");
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
		btnDelete.setBackground(new Color(255, 102, 51));
		btnDelete.setBounds(224, 156, 89, 23);
		panel_2.add(btnDelete);
		
		JLabel lblSuuprimeleContenuDe = new JLabel("suupression du contenu de la vue v_etudiant_list");
		lblSuuprimeleContenuDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSuuprimeleContenuDe.setForeground(Color.WHITE);
		lblSuuprimeleContenuDe.setBounds(20, 11, 368, 14);
		panel_2.add(lblSuuprimeleContenuDe);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("qs2_tache3", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnDelete_1 = new JButton("delete");
		btnDelete_1.setBackground(new Color(255, 102, 51));
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Query="delete from bddadmin.v_moyenne";
				PreparedStatement pst;
				try {pst = con.prepareStatement(Query);
				
					JOptionPane.showMessageDialog(null,"deleted");
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
		btnDelete_1.setBounds(228, 180, 89, 23);
		panel_3.add(btnDelete_1);
		
		JLabel lblCreateViewVetudiantlist = new JLabel("supression du contenu de v_moyenne");
		lblCreateViewVetudiantlist.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreateViewVetudiantlist.setForeground(Color.WHITE);
		lblCreateViewVetudiantlist.setBounds(10, 11, 288, 23);
		panel_3.add(lblCreateViewVetudiantlist);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:bddadmin/TPadmin@localhost");
			
		}catch (Exception e) {
		
		e.printStackTrace();
		}			
		


		 
		
	}
}
