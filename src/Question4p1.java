public class Question4p1 {

  public static void main(String[] args) {

    Graph.Node root = new Graph.Node(1);
    Graph.Node n2 = new Graph.Node(5);
    Graph.Node n3 = new Graph.Node(15);
    Graph.Node n4 = new Graph.Node(44);

    n2.adjacent.add(n4);
    n3.adjacent.add(n4);
    n4.adjacent.add(root);
    root.adjacent.add(n2);

    Graph g = new Graph();
    g.nodeLookup.put(1, root);
    g.nodeLookup.put(5, n2);
    g.nodeLookup.put(15, n3);
    g.nodeLookup.put(44, n4);

    System.out.println(g.hasPathBFS(root.id, n4.id));
  }
}
