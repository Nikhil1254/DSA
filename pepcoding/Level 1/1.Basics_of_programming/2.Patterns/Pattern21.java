import java.util.Scanner;

public class Pattern21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt() ;

        solution(n);
    }

    public static void solution(int n){
        int nstar = 1 ;
        
        for(int i=1 ; i<=n ; i++){

            for(int j=1 ; j<=nstar ; j++)
                System.out.print("*\t");
            
            if(i<=n/2)
                nstar++;
            else
                nstar--; 

            System.out.println();
        }
    }
}
