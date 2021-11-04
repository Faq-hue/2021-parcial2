package info3.parcial2;

import info3.parcial2.structure.AvlTree;
import info3.parcial2.util.MailReader;

public class MailManager {
  AvlTree<Email> tree;

  /**
   * Constructor de la clase la cual necesita el la ruta
   * hacia el archivo que contenga a los Mails
   * @param path
   * @throws Exception
   */
  MailManager(String path) throws Exception{
    this.tree = MailReader.fileReader(path);
  }
  

  /**
   * Agrega un mail al gestor
   *
   * @param m mail a agregar
   * @throws Exception
   */
  public void addMail(Email m) throws Exception {
    tree.insert(m);
  }

  /**
   * Elimina un mail del gestor
   *
   * @param id identificador del mail a borrar
   * @throws Exception
   */
  public void deleteMail(long id) throws Exception {
    Email aux = new Email();
    // TODO meter mas cosas, explicito
    aux.setId(id);
    tree.remove(aux);
  }

  /**
   * Devuelve una lista de mails ordenados por fecha
   *
   * @return lista de mails ordenados
   */
  public Email[] getSortedByDate() {
    return new Email[0];
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

    return new Email[0];
  }

  /**
   * Devuelve una lista de mails ordenados por Remitente
   *
   * @return lista de mails ordenados
   */
  public Email[] getSortedByFrom() {
    return new Email[0];
  }

  /**
   * Devuelve una lista de mails de un determinado remitente
   *
   * @param from String con direccion del remitente
   * @return lista de mails del remitente
   */
  public Email[] getByFrom(String from) {
    
    

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
    Email aux = new Email();
    aux.setSubject(query);
    aux.setDate(query);
    aux.setFrom(query);
    aux.setTo(query);

    tree.find(aux);
    return new Email[0];
  }
}
