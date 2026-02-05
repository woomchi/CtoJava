package 프로그래머스lv1;
import java.util.ArrayList;
import java.util.List;

public class 햄버거만들기 {
    // 나의 풀이
    // ArrayList를 활용한 다른 사람의 코드 참고함
    // remove 연산과 ArrayList를 사용했기 때문에 박싱 연산이 생김 => 효율이 낮아짐
    public int solution(int[] ingredient) {   
        List<Integer> regex = new ArrayList<>(4);
        List<Integer> list = new ArrayList<>(ingredient.length);
        regex.add(1); regex.add(2); regex.add(3); regex.add(1);
        for(int i : ingredient) list.add(i);

        int answer = 0;
        int i = 0;
        int len = list.size() - 3;
        while(i < len){
            if(list.get(i) == regex.get(0)  &&  list.get(i+1) == regex.get(1) &&
               list.get(i+2) == regex.get(2)   &&  list.get(i+3) == regex.get(3)){
                for(int j = 0 ; j < regex.size() ; j++) list.remove(i);
                len -= 4;
                if(i-4 >= -1){
                    i -= 4;
                }else{
                    i = -1;
                }
                answer++;
            }
            i++;
        }

        return answer;
    }

    // 처음 내 풀이와 매우 유사한 다른 사람의 풀이
    public int solutionOther(int[] ingredient) {
        int answer = 0;

        StringBuilder pack = new StringBuilder();
        for (int i : ingredient) pack.append(i);

        int index = pack.indexOf("1231");

        while (index != -1) {
            pack = pack.delete(index, index + 4);
            answer ++;
            index = pack.indexOf("1231");
        }
        return answer;
    }

    // Gemini 개선 풀이
    public int solutionGemini(int[] ingredient) {
        int answer = 0;
        // 1. ArrayList 대신 고정 배열(스택) 사용 -> 메모리/속도 최적화
        int[] stack = new int[ingredient.length];
        int sp = 0; // 스택 포인터 (현재 쌓인 높이)

        for (int i : ingredient) {
            stack[sp++] = i; // push

            // 2. 백트래킹이 필요 없음 (쌓을 때마다 끝만 확인하면 됨)
            if (sp >= 4 && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1) {
                
                sp -= 4; // pop (실제 데이터 삭제 없이 포인터만 이동 -> 초고속)
                answer++;
            }
        }
        return answer;
    }
}
