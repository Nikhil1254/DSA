public class CustomLinkedList {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (head == null)
                head = tail = temp;
            else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size() {
            // write code here
            return this.size;
        }

        public void display() {
            // write code here
            if (head == null)
                return;

            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public void removeFirst() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            Node temp = head;
            head = head.next;
            temp.next = null;
            size--;

            if (size == 0)
                head = tail = null;
        }

        public int getFirst() {
            // write your code here
            if (head == null) {
                System.out.println("List is empty");
                return -1;
            }

            return head.data;
        }

        public int getLast() {
            // write your code here
            if (head == null) {
                System.out.println("List is empty");
                return -1;
            }

            return tail.data;
        }

        public int getAt(int idx) {
            // idx = 0 to size-1
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            }

            if (head == null) {
                System.out.println("List is empty");
                return -1;
            }

            if (idx == 0)
                return getFirst();

            if (idx == size - 1)
                return getLast();

            int count = 0;
            Node temp = head;

            while (count != idx) {
                temp = temp.next;
                count++;
            }
            return temp.data;
        }

        public void addFirst(int val) {
            // write your code here
            Node node = new Node();
            node.data = val;

            if (head == null)
                head = tail = node;
            else {
                node.next = head;
                head = node;
            }

            size++;

        }

        public void addAt(int idx, int val) {
            // write your code here
            if (idx == 0)
                addFirst(val);
            else if (idx == size)
                addLast(val);
            else if (idx > 0 && idx < size) {
                int count = 0;
                Node temp = head;

                while (count != idx - 1) {
                    temp = temp.next;
                    count++;
                }

                Node node = new Node();
                node.data = val;
                node.next = temp.next;
                temp.next = node;
                size++;

            } else
                System.out.println("Invalid arguments");
        }

        public void removeLast() {
            // write your code here
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            if (size == 1) {
                head = tail = null;
                return;
            }

            Node temp = head;

            while (temp.next != tail)
                temp = temp.next;

            temp.next = null;
            tail = temp;

            size--;
        }

        public void removeAt(int idx) {
            // write your code here
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return;
            }

            if (size == 0) {
                System.out.println("List is empty");
                return;
            }

            if (idx == 0)
                removeFirst();
            else if (idx == size - 1)
                removeLast();
            else {
                int count = 0;
                Node temp = head;

                while (count != idx - 1) {
                    temp = temp.next;
                    count++;
                }

                Node node = temp.next;
                temp.next = node.next;
                node.next = null;
                size--;
            }
        }

        public void reverseDI() {
            // data iterative
            if (size == 0)
                return;

            int li = 0;
            int ri = size - 1;

            while (li < ri) {
                Node leftNode = getNodeAt(li);
                Node rightNode = getNodeAt(ri);
                swap(leftNode, rightNode);

                li++;
                ri--;
            }
        }

        public Node getNodeAt(int idx) {
            if (idx < 0 || idx >= size)
                return null;

            int count = 0;
            Node temp = head;

            while (count != idx) {
                temp = temp.next;
                count++;
            }

            return temp;
        }

        public void swap(Node n1, Node n2) {
            int temp = n1.data;
            n1.data = n2.data;
            n2.data = temp;
        }
    
        public void reversePI(){
            // write your code here
              if(size<=1)
                  return ;
              
              Node prev = null ;
              Node cur = head ;
              
              while(cur!=null){
                  Node temp = cur.next ;
                  cur.next = prev ;
                  
                  prev = cur ;
                  cur = temp ;
              }
              
              Node temp = head ;
              head = tail ;
              tail = temp;
          }
    
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            }
            str = br.readLine();
        }

        testList(list);
    }
}
