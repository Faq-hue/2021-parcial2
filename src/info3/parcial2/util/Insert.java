package info3.parcial2.util;

import info3.parcial2.structure.*;
import info3.parcial2.*;

public class Insert {
  public static void insert(Email email, AvlTree<Pair<Long, Email>> treeId,
      AvlTree<Pair<String, LinkedList<Email>>>... trees) {
    LinkedList<Email> list = new LinkedList<>();
    list.insert(email, list.zeroth());

    // generacion de pares
    Pair<String, LinkedList<Email>> pairDate = new Pair<>(email.getDate(), list);
    Pair<String, LinkedList<Email>> pairFrom = new Pair<>(email.getFrom(), list);
    Pair<Long, Email> pairId = new Pair<>(email.getId(), email);

    // insercion de pares en los arboles
    Pair<String, LinkedList<Email>> tmp = trees[0].find(pairDate);
    if (tmp != null) {
      tmp.getValor().insert(email, tmp.getValor().zeroth());
    } else {
      trees[0].insert(pairDate);
    }

    tmp = trees[1].find(pairFrom);
    if (tmp != null) {
      tmp.getValor().insert(email, tmp.getValor().zeroth());
    } else {
      trees[1].insert(pairFrom);
    }

    treeId.insert(pairId);
  }
}
