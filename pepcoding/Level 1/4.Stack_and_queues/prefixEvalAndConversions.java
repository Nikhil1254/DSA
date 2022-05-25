import java.util.Scanner;
import java.util.Stack;

public class prefixEvalAndConversions {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String exp = scn.nextLine();
        prefixEvalAndConversions(exp);
    }

    public static void prefixEvalAndConversions(String exp) {
        Stack<String> in = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Integer> eval = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9') {
                eval.push(ch - '0');
                in.push(ch + "");
                post.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v1 = eval.pop();
                int v2 = eval.pop();

                String inV1 = in.pop();
                String inV2 = in.pop();

                String postV1 = post.pop();
                String postV2 = post.pop();

                eval.push(evaluate(v1, v2, ch));
                in.push("(" + inV1 + ch + inV2 + ")");
                post.push(postV1 + postV2 + ch);
            }
        }

        System.out.println(eval.peek());
        System.out.println(in.peek());
        System.out.println(post.peek());
    }

    public static int evaluate(int v1, int v2, char op) {
        if (op == '+')
            return v1 + v2;
        else if (op == '-')
            return v1 - v2;
        else if (op == '*')
            return v1 * v2;
        else
            return v1 / v2;
    }
}
