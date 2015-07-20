package chapter4;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;
    
    public void addNode(Node node) {
        if(nodes == null) {
            nodes = new ArrayList<Node>();
        }
        nodes.add(node);
    }
    
    public ArrayList<Node> getNodes() {
        return nodes;
    }
    
    public Graph mockGraph() {
        Graph g = new Graph();
        Node one = new Node(1, null, State.UNVISITED);
        Node two = new Node(2, null, State.UNVISITED);
        Node three = new Node(3, null, State.UNVISITED);
        Node four = new Node(4, null, State.UNVISITED);
        Node five = new Node(5, null, State.UNVISITED);
        Node six = new Node(6, null, State.UNVISITED);
        Node seven = new Node(7, null, State.UNVISITED);
        Node eight = new Node(8, null, State.UNVISITED);
        Node nine = new Node(9, null, State.UNVISITED);
        Node ten = new Node(10, null, State.UNVISITED);
        
        one.addChild(two);
        one.addChild(three);
        one.addChild(seven);
        two.addChild(six);
        three.addChild(five);
        four.addChild(seven);
        five.addChild(seven);
        seven.addChild(five);
        five.addChild(nine);
        six.addChild(eight);
        nine.addChild(ten);
        
        g.addNode(one);
        g.addNode(two);
        g.addNode(three);
        g.addNode(four);
        g.addNode(five);
        g.addNode(six);
        g.addNode(seven);
        g.addNode(eight);
        g.addNode(nine);
        g.addNode(ten);
        
        return g;
    }
}