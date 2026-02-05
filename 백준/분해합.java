package 백준;
import java.io.*;

class 분해합{
    // 나의 풀이
    // 가독성 측면에서 변수명 선언 고려하기
    // 완전 탐색 방식이라 이보다 큰 값을 다룬다면 처리 시간이 많이 걸림
    // 주어진 값 : N => N - (자릿수 * 9) : 주어진 자릿수의 값이 1~9를 전부다 다룰 때 얻을 수 있는 최소값
    // 각 자리수에는 1~9가 들어갈 수 있는데 이때 0이 포함되지 않는 이유는 주어진값의 최소 연산시작값을 구하기 위해서는 가장 큰 값을 빼야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long M = 0;    long m = M;
        while(M < N){
            M++;    m = M;
            long sum = m;
            while(m > 0){
                sum += m%10;
                m /= 10;
            }
            if(sum == N)    break;
        }
        if(N == M){
            System.out.println(0);
        }else{
            System.out.println(M);
        }
        
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 문자열을 받아 자릿수를 계산하기 위해 String으로 먼저 받음
        String strN = br.readLine();
        int N = Integer.parseInt(strN);
        int len = strN.length(); // 자릿수 (예: 216 -> 3)

        int result = 0;

        // 최적화: 탐색 시작 범위를 (N - 9 * 자릿수)로 설정
        // 단, 계산 결과가 음수면 0부터 시작
        int start = N - (len * 9);
        if (start < 0) start = 0;

        for (int i = start; i < N; i++) {
            int sum = i; // 분해합 저장 변수
            int temp = i; // 자릿수 계산용 임시 변수

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            // 생성자를 찾으면 저장하고 반복 종료 (가장 작은 생성자를 찾아야 하므로)
            if (sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
        br.close();
    }
}