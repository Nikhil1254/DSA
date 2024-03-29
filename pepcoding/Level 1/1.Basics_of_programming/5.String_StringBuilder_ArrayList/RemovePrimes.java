import java.util.*;

public class RemovePrimes {
    public static void solution(ArrayList<Integer> al) {
        // write your code here

        // int idx = 0;

        // while (idx < al.size()) {
        // if (isPrime(al.get(idx)))
        // al.remove(idx);
        // else
        // idx++;
        // }

        for (int i = al.size() - 1; i >= 0; i--)
            if (isPrime(al.get(i)))
                al.remove(i);
    }

    public static boolean isPrime(int val) {

        for (int i = 2; i * i <= val; i++) {
            if (val % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }
}
