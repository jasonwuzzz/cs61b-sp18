package synthesizer;

/**
 * Provide a protected FILLCOUNT and CAPACITY variable that all subclasses will inherit,
 * as well as called “getter” methods capacity() and fillCount() that return capacity
 * and fillCount, respectively.
 * This saves a tiny amount of work for future implementations.
 *
 *  In practice, large Java libraries often have a hierarchy of interfaces,
 *  which are extended by abstract classes that provided default implementations for some methods,
 *  and which are in turn ultimately implemented by concrete classes.
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }
}
