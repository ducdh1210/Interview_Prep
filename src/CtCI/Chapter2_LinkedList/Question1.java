package CtCI.Chapter2_LinkedList;
import CtCI.CtCILibrary.AssortedMethods;
import CtCI.CtCILibrary.LinkedListNode;
import LinkedList.LinkedList;

import java.util.HashSet;

/**
 * Remove duplicates from an unsorted linked list
 */


public class Question1 {
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        LinkedListNode clone = head.clone();
        deleteDupsB(head);
        System.out.println(head.printForward());
        //deleteDupsC(clone);
        //deleteDupsC(clone);

    }

    /* Idea: using an hash set to memorize the duplicate values */

    public static void deleteDupsA(LinkedListNode n){
        LinkedListNode currentNode = n;
        LinkedListNode previousNode = null;

        HashSet<Integer> hashSet = new HashSet<Integer>();

        /* if the node is repeated, meaning its data is contained in the set, then remove it by unlink it, previous
        * node stays at un-duplicated node */
        while(currentNode != null){
            if (hashSet.contains(currentNode.data)){
                previousNode.next = currentNode.next;
            }else{
                hashSet.add(currentNode.data);
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    /* Idea: without using any buffer, need to check each node and remove all possible duplicate node. A "runner" node
    * is helpful to find out duplicate node*/

    public static void deleteDupsB(LinkedListNode head){
        if (head == null) return;

        LinkedListNode currentNode = head;

        while (currentNode != null){
            LinkedListNode runnerNode = currentNode;

            int currentData = currentNode.data;
            /* interesting point of this code is that the reference of a node is moved in the next iteration*/
            while (runnerNode.next != null){
                if (runnerNode.next.data == currentData) {
                    runnerNode.next = runnerNode.next.next;
                }else {
                    runnerNode = runnerNode.next;
                }
            }

            currentNode = currentNode.next;
        }


    }

 }
