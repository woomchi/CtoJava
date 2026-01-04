package 자바의정석.CollectionFrameWork;
import java.util.*;

public class MyStack extends Vector {
    public Object push(Object item){
        addElement(item);   //요소 추가
        return item;
    }

    public Object pop(){
        Object obj = peek();    //마지막 요소 추출
        removeElementAt(size()-1);  //제거
        return obj;
    }

    public Object peek(){
        int len = size();
        if(len == 0){
            throw new EmptyStackException();    //EmpyStackException은 RuntimeException으로 따로 예외처리 X
        }
        return elementAt(len-1);    //마지막 요소 반환
    }

    public boolean empty(){
        return size() == 0;
    }

    public int search(Object o){
        int i = lastIndexOf(o);

        if(i >= 0){
            return size()-i;
        }
        return -1;
    }
}
