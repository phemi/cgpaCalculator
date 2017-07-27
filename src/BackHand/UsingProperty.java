package BackHand;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oreoluwa
 */

import java.io.*;
import java.util.*;
public class UsingProperty {
    
    public static void main(String[] args){
        Properties table = new Properties();//create ppty tables
        
        //set ppties
        table.setProperty("Csc101", "4");
        table.setProperty("Mat141", "2");
        
        System.out.println( "After setting properties" );
        listProperties(table);
        
        //replace ppty value
        table.setProperty("Mat141", "4");
        
        System.out.println( "After replacing properties" );
        listProperties(table);
        
        saveProperties(table);//save ppties
        
        table.clear();//empties table
        
        System.out.println( "After clearing properties" );
        listProperties( table ); // display property values

        loadProperties(table);//load ppties
        
        table.setProperty("femi", "added");
        
        saveProperties(table);
      
        //get value of ppty color
//        Object value = table.getProperty("color");
        
//        //checkin if value is in table
//        if(value != null)
//            System.out.printf( "Property color's value is %s\n", value );
//        else
//           System.out.println( "Property color is not in table");

        
        
    }
    
    // save properties to a file
    private static void saveProperties( Properties props )
    {
        try{
            FileOutputStream output = new FileOutputStream("props.dat");
            props.store(output, "sample properties");
            output.close();
            System.out.println("After saving ppties");
            listProperties(props);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private static void loadProperties( Properties props )
    {
        // load contents of table
        try{
            FileInputStream input = new FileInputStream("props.dat");
        props.load(input);
        input.close();
        System.out.println( "After loading properties" );
        listProperties( props ); // display property
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
    
    // output property values
    private static void listProperties( Properties props )
    {
       Set< Object > keys = props.keySet();// get ppty names
       //outpt name/value pairs
       for(Object key : keys){
           System.out.printf(
                   "%s\t%s\n",key, props.getProperty((String) key));
           System.out.println();

       }
    }
//    public static void writeIntoFile(){
//        //Scanner input = new Scanner(new file("anjola.txt"));
//       try{
//           FileOutputStream output = new FileOutputStream("anjola.txt");
//           output.write;
//            //PrintWriter ogaWrite  = new PrintWriter("anjola.txt");
//            //ogaWrite.write("i am writng Anjola!");
//            //ogaWrite.close();
//       }catch(FileNotFoundException ex){
//            ex.printStackTrace();
//        }
//    }
//    
//     public static voidAppendFile(){
//        //Scanner input = new Scanner(new file("anjola.txt"));
//       try{
//           PrintWriter ogaWrite  = new PrintWriter("anjola.txt");
//           //Fi
//            ogaWrite.("i am writng oh!");
//            ogaWrite.close();
//       }catch(FileNotFoundException ex){
//            ex.printStackTrace();
//        }
//    }
    
}
