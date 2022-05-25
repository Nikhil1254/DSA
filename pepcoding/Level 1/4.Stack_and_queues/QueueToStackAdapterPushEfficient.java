import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapterPushEfficient {
    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            // write your code here
            return this.mainQ.size();
        }

        void push(int val) {
            // write your code here
            this.mainQ.add(val);
        }

        int pop() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            while (this.mainQ.size() > 1)
                this.helperQ.add(this.mainQ.remove());

            int val = this.mainQ.remove();

            Queue<Integer> temp = this.mainQ;
            this.mainQ = this.helperQ;
            this.helperQ = temp;
            return val;
        }

        int top() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            while (this.mainQ.size() > 1)
                this.helperQ.add(this.mainQ.remove());

            int val = this.mainQ.peek();
            this.helperQ.add(this.mainQ.remove());

            Queue<Integer> temp = this.mainQ;
            this.mainQ = this.helperQ;
            this.helperQ = temp;

            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        QueueToStackAdapter st = new QueueToStackAdapter();

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
            }
            str = br.readLine();
        }
    }
}
