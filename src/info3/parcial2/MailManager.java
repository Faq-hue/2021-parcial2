package info3.parcial2;

import info3.parcial2.structure.AvlTree;
import info3.parcial2.structure.LinkedList;
import info3.parcial2.structure.Pair;
import info3.parcial2.util.Insert;
import info3.parcial2.util.MailReader;

public class MailManager {
  AvlTree<Pair<String, LinkedList<Email>>> treeDate = new AvlTree<>();
  AvlTree<Pair<String, LinkedList<Email>>> treeFrom = new AvlTree<>();
  AvlTree<Pair<Long, Email>> treeId = new AvlTree<>();

  /**
   * Constructor de la clase la cual necesita el la ruta hacia el archivo que
   * contenga a los Mails
   * 
   * @param path
   * @throws Exception
   */
  MailManager(String path) {
    MailReader.fileReader(path, treeId, treeDate, treeFrom);
  }

  /**
   * Agrega un mail al gestor
   *
   * @param m mail a agregar
   * @throws Exception
   */
  public void addMail(Email m) throws Exception {
    long idTmp = treeId.findMax().getValor().getId() + 1;
    m.setId(idTmp);
    Insert.insert(m, treeId, treeDate, treeFrom);
  }

  /**
   * Elimina un mail del gestor
   *
   * @param id identificador del mail a borrar
   * @throws Exception
   */
  public void deleteMail(long id) throws Exception {
    treeId.remove(new Pair(id, null));
  }

  /**
   * Devuelve una lista de mails ordenados por fecha
   *
   * @return lista de mails ordenados
   */
  public Email[] getSortedByDate() {

    treeDate.printInorder();

    return null;
  }

  /**
   * Devuelve una lista de mails ordenados desde una fecha en adelante
   *
   * @return lista de mails ordenados
   */
  public Email[] getSortedByIniDate(String desde) {
    return new Email[0];
  }

  /**
   * Devuelve una lista de mails ordenados hasta una fecha
   *
   * @return lista de mails ordenados
   */
  public Email[] getSortedByEndDate(String hasta) {
    return new Email[0];
  }

  /**
   * Devuelve una lista de mails oredenados por fecha que estan en el rango desde
   * - hasta
   *
   * @param desde Fecha desde donde buscar
   * @param hasta Fecha hasta donde buscar
   * @return lista de mails ord-enados
   */
  public Email[] getSortedByDate(String desde, String hasta) {
    
    LinkedList<Pair<String, LinkedList<Email>>> ll = new LinkedList<>();

    for (int i = 0; i < ll.listSize(); i++) {
      
      if (desde.equals(treeDate.getList().first().getValor())) {
        ll.zeroth(treeDate.getList().getValor());
        System.out.println("Funca?");
      }

    }

    return null;
  }

  /**
   * Devuelve una lista de mails ordenados por Remitente
   *
   * @return lista de mails ordenados
   */
  public Email[] getSortedByFrom() {
    treeFrom.printInorder();
    return new Email[0];
  }

  /**
   * Devuelve una lista de mails de un determinado remitente
   *
   * @param from String con direccion del remitente
   * @return lista de mails del remitente
   */
  public Email[] getByFrom(String from) {

    Pair<String,LinkedList<Email>> pairAux = treeFrom.find(new Pair(from, null));
    LinkedList<Email> list = pairAux.getValor();
    System.out.println(list);
    return new Email[0];
  }

  /**
   * Devuelve una lista de mails que contengan las palabras de 'query' en su
   * asunto o en su contenido
   *
   * @param query String con palabra/s a buscar
   * @return lista de mails que contienen dicha/s palabra/s
   */
  public Email[] getByQuery(String query) {
    
    return new Email[0];
  }
}
