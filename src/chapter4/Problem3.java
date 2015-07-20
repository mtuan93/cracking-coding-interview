package chapter4;

import java.util.LinkedList;

public class Problem3 {
    public static void main(String[] args) {
        BST mockTree = (new BST()).mockBST();
        LinkedList<TreeNode>[] list = getListsByHeight(mockTree);
        for(int i = 0; i < list.length; i++) {
            System.out.println("Level " + (i+1));
            printLinkedList(list[i]);
            System.out.println("-----------------------------");
        }
    }
    
    public static void printLinkedList(LinkedList<TreeNode> list) {
        LinkedList<TreeNode> copy = (LinkedList<TreeNode>) list.clone();
        while(copy.size() > 1) {
                System.out.print(copy.poll().getData() + " -> ");
        }
        if(!copy.isEmpty()) System.out.println(copy.poll().getData());
    }
    
    public static LinkedList<TreeNode>[] getListsByHeight(BST tree) {
        int depth = tree.getRoot().getDepth();
        LinkedList<TreeNode>[] result = new LinkedList[depth];
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int currentLevel = 0;
        if(tree.getRoot() != null) {
            queue.add(tree.getRoot());
            while(!queue.isEmpty()) {
                for(int i = 0; i < Math.pow(2.0, (int)currentLevel); i++) {
                    TreeNode current = queue.poll();
                    if(current != null) {
                        if(result[currentLevel] == null) result[currentLevel] = new LinkedList<TreeNode>();
                        result[currentLevel].add(current);
                        if(current.getLeft() != null) queue.add(current.getLeft());
                        if(current.getRight() != null) queue.add(current.getRight());
                    }
                }
                currentLevel++;
            }
        }
        return result;
    }
}