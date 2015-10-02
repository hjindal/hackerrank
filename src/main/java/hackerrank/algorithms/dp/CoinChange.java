package hackerrank.algorithms.dp;

/**
 * Created by hjindal on 10/2/2015.
 */
import java.io.*;
import java.util.*;

public class CoinChange {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int n, m;
    n = s.nextInt();
    m = s.nextInt();

    int coins[] = new int[m];

    for(int i=0; i<m; ++i) {
      coins[i] = s.nextInt();
    }

    long table[][] = new long[n+1][m];

    for(int i=0; i<m; ++i) {
      table[0][i] = 1;
    }

    long p,q;
    for(int i=1; i<=n; ++i) {
      for(int j=0; j<m; ++j) {
        p = (i-coins[j] >= 0) ? table[i-coins[j]][j] : 0;
        q = j==0 ? 0 : table[i][j-1];
        table[i][j] = p+q;
      }
    }

    System.out.println(table[n][m-1]);
  }
}