import static org.junit.Assert.*;

import org.junit.Test;

public class UnionFindTest {

    /**
     * Example test that verifies correctness of the IntList.of static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testList() {
        UnionFind uf = new UnionFind(15);
        uf.union(1, 2);


    }
}
