import java.util.PriorityQueue;

public class PriorityQueueIntro {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] arr = { 12, 1, 27, 23, 45, 31 };

        for (int ele : arr)
            pq.add(ele);

        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
