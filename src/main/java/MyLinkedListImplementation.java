import java.util.Arrays;
import java.lang.Exception;

public class MyLinkedListImplementation<T> implements MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

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
        if ((index < 0) || (index > size)) {
            throw new Exception("Index for Add is out of boundary");
        } else {
            if ((size == 0) && (index == 0)) {//  (fist node in the list), 1
                head = new Node<>(null, null, value);
                tail = head;
            } else if ((size == 1) && (index == 0)) {// add at the beginning, 1 existing element, 2.1
                head = new Node<>(head, null, value);
                tail.prev = head;
            } else if ((size == 1) && (index == size)) {// add new element at the end, 1 existing element 2.2
                tail = new Node<>(null, head, value);
                head.next = tail;
            } else if ((size > 1) && (index == size)) {// add new element at the end
                tail.next = new Node<>(null, tail, value);
                tail = tail.next;
            } else if ((size > 1) && (index == 0)) {// add at the beginning, 1 existing element 3.1
                head.prev = new Node<>(head, null, value);
                head = head.prev;
            } else if ((size > 1) && (index > 0) && (index <= size-1)) {// add at the middle, 1 existing element 3.2
                Node<T> prevNode = head;
                Node<T> nextNode = head.next;
                for (int i = 1; i < index; i++) {
                    prevNode = prevNode.next;
                    nextNode = nextNode.next;
                }
                prevNode.next = new Node<>(nextNode, prevNode, value);
                nextNode.prev = prevNode.next;
          }
            size++;
        }
    }

    @Override
    public T get(int index) throws Exception {
        if (size == 0) {
            throw new Exception("List is empty");
        } else if ((index < 0) || (index >= size)) {
            throw new Exception("Index for Get is out of boundary");
        } else {
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
    }

    @Override
    public void set(int index, T value) throws Exception {
        if (size == 0) {
            throw new Exception("List is empty");
        } else if ((index < 0) || (index >= size)) {
            throw new Exception("Index for Set is out of boundary");
        } else {
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
        if (size == 0) {
            throw new Exception("List is empty");
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < size; i++) {
                if (currentNode.element == value) {
                    return i;
                } else {
                    currentNode = currentNode.next;
                }
            }
            return -1;
        }
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
        if (size == 0) {
            throw new Exception("List is empty");
        } else if ((index < 0) || (index >= size)) {
            throw new Exception("Index for Remove is out of boundary");
        } else {

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

                Node<T> prevNode = head;
                Node<T> nextNode = prevNode.next.next;
                for (int i = 1; i < index; i++) {
                    prevNode = prevNode.next;
                    nextNode = nextNode.next;
                }
                deletedElement = prevNode.next.element;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                size--;
                return deletedElement;
            } else if (index == size - 1) {
                deletedElement = tail.element;
                tail = tail.prev;
                size--;
            }
        }
        return null;
    }

    @Override
    public boolean removeV(T value) throws Exception {
        int index = indexOf(value);
        if (index == -1) {
            throw new Exception("Element not found");
        } else if (size == 0) {
            throw new Exception("List is empty");
        } else if ((index < 0) || (index >= size)) {
            throw new Exception("Index for Remove is out of boundary");
        } else {
            if (size == 1) {//1 existing element, 2.1
                head = null;
                tail = head;
                size--;
                return true;
            } else if (index == 0) {// first element
                head = head.next;
                size--;
                return true;
            } else if ((index > 0) && (index < size - 1)) {// add at the beginning, 1 existing element 3.2

                Node<T> prevNode = head;
                Node<T> nextNode = prevNode.next.next;
                for (int i = 1; i < index; i++) {
                    prevNode = prevNode.next;
                    nextNode = nextNode.next;
                }
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                size--;
                return true;
            } else if (index == size - 1) {
                tail = tail.prev;
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
}

