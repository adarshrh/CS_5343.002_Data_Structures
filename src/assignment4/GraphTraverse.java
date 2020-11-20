package assignment4;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraverse {

    public static void main(String[] args){
      int[][] adjMatrix = { {0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
              {1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
              {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
              {0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
              {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
              {0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
              {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
              {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
              {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
              {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0},
              {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1},
              {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
              {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0}  };

      printGraph(adjMatrix);
      System.out.println("====================================================");
      System.out.println("DFS Traversal: ");
      dfs(0,adjMatrix, new boolean[adjMatrix.length]);
      System.out.println("====================================================");
      System.out.println("BFS Traversal");
      bfs(0,adjMatrix);



    }

    /**
     * Breadth first search traversal starting from vertex source
     * @param source
     * @param adjMatrix
     */
    private static void bfs(int source, int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.println(node);
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[node][i] == 1 && (!visited[i])) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    /**
     * Depth first search traversal starting from vertex source
     * @param source
     * @param adjMatrix
     * @param visited
     */
    private static void dfs(int source, int[][] adjMatrix, boolean[] visited) {

        System.out.println(source);
        visited[source] = true;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[source][i] == 1 && (!visited[i])) {
                dfs(i, adjMatrix,visited);
            }
        }
    }

    /**
     * Prints the node names and edges of undirected graph
     * @param adjMatrix
     */
    private static void printGraph(int[][] adjMatrix) {
        System.out.println("Nodes are:");
        for (int i=0;i<adjMatrix.length;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Edges: Undirected edges between the the vertices (u,v)");
        for (int i=0;i<adjMatrix.length;i++){
            for(int j=0;j<adjMatrix[0].length;j++){
                if(i>j && adjMatrix[i][j]==1)
                System.out.println("("+i+","+j+")");
            }
        }
    }
}
