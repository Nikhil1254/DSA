import java.util.*;
import java.io.*;

public class ImplementHashmap {
    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        private int hashfn(K key) {
            int code = key.hashCode();
            return Math.abs(code) % buckets.length;
        }

        private void rehash() throws Exception {
            LinkedList<HMNode>[] old = buckets;

            initbuckets(old.length * 2);
            size = 0;

            for (int i = 0; i < old.length; i++) {
                for (HMNode node : old[i])
                    put(node.key, node.value);
            }
        }

        private int getIndexWithinBucket(K key, int bi) {
            int idx = 0;

            for (HMNode node : buckets[bi]) {
                if (node.key.equals(key))
                    return idx;
                else
                    idx++;
            }

            return -1;
        }

        public void put(K key, V value) throws Exception {
            // write your code here
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);

            if (di != -1) {
                // element alread present
                HMNode node = buckets[bi].get(di);
                node.value = value;
            } else {
                HMNode node = new HMNode(key, value);
                buckets[bi].add(node);
                size++;
            }

            double lam = size * 1.0 / buckets.length;

            if (lam > 2.0)
                rehash();
        }

        public V get(K key) throws Exception {
            // write your code here
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);

            if (di != -1) {
                // element alread present
                return buckets[bi].get(di).value;
            } else {
                return null;
            }
        }

        public boolean containsKey(K key) {
            // write your code here
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);

            if (di != -1) {
                // element alread present
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) throws Exception {
            // write your code here
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);

            if (di != -1) {
                // element alread present
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keyset() throws Exception {
            // write your code here
            ArrayList<K> list = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                for (HMNode node : buckets[i])
                    list.add(node.key);
            }

            return list;
        }

        public int size() {
            // write your code here
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}
