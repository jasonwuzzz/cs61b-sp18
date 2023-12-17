// Make sure to make this class a part of the synthesizer package
 package synthesizer;
import java.util.Iterator;

//Make sure to make this class and all of its methods public
//Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T> {
    /* Index for the least recently inserted item. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // Enqueue the item. Don't forget to increase fillCount and update last.
        if (!isFull()) {
            rb[last] = x;
            last = (last + 1) % capacity;
            fillCount += 1;
        } else {
            throw new RuntimeException("Ring buffer overflow");
        }
    }

    /**
     * Dequeue the oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update first.
        if (!isEmpty()) {
            T result = rb[first];
            first = (first + 1) % capacity;
            fillCount -= 1;
            return result;
        } else {
            throw new RuntimeException("Ring buffer underflow");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // Return the first item. None of your instance variables should change.
        if (!isEmpty()) {
            return rb[first];
        } else {
            throw new RuntimeException("Ring buffer underflow");
        }
    }

    // When you get to part 5, implement the needed code to support iteration.
    public Iterator<T> iterator() {
        return new RbIterator();
    }

    private class RbIterator implements Iterator<T> {
        private int current;

        public RbIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current < last;
        }

        @Override
        public T next() {
            T result = rb[current];
            current += 1;
            return result;
        }
    }
}
