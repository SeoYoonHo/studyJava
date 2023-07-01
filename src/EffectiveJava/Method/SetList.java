package EffectiveJava.Method;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        // [-3,-2,-1] 예상하지만
        // list.remove(int i) 는 i번째 인덱스의 값을 지운다
        // 즉 [-3,-2,-1,0,1,2] --> 0번째 인덱스 -3을 지우고 [-2,-1,0,1,2]
        // 1번째 인덱스 -1을 지우고 --> [-2,0,1,2] --> [-2,0,2] 가 된다.
        // 이를 해결하기 위해선 list.remove(Integer i)를 호출해야 한다!
        for (int i = 0; i < 3; i++) {
            set.remove(i);
//            list.remove(i);
            list.remove((Integer) i);
        }

        System.out.println(set + " " + list);
    }
}
