/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackHand;

/**
 *
 * @author Oreoluwa
 */

//This class has to do  mainly with the connection to the mysql database or any other database
import cgpa.Student_bio;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class StudentInfoCon extends SunDB2{
    public boolean  isSave=false;
    
    public static void main(String args[]){
        
    }
    
    //this method save is used to save student's biodata
    //takes in bio of reference type Student_bio which is imported from my made package cgpa
    //this methods returns a boolean value indicating whether it saved or not.
    public Boolean save(Student_bio bio){
        try{
            initDb();//intializes database by calling method intdb() of the extended SunDb class
            //Query used to insert the records by using the access modifies of Class Student_bio
            //to return the already set methods
            String query= "INSERT INTO `student_info`(`MatricNo`, `surname`, `firstname`, `Othername`, `level`, `yearOfEntry`, `sex`) VALUES ('"+
                    bio.returnmatricNo()+"','"+bio.returnSurname()+"','"+bio.returnfirstname() +"','"+bio.returnothername()+"','"
                    +bio.returnlevel()+"','"+bio.returnyearOfEntry()+"','"+bio.returnsex()+ "')";
            mySt=myCon.createStatement();//creates statement
            int count = mySt.executeUpdate(query);
            
            //if the returned value is greater than 0 set boolean isSave to true i.e it was saved successfully and else...
            if(count>0){
                isSave=true;
            }else{
                isSave=false;
            }
            
         
        }catch(SQLException ex){
            Logger.getLogger(StudentInfoCon.class.getName()).log(Level.SEVERE, null, ex);
            isSave = false;
        }
        
        //returns issave i.e if it is saved or not
        return isSave;
    }
    
    //this method is to get student bio of which his/is/ matric no is matno and saves the retrieved details
    //i.e the result set in the imported class Student_bio using the created copy obj
    //in other 4 me to use them by callin the access modifiers(i.e method 'returnStuffs')
    public void getStudentBio(int matNo, Student_bio obj){
        
        try{
            initDb();//intializes database by calling method intdb() of the extended SunDb class
            String query= "SELECT * FROM `student_info` WHERE MatricNo = '"+matNo+"'";
            myRs = mySt.executeQuery(query);
            
            //resultset sets the access modifiers in order to retrieve at the other end
            while(myRs.next()){
                obj.setmatricNo(myRs.getInt("MatricNo"));
                obj.setsurname(myRs.getString("surname"));
                obj.setfirstname(myRs.getString("firstname"));
                obj.setothername(myRs.getString("othername"));
                obj.setlevel(myRs.getInt("level"));
                obj.setyearOfEntry(myRs.getString("yearOfEntry"));
                obj.setsex(myRs.getString("sex"));
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(StudentInfoCon.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            killDb();
        }
    }
    
    public Boolean saveScores(Student_bio bio){
        try{
            initDb();//intializes database by calling method intdb() of the extended SunDb class
            //Query used to insert the records by using the access modifies of Class Student_bio
            //to return the already set methods
            String query= "INSERT INTO `scores100`(`MatricNo`, `csc101`, `csc101Unit`, `ges101`, "
                    + "`ges101Unit`, `ges107`, `ges107Unit`, `mat111`, `mat111Unit`, `mat121`, "
                    + "`mat121Unit`, `mat141`, `mat141Unit`, `phy112`, `phy112Unit`, `phy113`, "
                    + "`phy113Unit`, `phy114`, `phy114Unit`, `phy115`, `phy115Unit`, `phy118`, "
                    + "`phy118Unit`, `sta112`, `sta112Unit`, `sta121`, `sta121Unit`) VALUES  ('"+
                    bio.returnmatricNo()+"','"+bio.returncsc101()+"','"+bio.returncsc101Unit()+"','"
                    +bio.returnges101()+"','"+bio.returnges101Unit()+"','"
                    +bio.returnges107()+"','"+bio.returnges107Unit()+"','"
                    +bio.returnmat111()+"','"+bio.returnmat111Unit()+"','"
                    +bio.returnmat121()+"','"+bio.returnmat121Unit()+"','"+
                    bio.returnmat141()+"','"+bio.returnmat141Unit()+"','"
                    +bio.returnphy112()+"','"+bio.returnphy112Unit()
                    +"','"+bio.returnphy113()+"','"+bio.returnphy113Unit()+"','"+
                    bio.returnphy114()+"','"+bio.returnphy114Unit()+"','"+bio.returnphy115()
                    +"','"+bio.returnphy115Unit()+"','"+bio.returnphy118()+"','"+bio.returnphy118Unit()+"','"
                    +bio.returnSta112()+"','"+bio.returnSta112Unit()
                    +"','"+bio.returnSta121()+"','"+bio.returnSta121Unit()+"')";
            mySt=myCon.createStatement();//creates statement
            int count = mySt.executeUpdate(query);
            
            //if the returned value is greater than 0 set boolean isSave to true i.e it was saved successfully and else...
            if(count>0){
                isSave=true;
            }else{
                isSave=false;
            }
            
         
        }catch(SQLException ex){
            Logger.getLogger(StudentInfoCon.class.getName()).log(Level.SEVERE, null, ex);
            isSave = false;
        }
        
        //returns issave i.e if it is saved or not
        return isSave;
    }
    
    public void getStudentScores(int matNo, Student_bio obj){
        
        try{
            initDb();//intializes database by calling method intdb() of the extended SunDb class
            String query= "SELECT * FROM `scores100` WHERE MatricNo ='"+matNo+"'";
            myRs = mySt.executeQuery(query);
            
            //resultset sets the access modifiers in order to retrieve at the other end
            while(myRs.next()){
                obj.setmatricNo(myRs.getInt("MatricNo"));
                obj.setcsc101(myRs.getInt("csc101"));
                obj.setcsc101Unit(myRs.getInt("csc101Unit"));
                obj.setges101(myRs.getInt("ges101"));
                obj.setges101Unit(myRs.getInt("ges101Unit"));
                obj.setges107(myRs.getInt("ges107"));
                obj.setges107Unit(myRs.getInt("ges107Unit"));
                obj.setmat111(myRs.getInt("mat111"));
                obj.setmat111Unit(myRs.getInt("mat111Unit"));
                obj.setmat121(myRs.getInt("mat121"));
                obj.setmat121Unit(myRs.getInt("mat121Unit"));
                obj.setmat141(myRs.getInt("mat141"));
                obj.setmat141Unit(myRs.getInt("mat141Unit"));
                obj.setphy112(myRs.getInt("phy112"));
                obj.setphy112Unit(myRs.getInt("phy112Unit"));
                obj.setphy113(myRs.getInt("phy113"));
                obj.setphy113Unit(myRs.getInt("phy113Unit"));
                obj.setphy114(myRs.getInt("phy114"));
                obj.setphy114Unit(myRs.getInt("phy114Unit"));
                obj.setphy115(myRs.getInt("phy115"));
                obj.setphy115Unit(myRs.getInt("phy115Unit"));
                obj.setphy118(myRs.getInt("phy118"));
                obj.setphy118Unit(myRs.getInt("phy118Unit"));
                obj.setSta112(myRs.getInt("sta112"));
                obj.setSta112Unit(myRs.getInt("sta112Unit"));
                obj.setSta121(myRs.getInt("sta121"));
                obj.setSta121Unit(myRs.getInt("sta121Unit"));
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(StudentInfoCon.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            killDb();
        }
    }
    
    public String[] getMatricNo(){
        Vector v = new Vector();
        String[] arr = null;
        
       try {
            initDb();
           
            String q = "SELECT `MatricNo` FROM student_info ";
            
            myRs = mySt.executeQuery(q);
            while (myRs.next()) {               
               v.add(""+myRs.getInt("MatricNo")); 
           }
            
            arr = new String[v.size()];
                    v.toArray(arr);
            
            killDb();
       }  
        catch (SQLException ex) {
            Logger.getLogger(StudentInfoCon.class.getName()).log(Level.SEVERE, null, ex);
        }
            return arr;
    }
    
    public String[] getMatricNoFor100LScores(){
        Vector v = new Vector();
        String[] arr = null;
        
       try {
            initDb();
           
            String q = "SELECT `MatricNo` FROM scores100 ";
            
            myRs = mySt.executeQuery(q);
            while (myRs.next()) {               
               v.add(""+myRs.getInt("MatricNo")); 
           }
            
            arr = new String[v.size()];
                    v.toArray(arr);
            
            killDb();
       }  
        catch (SQLException ex) {
            Logger.getLogger(StudentInfoCon.class.getName()).log(Level.SEVERE, null, ex);
        }
            return arr;
    }
    
    public boolean deleteBio(int matNo){
        boolean isDeleted = false;
        try{
            initDb();
            String query= "DELETE FROM `student_info` WHERE MatricNo= '"+matNo+"'";
            mySt=myCon.createStatement();
            int count = mySt.executeUpdate(query);
            
            if(count>0){
                isDeleted=true;
            }else{
                isDeleted=false;
            }
            
         
        }catch(SQLException ex){
            Logger.getLogger(StudentInfoCon.class.getName()).log(Level.SEVERE, null, ex);
            isDeleted = false;
        }
        return isDeleted;
    }
    
    public boolean deleteScores(int matNo){
        boolean isDeleted = false;
        try{
            initDb();
            String query= "DELETE FROM `scores100` WHERE MatricNo= '"+matNo+"'";
            mySt=myCon.createStatement();
            int count = mySt.executeUpdate(query);
            
            if(count>0){
                isDeleted=true;
            }else{
                isDeleted=false;
            }
            
         
        }catch(SQLException ex){
            Logger.getLogger(StudentInfoCon.class.getName()).log(Level.SEVERE, null, ex);
            isDeleted = false;
        }
        return isDeleted;
    }
    public boolean updateRecord(int matNo, Student_bio bio){
        boolean isUpdated = false;
        try{
            initDb();
            String query= "UPDATE `student_info` SET `MatricNo`= '"+bio.returnmatricNo()+"' ,`surname`= '"+bio.returnSurname()+"',"
                    + "`firstname`= '"+bio.returnfirstname()+"' ,`Othername`= '"+bio.returnothername()+"' ,"
                    + "`level`=100,`yearOfEntry`= '"+bio.returnyearOfEntry()+"' ,`sex`= '"+bio.returnsex()+
                            "' WHERE `MatricNo`= '"+matNo+"'";
            mySt=myCon.createStatement();
            int count = mySt.executeUpdate(query);
            
            if(count>0){
                isUpdated=true;
            }else{
                isUpdated=false;
            }
            
         
        }catch(SQLException ex){
            Logger.getLogger(StudentInfoCon.class.getName()).log(Level.SEVERE, null, ex);
            isUpdated = false;
        }
        return isUpdated;
    }
    
    public boolean saveLoginInfo(String user, String pass){
        boolean isSave = false;
        try{
            initDb();//intializes database by calling method intdb() of the extended SunDb class
            //Query used to insert the records by using the access modifies of Class Student_bio
            //to return the already set methods
            String query= "INSERT INTO `logininfo`(`s/n`, `username`) VALUES("
                    + null+",'"+user+"' "+")";//creates statement
            int count = mySt.executeUpdate(query);
            
            //if the returned value is greater than 0 set boolean isSave to true i.e it was saved successfully and else...
            if(count>0){
                isSave=true;
            }else{
                isSave=false;
            }
            
    }catch(SQLException ex){
            Logger.getLogger(StudentInfoCon.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            killDb();
        }
        return isSave;
    }
}
