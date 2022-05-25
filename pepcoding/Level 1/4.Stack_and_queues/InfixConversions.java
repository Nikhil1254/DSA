import java.util.Scanner;
import java.util.Stack;

public class InfixConversions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String exp = scn.nextLine();

        infixConversion(exp);
    }

    public static void infixConversion(String exp) {
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> optors = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(')
                optors.push(ch);
            else if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')) {
                pre.push(ch + "");
                post.push(ch + "");
            } else if (ch == ')') {
                while (optors.size() > 0 && optors.peek() != '(') {
                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    char op = optors.pop();

                    pre.push(op + preV1 + preV2);

                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    post.push(postV1 + postV2 + op);
                }
                optors.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                while (optors.size() > 0 && precedence(optors.peek()) >= precedence(ch)) {
                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    char op = optors.pop();

                    pre.push(op + preV1 + preV2);

                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    post.push(postV1 + postV2 + op);
                }

                optors.push(ch);
            }
        }

        while (optors.size() > 0) {
            String preV2 = pre.pop();
            String preV1 = pre.pop();
            char op = optors.pop();

            pre.push(op + preV1 + preV2);

            String postV2 = post.pop();
            String postV1 = post.pop();
            post.push(postV1 + postV2 + op);
        }

        System.out.println(post.peek());
        System.out.println(pre.peek());
    }

    public static int precedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        else if (op == '*' || op == '/')
            return 2;
        else
            return 0; // for '('
    }

}
