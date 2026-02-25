package 백준;
import java.io.*;
import java.util.*;

class Main{
    static int N, k;
    static int count = 0;
    static int num = 0;
    static int [] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        int [] arr = new int[N];
        tmp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, N-1);
        if(count < k){
            System.out.println(-1);
        }else{
            System.out.println(num);
        }
        br.close();
    }

    public static void merge_sort(int [] A, int st, int ed) {
        if (st < ed) {
            int q = (st + ed) / 2;
            merge_sort(A, st, q);
            merge_sort(A, q + 1, ed);
            merge(A, st, q, ed);
        }
    }

    public static void merge(int [] A, int st, int q, int ed) {
        int i = st;
        int j = q+1;
        int t = 0;
        while (i <= q && j <= ed) {
            if (A[i] <= A[j]){
                tmp[t++] = A[i++];
            }else{
                tmp[t++] = A[j++];
            }
        }
        while (i <= q){
            tmp[t++] = A[i++];
        }
        while (j <= ed){
            tmp[t++] = A[j++];
        }

        i = st;
        t = 0;
        while (i <= ed){
            A[i] = tmp[t++];
            count++;

            if(count == k){
                num = A[i];
            }
            i++;
        }
    }
}