import java.util.ArrayList;
import java.util.Scanner;

public class GraphUsingAdjacancyList {
    static class Edge {
        int src; // source
        int nbr; // neighbour
        int wt; // weight of edge

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // no of vertices
        int e = scn.nextInt(); // no of edges

        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int src = scn.nextInt();
            int nbr = scn.nextInt();
            int wt = scn.nextInt();

            graph[src].add(new Edge(src, nbr, wt));
            graph[nbr].add(new Edge(nbr, src, wt));
        }

        displayGraph(graph);
    }

    public static void displayGraph(ArrayList<Edge>[] graph) {

        for (ArrayList<Edge> list : graph) {
            for (Edge e : list)
                System.out.println(e.src + "-" + e.nbr + "@" + e.wt);
        }
    }
}
