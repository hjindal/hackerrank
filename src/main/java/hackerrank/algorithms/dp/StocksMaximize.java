package hackerrank.algorithms.dp;

/**
 * Created by hjindal on 10/2/2015.
 */
import java.io.*;
import java.util.*;

public class StocksMaximize {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int  t = s.nextInt();
    for(;t>0; --t) {
      int n = s.nextInt();
      int arr[] = new int[n];
      for(int i=0; i<n; ++i)
        arr[i] = s.nextInt();

      long sum = 0, maxPrice = 0;
      for(int i=n-1; i>=0; --i) {
        maxPrice = maxPrice > arr[i] ? maxPrice : arr[i];
        sum += (maxPrice - arr[i]);
      }

      System.out.println(sum);
    }
  }
}