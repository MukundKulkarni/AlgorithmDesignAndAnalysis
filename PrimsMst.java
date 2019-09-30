public class PrimsMst{

    static int number_of_vertices = 5;

    int findMinKey(int key[], boolean vertex_included[]){
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for(int v = 0; v < number_of_vertices; v++){
            if(vertex_included[v] == false && key[v] < min){
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void makeMst(int graph[][]){
        boolean[] vertex_included = new boolean[number_of_vertices];
        int[] created_mst = new int[number_of_vertices];
        int[] key = new int[number_of_vertices];

        for(int i = 0; i < number_of_vertices; i++){
            key[i] = Integer.MAX_VALUE;
            vertex_included[i] = false;
        }

        key[0] = 0;
        created_mst[0] = -1;

        for(int c = 0; c < number_of_vertices - 1; c++){
            int u = findMinKey(key, vertex_included);

            vertex_included[u] = true;

            for(int v = 0; v < number_of_vertices ; v++){
                if (graph[u][v] != 0 && vertex_included[v] == false && graph[u][v] < key[v]) {
                   created_mst[v] = u;
                   key[v] = graph[u][v];
               }
            }
        }
         printMST(created_mst, graph);
    }

    void printMST(int created_mst[], int graph[][]){
       System.out.println("Edge \tWeight");
       for (int i = 1; i < number_of_vertices; i++){
           System.out.println(created_mst[i] + " - " + i + "\t" + graph[i][created_mst[i]]);
       }
   }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 9 },
                                      { 0, 5, 7, 9, 0 } };

        PrimsMst g = new PrimsMst();

        g.makeMst(graph);



    }
}
