import java.util.*;
import java.io.*;

public class IsCyclePresent {
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

    static class Pair {
        int v;
        String psf;

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }

    public static boolean isCyclePresent(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));

        while (queue.size() > 0) {
            Pair rm = queue.remove();

            // already visited means cycle present -i.e. we found 2 paths for the same
            // vertex -> cycle is present
            if (visited[rm.v] == true)
                return true;

            visited[rm.v] = true;

            for (Edge e : graph[rm.v])
                if (visited[e.nbr] == false)
                    queue.add(new Pair(e.nbr, rm.psf + e.nbr));
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

        // write your code here
        boolean[] visited = new boolean[vtces];

        // looping on all vertices cause it can be possible that we get disconnected graph in that case we need to explore all components thats why
        // looping over all vertices so that all components should get explored
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                boolean cycle = isCyclePresent(graph, v, visited);
                if (cycle) {
                    // cycle present
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
}