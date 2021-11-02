package info3.parcial2;

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String key = "";

    while (!key.equals("8")) {
      System.out.println("\tMENU");
      System.out.println("1.Add mail");
      System.out.println("2.Delete mail");
      System.out.println("3.Get view by date");
      System.out.println("4.Get view by sender");
      System.out.println("5.Get view by destinatary");
      System.out.println("6.Search");
      System.out.println("7.Read mail file");
      System.out.println("8.Exit");

      key = scan.nextLine();
      switch (key) {
        case "1":

          break;

        case "2":

          break;

        case "3":

          break;

        case "4":

          break;

        case "5":

          break;

        default:
          System.out.println("That is not an option");
          break;
      }
    }

    scan.close();

  }
}
