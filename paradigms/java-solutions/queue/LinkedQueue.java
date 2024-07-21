package queue;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class LinkedQueue extends AbstractQueue {

    private Node tail;
    private Node head;

    public Object element() {
        return head.value;
    }

    // :NOTE: ?
    public void print() {
    }

    public void enqueueImpl(Object x) {
        Node n = new Node(x, tail);
        if (size == 0) {
            head = n;
            tail = n;
        }
        tail.next = n;
        tail = n;
    }


    public Object dequeueImpl() {
        Object var = head.value;
        head = head.next;
        size--;
        return var;
    }

    public void clearImpl() {

    }

    private static class Node {

        private final Object value;
        private Node next;

        public Node(Object value, Node next) {
            assert value != null;
            this.value = value;
            this.next = next;
        }
    }
}
