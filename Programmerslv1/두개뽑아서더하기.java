package Programmerslv1;
import java.util.*;

public class 두개뽑아서더하기 {
    /* 핵심 로직 : TreeSet */

    // 나의 풀이
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] arr = new int[set.size()];
        // int index = 0;
        // Iterator it = set.iterator();
        // while(it.hasNext()){
        //     arr[index++] = (int)it.next();
        // }
        Arrays.sort(arr);
        return arr;
    }


    // Gemini 피드백
    public int[] solutionGemini(int[] numbers) {
        int len = numbers.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] arr = new int[set.size()];
        int index = 0;
        // Iterator<Integer> it = set.iterator();
        // while(it.hasNext()){
        //     arr[index++] = it.next();
        // }
        for(int num: set){
            arr[index++] = num;
        }
        Arrays.sort(arr);
        return arr;
    }

    // Gemini 개선 풀이
    public int[] solutionGemini1(int[] numbers) {
        // TreeSet은 입력 시 자동 정렬됨
        Set<Integer> set = new TreeSet<>();

        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // Set을 int 배열로 변환
        int[] arr = new int[set.size()];
        int index = 0;
        for(int num : set) {
            arr[index++] = num;
        }
        
        // 이미 정렬되어 있으므로 Arrays.sort 필요 없음
        return arr;
    }
}
