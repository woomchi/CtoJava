package 코딩테스트lv0;
public record 코드처리하기() {
    // 나의 문제 풀이
    public String solution(String code) {
        if(!(resultRet(code).equals(""))) return resultRet(code);
        return "EMPTY";
    }

    private String resultRet(String code){
        String ret = "";
        int mode = 0;
        for(int i=0;i<code.length();i++){
            if(mode == 0){
                if(!(code.substring(i,i+1).equals("1")) && i%2 == 0){
                    ret += code.substring(i,i+1);
                }else if(code.substring(i,i+1).equals("1")){
                    mode = 1;
                }
            }else if(mode == 1){
                if(!(code.substring(i,i+1).equals("1")) && i%2 == 1){
                    ret += code.substring(i,i+1);
                }else if(code.substring(i,i+1).equals("1")){
                    mode = 0;
                }
            }
        }
        return ret;
    }

    // 나의 문제 풀이 개선
    public String solution1(String code) {
        if(!(resultRet1(code).equals(""))) return resultRet1(code);
        return "EMPTY";
    }

    private String resultRet1(String code){
        String ret = "";
        int mode = 0;
        for(int i=0;i<code.length();i++){
            if(mode == 0){
                if(!(code.charAt(i) == '1') && i%2 == mode){
                    ret += code.charAt(i);
                }else if(code.charAt(i) == '1'){
                    mode = 1;
                }
            }else if(mode == 1){
                if(!(code.charAt(i) == '1') && i%2 == mode){
                    ret += code.charAt(i);
                }else if(code.charAt(i) == '1'){
                    mode = 0;
                }
            }
        }   
        return ret;
    }

    // Gemini의 개선
    public String solution2(String code) {
    StringBuilder sb = new StringBuilder();
    int mode = 0;

    for (int i = 0; i < code.length(); i++) {
        char current = code.charAt(i);

        // 1을 만나면 모드 체인지 (0 -> 1, 1 -> 0)
        if (current == '1') {
            mode = 1 - mode; 
            continue;
        }

        // 모드와 인덱스의 짝/홀수 여부가 일치할 때만 추가
        // mode 0일 때 i % 2 == 0, mode 1일 때 i % 2 == 1
        if (i % 2 == mode) {
            sb.append(current);
        }
    }

    // 결과가 비어있으면 "EMPTY", 아니면 결과값 반환
    return sb.length() == 0 ? "EMPTY" : sb.toString();
}
}
