package hackerrank.algorithms.dp;

/**
 * Created by hjindal on 10/2/2015.
 */
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Fibonacci {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scanner = new Scanner(System.in);

    BigInteger a = BigInteger.valueOf(scanner.nextInt());
    BigInteger b = BigInteger.valueOf(scanner.nextInt());
    int n = scanner.nextInt();

    BigInteger res = BigInteger.ZERO;
    if(n == 1)
      res = a;
    else if(n == 2)
      res = b;

    for(int i=3; i<=n; ++i) {
      res = a.add(b.multiply(b));
      a = b;
      b = res;
    }

    System.out.print(res);
  }
}
