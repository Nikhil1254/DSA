import java.util.Scanner;

public class PrintAllPermutattionsIterative {
    public static void solution(String str) {
        // write your code here
        int n = factorial(str.length());
        int l = str.length() ;

        for(int i=0 ; i<n ; i++){
            StringBuilder res = new StringBuilder(str);
            int divident = i ;
            int divisor = l ;
            while(divisor>0){
                int r = divident%divisor ;
                divident/= divisor;
                divisor-- ;

                System.out.print(res.charAt(r));
                res.deleteCharAt(r);
            }
            System.out.println();
        }
    }

    public static int factorial(int n) {
        int res = 1;
        while (n > 1) {
            res *= n--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }
}
