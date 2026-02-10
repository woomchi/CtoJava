package Programmerslv1;
import java.util.*;
import java.util.stream.Collectors;

class 포켓몬{
    /* 핵심 로직 : HashSet + max 활용 */

// 나의 풀이
    // contains와 add 모두 boolean 타입이기 때문에 코드가 겹침 => 그냥 add만 하면 알아서 걸러줌
    // 왜? => HashSet은 중복을 허용하지 않기 때문이다.
    // 마지막 조건문도 min을 활용하거나 return 탈출문 형식을 통해 간결하게 짤 수 있음
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }
        }

        if(set.size() <= nums.length/2){
            return set.size();
        }else{
            return nums.length/2;
        }
    }

    // Gemini 개선 풀이
    public int solutionGemini(int[] nums) {
        // 1. 중복 제거를 위한 HashSet 생성
        HashSet<Integer> set = new HashSet<>();

        // 2. 중복 체크 없이 바로 삽입 (코드가 훨씬 간결해지고 빠름)
        for (int num : nums) set.add(num);

        // 3. 가져갈 수 있는 최대 개수(N/2)와 유니크한 폰켓몬 수 중 작은 값 반환
        return Math.min(set.size(), nums.length / 2);
    }

    //Gemini 개선 풀이2
    public int solutionGemini1(int[] nums) {
        // boxed()로 int를 Integer로 변환 -> collect로 Set 변환 -> size 측정
        int uniqueCount = Arrays.stream(nums)
                                .boxed()
                                .collect(Collectors.toSet())
                                .size();

        return Math.min(uniqueCount, nums.length / 2);
    }
}
