package study.CollectionFrameWork;
import java.util.*;

public class TreeSetLotto {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();

        Iterator<Integer> it = set.iterator();
        while(it.hasNext() || set.size()<6){
            set.add((int)(Math.random()*45)+1);
        }
        System.out.println(set);
    }
}
