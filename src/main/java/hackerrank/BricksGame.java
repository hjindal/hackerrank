package hackerrank;

import java.util.Scanner;

/**
 * Created by hjindal on 9/20/2015.
 */
public class BricksGame {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int t = s.nextInt();

    while(t > 0) {
      t--;

      int n = s.nextInt();
      long[] a = new long[n];

      for(int i=n-1; i>=0; --i) {
        a[i] = s.nextInt();
      }

      long sum = f(a, n);

      System.out.println(sum);
    }
  }

  private static long max(long a, long b) {
    return a > b ? a : b;
  }

  private static long f(long a[], int n) {
    if(n == 1)
      return a[0];
    if(n == 2)
      return a[0]+a[1];
    if(n == 3)
      return a[0] + a[1] + a[2];
    long[] sum = new long[3];
    long[] sol = new long[3];

    sum[0] = sol[0] = a[0];
    sum[1] = sol[1] = sol[0]+ a[1];
    sum[2] = sol[2] = sol[1] + a[2];

    long csum=0, csol=0;

    for(int i=3; i<n; ++i) {
      long sol1 = a[i] + sum[2] - sol[2];
      long sol2 = a[i] + a[i-1] + sum[1] - sol[1];
      long sol3 = a[i] + a[i-1] + a[i-2] + sum[0] - sol[0];

      csum = sum[2] + a[i];
      csol = max(sol1, max(sol2, sol3));

      sum[0] = sum[1]; sum[1] = sum[2]; sum[2] = csum;
      sol[0] = sol[1]; sol[1] = sol[2]; sol[2] = csol;
    }

    return sol[2];
  }
}
