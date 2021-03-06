package code_02_threadSafeStrategy.synchronizedContainer;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by 18351 on 2018/11/6.
 */
//@NotThreadSafe
public class VectorExample2 {
    // java.util.ConcurrentModificationException
    // 在遍历的同时进行了删除的操作，导致抛出了并发修改的异常
    private static void test1(Vector<Integer> v1) { // foreach
        for(Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1) { // iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // success
    private static void test3(Vector<Integer> v1) { // for
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        //test1(vector);
        //test2(vector);
        test3(vector);
        System.out.println(vector);
    }
}
