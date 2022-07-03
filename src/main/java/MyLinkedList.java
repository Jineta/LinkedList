import  java.lang.Exception;
public interface MyLinkedList<T> {
    void add(T value) throws Exception;
    void add(int index,T value) throws Exception;
    int getSize();
    void clear();
    T get(int index) throws Exception ;
    int indexOf(T value) throws Exception; // in spec Object o
    void set(int index,T value) throws Exception;
    T remove(int index) throws Exception;
    boolean removeV(T value) throws Exception;
}
