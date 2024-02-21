import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.BitSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // BitSet의 크기는 주어진 범위의 2배가 되어야 하며, 음수를 포함할 수 있도록 오프셋을 적용
        BitSet bitSet = new BitSet(2000001);
        int offset = 1000000; // 음수를 인덱스로 변환하기 위한 오프셋

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine()) + offset;
            bitSet.set(number);
        }

        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i)) {
                bw.write((i - offset) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
