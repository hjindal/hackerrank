package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Created by hjindal on 10/5/2015.
 */
public class PalindromeIndex {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int t= s.nextInt();
    s.nextLine();

    while (t-- > 0) {

      String str = s.nextLine();
      int idx = fun(str.toCharArray(), 0, str.length()-1);
      System.out.println(idx);
    }
  }

  public static boolean checkPalindrome(char[] str, int l, int h) {
    while(l <= h && str[l] == str[h]) {
      l++;
      h--;
    }
    return l > h;
  }

  public static int fun(char[] str, int l, int h) {
    int idx = -1;

    while(l <= h) {
      if(str[l] == str[h]) {
        l++;
        h--;
      } else {
        if(checkPalindrome(str, l+1, h)) {
          idx = l;
          break;
        } else if(checkPalindrome(str, l, h-1)) {
          idx = h;
          break;
        }
      }
    }

    return idx;
  }
}
