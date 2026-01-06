package 자바의정석.ExceptionHandling;

public class Exception6 {
    public static void main(String[] args) {
        try {
            throw new Exception("고의로 발생시켰음");
        } catch (Exception e) {
            System.out.println("에러 메세지 : "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
