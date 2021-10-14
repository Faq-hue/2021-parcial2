package info3.parcial2;

import java.util.*;

import info3.parcial2.util.MailReader;

public class Main {

  public static void main(String[] args) {
    List<Email> lista = new ArrayList<>();
    try {
      lista = MailReader.fileReader("src/info3/parcial2/mails/mails-20.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(lista);

  }
}
