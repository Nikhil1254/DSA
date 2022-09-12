import java.util.*;

public class l023_LRUCache {

    public static class LRUCache {

        class ListNode {
            int key, value;
            ListNode next, prev;

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private HashMap<Integer, ListNode> map;
        int capacity; // maximum apps that can be opened
        int size; // current no of apps opened
        ListNode head, tail;

        private void initialize(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.map = new HashMap<>();
            this.head = this.tail = null;
        }

        public LRUCache(int capacity) {
            initialize(capacity);
        }

        public int get(int key) {
            if (!this.map.containsKey(key))
                return -1;

            ListNode node = this.map.get(key);
            makeRecent(node);
            return node.value;
        }

        // app name, app state
        public void put(int key, int value) {
            if (this.map.containsKey(key)) {
                // app already exist
                ListNode node = this.map.get(key);
                node.value = value;
                makeRecent(node);
            } else {
                // app opened for the first time
                ListNode node = new ListNode(key, value);
                if (this.size == this.capacity) // capacity is full need to remove oldest app
                {
                    ListNode rnode = removeFirst();
                    this.map.remove(rnode.key);
                }

                addLast(node);
                this.map.put(key, node);
            }
        }

        // helper functions
        private void makeRecent(ListNode node) {
            if (node == this.tail) // if opened app is recent app only
                return;

            remove(node);
            addLast(node);
        }

        private void addLast(ListNode node) {
            if (this.head == null)
                this.head = this.tail = node;
            else {
                this.tail.next = node;
                node.prev = this.tail;
                this.tail = this.tail.next;
            }
            this.size++;
        }

        private ListNode removeFirst() {
            if (this.size == 0) // this will not happen but for safer side
                return null;
            else if (this.size == 1) {
                ListNode node = this.head;
                this.head = this.tail = null;
                this.size--;
                return node;
            }

            ListNode node = this.head;
            this.head = this.head.next;
            node.next = this.head.prev = null;
            this.size--;
            return node;
        }

        private ListNode removeLast() {
            if (this.size == 0) // this will not happen but for safer side
                return null;
            else if (this.size == 1) {
                ListNode node = this.head;
                this.head = this.tail = null;
                this.size--;
                return node;
            }

            ListNode node = this.tail;
            this.tail = this.tail.prev;
            this.tail.next = node.prev = null;
            this.size--;
            return node;
        }

        private ListNode remove(ListNode node) {
            if (this.head == node)
                return removeFirst();
            else if (this.tail == node)
                return removeLast();

            ListNode prev = node.prev, forw = node.next;
            prev.next = forw;
            forw.prev = prev;
            node.next = node.prev = null;
            this.size-- ;
            return node;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // no of operations
        // 0 stand for put, 1 stand for get
        int size = scn.nextInt();
        LRUCache lru = new LRUCache(size);

        while (n-- > 0) {
            int op = scn.nextInt();
            if (op == 0)
                lru.put(scn.nextInt(), scn.nextInt());
            else
                System.out.println(lru.get(scn.nextInt()));
        }
    }

}