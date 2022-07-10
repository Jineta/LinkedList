import java.util.Arrays;
import java.lang.Exception;

public class MyLinkedListImplementation<T> implements MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T element;

        public Node(Node<T> next, Node<T> prev, T element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }
    }

    @Override
    public void add(T value) throws Exception {
        add(size, value);
    }

    @Override
    public void add(int index, T value) throws Exception {
        if (isIndexValid(index, false)) {
            if (size == 0) {
                head = new Node<>(null, null, value);
                tail = head;
            } else if ((size == 1) && (index == 0)) {
                head = new Node<>(head, null, value);
                tail.prev = head;
            } else if ((size == 1) && (index == size)) {
                tail = new Node<>(null, head, value);
                head.next = tail;
            } else if ((size > 1) && (index == size)) {
                tail.next = new Node<>(null, tail, value);
                tail = tail.next;
            } else if ((size > 1) && (index == 0)) {
                head.prev = new Node<>(head, null, value);
                head = head.prev;
            } else {
                Node<T> currentNode = findNode(index);
                Node<T> newNode = new Node<>(currentNode, currentNode.prev, value);
                currentNode.prev.next = newNode;
                currentNode.prev = newNode;
            }
            size++;
        }
    }

    private Node<T> findNode(int index) {
        Node<T> currentNode = head;
        for (int i = 1; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private Node<T> findNode(T value) {
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.element.equals(value)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    @Override
    public T get(int index) throws Exception {
        if (!isListEmpty() && isIndexValid(index, true)) {
            if (index == 0) {
                return head.element;
            } else {
                Node<T> currentNode = head;
                for (int i = 1; i <= index; i++) {
                    currentNode = currentNode.next;
                }
                return currentNode.element;
            }
        }
        return null;
    }

    @Override
    public void set(int index, T value) throws Exception {
        if (!isListEmpty() && isIndexValid(index, true)) {
            Node<T> currentNode = head;
            for (int i = 1; i <= index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.element = value;
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = head;
        size = 0;
    }

    @Override
    public int indexOf(T value) throws Exception {
        if (!isListEmpty()) {
            Node<T> currentNode = head;
            for (int i = 0; i < size; i++) {
                if (currentNode.element.equals(value)) {
                    return i;
                } else {
                    currentNode = currentNode.next;
                }
            }

        }
        return -1;
    }

    @Override
    public String toString() {
        Object[] arrayTemp = new Object[size];
        Node<T> currentNode = head;

        for (int i = 0; i < size; i++) {
            arrayTemp[i] = currentNode.element;
            if (i < size - 1) {
                currentNode = currentNode.next;
            }
        }
        return Arrays.toString(arrayTemp);
    }

    @Override
    public T remove(int index) throws Exception {
        T deletedElement;
        if (!isListEmpty() && isIndexValid(index, true)) {
            if (size == 1) {//1 existing element, 2.1
                deletedElement = head.element;
                head = null;
                tail = head;
                size--;
                return deletedElement;
            } else if (index == 0) {// first element
                deletedElement = head.element;
                head = head.next;
                size--;
                return deletedElement;
            } else if ((index > 0) && (index < size - 1)) {// add at the beginning, 1 existing element 3.2
                Node<T> deletedNode = findNode(index);
                deletedNode.next.prev = deletedNode.prev;
                deletedNode.prev.next = deletedNode.next;
                size--;
                return deletedNode.element;
            } else if (index == size - 1) {
                deletedElement = tail.element;
                tail = tail.prev;
                size--;
                return deletedElement;
            }
        }
        return null;
    }

    @Override
    public boolean remove(T value) throws Exception {
        if (!isListEmpty()) {
            Node<T> deletedNode = findNode(value);
            if (deletedNode == null) {
                throw new Exception("Element not found");
            } else if (size == 1) {
                head = null;
                tail = head;
                size--;
                return true;
            } else if (deletedNode == head) {
                head = head.next;
                size--;
                return true;
            } else if (deletedNode == tail) {
                tail = tail.prev;
                size--;
                return true;
            } else {
                deletedNode.next.prev = deletedNode.prev;
                deletedNode.prev.next = deletedNode.next;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    public boolean isIndexValid(int index, boolean notEqualSize) throws Exception {
        if (!notEqualSize && ((index < 0) || (index > size))) {
            throw new Exception("Index out of boundary");
        } else if (notEqualSize && ((index < 0) || (index >= size))) {
            throw new Exception("Index out of boundary");
        }
        return true;
    }

    public boolean isListEmpty() throws Exception {
        if (size == 0) {
            throw new Exception("List is empty");
        }
        return false;
    }
}

