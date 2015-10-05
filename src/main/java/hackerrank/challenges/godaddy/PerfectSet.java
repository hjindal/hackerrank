package hackerrank.challenges.godaddy;

import java.util.Scanner;

/**
 * Created by hjindal on 10/4/2015.
 */
public class PerfectSet {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int d = s.nextInt();

    int S = n + 1;

    int m = S/2 + d;
    System.out.println(m);
  }

}
