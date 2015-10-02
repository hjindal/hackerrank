package hackerrank.algorithms.graphtheory;

import java.util.*;

/**
 * Created by hjindal on 9/26/2015.
 */
public class DijkstraShortestReach {

  public static void main(String[] args) {

    DijkstraShortestReach soln = new DijkstraShortestReach();
    soln.ShortestReach();
  }

  private ArrayList<GraphNode>[] adjList;
  private int[] dist;
  boolean[] visited;

  public static class GraphNode {

    private int vertex;
    private int cost;

    public GraphNode(int v, int c) {
      this.vertex = v;
      this.cost = c;
    }

    public int getVertex() {
      return this.vertex;
    }

    public int getCost() {
      return this.cost;
    }
  }

  private void ShortestReach() {

    Scanner s = new Scanner(System.in);
    int t = s.nextInt();

    while(t-- > 0) {

      int n = s.nextInt();
      int m = s.nextInt();

      adjList = new ArrayList[n+1];
      dist = new int[n+1];
      visited = new boolean[n+1];

      for(int i=0; i<=n; ++i) {
        dist[i] = Integer.MAX_VALUE;
        visited[i] = false;
        adjList[i] = new ArrayList<GraphNode>();
      }

      for(int i=0; i<m; ++i) {
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        adjList[a].add(new GraphNode(b, c));
        adjList[b].add(new GraphNode(a, c));
      }

      int start = s.nextInt();
      dist[start] = 0;

      // find minimum distance node connected with given node
      int vIndex = start;
      while(vIndex != -1) {
        visited[vIndex] = true;
        for(GraphNode v : adjList[vIndex]) {
          if(!visited[v.getVertex()]) {
            dist[v.getVertex()] = Math.min(dist[v.getVertex()],
                    dist[vIndex] + v.getCost());
          }
        }
        vIndex = findMinimumDistanceNode();
      }

      for(int i=1; i<=n; ++i) {
        if(i != start) {
          System.out.print((dist[i] == Integer.MAX_VALUE ?
                  -1 : dist[i]) + " ");
        }
      }
      System.out.println();
    }
  }

  private int findMinimumDistanceNode() {
    int vIndex = -1;
    for(int i = 1; i<dist.length; ++i) {
      if (!visited[i]) {
        if (vIndex == -1 || dist[i] < dist[vIndex]) {
          vIndex = i;
        }
      }
    }
    return vIndex == -1 || dist[vIndex] == Integer.MAX_VALUE ? -1 :
            vIndex;
  }
}
