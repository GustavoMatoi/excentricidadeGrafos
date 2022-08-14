package implementacaoTres;

import java.lang.*;

public class Prim {


    private int size = 0;
    //esse v aq é o tamanho da matriz
    //ele usa la limitado a 5, a sua é maior então tem q por dinamico


    private int minKey(int[] key, Boolean[] mstSet) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < this.size; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }

        return min_index;
    }

    private void printMST(int[] parent, int[][] graph) {
        System.out.println("ARESTA \tPESO");
        for (int i = 1; i < this.size; i++){
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);

        }

    }

    public void primMST(int[][] graph) {
        this.size = graph.length;
        int[] parent = new int[this.size];

        int[] key = new int[this.size];

        Boolean[] mstSet = new Boolean[this.size];

        for (int i = 0; i < this.size; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }


        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < this.size - 1; count++) {
            int u = minKey(key, mstSet);

            try {
                mstSet[u] = true;
            }catch (Exception e) {
                System.out.print(count);
                return;
            }


            for (int v = 0; v < this.size; v++)

                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent, graph);
    }

    public int verificaGrau(int[] parent, int u) {
        int grau = 0;
        for (int i = 0; i < this.size; i++) {
            if (parent[i] == u) {
                grau++;
            }
        }
        return grau;
    }

}
