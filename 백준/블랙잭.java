package 백준;
import java.io.*;
import java.util.*;

class 블랙잭{
    // 나의 풀이
    // 시간 복잡도가 N^3인 것을 고려해 요소를 정리하여 합이 M을 넘으면 연산을 하지 않도록함
    // 다만, 크기가 정해져있으므로 박싱이 필요한 list 대신 그냥 배열이 조금 더 효율적임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>(N+1);
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        
        int approx = 0;
        int sum = 0;
        for(int i = 0 ; i < list.size()-2; i++){
            for(int j = i+1 ; j < list.size()-1 ; j++){
                for(int k = j+1; k < list.size() ; k++){
                    sum = list.get(i) + list.get(j) + list.get(k);
                    if(sum > M){
                        break;
                    }
                    approx = Math.max(approx, sum);
                }
            }
        }
        System.out.println(approx);
        br.close();
    }

    // Gemini 개선풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 개선 1: ArrayList 대신 기본 배열(Primitive Array) 사용
        int[] cards = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬 (배열 정렬)
        Arrays.sort(cards);
        
        int maxSum = 0; // 변수명 변경 (approx -> maxSum)
        
        // 3중 반복문 (브루트 포스)
        for(int i = 0 ; i < N - 2; i++){
            for(int j = i + 1 ; j < N - 1 ; j++){
                for(int k = j + 1; k < N ; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    
                    // 정렬이 되어 있으므로 M을 넘으면 더 이상 k를 증가시킬 필요 없음 (가지치기)
                    if(sum > M){
                        break; 
                    }
                    
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        
        System.out.println(maxSum);
        br.close();
    }
}