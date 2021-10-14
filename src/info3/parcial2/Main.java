package info3.parcial2;

import java.util.*;

import info3.parcial2.util.FileReader;

public class Main {

  public static void main(String[] args) {
    List<Email> lista = new ArrayList<>();
    try {
      lista = FileReader.fileReader("src/info3/parcial2/mails/mails-1.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(lista);

  }
}
