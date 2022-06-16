import java.util.Comparator;
import java.lang.Comparable;
import java.util.ArrayList;

public class GenericPriorityQueue {
    public static class PriorityQueue<T> {
        ArrayList<T> data;
        Comparator comp;

        public PriorityQueue() {
            data = new ArrayList<>();
            this.comp = null;
        }

        public PriorityQueue(Comparator comp) {
            data = new ArrayList<>();
            this.comp = comp;
        }

        // nlogn constructor
        public PriorityQueue(T[] arr) {
            data = new ArrayList<>();
            this.comp = null;
            for (T val : data)
                add(val);
        }

        public void add(T val) {
            // write your code here
            this.data.add(val);
            upheapify(this.size() - 1);
        }

        public void swap(int i, int j) {
            T ith = this.data.get(i);
            T jth = this.data.get(j);

            this.data.set(i, jth);
            this.data.set(j, ith);
        }

        public T remove() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Underflow");
                return null;
            }

            swap(0, this.size() - 1);
            T val = this.data.remove(this.size() - 1);
            downheapify(0);
            return val;
        }

        public T peek() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Underflow");
                return null;
            }

            return this.data.get(0);
        }

        public int size() {
            // write your code here
            return this.data.size();
        }

        public void upheapify(int ci) {
            if (ci == 0)
                return;

            int pi = (ci - 1) / 2; // parent idx

            if (this.isSmaller(ci, pi) < 0) {
                swap(ci, pi);
                upheapify(pi);
            }
        }

        public void downheapify(int pi) {
            int minIdx = pi; // min index

            int li = 2 * pi + 1; // left child index

            if (li < data.size() && this.isSmaller(li, minIdx) < 0)
                minIdx = li;

            int ri = pi * 2 + 2;
            if (ri < this.size() && this.isSmaller(ri, minIdx) < 0)
                minIdx = ri;

            if (minIdx != pi) {
                swap(pi, minIdx);
                downheapify(minIdx);
            }
        }

        private int isSmaller(int i, int j) {
            if (this.comp == null) {
                Comparable ith = (Comparable) this.data.get(i);
                Comparable jth = (Comparable) this.data.get(j);

                return ith.compareTo(jth); // child.compareTo(parent)
            } else {
                T ith = this.data.get(i);
                T jth = this.data.get(j);

                return comp.compare(ith, jth);
            }
        }
    }

    static class Student implements Comparable<Student> {
        int rno;
        int ht;
        int wt;

        public Student(int rno, int ht, int wt) {
            this.rno = rno;
            this.ht = ht;
            this.wt = wt;
        }

        public int compareTo(Student other) {
            // this- child , other - parent
            // if -ve value return swap will happen
            return this.rno - other.rno;
        }

        public String toString() {
            return "rno : " + this.rno + ", ht : " + this.ht + ", wt : " + this.wt;
        }
    }

    static class StudentHtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            // s1 is child and s2 is parent
            // if -ve value return swap will happen
            return s1.ht - s2.ht;
        }
    }

    static class StudentWtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            // s1 is child and s2 is parent
            // if -ve value return swap will happen
            return s1.wt - s2.wt;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentHtComparator());

        pq.add(new Student(5, 120, 89));
        pq.add(new Student(1, 111, 76));
        pq.add(new Student(12, 165, 67));
        pq.add(new Student(7, 132, 72));

        while (pq.size() > 0)
            System.out.println(pq.remove());

        // if we dont pass comparator object t will sort on basis on comparable
        // and if we give comparator it will sort on the basis of that
    }
}
