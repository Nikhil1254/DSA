import java.util.*;
import java.io.*;

// Topological sort is used for such kind of dependancy based problems.
public class OrderOfCompilation {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    // we are basically doing DFS traversal and adding vertices in post order manner
    // in stack
    public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {

        // mark ourself visited first
        visited[src] = true;

        // then add unvisited neighbours
        for (Edge e : graph[src])
            if (visited[e.nbr] == false)
                topologicalSort(graph, e.nbr, visited, st);

        // push ourself into stack in postorder manner
        st.push(src);
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
        }

        // write your code here ---------------------------------------------------

        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();

        // same as get connected components
        // in order to process all the components
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false)
                topologicalSort(graph, v, visited, st);
        }

        // printing topological sort
        // reverse of topological sort is nothing but order of work.
        while (st.size() > 0)
            System.out.println(st.pop());
    }
}
