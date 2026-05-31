package AdderSubtractorLocks;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class Subtractor implements Callable<Void> {
    public Value v;
    public ReentrantLock lock;
    public Subtractor(Value value, ReentrantLock lock) {
        this.v = value;
        this.lock = lock;
    }
    @Override
    public Void call() {
        for(int i=1;i<=1000000;i++) {
            lock.lock();
            this.v.value -= i;
            lock.unlock();
        }
        return null;
    }
}
