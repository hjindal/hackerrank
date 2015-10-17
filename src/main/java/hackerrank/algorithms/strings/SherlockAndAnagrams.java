package hackerrank.algorithms.strings;

import java.util.*;

/**
 * Created by hjindal on 10/17/2015.
 */
public class SherlockAndAnagrams {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    s.nextLine();

    while(t-- > 0) {
      String str = s.nextLine();
      int len = str.length();

      Map<String, Integer> freq = new HashMap<String, Integer>();

      for(int i=0; i<len; ++i) {
        for(int j=1; j<=len-i; ++j) {
          String sub = str.substring(i, i+j);

          char[] subArr = sub.toCharArray();
          Arrays.sort(subArr);
          sub = new String(subArr);

          if(freq.containsKey(sub))
            freq.put(sub, freq.get(sub).intValue()+1);
          else
            freq.put(sub, 1);
        }
      }

      int res = 0;
      for(String key : freq.keySet()) {
        int n = freq.get(key).intValue();
        res += n*(n-1)/2;
      }
      System.out.println(res);
    }
  }
}
