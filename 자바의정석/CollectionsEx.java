package 자바의정석;
import java.util.*;
import static java.util.Collections.*;

public class CollectionsEx {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list);

        addAll(list, 1,2,3,4,5);
        System.out.println(list);

        rotate(list, 2);    //rotate 메서드 : 오른쪽으로 2칸 이동
        System.out.println(list);

        swap(list, 0, 2);       //swap 메서드 : 첫 번째 요소와 세 번째 요소 교환
        System.out.println(list);

        shuffle(list);              //shuffle 메서드 : 저장된 요소의 위치를 임의로(무작위) 변경
        System.out.println(list);

        sort(list, reverseOrder()); //reverseOrder 메서드 : 역순 정렬 == reverse(list);
        System.out.println(list);   

        sort(list);
        System.out.println(list);

        int idx = binarySearch(list, 3);    // binarySearch 메서드 : list에서 3이 저장된 위치 반환
        System.out.println("index of 3 = "+idx);

        System.out.println("max="+max(list));
        System.out.println("min="+min(list));
        System.out.println("min="+max(list, reverseOrder()));

        fill(list, 9);                      // fill 메서드 : 모든 요소를 9로 채움
        System.out.println("list="+list);

        // List와 같은 크기의 새로운 List를 생성하고 2로 채움(단, 크기 변경 불가)
        List newList = nCopies(list.size(),2);
        System.out.println("newList="+newList);

        System.out.println(disjoint(list,newList)); // disjoint 메서드 : 공통 요소가 없으면 true 반환

        copy(list,newList);
        System.out.println("newList="+newList);
        System.out.println("list="+list);

        replaceAll(list,2,1);
        System.out.println("list="+list);
        
        Enumeration e = enumeration(list);
        ArrayList list2 = list(e);

        System.out.println("list2="+list2);
    }
}
