package heapsort;

import java.util.Comparator;

public class HeapSort {
    public static <E> void sort(
            E[] elements, Comparator<? super E> cmp) {
        new BinaryHeap<>(elements, cmp).heapSort();
    }

    public static <E extends Comparable<? super E>> void sort(
            E[] elements) {
        sort(elements, Comparator.naturalOrder());
    }

    public static <E extends Comparable<? super E>> void deleteRoot(E[] elements) {
        BinaryHeap<Integer> bh = new BinaryHeap<>((Integer[]) elements, Comparator.naturalOrder());
        bh.heapSize = bh.elements.length;
        bh.deleteRoot();
    }

    public static <E extends Comparable<? super E>> void addElement(Integer[] elements, Integer num) {
        BinaryHeap<Integer> bh = new BinaryHeap<>(elements, Comparator.naturalOrder());
        bh.heapSize = bh.elements.length - 1;
        bh.addElement(num);
    }

    static class BinaryHeap<E> {
        final E[] elements;
        final Comparator<? super E> comparator;
        int heapSize;

        public BinaryHeap(E[] elements, Comparator<E> cmp) {
            this.elements = elements;
            this.comparator = cmp;
            this.heapSize = 0;
        }

        static int parent(int index) {
            int result = (index - 1) / 2;
            return (int) Math.floor(result);
        }

        static int left(int index) {
            return 2 * index + 1;
        }

        static int right(int index) {
            return 2 * index + 2;
        }

        boolean hasLeft(int index) {
            return left(index) < heapSize && index >= 0;
        }

        boolean hasRight(int index) {
            return right(index) < heapSize && index >= 0;
        }

        boolean hasParent(int index) {
            return index > 0;
        }

        public boolean addElement(E element) {
            elements[heapSize] = element;
            if (hasParent(heapSize)) {
                int parent_idx = parent(heapSize);
                max_heapify(parent_idx);
            }
            heapSize++;
            return true;
        }

        public E deleteRoot() {
            if (elements.length == 0) {
                return null;
            }
            E element = elements[0];
            //swap(element, elements[heapSize - 1]);
            swapByIndex(0, heapSize - 1);
            heapSize--;
            max_heapify(0);
            return element;
        }

        private void build_max_heap() {

            for (int i = 0; i < elements.length; i++) {
                //checking if an element isn't a leaf
                if (!(i >= (heapSize / 2) && i <= heapSize))
                    max_heapify(i);
            }
        }

        private void max_heapify(int index) {
            int left = left(index);
            int right = right(index);

            int largest = index;

            if (left < heapSize && (comparator.compare(elements[index], elements[left]) < 0)) {
                largest = left;
            }

            if (right < heapSize && (comparator.compare(elements[largest], elements[right]) < 0)) {
                largest = right;
            }

            if (largest != index) {
                swapByIndex(largest, index);
                max_heapify(largest);
            }
            //Quan ni l'esquerra ni el dret siguin majors al index la funció acabara
        }

        void swapByIndex(int idx1, int idx2) {
            E swap = elements[idx1];
            elements[idx1] = elements[idx2];
            elements[idx2] = swap;
        }

        public void heapSort() {
            heapSize = 0;
            for (E element : elements) {
                addElement(element);
            }
            //heapSize = elements.length;
            build_max_heap();
            for (int i = 0; heapSize > 0 && i < elements.length; i++) {
                deleteRoot();
            }
        }
    }
}