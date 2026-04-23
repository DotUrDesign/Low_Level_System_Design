package Merge_Sort_Multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> l = List.of(7,3,1,2,4,6,17,12);
        ExecutorService executor = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(l, executor);
        Future<List<Integer>> futures = executor.submit(sorter);
        List<Integer> ans = futures.get();
        System.out.println(ans);
        executor.shutdown();
    }
}
