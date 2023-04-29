package MainPackage;

import java.sql.*; 
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;


/**
 * This class "MySQLDML" is the main database connective class in this application, other than the "Charting" class
 * 
 * This method is called to retrieve, delete, or add data from the database and is called 
 * by the classes: addpage, selectRecords, charting, and analysis
 * 
 * */


public class MySQLDML {
	
	
	//These are my JDBC connector, and also my username and password for my MySQL data (not secure).
	String url = "jdbc:mysql://localhost:3306/capstoneProject";
	String username = "root";
	String password = "Mikkel12??";

	//this is where the data is stored to display it in tables (tablemodels)
	
	private DefaultTableModel model = new DefaultTableModel();
	private DefaultTableModel modelSort = new DefaultTableModel();
	private int rowCount;
	
	//Method to add to skiInventory table.
	public MySQLDML()  {
	
	}
	
		//this method is called when the add inputs to database button is pressed and all the variables are put in the objects you can see below
		public void insertRecords(int skiPair, String dicipline, String conditions, String steepness, Double time, String date, String note) {
			
			//system message
			System.out.println(skiPair+"|"+dicipline+"|"+steepness+"|"+time+"|"+date+"|"+note);
			System.out.println("Inserting records......");
			
			//Creates connection variable between the application and database:			
			try (Connection con= DriverManager.getConnection(url,username,password)) {
			
			//Inserts record and adds note if you have that otherwise it will go to the next method where notes are not included
			//(It is optional to add notes)
				
			if(note.isBlank()==false) {
				String query	= "INSERT INTO skiInventory (skiPair, discipline, conditions, steepness, time, dateN, note) VALUES (?, ?, ?, ?, ?, ?, ?)";
				
				//prepares the statements
				try (PreparedStatement statement = con.prepareStatement(query)) {
			        statement.setInt(1, skiPair);
			        statement.setString(2, dicipline);
			        statement.setString(3, conditions);
			        statement.setString(4, steepness);
			        statement.setDouble(5, time);
			        statement.setDate(6, Date.valueOf(date));
			        statement.setString(7, note);
			        
			        
			        // Executes the updates
			        int rowsAffected = statement.executeUpdate();
			        System.out.println("Rows affected: " + rowsAffected);
			      }
			
			
				}
			
			//Adds all required fields except notes. 
			else {
				
				String query	= "INSERT INTO skiInventory (skiPair, discipline, conditions, steepness, time, dateN) VALUES (?,?, ?, ?, ?, ?)";
				
				try (PreparedStatement statement = con.prepareStatement(query)) {
			        statement.setInt(1, skiPair);
			        statement.setString(2, dicipline);
			        statement.setString(3, conditions);
			        statement.setString(4, steepness);
			        statement.setDouble(5, time);
			        statement.setDate(6, Date.valueOf(date));
	       
			        int rowsAffected = statement.executeUpdate();
			        System.out.println("Rows affected: " + rowsAffected);
			      }
				}
			
		    } catch (SQLException e) {
		      System.err.println("Error: " + e.getMessage());
		    	}
		}
			
		//This method retrieves the record/the whole table and puts it in a default tablemodel object.
		public void selectRecord() {
			
			
			try (Connection con= DriverManager.getConnection(url,username,password)) {
				
				//retrieves record. 	
					String query	= "SELECT * FROM skiInventory";
					try (PreparedStatement statement = con.prepareStatement(query)) {
						
						
						// Execute the query and process the results
						ResultSet resultSet = statement.executeQuery();
			            //DefaultTableModel model = new DefaultTableModel();
			          
			            model.addColumn("Row");
			            model.addColumn("Ski Pair");
			            model.addColumn("Discipline");
			            model.addColumn("Conditions");
			            model.addColumn("Steepness");
			            model.addColumn("Time");
			            model.addColumn("Date");
			            model.addColumn("Note");
			            
			            
			            /*
			             * Make sure the Decimals in the table are two and not only 1
			             * */
			            DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
			            dfs.setDecimalSeparator('.'); // Set decimal separator to period
			            dfs.setGroupingSeparator(','); // Set grouping separator to comma
			            DecimalFormat df = new DecimalFormat("#.00" , dfs); // format with two decimal places			            
			            
			            
			            
			            /**
			             * Retrieve the data from the query and put it into a DefaultTableModel
			             * Called model
			             * 
			             * */
			            while (resultSet.next()) {
			            	
			           
			            	int id 				= resultSet.getInt("id");
			                int skiPair 		= resultSet.getInt("skiPair");
			                String discipline 	= resultSet.getString("discipline");
			                String conditions	= resultSet.getString("Conditions");
			                String steepness 	= resultSet.getString("steepness");
			                Double time 		= resultSet.getDouble("time");
			                Date dateN 			= resultSet.getDate("dateN");
			                String note 		= resultSet.getString("note");
			                
			                ;
			                
			                model.addRow(new Object[]{id, skiPair, discipline, conditions, steepness, df.format(time), dateN, note});
			            }
			          
			            // Calls select id to show the delete rows dropdown menu the rows to choose.
			            selectId();
			          
			           
			        }
				} catch (SQLException e) {
			      System.err.println("Error: " + e.getMessage());
			    	}
			}	
		
