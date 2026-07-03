import java.io.*;
import java.util.StringTokenizer;

class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String [] input;
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
		    input = br.readLine().split(" ");
		    int N = Integer.parseInt(input[0]);
		    int K = Integer.parseInt(input[1]);
		    
		    int [] numbers = new int[N];
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int i = 0 ; i < N ; i++){
		        numbers[i] = Integer.parseInt(st.nextToken());
		    }
		    
		    // 가깝다는 기준 : K와의 차 최소값
		    // 전수검사로 가능 조합 생성
		    // 출력 값 자체는 중복 여부 상관없이 곱의 값 반환
		    // 종료 기준
		    // 1. 곱이 일치하는 값이 있을 경우(조기종료 조건)
		    // 2. 곱이 일치하지 않는 경우
		    
		    int sub = 1000 * 1000;
		    int closeNum = 0;
		    for(int i = 0 ; i < N ; i++){
		        for(int j = 0 ; j < N ; j++){
		            if (i == j) continue;
		            int num = numbers[i] * numbers[j];
		            if(num == K){
                        closeNum = num;
		                i = N;
		            }else{
		                if(Math.abs(K - num) < sub){
    		                sub = Math.abs(K - num);
    		                closeNum = num;
    		            }else if(Math.abs(K - num) == sub){
    		                if(num > closeNum){
    		                    closeNum = num;
    		                }
    		            }
		            }
		        }
		    }
			/////////////////////////////////////////////////////////////////////////////////////////////
            Answer = closeNum;

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}