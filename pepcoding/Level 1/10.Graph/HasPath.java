import java.util.*;
import java.io.*;

public class HasPath {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static int[] visited;

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {

        if (src == dest) // if im the dest or not
            return true;

        visited[src] = true; // mark ourself visited

        // asking unvisited nbr if their exist path between them to dest or not
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                boolean pathExist = hasPath(graph, e.nbr, dest, visited);
                if (pathExist)
                    return true;
            }
        }

        return false; 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        // write your code here
        boolean[] visited = new boolean[vtces];
        boolean hasPath = hasPath(graph, src, dest, visited);
        System.out.println(hasPath);

    }
}
