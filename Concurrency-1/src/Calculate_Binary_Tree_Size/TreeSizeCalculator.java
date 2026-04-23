package Calculate_Binary_Tree_Size;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    private Node root;
    private ExecutorService executor;
    public TreeSizeCalculator(Node root, ExecutorService executor) {
        this.root = root;
        this.executor = executor;
    }

    @Override
    public Integer call() throws ExecutionException, InterruptedException {
        // base case
        if(root == null)
            return 0;

        // recursive case
        TreeSizeCalculator left = new TreeSizeCalculator(root.left, executor);
        TreeSizeCalculator right = new TreeSizeCalculator(root.right, executor);

        Future<Integer> leftFuture = executor.submit(left);
        Future<Integer> rightFuture = executor.submit(right);

        return 1 + leftFuture.get() + rightFuture.get();
    }
}
