package tests.TestHeap;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.Heap.MinHeap;

public class TestMinHeap {
    @Test
    @DisplayName("Test IsHeap for external arrays")
    public void testIsHeapStatic() {
        int[] arr1 = {12, 24, 25, 40, 50, 43, 42, 71, 77};
        int[] arr2 = {12, 24, 25, 40, 41, 43, 24, 71, 77};
        int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        
        assertTrue(MinHeap.isHeap(arr1));
        assertTrue(!MinHeap.isHeap(arr2));
        assertTrue(!MinHeap.isHeap(arr3));
    }
    
    @Test
    @DisplayName("Test IsHeap for implemented array as Heap")
    public void testIsHeap(){
        int[] arr1 = {80, 70, 71, 40, 20, 15, 16, 21, 35};
        MinHeap h = new MinHeap(arr1);
        assertTrue(h.isHeap());
    }

    @Test
    @DisplayName("Test HeapSort for implemented array as Heap 1")
    public void testHeapSort1(){
        int[] arr2 = {40, 20, 15, 70, 80, 71, 16, 21, 35}; // not a heap, but will be in constructor
        MinHeap h = new MinHeap(arr2);
        h.print();
        assertTrue(h.isHeap());
    }

    @Test
    @DisplayName("Test HeapSort for implemented array as Heap 2")
    public void testHeapSort2(){
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; // not a heap, but will be in constructor
        MinHeap h = new MinHeap(arr);
        h.print();
        assertTrue(h.isHeap());
    }
}
