package info3.parcial2.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import info3.parcial2.Email;

/**
 * Clase para leer los archivos donde se encuentran los mails
 */
public class MailReader {
  /**
   * Metodo que lee los arichivos donde se encuentran los mails
   * 
   * @param path
   * @return retorna una estructura de datos en la cual se encuentran contenidos los mails
   * @throws IOException
   */
  public static List<Email> fileReader(String path) throws IOException {
    FileInputStream fstream = new FileInputStream(path);
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

    String strLine;
    String mail = "";

    // TODO cambiar el array list por la estructura de datos correspondiente
    List<Email> listMail = new ArrayList<>();

    
    while ((strLine = br.readLine()) != null) {
      
      mail += (!strLine.equals("-.-.-:-.-.-") ? strLine + "\n" : "");
      
      if (strLine.equals("-.-.-:-.-.-") && !mail.equals("")) {
        listMail.add(Converter.converted(mail));
        mail = "";
      }
      
    }
    
    fstream.close();
    return listMail;
  }
}
