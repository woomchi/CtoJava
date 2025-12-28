package 자바의정석;

import java.util.*;

public class VectorEx1 {
    public static void main(String[] args) {
        // capacity가 5인 Vector v를 생성하고 3개의 객체를 저장한 상태
        Vector v = new Vector(5);
        v.add("1");
        v.add("2");
        v.add("3");
        print(v);

        // 빈 공간을 없애서 capacity와 size를 같게 만드는데 배열은 크기를 생성한 뒤에 변경할 수 없어서 새로운 배열을 생성해 주소값을 v로 할당함
        v.trimToSize(); // 용량과 크기를 같게만들어 빈공간을 없앰
        System.out.println("=== After trimToSize() ===");
        print(v);


        // v의 capacity가 최소한 6이 되도록 한다. 이때 기존 v의 capacity가 3이므로 새로운 배열을 생성해 주소값을 v의 내용을 복사함
        v.ensureCapacity(6);
        System.out.println("=== After ensureCapacity(6) ===");
        print(v);

        // v의 크기를 7로 설정했는데 capacity가 6으로 부족하다. 이때 vector에서는 capacity가 부족하면 2배 크기로 증가된다.
        // vector를 사용해 인스턴스를 생성한 경우에는 지정해준 capacityIncrement만큼 증가하게 된다.
        v.setSize(7);
        System.out.println("=== After setSize(7) ===");
        print(v);

        // v의 내용을 모두 지웠다. 하지만, capacity는 그대로다.
        v.clear();
        System.out.println("=== After clear() ===");
        print(v);

        //Vector는 Object 배열로 인덱스가 아닌 주소로 저장된 형태이다.
        
        /*

        결론
        ArrayList나 Vector같이 배열을 이용한 자료구조는 데이터를 읽어오고 저장할 때 효율이 좋다.
        다만, 용량을 변경할 때 새로운 배열을 생성 후, 기존 배열로부터 생성된 배열로 데이터를 복사하기 때문에 상당히 효율이 떨어진다.
        따라서, 처음 인스턴스를 생성할 때, 저장할 데이터의 개수를 잘 고려해 충분한 용량의 인스턴스를 생성하는 것이 좋다.
            **용량을 늘릴 수는 있지만 이를 재할당하는 처리 시간이 증가된다는 점에서 지양해야한다.

        */
    }

    static void print(Vector v) {
        System.out.println(v);
        System.out.println("size: "+v.size());
        System.out.println("capacity: "+v.capacity());
    }  
}
