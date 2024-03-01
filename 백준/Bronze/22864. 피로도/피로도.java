import java.util.*;

/*
 * 1. 하루는 24시간이다
 * 2. 한시간 단위로 일을 하거나, 일을 쉰다
 *    2.1 일을 하면 시간 당 피로도는 A만큼 쌓이고, 일은 B만큼 처리
 *    2.2 쉰다면 피로도는 C만큼 줄어듬
 * 3. 최대 피로도(M)을 넘지 않고 할 수 있는 처리량을 구한다
 */

public class Main {
    static final int DAY = 24;
    static int fatigue; // 피로도
    static int work;
    static int A, B, C, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();

        for (int hour = 0; hour < DAY; hour++) {
            if (fatigue > M) {  // 피로도가 M을 넘어 번아웃이 왔다면
                break;
            }

            if (fatigue + A <= M) {     // M을 넘지 않는다면 일한다
                work += B;
                fatigue += A;
            } else if (fatigue + A > M) { // M을 넘을 것 같다면 쉰다
                fatigue -= C;
                if (fatigue < 0) {  // 피로도가 음수로 내려가면 0으로 바뀜
                    fatigue = 0;
                }
            }
        }


        System.out.println(work);
    }
}
