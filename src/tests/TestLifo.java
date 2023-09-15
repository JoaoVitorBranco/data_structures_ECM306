package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.LIFO.Lifo;

public class TestLifo {
    @Test
    public void testCreation(){
        Lifo<Integer> lifo = new Lifo<Integer>(0);
        assertEquals(lifo.getConfig(), 0);

        Lifo<Integer> lifo2 = new Lifo<Integer>(1);
        assertEquals(lifo2.getConfig(), 1);

        Lifo<Integer> lifo3 = new Lifo<Integer>(2);
        assertEquals(lifo3.getConfig(), 2);

        Lifo<Integer> lifo4 = new Lifo<Integer>(3);
        assertEquals(lifo4.getConfig(), 0);
    }

    @Test
    public void testPushLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(0);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);

        assertEquals(lifo.getSize(), 4);
    }

    @Test
    public void testPushDoublyLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(1);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);

        assertEquals(lifo.getSize(), 4);
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
        Lifo<Integer> lifo = new Lifo<Integer>(0);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);

        assertEquals(lifo.pop(), new Integer(4));
        assertEquals(lifo.pop(), new Integer(3));
        assertEquals(lifo.getSize(), 2);
        assertEquals(lifo.pop(), new Integer(2));
        assertEquals(lifo.pop(), new Integer(1));
        assertEquals(lifo.getSize(), 0);
    }
    
    @Test
    public void testPopDoublyLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(1);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);
        
        assertEquals(lifo.pop(), new Integer(4));
        assertEquals(lifo.pop(), new Integer(3));
        assertEquals(lifo.getSize(), 2);
        assertEquals(lifo.pop(), new Integer(2));
        assertEquals(lifo.pop(), new Integer(1));
        assertEquals(lifo.getSize(), 0);
    }

    @Test
    public void testPopCircularDoublyLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(2);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);
        
        assertEquals(lifo.pop(), new Integer(4));
        assertEquals(lifo.pop(), new Integer(3));
        assertEquals(lifo.getSize(), 2);
        assertEquals(lifo.pop(), new Integer(2));
        assertEquals(lifo.pop(), new Integer(1));
        assertEquals(lifo.getSize(), 0);
    }

    @Test
    public void testGetHeadLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(0);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);

        assertEquals(lifo.getHead(), new Integer(4));
    }

    @Test
    public void testGetHeadDoublyLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(1);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);

        assertEquals(lifo.getHead(), new Integer(4));
    }

    @Test
    public void testGetHeadCircularDoublyLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(2);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);

        assertEquals(lifo.getHead(), new Integer(4));
    }

    @Test
    public void testGetTailLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(0);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);

        assertEquals(lifo.getTail(), new Integer(1));
    }

    @Test
    public void testGetTailDoublyLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(1);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);

        assertEquals(lifo.getTail(), new Integer(1));
    }

    @Test
    public void testGetTailCircularDoublyLinkedList(){
        Lifo<Integer> lifo = new Lifo<Integer>(2);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);

        assertEquals(lifo.getTail(), new Integer(1));
    }
 
    
    
}
