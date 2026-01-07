package study.ExceptionHandling;

public class ExceptionEx3 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(0/0);    // 예외 발생
            System.out.println(4);   // 실행되지 않음     
        }catch(Exception e){    // ArithmeticException 예외 발생
            System.out.println(5);
        }
        System.out.println(6);
    }
}