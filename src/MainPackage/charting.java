package MainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import net.miginfocom.swing.MigLayout;


/**
 * This class is for charting my data based on the average time a ski pair used during a ski testing day,
 * and what discipline the user skied on (No point in comparing two different disciplines). 
 * 
 * */
public class charting extends JFrame {
	
	String url = "jdbc:mysql://localhost:3306/capstoneProject";
	String username = "root";
	String password = "Mikkel12??";
	
	//Creates the layout of the pop up page
	public charting() throws SQLException {
        super("Bar Chart Example");
        JPanel chartPanel = createChartPanel(analysis.pubDiscipline);
        getContentPane().add(chartPanel, BorderLayout.CENTER);
        chartPanel.setLayout(new MigLayout("", "[85px]", "[21px]"));
        
        JButton btnAnalysisButton = new JButton("Back");
		btnAnalysisButton.setBackground(Color.WHITE); //Changes based on the frame you are in
		btnAnalysisButton.setForeground(Color.BLACK);
		btnAnalysisButton.setFont(new Font("Tahome",Font.PLAIN, 12));
		btnAnalysisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				setVisible(false);
				
			}
		});
        chartPanel.add(btnAnalysisButton, "cell 0 0,alignx left, aligny top");
        
        setSize(640, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    /*
     * 
     * Creates a private JPanel that displays my chart, based on Average time, skipair, date, and Discipline. 
     * 
     * 
     * */
    
    
    private JPanel createChartPanel(String inputString) throws SQLException {
        String chartTitle = "Average time based on ski pair and date";
        String categoryAxisLabel = "Date";
        String valueAxisLabel = "Average Time Used";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        try (Connection con= DriverManager.getConnection(url,username,password)) {
           
        	//String to find the query
        	String query = "SELECT dateN, skiPair, AVG(time) AS avgtimeused FROM skiInventory WHERE discipline = ? GROUP BY dateN, skiPair";
        	
        	try (PreparedStatement statement = con.prepareStatement(query)) {
            
        		//Use the input string (SL/GS/SG/DH)
				statement.setString(1,inputString);

        		ResultSet rs = statement.executeQuery();
            
        		while (rs.next()) {
                
        			String date = rs.getString("dateN");
                
        			String skipair = rs.getString("skiPair");
                
        			double avgtimeused = rs.getDouble("avgtimeused");
                
        			dataset.addValue(avgtimeused, skipair, date);
            }
            con.close();
        } catch (Exception e) {
        	System.err.println("Error: " + e.getMessage());
        	}
        }       
        
        //Creates the chart based on the retrieved data
        JFreeChart chart = ChartFactory.createBarChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLowerBound(30); // set lower bound to 30
        return new ChartPanel(chart);
        }
        

    public static void main(String[] args) throws SQLException {
        new charting();
    }
}

