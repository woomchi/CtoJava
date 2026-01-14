package study.CollectionFrameWork;
import java.util.*;

class HashMapEx4{
    public static void main(String[] args) {
        String [] data = {"A", "K", "A", "k", "D", "K", "A", "K", "K", "K", "Z", "D"};

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<data.length;i++){
            if(map.containsKey(data[i])){
                Integer value = (Integer)map.get(data[i]);
                map.put(data[i], Integer.valueOf(value.intValue() +1));
            }else{
                map.put(data[i], Integer.valueOf(1));
            }
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : "+ printBar('#', entry.getValue())+ " "+entry.getValue());
        }
        
        // 향상된 반복문 + 제네릭스를 통해 Iterator 없이 간단히 출력할 수 있다.
        // Iterator it = map.entrySet().iterator();
        // while(it.hasNext()){
        //     Map.Entry entry = (Map.Entry)it.next();
        //     int value = ((Integer)entry.getValue()).intValue();
        //     System.out.println(entry.getKey() + " : "+ printBar('#', value)+ " "+value);
        // }
    }
    
    static String printBar(char ch, int value){
        char [] bar = new char[value];
        for(int i=0; i < bar.length;i++)    bar[i] = ch;
        return new String(bar);
    }
}