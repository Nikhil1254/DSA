import java.util.Scanner;

public class PythagoreasTriplet {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int n2 = scn.nextInt();
    int n3 = scn.nextInt();

    // if n1 is hypoteneous
    if (n1 > n2 && n1 > n3) System.out.println(
      (n1 * n1) == (n2 * n2) + (n3 * n3)
    );
    // if n2 is hypoteneous
    else if (n2 > n1 && n2 > n3) System.out.println(
      (n2 * n2) == (n1 * n1) + (n3 * n3)
    );
    // if n3 is hypoteneous
    else System.out.println((n3 * n3) == (n1 * n1) + (n2 * n2));
  }
}
