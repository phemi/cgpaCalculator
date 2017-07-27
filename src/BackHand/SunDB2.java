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
import java.util.logging.Level;
import java.util.logging.Logger;

public class SunDB2 {
    public final String driver = "com.mysql.jdbc.Driver";
    public final String url = "jdbc:mysql://localhost:3306/compdept";
    public final String userName = "root";
    public final String password = "";
    public String query= "SELECT * FROM `info2011_12`";
            
    public Connection myCon = null;
    public ResultSet myRs = null;
    public Statement mySt= null;
    public ResultSetMetaData metadata = null;
    public PreparedStatement selectAllPeople = null;
    public PreparedStatement selectPeopleOfMatricNo = null;
    
    public void setDb(){
        //establishes connection to database
        try{
            Class.forName(driver);//loads this class into the Java interpreter
            myCon = DriverManager.getConnection(url, userName, password);//sets up connection
            mySt = myCon.createStatement();//creates statement for querying database
            
            
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(SunDB2.class.getName()).log(Level.SEVERE,null, ex );
        }
        catch(SQLException ex){
            Logger.getLogger(SunDB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initDb(){
        setDb();
    }
    
    public void killDb(){
        //ensures mySt, myRs,myCon are closed
        if(mySt != null ){
            try{
                mySt.close();
            }
            catch(SQLException ex){
                Logger.getLogger(SunDB2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(myRs != null ){
            try{
                myRs.close();
            }
            catch(SQLException ex){
                Logger.getLogger(SunDB2.class.getName()).log(Level.SEVERE, null, ex );
            }
        }
        else if(myCon != null ){
            try{
                myCon.close();
            }
            catch(SQLException ex){
                Logger.getLogger(SunDB2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
