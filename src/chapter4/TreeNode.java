package chapter4;

public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;
    
    public TreeNode(int data, TreeNode left, TreeNode right) {
        setData(data);
        setLeft(left);
        setRight(right);
    }
    
    public TreeNode(int data) {
        setData(data);
    }
    
    public void setData(int data) {
        this.data = data;
    }
    public int getData() {
        return this.data;
    }
    
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getLeft() {
        return this.left;
    }
    
    public void setRight(TreeNode right) {
        this.right = right;
    }
    public TreeNode getRight() {
        return this.right;
    }
    
    public int getDepth() {
        return getDepth(this);
    }
    
    public static int getDepth(TreeNode node) {
        if(node == null) return 0;
        int depthLeft = getDepth(node.left);
        int depthRight = getDepth(node.right);
        return depthLeft > depthRight ? depthLeft + 1 : depthRight + 1;
    }
}