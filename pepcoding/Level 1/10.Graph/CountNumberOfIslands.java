import java.util.*;
import java.io.*;

public class CountNumberOfIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        // write your code here
        int count = 0;
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && visited[i][j] == false) {
                    // its land and its not visited
                    dfs(arr, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int[][] graph, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= graph.length || j >= graph[0].length || graph[i][j] == 1 || visited[i][j] == true)
            return;

        // making ourself visited
        visited[i][j] = true;

        // visiting all four sides of land
        dfs(graph, i - 1, j, visited);
        dfs(graph, i, j - 1, visited);
        dfs(graph, i + 1, j, visited);
        dfs(graph, i, j + 1, visited);
    }
}
