import java.util.Scanner;

public class MazePaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();

        printMazePaths(0, 0, nr - 1, nc - 1, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        if (sc + 1 <= dc)
            printMazePaths(sr, sc + 1, dr, dc, psf + "h");

        if (sr + 1 <= dr)
            printMazePaths(sr + 1, sc, dr, dc, psf + "v");
    }
}
