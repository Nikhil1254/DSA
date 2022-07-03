import java.util.*;
import java.io.*;

// My approach - using state variable like we used to do in trees for iterative traversals
public class DFSIterative {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int vtx;
        String psf;
        int state;

        public Pair(int vtx, String psf, int state) {
            this.vtx = vtx;
            this.psf = psf;
            this.state = state;
        }
    }

    public static void DFSIterative(ArrayList<Edge>[] graph, int src, int dest) {
        boolean[] visited = new boolean[graph.length];
        Stack<Pair> st = new Stack<>();

        st.push(new Pair(src, src + "", -1));

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == -1) {
                // first time visiting - pre
                visited[top.vtx] = true;

                if (top.vtx == dest)
                    System.out.println(top.vtx + "@" + top.psf);
                top.state++;
            } else if (top.state == graph[top.vtx].size()) {
                // last time visiting going back - post
                visited[top.vtx] = false;
                st.pop();
            } else {
                // intermediate visitings
                Edge e = graph[top.vtx].get(top.state);

                if (visited[e.nbr] == false)
                    st.push(new Pair(e.nbr, top.psf + e.nbr, -1));

                top.state++;
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
        int dest = Integer.parseInt(br.readLine());

        // write your code here
        DFSIterative(graph, src, dest);
    }
}
