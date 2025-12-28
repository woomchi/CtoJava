package 자바의정석;
import java.util.*;

public class ArrayListEx2 {
    public static void main(String [] args){
        final int LIMIT = 10;
        String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
        int length = source.length();
        
        List list = new ArrayList<>(length/LIMIT+10);   // 크기를 10정도 여유있게 할당하는 사전작업을 통해 크기 재할당으로 인한 처리시간 증가 방지

        for(int i=0;i<length;i+=LIMIT){
            if(i+LIMIT <length){
                list.add(source.substring(i, i+LIMIT));
            }else{
                list.add(source.substring(i));                
            }
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
