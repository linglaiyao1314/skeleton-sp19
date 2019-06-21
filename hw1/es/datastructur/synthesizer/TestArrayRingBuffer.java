package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1);
        System.out.println(arb.fillCount());
        arb.enqueue(2);
        System.out.println(arb.fillCount());
        arb.enqueue(3);
        System.out.println(arb.fillCount());
//        assertEquals(arb.fillCount(), 3);
        int[] someInts = new int[]{1, 2, 3};
        for (int x : someInts) {
            for (int y: someInts) {
                System.out.println("x: " + x +  ", y:" + y);
            }
        }
    }
}
