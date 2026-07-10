/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			int N = Integer.parseInt(br.readLine());
			int [] ware = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++){
				ware[i] = Integer.parseInt(st.nextToken());
			}

			// Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			
			// 최소 위험도 : 세 창고 중 두 바깥 두 창고와의 거리가 가장 짧은 곳
			int minDanger = Integer.MAX_VALUE;
			for(int i = 0 ; i < N-2 ; i++){
				minDanger = Math.min(minDanger, (ware[i+2]-ware[i])/2);
			}

			// 최대 위험도 : 각 창고 중 가장 높은 위험도
			int maxDanger = Integer.MIN_VALUE;
			// 양 끝 창고 위험도 비교
			maxDanger = Math.max(ware[2]-ware[0], ware[N-1]-ware[N-3]);
			for(int i = 1 ; i < N-3 ; i++){
				maxDanger = Math.max(maxDanger, ware[i+1]-ware[i]);
			}

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(maxDanger+" "+minDanger);
		}
	}
}