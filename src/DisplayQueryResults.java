/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oreoluwa
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.*;
public class DisplayQueryResults extends JFrame{
    
    //JDBC driver and database url
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/sec_sch";
    static final String USERNAME= "root";
    static final String PASSWORD= "";
    
    // default query selects all rows from authors table
    static final String DEFAULT_QUERY = "SELECT * FROM student_info";

    private ResultSetTableModel tableModel;
    private JTextArea queryArea;

    // create ResultSetTableModel and GUI
    public DisplayQueryResults(){
        super ( "Displaying Query Results" );

        // create ResultSetTableModel and display database table
        try{
            // create TableModel for results of query SELECT * FROM authors
            tableModel = new ResultSetTableModel( JDBC_DRIVER, DATABASE_URL,
                       USERNAME, PASSWORD, DEFAULT_QUERY );   
            JScrollPane scrollPane = new JScrollPane(queryArea,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
         
         // set up JButton for submitting queries
         JButton submitButton = new JButton( "Submit Query" );
         
         // create Box to manage placement of queryArea and
         Box box = Box.createHorizontalBox();
         box.add(scrollPane);
         box.add(submitButton);
            
         
      //create Jtable delegate for table Model
         JTable resultTable = new JTable(tableModel);
         
         //place GUI components on content pane
         add(box, BorderLayout.NORTH);
         add(new JScrollPane(resultTable), BorderLayout.CENTER);
         
         //create new event listner for submisson button
         submitButton.addActionListener(
                 new ActionListener(){
                     //pass query to table model
                     public void actionPerformed(ActionEvent event){
                         //perform a new query
                         try{
                             tableModel.setQuery(queryArea.getText());
                         }catch(SQLException sQLException){
                             JOptionPane.showMessageDialog(null, sQLException.getMessage(),"Database Error",
                                     JOptionPane.ERROR_MESSAGE);
                             
                             //trying to recover from invalid user query
                             //by executing default query
                             
                             try{
                                 tableModel.setQuery(DEFAULT_QUERY);
                                 queryArea.setText(DEFAULT_QUERY);
                             }catch(SQLException sQLException1){
                                 JOptionPane.showMessageDialog(null, sQLException1.getMessage(), "DAtabase error"
                                         , JOptionPane.ERROR_MESSAGE);
                                 
                                 //ensure database connection is closed
                                 tableModel.disconnectFromDatabase();
                                 
                                 System.exit(1);
                             }
                         }
                     }
                 });//end call to addAction listener
         
                 setSize(1000,500);
                 setVisible(true);
        }catch(ClassNotFoundException classNotFound){
            JOptionPane.showMessageDialog(null, "MySQL Driver not found",
                    "Driver not Found", JOptionPane.ERROR_MESSAGE);
            
            System.exit(1);//terminates app
        }catch(SQLException sQLException){
            JOptionPane.showMessageDialog(null, sQLException.getMessage(), "Database Error!", JOptionPane.ERROR_MESSAGE);
            
            tableModel.disconnectFromDatabase();
            System.exit(1);
        }
        
        //ensures database connection is closed when user quits
        addWindowListener(
                
                new WindowAdapter() {
                
                    public void windowClosed(WindowEvent event){
                        tableModel.disconnectFromDatabase();
                        System.exit(0);
                    }});
    }
    
    public static void main(String[] args){
        new DisplayQueryResults();
    }


}
