package 프로그래머스lv1;

public class 소수찾기 {
    /* 핵심 로직 : 1~N 제곱근까지의 소수의 배수를 지움 */

    public static void main(String[] args) {
        int N = 100000;
        solution1(N);   // 1부터 N까지 모두 연산
        solution2(N);   // 1부터 N제곱근까지 연산
        solution3(N);   // 에라토스테네스의 체
    }
    // 나의 풀이(다른 사람 로직 참고해서 완전하게 푼 것은 아님)
    // **소수는 2~ N의 제곱근까지 나누게 되면 N의 약수가 포함되므로**
    // 시간복잡도가 낮아 소수를 판별하기 용이함
    public static int solution1(int n) {
        // int answer = n+1;
        // long start = System.currentTimeMillis();
        // for(int i = 1 ; i <= n ; i ++){
        //     if(i<=1 || i%2 == 0){
        //         answer--;
        //         continue;
        //     }
        //     for(int m = 3 ; m <= Math.sqrt(i); m += 2){
        //         if(i%m == 0){
        //             m = i+1;
        //             answer--;
        //         }
        //     }
        // }
        // long end = System.currentTimeMillis();
        // System.out.println(end-start);
        // return answer;
        int count = 0;
        long start = System.currentTimeMillis();
        for(int i = 1; i <= n; i++){        // 첫 번째 반복문
            for(int j = 2; j <= i ; j++){   // 두 번째 반복문
                if(i%j == 0){
                    if(i == j){
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("solution1(N) | count : "+count+" | time "+(end-start));
        return count;
    }

    public static int solution2(int n) {
        int count = 0;
        long start = System.currentTimeMillis();
        for (int i = 2; i <= n; i++) {          // 1은 소수가 아니므로 2부터 시작
            boolean isPrime = true; 
            for (int j = 2; j * j <= i; j++) {  // j의 제곱 <= i 는 제곱근의 효과와 동일함
                if (i % j == 0) {
                    isPrime = false;
                    break; 
                }
            }

            if (isPrime == true) {
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("solution2(N) | count : "+count+" | time "+(end-start));
        return count;
    }

    // Gemini 개선 풀이
    public static int solution3(int n) {
        int answer = 0;
        
        // 1. 소수 여부를 저장할 배열 생성 (기본값 false)
        // 인덱스 자체를 숫자로 쓰기 위해 n+1 크기 할당
        boolean[] isPrime = new boolean[n + 1];
        
        // 2. 초기화: 2부터 n까지 모두 소수(true)라고 가정
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // 3. 에라토스테네스의 체 로직 수행
        // i의 배수들을 지워나감 (제곱근까지만 반복하면 됨)
        long start = System.currentTimeMillis();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) { // i가 소수라면
                // i의 배수들은 소수가 아님 (j는 i*i부터 시작해도 됨)
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        long end = System.currentTimeMillis();
        // 4. 소수 개수 세기
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                answer++;
            }
        }
        System.out.println("solution3(N) | count : "+answer+" | time "+(end-start));
        return answer;
    }
}
