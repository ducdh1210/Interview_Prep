package CtCI.Chapter3_StackAndQueue;

/**
 * Created by ducdh1210 on 10/15/14.
 */
import CtCI.CtCILibrary.Node;
import java.util.Collections.*;
import java.util.Stack;

/**
 * Design a stack, which in addtion to push and pop, also has a function min which returns the minimum element
 */

public class Question2 {

    class StackWithMin extends Stack<NodeWithMin> {
        Node top;


        void push(int value){
            int newMin = Math.min(value, min());
            NodeWithMin newNode = new NodeWithMin(value, newMin);
            super.push(newNode);
        }

        int min() {
            if (this.isEmpty()){
                return Integer.MAX_VALUE;
            }else{
                return peek().min;
            }
        }


    }

    class NodeWithMin{
        public int value;
        public int min;

        NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

}
