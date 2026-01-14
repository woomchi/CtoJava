package study.CollectionFrameWork;
import java.util.*;

public class HashSetLotto {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        // int i가 직접 쓰지 않아서 Iterator로 변경
        Iterator<Integer> it = set.iterator();
        while(it.hasNext() || set.size()<6){
            set.add(Integer.valueOf((int)(Math.random()*45)+5));
        }

        List<Integer> list = new LinkedList<Integer>(set);
        Collections.sort(list);
        System.out.println(list);
    }
}
