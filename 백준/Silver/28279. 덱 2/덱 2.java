import java.io.*;
import java.util.*;

public class Main {
    static int N, command, X;
    static Deque<Integer> deque;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());

            command = Integer.parseInt(st.nextToken());
            if(st.hasMoreTokens()){
                X = Integer.parseInt(st.nextToken());
            }

            switch(command){
                case 1:
                    deque.offerFirst(X);
                    break;
                case 2:
                    deque.offerLast(X);
                    break;
                case 3:
                    if(!deque.isEmpty()){
                        sb.append(deque.pollFirst()).append("\n");
                    } else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case 4:
                    if(!deque.isEmpty()){
                        sb.append(deque.pollLast()).append("\n");
                    } else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if(!deque.isEmpty()){
                        sb.append(0).append("\n");
                    } else{
                        sb.append(1).append("\n");
                    }
                    break;
                case 7:
                    if(!deque.isEmpty()){
                        sb.append(deque.peekFirst()).append("\n");
                    } else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case 8:
                    if(!deque.isEmpty()){
                        sb.append(deque.peekLast()).append("\n");
                    } else{
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
