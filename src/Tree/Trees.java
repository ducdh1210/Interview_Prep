package Tree;

import java.util.*;

public class Trees {

	public static void main(String[] args) {
		BSTree<Integer> tree = new BSTree<Integer>();
		
		tree.iterativeAdd(7);
		tree.iterativeAdd(9);
		tree.iterativeAdd(5);
		tree.iterativeAdd(2);
		tree.iterativeAdd(6);	
		tree.iterativeAdd(8);	
		tree.iterativeAdd(12);	
		tree.iterativeAdd(1);	
		tree.iterativeAdd(4);	
		tree.iterativeAdd(10);	
		tree.print();

        Set<Integer> set = new TreeSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator<Integer> iterator = set.iterator();
        System.out.println(iterator.next());
        while(iterator.hasNext()){
            Integer intObj = iterator.next();
            if (intObj == 2){
                System.out.println("found");
            }
        }
		//System.out.println("Number: \n" + tree.getCountGreatThan(2));
		
//		tree.iterativeRemove(7);
//		tree.iterativeRemove(8);
//		tree.iterativeRemove(9);
//		//tree.iterativeRemove(2);
//		tree.iterativeRemove(5);
//		//tree.iterativeRemove(7);
//		
//		System.out.println("New tree:");
//		//Iterator<Integer> it = tree.getIterator();
//		//while(it.hasNext()){
//			//System.out.print(it.next() + "  ");
//		//}
//		tree.print();
		
	}

	

}

class BSTree<T> implements Iterator<T>{
	BSTNode<T> root;
	BSTNode<T> currentNode;
	int numItems;
	Queue<T> tempStorage;
	ArrayList<T> arrayStorage = new ArrayList<T>(100);
	
	public BSTree() {
		root = null;
		numItems = 0;
	}
	
	private void inorderRetrieve(BSTNode<T> cursor){
		if(cursor == null) return;
		inorderRetrieve(cursor.getLeft());
		//tempStorage.offer(cursor.getInfo());
		inorderRetrieve(cursor.getRight());
	}
	
	@SuppressWarnings("unchecked")
	public void iterativeRemove(T item){
		BSTNode<T> cursor = root, precursor = null;
		if(root == null) return;
		while( !cursor.getInfo().equals(item) ){
			precursor = cursor;
			if( ((Comparable<T>)cursor.getInfo()).compareTo(item) < 0 )
				cursor = cursor.getRight();
			else cursor = cursor.getLeft();	
		}
		
		if(cursor.getLeft() == null && cursor.getRight() == null){
			if(precursor == null) { root = null; }
			else{
				if( ((Comparable<T>)cursor.getInfo()).compareTo(precursor.getInfo() ) < 0 )
					precursor.setLeft(null);
				else precursor.setRight(null);	
			}
		}
		else if( cursor.getLeft() == null ){
			if(precursor == null){
				root = cursor.getRight();
			}
			else{
				if( ((Comparable<T>)cursor.getRight().getInfo()).compareTo(precursor.getInfo() ) < 0 )
					precursor.setLeft(cursor.getRight());
				else precursor.setRight(cursor.getRight());
			}				
		}
		else if( cursor.getRight() == null ){
			if(precursor == null){
				root = cursor.getLeft();
			}
			else{
				if( ((Comparable<T>)cursor.getLeft().getInfo()).compareTo(precursor.getInfo() ) < 0 )
					precursor.setLeft(cursor.getLeft());
				else
					precursor.setRight(cursor.getLeft());
			}
		}
		else{
			T replacement = getAndRemovePredecessor(cursor);
			cursor.setInfo(replacement);
		}	
		numItems--;
	}
	
	/*public boolean recContains (String title, MovieNode root)	
	{
		MovieNode cursor = root;
		if (root == null)
			return false;
		else if (cursor.getMovie().getTitle().compareToIgnoreCase(title) > 0)
			return recContains(title, cursor.getLeft());
		else if (cursor.getMovie().getTitle().compareToIgnoreCase(title) < 0)
			return recContains(title, cursor.getRight());
		else 
			currentMovieNode = cursor;
			return true;
	}*/
	
	@SuppressWarnings("unchecked")
	public boolean recContains (T nodeInfo, BSTNode<T> root)	
	{
		BSTNode<T> cursor = root;
		if (root == null)
			return false;
		else if (((Comparable<T>)cursor.getInfo()).compareTo(nodeInfo) > 0)
			return recContains(nodeInfo, cursor.getLeft());
		else if (((Comparable<T>)cursor.getInfo()).compareTo(nodeInfo) < 0)
			return  recContains(nodeInfo, cursor.getRight());
		else 
			currentNode = cursor;
			return true;
	}
	
	public boolean contains (T nodeInfo){
		return recContains (nodeInfo, root);
	}
	
