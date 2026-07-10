import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

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

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}