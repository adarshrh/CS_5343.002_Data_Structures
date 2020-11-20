
import java.util.*;

public class TopologicalSortDFS {
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;
    Map<String, Integer> color;
    Map<String, List<String>> adjList;
    List<String> topologicalOrder;
    List<String> nodes;

    TopologicalSortDFS(Map<String, List<String>> adjList, List<String> nodes){
        this.adjList = adjList;
        this.isPossible = true;
        this.nodes = nodes;
        this.color = new HashMap();
        this.topologicalOrder = new ArrayList();

        // By default all vertces are WHITE
        for (String node: nodes) {
            this.color.put(node, WHITE);
        }
    }


    private void dfs(String node) {

        // Don't recurse further if we found a cycle already
        if (!this.isPossible) {
            return;
        }

        // Start the recursion
        this.color.put(node, GRAY);

        // Traverse on neighboring vertices
        for (String neighbor : this.adjList.get(node)) {
            if (this.color.get(neighbor) == WHITE) {
                this.dfs(neighbor);
            } else if (this.color.get(neighbor) == GRAY) {
                // An edge to a GRAY vertex represents a cycle
                this.isPossible = false;
            }
        }

        // Recursion ends. We mark it as black
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }

    public String[] findOrder() {

        // If the node is unprocessed, then call dfs on it.
        for (String node : nodes) {
            if (this.color.get(node) == WHITE) {
                this.dfs(node);
            }
        }

        String[] order;
        if (this.isPossible) {
            order = new String[nodes.size()];
            for (int i = 0; i < nodes.size(); i++) {
                order[i] = this.topologicalOrder.get(nodes.size() - i - 1);
            }
        } else {
            order = new String[0];
        }

        return order;
    }

    public void printOrder(String[] order){
        if(order==null || order.length==0){
            System.out.println("Topological order does not exists because of loop");
            return;
        }
        boolean flag = true;
        for(String str: order){
            if(flag){
                System.out.print(str);
                flag = false;
            }else {
                System.out.print(","+str);
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        //Adjacency list for graph 1
        Map<String, List<String>> image1_adjList = new HashMap<>();
        image1_adjList.put("m",new ArrayList<String>(Arrays.asList("x", "q", "r")));
        image1_adjList.put("n",new ArrayList<String>(Arrays.asList("u", "q", "o")));
        image1_adjList.put("o",new ArrayList<String>(Arrays.asList("r", "v", "s")));
        image1_adjList.put("p",new ArrayList<String>(Arrays.asList("o", "s", "z")));
        image1_adjList.put("q",new ArrayList<String>(Arrays.asList("t")));
        image1_adjList.put("r",new ArrayList<String>(Arrays.asList("u", "y")));
        image1_adjList.put("s",new ArrayList<String>(Arrays.asList("r")));
        image1_adjList.put("u",new ArrayList<String>(Arrays.asList("t")));
        image1_adjList.put("v",new ArrayList<String>(Arrays.asList("x", "w")));
        image1_adjList.put("w",new ArrayList<String>(Arrays.asList("z")));
        image1_adjList.put("y",new ArrayList<String>(Arrays.asList("v")));
        image1_adjList.put("t",new ArrayList<String>());
        image1_adjList.put("x",new ArrayList<String>());
        image1_adjList.put("z",new ArrayList<String>());

        List<String> nodes = new ArrayList(Arrays.asList("m", "n", "o","p","q","r","s","t","u","v","w","x","y","z"));

        TopologicalSortDFS topologicalSortDFS = new TopologicalSortDFS(image1_adjList,nodes);

        System.out.println("DFS Topological order for graph 1");
        System.out.println("----------------------------------------------");

        topologicalSortDFS.printOrder(topologicalSortDFS.findOrder());
        System.out.println();

        //Adj list for graph 2
        System.out.println("DFS Topological order for graph 2");
        System.out.println("----------------------------------------------");

        Map<String, List<String>> image2_adjList = new HashMap<>();
        image2_adjList.put("1",new ArrayList<String>(Arrays.asList("2","5","6")));
        image2_adjList.put("2",new ArrayList<String>(Arrays.asList("7","5","3")));
        image2_adjList.put("3",new ArrayList<String>(Arrays.asList("4")));
        image2_adjList.put("4",new ArrayList<String>(Arrays.asList("5")));
        image2_adjList.put("5",new ArrayList<String>(Arrays.asList("7","8")));
        image2_adjList.put("6",new ArrayList<String>(Arrays.asList("8","5")));
        image2_adjList.put("7",new ArrayList<String>(Arrays.asList("8","4")));
        image2_adjList.put("8",new ArrayList<String>());

        nodes = new ArrayList(Arrays.asList("1","2","3","4","5","6","7","8"));

        topologicalSortDFS = new TopologicalSortDFS(image2_adjList,nodes);
        topologicalSortDFS.printOrder(topologicalSortDFS.findOrder());

    }
}
