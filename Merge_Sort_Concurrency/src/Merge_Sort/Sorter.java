package Merge_Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable {
    private List<Integer> arr;
    private ExecutorService es;

    public Sorter(List<Integer> arr, ExecutorService es) {
        this.arr = arr;
        this.es = es;
    }

    @Override
    public List<Integer> call() throws ExecutionException, InterruptedException {
        // base case
        if(arr.size() <= 1)
            return arr;

        // recursive case
        int n = arr.size();
        int mid = n/2;
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();
        for(int i=0;i<mid;i++) {
            leftArr.add(arr.get(i));
        }
        for(int i=mid;i<n;i++) {
            rightArr.add(arr.get(i));
        }

        Sorter leftSorter = new Sorter(leftArr, es);
        Sorter rightSorter = new Sorter(rightArr, es);

        Future<List<Integer>> leftFuture = es.submit(leftSorter);
        Future<List<Integer>> rightFuture = es.submit(rightSorter);

        leftArr = leftFuture.get();
        rightArr = rightFuture.get();

        List<Integer> output = new ArrayList<>();
        int i =0;
        int j =0;
        while(i < leftArr.size() && j < rightArr.size()) {
            if(leftArr.get(i) < rightArr.get(j)) {
                output.add(leftArr.get(i));
                i++;
            } else {
                output.add(rightArr.get(j));
                j++;
            }
        }

        while(i < leftArr.size()) {
            output.add(leftArr.get(i));
            i++;
        }

        while(j < rightArr.size()) {
            output.add(rightArr.get(j));
            j++;
        }

        return output;
    }
}
