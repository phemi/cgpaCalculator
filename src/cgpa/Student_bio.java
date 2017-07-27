/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpa;

import java.io.Serializable;

/**
 *
 * @author Oreoluwa
 */
import BackHand.StudentInfoCon;
public class Student_bio implements Serializable{

    /**
     * @param args the command line arguments
     */
    
    private String surname;
    private String firstname;
    private String othername;
    private int matricNo;
    private int level;
    private String yearOfEntry;
    private String sex;
    
    private int totalUnits;
    private int unitPassed;
    private double totalWgp;
    
    private int csc101;
    private int ges101;
    private int ges107;
    private int mat111;
    private int mat121;
    private int mat141;
    private int phy112;
    private int phy113;
    private int phy114;
    private int phy115;
    private int phy118;
    private int sta112;
    private int sta121;
    
    private int csc101Unit;
    private int ges101Unit;
    private int ges107Unit;
    private int mat111Unit;
    private int mat121Unit;
    private int mat141Unit;
    private int phy112Unit;
    private int phy113Unit;
    private int phy114Unit;
    private int phy115Unit;
    private int phy118Unit;
    private int sta112Unit;
    private int sta121Unit;
    
   public void setsurname(String surname){this.surname=surname;}
   public String returnSurname(){return surname;}
   public void setfirstname(String firstname){this.firstname=firstname;}
   public String returnfirstname(){return firstname;}
   public void setothername(String othername){this.othername=othername;}
   public String returnothername(){return othername;}
   public void setmatricNo(int matricNo){this.matricNo=matricNo;}
   public int returnmatricNo(){return matricNo;}
   public void setlevel(int level){this.level=level;}
   public int returnlevel(){return level;}
   public void setyearOfEntry(String yearOfEntry){this.yearOfEntry=yearOfEntry;}
   public String returnyearOfEntry(){return yearOfEntry;}
   public void setsex(String sex){this.sex=sex;}
   public String returnsex(){return sex;}
   public void setTotalunits(int totalUnits){this.totalUnits=totalUnits;}
   public int returntotalUnits(){return totalUnits;}
   public void setunitPassed(int unitPassed){this.unitPassed=unitPassed;}
   public int returnunitPassed(){return unitPassed;}
   public void settotalWgp(double totalWgp){this.totalWgp=totalWgp;}
   public double returntotalWgp(){return totalWgp;}
   
   public void setcsc101(int csc101){this.csc101=csc101;}
   public int returncsc101(){return csc101;}
   public void setges101(int ges101){this.ges101=ges101;}
   public int returnges101(){return ges101;}
   public void setges107(int ges107){this.ges107=ges107;}
   public int returnges107(){return ges107;}
   public void setmat111(int mat111){this.mat111=mat111;}
   public int returnmat111(){return mat111;}
   public void setmat121(int mat121){this.mat121=mat121;}
   public int returnmat121(){return mat121;}
   public void setmat141(int mat141){this.mat141=mat141;}
   public int returnmat141(){return mat141;}
   public void setphy112(int phy112){this.phy112=phy112;}
   public int returnphy112(){return phy112;}
   public void setphy113(int phy113){this.phy113=phy113;}
   public int returnphy113(){return phy113;}
   public void setphy114(int phy114){this.phy114=phy114;}
   public int returnphy114(){return phy114;}
   public void setphy115(int phy115){this.phy115=phy115;}
   public int returnphy115(){return phy115;}
   public void setphy118(int phy118){this.phy118=phy118;}
   public int returnphy118(){return phy118;}
   public void setSta112(int sta112){this.sta112=sta112;}
   public int returnSta112(){return sta112;}
   public void setSta121(int sta121){this.sta121=sta121;}
   public int returnSta121(){return sta121;}
   
   public void setcsc101Unit(int csc101Unit){this.csc101Unit=csc101Unit;}
   public int returncsc101Unit(){return csc101Unit;}
   public void setges101Unit(int ges101Unit){this.ges101Unit=ges101Unit;}
   public int returnges101Unit(){return ges101Unit;}
   public void setges107Unit(int ges107Unit){this.ges107Unit=ges107Unit;}
   public int returnges107Unit(){return ges107Unit;}
   public void setmat111Unit(int mat111Unit){this.mat111Unit=mat111Unit;}
   public int returnmat111Unit(){return mat111Unit;}
   public void setmat121Unit(int mat121Unit){this.mat121Unit=mat121Unit;}
   public int returnmat121Unit(){return mat121Unit;}
   public void setmat141Unit(int mat141Unit){this.mat141Unit=mat141Unit;}
   public int returnmat141Unit(){return mat141Unit;}
   public void setphy112Unit(int phy112Unit){this.phy112Unit=phy112Unit;}
   public int returnphy112Unit(){return phy112Unit;}
   public void setphy113Unit(int phy113Unit){this.phy113Unit=phy113Unit;}
   public int returnphy113Unit(){return phy113Unit;}
   public void setphy114Unit(int phy114Unit){this.phy114Unit=phy114Unit;}
   public int returnphy114Unit(){return phy114Unit;}
   public void setphy115Unit(int phy115Unit){this.phy115Unit=phy115Unit;}
   public int returnphy115Unit(){return phy115Unit;}
   public void setphy118Unit(int phy118Unit){this.phy118Unit=phy118Unit;}
   public int returnphy118Unit(){return phy118Unit;}
   public void setSta112Unit(int sta112Unit){this.sta112Unit=sta112Unit;}
   public int returnSta112Unit(){return sta112Unit;}
   public void setSta121Unit(int sta121Unit){this.sta121Unit=sta121Unit;}
   public int returnSta121Unit(){return sta121Unit;}
}
