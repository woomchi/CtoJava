package 프로그래머스lv0;
// package 코딩테스트lv0;
// import java.util.*;

// class Solution {
//     // 나의 문제 풀이
//     // 1.불필요한 변수
//     // 2.중첩 반복문
//     // 3.간결하지 않은 로직
//     public String solution(String[] id_pw, String[][] db) {
//         String id = id_pw[0];
//         String pw = id_pw[1];
//         boolean isIdCorrect = false;
//         boolean isPwCorrect = false;

//         for(int i=0;i<db.length;i++){
//             if(id.equals(db[i][0])){
//                 isIdCorrect = true;
//                 if(pw.equals(db[i][1])){
//                     isPwCorrect = true;
//                 }
//                 break;
//             }
//         }
//         if(isIdCorrect==isPwCorrect){
//             if(isIdCorrect == true) return "login";
//         }else{
//             if(isIdCorrect == true){
//                 return "wrong pw";
//             }
//         }
//         return "fail";
//     }

//     //나의 리펙터링1
//     //불필요한 변수 제거 및 로직 간소화
//     class Solution1 {
//         public String solution(String[] id_pw, String[][] db) {
//             String id = id_pw[0];
//             String pw = id_pw[1];
            
//             for(int i=0;i<db.length;i++){
//                 if(id.equals(db[i][0])){
//                     if(pw.equals(db[i][1])){
//                         return "login";
//                     }
//                     return "wrong pw";
//                 }
//             }
//             return "fail";
//         }
//     }

//     // 나의 리펙터링2
//     //import java.util.*;

//     class Solution2 {
//         // Map 컬렉션을 활용해 id를 키로 갖고 이에 대응하는 pw를 찾도록함
//         // 주어진 id와 pw의 일치 여부를 get을 통해 id에 대한 pw를 반환받아 확인할 수 있음
//         public String solution(String[] id_pw, String[][] db) {
//             Map<String,String> dbMap = new HashMap<>();
//             for(String[] data: db){
//                 dbMap.put(data[0], data[1]);
//             }
//             if(!dbMap.containsKey(id_pw[0])){
//                 return "fail";
//             }
//             return dbMap.get(id_pw[0]).equals(id_pw[1]) ? "login" : "wrong pw";
//         }
//     }

//     // Gemini 개선 풀이
//     class SolutionGemini {
//     public String solution(String[] id_pw, String[][] db) {
//         String id = id_pw[0];
//         String pw = id_pw[1];

//         for (String[] user : db) {
//             if (id.equals(user[0])) {
//                 // 아이디가 일치하는 경우, 비밀번호까지 확인하고 즉시 결과 반환
//                 if (pw.equals(user[1])) {
//                     return "login";
//                 } else {
//                     return "wrong pw";
//                 }
//             }
//         }
        
//         // 반복문을 다 돌았는데도 id가 일치하는 유저가 없으면 "fail"
//         return "fail";
//     }
// }
// }