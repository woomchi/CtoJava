package study.CollectionFrameWork;
import java.util.*;

public class HashSetBingo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        int [][] board = new int[5][5];

        Iterator<String> it = set.iterator();
        while(it.hasNext() || set.size()<25){
            set.add((int)(Math.random()*50)+1+"");
        }
        
        it = set.iterator();

        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j] = Integer.parseInt((String)it.next());
                System.out.print((board[i][j] < 10 ? "  " : " ")+ board[i][j]);
            }
            System.out.println();
        }
    }
    
}
