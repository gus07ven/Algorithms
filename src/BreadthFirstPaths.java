
public class BreadthFirstPaths {

  private boolean[] marked;
  private int[] edgeTo;
  private int[] distTo;         // distTo[v] = number of edges shortest s-v path

  public BreadthFirstPaths(PGraph graph, int source){
    marked = new boolean[graph.V()];
    edgeTo = new int[graph.V()];
    distTo = new int[graph.V()];
    bfs(graph, source);
  }

  private void bfs(PGraph graph, int source){
    GenQueueArr<Integer> q = new GenQueueArr<>(graph.V());
    for(int v = 0; v < graph.V(); v++){
      distTo[v] = Integer.MAX_VALUE;
    }
    distTo[source] = 0;
    marked[source] = true;
    q.enqueue(source);

    while(!q.isEmpty()){
      int v = q.dequeue();
      for(int vertex : graph.adj(source)){
        if(!marked[vertex]){
          edgeTo[vertex] = v;
          marked[vertex] = true;
          distTo[vertex] = distTo[vertex] + 1;
          q.enqueue(vertex);
        }
      }
    }
  }

  public boolean hasPathTo(int v){
    return marked[v];
  }

  public int distTo(int v){
    return distTo[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    Stack<Integer> path = new Stack<Integer>();
    int x;
    for (x = v; distTo[x] != 0; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(x);
    return path;
  }
}
