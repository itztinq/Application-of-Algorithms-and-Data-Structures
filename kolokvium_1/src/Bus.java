import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka

        int minVal = 100 * (N + Math.max(0,  M - N));
        int maxVal = 100 * (N + (M == 0 ? 0 : M - 1));

        System.out.println(minVal);
        System.out.println(maxVal);
    }

}