package Graph.Level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 */
public class CloneGraph {

    public static void main(String[] args) {

        //sample graph
        GNode n1 = new GNode(1);
        GNode n2 = new GNode(2);
        GNode n3 = new GNode(3);
        GNode n4 = new GNode(4);

        n1.neighbours.add(n2);
        n1.neighbours.add(n4);
        n2.neighbours.add(n1);
        n2.neighbours.add(n3);
        n3.neighbours.add(n2);
        n3.neighbours.add(n4);
        n4.neighbours.add(n1);
        n4.neighbours.add(n3);

        CloneGraph h = new CloneGraph();
        GNode clonedGraph = h.clone(n1);
        h.printGraph(clonedGraph, new HashSet<>());
    }

    private void printGraph(GNode node, HashSet<Object> visited) {

        if(node == null  || visited.contains(node)) return;

        visited.add(node);

        System.out.println("Node : "+node.val+" neighbours : ");
        for (GNode neighbour : node.neighbours) {
            System.out.println(neighbour.val);
        }
        System.out.println();

        for (GNode neighbour : node.neighbours) {
            printGraph(neighbour, visited);
        }
    }

    public GNode clone(GNode node) {

        if(node == null) return null;
        Map<Integer, GNode> visited = new HashMap<>();
        
        return cloneHelper(node, visited);
    }

    private GNode cloneHelper(GNode node, Map<Integer, GNode> visited) {

        //create neighbours
        ArrayList<GNode> clonedNeighbours = new ArrayList<>();
        //create new Node
        GNode cloneNode = new GNode(node.val);

        visited.put(cloneNode.val, cloneNode);

        for (GNode oldNeighbour : node.neighbours) {
            if (!visited.containsKey(oldNeighbour)) {
                clonedNeighbours.add(cloneHelper(oldNeighbour, visited));
            } else {
                clonedNeighbours.add(visited.get(oldNeighbour.val));
            }
        }

        cloneNode.neighbours = clonedNeighbours;
        return cloneNode;
    }
}

class GNode {

    public int val;
    public ArrayList<GNode> neighbours;

    public GNode() {
        val = 0;
        neighbours = new ArrayList<>();
    }

    public GNode(int val) {
        this.val = val;
        neighbours = new ArrayList<>();
    }

}
