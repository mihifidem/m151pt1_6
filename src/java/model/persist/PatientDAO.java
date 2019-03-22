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
import model.User;

/**
 * Conector con BBD de la clase Patient
 *
 * @author obp
 */
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

    /**
     * Leer todos los registros
     *
     * @return ArrayList de Patient
     */
    public ArrayList<Patient> findAll() {
        ArrayList<Patient> list = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
                Statement st = conn.createStatement();) {
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

    /**
     * Consulta filtro Patient
     *
     * @param p filtro
     * @return Arralist Patient result select
     */
    public ArrayList<Patient> findFilter(Patient p) {
        int rowsAffected;
        ArrayList<Patient> list = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
                PreparedStatement st = conn.prepareStatement(getQuery("FILTER"));) {

            st.setString(1, p.getClassification());
            st.setBoolean(2, p.getMenopause());
            st.setString(3, p.getMenopauseType());

            ResultSet res = st.executeQuery();

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
            rowsAffected = 0;
            list = new ArrayList<>();
        }

        return list;
    }

    /**
     * Insert objeti patient a BBDD
     * @param p objeto analir
     * @return int result 1 = ok 0=fail
     */
    public int addPatient(Patient p) {
        int rowsAffected;

        try (Connection conn = dataSource.getConnection();
                PreparedStatement pst = conn.prepareStatement(getQuery("INSERT"));) {
            pst.setInt(1, p.getAge());
            pst.setString(2, p.getGrupEdat());
            pst.setInt(3, p.getWeight());
            pst.setInt(4, p.getHeight());
            pst.setDouble(5, p.getImc());
            pst.setString(6, p.getClassification());
            pst.setInt(7, p.getManarche());
            pst.setBoolean(8, p.getMenopause());
            pst.setString(9, p.getMenopauseType());

            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = 0;
        }

        return rowsAffected;
    }

}
