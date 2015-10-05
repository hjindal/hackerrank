package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Created by hjindal on 10/5/2015.
 */
public class CommonChildLCS {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    String as = s.nextLine();
    String bs = s.nextLine();

    int n = as.length();

    int[] X = new int[n+1];
    int[] Y = new int[n+1];

    reset(X, n+1);
    reset(Y, n+1);

    char[] a = as.toCharArray();
    char[] b = bs.toCharArray();

    for(int i=n-1; i>=0; --i) {
      for(int j=n-1; j>=0; --j) {
        if(a[i] == b[j]) {
          X[j] = 1 + Y[j+1];
        } else {
          X[j] = Math.max(X[j+1], Y[j]);
        }
      }

      copy(X, Y, n+1);
      reset(X, n+1);
    }

    System.out.println(Y[0]);
  }

  public static void reset(int[] arr, int n) {
    for(int i=0; i<n; ++i)
      arr[i] = 0;
  }

  public static void copy(int[] src, int[] dst, int n) {
    for(int i=0; i<n; ++i) {
      dst[i] = src[i];
    }
  }

}
