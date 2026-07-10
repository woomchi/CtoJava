import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

/* 문제

처음에 N병의 생수가 집에 있다. 매일 아침에 생수 한 병을 마신다. 매 M번째 날 저녁에 생수 한 병이 배달된다.
즉, M번째 날, 2M번째 날, …의 저녁에 생수가 배달된다. 언젠가는 집에 생수가 없어 아침에 사러 나가야 하는 날이 올 것이다.
몇 번째 날에 처음으로 생수를 사러 나가는지 계산하라. 첫 날의 번호는 1번이다.

예를 들어 설명하면 다음과 같다. N=10, M=4라고 하자. 4일째, 8일째, 12일째 날의 저녁에 생수가 배달된다.
즉, 13일째 아침에 일어나면 마지막 생수 한 병이 남아있다. 따라서, 14일째 아침에 생수를 사러 나가야 한다.

입력 제한
입력 파일에는 여러 테스트 케이스가 포함될 수 있다.
파일의 첫째 줄에 테스트 케이스의 개수를 나타내는 정수 T가 주어지고,
이후 차례로 T 개의 테스트 케이스가 주어진다. (1≤T≤50)
각 테스트 케이스의 첫 줄에 N과 M의 값이 주어진다.(1≤N≤1,000,000,000,000, 2≤M≤1,000,000,000,000).

*/

class 생수 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 1;             // 첫 날 : 1번
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());
			
            /*  첫 번째 풀이(시간 초과) 
            while(true){
                N -= 1;             // 아침에 물 한 병 소모
                if(Answer%M == 0){  // 저녁에 물 한 병 보급
                    N += 1;
                }
                Answer += 1;
                if(N == 0){
                    break;
                }
            }

            */

            // 최종 제출
            //추가 보급에 따른 보급 횟수 증가(기존 정해진 보급에서 더 보급받을 기회를 얻음)
			// 이전 보급수와 업데이트된 보급수가 더해진 N을 M으로 나눈 것이 같으면 더 이상 추가 보급 없음
			// N보다 M이 크면 어짜피 무조건 보급 못 받음
            if(N < M){
				Answer += N;
			}else{
				long add = N/M;
				while(true){
					if((N+add)/M == add) break; // 더이상 추가 보급 없음
					add = (N+add)/M;
				}
				Answer += N + add;
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}