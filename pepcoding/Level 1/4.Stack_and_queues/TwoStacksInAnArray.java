import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoStacksInAnArray {
    public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;

        public TwoStack(int cap) {
            // write your code here
            this.data = new int[cap];
            this.tos1 = -1;
            this.tos2 = cap;
        }

        int size1() {
            // write your code here
            return this.tos1 + 1;
        }

        int size2() {
            // write your code here
            return this.data.length - this.tos2;
        }

        void push1(int val) {
            // write your code here
            if (this.size1() + this.size2() == this.data.length) {
                System.out.println("Stack overflow");
                return;
            }

            this.data[++this.tos1] = val;
        }

        void push2(int val) {
            // write your code here
            if (this.size1() + this.size2() == this.data.length) {
                System.out.println("Stack overflow");
                return;
            }

            this.data[--this.tos2] = val;
        }

        int pop1() {
            // write your code here
            if (this.size1() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            return this.data[this.tos1--];
        }

        int pop2() {
            // write your code here
            if (this.size2() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            return this.data[this.tos2++];
        }

        int top1() {
            // write your code here
            if (this.size1() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            return this.data[this.tos1];
        }

        int top2() {
            // write your code here
            if (this.size2() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            return this.data[this.tos2];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TwoStack st = new TwoStack(n);

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push1")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push1(val);
            } else if (str.startsWith("pop1")) {
                int val = st.pop1();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top1")) {
                int val = st.top1();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size1")) {
                System.out.println(st.size1());
            } else if (str.startsWith("push2")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push2(val);
            } else if (str.startsWith("pop2")) {
                int val = st.pop2();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top2")) {
                int val = st.top2();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size2")) {
                System.out.println(st.size2());
            }
            str = br.readLine();
        }
    }
}
