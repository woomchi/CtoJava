package study.CollectionFrameWork;
import java.util.*;

public class ComparatorEx {
    public static void main(String[] args) {
        String [] strArr = {"cat","Dog","Lion","tiger"};

        Arrays.sort(strArr);    //String의 Comparable 구현
        System.out.println("strArr="+Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 X
        System.out.println("strArr="+Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println("strArr="+Arrays.toString(strArr));
    }
}

class Descending implements Comparator<String>{
    public int compare(String s1, String s2){
        s2.compareTo(s1);

        // 제네릭스를 사용하기 때문에 더 이상 타입 체크하고 형변환할 필요없음
        // if(o1 instanceof Comparable &&  o2 instanceof Comparable){
        //     Comparable c1 = (Comparable)o1;
        //     Comparable c2 = (Comparable)o2;
        //     return c1.compareTo(c2) * -1;   //기본 정렬 방식의 역으로 만듬
        //     // == return c2.compareTo(c1);
        // }
        return -1;
    }
}