	public boolean isAncestorDescendantRelation(T anc, T des)
	{
		if (recContains (anc, root)) // if there exists the anc node 
		{
			// now currentNode is pointing to anc, thus we check if des node is a child or grandchild of anc node 
			return recContains (des, currentNode);
		}
		return false;
	}
	
	public int getNumSignleChildNode()
	{
		return getNumOfOneChildNode(root);
	}
	
	public int getNumOfOneChildNode(BSTNode<T> tree)
	{
		//base case
		if (tree == null)
			return 0;
		// when a node has only right child
		else if ((tree.getRight() != null) && (tree.getLeft() == null) )
		{
			return (1 + getNumOfOneChildNode(tree.getRight()));			
		}
		// when a node has only left child
		else if ((tree.getLeft() != null) && (tree.getRight() == null) )
		{
			return (1 + getNumOfOneChildNode(tree.getLeft()));			
		}
		// when a node has 2 children
		return ( getNumOfOneChildNode(tree.getLeft()) + getNumOfOneChildNode(tree.getLeft()) );				
	}
	
	public T getMax()
	// return the maximum T (info) in the tree
	{
		BSTNode<T> cursor = root;
		while (cursor.getLeft() != null) 
		{
			cursor = cursor.getLeft();
		}
		return cursor.getInfo();
	}
	
	@SuppressWarnings("unused")
	private void postOrder(BSTNode<T> tree)
	  // Initializes postOrderQueue with tree elements in postOrder order.
	  {
	    if (tree != null)
	    {
	      postOrder(tree.getLeft());
	      postOrder(tree.getRight());
	      arrayStorage.add(tree.getInfo());	      
	    }
	  }
	
	public int countGreaterThan(T item)
	{
		int indexOfItem = arrayStorage.lastIndexOf(item);
		return arrayStorage.size() - 1 - indexOfItem;
	}
	
	public int getCountGreatThan(BSTNode<T> tree)
	{
		if (tree == currentNode && tree == null)
			return 0;
		else 
		{ 
		    return(getCountGreatThan(tree.getLeft()) + 1 + getCountGreatThan(tree.getRight())); 
	    } 	
		
	}
	
	
	private T getAndRemovePredecessor(BSTNode<T> start){
		T temp;
		if( start.getLeft().getRight() == null )
		{
			temp = start.getLeft().getInfo();
			start.setLeft(start.getLeft().getLeft());
			return temp;
		}
		else
		{
			BSTNode<T> cursor = start.getLeft(), precursor = null;
			while(cursor.getRight() != null)
			{
				precursor = cursor;
				cursor = cursor.getRight();
			}				
			precursor.setRight(null);
			return cursor.getInfo();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void iterativeAdd(T item)
	{
		BSTNode<T> newNode = new BSTNode<T>(item);
		
		if(root == null)
		{
			root = newNode; numItems++;
			return;
		}
		
		BSTNode<T> cursor = root, precursor = null;
		while( cursor != null)
		{
			precursor = cursor;
			if( ((Comparable<T>)cursor.getInfo()).compareTo(item) < 0 )
				cursor = cursor.getRight();
			else cursor = cursor.getLeft();			
		}
		
		if( ((Comparable<T>)precursor.getInfo()).compareTo(item) > 0)
			precursor.setLeft(newNode);
		else precursor.setRight(newNode);
		numItems++;
	}
	
	private void recPrint(BSTNode<T> cursor, int depth){
	    if(cursor != null){
	      recPrint(cursor.getRight(), depth+1);
		      for(int i = 1; i <= 4*depth; i++)
		        System.out.print(" ");
		      System.out.println(cursor.getInfo());
	      recPrint(cursor.getLeft(), depth+1);
	    }
	}
	  
	public void print(){
	    recPrint(root, 0);
	}
	
	public Iterator<T> getIterator(){
		tempStorage = new LinkedList<T>();
		inorderRetrieve(root);
		return this;
	}

	@Override
	public boolean hasNext() {
		return !tempStorage.isEmpty();
	}

	@Override
	public T next() {
		return tempStorage.poll();
	}

	@Override
	public void remove() {}
}



class BSTNode<T> {
	private T info;
	private BSTNode<T> left;
	private BSTNode<T> right;
	
	public BSTNode(T info)
	{
		this.info = info;
		left = right = null;
	}
	public T getInfo()
	{
		return info;
	}
	public void setInfo(T info)
	{
		this.info = info;
	}
	public BSTNode<T> getLeft()
	{
		return left;
	}
	public void setLeft(BSTNode<T> left)
	{
		this.left = left;
	}
	public BSTNode<T> getRight()
	{
		return right;
	}
	public void setRight(BSTNode<T> right)
	{
		this.right = right;
	}	
}
