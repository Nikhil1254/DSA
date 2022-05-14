import java.util.ArrayList;
import java.util.Scanner;

public class getMazePaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();

        System.out.println(getMazePaths(0, 0, nr - 1, nc - 1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        ArrayList<String> hp = new ArrayList<>();
        ArrayList<String> vp = new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();

        // horizontal move
        if (sc + 1 <= dc)
            hp = getMazePaths(sr, sc + 1, dr, dc);

        // vertical move
        if (sr + 1 <= dr)
            vp = getMazePaths(sr + 1, sc, dr, dc);

        for (String hPath : hp)
            paths.add("h" + hPath);

        for (String vPath : vp)
            paths.add("v" + vPath);

        return paths;

    }
}
