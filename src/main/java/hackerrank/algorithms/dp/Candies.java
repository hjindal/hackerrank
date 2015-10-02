package hackerrank.algorithms.dp;

/**
 * Created by hjindal on 10/2/2015.
 */
import java.io.*;
import java.util.*;

public class Candies {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    int arr[] = new int[t];
    long res[] = new long[t];

    for(int i=0; i<t; ++i) {
      arr[i] = s.nextInt();
      res[i] = 0;
    }

    res[0] = 1;
    for(int i=1; i<t; ++i) {
      res[i] = 1;
      if(arr[i] > arr[i-1]) {
        res[i] = res[i-1]+1;
      }
      else if(arr[i] < arr[i-1]) {
        int j = i;
        while(j>0 && arr[j-1] > arr[j] && res[j-1] <= res[j]) {
          res[j-1]++;
          j--;
        }
      }
    }

    long sum = 0;
    for(int i=0; i<t; ++i) {
      sum += res[i];
    }

    System.out.println(sum);
  }
}
