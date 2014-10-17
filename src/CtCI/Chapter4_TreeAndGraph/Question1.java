package CtCI.Chapter4_TreeAndGraph;
import CtCI.CtCILibrary.*;

/**
 * Check if a tree is balanced.
 * A balanced tree is defined to be a tree such that the heights of any two subtree never differs more than 1
 */
public class Question1 {
    public static int getHeight(TreeNode root){
        if (root == null) return 0; //Base case
        else{
            int height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
            return height;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        }
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
}
