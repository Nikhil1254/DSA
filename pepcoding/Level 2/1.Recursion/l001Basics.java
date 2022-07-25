import java.util.*;

public class l001Basics {
    // ===================================================================================
    // Basic codes on recursion

    public static void printIncreasing(int a, int b) {
        if (a > b)
            return;

        System.out.println(a);
        printIncreasing(a + 1, b);
    }

    public static void printDecreasing(int a, int b) {
        if (a > b)
            return;

        printDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void printIncreasingDecreasing(int a, int b) {
        if (a > b)
            return;

        System.out.println(a);
        printIncreasingDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void printOddEven(int a, int b) {
        if (a > b)
            return;

        if (a % 2 != 0)
            System.out.println(a);

        printOddEven(a + 1, b);

        if (a % 2 == 0)
            System.out.println(a);
    }

    public static int fact(int n) {
        return n == 0 ? 1 : n * fact(n - 1);
    }

    public static int powerLinear(int x, int n) {
        return n == 0 ? 1 : x * powerLinear(x, n - 1);
    }

    public static int powerLogarithmic(int x, int n) {
        if (n == 0)
            return 1;

        int smallAns = powerLogarithmic(x, n / 2);

        return n % 2 == 0 ? smallAns * smallAns : smallAns * smallAns * x;
    }

    // Recursion on Array and ArrayList -

    public static void displayArr(int[] arr, int idx) {
        if (idx == arr.length)
            return;

        System.out.print(arr[idx] + "\t");
        displayArr(arr, idx + 1);
    }

    public static void displayArrRev(int[] arr, int idx) {
        if (idx == arr.length)
            return;

        displayArrRev(arr, idx + 1);
        System.out.print(arr[idx] + "\t");
    }

    public static boolean find(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return false;

        return arr[idx] == data || find(arr, idx + 1, data);
    }

    public static int firstIndex(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return -1;

        return data == arr[idx] ? idx : firstIndex(arr, idx + 1, data);
    }

    public static int lastIndex(int[] arr, int idx, int data) {
        if (arr.length == idx)
            return -1;

        int lastIdx = lastIndex(arr, idx + 1, data); // faith

        return lastIdx != -1 ? lastIdx : (arr[idx] == data ? idx : -1);
    }

    public static int minimum(int[] arr, int idx) {
        if (idx == arr.length)
            return (int) 1e9;

        return Math.min(arr[idx], minimum(arr, idx + 1));
    }

    public static int maximum(int[] arr, int idx) {
        if (arr.length == idx)
            return -(int) 1e9;

        return Math.max(arr[idx], maximum(arr, idx + 1));
    }

    // ==========================================================================================
    // get all indices - on the way down

    public static int[] allIndices(int[] arr, int data, int idx, int fsf) {
        if (idx == arr.length) {
            return new int[fsf];
        }

        int[] rarr = arr[idx] == data ? allIndices(arr, data, idx + 1, fsf + 1) : allIndices(arr, data, idx + 1, fsf);

        if (arr[idx] == data)
            rarr[fsf] = idx;

        return rarr;
    }

    // =======================================================================================
    // get subsequnce - on the way down

    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> rlist = gss(str.substring(1)); // faith

        int size = rlist.size();
        char ch = str.charAt(0);

        for (int i = 0; i < size; i++)
            rlist.add(ch + rlist.get(i));

        return rlist;
    }

    public static ArrayList<String> gss(String str, int idx) {

        if (str.length() == idx) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> recRes = gss(str, idx + 1);

        int size = recRes.size();
        for (int i = 0; i < size; i++)
            recRes.add(str.charAt(idx) + recRes.get(i));

        return recRes;
    }

    // ==========================================================================================
    // get KPC - on the way down

    public static ArrayList<String> getKPC(String str, String[] comb) {
        if (str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> rlist = getKPC(str.substring(1), comb);

        String s = comb[str.charAt(0) - '0'];
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            for (String st : rlist)
                res.add(ch + st);
        }

        return res;
    }

    // ==========================================================================================
    // get stair paths - on the way down
    public static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int jump = 1; n - jump >= 0 && jump <= 3; jump++) {
            for (String path : getStairPaths(n - jump))
                ans.add(jump + path);
        }

