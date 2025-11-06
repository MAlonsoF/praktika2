package Testak;

import labo2.DoubleLinkedList;
import labo2.UnorderedDoubleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnorderedDoubleLinkedListTest {

    private UnorderedDoubleLinkedList<String> lista;
    private UnorderedDoubleLinkedList<String> lista2;
    private UnorderedDoubleLinkedList<String> lista3;

    @BeforeEach
    public void setUp() {
        lista = new UnorderedDoubleLinkedList<>();
        UnorderedDoubleLinkedList<String> lista2 = new UnorderedDoubleLinkedList<>();// lista2 prellenada con "A", "B"
        lista2.addToRear("A");
        lista2.addToRear("B");
        UnorderedDoubleLinkedList<String> lista3 = new UnorderedDoubleLinkedList<>();// lista3 prellenada con "A"
        lista3.addToRear("A");
    }

    @Test
    public void testAddToFront() {
        lista.addToFront("A");
        assertEquals(1, lista.size());
        assertEquals("A", lista.first());
        lista3.addToFront("B");
        assertEquals(2, lista3.size());
        assertEquals("B", lista.first());
    }

    @Test
    public void testAddToRear() {
        lista.addToRear("A");
        assertEquals(1, lista.size());
        assertEquals("A", lista.first());
        lista3.addToRear("B");
        assertEquals(2, lista3.size());
        assertEquals("B", lista3.last());
    }

    @Test
    public void testAddAfter() {
        lista.addToRear("A");
        lista.addToRear("C");
        lista.addAfter("B", "A");
        assertEquals(3, lista.size());
        assertEquals("A", lista.first());
        assertTrue(lista.contains("B"));
        assertEquals("C", lista.last());
        lista2.addAfter("C", "B");
        assertEquals(3, lista2.size());
        assertEquals("C", lista2.last());
        assertTrue(lista2.contains("C"));
        lista3.addAfter("B", "A");
        assertEquals(2, lista3.size());
        assertEquals("B", lista3.last());
        assertTrue(lista3.contains("B"));
    }
}
