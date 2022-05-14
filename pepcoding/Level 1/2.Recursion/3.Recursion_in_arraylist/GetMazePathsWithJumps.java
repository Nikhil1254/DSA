import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathsWithJumps {
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
        ArrayList<String> dp = new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();

        // horizontal
        for (int i = 1; sc + i <= dc; i++) {
            hp = getMazePaths(sr, sc + i, dr, dc);

            for (String hPath : hp)
                paths.add("h" + i + hPath);
        }

        // vertical
        for (int i = 1; sr + i <= dr; i++) {
            vp = getMazePaths(sr + i, sc, dr, dc);

            for (String vPath : vp)
                paths.add("v" + i + vPath);
        }

        // digonal
        for (int i = 1; sr + i <= dr && sc + i <= dc; i++) {
            dp = getMazePaths(sr + i, sc + i, dr, dc);

            for (String dPath : dp)
                paths.add("d" + i + dPath);
        }

        return paths;
    }
}
