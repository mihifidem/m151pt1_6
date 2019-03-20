package model.persist;

import model.persist.FileDataBase;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import model.Patient;

/**
 * Clase de acceso ficheros de Pacientes
 * 
 * @author Oscar Burgos
 * @version marzo/2019
 */
public class FilePatientDAO {

    //atributo que es un objeto de DataBase
    private FileDataBase d;
    int LEN_PATIENT_ATTRIBUTS = 10;

    public FilePatientDAO() {

    }

    public FilePatientDAO(String ruta) {

        d = new FileDataBase(ruta + "/files/osteoporosi.csv");

    }

    /**
     * Añade Paciente 
     * @param p objeto patient
     * @return (devuelve int con 0 si hay problemas y 1 si es exitosa.
     */
    public int addPatient(Patient p) {

        int inserted;
        inserted = d.insertToFile(p.toString());//0->problemas, 1-> ok
        return inserted;
    }

    /**
     * Devuelve numero total de objetos en fichero
     * @return int total objetos
     */
    public int totalPatients(){
        int total=0;
        List<String> all = new ArrayList();
        all = d.listAllLines();
        total = all.size();
        return total;
    }
    
    /**
     * Lee todo el contenido del fichero patients
     * @return Listas objetos Patientss
     */
    public List readLoadData() {
        List<Patient> patients = new ArrayList<>();
        List<String> all = new ArrayList();
        Patient p;

        all = d.listAllLines();

        for (String s : all) {
            String[] pieces = s.split(";");
            p = new Patient();
            p.setIdRegister(Integer.parseInt(pieces[0]));
            p.setAge(Integer.parseInt(pieces[1]));
            p.setGrupEdat(pieces[2]);
            p.setWeight(Integer.parseInt(pieces[3]));
            p.setHeight(Integer.parseInt(pieces[4]));
            p.setImc(Double.parseDouble(pieces[5]));
            p.setClassification(pieces[6]);
            p.setManarche(Integer.parseInt(pieces[7]));
            //p.setMenopause(pieces[8]);
            p.setMenopauseType(pieces[9]);
            patients.add(p);
        }
        return patients;
    }

}
