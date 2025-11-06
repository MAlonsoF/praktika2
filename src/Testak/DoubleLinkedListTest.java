package Testak;
import labo2.DoubleLinkedList;
import labo2.UnorderedDoubleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {

    private DoubleLinkedList<String> lista;
    private DoubleLinkedList<String> lista2;
    private DoubleLinkedList<String> lista3;

    @BeforeEach
    public void setUp() {
        lista = new DoubleLinkedList<>();
        UnorderedDoubleLinkedList<String> aux = new UnorderedDoubleLinkedList<>();
        aux.addToRear("A");
        aux.addToRear("B");
        DoubleLinkedList<String> lista2 = aux.clone(); // lista2 prellenada con "A", "B"
        UnorderedDoubleLinkedList<String> aux2 = new UnorderedDoubleLinkedList<>();
        aux.addToRear("A");
        DoubleLinkedList<String> lista3 = aux2.clone(); // lista3 prellenada con "A"
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
    }

    @Test
    public void testSetDeskrAndGetDeskr() {
        lista.setDeskr("Proba deskribapena");
        assertEquals("Proba deskribapena", lista.getDeskr());
    }

    @Test
    public void testCloneZerrendaHutsan() {
        DoubleLinkedList<String> kopia = lista.clone();
        assertTrue(kopia.isEmpty());
        assertEquals(0, kopia.size());
    }

    @Test
    public void testRemoveAllZerrendaHutsan() {
        lista.removeAll("X");
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testFindZerrendaHutsan() {
        assertNull(lista.find("X"));
    }

    @Test
    public void testContainsZerrendaHutsan() {
        assertFalse(lista.contains("X"));
    }

    @Test
    public void testRemoveFirstZerrendaHutsan() {
        assertNull(lista.removeFirst());
    }

    @Test
    public void testRemoveLastZerrendaHutsan() {
        assertNull(lista.removeLast());
    }

    @Test
    public void testFirstAndLastZerrendaHutsan() {
        assertNull(lista.first());
        assertNull(lista.last());
    }

    // === Zerrenda ez hutsa ===

    @Test
    public void testCloneZerrendaEzHutsan() {
        DoubleLinkedList<String> kopia = lista2.clone();
        assertEquals(2, kopia.size());
        assertEquals("A", kopia.first());
        assertEquals("B", kopia.last());
        DoubleLinkedList<String> kopia2 = lista3.clone();
        assertEquals(1, kopia2.size());
        assertEquals("A", kopia2.first());
        assertEquals("A", kopia2.last());
    }

    @Test
    public void testFirstAndLastZerrendaEzHutsan() {
        assertEquals("A", lista2.first());
        assertEquals("B", lista2.last());
    }

    @Test
    public void testSizeZerrendaEzHutsan() {
        assertEquals(2, lista2.size());
        assertEquals(1, lista3.size());
        assertEquals(0, lista.size());
    }

    @Test
    public void testIsEmptyZerrendaEzHutsan() {
        assertFalse(lista2.isEmpty());
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testContainsZerrendaEzHutsan() {
        assertTrue(lista2.contains("A"));
        assertTrue(lista2.contains("B"));
        assertFalse(lista2.contains("C"));
    }

    @Test
    public void testFindZerrendaEzHutsan() {
        assertEquals("A", lista2.find("A"));
        assertNull(lista2.find("D"));
    }

    @Test
    public void testRemoveAllZerrendaEzHutsan() {
        lista2.removeAll("A");
        assertEquals(1, lista2.size());
        assertFalse(lista2.contains("A"));
        assertTrue(lista2.contains("B"));
        lista3.removeAll("A");
        assertEquals(0, lista3.size());

    }

    @Test
    public void testRemoveLastZerrendaEzHutsan() {
        String eliminado = lista2.removeLast();
        assertEquals("B", eliminado);
        assertEquals(1, lista2.size());
        assertEquals("A", lista2.last());
        String eliminado2 = lista3.removeLast();
        assertEquals("A", eliminado);
        assertEquals(1, lista3.size());
    }

    @Test
    public void testRemoveFirstZerrendaEzHutsan() {
        String eliminado = lista2.removeFirst();
        assertEquals("A", eliminado);
        assertEquals(1, lista2.size());
        assertEquals("B", lista2.first());
        String eliminado2 = lista3.removeFirst();
        assertEquals("A", eliminado);
        assertEquals(1, lista3.size());
    }
}
