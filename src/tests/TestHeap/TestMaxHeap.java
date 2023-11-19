package tests.TestHeap;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.Heap.MaxHeap;

public class TestMaxHeap {
    @Test
    @DisplayName("Test IsHeap for external arrays")
    public void testIsHeapStatic() {
        int[] arr1 = {80, 70, 71, 40, 20, 15, 16, 21, 35};
        int[] arr2 = {40, 20, 15, 70, 80, 71, 16, 21, 35};
        
        assertTrue(MaxHeap.isHeap(arr1));
        assertTrue(!MaxHeap.isHeap(arr2));
    }
    
    @Test
    @DisplayName("Test IsHeap for implemented array as Heap")
    public void testIsHeap(){
        int[] arr1 = {80, 70, 71, 40, 20, 15, 16, 21, 35};
        MaxHeap h = new MaxHeap(arr1);
        assertTrue(h.isHeap());
    }

    @Test
    @DisplayName("Test HeapSort for implemented array as Heap 1")
    public void testHeapSort1(){
        int[] arr2 = {40, 20, 15, 70, 80, 71, 16, 21, 35}; // not a heap, but will be in constructor
        MaxHeap h = new MaxHeap(arr2);
        h.print();
        assertTrue(h.isHeap());
    }

    @Test
    @DisplayName("Test HeapSort for implemented array as Heap 2")
    public void testHeapSort2(){
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // not a heap, but will be in constructor
        MaxHeap h = new MaxHeap(arr);
        h.print();
        assertTrue(h.isHeap());
    }
}
