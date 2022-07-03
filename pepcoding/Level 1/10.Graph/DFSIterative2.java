import java.util.*;
import java.io.*;

// sir approach - 
// exactly same as BFS but we are using stack here instead of queue
// which result in DFS traversal , cause we go into depth due to stack
public class DFSIterative2 {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int vtx; // vertex
        String psf; // path so far

        public Pair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
        }
    }

    public static void DFSIterative(ArrayList<Edge>[] graph, int src) {
        Stack<Pair> st = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        st.push(new Pair(src, src + ""));

        while (st.size() > 0) {
            Pair rem = st.pop(); // remove

            // if we are not visited do ork
            if (visited[rem.vtx] == false) {
                visited[rem.vtx] = true; // mark ourself visited first

                System.out.println(rem.vtx + "@" + rem.psf); // work - printing

                // add unvisited neighbours
                for (Edge e : graph[rem.vtx])
                    if (visited[e.nbr] == false)
                        st.push(new Pair(e.nbr, rem.psf + e.nbr));
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here
        DFSIterative(graph, src);
    }
}
