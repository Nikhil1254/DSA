import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        System.out.println(solution(str));
    }

    public static boolean solution(String str) {
        Stack<Character> st = new Stack<>();

        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);

            if (ch == ')') {
                if (st.peek() == '(')
                    return true;

                while (st.peek() != '(') {
                    st.pop();
                }
                st.pop();
            } else
                st.push(ch);
        }

        return false;

    }
}
