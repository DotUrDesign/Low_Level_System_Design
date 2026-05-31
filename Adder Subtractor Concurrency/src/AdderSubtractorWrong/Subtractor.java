package AdderSubtractorWrong;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private Value v;
    public Subtractor(Value value) {
        this.v = value;
    }

    @Override
    public Void call() {
        for (int i = 1; i <= 10000000; i++) {
            this.v.value -= i;
        }
        return null;
    }
}
