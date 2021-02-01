/**
 * 
 */
package com.OrchidBank.Solution_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Samuel Columbus Jan 31, 2021
 */
public class PerfectSquareCount {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the number of test-case");
    int numberOfTestcase = input.nextInt();
    List<Integer> listSum = new ArrayList<Integer>();
    for (int tc = 0; tc < numberOfTestcase; tc++) {
      int length = input.nextInt();
      int width = input.nextInt();
      int sum = 0;
      for (int i = 0; i <= length; i++) {
        for (int j = 0; j <= width; j++) {
          for (int k = 1; k <= width; k++) {
            if ((j + k) <= width && (i + k) <= length) {
              sum += 1;
            }
          }
        }
      }
      listSum.add(sum);
    }
    for (Integer integer : listSum) {
      System.out.println(integer);
    }
  }
}
