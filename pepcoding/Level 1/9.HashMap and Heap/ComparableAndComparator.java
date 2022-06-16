import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparableAndComparator {

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
            // this-child , other-parent
            // if -ve value is returned then swapping takes place
            // -ve value show child smaller than parent swap
            return this.rno - other.rno;
        }

        public String toString() {
            return "rno : " + this.rno + ", ht : " + this.ht + ", wt : " + this.wt;
        }
    }

    static class StudentHtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            // s1 is child and s2 is parent
            return s1.ht - s2.ht;
        }
    }

    static class StudentWtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            // s1 is child and s2 is parent
            return s1.wt - s2.wt;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentWtComparator());

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
