class Solution {
    // 풀지 못해서 Geimini 코드 분석
    // 1. 배열 크기가 1000인 이유: 배열값에 해당하는 인덱스위치에 count함으로써 루프 한 번에 계산이 단순하게 진행되어 빠름
    // 2. 내가 풀지 못한 코드에서는 같은 값이고 같은 count인 인덱스가 여러개라 계산 과정에서 복잡하고 반례를 찾기 힘듬
    // 3. 배열값에 해당하는 인덱스에 count하여 maxCount가 0이 아니라는 것만 확인하여 중복 여부를 판별함
    // => 중요 포인트: 문제에서 주어진 값 범위만큼 배열을 생성하고 해당값을 인덱스로 활용해 빠른 처리가 가능함
    public int solution(int[] array) {
        // 1. 빈도수를 기록할 배열 (숫자 범위가 0~999라고 가정)
        int[] counts = new int[1000];
        
        // 2. 모든 숫자의 빈도수 계산
        for (int num : array) {
            counts[num]++; // 여기서 숫자가 나올 때마다 카운트를 올립니다.
        }

        int maxCount = 0;   // 가장 많이 나온 횟수
        int answer = -1;    // 최빈값 숫자
        boolean isDuplicate = false; // 최빈값이 여러 개인지 확인

        // 3. counts 배열을 돌면서 최빈값 찾기
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                answer = i;         // 현재 숫자가 최빈값
                isDuplicate = false; // 새로운 최댓값이니 중복 아님
            } else if (counts[i] == maxCount && maxCount != 0) {
                isDuplicate = true;  // 최댓값과 같은 횟수가 또 발견됨
            }
        }

        if (isDuplicate) return -1;
        return answer;
    }
}