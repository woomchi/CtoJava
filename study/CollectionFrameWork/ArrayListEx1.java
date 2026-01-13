package study.CollectionFrameWork;
import java.util.*; // ArrayList, Collection 등을 포함하는 패키지

public class ArrayListEx1 {
    public static void main(String [] args){
        ArrayList<String> list1 = new ArrayList<String>(10);       // 크기가 10인 ArrayList 생성
        list1.add(String.valueOf(5));  // 따로 변수를 선언하지 않고 정수형의 생성자로 바로 입력시킴
        list1.add(String.valueOf(4));
        list1.add(String.valueOf(2));
        list1.add(String.valueOf(0));
        list1.add(String.valueOf(1));
        list1.add(String.valueOf(3));

        // list1의 1부터 4번째까지 반환된 객체를 list2를 생성할 때 저장(List 타입이므로 Collection 매개변수로 적합함)
        ArrayList<String> list2 = new ArrayList<String>(list1.subList(1,4));    
        print(list1, list2);

        // Collection은 인터페이스이고, Collections는 메서드를 가진 클래스이다.
        // sort() 외에도 fill(), copy(), binarySearch() 등의 메서드도 존재한다. 
        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.containAll(list2: "
            + list1.containsAll(list2));
        
        // list2의 맨마지막에 데이터를 저장
        list2.add("B");
        list2.add("C");

        //지정된 위치에 데이터를 저장(끼워넣음)
        list2.add(3,"A");
        print(list1,list2);

        // 지정된 위치의 기존 데이터를 element로 변경
        list2.set(3, "AA");
        print(list1, list2);

        System.out.println("list1.retainAll(list2): "
            + list1.retainAll(list2));
        print(list1, list2);

        // i를 증가시키며 삭제하면 요소가 삭제될 때마다 빈 공간을 채우기 위해 나머지 요소들이 자리이동하는 특성이 있음
        // 만약 첫번째 요소를 삭제되면 다음 요소가 첫번째 요소가 되지만, 인덱스는 증가하기 때문에 이를 삭제하지 못하는 문제가 발생
      /*for(int i= 0;i<list2.size();i++){
            if(list1.contains(list2.get(i))){
                list2.remove(i);
            }
        } */

        // 따라서 배열값이 삭제되는 것으로 인덱스가 줄어 제거하지 못하는 경우를 없애고자 역방향으로 검색함
        for(int i= list2.size()-1;i>=0;i--){
            if(list1. contains(list2.get(i))){
                list2.remove(i);
            }
        }
        print(list1,list2);

    }

    static void print(ArrayList<String> list1, ArrayList<String> list2) {
        System.out.println("list1: "+list1);
        System.out.println("list2: "+list2);
        System.out.println();
    }    
}
