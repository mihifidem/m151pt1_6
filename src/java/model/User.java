package model;

/**Modeliza al Usuario a través de dos entradas: nombre de usuario
 * y la contraseña
 *@author Oscar Burgos
 *@version Marzo/2019
 */
public class User {
    
//atributos 
    private String username;
    private String password;
    private String role;

//constructor/es
    

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }
//accesores: getters + setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role ;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    //podrían interesarnos más métodos generales
    public String toString(){
        return "\n"+this.username+";"+this.password+";"+this.role+";";
    }
    
}
