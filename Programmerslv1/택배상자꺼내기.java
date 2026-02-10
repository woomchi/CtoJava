package Programmerslv1;

public class 택배상자꺼내기 {
    public int solution(int n, int w, int num) {
        int row = n/w;  int col = w;
        if(n%w != 0){
            row += 1;
        }

        // 지정된 상자 위치
        int x = 0;
        int y = 0;

        int [][] boxes = new int[row][col];
        int index = 1;
        int j = 0;
        for(int i = 0 ; i < row ; i++){
            if(j <= 0){
                j = 0;
                while(j < col){
                    if(index > n)   break;
                    if(index == num){
                        x = j;  y = i;
                    }
                    boxes[i][j] = index++;
                    j++;
                }
            }else if(j >= col){
                j = col-1;
                while(j >= 0){
                    if(index > n)   break;
                    if(index == num){
                        x = j;  y = i;
                    }
                    boxes[i][j] = index++;
                    j--;
                }
            }
        }

        int answer = 0;
        for(int i = y ; i < row ; i++){
            if(boxes[i][x] != 0)    answer++;
        }

        return answer;
    }
}
