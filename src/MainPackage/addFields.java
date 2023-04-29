package MainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.MaskFormatter;


/*
 * This class is called from the addpage class in is called to add texfields, and comboboxes to the add field page
 * This class is separate to account for compatibility issues for swing design view and comboboxes.
 * 
 * */

public class addFields extends JFrame implements ActionListener {
	//Text fields for add pages
	private static JTextField textTime;
	private static JFormattedTextField dateField;
	private static JTextField textNote;
	
	//Date validator
	private static final String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";
	
	//JcomboBOXES
	private static JComboBox<Integer> comboBox;
	private static JComboBox comboBox2;
	private static JComboBox comboBox3;
	private static JComboBox comboBox4;
	
	//Label, button and variables to send to insert into SQL
	private static JButton btnNewButton;
	private static JLabel success;
	
	//Timer for my JLabel -> success
	private Timer timer;
	
	//Variables used to save inputs from the user in order to add stuff. 
	private static String timeT;
	private static Double time;
	
	private static String date;
	private static String note;
	
	private static int skiPair;
	private static String dicipline;
	private static String steepness;
	private static String conditions;


	
	addFields(){
		
		
		//Creates timer for Pop up message
		timer = new Timer(3000, e -> {
            success.setText("");
            timer.stop();
        });
		
		//Adds jtextfield for time
		textTime = new JTextField();
		textTime.setColumns(10);
		textTime.setForeground(new Color(86,86,86));
		textTime.setBackground(new Color(255,255,255));
		textTime.setFont(new Font("Tahoma", Font.BOLD,12));
		addPage.contentPane.add(textTime, "cell 0 6,growx");
		
		
		//Formats Text field:
		 try {
	            MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
	            dateFormatter.setPlaceholderCharacter(' ');
	            dateField = new JFormattedTextField(dateFormatter);
	            dateField.setBackground(new Color(255,255,255));
	            dateField.setForeground(new Color(86,86,86));
	            dateField.setFont(new Font("Tahoma", Font.BOLD,12));
	           

	            addPage.contentPane.add(dateField, "cell 0 7, growx");
	            

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	
		
		
		//Adds jtextfield for notes
		textNote = new JTextField(5);
		textNote.setColumns(10);
		textNote.setForeground(new Color(86,86,86));
		textNote.setBackground(new Color(255,255,255));
		textNote.setFont(new Font("Tahoma", Font.BOLD,12));
		addPage.contentPane.add(textNote, "cell 0 8,growx");
		
		
		//method called from addPage to insert the comboBoxes that are seen when running the add page class
					
		Integer[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		comboBox = new JComboBox<>(numbers);
		comboBox.setBounds(10, 253, 132, 43);		
		comboBox.setSelectedIndex(-1);
		comboBox.setForeground(new Color(86, 86, 86));
		comboBox.setBackground(new Color(255,255,255));
		comboBox.setFont(new Font("Tahoma", Font.BOLD,12));
		addPage.contentPane.add(comboBox, "cell 0 2,growx, align right");
			
			
		String[] dicipline = {"SL","GS","SG","DH"};
		comboBox2 = new JComboBox(dicipline);	
		comboBox2.setSelectedIndex(-1);
		comboBox2.setForeground(new Color(86, 86, 86));
		comboBox2.setBackground(new Color(255,255,255));
		comboBox2.setFont(new Font("Tahoma", Font.BOLD,12));
		addPage.contentPane.add(comboBox2, "cell 0 3,growx, align right");
		
		String[] conditions = {"Soft","Salted Slush","Grippy","Icy"};
		comboBox4 = new JComboBox(conditions);		
		comboBox4.setSelectedIndex(-1);
		comboBox4.setForeground(new Color(86, 86, 86));
		comboBox4.setBackground(new Color(255,255,255));
		comboBox4.setFont(new Font("Tahoma", Font.BOLD,12));
		addPage.contentPane.add(comboBox4, "cell 0 4,growx");
			
		String[] steepness = {"Flat","Gradual","Rolling","Steep"};
		comboBox3 = new JComboBox(steepness);		
		comboBox3.setSelectedIndex(-1);
		comboBox3.setForeground(new Color(86, 86, 86));
		comboBox3.setBackground(new Color(255,255,255));
		comboBox3.setFont(new Font("Tahoma", Font.BOLD,12));
		addPage.contentPane.add(comboBox3, "cell 0 5,growx");
		
		
			
		//Adds jbutton for adding inputs to database
		btnNewButton = new JButton("Add inputs to the database");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnNewButton.addActionListener(this);
		addPage.contentPane.add(btnNewButton, "cell 0 9,growx");
		
		//Add Jlabel that will notify the user if there is anything wrong
		success = new JLabel("");
		success.setFont(new Font("Tahoma", Font.BOLD, 14));
		success.setForeground(Color.red);
		success.setBounds(320, 400, 300, 18);
		addPage.contentPane.add(success, "cell 0 10,align left");
			
	}
	

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		
			//TextFields
			timeT = textTime.getText();
			note  = textNote.getText();
			date  = dateField.getText();
			
			//Comboboxes
			dicipline = (String) comboBox2.getSelectedItem();
			steepness = (String) comboBox3.getSelectedItem();
			conditions = (String) comboBox4.getSelectedItem();
			
			//Done so we do not get an exception trying to convert an integer as a null value. 
			if(comboBox.getSelectedItem() == null) {
				success.setText("You need to fill out the fields above!");
				timer.start();
			}
			
			//If statements to check if all times and dates are added.
			else if(timeT.isEmpty()==false && date.isEmpty()==false && dicipline != null && steepness != null && conditions!=null) {
				time 	= Double.parseDouble(timeT);
				if(time<0.0||time>99.99 && isValidDate(date)== true) {
					success.setText("Your time format is not correct");
					timer.start();
					
				}
				else if(time>0.0 || time <100) {
				skiPair = (int) comboBox.getSelectedItem(); 
				success.setText("Perfect, everything is added!");
				timer.start();
				//Calls the method in SQL to insert the records into the table!
				MySQLDML temp = new MySQLDML();
				temp.insertRecords(skiPair,dicipline, conditions, steepness,time,date,note);
				}
			}
		
			else {
				success.setText("You need to fill out the fields above!");
				timer.start();
			}
			
			
		}
		
		public static boolean isValidDate(String date) {
			System.out.println("inside isvaliddate");
	        return Pattern.matches(DATE_PATTERN, date);
	    }
		
		
}
