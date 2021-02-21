package main;

import graphs.GraphWorker;
import graphs.Matrix;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        int n = 0;

        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println(e);
        }
        Matrix matrix = new Matrix();
        matrix.size = n;
        GraphWorker graphWorker = new GraphWorker();
        graphWorker.fillMatrix(matrix);
        graphWorker.showMatrix(matrix);
        //graphWorker.showANiceMatrix(matrix);
        boolean connected = graphWorker.isConnected(matrix);
        if(connected){
            System.out.println("Graful este conex!");
        }else{
            System.out.println("Gradul este neconex!");
        }
        graphWorker.calcConnectedComp(0, matrix);
    }
}
