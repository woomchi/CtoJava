package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 나머지 {
    // 나의 풀이
    // Set을 활용한 것은 좋지만, TreeSet은 불필요한 정렬 연산이 수행되므로 HashSet이 더 적합함
    public static void main(String[] args) throws IOException {
        final int INPUT_NUM = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0 ; i < INPUT_NUM ; i++){
            int num = Integer.parseInt(br.readLine());
            set.add(num%42);
        }
        System.out.println(set.size());
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        final int INPUT_NUM = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 정렬이 필요 없으므로 HashSet이 더 효율적입니다.
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < INPUT_NUM; i++) {
            // 변수 선언 없이 바로 넣어도 됩니다.
            set.add(Integer.parseInt(br.readLine()) % 42);
        }
        
        System.out.println(set.size());
        br.close(); // 습관적으로 닫아주는 것이 좋습니다 (혹은 try-with-resources)
    }

    // 다른 사람의 풀이
    // map의 키가 중복되면 기존 값을 다른 값으로 대체한다는 성질을 이용함
    // 즉, 나머지 값인 키는 동일한 1이라는 의미없는 수를 덮어씌움으로써 중복을 제거함
    public static void solutionOther(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st;
            for (int i = 0; i < 10; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                map.put(num % 42, 1);
            }

            System.out.println(map.size());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
