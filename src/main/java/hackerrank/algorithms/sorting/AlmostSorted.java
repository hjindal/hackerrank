package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by hjindal on 10/2/2015.
 */
public class AlmostSorted {
  public static void main(String[] args) {

    AlmostSorted soln = new AlmostSorted();
    soln.almostSorted();
  }


  int n;
  int[] arr;

  Dip[] dips = new Dip[2];
  int curDip = -1;
  DipState dipState = DipState.UP;
  boolean numDipsMoreThanThree = false;

  public class Dip {
    public int lIndex;
    public int rIndex;
    public int lItem;
    public int rItem;

    public Dip(int lIndex, int rIndex, int lItem, int rItem) {
      this.lIndex = lIndex;
      this.rIndex = rIndex;
      this.lItem = lItem;
      this.rItem = rItem;
    }

    public boolean ifDipFits() {
      if( (lIndex == 1 || arr[rIndex] >= arr[lIndex-1])
        && (rIndex == n || arr[rIndex + 1] >= arr[lIndex]) ) {
        return true;
      }
      return false;
    }

    public int windowSize() {
      return rIndex - lIndex + 1;
    }
  }

  public enum DipState {
    UP,
    DIP
  };

  private boolean ifSorted(int a, int b, int c) {
    if((a == 0 || arr[a] <= arr[b]) && (c == n+1 || arr[b] <= arr[c]))
      return true;
    return false;
  }

  public void almostSorted() {

    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    arr = new int[n+1];

    for(int i=1; i<=n; ++i) {
      arr[i] = s.nextInt();
    }

    for(int i=2; i<=n; ++i) {
      if( arr[i] >= arr[i-1] ) {
        dipState = DipState.UP;
      } else {
        if(dipState == DipState.UP) {
          if(curDip == 1) {
            numDipsMoreThanThree = true;
            break;
          }
          else {
            ++curDip;
            dips[curDip] = new Dip(i-1, i, arr[i-1], arr[i]);
            dipState = DipState.DIP;
          }
        } else {
          dips[curDip].rIndex = i;
          dips[curDip].rItem = arr[i];
        }
      }
    }

    if(numDipsMoreThanThree) {
      System.out.println("no");
    } else if(curDip == -1) {
      System.out.println("yes");
    } else if(curDip == 0) {
      if(dips[curDip].ifDipFits()) {
        System.out.println("yes");
        boolean two = dips[curDip].windowSize() == 2;
        System.out.println(
          (two == true? "swap " : "reverse ")
          + dips[curDip].lIndex + " " + dips[curDip].rIndex);
      }
      else {
        System.out.println("no");
      }
    } else if(curDip == 1) {
      // tru swapping dips[0].lIndex and dips[1].rIndex
      if(dips[0].windowSize() == 2 && dips[1].windowSize() == 2 &&
        ifSorted(dips[0].lIndex-1, dips[1].rIndex, dips[0].rIndex) &&
        ifSorted(dips[1].lIndex, dips[0].lIndex, dips[1].rIndex+1)) {
        System.out.println("yes");
        System.out.println("swap " + dips[0].lIndex + " " + dips[1].rIndex);
      }
      else {
        System.out.println("no");
      }
    }
  }
}
