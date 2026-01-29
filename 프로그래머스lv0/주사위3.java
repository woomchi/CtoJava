package 프로그래머스lv0;
import java.util.*;

class 주사위3 {
    //내가 풀이한 방법 - 직관적
    public int solution(int a, int b, int c, int d) {
        int [][] arrays = new int[4][2];
        arrays[0][0] = a;   // 
        arrays[1][0] = b;   // 2
        arrays[2][0] = c;   // 2
        arrays[3][0] = d;   // 2

        for(int i=0;i<arrays.length;i++){
            int count = 0;
            for(int j=0;j<arrays.length;j++){
                if(arrays[i][0] == arrays[j][0]){
                    count++;
                }
            }
            arrays[i][1] = count;
        }

        int minCount = Math.min(arrays[0][1], Math.min(arrays[1][1], Math.min(arrays[2][1],arrays[3][1])));
        int maxCount = Math.max(arrays[0][1], Math.max(arrays[1][1], Math.max(arrays[2][1],arrays[3][1])));

        int p = 0;
        int q = 0;
        if(maxCount == 4){
            return 1111*arrays[0][0];
        }else if(maxCount == 3){
            for(int i=0;i<arrays.length;i++){
                if(arrays[i][1] == 3){
                    p = arrays[i][0];
                }
                if(arrays[i][1] == 1){
                    q = arrays[i][0];
                }
            }
            return (int)Math.pow(10*p+q, 2);
        }else if(maxCount == 2){
            if(minCount == 1){
                for(int i=0;i<arrays.length;i++){
                    for(int j=0;j<2;j++){
                        if(arrays[i][1] == minCount){
                            if(arrays[i][0] != p && arrays[i][1] == minCount && p!=0){
                                q = arrays[i][0];
                            }else{
                                p = arrays[i][0];
                            }
                        }
                    }
                }
                return p*q;
            }else{
                for(int i=0;i<arrays.length;i++){
                    p = arrays[0][0];
                    if(p != arrays[i][0]){
                        q = arrays[i][0];
                    }

                }
                return (p+q)*Math.abs(p-q);
            }
        }else{
            return Math.min(arrays[0][0], Math.min(arrays[1][0], Math.min(arrays[2][0],arrays[3][0])));
        }
    }    

    //Gemini의 개선
    // 정렬 == 생각 정리 용도: 주사위를 오름차순으로 정렬함으로써 aaaa,aabb,aaab,aabc,abcd로 나타나도록해 경우를 줄임
    // 비교적 for문과 if문을 줄여 가독성과 정확성 높임
    public int solution1(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
        Arrays.sort(dice);

        if (dice[0] == dice[3]) { // 4개 동일
            return 1111 * dice[0];
        } else if (dice[0] == dice[2] || dice[1] == dice[3]) { // 3개 동일
            int p = dice[1]; // 정렬 시 무조건 포함되는 숫자
            int q = (dice[0] == dice[2]) ? dice[3] : dice[0];
            return (int) Math.pow(10 * p + q, 2);
        } else if (dice[0] == dice[1] && dice[2] == dice[3]) { // 2개씩 두 쌍
            return (dice[0] + dice[2]) * Math.abs(dice[0] - dice[2]);
        } else if (dice[0] == dice[1] || dice[1] == dice[2] || dice[2] == dice[3]) { // 한 쌍만 동일
            if (dice[0] == dice[1]) return dice[2] * dice[3];
            if (dice[1] == dice[2]) return dice[0] * dice[3];
            return dice[0] * dice[1];
        } else { // 모두 다름
            return dice[0];
        }
    }
}
