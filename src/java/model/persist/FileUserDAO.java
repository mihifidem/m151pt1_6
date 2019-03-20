package model.persist;

import model.persist.FileDataBase;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 * Clase de acceso ficheros de users
 * 
 * @author Oscar Burgos
 * @version marzo/2019
 */
public class FileUserDAO {
    
    //atributo que es un objeto de DataBase
    private FileDataBase d;

    public FileUserDAO(){
       
    }
    
    public FileUserDAO(String ruta){
       
        d=new FileDataBase(ruta+"/files/users.txt");
            
    }
   
    /**
     * retorna un boleà en funció si l'usuari hi és o no a l'aplicació 
     * @param u objeto user
     * @return devuel TRUE si el usuario (username/password) del objeto pasado existe.
     */
    public boolean findOne(User u){
       boolean flag=false;
       
       List<String> all=new ArrayList();
       all=d.listAllLines();
       
       for(String s : all){
            String[] pieces=s.split(";");
            if(pieces[0].equals(u.getUsername()) && pieces[1].equals(u.getPassword())){
                flag=true;
                break;
            }
      }
       
       
       return flag;
    }
    
    
    /**
     * retorna un string con el role en funció si l'usuari hi és o no a l'aplicació 
     * @param u objeto user
     * @return devuelve string role
     */
    public String findUser4Role(User u){
       String role="";
       
       List<String> all=new ArrayList();
       all=d.listAllLines();
       
       for(String s : all){
            String[] pieces=s.split(";");
            if(pieces[0].equals(u.getUsername()) && pieces[1].equals(u.getPassword())){
                role=pieces[2];
                break;
            }
      }     
     return role;
    }

    /**
     * Añade user 
     * 
     * @param u objeto user
     * @return Devuelve int (-1 si ya existe user-0 si hay problemas y 1 si
     * ha sido exitosa la acción
     */
    public int addUser(User u) {
        
        int inserted;
        //Paso 1: comprueba que u.getUsername() sea único
        if(findUsername(u.getUsername())){
            inserted=-1;//ya existe el usuario
        }else{
            //es cuando inserto
            inserted=d.insertToFile(u.toString());//0->problemas, 1-> ok
        }
        
        return inserted;
    }

    /**
     * Busca user por nombre
     * @param username
     * @return TRUE si existe no sino existe.
     */
    private boolean findUsername(String username) {
        boolean flag=false;
       
       List<String> all=new ArrayList();
       all=d.listAllLines();
       
       for(String s : all){
            String[] pieces=s.split(";");
            if(pieces[0].equals(username) ){
                flag=true;
                break;
            }
        }
       
       
       return flag;
        
     }
    
    /**
     * Borra user
     * @param username 
     */
    public void deleteUser(String username) {
      
        }
        
        

    
}

