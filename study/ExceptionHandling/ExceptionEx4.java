package study.ExceptionHandling;

public class ExceptionEx4 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(0/0);    // 예외 발생
            System.out.println(4);   // 실행되지 않음     
        }catch(ArithmeticException ae){    // ArithmeticException 예외 발생
            if(ae instanceof ArithmeticException){
                System.out.println(true);
            }
            System.out.println("ArithmeticException");

        }catch(Exception e){
            System.out.println("Exception");
        }
        System.out.println(6);
    }
}