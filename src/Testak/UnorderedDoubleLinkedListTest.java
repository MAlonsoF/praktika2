package Testak;

import labo2.UnorderedDoubleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnorderedDoubleLinkedListTest {

    private UnorderedDoubleLinkedList<String> lista3;

    @BeforeEach
    public void setUp() {
        lista3 = new UnorderedDoubleLinkedList<>();
    }

    @Test
    public void testAddToFront() {
        lista3.addToFront("A");
        lista3.addToFront("B");
        assertEquals(2, lista3.size());
        assertEquals("B", lista3.first());
        assertEquals("A", lista3.last());
    }

    @Test
    public void testAddToRear() {
        lista3.addToRear("A");
        lista3.addToRear("B");
        assertEquals(2, lista3.size());
        assertEquals("A", lista3.first());
        assertEquals("B", lista3.last());
    }

    @Test
    public void testAddAfter() {
        lista3.addToRear("A");
        lista3.addToRear("C");
        lista3.addAfter("B", "A");
        assertEquals(3, lista3.size());
        assertEquals("A", lista3.first());
        assertTrue(lista3.contains("B"));
        assertEquals("C", lista3.last());
    }
}
