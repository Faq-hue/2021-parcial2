package info3.parcial2.util;

import java.io.*;

import info3.parcial2.Email;
import info3.parcial2.structure.AvlTree;
import info3.parcial2.structure.Pair;

/**
 * Clase para leer los archivos donde se encuentran los mails
 */
public class MailReader {
  /**
   * Metodo que lee los arichivos donde se encuentran los mails
   * 
   * @param path
   * @return retorna una estructura de datos en la cual se encuentran contenidos
   *         los mails
   * @throws Exception
   */
  public static AvlTree<Email> fileReader(String path, AvlTree<Pair<Long, Email>> treeId,
      AvlTree<Pair<String, Email>>... trees) throws Exception {
    FileInputStream fstream = new FileInputStream(path);
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

    String strLine;
    String mail = "";
    long id = 0;

    AvlTree<Email> treeMail = new AvlTree<>();

    while ((strLine = br.readLine()) != null) {

      mail += (!strLine.equals("-.-.-:-.-.-") ? strLine + "\n" : "");

      if (strLine.equals("-.-.-:-.-.-") && !mail.equals("")) {
        Email tmp = Converter.converted(mail);
        tmp.setId(++id);

        // generacion de pares
        Pair<String, Email> pairDate = new Pair<>(tmp.getDate(), tmp);
        Pair<String, Email> pairFrom = new Pair<>(tmp.getFrom(), tmp);
        Pair<Long, Email> pairId = new Pair<>(tmp.getId(), tmp);

        // insercion de pares en los arboles
        trees[0].insert(pairDate);
        trees[1].insert(pairFrom);
        treeId.insert(pairId);

        mail = "";
      }

    }

    fstream.close();
    return treeMail;
  }
}
