import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String exp = scn.nextLine();

        System.out.println(infixEval(exp));
    }

    public static int infixEval(String exp) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9')
                operands.push(ch - '0');
            else if (ch == '(')
                operators.push(ch);
            else if (ch == ')') {
                while (operators.peek() != '(') {
                    int num2 = operands.pop();
                    int num1 = operands.pop();
                    char op = operators.pop();

                    operands.push(evaluate(num1, num2, op));
                }

                operators.pop();
            } else if (ch == '+' || ch == '*' || ch == '/' || ch == '-') {
                // + , - , * , /
                while (operators.size() > 0 && precidance(operators.peek()) >= precidance(ch)) {
                    int num2 = operands.pop();
                    int num1 = operands.pop();
                    char op = operators.pop();

                    operands.push(evaluate(num1, num2, op));
                }
                operators.push(ch);
            }

        }

        while (operators.size() > 0) {
            int num2 = operands.pop();
            int num1 = operands.pop();
            char op = operators.pop();

            operands.push(evaluate(num1, num2, op));
        }
        return operands.peek();
    }

    public static int evaluate(int num1, int num2, int op) {
        if (op == '+')
            return num1 + num2;
        else if (op == '-')
            return num1 - num2;
        else if (op == '*')
            return num1 * num2;
        else
            return num1 / num2;
    }

    public static int precidance(char op) {
        if (op == '*' || op == '/')
            return 2;
        else if(op=='+' || op=='-')
            return 1 ;
        
        return 0 ;
    }
}
