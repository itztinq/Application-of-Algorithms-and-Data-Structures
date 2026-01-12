import java.util.*;

public class TextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if(parts[0].equals("TYPE")) {
                sb.append(parts[1]);
            }
            else if(parts[0].equals("UNDO")) {
                if(sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else if(parts[0].equals("SHOW")) {
                System.out.println(sb.toString());
            }
        }
    }
}
