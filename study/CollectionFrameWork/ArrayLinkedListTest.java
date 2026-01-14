package study.CollectionFrameWork;
import java.util.*;

public class ArrayLinkedListTest {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>(2000000);
        LinkedList<String> ll = new LinkedList<String>();

        System.out.println("= 순차적으로 추가하기 =");
        System.out.println("ArrayList: "+add1(al));
        System.out.println("LinkedList: "+add1(ll));
        
        System.out.println("= 중간에 추가하기 =");
        System.out.println("ArrayList: "+add2(al));
        System.out.println("LinkedList: "+add2(ll));

        System.out.println("= 중간에서 삭제하기 =");
        System.out.println("ArrayList: "+remove2(al));
        System.out.println("LinkedList: "+remove2(ll));
        
        System.out.println("= 순차적으로 삭제하기 =");
        System.out.println("ArrayList: "+remove1(al));
        System.out.println("LinkedList: "+remove1(ll));
        
    }

    private static long add1(List<String> list) {
        // 순방향으로 i값을 추가
        long start = System.currentTimeMillis();
        for(int i=0;i<1000000;i++) list.add(i+"");
        long end = System.currentTimeMillis();
        return end-start;
    }

    private static long add2(List<String> list) {
        // 500간격마다 문자열 "X"를 추가
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++) list.add(500,"X");
        long end = System.currentTimeMillis();
        return end-start;
    }

    private static long remove1(List<String> list) {
        // 역방향으로 i값 제거
        long start = System.currentTimeMillis();
        for(int i=list.size()-1; i>=0 ;i--) list.remove(i);
        long end = System.currentTimeMillis();
        return end-start;
    }

    private static long remove2(List<String> list) {
        // 순방향으로 i값을 제거
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++) list.remove(i);
        long end = System.currentTimeMillis();
        return end-start;
    }
}
