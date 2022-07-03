import java.util.*;

public class GraphUsingAdjacancyMatrix {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // no of vertice
        int e = scn.nextInt(); // no of edges

        int[][] graph = new int[n][n];

        for (int i = 0; i < e; i++) {
            int src = scn.nextInt();
            int nb = scn.nextInt();
            int wt = scn.nextInt();

            // undirected graph
            graph[src][nb] = wt;
            graph[nb][src] = wt;
        }

        displayGraph(graph);
    }

    public static void displayGraph(int[][] graph){
        for(int i=0 ; i<graph.length ; i++){
            for(int j=0 ; j<graph[0].length ; j++){
                if(graph[i][j]!=0)
                    System.out.println(i+"-"+j+"@"+graph[i][j]);
            }
        }
    }
}