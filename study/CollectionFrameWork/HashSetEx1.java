package study.CollectionFrameWork;
import java.util.*;

public class HashSetEx1 {
    public static void main(String[] args) {
        Object [] objArr = {"1", Integer.valueOf(1), "2", "2", "3" ,"3", "4", "4", "4"};
        Set<Object> set = new HashSet<>(Arrays.asList(objArr));

        // 반복문으로 추가하는 것을 복사 생성자로 개선
        // for(int i=0;i<objArr.length;i++){
        //     set.add(objArr[i]);
        // }
        System.out.println(set);
    }
}
