package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영수증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalPrice = Integer.parseInt(br.readLine());
        int kind = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int totalSum = 0;
        for (int i = 0; i < kind; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            totalSum += price * num;
        }
        if (totalPrice == totalSum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
