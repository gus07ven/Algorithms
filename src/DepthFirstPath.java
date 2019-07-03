public class DepthFirstPath {

  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public DepthFirstPath(PGraph graph, int source){
    marked = new boolean[graph.V()];
    edgeTo = new int[graph.V()];
    this.s = source;
    dfs(graph, source);
  }

  private void dfs(PGraph graph, int source){
    marked[source] = true;
    for(int v : graph.adj(source)){
      if(!marked[v]){
        edgeTo[v] = source;
        dfs(graph, v);
      }
    }
  }

  public boolean hasPathTo(int v){
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v){
    if(!hasPathTo(v)) return null;
    Stack<Integer> path = new Stack<Integer>();
    for(int x = v; x != s; x = edgeTo[x]){
      path.push(x);
    }
    path.push(s);
    return path;
  }
}
