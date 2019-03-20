package model.persist;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Clase DataBase acceso a fichero
 * 
 * @author Oscar Burgos
 */
public class FileDataBase {
    
//atributs
    private String fileName;
   
//constructor
    public FileDataBase(String fileName) {
        this.fileName = fileName;
       
    }
//accesores
    public String getFileName() {
        return fileName;
    }

   

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
//metode per escriure a fitxer
    public int insertToFile(String inputText){
        //DINS DE DATABASE
        File outputFile=null;
        FileWriter fout=null;
        int i=0;
            try
            {
                outputFile = new File(this.fileName);
                fout = new FileWriter(outputFile, true);
                fout.write(inputText);
                i=1;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                   if (fout != null)
                    fout.close();
              } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            }
          return i; 
    }
    
//mètode per llegir de fitxer
    public ArrayList listAllLines(){
        ArrayList all=new ArrayList(); 
        
        try{

            FileInputStream fstream = new FileInputStream(this.fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;


            while ((strLine = br.readLine()) != null) {

                    all.add(strLine);

            }

            in.close();

            }catch (Exception e){


               System.out.println(e.getMessage());

            }
            
        
        return all;
    }
    
    
}