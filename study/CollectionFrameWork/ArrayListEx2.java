package study.CollectionFrameWork;
import java.util.*;

public class ArrayListEx2 {
    public static void main(String [] args){
        final int LIMIT = 10;   // 문자열을 끊는 단위
        String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
        int length = source.length();
        
        // 크기를 10정도 여유있게 할당하는 사전작업을 통해 크기 재할당으로 인한 처리시간 증가 방지
        List<String> list = new ArrayList<String>(length/LIMIT+10);   

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
