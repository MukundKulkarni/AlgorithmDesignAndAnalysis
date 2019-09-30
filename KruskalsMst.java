public class KruskalsMst{

    makeMst(int graph[][]){

    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 9 },
                                      { 0, 5, 7, 9, 0 } };

        KruskalsMst g = new KruskalsMst();

        g.makeMst(graph);

    }
}
