package implementacaoTres;
import implementacaoTres.QuickSort;

public class ArvoreGeradoraMinima {
    private int numeroVertices;
    private int numeroArestas;

    public ArvoreGeradoraMinima() {
        this.numeroVertices = 0;
        this.numeroArestas = 0;
    }

    public int getNumeroVertices() {
        return numeroVertices;
    }

    public void setNumeroVertices(int numeroVertices) {
        this.numeroVertices = numeroVertices;
    }

    public int getNumeroArestas() {
        return numeroArestas;
    }

    public void setNumeroArestas(int numeroArestas) {
        this.numeroVertices = numeroVertices;
    }

    public void preencher() {
        int arestas = 17;
                int[][] matriz = new int[][]{  {6,14,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {6,0,0,10,0,6,8,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,10,7,0,0,0,7,0,0,0,0,0,0,0,0},
                {0,14,0,0,7,0,0,0,0,6,0,6,0,0,0,0,0},
                {0,0,0,0,0,6,0,4,0,0,0,0,3,0,0,0,0},
                {0,0,0,0,0,0,8,4,7,6,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,6,0,0,5,0,5},
                {0,0,0,0,0,0,0,0,0,0,0,0,3,6,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,5}};

        int[] ordem = new int[arestas]; //ordenar as arestas

        int[][] arestasEq = new int[matriz.length][arestas];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < arestas; j++) {

                arestasEq[i][j] = 0;
            }
        }

        for (int i = 0; i < arestas; i++) {
            ordem[i] = 0;
        }


        int [] verticesEscolhidos = new int [9];

        for (int i = 0; i < 9; i++){
            verticesEscolhidos[i] = 0;
        }

        int [] verticePartida = new int[matriz.length];
        int [] verticeChegada = new int [matriz.length];

        for (int i = 0; i < matriz.length; i++){
            verticePartida[i] = 0;
        }

        for (int i = 0; i < matriz.length; i++){
            verticeChegada[i] = 0;
        }

        listaArestas(matriz, ordem, arestas);

        ordenaAresta(ordem);
        verticeEquivalente(matriz, ordem, arestasEq, arestas);
        imprimeAGM(matriz, arestasEq, arestas);


        System.out.println();

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < arestas; j++){
                System.out.print(matriz[i][j] + " " + "\t");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();




        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < arestas; j++) {
                System.out.print(arestasEq[i][j] + " " + "\t");
            }
            System.out.println();
        }
        System.out.println("Ordem de peso das  arestas ");
        for (int i = 0; i < arestas; i++) {
            System.out.print(ordem[i] + " ->");
        }

        System.out.println();
        associaVertAresta(arestasEq, 17, matriz, verticePartida, verticeChegada);

        }




    public void listaArestas(int[][] matriz, int[] ordem, int arestas) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < arestas; j++) {
                if (matriz[i][j] > ordem[j]) {
                    ordem[j] = matriz[i][j];
                    if (matriz[i][j] < ordem[j]) {
                        ordem[j] = matriz[i][j];
                    }
                }

            }
        }
    }

    public void verticeEquivalente(int[][] matriz, int[] ordem, int[][] verticeEquivalenteAresta, int arestas) {
        int somai = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < arestas; j++) {
                if (matriz[i][j] != 0) {
                    somai = i + 1;
                    verticeEquivalenteAresta[i][j] = somai;
                }
            }
        }
    }

    public void ordenaAresta(int[] ordem) {
        QuickSort q = new QuickSort();
        q.ordenarVetorDeInteiros(ordem);
    }

    public void imprimeAGM(int[][] matrizValores, int[][] matrizVertices, int arestas) {
        System.out.println("Arvore geradora minima do grafo informado:");
        System.out.println("Vertices: " + "    " + "   Arestas");
        for (int i = 0; i < matrizValores.length-1; i++) {
            for (int j = 0; j < arestas; j++) {
                if ((matrizVertices[i][j] != 0)) {
                        System.out.print(matrizVertices[i][j] + "   ");

                }
                if (matrizValores[i][j] != 0) {
                    System.out.print(matrizValores[i][j] + "   ");
                }

                if ((matrizVertices[i][j] != 0)) {
                    int imprimeImais1 = matrizVertices[i][j]+1; //só pra imprimir mais bonito
                    System.out.print(imprimeImais1 + "   ");
                }

                System.out.println();
            }
        }


    }

    public void associaVertAresta(int [][] matriz, int arestas, int [][] matrizValores, int []vetorSaida, int []vetorChegada){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < arestas; j++){
                int somai = i + 1;
                int somaj = j + 1;
            if (matriz[i][j] != 0){
                if (matriz[i][j] == somai){
                    vetorSaida[i] = i;
                    System.out.println("Saida " + vetorSaida[i]);
                    break;
                }
                if (matriz[i][j] == somai){
                    vetorChegada[i] = i;
                    System.out.println("Chegada " + vetorChegada[i]);

                }
            }

            }
        }

    }


}
