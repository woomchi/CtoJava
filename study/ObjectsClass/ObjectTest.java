package study.ObjectsClass;
import java.util.*;

public class ObjectTest {
    public static void main(String[] args) {
        String [][] str2d = new String [][]{{"aaa","bbb"},{"AAA","BBB"}};
        String [][] str2d2 = new String [][] {{"aaa","bbb"},{"AAA","BBB"}};

        System.out.print("str2d =" +"{");
        for(String [] tmp : str2d){
            System.out.print(Arrays.toString(tmp));
        }
        System.out.println("}");

        System.out.print("str2d =" +"{");
        for(String [] tmp : str2d2){
            System.out.print(Arrays.toString(tmp));
        }
        System.out.println("}");
        
        System.out.println("equals(str2d, str2d2= "+Objects.equals(str2d, str2d2));
        System.out.println("deepEquals(str2d, str2d2)= "+Objects.deepEquals(str2d, str2d2));
        System.out.println("isNull(null)= "+Objects.isNull(null));
        System.out.println("nonNull(null)= "+Objects.nonNull(null));
        System.out.println("hashCode(null)= "+Objects.hashCode(null));
        System.out.println("toString(null)= "+Objects.toString(null));
        System.out.println("toString(null, \"\")= "+Objects.toString(null, ""));

        Comparator<String> c = String.CASE_INSENSITIVE_ORDER;

        System.out.println("comapre(\"aa\",\"bb\")= "+Objects.compare("aa", "bb", c));
        System.out.println("comapre(\"bb\",\"aa\")= "+Objects.compare("bb", "aa", c));
        System.out.println("comapre(\"ab\",\"AB\")= "+Objects.compare("ab", "AB", c));
    }
}
