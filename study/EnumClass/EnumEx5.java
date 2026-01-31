package study.EnumClass;

public class EnumEx5 {
    public enum Dial {
    ABC(3, "ABC"),
    DEF(4, "DEF"),
    GHI(5, "GHI"),
    JKL(6, "JKL"),
    MNO(7, "MNO"),
    PQRS(8, "PQRS"),
    TUV(9, "TUV"),
    WXYZ(10, "WXYZ");

    private final int seconds;
    private final String mapping;

    Dial(int seconds, String mapping) {
        this.seconds = seconds;
        this.mapping = mapping;
    }

    // 문자가 주어졌을 때 시간을 반환하는 메서드
    // values 메서드는 컴파일러가 enum의 리터럴 인스턴스를 생성하면 자동으로 생성하는 리터럴 배열이다.
    // 다만, 이를 직접적으로 사용한다면 외부에서 배열을 조작할 수 있기 때문에 정적 멤버로 선언하여 사용하는 것이 좋다.
    public static int getSeconds(char c) {
        for (Dial d : Dial.values()) {
            if (d.mapping.indexOf(c) != -1) {
                return d.seconds;
            }
        }
        return 0; // 예외 처리
    }
}
}
