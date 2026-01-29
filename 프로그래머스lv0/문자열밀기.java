package 프로그래머스lv0;
class 문자열밀기 {
    //  내가 푼 방식 - C언어 스타일
    public int shiftStr(String A, String B) {
        int answer = 0; //미는 횟수
        int len = A.length();
        char [] tmp = A.toCharArray();

        while(len > answer){
            if(!A.equals(B)){
                char p = tmp[len-1];
                for(int i=len-1;i>0;i--){
                    tmp[i] = tmp[i-1]; 
                }
                tmp[0] = p;
                System.out.println(tmp);
                String str = new String(tmp);
                A = str;
                answer++;
            }else{
                return answer;
            }
        }
        return -1;
    }
    

    // 자바 객체 지향적으로 개선한 방식
    public int shiftStr1(String A, String B) {
        // 한 줄만을 조건문으로 작성할 때 간결함을 위해 블록을 생략할 수 있음
        // 단, 두 줄 이상부터는 논리적 버그 발생 우려 및 유지 보수 측면에서 문제가 발생할 수 있음
        if (A.equals(B)) return 0;

        int len = A.length();
        // A가 아닌 임시변수 temp를 사용하는 것은 보통 자바에서 매개변수는 읽기 전용(Read Only)으로 사용함으로써 
        // 실수 방지와 값의 변화를 확인하기 위해 이러한 방식을 사용함
        String temp = A;

        for (int i = 1; i < len; i++) {
            // 마지막 글자 + 그 전까지의 문자열
            temp = temp.substring(len - 1) + temp.substring(0, len - 1);
            //  substring을 통해 기존에 C언어에서 char를 일일이 다루는 방법을 개선함

            if (temp.equals(B)) {
                return i;
            }
        }
        return -1;
    }

    // 가장 자바스럽고 효율적인 방식
    public int shiftStr2(String A, String B) {
        // B를 2번 반복시키도록 append해 찾고자 하는 A가 시작되는 위치를 찾도록 함
        // String 메서드 concat, + 사용
        return (B + B).indexOf(A);
    }
        //경우에 따라 StringBuilder의 append(), insert(), delete() 등을 사용할 수 있음
}