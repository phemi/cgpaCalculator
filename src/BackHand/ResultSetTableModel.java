package BackHand;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oreoluwa
 */

import java.sql.*;
import javax.swing.table.AbstractTableModel;
public class ResultSetTableModel extends AbstractTableModel{
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    
    private boolean connectedToDatabase = false;
    
    public ResultSetTableModel(String driver, String url,
            String username, String password, String query) 
    throws SQLException, ClassNotFoundException{
        
        //load database driver class
        Class.forName(driver);
        
        //connect to database
        connection = DriverManager.getConnection(url, username, password);
        
        //create statement to query database
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        //update database connection status
        connectedToDatabase = true;
        
        //set query and execute it
        setQuery(query);
    }
    
    //get class that represents colmn type
    public Class getColumnClass(int column) throws IllegalStateException{
        
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to database");
            
            //determine Java class of column
        try
        {
            String className = metaData.getColumnClassName(column+1);
                
            //return Class object that represents classname
            return  Class.forName(className);
                
         }catch(Exception exception){
            exception.printStackTrace();
         }
            
         return Object. class;//if problems occur above, assume type Objevt 
    }
    
    public int getColumnCount()throws IllegalStateException{
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to datsbase");
        
        //determine no of cols
        try{
            return metaData.getColumnCount();
        }catch(SQLException sQLException){
            sQLException.printStackTrace();
        }
        return 0; //if problems occur above, return 0 for number of columns
        
    }
    
    public String getColumnName(int column)throws IllegalStateException{
        
        //ensures database con is availablesss
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to datsbase");
        
        //determine col name
        try{
            return metaData.getColumnName(column+1);
        }catch(SQLException sQLException){
            sQLException.printStackTrace();
        }
        return ""; //if problems occur above, return 0 for number of columns
        
    }
    
    public int getRowCount()throws IllegalStateException{
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to datsbase");
        
        
        return numberOfRows; //if problems occur above, return 0 for number of columns
        
    }
    
    public Object getValueAt(int row, int column)throws IllegalStateException{
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to datsbase");
        
        //determine no of cols
        try{
            resultSet.absolute(row+1);
            return resultSet.getObject(column+1);
        }catch(SQLException sQLException){
            sQLException.printStackTrace();
        }
        return ""; //if problems, return empty string obj
        
        
    }
    
    public void setQuery(String query)
            throws SQLException,IllegalStateException{
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to datsbase");
        
        resultSet = statement.executeQuery(query);
        
        metaData = resultSet.getMetaData();
        resultSet.last();
        numberOfRows = resultSet.getRow();
        
        //notifies JTable that model has changed
        fireTableStructureChanged();
        
    }
    
    public void disconnectFromDatabase(){
        if(!connectedToDatabase)
            return;
        
        
        //determine no of cols
        try{
            statement.close();
            connection.close();
        }catch(SQLException sQLException){
            sQLException.printStackTrace();
        }
        finally{
            connectedToDatabase= false;
        }
        
    }
}