		//This methods retrieves the primary key from the table and displays it as Rows that the user can choose to delete as they please.
				public void selectId() {
					
					
					try (Connection con= DriverManager.getConnection(url,username,password)) {
						
						//Finds the count of the table to make sure the table length is set and reset every time something is deleted. 	
							String countQuery = "SELECT COUNT(*)FROM skiInventory";
						
							try (PreparedStatement statement = con.prepareStatement(countQuery)) {
								
								
								// Execute the query and process the results
								ResultSet resultSet = statement.executeQuery(countQuery);
								resultSet.next();
								rowCount = resultSet.getInt(1);
								
					            
					            		            
					            
					            }
							
							String query	= "SELECT id FROM skiInventory";
							try (PreparedStatement statement = con.prepareStatement(query)) {
								
								
								// Execute the query and process the results
								ResultSet resultSet = statement.executeQuery();
					        
					            int i=0;
					            Integer[] count =  new Integer[rowCount];			            
					            while (resultSet.next()) {
					          
					            	count[i] = resultSet.getInt("id");
					                i++;
					            }
					            
					       
					            //Creates an instance of selectRecords to display the table and dropdown menu in the delete page.
					            selectRecords frame = new selectRecords();
					            frame.setTable(model);
					            frame.setCombobox(count);
					            frame.setVisible(true);
					           
					        }
						} catch (SQLException e) {
					      System.err.println("Error: " + e.getMessage());
					    	}
					}		
		
				//This method is called to delete the row
				public void deleteRow(int rowN) {
					
					
					try (Connection con= DriverManager.getConnection(url,username,password)) {
						
						//Deletes the record	
							String query	= "DELETE FROM skiInventory WHERE id = ?";
							try (PreparedStatement statement = con.prepareStatement(query)) {
								
								statement.setInt(1, rowN);
								int rowsDeleted = statement.executeUpdate();
								
								System.out.println(rowsDeleted + " rows deleted!");
								// Execute the query and process the results
								
					            selectRecord();
					            
					           
					        }
						} catch (SQLException e) {
					      System.err.println("Error: " + e.getMessage());
					    	}
				
				}
				
				//This method is used to sort the data when a SL, GS, SG, or DH button is clicked in the analysis table
				
				public void sortData(String inputString) {
					
					
					try (Connection con= DriverManager.getConnection(url,username,password)) {
						
						//Retrieves and sort the record by the discipline, ascending order of time, and descending order of date. 	
							String query	= "SELECT * FROM skiInventory WHERE discipline = ? ORDER BY time ASC, dateN DESC ";
							try (PreparedStatement statement = con.prepareStatement(query)) {
								
								
								statement.setString(1,inputString);
								// Execute the query and process the results
								ResultSet resultSet = statement.executeQuery();
					            //DefaultTableModel model = new DefaultTableModel();
					          
					           
					            modelSort.addColumn("Ski Pair");
					            modelSort.addColumn("Discipline");
					            modelSort.addColumn("Conditions");
					            modelSort.addColumn("Steepness");
					            modelSort.addColumn("Time");
					            modelSort.addColumn("Date");
					            modelSort.addColumn("Note");
					            
					            /*
					             * Make sure the Decimals in the table are two and not only 1
					             * */
					            DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
					            dfs.setDecimalSeparator('.'); // Set decimal separator to period
					            dfs.setGroupingSeparator(','); // Set grouping separator to comma
					            DecimalFormat df = new DecimalFormat("#.00" , dfs); // format with two decimal places
					            			            
					            while (resultSet.next()) {
					            	
					            	
					                int skiPair 		= resultSet.getInt("skiPair");
					                String discipline 	= resultSet.getString("discipline");
					                String conditions	= resultSet.getString("Conditions");
					                String steepness 	= resultSet.getString("steepness");
					                Double time 		= resultSet.getDouble("time");
					                Date dateN 			= resultSet.getDate("dateN");
					                String note 		= resultSet.getString("note");
					                modelSort.addRow(new Object[]{skiPair, discipline, conditions, steepness, df.format(time), dateN, note});
					            }
					           // selectId();
					            //selectRecords frame = new selectRecords();
					            //frame.setTable(model);
					            
					            analysis frame = new analysis();
					            frame.setTable(modelSort);
					            frame.setVisible(true);
					            frame.btnCharting.setVisible(true);
					           
					        }
						} catch (SQLException e) {
					      System.err.println("Error: " + e.getMessage());
					    	}
					}	
		
				public static void main(String[] args) {
	
				}	
}
