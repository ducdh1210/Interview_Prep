package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Implements an unbalanced binary search tree.
 */
public class MyTree<T extends Comparable<T>> {
    Node<T> root;
    
    /**
     * Construct the tree.
     */
    public MyTree(T elem) {
        root = new Node<T>(elem,null,null);
    }
    
    /**
     * Insert into the tree.
     * @param elem is the item to insert.
     * @throws IllegalArgumentException if elem is already present.
     */
    public void add(T elem) {
        Node<T> node = new Node<T>(elem,null,null);
        insertNode(root,node);
    }
    
     /**
     * Internal method to insert into a subtree.
     * @param subTree is the subtree.
     * @param newNode is the new node to be inserted.
     * @return the new subtree.
     * @throws IllegalArgumentException if newNode is already present.
     */
    private Node<T> insertNode(Node<T> subTree, Node<T> newNode) {
        
        if (subTree == null) {
            subTree = newNode;
        } else if ((subTree.elem).compareTo(newNode.elem) < 0){
                subTree.rightChild = insertNode(subTree.rightChild, newNode);
        } else if ((subTree.elem).compareTo(newNode.elem) > 0){
                subTree.leftChild = insertNode(subTree.leftChild, newNode);
        } else {
            throw 
                new IllegalArgumentException("Duplicate Element " + newNode.elem);
        }
        return subTree;
    }
    
    /**
     * Remove from the tree.
     * @param item is the item to remove.
     * @throws IllegalArgumentException if item is not found.
     */
    public void delete(T item) {
        this.deleteNode(root,item);
    }
    
     /**
     * Internal method to delete a node.
     * @param subtree is the subtree.
     * @param item is the item to be deleted.
     * @return the new subtree.
     * @throws IllegalArgumentException if the item is not present.
     */
    private Node<T> deleteNode(Node<T> subtree,  T item) {
        //Search for the node first 
        if (subtree != null) {
            if ((subtree.elem).compareTo(item) < 0) {
                subtree.rightChild = deleteNode(subtree.rightChild, item);
            } else if ((subtree.elem).compareTo(item) > 0) {
                subtree.leftChild = deleteNode(subtree.leftChild, item);
            } else {
                /* Found a match.
                 * There are 3 possibilities:
                 * Node is leaf: 
                 *     Easy, Just delete the node but this is implicitly
                 * handled as part of node has 1 child (see below)
                 * Node has 1 child: 
                 *     Delete the node and put the child node in its place
                 * Node has 2 children: 
                 *     Find the leftmost child in the right subtree, 
                 *     replace the node to be deleted with this child.
                 *     Then delete that child node.
                 */
                if ((subtree.leftChild != null) && (subtree.rightChild != null)) {
                    //Node has 2 children
                    //Find the leftmost child of the right subtree and
                    //make it the current node, then delete the
                    //leftmost child of the right subtree
                    Node<T> node = findLeftmostChild(subtree.rightChild);
                    subtree.elem = node.elem;
                    subtree.rightChild = deleteNode(subtree.rightChild,node.elem);
                } else if (subtree.leftChild != null) {
                    //Node has only 1 child i.e. left child
                    subtree = subtree.leftChild;
                } else {
                    //Node can either have no children or just have 1 right child
                    subtree = subtree.rightChild;    
                }
            }
            
        } else{
            //No match
            throw new IllegalArgumentException("No such element");
        }
        return subtree;
    }
    
    /**
     * Internal method to find the leftmost child.
     * @param subtree is the subtree.
     * @return the leftmost child.
     */
    private Node<T> findLeftmostChild(Node<T> subtree){
        assert (subtree != null);
        while (subtree.leftChild != null) {
            subtree = subtree.leftChild;
        }
        return subtree;
    }
    
    /**
     * Method to traverse the tree in depth first order.
     * @return the List of elements in the tree in depth first order.
     */
    public List<T> depthFirstTraversal() {
        List<T> l = new ArrayList<T>();
        Stack<Node<T>> s = new Stack<Node<T>>();
        s.push(root);
        while (!s.isEmpty()){
            Node<T> node = s.pop();
            l.add(node.elem);
            if (node.rightChild != null) {
                s.push(node.rightChild);
            }
            if (node.leftChild != null) {
                s.push(node.leftChild);
            }
        }
        return l;
    }
    
    /**
     * Method to traverse the tree in preorder, postOrder, and inOrder fashion by recursion.
     * @return print the traversal signature 
     */
    
    private void preOrder(Node<T> root)
    {
     
      if(root == null) return;
      
      System.out.print(root.elem + " ");
      
      preOrder( root.leftChild );
      preOrder( root.rightChild ); 
      
    }
    
    private void postOrder(Node<T> root)
    {
      if(root == null) return;
      postOrder( root.leftChild );
      postOrder( root.rightChild );
      System.out.print(root.elem + " ");
    }
    
    private void inOrder (Node<T> root)
    {
      if(root == null) return;
      inOrder( root.leftChild );
      System.out.print(root.elem + " ");
      inOrder( root.rightChild );
    }
    
    /**
     * Method to find the depth of a node
     * @return print the traversal signature 
     */
    
