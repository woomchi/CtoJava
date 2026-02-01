package 백준;
import java.io.*;

class 크로아티아{
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
        String str = br.readLine();
        
        int count = 0 ;
        for(String s: croatia){
            while((str.indexOf(s)) != -1){
                str = str.replaceFirst(s, " ");
                count ++;
            }
        }
        str = str.replaceAll(" ", "");
        count += str.length();
        System.out.println(count);
    }

    // 다른 사람의 개선된 풀이
    public static void solutionOthers(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
        String str = br.readLine();
        
        for(String s: croatia){
            str = str.replaceAll(s, "*");
        }
        System.out.println(str.length());
    }
}