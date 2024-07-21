package queue;

// Model: a[1]..a[n]
// Inv: n >= 0 && forall i=1..n: a[i] != null
// Let: immutable(k): forall i=1..k: a'[i] = a[i]

public interface Queue {

    //Pre: true
    // :NOTE: no order
    // forall i : !exist i' : a'[i]=a[i]
    //Post: forall a[i](i=1..n): exist unique j (1..a'.size)a'[j]=a[i]
    void distinct();


    //Pre:   x!=null  && queue!=null
    //Post:  n'=n+1 && a[n']=x
    void enqueue(Object x);


    //Pre: true
    //Post: a[1]
    Object element();


    //Pre:size>0
    //Post: res=a[1] && n'= head-1 && immutable(n)
    Object dequeue();

    //Pre: true
    //Post: res = n && n'=n && immutable(n)
    int size();

    // Pre:  true
    // Post: res = (n = 0) && n' = n && immutable(n)
    boolean isEmpty();

    //Pre:  true
    //Post: n=0

    void clear();
}
