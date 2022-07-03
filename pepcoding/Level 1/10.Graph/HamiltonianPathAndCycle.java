import java.util.*;
import java.io.*;

public class HamiltonianPathAndCycle {
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

        // write all your codes here
        boolean[] visited = new boolean[vtces];
        hamiltonianPathAndCycle(graph, src, visited, 1, src + "");
    }

    public static void hamiltonianPathAndCycle(ArrayList<Edge>[] graph, int src, boolean[] visited, int count,
            String psf) {
        if (graph.length == count) {
            if (isHamiltonianCycle(graph, psf))
                System.out.println(psf + "*");
            else
                System.out.println(psf + ".");

            return;
        }

        visited[src] = true;

        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false)
                hamiltonianPathAndCycle(graph, e.nbr, visited, count + 1, psf + e.nbr);
        }

        visited[src] = false;
    }

    private static boolean isHamiltonianCycle(ArrayList<Edge>[] graph, String path) {
        int fv = Integer.parseInt(path.charAt(0) + "");
        int lv = Integer.parseInt(path.charAt(graph.length - 1) + "");

        for (Edge e : graph[fv]) {
            if (e.nbr == lv)
                return true;
        }
        return false;
    }

}
