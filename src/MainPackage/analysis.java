package MainPackage;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollBar;

public class analysis extends JFrame {

	public static String pubDiscipline;
	private JPanel contentPane;
	private JTextField textFieldMiddle;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JTable table_1;
	private JTable table_2;
	public static JButton btnCharting;
	

	/**
	 * Create the frame.
	 */
	public analysis() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 419);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		//contentPane.setBackground(new Color(227, 255, 227));
		contentPane.setBackground(new Color(218, 218, 218));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][][][][grow][grow][]"));
		
		/* Headers 
		 * --------------------------------------------------------------------------
		 */
				//Home Button
				JButton btnHomeButton = new JButton("Home");
				//btnHomeButton.setBounds(100,500,200,20);
				btnHomeButton.setBackground(new Color(32, 136, 203));
				btnHomeButton.setForeground(new Color(255,255,255));
				btnHomeButton.setFont(new Font("Tahome",Font.BOLD, 16));
				btnHomeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						setVisible(false);
						MenuPage tFrame = new MenuPage();
						tFrame.setVisible(true);
					}
				});
				contentPane.add(btnHomeButton, "flowx,cell 0 0,growx,aligny top");
				
				//Add data Button
				JButton btnAdd = new JButton("Add data");
				btnAdd.setBackground(new Color(32, 136, 203));
				btnAdd.setForeground(new Color(255,255,255));
				btnAdd.setFont(new Font("Tahome",Font.BOLD, 16));
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						setVisible(false);
						addPage tFrame = new addPage();
						tFrame.setVisible(true);
					}
				});
				contentPane.add(btnAdd, "cell 0 0,growx,aligny top");
				
				//Analysis Button
				JButton btnAnalysisButton = new JButton("Analysis ");
				btnAnalysisButton.setBackground(new Color(0, 92, 168)); //Changes based on the frame you are in
				btnAnalysisButton.setForeground(new Color(255,255,255));
				btnAnalysisButton.setFont(new Font("Tahome",Font.BOLD, 16));

				contentPane.add(btnAnalysisButton, "cell 0 0,growx,aligny top");
				
				//Delete button
				JButton btnDelete = new JButton("Delete");
				btnDelete.setBackground(new Color(32, 136, 203));
				btnDelete.setForeground(new Color(255,255,255));
				btnDelete.setFont(new Font("Tahome",Font.BOLD, 16));
				btnDelete.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
				//Goes to the new database	
						setVisible(false);
						//selectRecords tFrame = new selectRecords();
						//tFrame.setVisible(true);
				//This creates a instance of mysqldml and calls the method selectRecord() (this method will again call the selectRecords class and update the table). 	
						MySQLDML recordss = new MySQLDML();
						//System.out.println("111");
						recordss.selectRecord();
						
						//tFrame.setVisible(false);
					}
				});
				
				contentPane.add(btnDelete, "cell 0 0,growx,aligny top");
		/*
		 * ----------------------------------------------------------------------------
		 */
		
		JLabel lblHeader = new JLabel("Please select the discipline you would like to compare below:");
		lblHeader.setBackground(new Color(86, 86, 86));
		lblHeader.setForeground(new Color(86, 86, 86));
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHeader, "cell 0 1,alignx center");
		
		//----------- Chart buttons appears --------------------------	
		btnCharting = new JButton("Charting");
		btnCharting.setForeground(Color.BLACK);
		btnCharting.setBackground(Color.WHITE);
		btnCharting.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCharting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//setVisible(false);
				charting tFrame = null;
				try {
					tFrame = new charting();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tFrame.setVisible(true);
			}
		});
		btnCharting.setVisible(false);
		
		
		
		// Button for GS, SL, SG, DH to sort and select based on discipline, time, and date.
		//this button opens a new JFrame to display all the records
		//Retrieves Slalom records
		JButton btnSL = new JButton("SL");
		btnSL.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSL.setBackground(new Color(255, 255, 255));
		btnSL.setForeground(new Color(0, 0, 0));
		btnSL.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				//Goes to the new database	
					btnCharting.setVisible(true);
					pubDiscipline = "SL";
					
					setVisible(false);
					System.out.println(pubDiscipline);
				//This creates a instance of mysqldml and calls the method selectRecord() (this method will again call the selectRecords class and update the table). 	
					MySQLDML slData = new MySQLDML();
					slData.sortData("SL");
					
				
					}
				});

		contentPane.add(btnSL, "flowx,cell 0 2,growx");
		contentPane.add(btnCharting, "flowx,cell 0 5,alignx center");							

		
		//Retrieves Giant Slalom records
		JButton btnGs = new JButton("GS");
		btnGs.setBackground(new Color(255, 255, 255));
		btnGs.setForeground(new Color(0, 0, 0));
		btnGs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Goes to the new database
				btnCharting.setVisible(true);
				pubDiscipline = "GS";
					setVisible(false);
				//This creates a instance of mysqldml and calls the method selectRecord() (this method will again call the selectRecords class and update the table). 	
					MySQLDML gsData = new MySQLDML();
								//System.out.println("111");
					gsData.sortData("GS");
								
								//tFrame.setVisible(false);
							}
				});
				contentPane.add(btnGs, "cell 0 2,growx");
		
		//Retrieves Super-G records						
		JButton btnSG = new JButton("SG");
		btnSG.setBackground(new Color(255, 255, 255));
		btnSG.setForeground(new Color(0,0,0));
		btnSG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Goes to the new database
				btnCharting.setVisible(true);
				pubDiscipline = "SG";
				
				setVisible(false);
				
				//This creates a instance of mysqldml and calls the method selectRecord() (this method will again call the selectRecords class and update the table). 	
					MySQLDML sgData = new MySQLDML();
								//System.out.println("111");
					sgData.sortData("SG");
								
								//tFrame.setVisible(false);
							}
				});
				contentPane.add(btnSG, "cell 0 2,growx");
				
				
		//Retrieves Downhill records
		JButton btnDH = new JButton("DH");
		btnDH.setBackground(new Color(255, 255, 255));
		btnDH.setForeground(new Color(0, 0, 0));
		btnDH.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
						//Goes to the new database	
				btnCharting.setVisible(true);
				pubDiscipline = "DH";
				
				setVisible(false);
						//This creates a instance of mysqldml and calls the method selectRecord() (this method will again call the selectRecords class and update the table). 	
					MySQLDML dhData = new MySQLDML();
					dhData.sortData("DH");
									}
						});
		contentPane.add(btnDH, "flowx,cell 0 2,growx");				
		
		/*
		 * This is the description Button for every page to explain what is going on!
		 * */
		
		JButton txt = new JButton("?");
		txt.setToolTipText("Click to see what the page is all about!");
		txt.setBackground(new Color(32, 136, 203));
		txt.setForeground(Color.WHITE);
		txt.setFont(new Font("Tahoma", Font.BOLD,12));
		txt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					
				//Creates the popup JFrame to display the description
				JFrame popup = new JFrame("Description");
		        JTextArea description = new JTextArea("This JFrame allows you to look at information from the data you have added. "
		        		+ "By Clicking the different discipline a table will give you a sorted table"
		        		+ " based on: discipline, order by time (ASC) and the date (DESC)."
		        		+ "In addition, when clicking on one of the disciplines a new charting button will appear"
		        		+ "this charting button opens a window showing the average time used grouped by the date and ski pair. "
		        		+ "This chart make it possible to see which ski is the fastest that day.");
		        
		        
		        description.setEditable(false);
		        description.setLineWrap(true);
		        description.setWrapStyleWord(true);
		        description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		        description.setPreferredSize(new Dimension(600,400));

		        popup.getContentPane().add(description);
		        popup.pack();
		        popup.setSize(new Dimension(420, 220));
		        popup.setLocationRelativeTo(null);
		        popup.setVisible(true);
				
				
			}
		});
		contentPane.add(txt, "flowx,cell 0 6,alignx left");
		
		
		/*
		 * End of description
		 * 
		 * */
	}
	
	public void setTable(DefaultTableModel model) {
	     
	     // Create a JTable with the table model
	     JTable table = new JTable(model);
	     table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	     table.setShowVerticalLines(true);
	     table.setShowHorizontalLines(false);    
	     table.setRowHeight(30);
	     
	     // Add the table to a JScrollPane and add the scroll pane to the frame
	     JScrollPane scrollPane = new JScrollPane(table);
	     scrollPane.setMinimumSize(getMinimumSize());
	     contentPane.add(scrollPane, "cell 0 4, growx");	   
		 JTableHeader Theader = table.getTableHeader();
	     Theader.setBackground(new Color(32, 136, 203)); //Sets color of Table
	     Theader.setForeground(new Color(255, 255,255)); //Sets foreground color of table
	     Theader.setFont(new Font("Segoe UI",Font.BOLD, 14));
	     Theader.setOpaque(false);
	    
	     
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					analysis open = new analysis();
					open.setVisible(true);
			
	}
}
