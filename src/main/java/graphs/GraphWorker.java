package graphs;

import java.util.Random;

/**
 * Un graphWorker poate sa:
 * -populeze matricea de adiacenta
 * -sa afiseze matricea de adiacenta
 */
public class GraphWorker {
    static int randFrom0To1() {
        Random rand = new Random();
        return rand.nextInt(2);
    }

    /**
     * Returneaza o matrice in care 1 reprezinta muchie de la i la j
     * matricea e conform matricei de adiacenta
     */
    public void fillMatrix(Matrix matrix) {
        Integer[][] myArray = new Integer[matrix.size][matrix.size];
        for (int i = 0; i < matrix.size; i++)
            for (int j = 0; j < matrix.size; j++) {
                matrix.values[i][j] = 0;
            }
        for (int i = 0; i < matrix.size - 1; i++)
            for (int j = i + 1; j < matrix.size; j++) {
                int random = randFrom0To1();

                matrix.values[i][j] = random;
                matrix.values[j][i] = random;
            }

    }

    /**
     * Afiseaza pe ecran matricea
     */
    public void showMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.size; i++) {
            for (int j = 0; j < matrix.size; j++) {
                System.out.print(matrix.values[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Afiseaza mai frumos o matrice
     */
    public void showANiceMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.size; i++) {
            for (int j = 0; j < matrix.size; j++) {
                if (matrix.values[i][j] == 1) {
                    char pic = '\u25A1';
                    System.out.print(pic + " ");
                } else {
                    System.out.print("\u25B3" + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Pargurge graful si returneaza daca graful este conex
     */
    public boolean isConnected(Matrix matrix) {
        for (int i = 0; i < matrix.size; i++) {
            matrix.nodes[i] = 0;
        }
        makeDFS(0, matrix);
        for (int i = 0; i < matrix.size; i++) {
            if (matrix.nodes[i] == 0)
                return false;
        }
        return true;
    }

    /**
     * Parcurge graful DFS
     */
    private void makeDFS(int node, Matrix matrix) {
        matrix.nodes[node] = 1;
        for (int i = 0; i < matrix.size; i++) {
            if (matrix.values[node][i] == 1 && matrix.nodes[i] == 0) {
                makeDFS(i, matrix);
            }
        }
    }

    /**
     * Calculeaza componentele conexe
     */
    public void calcConnectedComp(int node, Matrix matrix) {

        for (int i = 0; i < matrix.size; i++) {
            if (matrix.values[node][i] == 1 && matrix.nodes[i] == 1) {
                matrix.nodes[node] = 2;
                System.out.print(node + " ");
                calcConnectedComp(i, matrix);

            }



        }
        //System.out.println(matrix.nodes[matrix.size-1]);

    }

}
