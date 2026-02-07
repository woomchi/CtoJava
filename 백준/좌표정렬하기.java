package 백준;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 좌표정렬하기 {
    // 나의 풀이
    // Collection 사용으로 인한 박싱 비용 증가
    // 뺄셈 비교자 로직은 int 범위를 벗어나는 경우가 발생할 수 있음
    // 일반적인 comparing 메서드는 값의 크기를 비교하는 compareTo 메서드를 사용함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        List<int[]> list = new ArrayList<>(N);
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] pos = new int[2];
            pos[0] = Integer.parseInt(st.nextToken());
            pos[1] = Integer.parseInt(st.nextToken());
            list.add(pos);
        }
        
        Collections.sort(list, Comparator.comparing((int [] o) -> o[0])
                                         .thenComparing((o1, o2) -> o1[1] - o2[1]));
        
        for(int i = 0 ; i < N ; i++){
            int [] pos = list.get(i);
            bw.write(pos[0] + " " + pos[1]);
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    // 다른 사람의 풀이
    // 배열이 아닌 클래스 단위로 데이터를 관리함(유지 보수 Good)
    // 다만, 동일하게 뺄셈 로직을 사용함
    private static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solutionOther(String[] args) throws IOException {
        int n;
        Coordinate[] coords;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        coords = new Coordinate[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coords[i]= new Coordinate(x, y);
        }

        Arrays.sort(coords, (c1, c2) -> {
            if(c1.x != c2.x) return c1.x - c2.x;
            else return c1.y - c2.y;
        });
        for(Coordinate coord: coords)
            sb.append(coord.x).append(' ').append(coord.y).append('\n');
        System.out.print(sb.toString());
        br.close();
    }

    // 다른 사람 풀이 피드백 적용 버전1
    public static void solutionOtherFeedBack(String[] args) throws IOException {
        int n;
        Coordinate[] coords;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        coords = new Coordinate[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coords[i]= new Coordinate(x, y);
        }

        Arrays.sort(coords, Comparator.comparingInt((Coordinate c) -> c.x)
                                      .thenComparingInt((c) -> c.y));
        for(Coordinate coord: coords)
            sb.append(coord.x).append(' ').append(coord.y).append('\n');
        System.out.print(sb.toString());
        br.close();
    }

    // 다른 사람 풀이 피드백 적용 버전2 - Integer.compare 활용
    public static void solutionOtherFeedBack2(String[] args) throws IOException {
        int n;
        Coordinate[] coords;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        coords = new Coordinate[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coords[i]= new Coordinate(x, y);
        }

        Arrays.sort(coords, (c1, c2) -> {
            if(c1.x != c2.x){
                return Integer.compare(c1.x, c2.x);
            }
            return Integer.compare(c1.y, c2.y);
        });
        for(Coordinate coord: coords)
            sb.append(coord.x).append(' ').append(coord.y).append('\n');
        System.out.print(sb.toString());
        br.close();
    }

    //Gemini 개선 풀이
    // 배열로 primitive 타입 데이터를 다룸으로써 연산 비용 줄임
    // 뺄셈 로직이 아니라 값의 비교를 하는 default 비교자를 사용하기 때문에 오버플로우 방지함
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        // 메모리 효율을 위해 ArrayList 대신 2차원 배열 사용
        int[][] arr = new int[N][2];
        
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // comparingInt를 사용하여 박싱 오버헤드 제거 및 가독성 확보
        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0])
                                   .thenComparingInt(o -> o[1]));
        
        for(int i = 0 ; i < N ; i++){
            bw.write(arr[i][0] + " " + arr[i][1]);
            bw.newLine();
        }
        
        bw.flush();
        bw.close(); // br.close()는 알고리즘 풀이에서 생략해도 무방합니다.
    }
}
