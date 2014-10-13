package HashTable;
import java.util.*;

public class MyHashTable {
	/** Two class objects are: (1) array whose each element is a reference to a node
     *  and (2) predetermined size of the array **/
	public Node[] array;
	public int size;
	
	public MyHashTable(int newSize){
		array = new Node[newSize];
		size = newSize;
	}
	
	/**
	 * find unique hashCode of a key ¡
     * INPUT: a key
     * OUTPUT: a key is "supposed to" associated with an unique hash code. However, it is not a always the case.
     * Two or more keys can have same hash code. If that happens, it is called "collision". In such that case,
     * an array element will point to the linked list composed of those keys sharing same hash code.
     * In term of implementation, that linked list will be accessed using the specific bucket value (I call it bucket index)
	 * */
	public int getHashCode(String key){
		return key.charAt(0) - 97;
	}
	
	/**
	 * compression function: find the proper bucket (index in the arrayList) that the node with belong to
	 * */
	public int getBucketIndex(Node node){
		int bucketIndex = 0;
		/* first, get the hashCode by apply hash function to the node's key value*/
		int hashCodeOfNode = this.getHashCode(node.key);
		/* second, find bucket to that the node with that hash code will be in*/
		bucketIndex = hashCodeOfNode % size;
		return bucketIndex;
	}
	
	/**
	 * retrieve bucket index 
	 * */
	public int getBucketIndex(int hashNode){
		return hashNode % size;
	}
	
	/**
	 * add node to the array
	 * Step 1: find bucket associated with that node
	 * Step 2: Traverse through the chain associated with that bucket. Add the node to the end of that chain
	 * */
	public void add(Node node){
		int bucketIndex = this.getBucketIndex(node);
		//System.out.println(", bucketIndex " +  bucketIndex);

		/* get the first node in the chain on that bucket*/
		Node temp_Node = array[bucketIndex];
		if (temp_Node == null){ /* if that bucket is empty*/
			array[bucketIndex] = node;			
		}else{ /* if the bucket is not empty*/
			while(temp_Node.getNext()!= null){ /*traverse to get the last node in the chain*/
				temp_Node = temp_Node.getNext();
			}
			temp_Node.setNext(node);
			node.setNext(null);
		}
	}
	
	public void printAllValuesForKey(String givenKey){
		int hashCodeForGivenKey = this.getHashCode(givenKey);
		int bucketIndex = this.getBucketIndex(hashCodeForGivenKey);
		
		Node temp_Node = array[bucketIndex];
		
		if (temp_Node == null){ /* if that bucket is empty*/
			System.out.println("No node containing the givenKey");
		}else{ /* if the bucket is not empty*/
			System.out.printf("With givenKey = %s, then hashCode = %d, then bucketIndex = %d\n", givenKey, hashCodeForGivenKey,bucketIndex);
			while(temp_Node != null){ /*traverse to get the last node in the chain*/
				if (temp_Node.getNext() != null) { /* if it is not the last node in the chain*/
                    System.out.printf("(%s, %s) --> ", givenKey, temp_Node.value);
                }else{ /* if it is the last node in the chain*/
                    System.out.printf("(%s, %s)", givenKey, temp_Node.value);

                }
				temp_Node = temp_Node.getNext();
			}
			System.out.println();
		}
	}
	
	public int getNumOfElementsInChainWithKey(String givenKey){
		int hashCodeForGivenKey = this.getHashCode(givenKey);
		int bucketIndex = this.getBucketIndex(hashCodeForGivenKey);
		Node temp_Node = array[bucketIndex];
		
		if (temp_Node == null){ /* if that bucket is empty*/
			System.out.println("No node containing the givenKey");
			return 0;
		}else{ /* if the bucket is not empty*/
			int count = 1;
			while(temp_Node.getNext() != null){ /*traverse to get the last node in the chain*/
				count ++;
				temp_Node = temp_Node.getNext();
			}
			System.out.printf("There are %d nodes with the chain with key \"%s\"", count, givenKey);

			return count;
		}
	}

	public static void main(String [] args){
		MyHashTable ht = new MyHashTable(100);
		Node node1 = new Node("a","1st thing"); ht.add(node1);
		Node node2 = new Node("b","2nd thing"); ht.add(node2);
		Node node3 = new Node("c","3rd thing"); ht.add(node3);
		Node node4 = new Node("d","4th thing"); ht.add(node4);
		Node node5 = new Node("ab","5th thing"); ht.add(node5);
		Node node6 = new Node("abc","6th thing"); ht.add(node6);
		Node node7 = new Node("abcd","7th thing"); ht.add(node7);
		Node node8 = new Node("cj","8th thing"); ht.add(node8);
		Node node9 = new Node("cl","9th thing"); ht.add(node9);



		ht.printAllValuesForKey("a");
		ht.getNumOfElementsInChainWithKey("a");
		
		//System.out.println(hashCode("a"));
	}

}

class Node{
	public String key;
	public String value;
	public Node next;
	
	public Node(String key){
		this.key = key;
		this.value = null;
		this.next = null;
	}
	
	public Node(String key, String value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public void setNext(Node targetNode){
		this.next = targetNode;
	}
}
	

