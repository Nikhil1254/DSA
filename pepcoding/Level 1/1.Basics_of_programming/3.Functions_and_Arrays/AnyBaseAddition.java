import java.util.Scanner;

public class AnyBaseAddition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int base = scn.nextInt() ;
        int num1 = scn.nextInt() ;
        int num2 = scn.nextInt() ;

        int d = anyBaseAddition(base,num1,num2);
        System.out.println(d);
    }

    public static int anyBaseAddition(int base,int num1,int num2){
        int carry = 0 ;
        int res = 0;
        int mult = 1 ;

        while(num1>0 || num2>0 || carry>0){
            int d1 = num1%10 ;
            num1/=10;
            int d2 = num2%10 ;
            num2/=10;

            int val = d1+d2+carry ;
            int digit = val%base ;
            carry = val/base ;
            res += ((digit)*mult);

            mult*=10 ;

        }

        return res ;
    }
}
