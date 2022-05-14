import java.util.ArrayList;

public class GetStairsPath {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        ArrayList<String> res = new ArrayList<>();

        for (int jump = 1; jump <= 3 && jump <= n; jump++) {
            ArrayList<String> cb = getStairPaths(n - jump);

            for (String path : cb)
                res.add(jump + path);
        }

        return res;
    }
}
