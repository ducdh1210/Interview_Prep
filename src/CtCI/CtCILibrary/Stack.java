package CtCI.CtCILibrary;

/**
 * Created by ducdh1210 on 10/15/14.
 */
import CtCI.CtCILibrary.Node;
public class Stack {
    Node top;

    Object pop(){
        if (top != null){
            Object item = top.next;
            top = top.next;
            return item;
        }else return null;
    }

    void push(Object item){
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
    }

    Object peek(){
        return top.data;
    }
}
