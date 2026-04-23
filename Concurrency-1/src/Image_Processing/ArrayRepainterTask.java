package Image_Processing;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class ArrayRepainterTask implements Callable<Void> {
    int startRow;
    int endRow;
    int startCol;
    int endCol;
    int[][] originalArray;
    public ArrayRepainterTask(int[][] originalArray, int startRow,int endRow,int startCol,int endCol) {
        this.originalArray = originalArray;
        this.startRow = startRow;
        this.endRow = endRow;
        this.startCol = startCol;
        this.endCol = endCol;
    }

    @Override
    public Void call() {

        for(int i=startRow;i<endRow;i++) {
            for(int j=startCol;j<endCol;j++) {
                originalArray[i][j] = originalArray[i][j] * 2;
                System.out.println(originalArray[i][j] + " ::: " + Thread.currentThread().getName() + " ");
            }
        }

        return null;
    }
}
