package CtCI.Chapter4_TreeAndGraph;
import CtCI.CtCILibrary.*;

/**
 * Check if a tree is balanced.
 * A balanced tree is defined to be a tree such that the heights of any two subtree never differs more than 1
 */
public class Question1 {
    public static int getHeight(TreeNode node){
        if (node == null) return 0; //Base case
        else{
            int height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
            return height;
        }
    }

    public static boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int heightDiff = getHeight(node.left) - getHeight(node.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        }
        else {
            return isBalanced(node.left) && isBalanced(node.right);
        }
    }
}
