package info3.parcial2.util;

import java.io.*;

import info3.parcial2.Email;
import info3.parcial2.structure.RedBlackTree;

/**
 * Clase para leer los archivos donde se encuentran los mails
 */
public class MailReader {
  /**
   * Metodo que lee los arichivos donde se encuentran los mails
   * 
   * @param path
   * @return retorna una estructura de datos en la cual se encuentran contenidos los mails
   * @throws Exception
   */
  public static RedBlackTree<Email> fileReader(String path) throws Exception {
    FileInputStream fstream = new FileInputStream(path);
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

    String strLine;
    String mail = "";

    RedBlackTree<Email> treeMail = new RedBlackTree<>();
    
    while ((strLine = br.readLine()) != null) {
      
      mail += (!strLine.equals("-.-.-:-.-.-") ? strLine + "\n" : "");
      
      if (strLine.equals("-.-.-:-.-.-") && !mail.equals("")) {
        treeMail.insert(Converter.converted(mail));
        mail = "";
      }
      
    }
    
    fstream.close();
    return treeMail;
  }
}
