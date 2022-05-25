import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluationAndConversions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String exp = scn.nextLine();
        postEvalAndConversions(exp);
    }

    public static void postEvalAndConversions(String exp) {
        Stack<Integer> eval = new Stack<>();
        Stack<String> in = new Stack<>();
        Stack<String> pre = new Stack<>();

        Stack<Character> optors = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9') {
                eval.push(ch - '0');
                in.push(ch + "");
                pre.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v2 = eval.pop();
                int v1 = eval.pop();

                String inV2 = in.pop();
                String inV1 = in.pop();

                String preV2 = pre.pop();
                String preV1 = pre.pop();

                eval.push(evaluate(v1, v2, ch));
                in.push("(" + inV1 + ch + inV2 + ")");
                pre.push(ch + preV1 + preV2);

            }
        }

        System.out.println(eval.peek());
        System.out.println(in.peek());
        System.out.println(pre.peek());
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
