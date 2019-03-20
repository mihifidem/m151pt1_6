package model.persist;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import model.Patient;


public class PatientDAO {

    private final Properties queries;
    private static String PROPS_FILE;
    private static DBConnect dataSource;

    public PatientDAO(String ruta) throws IOException {
        queries = new Properties();
        PROPS_FILE = ruta + "/resources/patient_queries.properties";
        queries.load(new FileInputStream(PROPS_FILE));

        dataSource = DBConnect.getInstance();
    }

    public String getQuery(String queryName) {
        return queries.getProperty(queryName);
    }

    /**
     * <strong>getDataSource()</strong>
     *
     * @return object to connect to database.
     */
    public static DBConnect getDataSource() {
        return dataSource;
    }

   
     public ArrayList<Patient> findAll() {
        ArrayList<Patient> list = new ArrayList<>();
        try ( Connection conn = dataSource.getConnection();
              Statement st = conn.createStatement(); )
        {    
            ResultSet res = st.executeQuery(getQuery("FIND_ALL"));

            while (res.next()) {
                Patient pat = new Patient();
                pat.setIdRegister(res.getInt("id_register"));
                pat.setAge(res.getInt("age"));
                pat.setGrupEdat(res.getString("grupage"));
                pat.setWeight(res.getInt("weight"));
                pat.setHeight(res.getInt("height"));
                pat.setImc(res.getDouble("imc"));
                pat.setClassification(res.getString("classification"));
                pat.setManarche(res.getInt("menarche"));
                pat.setMenopause(res.getBoolean("menopause"));
                pat.setMenopauseType(res.getString("menopausetype"));
                list.add(pat);
            }
         

        } catch (SQLException e) {
            list = new ArrayList<>();
        }
        
        return list;
    }
   

   

}
