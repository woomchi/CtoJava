// package 프로그래머스lv0;
// import java.util.Arrays;

// class Solution {
//     // 나의 풀이
//     // 매번 배열을 생성하기 때문에 메모리 측면에서 부담이 감
//     public int[] solution(int[] arr, int[] query) {
//     int[] answer = Arrays.copyOf(arr, arr.length);   
//         for(int i=0;i<query.length;i++){
//             if(i%2==0){
//                 answer = Arrays.copyOfRange(answer, 0, query[i]+1);
//             }else{
//                 answer = Arrays.copyOfRange(answer,query[i], answer.length);
//             }
//         }
//         return answer;
//     }

//     //Gemini 개선 풀이
//     // 매번 배열을 생성하는 것이 아니라 시작점과 끝점만 계산해놓고 
//     // 이를 토대로 단 한 번 배열을 생성하면 성능 개선할 수 있다.
//     // 최소 4배에서 최대 30배까지 성능 개선할 수 있다.
//     class SolutionGemini {
//         public int[] solution(int[] arr, int[] query) {
//             int start = 0;
//             int end = arr.length;
//             for(int i=0;i<query.length;i++){
//                 if(i%2==0){
//                     end = start + query[i];
//                 }else{
//                     start = start + query[i];
//                 }
//             }
//             int[] answer = Arrays.copyOfRange(arr, start, end+1);   
//             return answer;
//         }
//     }
// }