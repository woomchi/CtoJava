package 자바의정석;
import java.util.*;

public class IteratorEx2 {
    public static void main(String[] args) {
        ArrayList original = new ArrayList();
        ArrayList copy1 = new ArrayList();
        ArrayList copy2 = new ArrayList();

        for(int i=0;i<10;i++){
            original.add(i);
        }

        Iterator it = original.iterator();
        while(it.hasNext()){
            copy1.add(it.next());
        }

        System.out.println("= Original에서 copy1로 복사(copy) =");
        System.out.println("original: "+original);
        System.out.println("copy1: "+copy1);
        System.out.println();

        it = original.iterator();   // iterator는 단 한 번만 사용 가능하므로 다시 얻어와야함

        while(it.hasNext()){
            copy2.add(it.next());
            it.remove();
        }

        System.out.println("= Original에서 copy2로 복사(copy) =");
        System.out.println("original: "+original);
        System.out.println("copy2: "+copy2);
        System.out.println();

    }
}
