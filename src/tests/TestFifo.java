package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import main.FIFO.Fifo;
import main.LIFO.Lifo;


public class TestFifo {
    @Test
    public void testCreation(){
        Fifo<Integer> fifo = new Fifo<Integer>(0);
        assertEquals(fifo.getConfig(), 0);

        Fifo<Integer> fifo2 = new Fifo<Integer>(1);
        assertEquals(fifo2.getConfig(), 1);

        Fifo<Integer> fifo3 = new Fifo<Integer>(2);
        assertEquals(fifo3.getConfig(), 2);

        Fifo<Integer> fifo4 = new Fifo<Integer>(3);
        assertEquals(fifo4.getConfig(), 0);
    }

    @Test
    public void testPushLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(0);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.getSize(), 4);
    }

    @Test
    public void testPushDoublyLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(1);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.getSize(), 4);
    }

    @Test
    public void testPushCircularDoublyLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(2);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);

        assertEquals(lifo.getSize(), 4);
    }

    @Test
    public void testPopLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(0);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.pop(), new Integer(1));
        assertEquals(fifo.pop(), new Integer(2));
        assertEquals(fifo.getSize(), 2);
        assertEquals(fifo.pop(), new Integer(3));
        assertEquals(fifo.pop(), new Integer(4));
        assertEquals(fifo.getSize(), 0);
    }
    
    @Test
    public void testPopDoublyLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(1);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.pop(), new Integer(1));
        assertEquals(fifo.pop(), new Integer(2));
        assertEquals(fifo.getSize(), 2);
        assertEquals(fifo.pop(), new Integer(3));
        assertEquals(fifo.pop(), new Integer(4));
        assertEquals(fifo.getSize(), 0);
    }

    @Test
    public void testPopCircularDoublyLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(2);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.pop(), new Integer(1));
        assertEquals(fifo.pop(), new Integer(2));
        assertEquals(fifo.getSize(), 2);
        assertEquals(fifo.pop(), new Integer(3));
        assertEquals(fifo.pop(), new Integer(4));
        assertEquals(fifo.getSize(), 0);
    }

    @Test
    public void testGetHeadLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(0);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.getHead(), new Integer(4));
    }

    @Test
    public void testGetHeadDoublyLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(1);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.getHead(), new Integer(4));
    }

    @Test
    public void testGetHeadCircularDoublyLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(2);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.getHead(), new Integer(4));
    }

    @Test
    public void testGetTailLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(0);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.getTail(), new Integer(1));
    }

    @Test
    public void testGetTailDoublyLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(1);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.getTail(), new Integer(1));
    }

    @Test
    public void testGetTailCircularDoublyLinkedList(){
        Fifo<Integer> fifo = new Fifo<Integer>(2);
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        fifo.push(4);

        assertEquals(fifo.getTail(), new Integer(1));
    }
 
}
