package implementacaoDois;

        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.Scanner;

public class Grafo {
    private int numeroVertices;
    private int NumeroArestas;

    public Grafo() {
        this.numeroVertices = 0;
        this.NumeroArestas = 0;

    }

    public void setNumeroArestas(int numeroArestas) {
        NumeroArestas = numeroArestas;
    }

    public int getNumeroArestas() {
        return NumeroArestas;
    }

    public void setNumeroVertices(int numeroVertices) {
        this.numeroVertices = numeroVertices;
    }

    public int getNumeroVertices() {
        return numeroVertices;
    }


    public void preencher() {
        int[][] matriz = new int[][]{{0, 12, 20, 15, 28, 37, 25, 38, 46},
                                    {12, 0, 8, 27, 16, 25, 37, 32, 43},
                                    {20, 8, 0, 35, 24, 17, 45, 40, 35},
                                    {15, 27, 35, 0, 15, 25, 14, 27, 35},
                                    {28, 16, 24, 15, 0, 10, 29, 16, 27},
                                    {37, 25, 17, 25, 10, 0, 39, 26, 18},
                                    {25, 37, 45, 14, 29, 39, 0, 13, 21},
                                    {38, 32, 40, 27, 16, 26, 13, 0, 11},
                                    {46, 43, 35, 35, 27, 18, 21, 11, 0}};


        int[] total = new int[matriz.length]; //distancia total

        for (int i = 0; i < total.length; i++) {
            total[i] = 0;                   // inicializando as distancias com 0 para evitar erros
        }

        int []totalColunas = new int [matriz.length];



        for (int i = 0; i < matriz.length; i++){
            totalColunas[i] = 0;
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                totalColunas[j] = totalColunas[j] + matriz[i][j]; //somando as distancias de cada linha
            }

        }



        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                total[i] = total[i] + matriz[i][j]; //somando as distancias de cada linha
            }

        }
        int [] max = new int[matriz.length];
        int [] min = new int [matriz.length];

        for (int i = 0; i < matriz.length; i++){
            max[i] = 0;
            min[i] = 999;
        }

        for (int i =0; i < matriz.length; i++){ //comparações para gerar os valores de maximo e minimo das linhas
            for (int j = 0; j < matriz.length; j++){
                if (matriz[i][j] > max[i]){
                    max[i] = matriz[i][j];
                }
                if (matriz[i][j] < min[i] && matriz[i][j] != 0){
                    min[i] = matriz[i][j];
                }
            }
        }

        int [] maxColuna = new int[matriz.length];
        int [] minColuna = new int [matriz.length];

        for (int i = 0; i < matriz.length; i++){
            maxColuna[i] = 0;
            minColuna[i] = 999;
        }

        for (int i =0; i < matriz.length; i++){ //comparações para gerar os valores de maximo e minimo das colunas
            for (int j = 0; j < matriz.length; j++){
                if (matriz[i][j] > maxColuna[j]){
                    maxColuna[j] = matriz[i][j];
                }
                if (matriz[i][j] < minColuna[j] && matriz[i][j] != 0){
                    minColuna[j] = matriz[i][j];
                }
            }
        }


        for(int i = 0; i < matriz.length; i++){
                System.out.println("maximo: " + max[i]);
                System.out.println("minimo: " + min[i]);


        }


        //impressao
        System.out.println("Vértices" + "                                                 " + "Total" + " | " + "Max" + " | " + "Min");

        for (int i = 0; i < matriz.length;i++){
            int somai = i + 1;
            System.out.print( "  " +  somai  + "   " );
        }
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {
            int somai = i + 1;
            System.out.print(somai + "|");
            for (int j = 0; j < matriz.length; j++) {
                    System.out.print(matriz[i][j] + "    "  );
            }
            System.out.print(" | " + total[i]);
            System.out.print(" | " + max[i]);
            System.out.print(" | " + min[i]);

            System.out.println();

        }
        System.out.println("---------------------------------------------------------------");

        System.out.print("T|"); //imprime total coluna
        for (int i = 0; i < matriz.length; i++){
            System.out.print(totalColunas[i] +"   " );
        }
        System.out.println();

        System.out.print("Mi|"); //imprime minimo coluna
        for (int i = 0; i < matriz.length; i++){
            System.out.print(minColuna[i] +"    "  );
        }
        System.out.println();

        System.out.print("Ma|"); //imprime maximo coluna
        for (int i = 0; i < matriz.length; i++){
            System.out.print(maxColuna[i] +"    ");
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        int diametroGrafo = 0;

        for (int i = 0; i < matriz.length; i++){
            int diametror = diametroGrafo;
            if (total[i] > diametroGrafo){
                diametroGrafo = total[i];

            }
            if (total[i] > diametror){
                diametroGrafo = total[i];
            }
        }



        int raioGrafo = 999;

        for (int i = 0; i < matriz.length; i++){       //Achar o raio
            for (int j = 0; j < matriz.length; j++){
                if ((matriz[i][j] < raioGrafo) && (matriz[i][j] != 0)){
                    raioGrafo = matriz[i][j];
                }
            }
        }
        int [] vertices = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++){
            vertices[i] = i+1;
        }





        int medianaInterior = 999;              //achar a medianaInterior (minimo colunas)
        int posicaoMedianaInterior = 0;
        for (int i = 0; i < matriz.length; i++){
            if (minColuna[i] < medianaInterior && minColuna[i] != 0){
                medianaInterior = minColuna[i];
                posicaoMedianaInterior = i + 1;
            }
        }

        int medianaExterior = 999;          //achar a medianaExterior (minimo linhas)
        int posicaoMedianaExterior = 0;
        for (int i = 0; i < matriz.length; i++){
            if (min[i] < medianaExterior && min[i] != 0){
                medianaExterior = min[i];
                posicaoMedianaExterior = i + 1;
            }
        }

        int centroInterior = 999;
        int posicaoCentroInterior = 0;

        for (int i = 0; i < matriz.length; i++){  //achar o centro interior
            if(maxColuna[i] < centroInterior){
                centroInterior = maxColuna[i];
                posicaoCentroInterior = i + 1;
            }
        }

        int centroExterior = 999;
        int posicaoCentroExterior = 0;

        for (int i = 0; i < matriz.length; i++){        //achar o centro exterior
            if(max[i] < centroExterior){
                centroExterior = max[i];
                posicaoCentroExterior = i + 1;
            }
        }

        int antiCentroInterior = 0;
        int posicaoAntiCentroInterior = 0;

        for (int i = 0; i < matriz.length; i++){        //achar o anti centro interior
            if (minColuna[i] > antiCentroInterior){
                antiCentroInterior = minColuna[i];
                posicaoAntiCentroInterior = i + 1;
            }
        }

        int antiCentroExterior = 0;
        int posicaoAntiCentroExterior = 0;

        for (int i = 0; i < matriz.length; i++){            //achar o anti centro exterior
            if (min[i] > antiCentroExterior){
                antiCentroExterior = min[i];
                posicaoAntiCentroExterior = i + 1;
            }
        }



        System.out.println("Anti centro interior: " + antiCentroInterior );
        System.out.println("Posição anti centro interior:" + posicaoAntiCentroInterior);

        System.out.println("Anti centro exterior: " + antiCentroExterior );
        System.out.println("Posição anti centro exterior:" + posicaoAntiCentroExterior);

        System.out.println("Centro Interior:" + centroInterior);
        System.out.println("Posição centro interior:" + posicaoCentroInterior);


        System.out.println("Centro Interior:" + centroExterior);
        System.out.println("Posição centro interior:" + posicaoCentroExterior);

        System.out.println("Mediana Interior:" + medianaInterior);
        System.out.println("Posição mediana interior:" + posicaoMedianaInterior);

        System.out.println("Mediana exterior:" + medianaExterior);
        System.out.println("Posição mediana exterior:" + posicaoMedianaExterior);




        System.out.println("Raio do grafo:" + raioGrafo);


        System.out.println("Diametro do grafo:" + diametroGrafo);
    }



}
