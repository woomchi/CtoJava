package study.ObjectMethod; 

class Card1 {
    String kind;
    int number;

    Card1() {
        this("SPADE", 1);
    }

    Card1(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override // 오버라이딩을 명시적으로 표시 (추천)
    public String toString() {
        return "kind: " + kind + ", number: " + number;
    }
}

public class CardToString2 {
    public static void main(String[] args) {
        Card1 c1 = new Card1();
        Card1 c2 = new Card1("Heart", 10);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}