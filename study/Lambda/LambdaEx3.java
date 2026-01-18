package study.Lambda;
@FunctionalInterface
interface MyFunction{
    void myMethod();
}
class Outer{
    int value = 10;
    class Inner{
        int value = 20;
        void method(int i){
            int value = 30;
            MyFunction f = () -> {
                System.out.println("               i : "+i);
                System.out.println("           value : "+value);
                System.out.println("      this.value : "+this.value);
                System.out.println("Outer.this.value : "+Outer.this.value);
            };
            f.myMethod();
        }
    }
}
public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }
}
