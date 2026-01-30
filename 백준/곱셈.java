package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셈 {
    // 나의 풀이
    // 사람의 사고 방식인 '세로 셈법'을 로직으로 구현함
    // 다만, 컴퓨터 관점에서 굳이 세로 셈법을 사용할 필요없이
    // 두 번째 숫자를 쪼개서 각각 곱하고 각 결과에 1, 10, 100 을 곱하면 최적화된 상태로 풀이할 수 있음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        for(int i = 2 ; i >= 0 ; i--){
            arr1[i] = num1%10;
            num1 /= 10;            
            arr2[i] = num2%10;
            num2 /= 10;
        }
        
        int len = arr1.length;
        int sum = 0;
        int indexSum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = len-1 ; i >= 0 ; i--){
            int num = 0;
            int indexNum = 0;
            for(int j = len-1 ; j >= 0 ; j--){
                int nMod = (arr2[i] * arr1[j])%10;
                int nQuotient = (arr2[i] * arr1[j])/10;
                num += nMod * Math.pow(10,indexNum) + nQuotient * Math.pow(10, indexNum+1);
                indexNum++;
            }
            sum += num * Math.pow(10, indexSum);
            sb.append(num).append("\n");
            indexSum++;
        }
        sb.append(sum).append("\n");
        System.out.print(sb.toString());
        br.close();
    }

    // Gemini 개선풀이
    // 세로 셈법을 단순히 수학적으로 쪼개어 각 결과를 출력하고
    // 번거로운 과정없이 기본 사칙 연산을 통해 간단히 결과를 출력함
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 1. (3)번 위치: A * (B의 1의 자리)
        sb.append(A * (B % 10)).append('\n');

        // 2. (4)번 위치: A * (B의 10의 자리)
        // (B % 100) / 10 을 하면 10의 자리를 구할 수 있습니다.
        // 혹은 (B / 10) % 10 도 가능합니다.
        sb.append(A * ((B % 100) / 10)).append('\n');

        // 3. (5)번 위치: A * (B의 100의 자리)
        sb.append(A * (B / 100)).append('\n');

        // 4. (6)번 위치: A * B (최종 결과)
        sb.append(A * B).append('\n');

        System.out.print(sb);
        br.close();
    }
}
