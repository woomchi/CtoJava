package 자바의정석;
import java.io.*;
import java.util.*;

public class PropertiesEx3 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        prop.setProperty("timeout", "30");
        prop.setProperty("language", "한글");
        prop.setProperty("size", "10");
        prop.setProperty("capacity", "10");

        try{
            prop.store(new FileOutputStream("ouput.txt"), "Properties Example");
            prop.storeToXML(new FileOutputStream("ouput.txt"), "Properties Example");            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
