import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestMyLinkedListImplementation {

    @Test
    public void add_createNewList() throws Exception {
        String[] expected = new String[]{"s0", "s1", "s2"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test
    public void addByIndex_createNewList() throws Exception {
        String[] expected = new String[]{"s0", "s1", "s2"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add(i, "s" + i);
        }
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test
    public void addByIndex_0_size1() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        listActual.add("first");
        listActual.add(0, "newFirst");
        Assertions.assertEquals("newFirst", listActual.get(0));
        Assertions.assertEquals("first", listActual.get(1));
    }

    @Test
    public void addByIndex_newTail_size1() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        listActual.add("first");
        listActual.add(1, "newTail");
        Assertions.assertEquals("first", listActual.get(0));
        Assertions.assertEquals("newTail", listActual.get(1));
    }

    @Test
    public void addByIndex_last_sizeMore1() throws Exception {
        String[] expected = new String[]{"s0", "s1", "added", "s2"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        listActual.add(2, "added");
        for (int i = 0; i < 4; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test
    public void addByIndex_0_sizeMore1() throws Exception {
        String[] expected = new String[]{"added", "s0", "s1", "s2"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add(i, "s" + i);
        }
        listActual.add(0, "added");

        for (int i = 1; i < 4; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test
    public void addByIndex_middle_sizeMore1() throws Exception {
        String[] expected = new String[]{"s0", "added", "s1", "s2"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        listActual.add(1, "added");
        for (int i = 0; i < 4; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }


    @Test
    public void addByIndex_newTail_sizeMore1() throws Exception {
        String[] expected = new String[]{"s0", "s1", "s2", "added"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        listActual.add(3, "added");
        for (int i = 0; i < 4; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    //TODO ask questions about unit tests -  it seems, my tests are something like a bullshit
    //
    @Test
    public void removeByIndex_0_size1() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        listActual.add("first");
        Assertions.assertEquals("first", listActual.remove(0));
        //TODO add assert to be sure that list is empty? size or exception
    }

    @Test
    public void removeByIndex_0_sizeMore1() throws Exception {
        String[] expected = new String[]{"s1", "s2"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        Assertions.assertEquals("s0", listActual.remove(0));
        for (int i = 1; i < 2; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test
    public void removeByIndex_middle_sizeMore1() throws Exception {
        String[] expected = new String[]{"s0", "s2"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        Assertions.assertEquals("s1", listActual.remove(1));
        for (int i = 1; i < 2; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test
    public void removeByIndex_Tail_sizeMore1() throws Exception {
        String[] expected = new String[]{"s0", "s1"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        Assertions.assertEquals("s2", listActual.remove(2));
        for (int i = 1; i < 2; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test
    public void removeByValue_0_size1_found() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        listActual.add("first");
        Assertions.assertEquals(true, listActual.remove("first"));
        //TODO add assert to be sure that list is empty? size or exception
    }

    @Test
    public void removeByValue_head_sizeMore1_found() throws Exception {
        String[] expected = new String[]{"s1", "s2"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        Assertions.assertEquals(true, listActual.remove("s0"));
        for (int i = 1; i < 2; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test
    public void removeByValue_middle_sizeMore1_found() throws Exception {
        String[] expected = new String[]{"s0", "s2"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        Assertions.assertEquals(true, listActual.remove("s1"));
        for (int i = 1; i < 2; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test
    public void removeByValue_tail_sizeMore1_found() throws Exception {
        String[] expected = new String[]{"s0", "s1"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        Assertions.assertEquals(true, listActual.remove("s2"));
        for (int i = 1; i < 2; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test //TODO exception in assert
    public void removeByValue_notFound() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        Assertions.assertEquals(false, listActual.remove("s4"));
    }

    @Test
    public void set_sizeMore1() throws Exception {
        String[] expected = new String[]{"set0", "set1", "set2"};
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        for (int i = 0; i < 3; i++) {
            listActual.set(i, "set" + i);
        }
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(expected[i], listActual.get(i));
        }
    }

    @Test
    public void set_size1() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        listActual.add("s");
        listActual.set(0, "set");
        Assertions.assertEquals("set", listActual.get(0));
    }

    @Test
    public void indexOf_sizeMore1_found() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 4; i++) {
            listActual.add("s" + i);
        }
        listActual.set(2, "s1");
        Assertions.assertEquals(1, listActual.indexOf("s1"));
        Assertions.assertEquals(0, listActual.indexOf("s0"));
        Assertions.assertEquals(3, listActual.indexOf("s3"));
    }

    @Test
    public void indexOf_size1_found() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        listActual.add("s0");
        Assertions.assertEquals(0, listActual.indexOf("s0"));
    }

    @Test
    public void indexOf_notFound() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        Assertions.assertEquals(-1, listActual.indexOf("s4"));
    }

    @Test
    public void size_empty() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        Assertions.assertEquals(0, listActual.getSize());
    }

    @Test
    public void size_1() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        listActual.add("s");
        Assertions.assertEquals(1, listActual.getSize());
    }

    @Test
    public void size_more1() throws Exception {
        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
        for (int i = 0; i < 3; i++) {
            listActual.add("s" + i);
        }
        Assertions.assertEquals(3, listActual.getSize());
    }

    //TODO unit tests for errors (list is empty, boundary errors) for Add, Set  etc
//    @Test
//    public void addByIndex_errorOutOfBoundary() throws Exception {
//        MyLinkedListImplementation<String> listActual = new MyLinkedListImplementation<>();
//        for (int i = 0; i < 3; i++) {
//            listActual.add("s"+i);
//        }
//        listActual.add(5, "added");
//
//        String methodName = "stringExpressionThatIsNeitherTrueNorFalse";
////        IllegalStateException exception = assertThrows(IllegalStateException.class,
////                () -> condition.evaluateExecutionCondition(buildExtensionContext(methodName)));
//
//        Assertions.assertThrows(Exception.getMessage(), "Index out of boundary");
//        Assertions.assertEquals("Index out of boundary",thrown.getMessage());
//    }

//    @Test
//    public void isIndexValid() throws Exception {
//        MyLinkedListImplementation<Integer> listActual = new MyLinkedListImplementation<>();
//
//        for (int i = 0; i < 3; i++) {
//            listActual.add(i);
//        }
//            Assertions.assertEquals(false, listActual.isIndexValid(-1, true));
//            Assertions.assertEquals(false, listActual.isIndexValid(4, true));
//            Assertions.assertEquals(false, listActual.isIndexValid(3, true));
//            Assertions.assertEquals(true, listActual.isIndexValid(0, true));
//            Assertions.assertEquals(true, listActual.isIndexValid(1, true));
//
//            Assertions.assertEquals(false, listActual.isIndexValid(-1, false));
//            Assertions.assertEquals(false,listActual.isIndexValid(4, false));
//            Assertions.assertEquals(true,listActual.isIndexValid(3, false));
//            Assertions.assertEquals(true,listActual.isIndexValid(0, false));
//            Assertions.assertEquals(true,listActual.isIndexValid(1, false));
//    }
}

