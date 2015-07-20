package chapter4;

import java.util.LinkedList;

public class BST {
    private TreeNode root;
    
    public BST(TreeNode root) {
        this.root = root;
    }
    
    public BST() {}
    
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    public TreeNode getRoot() {
        return this.root;
    }
    
    public BST mockBST() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        
        node2.setLeft(node1);
        node3.setLeft(node2);
        node3.setRight(node4);
        node5.setLeft(node3);
        node7.setLeft(node6);
        node8.setLeft(node7);
        node9.setRight(node10);
        node8.setRight(node9);
        node5.setRight(node8);
        
        return new BST(node5);
    }
    
    public void inOrder(TreeNode node) {
        if(node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }
    }
    
    public void postOrder(TreeNode node) {
        if(node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }
    
    public void preOrder(TreeNode node) {
        if(node != null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    
    public void breathFirst(TreeNode node) {
        LinkedList<TreeNode> list = new LinkedList<TreeNode>(); // acts as a queue
        TreeNode current;
        if(node != null) {
            list.add(node);
            while(!list.isEmpty()) {
                current = list.poll();
                if(current.getLeft() != null) 
                    list.add(current.getLeft());
                if(current.getRight() != null)
                    list.add(current.getRight());
                System.out.print(current.getData() + " ");
            }
        }
    }
}