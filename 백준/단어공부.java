package 백준;
import java.io.*;
import java.util.*;

class 단어공부{
    // 나의 풀이
    // a~z까지 범위가 정해져 있으므로 HashMap보다는 배열이 효율적임(오토박싱 측면에서도)
    // 어차피 str의 char를 key로 확인하여 넣기 때문에 a~z만큼 반복할 이유가 없음
    // 최댓값이 중복되는지 확인하고 이를 처음부터 다시 순회해서 찾음
    // => 매우 비효율적인 코드
    // 따라서, a~z의 개수를 카운팅할 배열을 만들고(어차피 범위가 정해져있으므로)
    // 카운팅한 결과의 최댓값을 찾음
    // 만약 최댓값이 겹치면 ?를 반환하고 아니면 최댓값의 문자를 대문자로 변환하여 반환하면 됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = (br.readLine()).toLowerCase();
        
        // HashMap에 a~z까지 저장하고 str번 반복해서 개수를 증가시키기
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < str.length(); i++){
            for(char c = 'a' ; c <= 'z' ; c++){
                if(str.charAt(i) == c){
                    if(map.containsKey(c)){
                        int temp = map.get(c) + 1;
                        map.replace(c,temp);
                    }else{
                        map.put(c, 1);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        int maxValue = Collections.max(list);
        int isDuplicate = 0;
        for(int i : list){
            if(i == maxValue)    isDuplicate++;
        }
        
        if(isDuplicate <= 1){
            for(int i = 0 ; i < str.length(); i++){
                char c = str.charAt(i);
                if(map.get(c) == maxValue){
                    System.out.println((String.valueOf(c)).toUpperCase());
                    break;
                }
            }
        }else{
            System.out.println("?");
        }
        
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase(); // 미리 대문자로 변환 (출력 시 편리함)
        
        // 1. 알파벳 개수를 저장할 배열 (A-Z: 26개)
        int[] count = new int[26];

        // 2. 문자열을 한 번만 순회하며 카운팅 (시간 복잡도: O(N))
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 'A'의 아스키코드는 65. c - 'A'를 하면 0~25 사이의 인덱스가 나옴
            count[c - 'A']++;
        }

        // 3. 최빈값 찾기 (시간 복잡도: O(26) -> 상수 시간)
        int max = -1;
        char answer = '?';

        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = (char) (i + 'A'); // 인덱스를 다시 문자로 변환
            } else if (count[i] == max) {
                answer = '?'; // 최빈값이 중복되면 ? 로 설정
            }
        }

        System.out.println(answer);
        br.close();
    }
}