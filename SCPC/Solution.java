/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;


/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		// Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 1;             // 첫 날 : 1번
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
                물을 먹는 시점 : 아침
                물이 배달되는 시점 : 저녁
                배달 시점에만 계산하는 건? 타임 스킵
                생수를 사러 가는 시점 : 아침에 물이 0개 일때
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
            
            //M번째 날이 될 때까지 생수가 남는다면
            //안 남는다면
            Answer += N;
            if(N < M){
                break;
            }else if(N == M){
                Answer += 1;
            }else{
                Answer += N/M;
                Answer += N%M;
            }

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}