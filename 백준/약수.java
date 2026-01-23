package 백준;

import java.io.*;
import java.util.StringTokenizer;


class Main{
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

    //Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken());
        
        int count = 0;
        boolean found = false; // 약수를 찾았는지 확인하는 플래그 변수

        // for문으로 변경하여 가독성 향상
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
                if (count == index) {
                    System.out.println(i); // println 사용
                    found = true;
                    break; // 답을 찾았으니 반복문 탈출
                }
            }
        }

        // 반복문이 끝날 때까지 index번째 약수를 못 찾았다면 0 출력
        if (!found) {
            System.out.println(0);
        }
    }
}
