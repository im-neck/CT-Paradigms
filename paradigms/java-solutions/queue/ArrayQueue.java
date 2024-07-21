package queue;


import java.util.Objects;
import java.util.function.Predicate;

// Model: a[1]..a[n]
// Inv: n >= 0 && forall i=1..n: a[i] != null
// Let: immutable(k): forall i=1..k: a'[i] = a[i]

public class ArrayQueue extends AbstractQueue {
    private int head;
    private Object[] elements = new Object[20];

    //Pre: pred!=null && queue!=null
    //Post: 1)if pred(a[ans]) == false : res=-1
    //      2)else: res=ans && pred(a[ans]) == true && ans -> min;

    public int indexIf(Predicate<Object> pred) {
        int i = 0;
        while (i < size) {
            if (pred.test(elements[(i + head) % elements.length])) {
                return i;
            }
            i++;
        }
        return -1;
    }


    //Pre: pred!=null  && queue!=null
    //Post: 1)if pred(elements[ans]) == false : res=-1
    //      2)else: res=ans && pred(a[ans]) == true && ans -> max;
    public int lastIndexIf(Predicate<Object> pred) {
        int ans = -1;
        int i = 0;
        while (i < size) {
            if (pred.test(elements[(i + head) % elements.length])) {
                ans = i;
            }
            i++;
        }
        return ans;
    }


    //Pre: x!=null  && queue!=null
    //Post:  n'=n+1 && a[n']=x
    public void enqueueImpl(Object x) {
        ensureCapacity(size);
        Objects.requireNonNull(x);
        elements[(size + head) % elements.length] = x;
        //size++;
    }

    //Pre: true  && queue!=null
    //Post: a[1]
    public Object element() {
        return elements[head];
    }


    //Pre:size>0  && queue!=null
    //Post: res=a[1] && n'= head-1 && immutable(n)
    public Object dequeueImpl() {
        //assert size > 0;
        Object value = element();
        size--;
        elements[head] = null;
        head = (head + 1) % elements.length;
        return value;

    }


    private void ensureCapacity(int capacity) {
        if (capacity == elements.length) {

            Object[] sup = new Object[capacity * 2];
            System.arraycopy(elements, head, sup, 0, capacity - head);
            System.arraycopy(elements, 0, sup, capacity - head, head);
            elements = sup;
            head = 0;

        }
    }

    public void clearImpl() {
        // :NOTE: Пересоздание массива
        Object[] elements = new Object[2];
    }
}
