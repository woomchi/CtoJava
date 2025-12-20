import java.util.Arrays;
import java.util.Comparator;
public class 특이한정렬 {
    public int[] solution(int[] numlist, int n) {
        int [] distances = new int[numlist.length];
        int [] sortedlist = new int[numlist.length];
        for(int i=0;i<numlist.length;i++){
            sortedlist[i] = numlist[i];
            distances[i] = sortedlist[i] - n;
        }
        
        for(int k=0;k<numlist.length;k++){
            for(int i=0;i<numlist.length-1;i++){
                if(Math.abs(distances[i]) > Math.abs(distances[i+1]) 
                   || (Math.abs(distances[i]) == Math.abs(distances[i+1]) && sortedlist[i] < sortedlist[i+1]) ){
                    sorting(distances, i);
                    sorting(sortedlist, i);
                }
            }   
        }
        return sortedlist;
    }
    public void sorting(int [] list, int index){
        int temp = list[index];
        list[index] = list[index+1];
        list[index+1] = temp;
    }

    // Gemini의 개선
    // 아직 stream에 대해 배운적이 없어 이해가 어려움
    public int[] solution1(int[] numlist, int n) {
        return Arrays.stream(numlist)
            .boxed() // int를 Integer 객체로 변환 (정렬 기준 설정을 위해)
            .sorted((a, b) -> {
                int distA = Math.abs(a - n);
                int distB = Math.abs(b - n);
                    
                // 1. 거리가 같다면 숫자가 큰 순서대로 (내림차순)
                if (distA == distB) {
                    return b - a; 
                }
                // 2. 거리가 다르다면 가까운 순서대로 (오름차순)
                return distA - distB;
            })
            .mapToInt(Integer::intValue) // 다시 int 배열로 변환
            .toArray();
    }
}
