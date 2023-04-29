package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

/**
 * Add page: This page is where a user can add data to the database. The format is for testing ski equipment and the variables are the
 * variables that makes the most sense to use for ski testing. 
 * 
 * */

public class addPage extends JFrame {

	public static JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public addPage() {
		//Creates the overall content pane for the addPage frame
		//setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		setBounds(100, 100, 884, 702);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 218, 218));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//Sets the layout of the page:
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow][grow][grow][grow][grow][grow][grow][55][55][55][][]"));
		
		
	
		
		
		
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
				btnAdd.setBackground(new Color(0, 92, 168));
				btnAdd.setForeground(new Color(255,255,255));
				btnAdd.setFont(new Font("Tahome",Font.BOLD, 16));
				contentPane.add(btnAdd, "cell 0 0,growx,aligny top");
				
				//Analysis Button
				JButton btnAnalysisButton = new JButton("Analysis ");
				btnAnalysisButton.setBackground(new Color(32, 136, 203)); //Changes based on the frame you are in
				btnAnalysisButton.setForeground(new Color(255,255,255));
				btnAnalysisButton.setFont(new Font("Tahome",Font.BOLD, 16));
				btnAnalysisButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						setVisible(false);
						analysis tFrame = new analysis();
						tFrame.setVisible(true);
					}
				});
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
						
				//This creates a instance of mysqldml and calls the method selectRecord() 
				//(this method will again call the selectRecords class and update the table).
						
						MySQLDML recordss = new MySQLDML();
						
						recordss.selectRecord();
						
					}
				});
				
				contentPane.add(btnDelete, "cell 0 0,growx,aligny top");
		/*
		 * ----------------------------------------------------------------------------
		 */
				
		//Label for the page
		
		JLabel lblHeader = new JLabel("Add data from your ski test below:");
		lblHeader.setBackground(new Color(86, 86, 86));
		lblHeader.setForeground(new Color(86, 86, 86));
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHeader, "cell 0 1,alignx center");
		
		
		/*
		 * ADDS Space to align the text better
		 * 
		 * ¨-------------------------------------------------------------------------------------
		 * 
		 * */
		JLabel spcLBL1 = new JLabel("                                                                               ");
		contentPane.add(spcLBL1, "flowx,cell 0 2");
		
		JLabel spcLBL2 = new JLabel("                                                                         ");
		contentPane.add(spcLBL2, "flowx,cell 0 3");
		
		JLabel spcLBL3 = new JLabel("                                                                                    ");
		contentPane.add(spcLBL3, "flowx,cell 0 4");
		
		JLabel spcLBL4 = new JLabel("                                                                       ");		
		contentPane.add(spcLBL4, "flowx,cell 0 5");
		
		JLabel spcLBL5 = new JLabel("                                                     ");		
		contentPane.add(spcLBL5, "flowx,cell 0 6");
		
		JLabel spcLBL6 = new JLabel("                                         ");		
		contentPane.add(spcLBL6, "flowx,cell 0 7");
		
		JLabel spcLBL7 = new JLabel("                                                                                              ");
		contentPane.add(spcLBL7, "flowx,cell 0 8");
		
		JLabel spcLBL8 = new JLabel("                                                                                                              ");
		contentPane.add(spcLBL8, "flowx,cell 0 9");
		
		JLabel spcLBL9 = new JLabel("                                                                                                              ");
		contentPane.add(spcLBL9, "cell 0 10");
		
		/**
		 * 
		 * END OF SPACE
		 * 
		 * 
		 * */
		
		
		
		/* 
		 * Adding the labels for each textfield and comboboxes. 
		 * 
		 * */
		
		JLabel lblNewLabel_1 = new JLabel("Ski pair used:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(86, 86, 86));
		lblNewLabel_1.setBackground(new Color(86, 86, 86));
		contentPane.add(lblNewLabel_1, "cell 0 2,alignx right");
		
		JLabel lblNewLabel_1_1 = new JLabel("Discipline skied:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setForeground(new Color(86, 86, 86));
		lblNewLabel_1_1.setBackground(new Color(86, 86, 86));
		contentPane.add(lblNewLabel_1_1, "cell 0 3,alignx right");
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Conditions:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setForeground(new Color(86, 86, 86));
		lblNewLabel_1_1_1_1.setBackground(new Color(86, 86, 86));
		contentPane.add(lblNewLabel_1_1_1_1, "cell 0 4,alignx trailing");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Steepness of hill:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setForeground(new Color(86, 86, 86));
		lblNewLabel_1_1_1.setBackground(new Color(86, 86, 86));
		contentPane.add(lblNewLabel_1_1_1, "cell 0 5,alignx trailing");
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Time in seconds (xx.xx):");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setForeground(new Color(86, 86, 86));
		lblNewLabel_1_1_1_1_1.setBackground(new Color(86, 86, 86));
		contentPane.add(lblNewLabel_1_1_1_1_1, "cell 0 6,alignx trailing");
		
		JLabel dateLabel = new JLabel("Date of testing (yyyy-mm-dd):");
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateLabel.setForeground(new Color(86, 86, 86));
		dateLabel.setBackground(new Color(86, 86, 86));
		contentPane.add(dateLabel, "cell 0 7,alignx trailing");
		
		JLabel noteLabel = new JLabel("Notes:");
		noteLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		noteLabel.setForeground(new Color(86, 86, 86));
		noteLabel.setBackground(new Color(86, 86, 86));
		contentPane.add(noteLabel, "cell 0 8,alignx trailing");
		
		
		
		//Calls the add fields method to add my text fields and comboboxes!
		
		/*Calls the class comboBoxes to insert and save the drop down 
		* menu for later insert into database
		* I put everything in addFields class, because the Integer I added to my combobox was not compatible with designer view
		* By putting it all in one class it made it easier to use the designer view, while also keeping the functionality maximized
			*/
				
		new addFields();
		
		
		/*
		 * Adds space after the textfields and comboboxes to better align them better.
		 * 
		 * */
			
		JLabel _1 = new JLabel("                                                                                                                                   ");
		contentPane.add(_1, "flowx,cell 0 2");
		
		JLabel _2 = new JLabel("                                                                                                                                   ");
		contentPane.add(_2, "flowx,cell 0 3");
		
		JLabel _3 = new JLabel("                                                                                                                                   ");
		contentPane.add(_3, "flowx,cell 0 4");
		
		JLabel _4 = new JLabel("                                                                                                                                   ");
		contentPane.add(_4, "flowx,cell 0 5");
		
		JLabel _5 = new JLabel("                                                                                                                                   ");
		contentPane.add(_5, "flowx,cell 0 6");
		
		JLabel _6 = new JLabel("                                                                                                                                   ");
		contentPane.add(_6, "flowx,cell 0 7");
		
		JLabel _7 = new JLabel("                                                                                                                                   ");
		contentPane.add(_7, "flowx,cell 0 8");
		
		JLabel _8 = new JLabel("                                                                                                                                   ");
		contentPane.add(_8, "flowx,cell 0 9");
		
		
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
		        JTextArea description = new JTextArea("This page allows you to add information from you ski test. "
		        		+ "You do need to add ALL fields except the notes field. If you add something wrong, "
		        		+ "you can simply go to the delete page and remove it.");
		        
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
		contentPane.add(txt, "cell 0 11,alignx left");
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		addPage open = new addPage();
		open.setVisible(true);	
	}
	
}