package info3.parcial2.util;

import java.io.*;

import info3.parcial2.Email;

public class FileReader {
  public static Email[] fileReader(String path) throws IOException {
    FileInputStream fstream = new FileInputStream(path);
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

    String strLine;
    String mail = "";
    // Read File Line By Line
    while ((strLine = br.readLine()) != null) {
      mail += (!strLine.equals("-.-.-:-.-.-") ? strLine + "\n" : "");
      if (strLine.equals("-.-.-:-.-.-")) {

        System.out.println(mail == "" ? "nada" : mail);
        mail = "";
      }
    }
    // Close the input stream
    fstream.close();
    return null;
  }
}
