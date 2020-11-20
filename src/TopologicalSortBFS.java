import java.util.*;

public class TopologicalSortBFS {

    List<String> topologicalOrder;
    List<String> nodes;
    Map<String, List<String>> adjList;
    boolean isPossible;
    Map<String,Integer> inDegreeMap;

    TopologicalSortBFS(Map<String, List<String>> adjList, List<String> nodes){
        this.adjList = adjList;
        this.isPossible = true;
        this.nodes = nodes;
        this.topologicalOrder = new ArrayList();
        inDegreeMap = new HashMap<>();
        for(String node: adjList.keySet()){
            inDegreeMap.put(node,0);
        }

    }

    public String[] findOrder() {

        isPossible = true;
        String[] topologicalOrder = new String[adjList.size()];

        for (String node: adjList.keySet()) {
            // Record in-degree of each vertex
            for(String nbr: adjList.get(node)){
                inDegreeMap.put(nbr,inDegreeMap.get(nbr)+1);
            }

        }

        // Add all vertices with 0 in-degree to the queue
        Queue<String> q = new LinkedList<String>();
        for (String node: nodes) {
            if (inDegreeMap.get(node) == 0) {
                q.add(node);
            }
        }

        int i = 0;
        // Process until the Q becomes empty
        while (!q.isEmpty()) {
            String node = q.remove();
            topologicalOrder[i++] = node;

            // Reduce the in-degree of each neighbor by 1
            if (adjList.containsKey(node)) {
                for (String neighbor : adjList.get(node)) {
                    inDegreeMap.put(neighbor,inDegreeMap.get(neighbor)-1);
                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (inDegreeMap.get(neighbor) == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        // Check to see if topological sort is possible or not.
        if (i == nodes.size()) {
            return topologicalOrder;
        }

        return new String[0];
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

        TopologicalSortBFS topologicalSortBFS = new TopologicalSortBFS(image1_adjList,nodes);
        String[] topologicalOrder = topologicalSortBFS.findOrder();
        System.out.println("BFS Topological order for graph 1");
        System.out.println("----------------------------------------------");
        topologicalSortBFS.printOrder(topologicalOrder);
        System.out.println();

        //Adj list for graph 2

        System.out.println("BFS Topological order for graph 2");
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
        topologicalSortBFS = new TopologicalSortBFS(image2_adjList,nodes);
        topologicalSortBFS.printOrder(topologicalSortBFS.findOrder());

    }
}
