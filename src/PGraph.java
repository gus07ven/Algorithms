public class PGraph {
  private static final String NEWLINE = System.getProperty("line.separator");
  private final int V;
  private int E;
  private Bag<Integer>[] adj;

  public Graph(int vertices){
    if(vertices < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
    this.V = vertices;
    this.E = 0;
    adj = (Bag<Integer>[]) new Bag[vertices];
    for(int v = 0; v < vertices; v++){
      adj[v] = new Bag<Integer>();
    }
  }

  public int V(){
    return V;
  }

  public int E(){
    return E;
  }

  private void validateVertex(int v){
    if(v < 0 || v >= V){
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
  }

  public void addEdge(int v, int w){
    validateVertex(v);
    validateVertex(w);
    E++;
    adj[v].add(w);
    adj[w].add(v);
  }
}
