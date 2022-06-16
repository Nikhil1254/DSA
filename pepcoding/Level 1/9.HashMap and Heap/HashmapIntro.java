import java.util.HashMap;
import java.util.Set;

public class HashmapIntro {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        // put(key,val)
        hm.put("India", 375);
        hm.put("China", 435);
        hm.put("UK", 120);
        hm.put("India", 100);

        // printing hashmap
        System.out.println(hm);

        // containsKey(key)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("USA"));

        // get(key)
        System.out.println(hm.get("India"));
        System.out.println(hm.get("USA"));

        Set<String> keys = hm.keySet();
        for (String key : keys)
            System.out.println(key + " - " + hm.get(key));
    }
}

// Important points
// 1 - Order is not preserved in Hashmap
// 2 - all this operations are performed in O(1) time
