package CtCI.Chapter4_TreeAndGraph;
import CtCI.CtCILibrary.*;

/**
 * Create minimized-height bst from sorted array of integers
 */
public class Question3 {
    public static void main(String[] args) {
        System.out.println((int)Math.ceil(5/2));
    }


    /*
    * Algorithm:
    * 1) Insert into the tree the middle element of the array
    * 2) Insert (into the left subtree) the left sub-array element
    * 3) Insert (into the right subtree) the right sub-array element
    * */


    public static TreeNode createMinimalBST(int[] arr, int start, int end){
        if (end < start) return null;
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }

    public static TreeNode createMinimalBST(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

}
