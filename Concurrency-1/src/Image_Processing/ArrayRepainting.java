package Image_Processing;

import java.util.concurrent.*;

public class ArrayRepainting {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[][] originalArray = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int rows = originalArray.length;
        int cols = originalArray[0].length;
        int midRow = rows/2;
        int midCol = cols/2;

        ArrayRepainterTask arrayRepainterTask1 = new ArrayRepainterTask(originalArray,0,midRow,0,midCol);
        ArrayRepainterTask arrayRepainterTask2 = new ArrayRepainterTask(originalArray,midRow,rows,0,midCol);
        ArrayRepainterTask arrayRepainterTask3 = new ArrayRepainterTask(originalArray,0,midRow,midCol,cols);
        ArrayRepainterTask arrayRepainterTask4 = new ArrayRepainterTask(originalArray,midRow,rows,midCol,cols);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<Void> f1 = executor.submit(arrayRepainterTask1);
        Future<Void> f2 = executor.submit(arrayRepainterTask2);
        Future<Void> f3 = executor.submit(arrayRepainterTask3);
        Future<Void> f4 = executor.submit(arrayRepainterTask4);

        f1.get();
        f2.get();
        f3.get();
        f4.get();

        executor.shutdown();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                System.out.print(originalArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}
