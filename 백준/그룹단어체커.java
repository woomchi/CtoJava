package 백준;
import java.io.*;
import java.util.*;

class 그룹단어체커{
    // 나의 풀이
    // 코드가 복잡하고 contains메서드로 인한 시간 복잡도가 N^2*length가 됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0 ;
        
        for(int i = 0 ; i < N ; i++){
            List<Character> list = new ArrayList<>();
            String str = br.readLine();
            for(int j = 0 ; j < str.length(); j++){
                if(!list.contains(str.charAt(j))){
                    list.add(str.charAt(j));
                }
            }
            int index = 0;
            for(int j = 0 ; j < list.size() ; j++){
                while(index < str.length()){
                    if(list.get(j) != str.charAt(index))    break;
                    if(list.get(j) == str.charAt(index))    index++;
                }
            }
            if(index == str.length())    count++;
        }
        System.out.println(count);
    }

    // Gemini 개선풀이
    // 26개의 알파벳 boolean으로 방문 여부를 확인하여 적은 메모리 용량으로 빠른 순회를 통해 처리할 수 있음
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (checkGroupWord(str)) { // 함수로 분리하여 가독성 향상
                count++;
            }
        }
        
        System.out.println(count);
    }

    // 그룹 단어인지 체크하는 함수
    public static boolean checkGroupWord(String str) {
        boolean[] visited = new boolean[26]; // 알파벳 방문 여부 체크 (소문자 a-z)
        int prev = -1; // 이전 문자 저장

        for (int j = 0; j < str.length(); j++) {
            int current = str.charAt(j); // 현재 문자

            // 이전 문자와 다를 때 (연속된 문자가 끝났을 때)
            if (prev != current) {
                // 이미 방문한 적이 있는 문자라면 그룹 단어가 아님
                if (visited[current - 'a']) {
                    return false;
                }
                // 방문 처리
                visited[current - 'a'] = true;
                prev = current;
            }
            // 이전 문자와 같다면(연속 중이라면) 그냥 통과
        }
        return true;
    }
}