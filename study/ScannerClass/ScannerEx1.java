package study.ScannerClass;
import java.util.*;

public class ScannerEx1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String [] argArr = null;

        while(true){
            String prompt = ">>";
            System.out.println(prompt);

            String input = s.nextLine();    // 화면 입력을 라인 단위로 받음
            input = input.trim();
            argArr = input.split(" +");

            String command = argArr[0].trim();
            if("".equals(command)) continue;

            command = command.toLowerCase();
            if(command.equals("q")){
                s.close();
                System.exit(0);
            }else{
                for(int i=0;i<argArr.length;i++){
                    System.out.println(argArr[i]);
                }
            }
        }
    }
}
