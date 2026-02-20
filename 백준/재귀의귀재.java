package 백준;
import java.io.*;

class 재귀의귀재{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            sb.append(isPalindrome(str)).append(" ");
            sb.append(countCompare(str)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    
    public static int recursion(String s, int st, int ed){
        if(st >= ed){
            return 1;
        }else if(s.charAt(st) != s.charAt(ed)){
            return 0;
        }else{
            return recursion(s, st+1, ed-1);
        }
    }
    
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    
    public static int countCompare(String s){
        int st = 0;
        int ed = s.length()-1;
        int count = 0;
        while(true){
            count++;
            if(s.charAt(st) != s.charAt(ed) || st >= ed)    break;
            st++;   ed--;
        }
        return count;
    }

    // Gemini 개선 풀이
    private static int count;

	public static void solutionGemini(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			count = 0;
			String word = br.readLine();
			bw.write(isPalindrome1(word) + " " + count + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static int isPalindrome1(String s) {
		return recursion(s.toCharArray(), 0, s.length() - 1);
	}

	static int recursion(char[] s, int left, int right) {
		count++;
		if (left >= right) {
			return 1;
		} else if (s[left] != s[right]) {
			return 0;
		} else {
			return recursion(s, left + 1, right - 1);
		}
	}

    // Gemini 개선 풀이 - 배열 참조 활용
    public static void solutionGemini1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            
            // 크기가 1인 배열을 만들어 카운터로 사용 (참조값 전달)
            int[] count = new int[1]; 
            int result = isPalindrome(str, count); 
            
            sb.append(result).append(" ").append(count[0]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    
    // 배열 count를 파라미터로 계속 넘겨주며 값을 누적
    public static int recursion(String s, int st, int ed, int[] count){
        count[0]++; // 참조된 배열의 값을 직접 증가시킴

        if(st >= ed){
            return 1;
        }else if(s.charAt(st) != s.charAt(ed)){
            return 0;
        }else{
            return recursion(s, st+1, ed-1, count);
        }
    }
    
    public static int isPalindrome(String s, int[] count){
        return recursion(s, 0, s.length()-1, count);
    }

    // Gemini 개선 풀이 - 배열 참조 활용을 전역 변수처럼
    public static void solutionGemini2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        // 1. 반복문 밖에서 단 한 번만 배열 생성 (메모리 할당 최소화)
        int[] count = new int[1]; 
        
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            
            // 2. 매 반복마다 카운트 값만 0으로 초기화하여 재사용
            count[0] = 0; 
            
            // 3. 팰린드롬 검사와 카운팅을 동시에 수행 (중복 연산 제거)
            int result = isPalindrome1(str, count); 
            sb.append(result).append(" ").append(count[0]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    public static int recursion1(String s, int st, int ed, int[] count){
        count[0]++; // 배열의 첫 번째 원소 값 증가

        if(st >= ed){
            return 1;
        }else if(s.charAt(st) != s.charAt(ed)){
            return 0;
        }else{
            return recursion1(s, st+1, ed-1, count);
        }
    }
    
    public static int isPalindrome1(String s, int[] count){
        return recursion1(s, 0, s.length()-1, count);
    }
}