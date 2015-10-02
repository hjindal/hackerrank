package hackerrank.algorithms.dp;

import java.io.*;
import java.util.*;

public class MaxSubArray {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    long t;
    t = s.nextInt();

    for(; t>0; t--) {
      int n;
      n = s.nextInt();

      int contiguousSum = 0;
      int curSum = 0;

      int nonContiguousSum = 0;

      int maxNum = Integer.MIN_VALUE;
      int num=0;

      for(long i=0; i<n; ++i) {
        num = s.nextInt();

        if(num > 0) {
          curSum += num;
          nonContiguousSum += num;
        }
        else {
          if(num + curSum > 0) {
            curSum = num + curSum;
          }
          else
            curSum = 0;
        }

        if(num > maxNum) {
          maxNum = num;
        }

        if(curSum > contiguousSum)
          contiguousSum = curSum;
      }

      // special handling for all negative numbers
      if(maxNum < 0) {
        nonContiguousSum = contiguousSum = maxNum;
      }
      System.out.println(contiguousSum + " " + nonContiguousSum);
    }

  }
}