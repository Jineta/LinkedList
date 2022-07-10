import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception{
        MyLinkedListImplementation<Integer> linkedList = new MyLinkedListImplementation<>();

        for (int i = 0; i < 5; i++) {//  create initial list
            linkedList.add(i);
    }
        System.out.println("Add. Size: "+linkedList.getSize()+ ", " + linkedList);
        // test addByIndex
        try {System.out.println("Remove 0. Size before: " +  linkedList.getSize() + ", "+linkedList.removeV(0)+ ", " + linkedList);
            System.out.println("Remove 2. Size before: " + linkedList.getSize() + ", "+linkedList.removeV(2)+ ", " + linkedList);
            System.out.println("Remove 4. Size before: " + linkedList.getSize() + ", "+linkedList.removeV(4)+ ", " + linkedList);

            System.out.println("Remove 3. Size before: " + linkedList.getSize() + ", "+linkedList.removeV(3)+ ", " + linkedList);
            System.out.println("Remove 1. Size before: " + linkedList.getSize() + ", "+linkedList.removeV(1)+ ", " + linkedList);

            System.out.println("Remove 5. Size before: " + linkedList.getSize() + ", "+linkedList.removeV(5)+ ", " + linkedList);
 //           System.out.println("Remove 0. Size: "+linkedList.remove(0)+ ", " + linkedList);
 //           System.out.println("Remove 2. Size: "+linkedList.remove(2)+ ", " + linkedList);
 //           System.out.println("Remove 3. Size: "+linkedList.remove(3)+ ", " + linkedList);
//
            //SET
//            for (int i = 0; i < 5; i++) {//  create initial list
//                linkedList.set(i,i+11);
//            }

//            System.out.println("indexOf: " + " " + linkedList.indexOf(11));
//            System.out.println("indexOf: " + " " + linkedList.indexOf(13));
//            System.out.println("indexOf: " + " " + linkedList.indexOf(15));
//            System.out.println("indexOf: " + " " + linkedList.indexOf(1));

//            linkedList.add(0, 100);
//            System.out.println("Add by index 0. Size: " + linkedList.getSize() + ", " + linkedList);
//            linkedList.add(4, 300);
//            System.out.println("Add by index 4. Size: " + linkedList.getSize() + ", " + linkedList);
//            linkedList.add(6, 500);
//            System.out.println("Add by index 6. Size: " + linkedList.getSize() + ", " + linkedList);
//            linkedList.add(8, 600);
//            System.out.println("Add by index 8. Size: " + linkedList.getSize() + ", " + linkedList);
//            linkedList.add(8, 700);
//            System.out.println("Add by index 8. Size: " + linkedList.getSize() + ", " + linkedList);
//            linkedList.add(0, 800);
//            System.out.println("Add by index 0. Size: " + linkedList.getSize() + ", " + linkedList);
//
//            for (int i = 0; i < 5; i++) {//  create initial list
//                linkedList.add(i);
//            }
//            System.out.println("Add. Size: " + linkedList.getSize() + ", " + linkedList);
//            System.out.println("Get 0, 4, 15: " + linkedList.get(0) + ", " + linkedList.get(4) + ", " + linkedList.get(15));
            //System.out.println("Get 16. Size: " + linkedList.get(-1));


           MyLinkedListImplementation<Integer> linkedList2 = new MyLinkedListImplementation<>();
            System.out.println("Remove 4. Size: "+linkedList2.remove(4)+ ", " + linkedList2);
//            System.out.println("indexOf: " + " " + linkedList2.indexOf(1));
//            linkedList2.set(0,1);
//        linkedList2.add(0,100);
//        System.out.println("Add by index 0. Size: "+linkedList2.getSize()+ ".." +  linkedList2);
//        System.out.println("Get 16: "+linkedList2.get(0));
//
//        linkedList2.add(1, 200);
//        System.out.println("Add by index 1. Size: "+linkedList2.getSize()+ ".." +  linkedList2);
 //           System.out.println("Get" + linkedList2.get(0));
       }
        catch(Exception e) {
            System.out.println(e.getMessage());

        }
        }
    }


