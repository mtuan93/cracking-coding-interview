package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Problem1 {
    public static void main(String[] args) {
        Graph g = (new Graph()).mockGraph();
        ArrayList<Node> nodes = g.getNodes();
        Node start = nodes.get(1);
        Node end = nodes.get(9);
        String result1 = BFS(start, end) ? "connected" : "not connected";
        resetState(nodes);
        String result2 = DFS(start, end) ? "connected" : "not connected";
        System.out.println("Bread first search on node " + start.getData() + " and "
                + "node " + end.getData() + ": " + result1);
        System.out.println("Depth first search on node " + start.getData() + " and "
                + "node " + end.getData() + ": " + result2);
    }
    
    //Breadth first search
    public static boolean BFS(Node start, Node end) {
        if(start == end) return true;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(start);
        start.setState(State.VISITED);
        Node current;
        while(!queue.isEmpty()) {
            current = queue.poll();
            if(current.getChilds() != null) {
                for(Node n : current.getChilds()) {
                    if(n.getState() == State.UNVISITED) {
                        if(n == end) return true;
                        queue.add(n);
                        n.setState(State.VISITED);
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean DFS(Node start, Node end) {
        if(start == end) return true;
        if(start == null) return false;
        if(start.getChilds() == null) return false;
        start.setState(State.VISITED);
        for(Node n : start.getChilds()) {
            if(n.getState() == State.UNVISITED && DFS(n,end)) return true;
        }
        return false;
    }
    
    public static void resetState(ArrayList<Node> nodes) {
        if(!nodes.isEmpty()) {
            for(Node n: nodes) {
                n.setState(State.UNVISITED);
            }
        }
    }
}
