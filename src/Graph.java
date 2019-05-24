import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
  private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

  public static class Node {
    private int id;
    LinkedList<Node> adjacent = new LinkedList<Node>();

    private Node(int id){
      this.id = id;
    }
  }

  private Node getNode(int id){
    return nodeLookup.get(id);
  }

  public void addEdge(int source, int destination){
    Node s = getNode(source);
    Node d = getNode(destination);
    s.adjacent.add(d);
  }

  public boolean hasPathDFS(int source, int destination){
    Node s = getNode(source);
    Node d = getNode(destination);
    HashSet<Integer> visited = new HashSet<Integer>();
    return hasPathDFS(s, d, visited);
  }

  private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){
    if (visited.contains(source.id)){
      return false;
    }
    visited.add(source.id);
    if (source == destination){
      return true;
    }
    for (Node child : source.adjacent){
      if (hasPathDFS(child, destination, visited)){
        return true;
      }
    }
    return false;
  }

  public boolean hasPathBFS(int source, int destination){
    return hasPathBFS(getNode(source), getNode(destination));
  }

  private boolean hasPathBFS(Node source, Node destination){
    LinkedList<Node> nextToVisit = new LinkedList<Node>();
    HashSet<Integer> visited = new HashSet<Integer>();
    nextToVisit.add(source);
    while (!nextToVisit.isEmpty()){
      Node node = nextToVisit.remove();
      if (node == destination){
        return true;
      }
      if (visited.contains(node.id)){
        continue;
      }
      visited.add(node.id);

      for (Node child : node.adjacent){
        nextToVisit.add(child);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    n2.adjacent.add(n4);
    n3.adjacent.add(n4);
    n4.adjacent.add(root);
    root.adjacent.add(n2);

    Graph g = new Graph();
    g.nodeLookup.put(1, root);
    g.nodeLookup.put(2, n2);
    g.nodeLookup.put(3, n3);
    g.nodeLookup.put(4, n4);

    System.out.println(g.hasPathBFS(root.id, n4.id));
  }

}
