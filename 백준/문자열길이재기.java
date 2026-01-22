package 백준;
import java.util.*;

class 문자열길이재기{
    // 나의 풀이
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        sc.close();        
        System.out.println(word.length());
    }

    // Gemini를 통한 원초적인 풀이
    public void solution(){
        String str = "Hello Java";
        char[] strChars = str.toCharArray();
        int length = strChars.length;

        System.out.println("길이: " + length);
    }

    // for-Each문 활용한 풀이
    public void solution1(){
        String str1 = "Hello Java";
        int count = 0;

        for (@SuppressWarnings("unused") char c : str1.toCharArray()) {
            count++;
        }

        System.out.println("길이: " + count);
    }
}