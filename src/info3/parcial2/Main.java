package info3.parcial2;

import java.time.LocalDateTime;
import java.util.Scanner;

import info3.parcial2.structure.LinkedList;

public class Main {

  public static void main(String[] args) {
    /*
     * // Test N8 angelo System.out.println("Test N8 angelo"); LinkedList<Integer>
     * list = new LinkedList<>(); list.insert(1,list.zeroth()); list.insert(2,
     * list.zeroth()); list.insert(3, list.zeroth());
     * 
     * Integer[] array = new Integer[LinkedList.listSize(list)];
     * list.toArray(list,array);
     * 
     * for (Integer number : array) { System.out.println(number); }
     */

    /*
     * //Test N7 faq MailManager mn = new MailManager("");
     * 
     * mn.getSortedByDate("2013-08-13 00:14","2013-08-13 00:14");
     * 
     */
    /*
     * // Test N6 MailManager mn = new
     * MailManager("src/info3/parcial2/mails/mails-20.txt");
     * mn.getByFrom("t---@grulic.psi.unc.edu.ar"); //mn.getByQuery("maestro");
     * 
     * 
     * /* // Test N5 AvlTree<Integer> tree = new AvlTree<>(); tree.insert(5);
     * Integer prueba = tree.find(5); System.out.println(prueba); /* /* // Test N4
     * 
     * MailManager mn= new MailManager("src/info3/parcial2/mails/mails-20.txt");
     * 
     * mn.getSortedByDate();
     */
    /*
     * // Test N3
     * 
     * AvlTree<Integer> tree = new AvlTree<>();
     * 
     * tree.insert(2); tree.print(); tree.remove(2); tree.print();
     */
    // Test N2
    // MailManager mn = new MailManager("src/info3/parcial2/mails/mails-2-alt.txt");

    /*
     * test N1 AvlTree<Integer> tree = new AvlTree<Integer>(); try { tree.insert(5);
     * tree.insert(3); tree.insert(7); tree.insert(2); tree.printTree();
     * tree.remove(3); tree.printTree(); } catch (Exception e) {
     * e.printStackTrace(); }
     */

    try {
      MailManager mailManager = new MailManager("src/info3/parcial2/mails/mails-1.txt");
      Scanner scan = new Scanner(System.in);
      String key = "";
      while (!key.equals("11")) {
        System.out.println("-------------MENU---------------");
        System.out.println("|   1.Add mail                 |");
        System.out.println("|   2.Delete mail              |");
        System.out.println("|   3.Get view by date         |");
        System.out.println("|   4.Get view by sender       |");
        System.out.println("|   5.Get view by destinatary  |");
        System.out.println("|   6.Search                   |");
        System.out.println("|   7.Search                   |");
        System.out.println("|   8.Search sender            |");
        System.out.println("|   9.filter by date           |");
        System.out.println("|   11.Exit                    |");
        System.out.println("--------------------------------");
        System.out.print("| selection:");
        key = scan.nextLine();
        switch (key) {
        case "1":
          Email mail = new Email();
          System.out.println("Enter the sender: ");
          mail.setFrom(scan.nextLine());
          System.out.println("Enter the destinatary: ");
          mail.setTo(scan.nextLine());
          System.out.println("Enter the subject: ");
          mail.setSubject(scan.nextLine());
          System.out.println("Enter the body: ");
          mail.setContent(scan.nextLine());
          mail.setDate(LocalDateTime.now().toString());
          mailManager.addMail(mail);
          System.out.println(mail);
          break;

        case "2":
          System.out.println("Enter the id of the mail to delete: ");
          long id = scan.nextInt();
          mailManager.deleteMail(id);
          break;

        case "3":

          break;

        case "4":

          break;

        case "5":
          Email[] emails = mailManager.getSortedByFrom();
          System.out.println(emails[0]);
          break;
        case "6":

          break;
        case "7":

          break;
        case "8":
          System.out.println("Enter the word to search: ");
          mailManager.getByQuery(scan.nextLine());
          break;

        default:
          System.out.println("That is not an option");
          break;
        }
      }

      scan.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
