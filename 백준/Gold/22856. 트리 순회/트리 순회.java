import java.io.*;
import java.util.*;

public class Main {
    static int N, moveCnt, lastNode, visitedCnt;
    static Node[] tree;
    static boolean[] visited;
    static List<Integer> similarInOrderStatus, inOrderStatus;
    static class Node {
        int left;
        int right;

        Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());

        tree = new Node[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[num] = new Node(left, right);
        }

        inOrderStatus = new ArrayList<>();
        inOrder(1);

        lastNode = inOrderStatus.get(N - 1);

        similarInOrderStatus = new ArrayList<>();
        visited = new boolean[N + 1];
        visited[0] = true;

        similarInOrder(1);
    }

    static void similarInOrder(int cur){
        similarInOrderStatus.add(cur);

        if(!visited[cur]){
            visited[cur] = true;
            visitedCnt++;
        }

        Node curNode = tree[cur];
        int left = curNode.left;
        int right = curNode.right;

        if(left != -1){
            similarInOrder(curNode.left);
            similarInOrderStatus.add(cur);
        }

        if(right != -1){
            similarInOrder(curNode.right);
            similarInOrderStatus.add(cur);
        }

        if(visitedCnt == N && cur == lastNode){
            System.out.println(similarInOrderStatus.size() -1);

        }
    }

    static void inOrder(int cur){
        Node curNode = tree[cur];
        int left = curNode.left;
        int right = curNode.right;

        if(left != -1){
            inOrder(left);
        }

        inOrderStatus.add(cur);

        if(right != -1){
            inOrder(right);
        }
    }
}
