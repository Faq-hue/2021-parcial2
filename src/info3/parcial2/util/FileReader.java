package info3.parcial2.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import info3.parcial2.Email;

public class FileReader {
  public static Email[] fileReader(String path) throws FileNotFoundException {
    Scanner reed = new Scanner(new File(path));
    String mail = "";

    while (reed.hasNextLine()) {

      mail += reed.nextLine();

      System.out.println(mail);
      if (reed.nextLine().equals("-.-.-:-.-.-")) {
        //System.out.println(!mail.equals("") ? mail : "no hay nada");
      }

    }
    reed.close();
    return null;
  }
}
