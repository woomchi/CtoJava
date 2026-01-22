package 백준;
import java.io.*;

class 별찍기7{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<num;i++){
            for(int j=0;j<num-i;j++){
                sb.append(" ");
            }
            for(int j=0;j<i*2-1;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=num;i>=1;i--){
            for(int j=num-i;j>=1;j--){
                sb.append(" ");
            }
            for(int j=i*2-1;j>=1;j--){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}