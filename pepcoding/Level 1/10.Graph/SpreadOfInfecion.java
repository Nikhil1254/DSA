import java.util.*;
import java.io.*;

public class SpreadOfInfecion {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int v; // vertex
        int t; // infection time

        public Pair(int v, int t) {
            this.v = v;
            this.t = t;
        }
    }

    public static int infectionCount(ArrayList<Edge>[] graph, int src, int t, boolean[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 1));

        int count = 0;

        while (q.size() > 0) {
            Pair rem = q.remove();

            if (rem.t > t)
                break;

            if (visited[rem.v] == false) {
                visited[rem.v] = true;
                count++;

                for (Edge e : graph[rem.v])
                    if (visited[e.nbr] == false)
                        q.add(new Pair(e.nbr, rem.t + 1));
            }
        }

        return count;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        // write your code here
        boolean[] visited = new boolean[vtces];
        System.out.println(infectionCount(graph, src, t, visited));
    }
}
