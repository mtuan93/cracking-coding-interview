package chapter4;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a strictly increasing array: ");
        String[] in = input.nextLine().split(" ");
        int[] array = new int[in.length];
        for(int i = 0; i < in.length; i++){
            array[i] = Integer.parseInt(in[i]);
        }
        BST tree = getBST(array);
        System.out.print("In order: ");
        tree.inOrder(tree.getRoot());
        System.out.println();
        
        System.out.print("Pre order: ");
        tree.preOrder(tree.getRoot());
        System.out.println();
        
        System.out.print("Post order: ");
        tree.postOrder(tree.getRoot());
        System.out.println();
        
        System.out.print("Breath First: ");
        tree.breathFirst(tree.getRoot());
        System.out.println();
    }
    
    public static BST getBST(int[] array) {
        if(array.length == 0) {
            return new BST(null);
        }
        if(array.length == 1) {
            return new BST(new TreeNode(array[0]));
        }
        int rootIndex = array.length/2;
        TreeNode root = new TreeNode(array[rootIndex]);
        root.setLeft(getBST(Arrays.copyOfRange(array, 0, rootIndex)).getRoot());
        root.setRight(getBST(Arrays.copyOfRange(array, rootIndex+1, array.length)).getRoot());
        return new BST(root);
    }
}
