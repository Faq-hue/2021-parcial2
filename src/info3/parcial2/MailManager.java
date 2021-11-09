package info3.parcial2;

import info3.parcial2.structure.*;
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

    this.treeDate.printInorder();

    return null;
  }

  /**
   * Devuelve una lista de mails ordenados desde una fecha en adelante
   *
   * @return lista de mails ordenados
   */
  public Email[] getSortedByIniDate(String desde) {

    LinkedList<Email> list = new LinkedList<>();

    getSortedByIniDate(treeId.getRoot(), desde, list);

    return new Email[0];
  }

  private void getSortedByIniDate(AvlNode<Pair<Long, Email>> node, String desde, LinkedList<Email> list){

    if (node == null) return;

    // Recurcion en el hijo izquierdo
    getSortedByIniDate(node.left,desde,list);

    // inserto los nodos a la lista si la date es mayor al desde
    if(node.element.getValor().getDate().compareTo(desde) >= 0 ){
      list.insert(node.element.getValor(),list.zeroth());
    }

    // Recurcion en el hijo izquierdo
    getSortedByIniDate(node.right,desde,list);

  }

  /**
   * Devuelve una lista de mails ordenados hasta una fecha
   *
   * @return lista de mails ordenados
   */
  public Email[] getSortedByEndDate(String hasta) {

    LinkedList<Email> list = new LinkedList<>();

    getSortedByEndDate(treeId.getRoot(), hasta, list);

    return new Email[0];
  }

  private void getSortedByEndDate(AvlNode<Pair<Long, Email>> node, String hasta, LinkedList<Email> list){

    if (node == null) return;

    // Recurcion en el hijo izquierdo
    getSortedByIniDate(node.left,hasta,list);

    // inserto los nodos a la lista si la date es mayor al desde
    if(node.element.getValor().getDate().compareTo(hasta) <= 0 ){
      list.insert(node.element.getValor(),list.zeroth());
    }

    // Recurcion en el hijo izquierdo
    getSortedByIniDate(node.right,hasta,list);

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

    LinkedList<Email> list = new LinkedList<>();

    getSortedByDate2(treeId.getRoot(), desde, hasta, list);

    LinkedList.printList(list);

    return null;
  }

  private void getSortedByDate2(AvlNode<Pair<Long, Email>> node, String desde, String hasta, LinkedList<Email> list){
    if (node == null) return;

    // Recurcion en el hijo izquierdo
    getSortedByDate2(node.left,desde,hasta,list);

    // inserto los nodos a la lista si la date se encuentra entre desde y hasta
    if(node.element.getValor().getDate().compareTo(desde) >= 0 && node.element.getValor().getDate().compareTo(hasta) <= 0){
      list.insert(node.element.getValor(),list.zeroth());
    }

    // Recurcion en el hijo izquierdo
    getSortedByDate2(node.right,desde,hasta,list);

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
    LinkedList.printList(list);
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
    LinkedList<Email> list = new LinkedList<>();
    recorrido(treeId.getRoot(),query,list);
    LinkedList.printList(list);
    return new Email[0];
  }

  public void recorrido(AvlNode<Pair<Long, Email>> node, String query, LinkedList<Email> list){
    if (node == null)
      return;

    // Recurcion en el hijo izquierdo
    recorrido(node.left,query,list);

    // inserto los nodos a la lista si la query se encuentra en el contenido o en el asunto
    if(node.element.getValor().getContent().contains(query) || node.element.getValor().getSubject().contains(query)){
      list.insert(node.element.getValor(),list.zeroth());
    }

    // Recurcion en el hijo izquierdo
    recorrido(node.right,query,list);
  }
}
