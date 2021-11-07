package info3.parcial2;

import info3.parcial2.structure.AvlTree;

public class Main {

  public static void main(String[] args) {
    // Test N6
    MailManager mn = new MailManager("src/info3/parcial2/mails/mails-20.txt");
    mn.getByFrom("t---@grulic.psi.unc.edu.ar");
    //mn.getByQuery("maestro");


    /*
    // Test N5
    AvlTree<Integer> tree = new AvlTree<>();
    tree.insert(5);
    Integer prueba = tree.find(5);
    System.out.println(prueba);
/*
    /*    
    // Test N4

    MailManager mn= new MailManager("src/info3/parcial2/mails/mails-20.txt");
    
    mn.getSortedByDate();
*/
/*
    // Test N3

    AvlTree<Integer> tree = new AvlTree<>();
    
    tree.insert(2);
    tree.print();
    tree.remove(2);
    tree.print();  
  */  
    // Test N2
    //MailManager mn = new MailManager("src/info3/parcial2/mails/mails-2-alt.txt");
      



    /*  test N1
     AvlTree<Integer> tree = new AvlTree<Integer>();
       try {
      tree.insert(5);
      tree.insert(3);
      tree.insert(7);
      tree.insert(2);
      tree.printTree();
      tree.remove(3);
      tree.printTree();
    } catch (Exception e) {
      e.printStackTrace();
    }
     */
  
      
  
    /*  try {
      MailManager mailManager = new MailManager("src/info3/parcial2/mails/mails-1.txt");
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
        System.out.println("8.Exit");

        key = scan.nextLine();
        switch (key) {
        case "1":

          break;

        case "2":
          System.out.println("----Toy Aca----");
          System.out.println(id);
          mailManager.deleteMail(id);
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

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
*/
  }
}
