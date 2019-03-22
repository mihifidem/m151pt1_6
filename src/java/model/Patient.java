package model;

/**class model patients
 *@author Oscar Burgos
 *@version Marzo/2019
 */
public class Patient {
    
//atributos 
    private int idRegister;
    private int age;
    private String grupEdat;
    private int weight;
    private int height;
    private double imc;
    private String classification;
    private int manarche;
    private boolean menopause;
    private String menopauseType; 

//constructors

    public Patient() {
    }

    public Patient(int idRegister, int age, String grupEdat, int weight, int height, double imc, String classification, int manarche, boolean menopause, String menopauseType) {
        this.idRegister = idRegister;
        this.age = age;
        this.grupEdat = grupEdat;
        this.weight = weight;
        this.height = height;
        this.imc = imc;
        this.classification = classification;
        this.manarche = manarche;
        this.menopause = menopause;
        this.menopauseType = menopauseType;
    }
    
//setters&getters

    public int getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(int idRegister) {
        this.idRegister = idRegister;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrupEdat() {
        return grupEdat;
    }

    public void setGrupEdat(String grupEdat) {
        this.grupEdat = grupEdat;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getManarche() {
        return manarche;
    }

    public void setManarche(int manarche) {
        this.manarche = manarche;
    }

    public boolean getMenopause() {
        return menopause;
    }

    public void setMenopause(boolean menopause) {
        this.menopause = menopause;
    }

    public String getMenopauseType() {
        return menopauseType;
    }

    public void setMenopauseType(String menopauseType) {
        this.menopauseType = menopauseType;
    }
    
//others methods
    @Override
    public String toString(){
        return "\n"+this.idRegister+";"+this.age+";"+this.grupEdat+";"+this.weight+";"+
                this.height+";"+this.imc+";"+this.classification+";"+
                this.manarche+";"+this.menopause+";"+this.menopauseType+";";
    }
    
}