package chapter4;

import java.util.ArrayList;

public class Node {
    private int data;
    private ArrayList<Node> childrens;
    private State state;
    
    public Node(int data, ArrayList<Node> childs, State state) {
        setData(data);
        setChilds(childs);
        setState(state);
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public int getData() {
        return this.data;
    }
    
    public void setChilds(ArrayList<Node> childs) {
        childrens = childs;
    }
    
    public ArrayList<Node> getChilds() {
        return childrens;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public State getState() {
        return this.state;
    }
    
    public void addChild(Node child) {
        if(this.childrens == null) {
            this.childrens = new ArrayList<Node>();
        }
        if(!this.childrens.contains(child)) {
            this.childrens.add(child);
//            child.addChild(this); this only applies for undirected graph
        }
    }
}
