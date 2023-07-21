package EffectiveJava.General;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<String> ti = new ArrayList<>();
        ti.add("a");
        ti.add("b");
        ti.add("c");

        for (String s : ti) {
            if (s.equals("a")) {
                ti.remove(s);
            }
        }

        int size = ti.size();

//        for (int i = 0; i < ti.size(); i++) {
//            if (ti.get(i).equals("b")) {
//                ti.remove(i);
////                size--;
////                i--;
//            }
//        }
    }
}
