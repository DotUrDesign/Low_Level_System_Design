package AdderSubtractorWrong;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value v = new Value();
        Adder obj1 = new Adder(v);
        Subtractor obj2 = new Subtractor(v);

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Void> adderFutures = es.submit(obj1);
        Future<Void> subtractorFutures = es.submit(obj2);

        adderFutures.get();
        subtractorFutures.get();

        System.out.println(v.value);
    }
}
