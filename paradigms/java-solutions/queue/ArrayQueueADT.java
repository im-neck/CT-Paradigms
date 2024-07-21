package queue;

import java.util.Objects;
import java.util.function.Predicate;

// Model: a[1]..a[n]
// Inv: n >= 0 && forall i=1..n: a[i] != null
// Let: immutable(k): forall i=1..k: a'[i] = a[i]

public class ArrayQueueADT {
    private Object[] elements = new Object[20];
    private int head , size ;

    //Pre: pred!=null && queue!=null
    //Post: 1)if pred(a[ans]) == false : res=-1
    //      2)else: res=ans && pred(a[ans]) == true && ans -> min;
    public static int indexIf(ArrayQueueADT queue,Predicate<Object> pred) {
        int i = 0;
        while (i < queue.size) {
            if (pred.test(queue.elements[(i + queue.head) % queue.elements.length])) {
                return i;
            }
            i++;
        }
        return -1;
    }
    //Pre: pred!=null  && queue!=null
    //Post: 1)if pred(elements[ans]) == false : res=-1
    //      2)else: res=ans && pred(a[ans]) == true && ans -> max;
    public static int lastIndexIf(ArrayQueueADT queue,Predicate<Object> pred) {
        int ans = -1;
        int i = 0;
        while (i < queue.size) {
            if (pred.test(queue.elements[(i + queue.head) % queue.elements.length])) {
                ans = i;
            }
            i++;
        }
        return ans;
    }
    //Pre: x!=null  && queue!=null
    //Post:  n'=n+1 && a[n']=x
    public static void enqueue(ArrayQueueADT queue, Object x) {
        ensureCapacity(queue, queue.size);
        Objects.requireNonNull(x);
        queue.elements[(queue.size + queue.head) % queue.elements.length] = x;
        queue.size++;
    }
    //Pre: true  && queue!=null
    //Post: a[1]
    public static Object element(ArrayQueueADT queue) {
        return queue.elements[queue.head];
    }

    //Pre:size>0  && queue!=null
    //Post: res=a[1] && n'= head-1 && immutable(n)
    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.size > 0;

        Object value = element(queue);
        queue.size--;
        queue.elements[queue.head] = null;
        queue.head=(queue.head+1) % queue.elements.length;
        return value;

    }
    //Pre: queue!=null
    //Post: res = n && n'=n && immutable(n)
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    // Pre:  && queue!=null
    // Post: res = (n = 0) && n' = n && immutable(n)
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    //Pre:  queue!=null
    //Post: n=0
    public static void clear(ArrayQueueADT queue) {
        queue.head = 0;
        queue.size = 0;

    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity == queue.elements.length) {

            Object[] sup = new Object[capacity * 2];
            System.arraycopy(queue.elements, queue.head, sup, 0, capacity - queue.head);
            System.arraycopy(queue.elements, 0, sup, capacity - queue.head, queue.head);
            queue.elements = sup;
            queue.head = 0;

        }
    }

}

































