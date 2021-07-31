package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Component;
import java.awt.FlowLayout;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username_field;
	private JTextField password_field;
	protected ResultSet set;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 468);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBackground(new Color(102, 102, 102));
		lblUsername.setBounds(391, 113, 67, 14);
		lblUsername.setForeground(new Color(102, 102, 102));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(391, 195, 67, 14);
		lblPassword.setForeground(new Color(102, 102, 102));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblPassword);
		
		username_field = new JTextField();
		username_field.setBackground(SystemColor.text);
		username_field.setBounds(391, 138, 244, 29);
		contentPane.add(username_field);
		username_field.setColumns(10);
		
		password_field = new JTextField();
		password_field.setBounds(391, 220, 244, 29);
		contentPane.add(password_field);
		password_field.setColumns(10);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setBounds(466, 317, 111, 29);
		btnLogin.setBorder(new EmptyBorder(7, 7, 7, 7));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(255, 102, 51));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
					String  name=username_field.getText();
					String pass=password_field.getText();
					
					
					if(name.equals("bddadmin") && pass.equals("TPadmin")){
						try {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection con=DriverManager.getConnection("jdbc:oracle:thin:bddadmin/TPadmin@localhost");
						
						}catch (Exception e) {
						
							JOptionPane.showMessageDialog(null,"invalide user name or password");
						}
						JOptionPane.showMessageDialog(null,"login succesful");
						bddadmin p2=new bddadmin();
		 				p2.setVisible(true);
					}
					else {
						if(name.equals("Etudiant") && pass.equals("TPEtudiant")) {
							try {
								Class.forName("oracle.jdbc.driver.OracleDriver");
								Connection con=DriverManager.getConnection("jdbc:oracle:thin:Etudiant/TPEtudiant@localhost");
							
							}catch (Exception e) {
								JOptionPane.showMessageDialog(null,"invalide user name or password");
							
							}
							
							JOptionPane.showMessageDialog(null,"login succesful");
							Etudiant p2=new Etudiant();
			 				p2.setVisible(true);
							
						}
						else {
							if(name.equals("Enseignant") && pass.equals("TPEnseignant")) {
								try {
									Class.forName("oracle.jdbc.driver.OracleDriver");
									Connection con=DriverManager.getConnection("jdbc:oracle:thin:Enseignant/TPEnseignant@localhost");
								
								}catch (Exception e) {
									JOptionPane.showMessageDialog(null,"invalide user name or password");
								
								}
								
								JOptionPane.showMessageDialog(null,"login succesful");
								Enseignant p2=new Enseignant();
				 				p2.setVisible(true);
								
							}
						}
						
						
		 				
		 				
					}
				
				
			}
		});
		contentPane.add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		panel.setBounds(0, 0, 347, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("LOGIN PAGE");
		lblLoginPage.setBounds(102, 98, 108, 21);
		panel.add(lblLoginPage);
		lblLoginPage.setForeground(new Color(255, 255, 255));
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setBounds(102, 178, 108, 119);
		panel.add(lblLogin);
		lblLogin.setBackground(new Color(255, 255, 255));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setIcon(new ImageIcon("C:\\Users\\HPC\\Downloads\\ACAD\\projet\\login\\user (4).png"));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
	}
}
