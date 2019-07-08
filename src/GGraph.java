import java.util.LinkedList;

public class GGraph {

  private int V;
  private LinkedList<Integer> adj[];

  public Graph(int v){
    V = v;
    adj = new LinkedList[v];

    for(int i = 0; i < v; i++){
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int v, int w){
    adj[v].add(w);
  }
}