    public int maxDepth(Node<T> node){
    	if (node == null){
    		return 0;
    	}else{
    		// compute the depth of each subtree
    		int left_Depth = maxDepth(node.getLeftChild());
    		int right_Depth = maxDepth(node.getRightChild());
    		
    		if (left_Depth > right_Depth) return (left_Depth+1);
    		else return (right_Depth+1);
    	}
    }
    
    /**
     * Method to traverse the tree in breadth first order
     * @return the List of elements in the tree in breadth first order.
     */
    public List<T> breadthFirstTraversal() {
        List<T> l = new ArrayList<T>();
        Queue<Node<T>> q = new LinkedList<Node<T>>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<T> node = q.poll();
            l.add(node.elem);
            if (node.leftChild != null) {
                q.add(node.leftChild);
            } 
            if (node.rightChild != null) {
                q.add(node.rightChild);
            }
        }
        return l;
    }
    
    /**
     * Method to find an item in a subtree.
     * @param item is item to search for.
     * @return node containing the matched item.
     */
    public Node<T> findNode(T item) {
        if (item == null) return null;
        Node<T> current = root;
        while ((current.elem).compareTo(item) != 0) {
            if ((current.elem).compareTo(item) > 0) {
                current = current.leftChild;
            } else if ((current.elem).compareTo(item) < 0) {
                current = current.rightChild;
            }
            if (current == null) return null;
        }
        return current;
    }

    /**
     * @return the List of elements in the tree which are parents of two Roman nodes
     */
    public void listOfParentsOfTwoRomanNodesButNotRoman(Node<T> node, List<T> list) {
        if(node == null) return;

        if (this.isParentOfTwoRomanNodeButNotRoman(node)){
            list.add(node.elem);
            System.out.println(node.elem);
        }

        preOrder( root.leftChild );
        preOrder( root.rightChild );
    }

    /**
     * Find Roman node. Roman node is a whose size of left subtree differs from size of right subtree
     * no different than 5
     * @param node
     * @return if the node is Roman or not
     */

    public boolean isParentOfTwoRomanNodeButNotRoman(Node<T> node){
        if (this.isRomanNode(node.getRightChild()) && this.isRomanNode(node.getLeftChild()) && !this.isRomanNode(node) ){
            return true;
        }else return false;
    }

    public boolean isRomanNode(Node<T> subtree){
        if (subtree == null){
            return false;
        }
        boolean found = false;
        int sizeLeft = 0;
        int sizeRight = 0;

        Node<T> leftSubtree = subtree.getLeftChild();
        Node<T> rightSubtree = subtree.getRightChild();

        /* need to find size of leftSubtree and rightSubtree */
        if (leftSubtree != null) {
            sizeLeft = this.getSizeOfTree(leftSubtree);
        }
        if (rightSubtree!= null){
            sizeRight = this.getSizeOfTree(rightSubtree);
        }

        /* Condition 1 at least one of two subtree is not null and Condition 2 for roman node */
        if ( (sizeLeft + sizeRight > 0) & Math.abs(sizeLeft - sizeRight) < 6){
            found = true;
        }

        return found;
    }

    public int getSizeOfTree(Node<T> node){
        /*The idea here is that size of a subtree whose node is parent node
        * is equal to size of (left subtree + size of right subtree + 1) */

        if (node == null) return 0;

        int sizeLeft = getSizeOfTree(node.getLeftChild());
        int sizeRight = getSizeOfTree(node.getRightChild());

        return (sizeLeft + sizeRight + 1); // "1" is account for the node itself.
    }
    
    //Test it
    public static void main(String[] args) {
        MyTree<Integer> tree = new MyTree<Integer>(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(14);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(13);
        tree.add(17);
        tree.add(18);

        List<Integer> l = tree.depthFirstTraversal();
        //System.out.println("Depth First Order");
       // printTree(l);
         
        // print traversal singnature
         tree.preOrder(tree.root); System.out.println();
         tree.postOrder(tree.root); System.out.println();
         tree.inOrder(tree.root);System.out.println();
         
        // depth of a tree
         System.out.println("Max Depth: " + tree.maxDepth(tree.root));
        
//        l = tree.breadthFirstTraversal();
//        System.out.println("Breadth First Order");
//        printTree(l);
        
//        tree.delete(10);
//        System.out.println("Tree after deleting a node");
//        l = tree.depthFirstTraversal();
//        printTree(l);
         
//     	MyTree<Movie> tree = new MyTree<Movie>(new Movie("","","",8));
//       //tree.add(30);
//      tree.add(new Movie("","","",3));
//      tree.add(new Movie("","","",10));
//      tree.add(new Movie("","","",1));
//      tree.add(new Movie("","","",14));
//      tree.add(new Movie("","","",6));
//      tree.add(new Movie("","","",4));
//      tree.add(new Movie("","","",7));
//      tree.add(new Movie("","","",13));
    }
    
    //Method to print tree
    public static <T> void printTree(List<T> l) {
        for(T i: l) {
            System.out.println(i);
        }
    }

}

/**
 * Basic node stored in binary search trees
 */
class Node<T extends Comparable<T>>{
    T elem;
    Node<T> leftChild;
    Node<T> rightChild;
    
    public Node(T elem, Node<T> left, Node<T> right){
        this.elem = elem;
        leftChild = left;
        rightChild = right;
    }
    
    public Node<T> getLeftChild(){
    	return leftChild;
    }
    
    public Node<T> getRightChild(){
    	return rightChild;
    }
}