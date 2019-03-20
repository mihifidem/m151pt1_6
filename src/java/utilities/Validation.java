/**
 * File utilities
 * @author Oscar Burgos
 */
package utilities;

public class Validation {
    public static boolean minimSize(String value, int mySize){
        
        boolean flag=false;
        
        if(value.length()>=mySize) flag=true;
        
        return flag;
         
    }
    
    public static boolean NumEntreValues(int value, int min, int max){
        
        boolean flag=false;
        
        if ((value>min) && (value<max)) flag=true;
        
        return flag;
         
    }
    
}
