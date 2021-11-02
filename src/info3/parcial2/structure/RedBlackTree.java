package info3.parcial2.structure;

// RedBlackTree class
//
// CONSTRUCTION: with no parameters
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print all items
// ******************ERRORS********************************
// Exceptions are thrown by insert if warranted and remove.

/**
 * Implements a red-black tree. Note that all "matching" is based on the
 * compareTo method.
 * 
 * @author Mark Allen Weiss
 */
public class RedBlackTree<AnyType extends Comparable<? super AnyType>> {
  /**
   * Construct the tree.
   */
  public RedBlackTree() {
    nullNode = new RedBlackNode<AnyType>(null);
    nullNode.left = nullNode.right = nullNode;
    header = new RedBlackNode<AnyType>(null);
    header.left = header.right = nullNode;
  }

  /**
   * Compare item and t.element, using compareTo, with caveat that if t is header,
   * then item is always larger. This routine is called if is possible that t is
   * header. If it is not possible for t to be header, use compareTo directly.
   */
  private final int compare(AnyType item, RedBlackNode<AnyType> t) {
    if (t == header)
      return 1;
    else
      return item.compareTo(t.element);
  }

  /**
   * Insert into the tree.
   * 
   * @param item the item to insert.
   * @throws Exception
   * @throws DuplicateItemException if item is already present.
   */
  public void insert(AnyType item) throws Exception {
    current = parent = grand = header;
    nullNode.element = item;

    while (compare(item, current) != 0) {
      great = grand;
      grand = parent;
      parent = current;
      current = compare(item, current) < 0 ? current.left : current.right;

      // Check if two red children; fix if so
      if (current.left.color == RED && current.right.color == RED)
        handleReorient(item);
    }

    // Insertion fails if already present
    if (current != nullNode)
      throw new Exception(item.toString());
    current = new RedBlackNode<AnyType>(item, nullNode, nullNode);

    // Attach to parent
    if (compare(item, parent) < 0)
      parent.left = current;
    else
      parent.right = current;
    handleReorient(item);
  }

  /**
   * Remove from the tree.
   * 
   * @param x the item to remove.
   * @throws Exception
   */
  public void remove(AnyType x) throws Exception {
    header = remove(x,header);
  }

  private RedBlackNode<AnyType> remove(AnyType x, RedBlackNode<AnyType> t) throws Exception {
    if (t == nullNode)
      return t;

    int compareResult = x.compareTo(t.element);

    if(compareResult < 0)
      t.left = remove(x, t.left);
    else if(compareResult > 0)
      t.right = remove(x, t.right);
    else if (t.left != null && t.right != null) // Two children
    {
      t.element = findMin(t.right).element;
      t.right = remove(t.element, t.right);
    } else
      t = (t.left != null) ? t.left : t.right;

    if (current.left.color == RED && current.right.color == RED)
      handleReorient(t.element);

    return t;
  }

  private RedBlackNode<AnyType> findMin(RedBlackNode<AnyType> x) {
    if (x.right == null && x.left == null)
      return null;

    RedBlackNode<AnyType> itr = x.right;

    while (itr.left != nullNode)
      itr = itr.left;

    return itr;
  }

  /**
   * Find the smallest item the tree.
   * 
   * @return the smallest item or null if empty.
   */
  public AnyType findMin() {
    if (isEmpty())
      return null;

    RedBlackNode<AnyType> itr = header.right;

    while (itr.left != nullNode)
      itr = itr.left;

    return itr.element;
  }

  /**
   * Find the largest item in the tree.
   * 
   * @return the largest item or null if empty.
   */
  public AnyType findMax() {
    if (isEmpty())
      return null;

    RedBlackNode<AnyType> itr = header.right;

    while (itr.right != nullNode)
      itr = itr.right;

    return itr.element;
  }

