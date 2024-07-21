package queue;

public class MyArrayQueueTest {
    public static void fill(ArrayQueue queue, String pref) {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(  i);
        }
    }

    public static void dump(ArrayQueue queue) {
        int i=10;
        while (!queue.isEmpty()) {
            assert queue.size()==i;
           // assert i == queue.element();
            System.out.println(
                    queue.size() + " " +
                            queue.element() + " " +
                            queue.dequeue()
            );

        }
    }

    public static void blank(ArrayQueue queue) {
        fill(queue,"");
        queue.clear();
        System.out.println(queue.isEmpty());
    }

    public static void notblank(ArrayQueue queue) {
        fill(queue,"");
        System.out.println(queue.isEmpty());
    }


    public static void main(String[] args) {
        ArrayQueue queue1 = new ArrayQueue();
        ArrayQueue queue2 = new ArrayQueue();
        System.out.println("Checking first queue: ");
        fill(queue1,"str1_");
        dump(queue1);
        blank(queue1);
        notblank(queue1);
        System.out.println("Checking second queue:");
        fill(queue2,"str2_");
        dump(queue2);
        blank(queue2);
        notblank(queue2);

    }
}

