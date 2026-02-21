package 백준;
import java.io.*;

class 칸토어집합{
    static char [] sequence;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            int num = Integer.parseInt(str);
            int len = (int)Math.pow(3,num);
            sequence = new char[len];
            for(int i = 0 ; i < len ; i++){
                sequence[i] = '-';
            }

            cantorSet(sequence, 0, len);
            System.out.println(sequence);
        }
    }
    
    public static void cantorSet(char [] seq, int p1 , int p2){
        if(p2 - p1 > 1){
            int len = (p2-p1)/3;
            for(int i = p1 + len ; i < p1 + len*2 ; i++){
                seq[i] = ' ';
            }
            cantorSet(seq, p1, p1+len);
            cantorSet(seq, p1+len*2, p2);
        }
    }

    // Gemini 개선 풀이 - 리펙터링
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            int num = Integer.parseInt(str);
            int len = (int)Math.pow(3, num);
            char[] sequence = new char[len];

            // for문 대신 내장 함수 사용
            java.util.Arrays.fill(sequence, '-');

            cantorSet1(sequence, 0, len);
            System.out.println(sequence);
        }
    }
    
    public static void cantorSet1(char [] seq, int p1 , int p2){
        if(p2 - p1 > 1){
            int len = (p2-p1)/3;
            for(int i = p1 + len ; i < p1 + len*2 ; i++){
                seq[i] = ' ';
            }
            cantorSet1(seq, p1, p1+len);
            cantorSet1(seq, p1+len*2, p2);
        }
    }
}