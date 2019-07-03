// DFS for an undirected graph.

public class DepthFirstSearch {

  private boolean[] marked;
  private int count;

  public DepthFirstSearch(PGraph graph, int source){
    marked = new boolean[graph.V()];
    dfs(graph, source);
  }

  private void dfs(PGraph graph, int vertex){
    marked[vertex] = true;
    count++;
    for(int v : graph.adj(vertex)){
      if(!marked[v]){
        dfs(graph, v);
      }
    }
  }

  public boolean marked(int w){
    return marked[w];
  }

  public int count(){
    return count;
  }
}
