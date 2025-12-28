package 자바의정석;
import java.util.*;

public class ArrayListEx1 {
    public static void main(String [] args){
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        ArrayList list2 = new ArrayList(list1.subList(1,4));
        print(list1, list2);

        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.containAll(list2: "
            + list1.containsAll(list2));
        
        list2.add("B");
        list2.add("C");
        list2.add(3,"A");
        print(list1,list2);

        list2.set(3, "AA");
        print(list1, list2);

        System.out.println("list1.retainAll(list2): "
            + list1.retainAll(list2));
        print(list1, list2);

        for(int i= list2.size()-1;i>=0;i--){
            if(list1. contains(list2.get(i))){
                list2.remove(i);
            }
        }

        // i를 증가시키며 삭제하면 요소가 삭제될 때마다 빈 공간을 채우기 위해 나머지 요소들이 자리이동한다.
        // 만약 첫번째 요소를 삭제되면 다음 요소가 첫번째 요소가 되지만, 인덱스는 증가해서 겹치더라도 삭제하지 못하는 문제가 발생한다.
      /*for(int i= 0;i<list2.size();i++){
            if(list1.contains(list2.get(i))){
                list2.remove(i);
            }
        } */
        
        print(list1,list2);

    }

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1: "+list1);
        System.out.println("list2: "+list2);
        System.out.println();
    }    
}
