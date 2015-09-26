package hackerrank.algorithms.dp;

import java.util.Scanner;

/**
 * Created by hjindal on 9/20/2015.
 */
public class SherlockAndCost {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int t = s.nextInt();

    while(t-- > 0) {
      int n = s.nextInt();

      long[] arr = new long[n+1];
      for(int i=0; i<n; ++i)
        arr[i] = s.nextInt();

      long result = 0, pOne = 0, pSame = 0;

        for(int i=1; i<n; ++i) {
          long temp = pOne;
          pOne = Math.max(pOne, pSame + arr[i-1]-1 );
          pSame = Math.max(temp + arr[i] - 1, pSame + Math.abs(arr[i] - arr[i - 1]));
        }
        result = Math.max(pOne,pSame);
      System.out.println(result);
    }
  }
}
