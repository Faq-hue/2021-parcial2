package info3.parcial2.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import info3.parcial2.Email;

public class FileReader {
  public static List<Email> fileReader(String path) throws IOException {
    FileInputStream fstream = new FileInputStream(path);
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

    String strLine;
    String mail = "";
    List<Email> listMail = new ArrayList<>();

    // Read File Line By Line
    while ((strLine = br.readLine()) != null) {
      
      mail += (!strLine.equals("-.-.-:-.-.-") ? strLine + "\n" : "");
      
      if (strLine.equals("-.-.-:-.-.-") && !mail.equals("")) {
        listMail.add(Converter.converted(mail));
        mail = "";
      }
      
    }
    // Close the input stream
    fstream.close();
    return listMail;
  }
}
