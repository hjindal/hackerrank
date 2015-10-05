package hackerrank.challenges.godaddy;

import java.util.Scanner;

/**
 * Created by hjindal on 10/4/2015.
 */
public class LCS {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int t = s.nextInt();

    while (t-- >= 1) {

      int n = s.nextInt();

      int A[] = new int[n];
      int B[] = new int[n];
      int C[] = new int[n];

      int[][][] dp = new int[n][n][n];
      for(int i=0; i<n; ++i) {
        for(int j=0; j<n; ++j) {
          for(int k=0; k<n; ++k) {
            dp[i][j][k] = -1;
          }
        }
      }

      for(int i=0; i<n; ++i)
        A[i] = s.nextInt();
      for(int i=0; i<n; ++i)
        B[i] = s.nextInt();
      for(int i=0; i<n; ++i)
        C[i] = s.nextInt();

      int res = fun(dp, n, A, B, C, 0, 0, 0);
      System.out.println(res);
    }
  }

  public static int fun(int [][][]dp, int n, int[] A, int[] B, int[] C, int a, int b, int c) {

    int res = 0;

    if(a >=n || b >= n || c >= n) {
      return res;
    }

    if(dp[a][b][c] != -1) {
      return dp[a][b][c];
    }

    if(A[a] == B[b] && B[b] == C[c]) {
      res = 1 + fun(dp, n, A, B, C, a+1, b+1, c+1);
    }
    else if(A[a] == B[b]){
      res = Math.max(fun(dp, n, A, B, C, a+1,b+1,c), fun(dp,n,A,B,C,a,b,c+1));
    }
    else if(A[a] == C[c]) {
      res = Math.max(fun(dp,n,A,B,C,a+1,b,c+1), fun(dp,n,A,B,C,a,b+1,c));
    }
    else if(B[b] == C[c]) {
      res = Math.max(fun(dp,n,A,B,C,a,b+1,c+1), fun(dp,n,A,B,C,a+1,b,c));
    }
    else {
      res = Math.max(
              Math.max(fun(dp,n,A,B,C,a+1,b,c),fun(dp,n,A,B,C,a,b+1,c)),
              fun(dp,n,A,B,C,a,b,c+1)
      );
    }

    dp[a][b][c] = res;
    return res;
  }

}
