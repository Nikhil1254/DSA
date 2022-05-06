import java.util.Scanner;

public class DigitsOfNumber {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();

    printDigits(num);
  }

  public static void printDigits(int num) {
    // get multiple
    int mult = 1;
    int temp = num;

    while (temp > 10) {
      mult *= 10;
      temp /= 10;
    }

    //print digits - num!=0 will not work here ,edge case 1234500
    while (mult != 0) {
      System.out.println(num / mult);
      num %= mult;
      mult /= 10;
    }
  }
}
