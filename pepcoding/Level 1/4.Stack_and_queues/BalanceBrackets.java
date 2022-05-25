import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        System.out.println(solution(str));
    }

    public static boolean solution(String str) {
        Stack<Character> st = new Stack<>();

        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);

            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (st.size() == 0) // closing brackets are more
                    return true;

                // mismatched condition check
                if (ch == ')' && st.peek() != '(')
                    return true;
                else if (ch == ']' && st.peek() != '[')
                    return false;
                else if (ch == '}' && st.peek() != '{')
                    return false;

                st.pop();
            }
        }

        return st.size() == 0; // if opening brackets are more
    }
}
