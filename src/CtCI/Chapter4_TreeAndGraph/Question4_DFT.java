package CtCI.Chapter4_TreeAndGraph;

import CtCI.CtCILibrary.AssortedMethods;
import CtCI.CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ducdh1210 on 10/25/14.
 */
public class Question4_DFT {
    /*public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        System.out.println("Level: " + level);
        if (root == null){
            System.out.println("        Null");
            return;
        }
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) { // Level not contained in list
            list = new LinkedList<TreeNode>();
			*//* Levels are always traversed in order. So, if this is the first time we've visited level i,
			 * we must have seen levels 0 through i - 1. We can therefore safely add the level at the end. *//*
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }*/

    /*public static ArrayList< LinkedList<TreeNode> > createLevelLinkedList(TreeNode root) {
        ArrayList< LinkedList<TreeNode> > lists = new ArrayList< LinkedList<TreeNode> >();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }*/

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode node){
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(node, lists, 0);
        return lists;
    }

    private static void createLevelLinkedList(TreeNode node, ArrayList<LinkedList<TreeNode>> lists, int level) {
        /* Basic idea: in each recursion, we have the knowledge of the level the node is in.
        *  We follow the pre-order traversal to add each node into the linked list it should be in.
        *  Note that each linked list is stored as an element in the overall array-list.
        *  The index of each linked list equals to the level of each node in it
        *  */

        /* Base case */
        if (node == null) return;

        /* Note that a new linked list is also added into the arraylist inorderly.
         * For example, a linkedlist whose nodes are of level 3 will be created and added before linkedlist whose node
         * are of level 4 and after the one whose nodes are of level 2 */
        if (lists.size() == level){ // no linked list of this level created yet
            LinkedList<TreeNode> newLinkedList = new LinkedList<TreeNode>();
            newLinkedList.add(node); // add the node into the newly created linkedlist
            lists.add(newLinkedList); /* add the newly created linkedlist into the arraylist. Levels are always traversed in order. So, if this is the first time we've visited level i,
            we must have seen levels 0 through i - 1. We can therefore safely add the level at the end */
        }else{
            LinkedList<TreeNode> linkedList = lists.get(level); // retrieve the linked list corresponding to the level
            linkedList.add(node);
        }

        /* In-order traversal */
        createLevelLinkedList(node.left, lists, level + 1);
        createLevelLinkedList(node.right, lists, level + 1);


     }

    public static void printResult(ArrayList<LinkedList<TreeNode>> result){
        int depth = 0;
        for(LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" " + ((TreeNode)i.next()).data);
            }
            System.out.println();
            depth++;
        }
    }


    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        printResult(list);
    }
}
