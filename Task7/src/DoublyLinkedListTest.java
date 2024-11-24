import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;

public class DoublyLinkedListTest {

    @Test
    public void testAddInteger() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Assert.assertEquals(0, list.size());
        list.add(10);
        list.add(20);
        list.add(30);
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testAddString() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        Assert.assertEquals(0, list.size());
        list.add("a");
        list.add("b");
        list.add("c");
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testRemoveInteger() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        Integer removed = list.remove();
        Assert.assertEquals(Integer.valueOf(30), removed);
        Assert.assertEquals(2, list.size());

        removed = list.remove();
        Assert.assertEquals(Integer.valueOf(20), removed);
        Assert.assertEquals(1, list.size());

        removed = list.remove();
        Assert.assertEquals(Integer.valueOf(10), removed);
        Assert.assertEquals(0, list.size());

        removed = list.remove();
        Assert.assertNull(removed);
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testRemoveString() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("a");
        list.add("b");

        String removed = list.remove();
        Assert.assertEquals("b", removed);
        Assert.assertEquals(1, list.size());

        removed = list.remove();
        Assert.assertEquals("a", removed);
        Assert.assertEquals(0, list.size());

        removed = list.remove();
        Assert.assertNull(removed);
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testRemoveByValueInteger() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);

        // Удалить первое вхождение 20
        boolean removed = list.remove(20);
        Assert.assertTrue(removed);
        Assert.assertEquals(3, list.size());


        Assert.assertEquals(Integer.valueOf(20), list.remove());
        Assert.assertEquals(Integer.valueOf(30), list.remove());
        Assert.assertEquals(Integer.valueOf(10), list.remove());
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testRemoveByValueString() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");

        // Удалить первое вхождение "b"
        boolean removed = list.remove("b");
        Assert.assertTrue(removed);
        Assert.assertEquals(3, list.size());

        // Проверка, что осталась еще одна "b"
        Assert.assertEquals("b", list.remove());
        Assert.assertEquals("c", list.remove());
        Assert.assertEquals("a", list.remove());
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testFindInteger() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        Integer found = list.find(20);
        Assert.assertEquals(Integer.valueOf(20), found);

        found = list.find(40);
        Assert.assertNull(found);
    }

    @Test
    public void testFindString() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        String found = list.find("banana");
        Assert.assertEquals("banana", found);

        found = list.find("date");
        Assert.assertNull(found);
    }

    @Test
    public void testIteratorInteger() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        Assert.assertEquals(6, sum);
    }

    @Test
    public void testIteratorString() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("x");
        list.add("y");
        list.add("z");

        Iterator<String> iterator = list.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        Assert.assertEquals("xyz", sb.toString());
    }

    @Test
    public void testNodeEquals() {
        Node<String> node1 = new Node<>("test");
        Node<String> node2 = new Node<>("test");
        Node<String> node3 = new Node<>(null);
        Node<String> node4 = new Node<>(null);

        Assert.assertTrue(node1.equals(node2));
        Assert.assertTrue(node3.equals(node4));

        Node<String> node5 = new Node<>("different");
        Assert.assertFalse(node1.equals(node5));
        Assert.assertFalse(node1.equals(node3));
        Assert.assertFalse(node3.equals(node5));
    }

    @Test
    public void testNodeHashCode() {
        Node<Integer> node1 = new Node<>(100);
        Node<Integer> node2 = new Node<>(100);
        Node<Integer> node3 = new Node<>(200);

        Assert.assertEquals(node1.hashCode(), node2.hashCode());
        Assert.assertNotEquals(node1.hashCode(), node3.hashCode());
    }
}
