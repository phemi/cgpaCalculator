/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpa;

/**
 *
 * @author Oreoluwa
 */
//import java.util.EnumSet;
import BackHand.StudentInfoCon;
import java.text.DecimalFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CGPA extends Student_bio{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String code = "CSC101";
        CourseTitles ttl = CourseTitles.valueOf(code);
        //for(CourseTitles ttl : CourseTitles.values()){
            System.out.println(ttl+"  "+ ttl.returnTitle());
        //}
    }
    
    public double calcGP(int[] scores, int[] units, int[] points, int[] wGradePoints, String[] remarks, CGPA obj){
        int totalUnit=0;
        int unitPassed=0;
        double cgpa;
        double totalWgpa=0.0;
        for(int i=0; i<scores.length; i++){
            if( scores[i]    >= 70 && scores[i] <= 100 ) {
                    points[i] = 7;
                    wGradePoints[i]=points[i] *units[i];
                    remarks[i]="Passed";
                    unitPassed+=units[i];
                }
			else if( scores[i] >= 65 && scores[i] < 70 ) {
                                    points[i] = 6;
                                    wGradePoints[i]=points[i] *units[i];
                                    remarks[i]="Passed";
                                    unitPassed+=units[i];
                                }
                 		else if( scores[i] >= 60 && scores[i] < 65 ) {
                                        points[i] = 5;
                                        wGradePoints[i]=points[i] *units[i];
                                        remarks[i]="Passed";
                                        unitPassed+=units[i];
                                        }
			  		else if( scores[i] >= 55 && scores[i] < 60 ) {
                                                points[i] = 4;
                                                wGradePoints[i]=points[i] *units[i];
                                                remarks[i]="Passed";
                                                unitPassed+=units[i];
                                                }
						else if( scores[i] >= 50 && scores[i] < 55 ) {
                                                            points[i] = 3;
                                                            wGradePoints[i]=points[i] *units[i];
                                                            remarks[i]="Passed";
                                                            unitPassed+=units[i];
                                                        }
							else if( scores[i] >= 45 && scores[i] < 50 ) {
                                                                points[i] = 2;
                                                                wGradePoints[i]=points[i] *units[i];
                                                                remarks[i]="Passed";
                                                                unitPassed+=units[i];
                                                               }
								else if( scores[i] >= 40 && scores[i] < 45 ) {
                                                                        points[i] = 1;
                                                                        wGradePoints[i]=points[i] *units[i];
                                                                        remarks[i]="Passed";
                                                                        }
									else {
                                                                                 points[i] = 0;
                                                                                 wGradePoints[i]=points[i] *units[i];
                                                                                 remarks[i]="Failed";
                                                                         }
            totalUnit+=units[i];
            totalWgpa+=wGradePoints[i];
            
        }
        obj.setunitPassed(unitPassed);
        obj.setTotalunits(totalUnit);
        obj.settotalWgp(totalWgpa);
        cgpa=totalWgpa/totalUnit;
        return cgpa;
    }
    
    
    public String print(File file,String sname, String fname, String oname, int matno, String yoE, String sex, String[] title, String[] courseCode, 
            int[] scores,int[] unit, int[] gP ,int[] wgp,String[] remark,String session, int totalUnits, int unitPassed,
            double totalWGP, String gp, int[] pExceptions){
        String result="";
        String Header="";
        try {
            //Scanner objScanner = new Scanner(new File("out.txt"));
            
            
            PrintWriter myWriter = new PrintWriter(file);
            Header="\t\t2012/12  SESSION\n";
            Header+="\tPROVISIONAL DEPARTMENTAL TRANSCRIPT\n";
            Header+="\t\tCOMPUTER SCIENCE DEPARTMENT\n";
            Header+="\t\tFACULTY OF SCIENCE\n\n";
            Header+="Name: "+sname+" "+fname+" "+oname+"     MATRIC-NO: "+matno+"\n";
            Header+="YEAR OF ENTRY: "+yoE+" \t\t\tSEX: "+sex+"\n";
            Header+="***********************************************************************\n";
            Header+="CODE\t\tTITLE\t\t\t\t\t MARK UNIT GP WGP REMARK SESSION\n";
            Header+="***********************************************************************\n";
            Header+="\t\t\tCOMPULSORY COURSES\n";
            result+=Header;
            myWriter.write(Header);
            
            
            //String[] session = {"2011/12", "2011/12","2011/12","2011/12","2011/12","2011/12","2011/12"};
            for(int i=0, j=0; i<title.length;i++){
                String pScore=""+scores[j], pUnit=""+unit[j],pGP =""+gP[j],pWGP=""+wgp[j], pRemark=""+remark[j];
                boolean isException = false;
                
                for(int k=0; k<pExceptions.length;k++){
                    if(pExceptions[k]==i){
                        pScore="";
                        pUnit="";
                        pGP="";
                        pWGP="";
                        pRemark="";
                        isException=true;
                        break;
                    }
                }
                //CourseTitles ttl = CourseTitles.valueOf(courseCode[i]); //i'm gonnA use dis wen they've registered cos of xceptional cases lik xtra courses
                myWriter.printf("%-8s%-35s%-4s%-4s%-4s%-4s%-7s%-7s\n", courseCode[i],title[i],pScore,pUnit, pGP, pWGP, pRemark, session );
                result+=String.format("%-8s%-35s%-4s%-4s%-4s%-4s%-7s%-7s\n", courseCode[i],title[i],pScore,pUnit, pGP, pWGP, pRemark, session );
                if(i==2){
                    myWriter.write("------------------------------------------------------------------------\nREQUIRED COURSES\n");
                    result+="------------------------------------------------------------------------\nREQUIRED COURSES\n";
                }
                if(isException==false){
                    j++;
                }
            }
            myWriter.write("REQUIRED COURSE UNIT PASSED = "+unitPassed+" OUT OF 35.0\n");
            myWriter.write("------------------------------------------------------------------------\n");
            myWriter.write("Total Units Taken = "+totalUnits+"\t\t\tTotal Units Passed = "+unitPassed+"\n");
            myWriter.write("TOTAL WGP = "+totalWGP+"\t\t\tCummulative Grade Point Average = "+gp+"\n\n");
            myWriter.write("*** NON GRADUATING STUDENT ***\n\n");
            
            String footer="REMARK\n";
            footer+="GRADE\t\tGRADE POINT\t\tMARK\t\tCUM. GRADE POINT AVERAGE\n";
            footer+="A\t\t\t7\t  70 & Above\t6.0 & Above FIRST CLASS\n";
            footer+="A-\t\t\t6\t  65 - 69\t\t4.6 - 5.9 2nd Class(Upper)\n";
            footer+="B+\t\t\t5\t  60 - 64\t\t2.6 - 4.5 2nd Class(Lower)\n";
            footer+="B\t\t\t4\t  55 - 59\t\t1.6 - 2.5 3rd Class\n";
            footer+="B-\t\t\t3\t  50 - 54\t\t1.0 - 1.5 Pass\n";
            footer+="C+\t\t\t2\t  45 - 49\t\t0   - 0.9 Fail\n";
            footer+="C\t\t\t1\t  40 - 44\n";
            footer+="D\t\t\t0\t  0  - 39\n\n";
            footer+="\t\t\t..........................\n";
            footer+="\t\t\t\tHead of Department\n\n";
            footer+="\t\tAny alteration renders this document invalid.";
            footer+="\n\n\n\n\n\n\n\n\n\n\n\n";
            myWriter.write(footer);
            result+=footer;
            myWriter.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CGPA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public void printAllRecord(File file, String[] matricNo, String session){
        try{
           
            PrintWriter myWriter = new PrintWriter(file);
            
            for(int i =0; i<matricNo.length; i++){
                StudentInfoCon objStudInfoCon = new StudentInfoCon();
                CGPA bioStud = new CGPA();
                objStudInfoCon.getStudentBio(Integer.parseInt(matricNo[i]), bioStud);
                
                String sname= bioStud.returnSurname();
                String fname=bioStud.returnfirstname();
                String oname=bioStud.returnothername();
                String sex = bioStud.returnsex();
                String yoE =bioStud.returnyearOfEntry();
                
        
                String[] courseCode={"CSC101","GES101","GES107","MAT111","MAT121","MAT141","PHY112","PHY113",
                "PHY114","PHY115", "PHY118", "STA112", "STA121"};
                
                objStudInfoCon.getStudentScores(Integer.parseInt(matricNo[i]), bioStud);
                
                int[] scores={bioStud.returncsc101(), bioStud.returnmat111(), bioStud.returnmat121(),
                bioStud.returnmat141(), bioStud.returnphy112(), bioStud.returnphy113(), bioStud.returnphy114(),
                bioStud.returnphy115(), bioStud.returnphy118(), bioStud.returnSta112(), bioStud.returnSta121()};
                
                int[] unit={bioStud.returncsc101Unit(), bioStud.returnmat111Unit(), bioStud.returnmat121Unit(),
                bioStud.returnmat141Unit(), bioStud.returnphy112Unit(), bioStud.returnphy113Unit(), bioStud.returnphy114Unit(),
                bioStud.returnphy115Unit(), bioStud.returnphy118Unit(), bioStud.returnSta112Unit(), bioStud.returnSta121Unit()};
                
                int[] gP= new int[scores.length], wgp = new int[scores.length];
                String[] remark = new String[scores.length];
                
                DecimalFormat decFormat = new DecimalFormat("0.0");
                String gp = decFormat.format(calcGP(scores, unit, gP, wgp, remark, bioStud));
                int unitPassed = bioStud.returnunitPassed();
                int totalUnits = bioStud.returntotalUnits();
                double totalWGP = bioStud.returntotalWgp();
                
                String Header="\t\t2012/12  SESSION\n";
            Header+="\tPROVISIONAL DEPARTMENTAL TRANSCRIPT\n";
            Header+="\t\tCOMPUTER SCIENCE DEPARTMENT\n";
            Header+="\t\tFACULTY OF SCIENCE\n\n";
            Header+="Name: "+sname+" "+fname+" "+oname+"     MATRIC-NO: "+matricNo[i]+"\n";
            Header+="YEAR OF ENTRY: "+yoE+" \t\t\tSEX: "+sex+"\n";
            Header+="***********************************************************************\n";
            Header+="CODE\t\tTITLE\t\t\t\t\t MARK UNIT GP WGP REMARK SESSION\n";
            Header+="***********************************************************************\n";
            Header+="\t\t\tCOMPULSORY COURSES\n";
            myWriter.write(Header);
            
            
            //String[] session = {"2011/12", "2011/12","2011/12","2011/12","2011/12","2011/12","2011/12"};
            for(int j=0; j<scores.length;j++){
                CourseTitles ttl = CourseTitles.valueOf(courseCode[j]);
                myWriter.printf("%-8s%-35s%-4d%-4d%-4d%-4d%-7s%-7s\n", courseCode[j],ttl.returnTitle(),scores[j],unit[j], gP[j], wgp[j], remark[j], session );
                if(j==2){
                    myWriter.write("------------------------------------------------------------------------\nREQUIRED COURSES\n");
                }
            }
            myWriter.write("REQUIRED COURSE UNIT PASSED = "+unitPassed+" OUT OF 35.0\n");
            myWriter.write("------------------------------------------------------------------------\n");
            myWriter.write("Total Units Taken = "+totalUnits+"\t\t\tTotal Units Passed = "+unitPassed+"\n");
            myWriter.write("TOTAL WGP = "+totalWGP+"\t\t\tCummulative Grade Point Average = "+gp+"\n\n");
            myWriter.write("*** NON GRADUATING STUDENT ***\n\n");
            
            String footer="REMARK\n";
            footer+="GRADE\t\tGRADE POINT\t\tMARK\t\tCUM. GRADE POINT AVERAGE\n";
            footer+="A\t\t\t7\t  70 & Above\t6.0 & Above FIRST CLASS\n";
            footer+="A-\t\t\t6\t  65 - 69\t\t4.6 - 5.9 2nd Class(Upper)\n";
            footer+="B+\t\t\t5\t  60 - 64\t\t2.6 - 4.5 2nd Class(Lower)\n";
            footer+="B\t\t\t4\t  55 - 59\t\t1.6 - 2.5 3rd Class\n";
            footer+="B-\t\t\t3\t  50 - 54\t\t1.0 - 1.5 Pass\n";
            footer+="C+\t\t\t2\t  45 - 49\t\t0   - 0.9 Fail\n";
            footer+="C\t\t\t1\t  40 - 44\n";
            footer+="D\t\t\t0\t  0  - 39\n\n";
            footer+="\t\t\t..........................\n";
            footer+="\t\t\t\tHead of Department\n\n";
            footer+="\t\tAny alteration renders this document invalid.";
            footer+="\n\n\n\n\n\n\n\n\n\n\n\n\n";
            myWriter.write(footer);
            }
            myWriter.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(CGPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int[] integerListToInt(ArrayList<Integer> listToBeConverted){
        int[] intConversion = new int[listToBeConverted.size()];
        int i=0;
        for(Integer val: listToBeConverted){
    		intConversion[i] = val.intValue();
    		i++;
    	}
        return intConversion;
    }
    
    public String[] stringListToString(ArrayList<String> listToBeConverted){
        String[] stringConversion = new String[listToBeConverted.size()];
        int i=0;
        for(String val: listToBeConverted){
    		stringConversion[i] = val.toString();
    		i++;
    	}
        return stringConversion;
    }
    
}
