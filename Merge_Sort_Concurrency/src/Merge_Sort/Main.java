package Merge_Sort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arr = List.of(1,4,2,1,3,4,5,5,5);
        ExecutorService es = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(arr, es);
        Future<List<Integer>> futures = es.submit(sorter);
        List<Integer> output = futures.get();
        System.out.println(output);
        es.shutdown();
    }
}
