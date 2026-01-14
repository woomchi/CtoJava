// package study.Generics;
// import java.util.ArrayList;

// interface Eatable { }
// class Fruit implements Eatable{
//     public String toString() { return "Fruit"; }
// }
// class Apple extends Fruit   { public String toString(){ return "Apple"; } }
// class Grape extends Fruit   { public String toString(){ return "Grape"; }}
// class Toy                   { public String toString(){ return "Toy";}}


// class Box<T>{
//     ArrayList<T> list = new ArrayList<T>();
//     void add(T item){ list.add(item); }    //메서드 타입 매개변수
//     T get(int i)    { return list.get(i); }
//     int size()      { return list.size(); }
//     public String toString() { return list.toString(); } 
// }
// class FruitBox<T extends Fruit & Eatable> extends Box<T>{ }

// public class FruitBoxEx implements Eatable{
//     public static void main(String[] args) {
//         FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
//         FruitBox<Apple> appleBox = new FruitBox<Apple>();
//         FruitBox<Grape> grapeBox = new FruitBox<Grape>();

//         fruitBox.add(new Fruit());
//         fruitBox.add(new Apple());
//         fruitBox.add(new Grape());
//         // fruitBox.add(new Toy());  // 상속 관계가 아니므로 에러
//         appleBox.add(new Apple());
//         grapeBox.add(new Grape());

//         System.out.println("fruitBox-"+fruitBox);
//         System.out.println("appleBox-"+appleBox);
//         System.out.println("grapeBox-"+grapeBox);

//     }
// }
