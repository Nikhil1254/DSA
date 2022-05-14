import java.util.Scanner;

public class PrintKPC {
    static String[] values = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        printKPC(str,"");
    }

    public static void printKPC(String str, String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return ;
        }

        String cs = values[Integer.parseInt(str.charAt(0)+"")];

        for(int i=0 ; i<cs.length() ;i++)
            printKPC(str.substring(1), asf+cs.charAt(i));
    }
}