        return ans;
    }

    // ==========================================================================================
    // print subsequnce - on the way up

    public static int printSS(String str, int idx, String ans, ArrayList<String> res) {
        if (idx == str.length()) {
            res.add(ans);
            return 1;
        }

        int count = 0;
        char ch = str.charAt(idx);

        count += printSS(str, idx + 1, ans + ch, res); // included in ans
        count += printSS(str, idx + 1, ans, res); // not included in ans

        return count;
    }

    // ==========================================================================================
    // print kpc - on the way up
    // used index instead of substring to optimize
    // on the way up we will pass arraylist or array and in that we will add our
    // answer in our base case

    public static int printKPC(String str, int idx, String asf, String[] keys, ArrayList<String> list) {
        if (idx == str.length()) {
            list.add(asf);
            // System.out.println(asf);
            return 1;
        }

        int count = 0;
        String ss = keys[str.charAt(idx) - '0'];

        for (int i = 0; i < ss.length(); i++)
            count += printKPC(str, idx + 1, asf + ss.charAt(i), keys, list);

        return count;
    }

    // ============================================================================================
    // print stair paths - on the way up
    // it will give us 2 things - all possible ways , count of all possible ways
    public static int printStairPaths(int n, String path, ArrayList<String> list) {
        if (n == 0) {
            list.add(path);
            return 1;
        }

        int count = 0;
        for (int jump = 1; jump <= 3 && n - jump >= 0; jump++)
            count += printStairPaths(n - jump, path + jump, list);

        return count;
    }

    // =======================================================================================
    // Maze Path -
    /*
     * Always make valid calls only , same code we can use then in DP as well if we
     * make only valid calls
     */

    // single jump allowed(top to bottom approach) - horizontal,vertical,diagonal -
    public static ArrayList<String> mazePath_HVD(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }

        ArrayList<String> allPaths = new ArrayList<>();

        // horizontal call
        if (sc + 1 <= ec) {
            ArrayList<String> hPaths = mazePath_HVD(sr, sc + 1, er, ec);

            for (String path : hPaths)
                allPaths.add("h" + path);
        }

        // vertical call
        if (sr + 1 <= er) {
            ArrayList<String> vPaths = mazePath_HVD(sr + 1, sc, er, ec);

            for (String path : vPaths)
                allPaths.add("v" + path);
        }

        // diagonal call
        if (sr + 1 <= er && sc + 1 <= ec) {
            ArrayList<String> dPaths = mazePath_HVD(sr + 1, sc + 1, er, ec);

            for (String path : dPaths)
                allPaths.add("d" + path);
        }

        return allPaths;
    }

    // single jump allowed(bottom top approach) - horizontal,vertical,diagonal
    public static int mazePath_HVD(int sr, int sc, int er, int ec, String psf, ArrayList<String> paths) {

        if (sr == er && sc == ec) {
            paths.add(psf);
            return 1;
        }

        int count = 0;

        if (sc + 1 <= ec)
            count += mazePath_HVD(sr, sc + 1, er, ec, psf + "h", paths);
        if (sr + 1 <= er)
            count += mazePath_HVD(sr + 1, sc, er, ec, psf + "v", paths);
        if (sr + 1 <= er && sc + 1 <= ec)
            count += mazePath_HVD(sr + 1, sc + 1, er, ec, psf + "d", paths);

        return count;
    }

    // infinite jumps allowed(top down approach)
    public static ArrayList<String> mazePath_HVD_multi(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }

        ArrayList<String> allPaths = new ArrayList<>();

        // horizontal call
        for (int jump = 1; sc + jump <= ec; jump++) {
            ArrayList<String> hPaths = mazePath_HVD_multi(sr, sc + jump, er, ec);

            for (String path : hPaths)
                allPaths.add("h" + jump + path);
        }

        // vertical call
        for (int jump = 1; sr + jump <= er; jump++) {
            ArrayList<String> vPaths = mazePath_HVD_multi(sr + jump, sc, er, ec);

            for (String path : vPaths)
                allPaths.add("v" + jump + path);
        }

        // diagonal call
        for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++) {
            ArrayList<String> dPaths = mazePath_HVD_multi(sr + jump, sc + jump, er, ec);

            for (String path : dPaths)
                allPaths.add("d" + jump + path);
        }

        return allPaths;
    }

    // infinite jumps allowed (bottom top approach) -
    public static int mazePath_HVD_multi(int sr, int sc, int er, int ec, String psf, ArrayList<String> paths) {
        if (sr == er && sc == ec) {
            paths.add(psf);
            return 1;
        }

        int count = 0;

        for (int jump = 1; sc + jump <= ec; jump++)
            count += mazePath_HVD_multi(sr, sc + jump, er, ec, psf + "h" + jump, paths);
        for (int jump = 1; sr + jump <= er; jump++)
            count += mazePath_HVD_multi(sr + jump, sc, er, ec, psf + "v" + jump, paths);
        for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++)
            count += mazePath_HVD_multi(sr + jump, sc + jump, er, ec, psf + "d" + jump, paths);

        return count;
    }

    // generic - using direction array(single jump allowed)
    public static int mazePath_HVD_2(int sr, int sc, int er, int ec, String psf, ArrayList<String> paths, int[][] dir,
            String[] dirS) {

        if (sr == er && sc == ec) {
            paths.add(psf);
            return 1;
        }

        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec)
                count += mazePath_HVD_2(r, c, er, ec, psf + dirS[d], paths, dir, dirS);
        }

        return count;
    }

    // =============================================================================
    // Flood fill - using direction array only (generic approach) - single jump
    // allowed
    public static int floodFill(int sr, int sc, boolean[][] visited, int[][] dir, String[] dirS, String psf,
            ArrayList<String> paths) {

        if (sr == visited.length - 1 && sc == visited[0].length - 1) {
            paths.add(psf);
            return 1;
        }

        visited[sr][sc] = true;

        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < visited.length && c < visited[0].length && visited[r][c] == false)
                count += floodFill(r, c, visited, dir, dirS, psf + dirS[d], paths);
        }

        visited[sr][sc] = false;
        return count;
    }

    // multiple jumps allowed - using direction array and radius for jump
    public static int floodFill_multi(int sr, int sc, boolean[][] visited, int[][] dir, String[] dirS, String psf,
            ArrayList<String> paths) {
        int n = visited.length, m = visited[0].length;

        if (sr == n - 1 && sc == m - 1) {
            paths.add(psf);
            return 1;
        }

        visited[sr][sc] = true;

        int count = 0;

        // this loop order is importatnt - direction->radius
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= Math.max(n, m); rad++) {
                int row = sr + rad * dir[d][0];
                int col = sc + rad * dir[d][1];

                if (row >= 0 && col >= 0 && row < n && col < m) {
                    if (visited[row][col] == false)
                        count += floodFill_multi(row, col, visited, dir, dirS, psf + dirS[d] + rad, paths);
                } else
                    break;
            }
        }

        visited[sr][sc] = false;
        return count;
    }

    // ==========================================================================================

    // 1. Rat in maze -
    // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
    public static ArrayList<String> findPath(int[][] mat, int n) {
        // Your code here

        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0)
            return new ArrayList<String>();

        ArrayList<String> res = new ArrayList<>();
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        String[] dirS = { "U", "D", "L", "R" };

        int count = floodFill(0, 0, mat, dir, dirS, res, "");
        return res;
    }

    public static int floodFill(int sr, int sc, int[][] mat, int[][] dir, String[] dirS, ArrayList<String> res,
            String psf) {
        int n = mat.length, m = mat[0].length;

        if (sr == n - 1 && sc == m - 1) {
            res.add(psf);
            return 1;
        }

        mat[sr][sc] = 0;
        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && mat[r][c] == 1)
                count += floodFill(r, c, mat, dir, dirS, res, psf + dirS[d]);
        }

        mat[sr][sc] = 1;
        return count;
    }

    // -------------------------------------------------------------------------------
    // 2.special matrix(DP question)
    // https://practice.geeksforgeeks.org/problems/special-matrix4201/1#
    public int FindWays(int n, int m, int[][] blocked_cells) {
        // Code here
        boolean[][] vis = new boolean[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];

        for (int r = 0; r < dp.length; r++)
            for (int c = 0; c < dp[0].length; c++)
                dp[r][c] = -1;

        for (int r = 0; r < blocked_cells.length; r++)
            vis[blocked_cells[r][0]][blocked_cells[r][1]] = true;

        if (vis[1][1] == true || vis[n][m] == true)
            return 0;

        int[][] dir = { { 0, 1 }, { 1, 0 } };

        return floodFill(1, 1, vis, dir, dp);
    }

    public int floodFill(int sr, int sc, boolean[][] vis, int[][] dir, int[][] dp) {
        int n = vis.length, m = vis[0].length;

        if (sr == n - 1 && sc == m - 1)
            return 1;

        if (dp[sr][sc] != -1)
            return dp[sr][sc];

        int count = 0;
        int mod = (int) 1e9 + 7;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && vis[r][c] == false)
                count = (count % mod + floodFill(r, c, vis, dir, dp) % mod) % mod;
        }

        dp[sr][sc] = count;
        return count;
    }

    // ---------------------------------------------------------------------------------------
    // 3. Rat in maze multi jumps allowed
    // https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/
    // we have written generic code - for all directions possible
    public static void display2D(int[][] arr) {
        System.out.println("Display");
        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }

        System.out.println("--------------------------------------------");
    }

    public static int floodFill(int sr, int sc, int[][] dir, int[][] mat, int[][] ans) {
        int n = mat.length, m = mat[0].length;

        if (sr == n - 1 && sc == m - 1) {
            ans[sr][sc] = 1;
            display2D(ans);
            ans[sr][sc] = 0;
            return 1;
        }

        int jump = mat[sr][sc];
        mat[sr][sc] = 0; // block
        ans[sr][sc] = 1; // psf

        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= jump; rad++) {

                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                // if we are outof bound then
                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (mat[r][c] != 0)
                        count += floodFill(r, c, dir, mat, ans);
                } else
                    break;
            }
        }

        mat[sr][sc] = jump; // unblock
        ans[sr][sc] = 0; // psf
        return count;
    }

    // -----------------------------------------------------------------------------------------
    // longest and shortest path possible Floodfill
    // 4 directions allowed and infinite jumps,some places my be blocked
    // first try to do it for single jump and modify it to multiple jumps

    public static class Pair {
        String psf;
        int len;

        public Pair(String psf, int len) {
            this.psf = psf;
            this.len = len;
        }
    }

    public static Pair longestPath(int sr, int sc, boolean[][] vis, int[][] dir, String[] dirS) {
        int n = vis.length, m = vis[0].length;

        if (sr == n - 1 && sc == m - 1) {
            return new Pair("", 0); // len==0 is mark that we hit base case
        }

        vis[sr][sc] = true;
        Pair ans = new Pair("", -1); // len==-1 means we are coming from place which was not base case , dead end

        for (int d = 0; d < dir.length; d++) {

            for (int jump = 1; jump < Math.max(n, m); jump++) {
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];

                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (vis[r][c] == false) {
                        Pair recAns = longestPath(r, c, vis, dir, dirS);
                        if (recAns.len != -1 && recAns.len + 1 > ans.len) {
                            ans.len = recAns.len + 1;
                            ans.psf = dirS[d] + jump + recAns.psf;
                        }
                    }
                } else
                    break;
            }
        }

        vis[sr][sc] = false;
        return ans;
    }

    public static Pair shortestPath(int sr, int sc, boolean[][] vis, int[][] dir, String[] dirS) {
        int n = vis.length, m = vis[0].length;

        if (sr == n - 1 && sc == m - 1) {
            return new Pair("", 0); // len==0 is mark that we hit base case
        }

        vis[sr][sc] = true;
        Pair ans = new Pair("", (int) 1e9); // len==-1 means we are coming from place which was not base case

        for (int d = 0; d < dir.length; d++) {

            for (int jump = 1; jump < Math.max(n, m); jump++) {
                int r = sr + jump * dir[d][0];
                int c = sc + jump * dir[d][1];

                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (vis[r][c] == false) {
                        Pair recAns = shortestPath(r, c, vis, dir, dirS);
                        if (recAns.len != (int) 1e9 && recAns.len + 1 < ans.len) {
                            ans.len = recAns.len + 1;
                            ans.psf = dirS[d] + jump + recAns.psf;
                        }
                    }
                } else
                    break;
            }
        }

        vis[sr][sc] = false;
        return ans;
    }

    // ===========================================================================================
    // testing calls -

    public static void longestShortestPath() {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        String[] dirS = { "D", "R", "U", "L" };
        boolean[][] vis = new boolean[3][3];

        // vis[1][1] = vis[1][2] = vis[2][0] = true; // blocked cells

        Pair ans = longestPath(0, 0, vis, dir, dirS);
        System.out.println(ans.psf + " @ " + ans.len);
        ans = shortestPath(0, 0, vis, dir, dirS);
        System.out.println(ans.psf + " @ " + ans.len);

    }

    public static void mazePath() {
        // ArrayList<String> list = new ArrayList<>();
        // int count = mazePath_HVD(0, 0, 2, 2, "", list);
        // System.out.println(list);
        // System.out.println(mazePath_HVD(0, 0, 2, 2));
        // System.out.println(count);
        // System.out.println("-------------------------------------------------");
        // list = new ArrayList<>();
        // System.out.println(mazePath_HVD_multi(0, 0, 2, 2));
        // count = mazePath_HVD_multi(0, 0, 2, 2, "", list);
        // System.out.println(list);
        // System.out.println(count);

        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } }; // directions
        String[] dirS = { "H", "V", "D" }; // hori,verti,diagonal
        ArrayList<String> paths = new ArrayList<>();
        int count = mazePath_HVD_2(0, 0, 2, 2, "", paths, dir, dirS);
        System.out.println(paths);
        System.out.println(count);
    }

    public static void floodFill() {
        int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // directions
        String[] dirS = { "R", "L", "T", "D" }; // directions names right,left,top,down

        int n = 3, m = 3;
        boolean[][] visited = new boolean[n][m];

        ArrayList<String> paths = new ArrayList<>();
        // int count = floodFill(0, 0, visited, dir, dirS, "", paths);
        // System.out.println(paths);
        // System.out.println(count);

        int count = floodFill_multi(0, 0, visited, dir, dirS, "", paths);
        System.out.println(count);
        System.out.println(paths);
    }

    public static void sum(int n1, int n2) {
        int[] arr = { 1, 2, 3 };

        System.out.println(arr);

    }

    public static void main(String[] args) {
        // printIncreasing(5,9);
        // printDecreasing(5, 9);
        // printIncreasingDecreasing(5, 9);
        // printOddEven(1, 10);
        // System.out.println(fact(5));
        // System.out.println(powerLinear(2, 5));
        // System.out.println(powerLogarithmic(2, 5));

        int[] arr = { 12, 44, 11, -2, 3, -12, 78, 12, 33, 12, 52 };
        ArrayList<String> list = new ArrayList<>();
        int count = 0;

        // displayArr(arr, 0);
        // System.out.println(find(arr, 0, 12));
        // System.out.println(find(arr, 0, -22));
        // displayArrRev(arr, 0);
        // System.out.println(minimum(arr, 0));
        // System.out.println(maximum(arr, 0));
        // displayArr(allIndices(arr, 12, 0, 0), 0);
        // System.out.println(gss("abc"));
        // System.out.println(getKPC("78", new String[]{ ".;", "abc", "def", "ghi",
        // "jkl", "mno", "pqrs", "tu", "vwx", "yz" }));
        // System.out.println(getStairPaths(3));

        // count = printSS("abc", 0, "", list);
        // System.out.println(list);
        // System.out.println(count);
        // count = printKPC("78", 0, "", new String[] { ".;", "abc", "def", "ghi",
        // "jkl", "mno", "pqrs", "tu", "vwx", "yz" }, list);
        // System.out.println(count);
        // System.out.println(list);
        // System.out.println(printStairPaths(3, "", list));
        // System.out.println(list);
        // mazePath();
        // floodFill();

        // int[][] mat = {
        // { 2, 1, 0, 0 },
        // { 3, 0, 0, 1 },
        // { 0, 1, 0, 1 },
        // { 0, 0, 0, 1 }
        // };

        // int[][] dir = { { 0, 1 }, { 1, 0 } };
        // int[][] ans = new int[mat.length][mat[0].length];
        // System.out.println(floodFill(0, 0, dir, mat, ans));

        longestShortestPath();
        // System.out.println(gss("abc"));
        // System.out.println(gss("abc", 0));
    }
}
