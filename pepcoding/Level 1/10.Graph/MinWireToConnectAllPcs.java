
// Prims algorithm
import java.util.*;
import java.io.*;

public class MinWireToConnectAllPcs {
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
        int v; // our vertex
        int av; // aquring vertex - i.e. from which vertex we reached our vertex
        int wt; // weight of edge between vetrex and aquring vertex

        public Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }
    }

    public static void primsAlgo(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.wt - p2.wt);
        pq.add(new Pair(src, -1, 0));

        while (pq.size() > 0) {
            Pair rem = pq.remove();

            if (visited[rem.v] == false) {
                visited[rem.v] = true;

                if (rem.av != -1)
                    System.out.println("[" + rem.v + "-" + rem.av + "@" + rem.wt + "]");

                for (Edge e : graph[rem.v])
                    if (visited[e.nbr] == false)
                        pq.add(new Pair(e.nbr, rem.v, e.wt));
            }
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

        // write your code here
        boolean[] visited = new boolean[vtces];

        primsAlgo(graph, 0, visited);
    }
}
