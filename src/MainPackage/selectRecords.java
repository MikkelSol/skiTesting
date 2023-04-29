package MainPackage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * This class is used to retrieve the records and display it in a JFrame.
 * This class also enables the user to look at the records in the database and delete depending on the row (primary key).
 * @author Mikkel
 *
 */

//This class is called in the menu page when clicking the button to look at the records.

public class selectRecords extends JFrame implements ActionListener  {
	private JPanel contentPane;
	private static JComboBox<Integer> comboBox;
	private static int id;
	private static JLabel message;
	private Timer timer;
	
	public selectRecords() {
		
		//Set timer for pop up message
		timer = new Timer(3000, e -> {
            message.setText("");
            timer.stop();
        });
		
		//Creates content pane
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 640);
		setBounds(100, 100, 1022, 640);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(218, 218, 218));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][]", "[162.00][][][][][grow]"));
		
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
				contentPane.add(btnHomeButton, "flowx,cell 2 0,growx,aligny top");
				
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
				contentPane.add(btnAdd, "cell 2 0,growx,aligny top");
				
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
				contentPane.add(btnAnalysisButton, "cell 2 0,growx,aligny top");
				
				//Delete button
				JButton btnDelete = new JButton("Delete");
				btnDelete.setBackground(new Color(0, 92, 168));
				btnDelete.setForeground(new Color(255,255,255));
				btnDelete.setFont(new Font("Tahome",Font.BOLD, 16));
				
				contentPane.add(btnDelete, "cell 2 0,growx,aligny top");
		/*
		 * ----------------------------------------------------------------------------
		 */
		
		
		//Add Jlabel that will notify the user if there is anything wrong
		message = new JLabel("");
		message.setFont(new Font("Tahoma", Font.PLAIN, 14));
		message.setBounds(500, 450, 250, 50);
		contentPane.add(message, "cell 2 4, align center");
		
		
		
		
		
	
		//Adds button for deleting inputs from the database
		JButton btnNewButton = new JButton("Delete row:");
		btnNewButton.setBounds(350, 450, 132, 43);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton, "cell 2 2,align center");
				
		
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
		        JTextArea description = new JTextArea("This page shows you the full skiInventory table. "
		        		+ "The page is designed so that the user can easily look at the data and delete "
		        		+ "rows as they please.");
		        
		        
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
		contentPane.add(txt, "flowx,cell 2 5,alignx left,aligny bottom");
		
	}
		
	
		/**This method is where the table is created. The method is called in the class: MySQLDML.java 
		 * 
		 * MySQLDML is where the records are retrieved and the model, setTables input, is created. 
		 * 
		 */	
		public void setTable(DefaultTableModel model) {
	     
	     // Create a JTable with the table model
	     JTable table = new JTable(model);
	     table.setBounds(50, 100, 200, 100);
	     table.setRowHeight(30);
	     table.setShowHorizontalLines(false);
	     

	     // Add the table to a JScrollPane and add the scroll pane to the frame
	     JScrollPane scrollPane = new JScrollPane(table);
	     scrollPane.setBounds(200, 200, 500, 200);
	     getContentPane().add(scrollPane, "cell 2 1, growx");
	     
	     //Customize the header of the table
	     JTableHeader Theader = table.getTableHeader();
	     Theader.setBackground(new Color(32, 136, 203)); //Sets color of Table
	     Theader.setForeground(new Color(255, 255,255)); //Sets foreground color of table
	     Theader.setFont(new Font("Segoe UI",Font.BOLD, 14));
	     Theader.setOpaque(false);
	   
		}
		
		/*This method creates the combobox (drop down menu) so that the user can select the appropriate row based on what is in the table
		* This method is also called in the MySQLDML class where it retrieves the primary key integer from the table and puts it in an integer array. 
		* The method is then called in MySQLDML to update the combobox to have the appropriate values for the user to delete.
		* 
		*/
		public void setCombobox(Integer[] count) {
		     
		     // Create a JTable with the table model
			comboBox = new JComboBox<>(count);
			//comboBox.addActionListener(this);
			comboBox.setBounds(200, 450, 132, 43);		
			comboBox.setSelectedIndex(-1);
			comboBox.setForeground(new Color(86, 86, 86));
			comboBox.setBackground(new Color(235, 241, 241));
			contentPane.add(comboBox, "cell 2 2, alignx");
		     
		   
			}
		
		//This action listener checks if the selected row/id from the drop down menu is correct.
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		if(comboBox.getSelectedItem()==null) {
			message.setText("You need to pick a valid ID!");
			timer.start();
		}	
		
		else{
			id = (int) comboBox.getSelectedItem();
			
			MySQLDML delete = new MySQLDML();
			delete.deleteRow(id);
			setVisible(false);
			message.setText("Row number '" + id+"' was deleted");
			timer.start();
		}
			
			
		}
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new selectRecords();
	}


	

	
}
