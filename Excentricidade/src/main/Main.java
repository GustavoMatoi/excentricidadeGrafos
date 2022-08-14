package main;

import implementacaoDois.Grafo;
import implementacaoTres.ArvoreGeradoraMinima;
import implementacaoTres.Prim;

public class Main {
    /*
    Autor : Gustavo Vaz Teixeira

     */
    public static void main(String[] args) {


       /* Prim t = new Prim();
        int[][] graph = new int[][]{
                {0,6,1,14,0,0,0,0,0,0},
                {6,0,10,0,6,8,0,0,0,0},
                {1,10,0,7,0,0,6,0,0,0},
                {14,0,7,0,0,6,6,0,0,0},
                {0,6,0,0,0,4,0,3,0,0},
                {0,8,7,0,4,0,1,0,5,0},
                {0,0,0,6,0,1,0,0,0,5},
                {0,0,0,0,3,0,0,0,6,0},
                {0,0,0,0,0,5,0,6,0,5},
                {0,0,0,0,0,0,5,0,5,0},

        };

        t.primMST(graph); */

    /*    ArvoreGeradoraMinima a = new ArvoreGeradoraMinima();
         a.preencher(); */

      Grafo g = new Grafo();
      g.preencher();
    }
}
