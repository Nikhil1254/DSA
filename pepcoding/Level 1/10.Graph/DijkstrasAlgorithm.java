
//shortes path in weights question -
import java.util.*;
import java.io.*;

public class DijkstrasAlgorithm {
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
        // write your code here

        boolean[] visited = new boolean[vtces];
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.wsf - p2.wsf); // p1-child , p2-parent , we swap
                                                                                   // when -ve value is returned.
        pq.add(new Pair(src, src + "", 0));

        while (pq.size() > 0) {
            Pair rem = pq.remove();

            if (visited[rem.v] == false) {
                visited[rem.v] = true;

                System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

                for (Edge e : graph[rem.v])
                    if (visited[e.nbr] == false)
                        pq.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
            }
        }
    }

    static class Pair {
        int v;
        String psf;
        int wsf;

        public Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }
    }
}
