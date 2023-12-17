package synthesizer;

import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T> {

    Iterator<T> iterator();

    /** Return size of the buffer.
     *  Unlike our Deque, the BoundedDeque has a fixed capacity,
     *  and nothing is allowed to enqueue if the queue is full.
     */
    int capacity();

    /** Return number of items currently in the buffer. */
    int fillCount();

    /** Add item x to the end.
     *  Items can only be enqueued at the back of the queue.
     */
    void enqueue(T x);

    /** Delete and return item from the front.
     *  And can only be dequeued from the front of the queue.
     */
    T dequeue();

    /** Return (but do not delete) item from the front. */
    T peek();

    /** Is the buffer empty (fillCount equals zero)? */
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    /** Is the buffer full (fillCount is same as capacity)? */
    default boolean isFull() {
        return fillCount() == capacity();
    }
}
