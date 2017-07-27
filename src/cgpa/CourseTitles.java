/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpa;

/**
 *
 * @author Oreoluwa
 */
public enum CourseTitles {
    
    //declare course titles
    CSC101("INTRODUCION TO COMPUTER"),
    GES101("USE OF ENGLISH"),
    GES107("REPRODUCTIVE HEALTH, STI & HIV"),
    MAT111("ALGEBRA"),
    MAT121("CALCULUS & TRIGONOMETRY"),
    MAT141("ANALYTICAL GEOMETRY & MECHANICS"),
    PHY112("BASIC PRINCIPLES OF PHYSICS II"),
    PHY113("BASIC PRINCIPLES OF PHYSICS I"),
    PHY114("BASIC PRINCIPLES OF PHYSICS III"),
    PHY115("BASIC PRINCIPLES OF PHYSICS IV"),
    PHY118("EXPERIMENTAL PHYSICS I"),
    STA112("PROBABILITY I"),
    STA121("STATISTICAL INFERENCE I");
    
    private final String title; // book title
    
    CourseTitles(String title){
        this.title= title;
    }
    public String returnTitle(){
        return  title;
    }

}