  /**
   * Find an item in the tree.
   * 
   * @param x the item to search for.
   * @return the matching item or null if not found.
   */
  public AnyType find(AnyType x) {
    nullNode.element = x;
    current = header.right;

    for (;;) {
      if (x.compareTo(current.element) < 0)
        current = current.left;
      else if (x.compareTo(current.element) > 0)
        current = current.right;
      else if (current != nullNode)
        return current.element;
      else
        return null;
    }
  }

  /**
   * Make the tree logically empty.
   */
  public void makeEmpty() {
    header.right = nullNode;
  }

  /**
   * Print all items.
   */
  public void printTree() {
    printTree(header.right);
  }

  /**
   * Internal method to print a subtree in sorted order.
   * 
   * @param t the node that roots the tree.
   */
  private void printTree(RedBlackNode<AnyType> t) {
    if (t != nullNode) {
      printTree(t.left);
      System.out.println(t.element);
      printTree(t.right);
    }
  }

  /**
   * Test if the tree is logically empty.
   * 
   * @return true if empty, false otherwise.
   */
  public boolean isEmpty() {
    return header.right == nullNode;
  }

  /**
   * Internal routine that is called during an insertion if a node has two red
   * children. Performs flip and rotations.
   * 
   * @param item the item being inserted.
   */
  private void handleReorient(AnyType item) {
    // Do the color flip
    current.color = RED;
    current.left.color = BLACK;
    current.right.color = BLACK;

    if (parent.color == RED) // Have to rotate
    {
      grand.color = RED;
      if ((compare(item, grand) < 0) != (compare(item, parent) < 0))
        parent = rotate(item, grand); // Start dbl rotate
      current = rotate(item, great);
      current.color = BLACK;
    }
    header.right.color = BLACK; // Make root black
  }

  /**
   * Internal routine that performs a single or double rotation. Because the
   * result is attached to the parent, there are four cases. Called by
   * handleReorient.
   * 
   * @param item   the item in handleReorient.
   * @param parent the parent of the root of the rotated subtree.
   * @return the root of the rotated subtree.
   */
  private RedBlackNode<AnyType> rotate(AnyType item, RedBlackNode<AnyType> parent) {
    if (compare(item, parent) < 0)
      return parent.left = compare(item, parent.left) < 0 ? rotateWithLeftChild(parent.left) : // LL
          rotateWithRightChild(parent.left); // LR
    else
      return parent.right = compare(item, parent.right) < 0 ? rotateWithLeftChild(parent.right) : // RL
          rotateWithRightChild(parent.right); // RR
  }

  /**
   * Rotate binary tree node with left child.
   */
  private static <AnyType> RedBlackNode<AnyType> rotateWithLeftChild(RedBlackNode<AnyType> k2) {
    RedBlackNode<AnyType> k1 = k2.left;
    k2.left = k1.right;
    k1.right = k2;
    return k1;
  }

  /**
   * Rotate binary tree node with right child.
   */
  private static <AnyType> RedBlackNode<AnyType> rotateWithRightChild(RedBlackNode<AnyType> k1) {
    RedBlackNode<AnyType> k2 = k1.right;
    k1.right = k2.left;
    k2.left = k1;
    return k2;
  }

  private static class RedBlackNode<AnyType> {
    // Constructors
    RedBlackNode(AnyType theElement) {
      this(theElement, null, null);
    }

    RedBlackNode(AnyType theElement, RedBlackNode<AnyType> lt, RedBlackNode<AnyType> rt) {
      element = theElement;
      left = lt;
      right = rt;
      color = RedBlackTree.BLACK;
    }

    AnyType element; // The data in the node
    RedBlackNode<AnyType> left; // Left child
    RedBlackNode<AnyType> right; // Right child
    int color; // Color
  }

  private RedBlackNode<AnyType> header;
  private RedBlackNode<AnyType> nullNode;

  private static final int BLACK = 1; // BLACK must be 1
  private static final int RED = 0;

  // Used in insert routine and its helpers
  private RedBlackNode<AnyType> current;
  private RedBlackNode<AnyType> parent;
  private RedBlackNode<AnyType> grand;
  private RedBlackNode<AnyType> great;

}
