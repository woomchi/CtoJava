package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약수 {
    // 나의 풀이
    // 문자열" "을 결합하면 재할당이 일어나기 때문에 이럴 때는 println으로 처리하기 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken());
        
        // 약수 구하기
        int count = 0;
        int div=1;
        while(div<=num){
            if(num%div == 0){
                count++;
                if(index == count){
                    System.out.print(div+"\n");
                    break;
                }
            }
            div++;
        }
        if(count < index){
            System.out.print("0\n");
        }
    }
}
