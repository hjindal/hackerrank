package hackerrank.algorithms.graphtheory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by hjindal on 9/26/2015.
 */
public class BFSShortestReach {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();

    while(t-- > 0) {
      int n = s.nextInt();
      int m = s.nextInt();

      ArrayList<Integer>[] adjList = new ArrayList[n+1];
      int[] dist = new int[n+1];

      for(int i=0; i<=n; ++i) {
        dist[i] = -1;
        adjList[i] = new ArrayList<Integer>();
      }

      while(m-- > 0) {
        int a = s.nextInt();
        int b = s.nextInt();

        adjList[a].add(b);
        adjList[b].add(a);
      }

      int start = s.nextInt();
      dist[start] = 0;

      Queue<Integer> queue = new ArrayDeque<Integer>(n);
      queue.add(start);

      while (!queue.isEmpty()) {
        int vertex = queue.remove();
        for(Integer u : adjList[vertex]) {
            if (dist[u] == -1) {
              dist[u] = dist[vertex] + 6;
              queue.add(u);
            }
        }
      }

      for(int i=1; i<=n; ++i) {
        if(i != start) {
          System.out.print(dist[i] + " ");
        }
      }

      System.out.println();
    }
  }
}
