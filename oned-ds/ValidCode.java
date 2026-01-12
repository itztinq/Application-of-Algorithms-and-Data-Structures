import java.util.*;

public class ValidCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>() {
            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public String peek() {
                return "";
            }

            @Override
            public void clear() {

            }

            @Override
            public void push(String x) {

            }

            @Override
            public String pop() {
                return "";
            }
        };
        while(true) {
            String line = sc.nextLine();
            if(line.equals("x")) break;
            if(!line.startsWith("end")) {
                stack.push(line);
            } else {
                if(stack.isEmpty() || !stack.peek().equals(line.substring(3))) {
                    System.out.println("invalid");
                    return;
                }
                stack.pop();
            }
        }
        System.out.println(stack.isEmpty() ? "Valid" : "Invalid");
    }
}
