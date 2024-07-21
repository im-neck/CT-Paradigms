package queue;

public class MyArrayQueueADTTest {
    public static void fill(ArrayQueueADT queue, String pref) {
        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.enqueue(queue, pref + i);
        }
    }

    public static void dump(ArrayQueueADT queue) {
        while (!ArrayQueueADT.isEmpty(queue)) {
            System.out.println(
                    ArrayQueueADT.size(queue) + " " +
                            ArrayQueueADT.element(queue) + " " +
                            ArrayQueueADT.dequeue(queue)
            );
        }
    }

    public static void blank(ArrayQueueADT queue) {
        fill(queue,"");
        ArrayQueueADT.clear(queue);
        System.out.println(ArrayQueueADT.isEmpty(queue));
    }

    public static void notblank(ArrayQueueADT queue) {
        fill(queue,"");
        System.out.println(ArrayQueueADT.isEmpty(queue));
    }


    public static void main(String[] args) {
        // :NOTE: assert
        ArrayQueueADT queue1 = new ArrayQueueADT();
        ArrayQueueADT queue2 = new ArrayQueueADT();
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
