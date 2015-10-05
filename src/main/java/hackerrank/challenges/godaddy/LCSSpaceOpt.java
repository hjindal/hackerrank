package hackerrank.challenges.godaddy;

import java.util.Scanner;

/**
 * Created by hjindal on 10/4/2015.
 */
public class LCSSpaceOpt {

  private static final int N = 3000;

  private static int A[] = new int[N];
  private static int B[] = new int[N];
  private static int C[] = new int[N];

  private static int[][] X = new int[N+1][N+1];
  private static int[][] Y = new int[N+1][N+1];

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int t = s.nextInt();

    while (t-- >= 1) {

      int n = s.nextInt();


      for(int i=0; i<n; ++i)
        A[i] = s.nextInt();
      for(int i=0; i<n; ++i)
        B[i] = s.nextInt();
      for(int i=0; i<n; ++i)
        C[i] = s.nextInt();

      int res = fun(n, A, B, C);
      System.out.println(res);
    }
  }

  static int fun(int n, int[] A, int[] B, int[] C) {

    reset(X, n+1);
    reset(Y, n+1);

    for(int a=n-1; a>=0; --a) {
      for(int b=n-1; b>=0; --b) {
        for(int c=n-1; c>=0; --c) {
          if(A[a] == B[b] && B[b] == C[c]) {
            X[b][c] = 1 + Y[b+1][c+1];
          }
          else {
            X[b][c] = Math.max(Math.max(X[b][c+1], X[b+1][c]),
                            Y[b][c]);
          }
        }
      }

      copy(X, Y, n+1);
      reset(X, n+1);
    }
    return Y[0][0];
  }

  static void reset(int[][] m, int n) {
    for(int i=0; i<n; ++i) {
      for(int j=0; j<n; ++j) {
        m[i][j] = 0;
      }
    }
  }

  static void copy(int[][] src, int[][] dst, int n) {
    for(int i=0; i<n; ++i) {
      for(int j=0; j<n; ++j) {
        dst[i][j] = src[i][j];
      }
    }
  }

}
