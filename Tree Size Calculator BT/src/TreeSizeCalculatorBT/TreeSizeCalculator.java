package TreeSizeCalculatorBT;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    private Node root;
    private ExecutorService es;
    public TreeSizeCalculator(Node root, ExecutorService es) {
        this.root = root;
        this.es = es;
    }

    @Override
    public Integer call() throws ExecutionException, InterruptedException {
        // base case
        if(root == null) {
            return null;
        }

        // recursive case
        TreeSizeCalculator left = new TreeSizeCalculator(root.left, es);
        TreeSizeCalculator right = new TreeSizeCalculator(root.right, es);

        Future<Integer> leftSize = es.submit(left);
        Future<Integer> rightSize = es.submit(right);

        return 1 + leftSize.get() + rightSize.get();
    }
}
