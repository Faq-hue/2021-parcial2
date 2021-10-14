package info3.parcial2;


import info3.parcial2.util.FileReader;

public class Main {

  public static void main(String[] args) {
    try {
      FileReader.fileReader("src/info3/parcial2/mails/mails-2.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
