import java.util.Scanner;

public class RotateNumber {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();
    int k = scn.nextInt();

    System.out.println(rotateNumber(num, k));
  }

  public static int rotateNumber(int num, int k) {
    //actual rotations
    int n = countDigits(num);

    k = k % n;
    if (k < 0) k += n; //to handle negative rotation

    if (k == 0) return num; //extra optimization

    //get divison and multiplier
    int div = 1;
    int mult = 1;

    for (int i = 1; i <= n; i++) {
      if (i <= k) div *= 10; else mult *= 10;
    }

    // get result
    int q = num / div;
    int r = num % div;

    int res = r * mult + q;
    return res;
  }

  public static int countDigits(int num) {
    int count = 0;
    while (num != 0) {
      count++;
      num /= 10;
    }

    return count;
  }
}
