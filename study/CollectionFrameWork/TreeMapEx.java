package study.CollectionFrameWork;
import java.util.*;

class TreeMapEx{
    public static void main(String[] args) {
        String [] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for(int i=0;i<data.length;i++){
            if(map.containsKey(data[i])){
                Integer value = (Integer)map.get(data[i]);
                map.put(data[i], Integer.valueOf(value.intValue() +1));
            }else{
                map.put(data[i], Integer.valueOf(1));
            }
        }
        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
        System.out.println("= 기본정렬 =");
        while(it.hasNext()){
            Map.Entry<String,Integer> entry = (Map.Entry<String,Integer>)it.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() + " : "+ printBar('#', value)+ " "+value);
        }
        System.out.println();

        // map을 ArrayList로 변환한 다음에 Collections.sort()로 정렬
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(set);

        Collections.sort(list, new ValueComparator());

        it = list.iterator();

        System.out.println("= 값의 크기가 큰 순서로 정렬 =");
        while(it.hasNext()){
            Map.Entry<String,Integer> entry = (Map.Entry<String,Integer>)it.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey()+" : "+printBar('#', value)+" "+value);
        }
    }
    
    static class ValueComparator implements Comparator<Map.Entry<String,Integer>>{
        public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
            if(o1 instanceof Map.Entry && o2 instanceof Map.Entry){
                Map.Entry<String,Integer> e1 = (Map.Entry<String,Integer>)o1;
                Map.Entry<String,Integer> e2 = (Map.Entry<String,Integer>)o2;
                
                int v1 = ((Integer)e1.getValue()).intValue();
                int v2 = ((Integer)e2.getValue()).intValue();

                return v2 - v1;
            }
            return -1;
        }
    }

    static String printBar(char ch, int value){
        char [] bar = new char[value];
        for(int i=0; i < bar.length;i++)    bar[i] = ch;
        return new String(bar);
    }
}