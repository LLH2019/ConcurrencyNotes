package code_02_threadSafeStrategy;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.List;

/**
 * Created by 18351 on 2018/11/6.
 */
//@ThreadSafe
public class Code_01_Immutable {
    private final static List<Integer> list = ImmutableList.of(1,2,3);
    private final static ImmutableSet set = ImmutableSet.copyOf(list);
    // 奇数位参数为key，偶数位参数为value
    private final static ImmutableMap map1 = ImmutableMap.of(1,2,3,5);

    private final static ImmutableMap<Integer,Integer> map2 = ImmutableMap.<Integer,Integer>builder()
            .put(1,2).put(3,4).build();

    public static void main(String[] args) {
        // 执行都会抛出 UnsupportedOperationException异常
        list.add(5);
        //使用ImmutableXXX声明会直接在编译的时候就告诉你这个方法已经被废弃,斜杠为证
        set.add(6);
        map1.put(1,2);
        map2.put(3,4);
    }
}
