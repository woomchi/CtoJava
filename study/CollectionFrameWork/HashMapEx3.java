package study.CollectionFrameWork;
import java.util.*;

public class HashMapEx3 {
    static HashMap<String,HashMap<String,String>> phoneBook = new HashMap<String,HashMap<String,String>>();
    public static void main(String[] args) {
        addPhoneNo("친구", "이자바", "010-111-1111");
        addPhoneNo("친구", "김자바", "010-222-2222");
        addPhoneNo("친구", "김자바", "010-333-3333");
        addPhoneNo("회사", "김대리", "010-444-4444");
        addPhoneNo("회사", "김대리", "010-555-5555");
        addPhoneNo("회사", "박대리", "010-666-6666");
        addPhoneNo("회사", "이과장", "010-777-7777");
        addPhoneNo("세탁", "010-888-8888");

        printlist();
    }

    static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);
        HashMap<String,String> group = (HashMap<String,String>)phoneBook.get(groupName);
        group.put(tel,name);
    }

    static void addGroup(String groupName){
        if(!phoneBook.containsKey(groupName)){
            phoneBook.put(groupName,(new HashMap<String,String>()));
        }
    }
    
    static void addPhoneNo(String name, String tel) {
        addPhoneNo("기타", name, tel);
    }

    static void printlist() {
        Set<Map.Entry<String,HashMap<String,String>>> set = phoneBook.entrySet();
        Iterator<Map.Entry<String,HashMap<String,String>>> it = set.iterator();

        while(it.hasNext()){
            Map.Entry<String,HashMap<String,String>> e = (Map.Entry<String,HashMap<String,String>>)it.next();

            Set<Map.Entry<String,String>> subSet = ((HashMap<String,String>)e.getValue()).entrySet();
            Iterator<Map.Entry<String,String>> subIt = subSet.iterator();
            System.out.println(" * "+e.getKey()+"["+subSet.size()+"]");

            while(subIt.hasNext()){
                Map.Entry<String,String> subE = (Map.Entry<String,String>)subIt.next();
                String telNo = (String)subE.getKey();
                String name = (String)subE.getValue();
                System.out.println(name+" "+telNo);
            }
            System.out.println();
        }
    }
}
