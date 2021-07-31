package login;
import java.sql.Date;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class bddadmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bddadmin frame = new bddadmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JTextField matriculetu;
	private JTextField nometu;
	private JTextField prenometu;
	private JTextField adress;
	private JTextField matriculens;
	private JTextField codunite;
	private JTextField nombre_heures;
	private JTextField libell;
	private JTextField matriculenss;
	private JTextField nomenss;
	private JTextField prenomenss;
	private JTextField matriculetuu;
	private JTextField codeunitee;
	private JTextField notecc;
	private JTextField notetp;
	private JTextField noteexamen;
	private JTable table;
	private JTable table_2;
	private JTable table_1;
	private JTable table_3;
	/**
	 * Create the frame.
	 */
	public bddadmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 0, 807, 461);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("consult etudiant", null, panel, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		panel.setLayout(null);
		
		JRadioButton matricule_etu = new JRadioButton("matricule_etu");
		matricule_etu.setBounds(53, 145, 109, 23);
		matricule_etu.setFont(new Font("Tahoma", Font.BOLD, 11));
		matricule_etu.setForeground(new Color(255, 255, 255));
		matricule_etu.setBackground(new Color(102, 102, 102));
		panel.add(matricule_etu);
		
		JRadioButton nom_etu = new JRadioButton("nom_etu");
		nom_etu.setBounds(188, 145, 89, 23);
		nom_etu.setFont(new Font("Tahoma", Font.BOLD, 11));
		nom_etu.setForeground(new Color(255, 255, 255));
		nom_etu.setBackground(new Color(102, 102, 102));
		panel.add(nom_etu);
		
		JRadioButton prenom_etu = new JRadioButton("prenom_etu");
		prenom_etu.setBounds(53, 197, 109, 23);
		prenom_etu.setFont(new Font("Tahoma", Font.BOLD, 11));
		prenom_etu.setForeground(new Color(255, 255, 255));
		prenom_etu.setBackground(new Color(102, 102, 102));
		panel.add(prenom_etu);
		
		JRadioButton date_naissance = new JRadioButton("date_naissance");
		date_naissance.setBounds(53, 248, 132, 23);
		date_naissance.setFont(new Font("Tahoma", Font.BOLD, 11));
		date_naissance.setForeground(new Color(255, 255, 255));
		date_naissance.setBackground(new Color(102, 102, 102));
		panel.add(date_naissance);
		
		JRadioButton address = new JRadioButton("address");
		address.setBounds(188, 197, 89, 23);
		address.setFont(new Font("Tahoma", Font.BOLD, 11));
		address.setForeground(new Color(255, 255, 255));
		address.setBackground(new Color(102, 102, 102));
		panel.add(address);
		
		JButton btnValid = new JButton("Valid");
		btnValid.setBounds(118, 321, 96, 31);
		btnValid.setForeground(new Color(255, 255, 255));
		btnValid.setBackground(new Color(255, 102, 51));
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(matricule_etu.isSelected()) {
					String Query="select matricule_etu from etudiant";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));

					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				
				}
			  else {
					if(nom_etu.isSelected()) {
					
						String Query="select nom_etu from etudiant";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					}
					else {
						if(prenom_etu.isSelected()) {
							String Query="select prenom_etu from etudiant";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}	
						}
						else {
							if(address.isSelected()) {
								String Query="select adresse from etudiant";
								PreparedStatement pst;
								try {
									pst = con.prepareStatement(Query);
									ResultSet rs=pst.executeQuery();
									table.setModel(DbUtils.resultSetToTableModel(rs));
								} catch (Exception e1) {
								
									e1.printStackTrace();
								}
							}
							else{
								if(date_naissance.isSelected()) {
								
									String Query="select date_naissance from etudiant";
									PreparedStatement pst;
									try {
										pst = con.prepareStatement(Query);
										ResultSet rs=pst.executeQuery();
										table.setModel(DbUtils.resultSetToTableModel(rs));
									} catch (Exception e1) {
									
										e1.printStackTrace();
									}
								}
								
								}
							
								
							}
						}
						
						}
				
					
					
				if(matricule_etu.isSelected() && nom_etu.isSelected()) {
					String Query="select matricule_etu , nom_etu from etudiant";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
				else {
					if(matricule_etu.isSelected() &&prenom_etu.isSelected()) {
						String Query="select matricule_etu , prenom_etu from etudiant";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					}
					else {
						if(matricule_etu.isSelected() && address.isSelected()) {
							String Query="select matricule_etu , adresse from etudiant";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						}
						else {
							if(matricule_etu.isSelected() && date_naissance.isSelected()) {
								String Query="select matricule_etu ,date_naissance from etudiant";
								PreparedStatement pst;
								try {
									pst = con.prepareStatement(Query);
									ResultSet rs=pst.executeQuery();
									table.setModel(DbUtils.resultSetToTableModel(rs));
								} catch (Exception e1) {
								
									e1.printStackTrace();
								}
							}
							else {
								if(prenom_etu.isSelected() && nom_etu.isSelected()) {
									String Query="select nom_etu ,prenom_etu from etudiant";
									PreparedStatement pst;
									try {
										pst = con.prepareStatement(Query);
										ResultSet rs=pst.executeQuery();
										table.setModel(DbUtils.resultSetToTableModel(rs));
									} catch (Exception e1) {
									
										e1.printStackTrace();
									}
								}
								else {
									if(date_naissance.isSelected() && nom_etu.isSelected()) {
										String Query="select nom_etu ,date_naissance from etudiant";
										PreparedStatement pst;
										try {
											pst = con.prepareStatement(Query);
											ResultSet rs=pst.executeQuery();
											table.setModel(DbUtils.resultSetToTableModel(rs));
										} catch (Exception e1) {
										
											e1.printStackTrace();
										}
									}
									else {
										if(address.isSelected() && nom_etu.isSelected()) {
											String Query="select nom_etu ,adresse from etudiant";
											PreparedStatement pst;
											try {
												pst = con.prepareStatement(Query);
												ResultSet rs=pst.executeQuery();
												table.setModel(DbUtils.resultSetToTableModel(rs));
											} catch (Exception e1) {
											
												e1.printStackTrace();
											}
										}
										else {
											if(prenom_etu.isSelected() && date_naissance.isSelected()) {
												String Query="select prenom_etu ,date_naissance from etudiant";
												PreparedStatement pst;
												try {
													pst = con.prepareStatement(Query);
													ResultSet rs=pst.executeQuery();
													table.setModel(DbUtils.resultSetToTableModel(rs));
												} catch (Exception e1) {
												
													e1.printStackTrace();
												}
											}
											else {
												if(prenom_etu.isSelected() && address.isSelected()) {
													String Query="select prenom_etu ,adresse from etudiant";
													PreparedStatement pst;
													try {
														pst = con.prepareStatement(Query);
														ResultSet rs=pst.executeQuery();
														table.setModel(DbUtils.resultSetToTableModel(rs));
													} catch (Exception e1) {
													
														e1.printStackTrace();
													}
												}
												else {
													if((date_naissance.isSelected() && address.isSelected())){
														String Query="select date_naissance ,adresse from etudiant";
														PreparedStatement pst;
														try {
															pst = con.prepareStatement(Query);
															ResultSet rs=pst.executeQuery();
															table.setModel(DbUtils.resultSetToTableModel(rs));
														} catch (Exception e1) {
														
															e1.printStackTrace();
														}
													}
													else {
														
													}
													
												}
												
											}
										}
									}
								}
							}
						}
					}
				}
				
				if(matricule_etu.isSelected() && nom_etu.isSelected()&& prenom_etu.isSelected()) {
					String Query="select matricule_etu ,nom_etu,prenom_etu from etudiant";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
				else {
					if(matricule_etu.isSelected() && nom_etu.isSelected()&& date_naissance.isSelected()) {
						String Query="select matricule_etu ,nom_etu,date_naissance from etudiant";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					}
					else {
						if(matricule_etu.isSelected() && nom_etu.isSelected()&& address.isSelected()) {
							String Query="select matricule_etu ,nom_etu,adresse from etudiant";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						}
						else {
							if(prenom_etu.isSelected() && nom_etu.isSelected() && date_naissance.isSelected()) {
								String Query="select nom_etu ,prenom_etu,date_naissance from etudiant";
								PreparedStatement pst;
								try {
									pst = con.prepareStatement(Query);
									ResultSet rs=pst.executeQuery();
									table.setModel(DbUtils.resultSetToTableModel(rs));
								} catch (Exception e1) {
								
									e1.printStackTrace();
								}
							}
							else {
								if(prenom_etu.isSelected() && nom_etu.isSelected() && address .isSelected()) {
									String Query="select nom_etu ,prenom_etu,adresse from etudiant";
									PreparedStatement pst;
									try {
										pst = con.prepareStatement(Query);
										ResultSet rs=pst.executeQuery();
										table.setModel(DbUtils.resultSetToTableModel(rs));
									} catch (Exception e1) {
									
										e1.printStackTrace();
									}
								}
								else {
									if(prenom_etu.isSelected() && date_naissance.isSelected() && address .isSelected()) {
										String Query="select date_naissance,prenom_etu,adresse from etudiant";
										PreparedStatement pst;
										try {
											pst = con.prepareStatement(Query);
											ResultSet rs=pst.executeQuery();
											table.setModel(DbUtils.resultSetToTableModel(rs));
										} catch (Exception e1) {
										
											e1.printStackTrace();
										}
									}
									else {
										if(matricule_etu.isSelected() && prenom_etu.isSelected() && address .isSelected()) {
											String Query="select matricule_etu,prenom_etu,adresse from etudiant";
											PreparedStatement pst;
											try {
												pst = con.prepareStatement(Query);
												ResultSet rs=pst.executeQuery();
												table.setModel(DbUtils.resultSetToTableModel(rs));
											} catch (Exception e1) {
											
												e1.printStackTrace();
											}
										}
										else {
											if(matricule_etu.isSelected() && prenom_etu.isSelected() && date_naissance .isSelected()) {
												String Query="select matricule_etu,prenom_etu,date_naissance from etudiant";
												PreparedStatement pst;
												try {
													pst = con.prepareStatement(Query);
													ResultSet rs=pst.executeQuery();
													table.setModel(DbUtils.resultSetToTableModel(rs));
												} catch (Exception e1) {
												
													e1.printStackTrace();
												}
											}
											else {
												if(matricule_etu.isSelected() && date_naissance.isSelected()&& address.isSelected()) {
													String Query="select matricule_etu ,date_naissance,adresse from etudiant";
													PreparedStatement pst;
													try {
														pst = con.prepareStatement(Query);
														ResultSet rs=pst.executeQuery();
														table.setModel(DbUtils.resultSetToTableModel(rs));
													} catch (Exception e1) {
													
														e1.printStackTrace();
													}
												}
												else {
													if(nom_etu.isSelected() && date_naissance.isSelected()&& address.isSelected()) {
														String Query="select matricule_etu ,date_naissance,adresse from etudiant";
														PreparedStatement pst;
														try {
															pst = con.prepareStatement(Query);
															ResultSet rs=pst.executeQuery();
															table.setModel(DbUtils.resultSetToTableModel(rs));
														} catch (Exception e1) {
														
															e1.printStackTrace();
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				
			if(matricule_etu.isSelected()&& nom_etu.isSelected() && nom_etu.isSelected()&& date_naissance.isSelected()) {
				String Query="select matricule_etu,nom_etu,prenom_etu,date_naissance from etudiant";
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
			}
			else {
				if(matricule_etu.isSelected()&& nom_etu.isSelected() && prenom_etu.isSelected()&& address.isSelected()) {
					String Query="select matricule_etu,nom_etu,prenom_etu,adresse from etudiant";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
				else {
					if(matricule_etu.isSelected()&& nom_etu.isSelected() && date_naissance.isSelected()&& address.isSelected()) {
						String Query="select matricule_etu,nom_etu,adresse,date_naissance from etudiant";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					}
					else {
						if(matricule_etu.isSelected()&& address.isSelected() && prenom_etu.isSelected()&& date_naissance.isSelected()) {
							String Query="select matricule_etu,prenom_etu,date_naissance,adresse from etudiant";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						}
						else {
							if( nom_etu.isSelected() && prenom_etu.isSelected()&& date_naissance.isSelected()&&address.isSelected()) {
								String Query="select nom_etu,prenom_etu,date_naissance,adresse from etudiant";
								PreparedStatement pst;
								try {
									pst = con.prepareStatement(Query);
									ResultSet rs=pst.executeQuery();
									table.setModel(DbUtils.resultSetToTableModel(rs));
								} catch (Exception e1) {
								
									e1.printStackTrace();
								}
							}
						}
					}
				}
				
			}
				
			if(  matricule_etu.isSelected() &&nom_etu.isSelected() && prenom_etu.isSelected()&& date_naissance.isSelected()&&address.isSelected()) {
				String Query="select * from etudiant";
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
			}
			}
			
		});
		panel.add(btnValid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(383, 145, 361, 167);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("consult unite", null, panel_1, null);
		panel_1.setLayout(null);
		
		JRadioButton code_unite = new JRadioButton("code_unite");
		code_unite.setFont(new Font("Tahoma", Font.BOLD, 11));
		code_unite.setBackground(new Color(102, 102, 102));
		code_unite.setForeground(new Color(255, 255, 255));
		code_unite.setBounds(57, 151, 109, 23);
		panel_1.add(code_unite);
		
		JRadioButton libelle = new JRadioButton("libelle");
		libelle.setFont(new Font("Tahoma", Font.BOLD, 11));
		libelle.setBackground(new Color(102, 102, 102));
		libelle.setForeground(new Color(255, 255, 255));
		libelle.setBounds(57, 226, 87, 23);
		panel_1.add(libelle);
		
		JRadioButton matricule_ens = new JRadioButton("matricule_ens");
		matricule_ens.setFont(new Font("Tahoma", Font.BOLD, 11));
		matricule_ens.setBackground(new Color(102, 102, 102));
		matricule_ens.setForeground(new Color(255, 255, 255));
		matricule_ens.setBounds(172, 151, 109, 23);
		panel_1.add(matricule_ens);
		
		JRadioButton nbr_heures = new JRadioButton("nbr_heures");
		nbr_heures.setFont(new Font("Tahoma", Font.BOLD, 11));
		nbr_heures.setBackground(new Color(102, 102, 102));
		nbr_heures.setForeground(new Color(255, 255, 255));
		nbr_heures.setBounds(172, 226, 109, 23);
		panel_1.add(nbr_heures);
		
		JButton btnValid_2 = new JButton("Valid");
		btnValid_2.setBackground(new Color(255, 102, 51));
		btnValid_2.setForeground(new Color(255, 255, 255));
		btnValid_2.setBounds(115, 305, 99, 32);
		btnValid_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(code_unite.isSelected()) {
					String Query="select code_unite from unite";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table_2.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				
				}
				else {
					if(libelle.isSelected()) {
						String Query="select libelle from unite";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table_2.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					
						}
					else {
						
						if(nbr_heures.isSelected()) {
							String Query="select nbr_heures from unite";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table_2.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						}
						
                    	else {
						
						if(matricule_ens.isSelected()) {
							String Query="select matricule_ens from unite";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table_2.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						}
						}
					
					}
					}
				if(code_unite.isSelected()&&libelle.isSelected()) {
					
						String Query="select code_unite,libelle from unite";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table_2.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}}
				else {
					if(code_unite.isSelected() && nbr_heures.isSelected()) {
						String Query="select code_unite,nbr_heures from unite";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table_2.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
						}
					else {
						if(code_unite.isSelected()&&matricule_ens.isSelected()) {
							String Query="select code_unite,matricule_ens from unite";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table_2.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
							}
						else {
							if(libelle.isSelected()&&nbr_heures.isSelected()) {
								String Query="select libelle,nbr_heures from unite";
								PreparedStatement pst;
								try {
									pst = con.prepareStatement(Query);
									ResultSet rs=pst.executeQuery();
									table_2.setModel(DbUtils.resultSetToTableModel(rs));
								} catch (Exception e1) {
								
									e1.printStackTrace();
								}
								}
							else {
								if(libelle.isSelected() && matricule_ens.isSelected()) {
									String Query="select libelle,matricule_ens from unite";
									PreparedStatement pst;
									try {
										pst = con.prepareStatement(Query);
										ResultSet rs=pst.executeQuery();
										table_2.setModel(DbUtils.resultSetToTableModel(rs));
									} catch (Exception e1) {
									
										e1.printStackTrace();
									}
									}
								else {
									if(nbr_heures.isSelected()&&matricule_ens.isSelected()) {
										String Query="select nbr_heures,matricule_ens from unite";
										PreparedStatement pst;
										try {
											pst = con.prepareStatement(Query);
											ResultSet rs=pst.executeQuery();
											table_2.setModel(DbUtils.resultSetToTableModel(rs));
										} catch (Exception e1) {
										
											e1.printStackTrace();
										}
										}
								}
							}
						}
					}
				}
				if(code_unite.isSelected() && libelle.isSelected()&& nbr_heures.isSelected()) {
					String Query="select code_unite ,libelle,nbr_heures from unite";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table_2.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
				
				else {
					if(code_unite.isSelected() && libelle.isSelected()&& matricule_ens.isSelected()) {
						String Query="select code_unite ,libelle ,matricule_ens from unite";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table_2.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					}
					
					else {
						if(code_unite.isSelected() &&nbr_heures.isSelected()&& matricule_ens.isSelected()) {
							String Query="select code_unite ,nbr_heures,matricule_ens from unite";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table_2.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						}
						else {
							if(libelle.isSelected() && matricule_ens.isSelected() &&nbr_heures.isSelected()) {
								String Query="select libelle ,matricule_ens,nbr_heures from unite";
								PreparedStatement pst;
								try {
									pst = con.prepareStatement(Query);
									ResultSet rs=pst.executeQuery();
									table_2.setModel(DbUtils.resultSetToTableModel(rs));
								} catch (Exception e1) {
								
									e1.printStackTrace();
								}
							}
						}
					}
				}
				if (code_unite.isSelected()&&libelle.isSelected()&&nbr_heures.isSelected()&&matricule_ens.isSelected()) {
					
					String Query="select * from unite";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table_2.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
			}
		});
		panel_1.add(btnValid_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(255, 255, 255));
		scrollPane_1.setBounds(399, 151, 333, 160);
		panel_1.add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_2.setForeground(new Color(0, 0, 0));
		table_2.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(table_2);
		tabbedPane.setEnabledAt(1, true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("consult enseignant", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		JRadioButton matriculeens = new JRadioButton("matricule_ens");
		matriculeens.setFont(new Font("Tahoma", Font.BOLD, 11));
		matriculeens.setForeground(new Color(255, 255, 255));
		matriculeens.setBackground(new Color(102, 102, 102));
		matriculeens.setBounds(51, 165, 109, 23);
		panel_2.add(matriculeens);
		
		JRadioButton nom_ens = new JRadioButton("nom_ens");
		nom_ens.setFont(new Font("Tahoma", Font.BOLD, 11));
		nom_ens.setForeground(new Color(255, 255, 255));
		nom_ens.setBackground(new Color(102, 102, 102));
		nom_ens.setBounds(182, 165, 109, 23);
		panel_2.add(nom_ens);
		
		JRadioButton prenom_ens = new JRadioButton("prenom_ens");
		prenom_ens.setFont(new Font("Tahoma", Font.BOLD, 11));
		prenom_ens.setForeground(new Color(255, 255, 255));
		prenom_ens.setBackground(new Color(102, 102, 102));
		prenom_ens.setBounds(102, 227, 109, 23);
		panel_2.add(prenom_ens);
		tabbedPane.setEnabledAt(2, true);
		
		JButton btnValid_1 = new JButton("Valid");
		btnValid_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnValid_1.setBackground(new Color(255, 102, 51));
		btnValid_1.setForeground(new Color(255, 255, 255));
		btnValid_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(matriculeens.isSelected()) {
					String Query="select matricule_ens from enseignant";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				
				}
				else {
					if(nom_ens.isSelected()) {
						String Query="select nom_ens from enseignant";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table_1.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					
						}
					else {
						
						if(prenom_ens.isSelected()) {
							String Query="select prenom_ens from enseignant";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table_1.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						}
						}
					}
				
	if(matriculeens.isSelected()&& nom_ens.isSelected()) {
			
				String Query="select matricule_ens,nom_ens from enseignant";
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
		
		}
		else {
			if(matriculeens.isSelected() && prenom_ens.isSelected()) {
				String Query="select matricule_ens,prenom_ens from enseignant";
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
				}
			else {
				if(nom_ens.isSelected()&&prenom_ens.isSelected()) {
					String Query="select prenom_ens,prenom_ens from enseignant";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
					}
				
			}}
		if (nom_ens.isSelected()&&prenom_ens.isSelected()&&matriculeens.isSelected()) {
		
			String Query="select * from enseignant";
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(Query);
				ResultSet rs=pst.executeQuery();
				table_1.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e1) {
			
				e1.printStackTrace();
			}
		}
			}
		});
		btnValid_1.setBounds(100, 306, 98, 35);
		panel_2.add(btnValid_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(new Color(255, 255, 255));
		scrollPane_2.setBounds(389, 141, 334, 193);
		panel_2.add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_1.setBackground(new Color(255, 255, 255));
		table_1.setForeground(new Color(0, 0, 0));
		scrollPane_2.setViewportView(table_1);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("consult etudiantunite", null, panel_3, null);
		tabbedPane.setEnabledAt(3, true);
		panel_3.setLayout(null);
		
		JRadioButton matriculeetu = new JRadioButton("matricule_etu");
		matriculeetu.setBackground(new Color(102, 102, 102));
		matriculeetu.setForeground(new Color(255, 255, 255));
		matriculeetu.setFont(new Font("Tahoma", Font.BOLD, 11));
		matriculeetu.setBounds(67, 141, 109, 23);
		panel_3.add(matriculeetu);
		
		JRadioButton note_cc = new JRadioButton("note_cc");
		note_cc.setBackground(new Color(102, 102, 102));
		note_cc.setForeground(new Color(255, 255, 255));
		note_cc.setFont(new Font("Tahoma", Font.BOLD, 11));
		note_cc.setBounds(201, 141, 109, 23);
		panel_3.add(note_cc);
		
		JRadioButton note_tp = new JRadioButton("note_tp");
		note_tp.setBackground(new Color(102, 102, 102));
		note_tp.setForeground(new Color(255, 255, 255));
		note_tp.setFont(new Font("Tahoma", Font.BOLD, 11));
		note_tp.setBounds(67, 199, 109, 23);
		panel_3.add(note_tp);
		
		JRadioButton note_examen = new JRadioButton("note_examen");
		note_examen.setBackground(new Color(102, 102, 102));
		note_examen.setForeground(new Color(255, 255, 255));
		note_examen.setFont(new Font("Tahoma", Font.BOLD, 11));
		note_examen.setBounds(201, 199, 109, 23);
		panel_3.add(note_examen);
		
		JRadioButton codeunite = new JRadioButton("code_unite");
		codeunite.setBackground(new Color(102, 102, 102));
		codeunite.setForeground(new Color(255, 255, 255));
		codeunite.setFont(new Font("Tahoma", Font.BOLD, 11));
		codeunite.setBounds(67, 257, 109, 23);
		panel_3.add(codeunite);
		
		JButton btnValider = new JButton("valider");
		btnValider.setBackground(new Color(255, 102, 51));
		btnValider.setForeground(new Color(255, 255, 255));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matriculeetu.isSelected()) {
					String Query="select matricule_etu from EtudiantUnite";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table_3.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				
				}
			  else {
					if(codeunite.isSelected()) {
					
						String Query="select code_unite from EtudiantUnite ";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table_3.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					}
					else {
						if(note_cc.isSelected()) {
							String Query="select note_CC from EtudiantUnite";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table_3.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}	
						}
						else {
							if(note_tp.isSelected()) {
								String Query="select note_TP from EtudiantUnite";
								PreparedStatement pst;
								try {
									pst = con.prepareStatement(Query);
									ResultSet rs=pst.executeQuery();
									table_3.setModel(DbUtils.resultSetToTableModel(rs));
								} catch (Exception e1) {
								
									e1.printStackTrace();
								}
							}
							else{
								if(note_examen.isSelected()) {
								
									String Query="select note_examen  from EtudiantUnite";
									PreparedStatement pst;
									try {
										pst = con.prepareStatement(Query);
										ResultSet rs=pst.executeQuery();
										table_3.setModel(DbUtils.resultSetToTableModel(rs));
									} catch (Exception e1) {
									
										e1.printStackTrace();
									}
								}
								
								}
							
								
							}
						}
						
						}
				
				if(matriculeetu.isSelected() && codeunite.isSelected()) {
					String Query="select matricule_etu , code_unite from EtudiantUnite";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table_3.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
				else {
					if(matriculeetu.isSelected() &&note_cc.isSelected()) {
						String Query="select matricule_etu , note_CC from EtudiantUnite";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table_3.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					}
					else {
						if(matriculeetu.isSelected() && note_examen.isSelected()) {
							String Query="select matricule_etu ,note_examen from EtudiantUnite";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table_3.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						}
						else {
							if(matriculeetu.isSelected() && note_tp.isSelected()) {
								String Query="select matricule_etu ,note_TP from EtudiantUnite";
								PreparedStatement pst;
								try {
									pst = con.prepareStatement(Query);
									ResultSet rs=pst.executeQuery();
									table_3.setModel(DbUtils.resultSetToTableModel(rs));
								} catch (Exception e1) {
								
									e1.printStackTrace();
								}
							}
							else {
								if(codeunite.isSelected() && note_cc.isSelected()) {
									String Query="select code_unite,note_CC from EtudiantUnite";
									PreparedStatement pst;
									try {
										pst = con.prepareStatement(Query);
										ResultSet rs=pst.executeQuery();
										table.setModel(DbUtils.resultSetToTableModel(rs));
									} catch (Exception e1) {
									
										e1.printStackTrace();
									}
								}
								else {
									if(codeunite.isSelected() && note_tp.isSelected()) {
										String Query="select code_unite ,note_TP from EtudiantUnite";
										PreparedStatement pst;
										try {
											pst = con.prepareStatement(Query);
											ResultSet rs=pst.executeQuery();
											table_3.setModel(DbUtils.resultSetToTableModel(rs));
										} catch (Exception e1) {
										
											e1.printStackTrace();
										}
									}
									else {
										if(codeunite.isSelected() && note_examen.isSelected()) {
											String Query="select  code_unite,note_examen from EtudiantUnite";
											PreparedStatement pst;
											try {
												pst = con.prepareStatement(Query);
												ResultSet rs=pst.executeQuery();
												table_3.setModel(DbUtils.resultSetToTableModel(rs));
											} catch (Exception e1) {
											
												e1.printStackTrace();
											}
										}
										else {
											if(note_cc.isSelected() && note_tp.isSelected()) {
												String Query="select note_CC ,note_TP from EtudiantUnite";
												PreparedStatement pst;
												try {
													pst = con.prepareStatement(Query);
													ResultSet rs=pst.executeQuery();
													table_3.setModel(DbUtils.resultSetToTableModel(rs));
												} catch (Exception e1) {
												
													e1.printStackTrace();
												}
											}
											else {
												if(note_cc.isSelected() && note_examen.isSelected()) {
													String Query="select note_cc ,note_examen from EtudiantUnite";
													PreparedStatement pst;
													try {
														pst = con.prepareStatement(Query);
														ResultSet rs=pst.executeQuery();
														table_3.setModel(DbUtils.resultSetToTableModel(rs));
													} catch (Exception e1) {
													
														e1.printStackTrace();
													}
												}
												else {
													if((note_tp.isSelected() && note_examen.isSelected())){
														String Query="select note_TP ,note_examen from EtudiantUnite";
														PreparedStatement pst;
														try {
															pst = con.prepareStatement(Query);
															ResultSet rs=pst.executeQuery();
															table_3.setModel(DbUtils.resultSetToTableModel(rs));
														} catch (Exception e1) {
														
															e1.printStackTrace();
														}
													}
													
												}
												
											}
										}
									}
								}
							}
						}
					}
				}
				if(matriculeetu.isSelected() && codeunite.isSelected()&& note_cc.isSelected()) {
					String Query="select matricule_etu ,code_unite,note_CC from EtudiantUnite";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table_3.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
				else {
					if(matriculeetu.isSelected() && codeunite.isSelected()&& note_tp.isSelected()) {
						String Query="select matricule_etu ,code_unite,note_TP from EtudiantUnite";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table_3.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					}
					else {
						if(matriculeetu.isSelected() && codeunite.isSelected()&& note_examen.isSelected()) {
							String Query="select matricule_etu ,code_unite,note_examen from EtudiantUnite";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table_3.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						}
						else {
							if(codeunite.isSelected() &&note_cc.isSelected() && note_tp.isSelected()) {
								String Query="select code_unite ,note_CC,note_TP from EtudiantUnite";
								PreparedStatement pst;
								try {
									pst = con.prepareStatement(Query);
									ResultSet rs=pst.executeQuery();
									table_3.setModel(DbUtils.resultSetToTableModel(rs));
								} catch (Exception e1) {
								
									e1.printStackTrace();
								}
							}
							else {
								if(codeunite.isSelected() && note_cc.isSelected() &&  note_examen.isSelected()) {
									String Query="select code_unite ,note_CC,note_examen from EtudiantUnite";
									PreparedStatement pst;
									try {
										pst = con.prepareStatement(Query);
										ResultSet rs=pst.executeQuery();
										table_3.setModel(DbUtils.resultSetToTableModel(rs));
									} catch (Exception e1) {
									
										e1.printStackTrace();
									}
								}
								else {
									if(note_cc.isSelected() && note_tp.isSelected() && note_examen.isSelected()) {
										String Query="select note_CC,note_TP,note_examen from EtudiantUnite";
										PreparedStatement pst;
										try {
											pst = con.prepareStatement(Query);
											ResultSet rs=pst.executeQuery();
											table_3.setModel(DbUtils.resultSetToTableModel(rs));
										} catch (Exception e1) {
										
											e1.printStackTrace();
										}
									}
									else {
										if(matriculeetu.isSelected() && note_cc.isSelected() && note_examen .isSelected()) {
											String Query="select matricule_etu,note_CC,note_examen from EtudiantUnite";
											PreparedStatement pst;
											try {
												pst = con.prepareStatement(Query);
												ResultSet rs=pst.executeQuery();
												table_3.setModel(DbUtils.resultSetToTableModel(rs));
											} catch (Exception e1) {
											
												e1.printStackTrace();
											}
										}
										else {
											if(matriculeetu.isSelected() && note_cc.isSelected() && note_tp .isSelected()) {
												String Query="select matricule_etu,note_CC,note_TP from EtudiantUnite";
												PreparedStatement pst;
												try {
													pst = con.prepareStatement(Query);
													ResultSet rs=pst.executeQuery();
													table_3.setModel(DbUtils.resultSetToTableModel(rs));
												} catch (Exception e1) {
												
													e1.printStackTrace();
												}
											}
											else {
												if(matriculeetu.isSelected() && note_tp.isSelected()&& note_examen.isSelected()) {
													String Query="select matricule_etu ,note_TP,note_examen from EtudiantUnite";
													PreparedStatement pst;
													try {
														pst = con.prepareStatement(Query);
														ResultSet rs=pst.executeQuery();
														table_3.setModel(DbUtils.resultSetToTableModel(rs));
													} catch (Exception e1) {
													
														e1.printStackTrace();
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}	
				
				if(  matriculeetu.isSelected() &&codeunite.isSelected() && note_cc.isSelected()&& note_tp.isSelected()&&note_examen.isSelected()) {
					String Query="select * from EtudiantUnite";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table_3.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
				if(matriculeetu.isSelected()&& codeunite.isSelected() && note_cc.isSelected()&& note_tp.isSelected()) {
					String Query="select matricule_etu,code_unite,note_cc,note_tp from EtudiantUnite";
					PreparedStatement pst;
					try {
						pst = con.prepareStatement(Query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
				else {
					if(matriculeetu.isSelected()&& codeunite.isSelected() && note_cc.isSelected()&& note_examen.isSelected()) {
						String Query="select matricule_etu,code_unite,note_cc,note_examen from EtudiantUnite";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table_3.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					}
					else {
						if(matriculeetu.isSelected()&& note_tp.isSelected() && note_cc.isSelected()&& note_examen.isSelected()) {
							String Query="select matricule_etu,note_tp,note_cc ,note_examen from EtudiantUnite";
							PreparedStatement pst;
							try {
								pst = con.prepareStatement(Query);
								ResultSet rs=pst.executeQuery();
								table_3.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						}
						else {
							if(note_tp.isSelected()&& codeunite.isSelected() && note_cc.isSelected()&& note_examen.isSelected()) {
								String Query="select code_unite,note_tp,note_cc ,note_examen from EtudiantUnite";
								PreparedStatement pst;
								try {
									pst = con.prepareStatement(Query);
									ResultSet rs=pst.executeQuery();
									table_3.setModel(DbUtils.resultSetToTableModel(rs));
								} catch (Exception e1) {
								
									e1.printStackTrace();
								}
							}
							
							}
						}
					}
					
				
				
					if( matriculeetu.isSelected() && codeunite.isSelected()&& note_tp.isSelected()&&note_examen.isSelected()&&note_cc.isSelected()) {
						String Query="select * from EtudiantUnite";
						PreparedStatement pst;
						try {
							pst = con.prepareStatement(Query);
							ResultSet rs=pst.executeQuery();
							table_3.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					}
			}
		});
		btnValider.setBounds(114, 327, 95, 30);
		panel_3.add(btnValider);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(new Color(255, 255, 255));
		scrollPane_3.setBounds(397, 141, 344, 188);
		panel_3.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_3.setForeground(new Color(0, 0, 0));
		scrollPane_3.setViewportView(table_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("insert etudiant", null, panel_4, null);
		tabbedPane.setEnabledAt(4, true);
		panel_4.setLayout(null);
		
		matriculetu = new JTextField();
		matriculetu.setHorizontalAlignment(SwingConstants.CENTER);
		matriculetu.setBounds(275, 68, 264, 27);
		panel_4.add(matriculetu);
		matriculetu.setColumns(10);
		
		JLabel lblMatriculeetu = new JLabel("matricule_etu");
		lblMatriculeetu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatriculeetu.setForeground(new Color(255, 255, 255));
		lblMatriculeetu.setBounds(93, 72, 120, 19);
		panel_4.add(lblMatriculeetu);
		
		JLabel lblNometu = new JLabel("nom_etu");
		lblNometu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNometu.setForeground(new Color(255, 255, 255));
		lblNometu.setBounds(93, 121, 120, 14);
		panel_4.add(lblNometu);
		
		JLabel lblPrenometu = new JLabel("prenom_etu");
		lblPrenometu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenometu.setForeground(new Color(255, 255, 255));
		lblPrenometu.setBounds(93, 167, 120, 14);
		panel_4.add(lblPrenometu);
		
		JLabel lblDatenaissnce = new JLabel("date_naissnce");
		lblDatenaissnce.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatenaissnce.setForeground(new Color(255, 255, 255));
		lblDatenaissnce.setBounds(93, 211, 120, 14);
		panel_4.add(lblDatenaissnce);
		
		JLabel lblAddress = new JLabel("address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setBounds(93, 255, 120, 14);
		panel_4.add(lblAddress);
		
		JFormattedTextField datenaissance = new JFormattedTextField();
		datenaissance.setHorizontalAlignment(SwingConstants.CENTER);
		datenaissance.setBounds(275, 205, 264, 27);
		panel_4.add(datenaissance);
		
		JButton btnInsert = new JButton("insert");
		btnInsert.setBackground(new Color(255, 102, 51));
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:bddadmin/TPadmin@localhost");	
				
						String query="insert into etudiant values(?,?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1,matriculetu.getText());
						ps.setString(2,nometu.getText());
						ps.setString(3,prenometu.getText());
						ps.setString(4,datenaissance.getText().toString() ); 
						ps.setString(5,adress.getText());
						ps.execute();
						
						JOptionPane.showMessageDialog(null, "saved");
					}catch (Exception e1) {
						e1.printStackTrace();
					}
					
			}
		});
		btnInsert.setBounds(359, 331, 97, 27);
		panel_4.add(btnInsert);
		
		nometu = new JTextField();
		nometu.setHorizontalAlignment(SwingConstants.CENTER);
		nometu.setBounds(274, 115, 265, 27);
		panel_4.add(nometu);
		nometu.setColumns(10);
		
		prenometu = new JTextField();
		prenometu.setHorizontalAlignment(SwingConstants.CENTER);
		prenometu.setBounds(275, 161, 264, 27);
		panel_4.add(prenometu);
		prenometu.setColumns(10);
		
		adress = new JTextField();
		adress.setHorizontalAlignment(SwingConstants.CENTER);
		adress.setBounds(275, 249, 264, 27);
		panel_4.add(adress);
		adress.setColumns(10);
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("insert unite", null, panel_5, null);
		panel_5.setLayout(null);
		
		matriculens = new JTextField();
		matriculens.setBounds(261, 90, 245, 29);
		panel_5.add(matriculens);
		matriculens.setColumns(10);
		
		JLabel lblMatriculeens = new JLabel("matricule_ens");
		lblMatriculeens.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatriculeens.setForeground(new Color(255, 255, 255));
		lblMatriculeens.setBounds(93, 97, 84, 14);
		panel_5.add(lblMatriculeens);
		
		codunite = new JTextField();
		codunite.setBounds(261, 159, 245, 29);
		panel_5.add(codunite);
		codunite.setColumns(10);
		
		JLabel lblCodeunite = new JLabel("code_unite");
		lblCodeunite.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodeunite.setForeground(new Color(255, 255, 255));
		lblCodeunite.setBounds(93, 166, 84, 14);
		panel_5.add(lblCodeunite);
		
		nombre_heures = new JTextField();
		nombre_heures.setBounds(261, 227, 245, 29);
		panel_5.add(nombre_heures);
		nombre_heures.setColumns(10);
		
		JLabel lblNbrheures = new JLabel("nombres_heures");
		lblNbrheures.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNbrheures.setForeground(new Color(255, 255, 255));
		lblNbrheures.setBounds(93, 234, 104, 14);
		panel_5.add(lblNbrheures);
		
		libell = new JTextField();
		libell.setBounds(261, 291, 245, 29);
		panel_5.add(libell);
		libell.setColumns(10);
		
		JLabel lblLibelles = new JLabel("libelle");
		lblLibelles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLibelles.setForeground(new Color(255, 255, 255));
		lblLibelles.setBounds(93, 298, 46, 14);
		panel_5.add(lblLibelles);
		
		JButton btnInsert_1 = new JButton("insert");
		btnInsert_1.setBackground(new Color(255, 102, 51));
		btnInsert_1.setForeground(new Color(255, 255, 255));
		btnInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:bddadmin/TPadmin@localhost");	
				
						String query="insert into unite values(?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1,codunite.getText());
						ps.setString(2,matriculens.getText());
						ps.setString(3,libell.getText());
						ps.setString(4,nombre_heures.getText());
						ps.execute();
						JOptionPane.showMessageDialog(null, "saved");
						
					}catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnInsert_1.setBounds(339, 359, 89, 23);
		panel_5.add(btnInsert_1);
		tabbedPane.setEnabledAt(5, true);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("insert enseignant", null, panel_6, null);
		panel_6.setLayout(null);
		
		matriculenss = new JTextField();
		matriculenss.setBounds(275, 76, 256, 31);
		panel_6.add(matriculenss);
		matriculenss.setColumns(10);
		
		JLabel lblMatriculeens_1 = new JLabel("matricule_ens");
		lblMatriculeens_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatriculeens_1.setForeground(new Color(255, 255, 255));
		lblMatriculeens_1.setBounds(98, 84, 100, 14);
		panel_6.add(lblMatriculeens_1);
		
		nomenss = new JTextField();
		nomenss.setBounds(275, 157, 256, 31);
		panel_6.add(nomenss);
		nomenss.setColumns(10);
		
		prenomenss = new JTextField();
		prenomenss.setBounds(275, 240, 256, 31);
		panel_6.add(prenomenss);
		prenomenss.setColumns(10);
		
		JLabel lblNomens = new JLabel("nom_ens");
		lblNomens.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomens.setForeground(new Color(255, 255, 255));
		lblNomens.setBounds(98, 165, 79, 14);
		panel_6.add(lblNomens);
		
		JLabel lblPrenomens = new JLabel("prenom_ens");
		lblPrenomens.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenomens.setForeground(new Color(255, 255, 255));
		lblPrenomens.setBounds(98, 248, 79, 14);
		panel_6.add(lblPrenomens);
		
		JButton btnInsert_2 = new JButton("insert");
		btnInsert_2.setBackground(new Color(255, 102, 51));
		btnInsert_2.setForeground(new Color(255, 255, 255));
		btnInsert_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:bddadmin/TPadmin@localhost");	
				
						String query="insert into enseignant values(?,?,?)";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1,matriculenss.getText());
						ps.setString(2,nomenss.getText());
						ps.setString(3,prenomenss.getText());
						
						ps.execute();
						JOptionPane.showMessageDialog(null, "saved");
						
					}catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnInsert_2.setBounds(359, 335, 89, 23);
		panel_6.add(btnInsert_2);
		tabbedPane.setEnabledAt(6, true);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("insert etudiantunite", null, panel_7, null);
		panel_7.setLayout(null);
		
		matriculetuu = new JTextField();
		matriculetuu.setBounds(262, 50, 252, 31);
		panel_7.add(matriculetuu);
		matriculetuu.setColumns(10);
		
		JLabel lblMatriculeetu_1 = new JLabel("matricule_etu");
		lblMatriculeetu_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatriculeetu_1.setForeground(new Color(255, 255, 255));
		lblMatriculeetu_1.setBounds(91, 58, 92, 14);
		panel_7.add(lblMatriculeetu_1);
		
		codeunitee = new JTextField();
		codeunitee.setBounds(262, 114, 252, 31);
		panel_7.add(codeunitee);
		codeunitee.setColumns(10);
		
		JLabel lblCodeunite_1 = new JLabel("code_unite");
		lblCodeunite_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodeunite_1.setForeground(new Color(255, 255, 255));
		lblCodeunite_1.setBounds(91, 122, 92, 14);
		panel_7.add(lblCodeunite_1);
		
		notecc = new JTextField();
		notecc.setBounds(262, 180, 252, 31);
		panel_7.add(notecc);
		notecc.setColumns(10);
		
		JLabel lblNotecc = new JLabel("note_cc");
		lblNotecc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotecc.setForeground(new Color(255, 255, 255));
		lblNotecc.setBounds(91, 188, 92, 14);
		panel_7.add(lblNotecc);
		
		notetp = new JTextField();
		notetp.setBounds(262, 247, 252, 31);
		panel_7.add(notetp);
		notetp.setColumns(10);
		
		JLabel lblNotetp = new JLabel("note_tp");
		lblNotetp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotetp.setForeground(new Color(255, 255, 255));
		lblNotetp.setBounds(91, 255, 92, 14);
		panel_7.add(lblNotetp);
		
		noteexamen = new JTextField();
		noteexamen.setBounds(262, 307, 252, 31);
		panel_7.add(noteexamen);
		noteexamen.setColumns(10);
		
		JLabel lblNoteexamen = new JLabel("note_examen");
		lblNoteexamen.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoteexamen.setForeground(new Color(255, 255, 255));
		lblNoteexamen.setBounds(91, 315, 92, 14);
		panel_7.add(lblNoteexamen);
		
		JButton btnInsert_3 = new JButton("insert");
		btnInsert_3.setBackground(new Color(255, 102, 51));
		btnInsert_3.setForeground(new Color(255, 255, 255));
		btnInsert_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:bddadmin/TPadmin@localhost");	
				
						String query="insert into EtudiantUnite values(?,?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1,matriculetuu.getText());
						ps.setString(2,codeunitee.getText());
						ps.setString(3,notecc.getText());
						ps.setString(4,notetp.getText());
						ps.setString(5,noteexamen.getText());
						
						ps.execute();
						JOptionPane.showMessageDialog(null, "saved");
						
					}catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnInsert_3.setBounds(343, 361, 89, 23);
		panel_7.add(btnInsert_3);
		tabbedPane.setEnabledAt(7, true);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:bddadmin/TPadmin@localhost");
			
		}catch (Exception e) {
		
		e.printStackTrace();
		}
	}
}
