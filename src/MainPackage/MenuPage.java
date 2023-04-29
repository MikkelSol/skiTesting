package MainPackage;



//Imports:
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;


/*
 * Main Menu class: 
 * 
 * This class is functioning as the starting/home page for my application. The page has three primary function which is 
 * to move to different pages in the application.
 * 
 * This is the class that starts first when opening the application.
 * 
 * 
 * **/

public class MenuPage extends JFrame {

	
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MenuPage() {
	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 640);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(218, 218, 218));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Sets the layout of the page:
		
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[162.00][][][][][][][][][][28.00][12.00][-26.00][]"));
		
		
		//Adds all the buttons and adds the functionality to them:
		
		
		//Main menu label for Main Menu to be displayed
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setBackground(new Color(86, 86, 86));
		lblMainMenu.setForeground(new Color(86, 86, 86));
		lblMainMenu.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMainMenu, "cell 2 0,growx");
		
		
		//J button Add data --> takes you to add data page and sets the current visible frame to 0
		JButton btnAddData = new JButton("Add data ");
		btnAddData.setBackground(new Color(32, 136, 203));
		btnAddData.setForeground(new Color(255,255,255));
		btnAddData.setFont(new Font("Tahome",Font.BOLD, 16));
		btnAddData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				addPage tFrame = new addPage();
				tFrame.setVisible(true);
			}
		});
		contentPane.add(btnAddData, "flowx,cell 2 1,growx,growy");
		
		
		//J button analysis --> takes you to analysis page and sets the current visible frame to 0
		JButton btnAnalysis = new JButton("Analysis");
		btnAnalysis.setBackground(new Color(32, 136, 203));
		btnAnalysis.setForeground(new Color(255,255,255));
		btnAnalysis.setFont(new Font("Tahome",Font.BOLD, 16));
		btnAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				analysis tFrame = new analysis();
				tFrame.setVisible(true);
			}
		});
		contentPane.add(btnAnalysis, "cell 2 1,growx,growy");
		
		
		//J button delete data --> takes you to delete page and sets the current visible frame to 0
		JButton btnDelete = new JButton("Delete data");
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
		contentPane.add(btnDelete, "cell 2 1,growx,growy");
		
		
		
		
		//Creates the image and displays it on the page
		JLabel lblImage = new JLabel("");
		
		Image img = new ImageIcon(this.getClass().getResource("/Skier.jpg")).getImage();
		lblImage.setBackground(new Color(80, 80, 80));
		lblImage.setForeground(new Color(86, 86, 86));
		lblImage.setIcon(new ImageIcon(img));
		lblImage.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImage, "cell 2 6,growx");
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Makes sure the menupage is opened when starting this application.
		MenuPage open = new MenuPage();
		open.setVisible(true);
	}

}
