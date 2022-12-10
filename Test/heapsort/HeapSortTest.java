package heapsort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapSortTest {
    HeapSortTest() {
    }

    @Test
    void samplePdfSort() {
        Integer[] array = new Integer[]{8, 9, 12, 3, 7};
        HeapSort.sort(array);
        Assertions.assertArrayEquals(new Integer[]{3, 7, 8, 9, 12}, array);
    }

    @Test
    void sort1() {
        Integer[] array = new Integer[]{1, 3, 5, 7, 7, 7, 5, 3, 1, 9};
        HeapSort.sort(array);
        Assertions.assertArrayEquals(new Integer[]{1, 1, 3, 3, 5, 5, 7, 7, 7, 9}, array);
    }

    @Test
    void sort11() {
        Integer[] array = new Integer[]{8, 5, 3, 1, 9};
        HeapSort.sort(array);
        Assertions.assertArrayEquals(new Integer[]{1, 3, 5, 8, 9}, array);
    }

    @Test
    void sort2() {
        Integer[] array = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        HeapSort.sort(array);
        Assertions.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    void delete() {
        Integer[] array = new Integer[]{10, 8, 7, 6, 6, 4, 2};
        HeapSort.deleteRoot(array);
        Assertions.assertArrayEquals(new Integer[]{8, 6, 7, 2, 6, 4, 10}, array);
    }

    @Test
    void add() {
        Integer[] array = new Integer[]{1, 1, 1, 1, null};
        Integer num = 99;
        HeapSort.addElement(array, num);
        Assertions.assertArrayEquals(new Integer[]{99, 1, 1, 1, 1}, array);
    }

    @Test
    void emptySort() {
        Integer[] array = new Integer[]{};
        HeapSort.sort(array);
        Assertions.assertArrayEquals(new Integer[]{}, array);
    }

    @Test
    void oneElementSort() {
        Integer[] array = new Integer[]{0};
        HeapSort.sort(array);
        Assertions.assertArrayEquals(new Integer[]{0}, array);
    }

    @Test
    void twoElementSort() {
        Integer[] array = new Integer[]{9, 8};
        HeapSort.sort(array);
        Assertions.assertArrayEquals(new Integer[]{8, 9}, array);
    }
}