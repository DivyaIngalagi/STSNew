import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SortIntegerTest {

    @Test
    void testSortInt() {
        int[] a = { -100, 1, 2, 3, 5, 6, 100 };
        SortInteger si = new SortInteger();
        int a1[] = si.sortInt();
        assertArrayEquals(a, a1);
    }

}
