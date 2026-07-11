/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

/*

N개의 자연수가 저장된 배열 A[1],A[2],...,A[N]이 주어진다. 이 배열을 서로 겹치지 않는 연속된 부분들로 나누려고 한다.
부분의 개수는 몇 개이든 상관 없다. 각 부분의 특성값은 해당 부분의 최댓값과 최솟값의 차이이다.
모든 부분의 특성값의 합이 최대가 되도록 배열을 적절히 나누고 그 합을 출력하는 프로그램을 작성하라. 

예를 들어 설명하면 다음과 같다. N=4이고 배열 A는 {6,5,3,4}라고 하자.
배열을 두 부분 {6,5,3}과 {4}로 나누면 두 부분의 특성값은 각각 3과 0이 된다. 이 경우가 특성값의 합이 최대가 되는 경우이다.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class 최대최소 {
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

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			Implement your algorithm here.
			The answer to the case will be stored in variable Answer.
			*/
			/////////////////////////////////////////////////////////////////////////////////////////////
			
			// 원소
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 증가 상태일 때 i+1번째 원소가 i번째 원소보다 작으면
			// 감소 상태일 때 i+1번째 원소가 i번째 원소보다 크면
			List<List<Long>> bucket = new ArrayList<>();
			long sum = 0;

			if(N == 1){
				sum = 0;
			}else if(N == 2){				
				sum += Math.abs(Long.parseLong(st.nextToken())-Long.parseLong(st.nextToken()));
			}else{
				int index = -1;
				boolean isChanged = false;
				boolean isIncrement = false;
				long element = -1;
				for(int i = 0 ; i < N ; i++){
					if(bucket.size() == 0 ){
						index += 1;
						bucket.add(new ArrayList<>());
						long element1 = Long.parseLong(st.nextToken());
						long element2 = Long.parseLong(st.nextToken());
						bucket.get(index).add(element1);
						bucket.get(index).add(element2);
						if(element1 < element2){
							isIncrement = true;
						}
						i += 1;
					}else if(isChanged){
						isChanged = false;
						index += 1;
						bucket.add(new ArrayList<>());
						bucket.get(index).add(element);
						if(i >= N)	break;
						long elementTemp = Long.parseLong(st.nextToken());
						bucket.get(index).add(elementTemp);
						if(element < elementTemp){
							isIncrement = true;
						}
					}else{
						element = Long.parseLong(st.nextToken());
						if(isIncrement){
							if(bucket.get(index).get(bucket.get(index).size()-1) > element){
								// 증가 -> 감소 전환
								isChanged = true;
							}else{
								bucket.get(index).add(element);
							}
						}else{
							if(bucket.get(index).get(bucket.get(index).size()-1) < element){
								// 감소 -> 증가 전환
								isChanged = true;
							}else{
								bucket.get(index).add(element);
							}
						}
					}
				}
				for(int i = 0 ; i <= index ; i++){	// index == 버켓 수
					sum += (Collections.max(bucket.get(i)) - Collections.min(bucket.get(i)));
				}			
			}
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(sum);
		}
	}
}