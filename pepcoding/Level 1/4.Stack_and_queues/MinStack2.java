import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// constant space
public class MinStack2 {
    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            // write your code here
            return this.data.size();
        }

        void push(int val) {
            // write your code here
            if (this.data.size() == 0) {
                this.data.push(val);
                this.min = val;
                return;
            }

            if (val < this.min) {
                this.data.push(val + (val - this.min)); // storing fake smaller value
                this.min = val;
            } else
                this.data.push(val);
        }

        int pop() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            if (this.data.peek() >= this.min)
                return this.data.pop();
            else {
                int val = this.min; // actual value at that point
                this.min = (2 * val) - this.data.pop(); // restoring old min value , cause current min will be removed
                return val;
            }
        }

        int top() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            if (this.data.peek() >= this.min)
                return this.data.peek();
            else
                return this.min; // this is actual value at that point
        }

        int min() {
            // write your code here
            return this.min; // current min is store here
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
