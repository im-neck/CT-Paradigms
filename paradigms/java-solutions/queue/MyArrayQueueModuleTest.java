package queue;

public class MyArrayQueueModuleTest {
    public static void fill() {
        for (int i = 0; i < 10; i++) {
            ArrayQueueModule.enqueue(i);
        }
    }

    public static void dump() {
        while (!ArrayQueueModule.isEmpty()) {
            System.out.println(
                    ArrayQueueModule.size() + " " +
                            ArrayQueueModule.element() + " " +
                            ArrayQueueModule.dequeue()
            );
        }
    }
    public static void blank() {
        fill();
        ArrayQueueModule.clear();
        System.out.println(ArrayQueueModule.isEmpty());
    }
    public static void notblank() {
        fill();
        System.out.println(ArrayQueueModule.isEmpty());
    }



    public static void main(String[] args) {
        fill();
        dump();
        blank();
        notblank();
    }
}
