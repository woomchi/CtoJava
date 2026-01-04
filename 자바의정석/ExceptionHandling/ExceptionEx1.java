package 자바의정석.ExceptionHandling;

public class ExceptionEx1 {
    public static void main(String[] args) {
        try{
            try{    }   catch(Exception e){ }
        }catch(Exception e){
        //    try{    }   catch(Exception e){ }   // 에러 발생: 지역변수 e가 중복됨
        }

        try{

        }catch(Exception e){
            
        }
    }
}
