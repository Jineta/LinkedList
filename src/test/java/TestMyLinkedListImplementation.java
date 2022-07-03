import  java.lang.Exception;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class TestMyLinkedListImplementation {
    @Test
    public void add_createNewList() throws Exception {
        MyLinkedListImplementation<Integer> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add(i);
        }
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(i, listActual.get(i));
        }
    }

    @Test
    public void addByIndex_createNewList() throws Exception {
        MyLinkedListImplementation<Integer> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add(i, i + 11);
        }
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(i + 11, listActual.get(i));
        }
    }

    @Test
    public void addByIndex_0_size1() throws Exception {
        MyLinkedListImplementation<Integer> listActual = new MyLinkedListImplementation<>();
        listActual.add(100);
        listActual.add(0, 200);
        Assertions.assertEquals(200, listActual.get(0));
        Assertions.assertEquals(100, listActual.get(1));
    }

    @Test
    public void addByIndex_0_sizeMore1() throws Exception {
        MyLinkedListImplementation<Integer> listActual = new MyLinkedListImplementation<>();
        Integer[] listExpected = new Integer[3];
        for (int i = 0; i < 3; i++) {
            listActual.add(i, i + 11);
            listExpected[i] = i+11;
        }
        listActual.add(0, 200);
        Assertions.assertEquals(200, listActual.get(0));

        for (int i = 1; i < 4; i++) {
            Assertions.assertEquals(listExpected[i-1], listActual.get(i));
        }
    }
    @Test
    public void addByIndex_middle_sizeMore1() throws Exception {
        MyLinkedListImplementation<Integer> listActual = new MyLinkedListImplementation<>();
        List<Integer> listExpected = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listActual.add(i + 11);
            listExpected.add(i + 11);
        }
        listExpected.add(1,222);
        listActual.add(1, 222);

        for (int i = 0; i < 4; i++) {
            Assertions.assertEquals(listExpected.get(i), listActual.get(i));
        }
    }
    @Test
    public void addByIndex_last_sizeMore1() throws Exception {
        MyLinkedListImplementation<Integer> listActual = new MyLinkedListImplementation<>();
        List<Integer> listExpected = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listActual.add(i + 11);
            listExpected.add(i + 11);
        }
        listExpected.add(2,222);
        listActual.add(2, 222);

        for (int i = 0; i < 4; i++) {
            Assertions.assertEquals(listExpected.get(i), listActual.get(i));
        }
    }
//
    @Test
    public void addByIndex_newLast_sizeMore1() throws Exception {
        MyLinkedListImplementation<Integer> listActual = new MyLinkedListImplementation<>();
        List<Integer> listExpected = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listActual.add(i + 11);
            listExpected.add(i + 11);
        }
        listExpected.add(2,222);
        listActual.add(2, 222);

        for (int i = 0; i < 4; i++) {
            Assertions.assertEquals(listExpected.get(i), listActual.get(i));
        }
    }
}
