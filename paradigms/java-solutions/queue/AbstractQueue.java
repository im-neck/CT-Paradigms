package queue;

import java.util.*;

public abstract class AbstractQueue implements Queue {
    protected int size;

    public void distinct() {
        final int tempSize = size;
        Set<Object> nn = new HashSet<>();
        for (int i =0; i<tempSize; i++){
            Object x = dequeue();
            if (!nn.contains(x)){
                nn.add(x);
                enqueue(x);
            }
        }
    }

    public void enqueue(Object x) {
        Objects.requireNonNull(x);
        enqueueImpl(x);
        size++;
    }

    protected abstract void enqueueImpl(Object x);

    protected abstract Object dequeueImpl();

    public Object dequeue() {
        assert size > 0;
        return dequeueImpl();
    }

    public int size() {
        return size;
    }

    public void clear() {
        // :NOTE: Не освобождаете объекты в ArrayQueue
        size = 0;
        clearImpl();
    }

    protected abstract void clearImpl();
    public boolean isEmpty() {
        return size == 0;
    }
}
