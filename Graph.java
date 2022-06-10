import java.util.ArrayList;

public class Graph {

    ArrayList<ArrayList<Integer>> edges;

    public Graph() {
        this.edges = new ArrayList<ArrayList<Integer>>();
    }

    public void setEdges(){
        int nodes = this.getNodes();
        for (int i = 0; i < nodes; i++){
            ArrayList<Integer> edge = new ArrayList<Integer>();
            
            edge = this.getEdge(edge);
            
            this.edges.add(edge);
        }
    }

    public ArrayList<Integer> getEdge(ArrayList<Integer> edge){
        int nEdges = this.getNEdges();
        for (int i = 0; i < nEdges; i++){
            int e = Integer.parseInt(System.console().readLine());
            edge.add(e);
        }

        return edge;
    }

    public int getNEdges(){
        System.out.println("Please enter the number of edges: ");
        int nEdges = Integer.parseInt(System.console().readLine());
        return nEdges;
    }

    public int getNodes(){
        System.out.println("Please enter the number of nodes: ");
        int nodes = Integer.parseInt(System.console().readLine());
        return nodes;
    }

    public void displayGraph(){
        // displays the nodes:
        System.out.print("Nodes: ");
        for (int i = 1; i <= this.edges.size(); i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int traverse(){
        return 0;
    }

    public int minDistance(int[] distance, boolean[] included){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < distance.length; i++){
            if (included[i] == false && distance[i] <= min){
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void Dijkstra(int[][] arr, int src){

        int[] dist = new int[arr.length];

        boolean[] included = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++){
            // initialises the distance arrays.
            dist[i] = Integer.MAX_VALUE;
            included[i] = false;
        }

        // intialises the distance of the source node to 0.
        dist[src] = 0;

        for (int i = 0; i < arr.length - 1; i++){

            int u = minDistance(dist, included);

            included[i] = true;

            for (int j = 0; j < arr.length; j++){

                if (!included[j] && arr[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + arr[u][j] < dist[j]){
                    dist[j] = dist[u] + arr[u][j];
                }

            }

        }

        for (int i = 0; i < dist.length; i++){
            System.out.println("Distance from " + src + " to " + i + " is " + dist[i]);
        }

    }

    public static void main(String[] args) {
        
        // initialise a 2d array of int
        // int[][] arr = new int[][]{
        // //      1     2     3     4     5     6     7     8     9     10     11     12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30   31   32   33   34   35   36   37   38   39 
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0, 113,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 1
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 163,   0,   0,   0,   0}, // 2
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,  80,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 3
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 148,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 4
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0, 165,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 5
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 178,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 6
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0, 131,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 7
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,  84, 120,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 207,   0}, // 8
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,  86,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 130,   0,   0,   0}, // 9
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,  38,   0,   0,   0,   0,   0,   0,   0,   0,  50,   0,   0,   0,   0,   0,   0,   0,   0}, // 10
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0, 118,   0,   0,   0,   0,   0,   0,   0,   0,  37,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 11
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0, 131,   0,   0, 189,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 12
        //     { 113,    0,    0,    0,    0,    0,    0,    0,    0,     0,   118,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 13
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0, 161,   0, 146,   0,   0,   0,   0,   0,   0,   0,   0,  77,   0,   0,   0,   0,   0,   0,   0,  85,   0}, // 14
        //     {   0,    0,    0,    0,  165,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 167, 113,   0,   0,   0,   0,   0,   0,  79,   0,   0,   0,   0,   0,   0,   0}, // 15
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,  46,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 127}, // 16
        //     {   0,    0,   80,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0, 218,   0,   0,   0,   0,   0,   0,   0,   0,   0, 338,   0,   0,   0,   0, 111,   0,   0,   0, 143,   0, 184,   0,   0,   0,   0}, // 17
        //     {   0,    0,    0,    0,    0,    0,  131,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,  68,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 18
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,   131,   0, 161,   0,   0,   0,   0,   0, 135,   0,   0,   0,   0,   0,   0,   0,   0,   0, 260,   0,   0, 113,   0,   0,   0,   0,   0,   0}, // 19
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0, 135,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 20
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0, 146,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 176,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 21
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,  46,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 22
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 23
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 24
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 25
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 26
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 27
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 28
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 29
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 30
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 31
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 32
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 33
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 34
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 35
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 36
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 37
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // 38
        //     {   0,    0,    0,    0,    0,    0,    0,    0,    0,     0,     0,     0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}  // 39

        // };

        int[][] arr = new int[][]{
            {0, 10, 0, 5, 0},
            {0, 0, 1, 2, 0},
            {0, 0, 0, 0, 4},
            {0, 3, 9, 0, 2},
            {7, 0, 6, 0, 0}
        };

        Graph graph = new Graph();
        graph.Dijkstra(arr, 0);
    }

}