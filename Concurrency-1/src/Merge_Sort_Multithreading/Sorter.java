package Merge_Sort_Multithreading;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/*
    Runnable -> when the function does not have to return any value.
             -> Just we are saying a thread to execute the function and come.

    Callable<Integer>

    Inside the callable<T> => The "T" should not be a primitive data type like int, double, List<int>.
    Rather we should be using wrapper classes like Integer, Double, List<Integer>

    ---------------------------------------------------

    Whats the difference between executor.submit and executor.execute ?
    executor.execute() => it takes Runnable as an argument.
    meaning => executor.execute(() -> {...})
    inside function is a runnable function
    And executor.execute() does not returns any value.

    executor.submit() => it takes Callable as an argument.
    And it returns some value.

 */
public class Sorter implements Callable<List<Integer>> {

    public List<Integer> arr = new ArrayList<>();
    public ExecutorService executor;

    public Sorter(List<Integer> arr, ExecutorService executor) {
        this.arr = arr;
        this.executor = executor;
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

        Sorter leftSorter = new Sorter(leftArr, executor);
        Sorter rightSorter = new Sorter(rightArr, executor);

        Future<List<Integer>> leftFuture = executor.submit(leftSorter);
        Future<List<Integer>> rightFuture = executor.submit(rightSorter);

        leftArr = leftFuture.get();
        rightArr = rightFuture.get();

        // merge
        List<Integer> output = new ArrayList<>();
        int i =0;
        int j = 0;
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
