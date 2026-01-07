package study.ExceptionHandling;

public class Exception7 {
    public static void main(String[] args) throws Exception {
        method1();              //예외 전달 => 프로그램 종료(예외 처리 X)
    }
    static void method1() throws Exception{
        method2();              //예외 전달
    }
    static void method2() throws Exception{
        throw new Exception();  // 예외 발생
    }
}
