import java.util.Scanner;
import java.util.Stack;

public class SmallestNumberFollowingPattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        solution(str);
    }

    public static void solution(String str) {
        Stack<Integer> st = new Stack<>();
        int num = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'd') {
                st.push(num);
                num++;
            } else {
                st.push(num);
                num++;

                while (st.size() > 0)
                    System.out.print(st.pop());
            }
        }

        st.push(num);
        while (st.size() > 0)
            System.out.print(st.pop());
    }
}
