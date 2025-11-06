package Testak;

import static org.junit.jupiter.api.Assertions.*;

import labo2.Node;
import labo2.OrderedDoubleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderedDoubleLinkedListTest {

    private OrderedDoubleLinkedList<Integer> list1;
    private OrderedDoubleLinkedList<Integer> list2;

    @BeforeEach
    void setUp() {
        list1 = new OrderedDoubleLinkedList<>();
        list2 = new OrderedDoubleLinkedList<>();
    }

    @Test
    void testAdd_InsertInOrder() {
        list1.add(5);
        list1.add(2);
        list1.add(8);
        list1.add(1);
        list1.add(3);

        // Esperado: [1, 2, 3, 5, 8]
        Integer[] expected = {1, 2, 3, 5, 8};
        assertArrayEquals(expected, toArray(list1));
    }

    @Test
    void testAdd_InsertAtBeginning() {
        list1.add(10);
        list1.add(5);
        // Esperado: [5, 10]
        Integer[] expected = {5, 10};
        assertArrayEquals(expected, toArray(list1));
    }

    @Test
    void testAdd_InsertAtEnd() {
        list1.add(1);
        list1.add(5);
        list1.add(10);
        list1.add(15);
        // Esperado: [1, 5, 10, 15]
        Integer[] expected = {1, 5, 10, 15};
        assertArrayEquals(expected, toArray(list1));
    }

    @Test
    void testIntersection_CommonElements() {
        // list1: [1, 3, 5, 7, 9]
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);

        // list2: [3, 4, 5, 8, 9]
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(8);
        list2.add(9);

        OrderedDoubleLinkedList<Integer> result = list1.intersection(list2);

        // Esperado: [3, 5, 9]
        Integer[] expected = {3, 5, 9};
        assertArrayEquals(expected, toArray(result));
    }

    @Test
    void testIntersection_NoCommonElements() {
        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(4);
        list2.add(5);
        list2.add(6);

        OrderedDoubleLinkedList<Integer> result = list1.intersection(list2);

        assertTrue(result.isEmpty());
    }

    @Test
    void testIntersection_WithEmptyList() {
        list1.add(1);
        list1.add(2);
        list1.add(3);

        OrderedDoubleLinkedList<Integer> result = list1.intersection(list2); // list2 vacía

        assertTrue(result.isEmpty());
    }

    // --- Método auxiliar para comparar el contenido ---
    private Integer[] toArray(OrderedDoubleLinkedList<Integer> list) {
        Integer[] arr = new Integer[list.size()];
        Node<Integer> current = list.first;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }
}