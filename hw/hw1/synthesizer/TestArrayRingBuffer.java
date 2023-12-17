package synthesizer;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void lastTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        assertEquals(3, arb.fillCount());
    }

    @Test
    public void firstTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        assertEquals(1, (int) arb.peek());
        assertEquals(1, (int) arb.dequeue());
    }

    @Test
    public void isTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertTrue(arb.isEmpty());
        try {
            arb.peek();
            arb.dequeue();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        for (int i = 0; i < 10; i += 1) {
            arb.enqueue(i);
        }
        assertTrue(arb.isFull());
        try {
            arb.enqueue(10);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    @Test
    public void iterableTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1);
        Iterator<Integer> seer = arb.iterator();
        assertTrue(seer.hasNext());
        assertEquals(1, (int) seer.next());
        assertFalse(seer.hasNext());
    }

    @Test
    public void forEachTest() {
        ArrayRingBuffer<String> arb = new ArrayRingBuffer<>(10);
        arb.enqueue("Hello");
        arb.enqueue(", ");
        arb.enqueue("Jason ");
        arb.enqueue("Wu!");

        String greeting = "";
        for(String w : arb) {
            greeting += w;
        }
        assertEquals("Hello, Jason Wu!", greeting);
    }
}
