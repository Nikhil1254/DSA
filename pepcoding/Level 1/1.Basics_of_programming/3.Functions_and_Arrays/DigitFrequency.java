import java.util.Scanner;

public class DigitFrequency {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();
    int digit = scn.nextInt();

    System.out.println(countFrequency(num, digit));
  }

  public static int countFrequency(int num, int digit) {
    int count = 0;

    while (num > 0) {
      if (num % 10 == digit) count++;
      num /= 10;
    }

    return count;
  }
}
