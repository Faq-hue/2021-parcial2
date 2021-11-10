package info3.parcial2;

import java.time.LocalDateTime;
import java.util.Scanner;

import info3.parcial2.structure.LinkedList;

public class Main {

  public static void main(String[] args) {

    try {
      MailManager mailManager = new MailManager("src/info3/parcial2/mails/mails-1.txt");
      Scanner scan = new Scanner(System.in);
      String key = "";
      while (!key.equals("11")) {
        System.out.println("-------------MENU---------------");
        System.out.println("|   1.Add mail                 |");
        System.out.println("|   2.Delete mail              |");
        System.out.println("|   3.Get mails sorted by date |");
        System.out.println("|   4.Get mails from a date    |");
        System.out.println("|   5.Get mails up to a date   |");
        System.out.println("|   6.Get mails from one date  |");
        System.out.println("|       to another date        | ");
        System.out.println("|   7.Get mails sorted by from |");
        System.out.println("|   8.Get mails from a sender  |");
        System.out.println("|   9.Get mails from by a query|");
        System.out.println("|   10.Exit                    |");
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
          Email [] emails3 = mailManager.getSortedByDate();

          for (int i = 0; i < emails3.length; i++) {
            System.out.println(emails3[i]);
          }
          break;

        case "4":
          System.out.println("Enter the initial date of the mails in the following format: \"2017-05-21 09:42\"");
          Email [] emails4 = mailManager.getSortedByIniDate(scan.nextLine());

          for (int i = 0; i < emails4.length; i++) {
            System.out.println(emails4[i]);
          }

          break;

        case "5":
          System.out.println("Enter the end date of the mails in the following format: \"2017-05-21 09:42\"");

          Email [] emails5 = mailManager.getSortedByEndDate(scan.nextLine());

          for (int i = 0; i < emails5.length; i++) {
            System.out.println(emails5[i]);
          }

          break;

        case "6":

          System.out.println("Enter the initial date of the mails in the following format: \"2017-05-21 09:42\"");
          String init = scan.nextLine();

          System.out.println("Enter the end date of the mails in the following format: \"2017-05-21 09:42\"");
          String end = scan.nextLine();

          Email [] emails6 = mailManager.getSortedByDate(init, end);

          for (int i = 0; i < emails6.length; i++) {
            System.out.println(emails6[i]);
          }

          break;

        case "7":
          Email[] emails7 = mailManager.getSortedByFrom();

          for (int i = 0; i < emails7.length; i++) {
            System.out.println(emails7[i]);
          }

          break;
        case "8":
          System.out.println("Enter the sender adress Ej: \"britosl---@gmail.com\"");

          Email[] emails8 = mailManager.getByFrom(scan.nextLine());

          for (int i = 0; i < emails8.length; i++) {
            System.out.println(emails8[i]);
          }

          break;

        case "9":
          System.out.println("Enter the query: ");

          Email[] emails9 = mailManager.getByQuery(scan.nextLine());

          for (int i = 0; i < emails9.length; i++) {
            System.out.println(emails9[i]);
          }
          break;

          case "10": break;


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
