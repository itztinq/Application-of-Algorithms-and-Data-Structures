import java.util.*;

public class WowPodnizi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        int totalW = 0;

        for(char c : line.toCharArray()) {
            if(c == 'w') totalW++;
        }

        int beforeW = 0;
        int res = 0;

        for(char c : line.toCharArray()) {
            if(c == 'w') beforeW++;
            else if(c == 'o') {
                res += beforeW * (totalW - beforeW);
            }
        }

        System.out.println(res);
    }
}
