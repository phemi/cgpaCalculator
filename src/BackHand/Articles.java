/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author Oreoluwa
 */
public class Articles {
    private Properties table = new Properties();
    private String articleName ;
    private boolean  isSaved = false;
    
    
    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public boolean isIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }
    
    
    public Properties getTable() {
        try{
            loadProperties(table);
        }catch(Exception ex){
            table.put(2, "hhjhjkl#");
        }
        return table;
    }

    public void setTable(Properties table) {
        this.table = table;
    }
    
    public void loadProperties (Properties prop) throws IOException {
            FileInputStream input = new FileInputStream("props.dat");
            table.load(input);
            input.close();
    }
    public void saveProperties(Properties prop) throws IOException{
        FileOutputStream output = new FileOutputStream("props.dat");
        prop.store(output, "");
        output.close();
    }
    public List getNames(){
        Set<Object> keys = getTable().keySet();
        List list = new ArrayList();
        for(Object key : keys ){
            list.add(table.getProperty((String)key));
        }
        emptyTable();
        return list;
    }
    
    public boolean saveName(String name){
        
        Set<Object> keys = getTable().keySet();
        Object[] arrayKeys = keys.toArray();
        String lastKey;
        if(arrayKeys.length != 0){
             lastKey= arrayKeys[arrayKeys.length - 1 ].toString(); //gets the last key
        }else{
             lastKey = "0"; //sets the last key to be 0
        }
        
        int nextIndex ; //
        
        try{
            nextIndex = Integer.parseInt(lastKey) + 1; //sets next index as the last key++
            table.put(nextIndex, name);
            saveProperties(table);
            isSaved = true;
        }catch(Exception ex){
           isSaved = false;
        }
        emptyTable();
        return isSaved;
    }
    
    public boolean deleteName(String key){
        boolean isDeleted = false;
        getTable().remove(key);
        try{
            saveProperties(table);
            isDeleted = true;
        }catch(Exception ex){
            isDeleted = false;
        }
        return isDeleted;
    }
    public void emptyTable(){
        table.clear();
    }
    
    public String addArticle(){
        saveName(getArticleName());
        return "requestForm_home";
    }
    public static  void main(String[] args){
        Articles articles = new Articles(); 
       System.out.println(articles.getNames().size());
    }
}
