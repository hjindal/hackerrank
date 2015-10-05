package hackerrank.challenges.godaddy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by hjindal on 10/4/2015.
 */
public class HexagonalWar {

  public enum ITEM {
    NEITHER,
    ROMANS,
    PERSIANS
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    ITEM[][] mat = new ITEM[n][n];
    for(int i=0; i<n; ++i) {
      for (int j = 0; j < n; ++j) {
        mat[i][j] = ITEM.NEITHER;
      }
    }

    ITEM cur = ITEM.ROMANS;
    for(int i=0; i<m; ++i) {
      mat[s.nextInt()-1][s.nextInt()-1] = cur;
      cur = cur == ITEM.ROMANS ? ITEM.PERSIANS : ITEM.ROMANS;
    }

    int maxPersianIndex = -1;
    for(int i=0; i<n; ++i) {

      int numPersians = 0;
      // track if romans win in this row
      boolean romansWon = false;
      int maxRomanIndex = -1;
      for(int j=0; j<n; ++j) {
        if(mat[i][j] == ITEM.ROMANS) {
          if((i ==0 && j ==0) ||
             (j+1 < n && mat[i][j+1] == ITEM.ROMANS) ||
             (i > 0 && mat[i-1][j] == ITEM.ROMANS)) {
            maxRomanIndex = j;
            if(maxRomanIndex == n-1) {
              romansWon = true;
            }
          } else {
            mat[i][j] = ITEM.NEITHER;
          }
        }
        else {
          if((i > 0)) {
            if(mat[i-1][j] == ITEM.PERSIANS ||
              (j+1 < n && mat[i-1][j+1] == ITEM.PERSIANS)) {
              maxPersianIndex = i;
              if(i == n-1)
                break;
            }
            else {
              mat[i][j] = ITEM.NEITHER;
            }
          }
        }
      }

      if(romansWon) {
        System.out.println("ROMANS");
        return;
      }
    }

    if(maxPersianIndex == n-1) {
      System.out.println("PERSIANS");
    }
    else {
      System.out.println("NEITHER");
    }
  }
}
